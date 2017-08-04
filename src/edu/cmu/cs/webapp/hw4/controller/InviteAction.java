package edu.cmu.cs.webapp.hw4.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.cs.webapp.hw4.databean.SessionBean;
import edu.cmu.cs.webapp.hw4.formbean.InvitationForm;

public class InviteAction extends Action{
    private FormBeanFactory<InvitationForm> formBeanFactory = FormBeanFactory.getInstance(InvitationForm.class);
    @Override
    public String getName() {
        return "invite.do";
    }

    @Override
    public String perform(HttpServletRequest request) {
        SessionBean sessionBean = (SessionBean) request.getSession().getAttribute("session");
//        if (sessionBean == null) {
//            return "login.do";
//        }
//        
        
        List<String> errors = new ArrayList<>();
        request.setAttribute("errors", errors);
        JSONObject responseObj = new JSONObject();
        
        try {
            InvitationForm form = formBeanFactory.create(request);
            request.setAttribute("form", form);
            errors.addAll(form.getValidationErrors());
            if (errors.size() != 0) {
                return "error.jsp";
                //return "CareteamDashboard.jsp";
            }
            if (form.getAction().equals("Send Invitation")) {
                String query = "http://localhost:8080/CurantisBackendService/curantis/addToCircle";
                JSONObject obj = new JSONObject();
               
                try {
//                    obj.put("email", sessionBean.getEmail());
//                    obj.put("circleId", sessionBean.getCircleId());
                    obj.put("email", "junyi@gmail.com");
                    obj.put("circleId", "1");
                    obj.put("emailToAdd", form.getEmailToAdd());
                } catch (JSONException e1) {
                      e1.printStackTrace();
                }
                
                try {
                    URL url = new URL(query);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setConnectTimeout(5000);
                    conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                    conn.setDoOutput(true);
                    conn.setDoInput(true);
                    conn.setRequestMethod("POST");
                    OutputStream os = conn.getOutputStream();
                    os.write(obj.toString().getBytes("UTF-8"));
                    System.out.println("Sent request to backend");
                    os.close();
                    
                    // read the response
                    if (conn.getResponseCode() != 200) {
                        throw new RuntimeException("Failed : HTTP error code : "
                            + conn.getResponseCode());
                    }
    
                    BufferedReader br = new BufferedReader(new InputStreamReader(
                            (conn.getInputStream())));
                    String output;
                    System.out.println("Output from Server .... \n");
                    
                    while ((output = br.readLine()) != null) {
                        try {
                            responseObj = new JSONObject(output);
                            Boolean success = responseObj.getBoolean("success");
                            String message = responseObj.getString("message");
                            if (!success) {
                                if (message.equals("Missing email or circleId!")) {
                                    errors.add("Missing email or circleId!");
                                    return "error.jsp";
                                    //return "CareteamDashboard.jsp";
                                } else if (message.equals("Member already exists in this circle!")) {
                                    errors.add("Member already exists in this circle!");
                                    return "error.jsp";
                                    //return "CareteamDashboard.jsp";
                                } else if (message.equals("Adding to circle failed!")) {
                                    errors.add("Invite people failed! Please try again.");
                                    return "error.jsp";
                                    //return "CareteamDashboard.jsp";
                                } else if (message.equals("Not primary caregiver for this circle!")) {
                                    errors.add("Not primary caregiver for this circle!");
                                    return "error.jsp";
                                    //return "CareteamDashboard.jsp";
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    conn.disconnect();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                errors.add("Invitation is sent to the user's email!");
                return "error.jsp";
                //return "careteamDashboard.do";
            } else {
                return "careteamDashboard.do";
            }
            
        } catch (FormBeanException e) {
            errors.add(e.getMessage());
            return "error.jsp";
        }
    }

}
