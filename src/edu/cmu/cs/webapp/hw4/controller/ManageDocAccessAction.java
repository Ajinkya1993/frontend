package edu.cmu.cs.webapp.hw4.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.cmu.cs.webapp.hw4.databean.DocumentPeopleBean;
import edu.cmu.cs.webapp.hw4.databean.SessionBean;

public class ManageDocAccessAction extends Action{

    @Override
    public String getName() {
        return "manageDocAccess.do";
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
        JSONObject responseObj = new JSONObject();
        
        try {
            object.put("circleId", sessionBean.getCircleId());
            object.put("email", sessionBean.getEmail());
            object.put("service", "1");
            object.put("documentName", session.getAttribute("documentName"));
            
            
            String query = "http://localhost:8080/CurantisBackendService/curantis/listpeople";
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
            System.out.println("Output from Server care team .... \n");
            
            while ((output = br.readLine()) != null) {
                try {
                     responseObj = new JSONObject(output);
                     boolean success = responseObj.getBoolean("success");
                     String message = responseObj.getString("message");
                     System.out.println("Received response: "+responseObj);
                     if (!success) {
                         errors.add(message);
                         return "error.jsp";
                     } 
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            
            System.out.println("No error.");
            JSONArray docPeople = responseObj.getJSONArray("people");
            HashMap<String, Boolean> accessMap = new HashMap<String, Boolean>();
            for (int i = 0; i < docPeople.length(); i++) {
                JSONObject obj = docPeople.getJSONObject(i);
                accessMap.put(obj.getString("email"), obj.getBoolean("accessLevel"));
            }
            //Get members of this circle;
            List<DocumentPeopleBean> memberList = getCircleMembers(sessionBean.getCircleId(), accessMap);
            request.setAttribute("documentPeople", memberList);
            request.setAttribute("docUrl", "docUrl");
            request.setAttribute("documentName", session.getAttribute("documentName"));
            //request.setAttribute("documentName", "doc1");
            session.setAttribute("documentPeople", memberList);
            
            conn.disconnect();
                
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ManageDocAccess.jsp";
       
    }
    
    private List<DocumentPeopleBean> getCircleMembers(long circleId, HashMap<String, Boolean> accessMap) {
        List<DocumentPeopleBean> peopleBeans = new ArrayList<>();
        JSONObject object = new JSONObject();
        try {
            object.put("circleId", circleId);
            
            String query = "http://localhost:8080/CurantisBackendService/curantis/getusersofacircle";
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
                        System.out.println(message);
                        return peopleBeans;
                    } else {
                        JSONArray list = response.getJSONArray("list");
                        for (int i = 0; i < list.length(); i++) {
                            JSONObject member = list.getJSONObject(i);
                            String email = member.getString("email");
                            DocumentPeopleBean people = new DocumentPeopleBean();
                            people.setFirstName(member.getString("firstName"));
                            people.setLastName(member.getString("lastName"));
                            people.setEmail(email);
                            
                            if (accessMap.containsKey(email)) {
                                String accessLevel = accessMap.get(email) ? "Share and Delete" : "View and Download";
                                people.setAccessLevel(accessLevel);
                            } else {
                                people.setAccessLevel("No Access");
                            }
                            peopleBeans.add(people);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return peopleBeans;
        
    }

}
