package edu.cmu.cs.webapp.hw4.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;


import edu.cmu.cs.webapp.hw4.databean.DocumentPeopleBean;
import edu.cmu.cs.webapp.hw4.databean.SessionBean;

public class ChangeAccessAction extends Action {

    @Override
    public String getName() {
        return "changeAccess.do";
    }

    @Override
    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<>();
        HttpSession session = request.getSession();
        SessionBean sessionBean = (SessionBean) request.getSession().getAttribute("session");
        request.setAttribute("curTab", "document");
        if (sessionBean == null) {
            errors.add("Session expired. Please log in.");
            return "login.jsp";
        }
        
        JSONObject object = new JSONObject();
        List<DocumentPeopleBean> memberList = (List<DocumentPeopleBean>) session.getAttribute("documentPeople");
        
        try {
            //email, targetEmail, circleId, service, documentName, documentUrl
            object.put("email", sessionBean.getEmail());
            System.out.println("Email in session is:" + sessionBean.getEmail());
            object.put("circleId", sessionBean.getCircleId());
            object.put("service", "1");
            object.put("documentName", session.getAttribute("documentName"));
            object.put("documentUrl", "www.s1.com");
            //object.put("documentUrl", session.getAttribute("documentUrl"));
            for (DocumentPeopleBean member : memberList) {
                object.put("targetEmail", member.getEmail());
                if (request.getParameter("accessLevel"+member.getEmail()).equals("Share and Delete")) {
                    object.put("accessLevel", "true");
                } else if (request.getParameter("accessLevel"+member.getEmail()).equals("View and Download")) {
                    object.put("accessLevel", "false");
                } else {
                    continue;
                }
                
                String query = "http://localhost:8080/CurantisBackendService/curantis/sharedocument";
                URL url = new URL(query);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(5000);
                conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setRequestMethod("POST");
                OutputStream os = conn.getOutputStream();
                os.write(object.toString().getBytes("UTF-8"));
                os.close();
                
                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
                }
                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                String output;
                JSONObject response = new JSONObject(); 
                
                while ((output = br.readLine()) != null) { 
                    try {
                        response = new JSONObject(output);
                        boolean success = response.getBoolean("success");
                        String message = response.getString("message");
                        System.out.println("Received response: "+response);
                        if (!success) {
                            errors.add(message);
                            return "error.jsp";
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                conn.disconnect();
            }
            return "seniorHousingDoc.do";
            
        } catch(JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return null;
    }

}
