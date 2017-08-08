// Name: Namita Sibal Date: 12/14/16 Course Number: 08672
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
import edu.cmu.cs.webapp.hw4.formbean.LoginForm;


public class UpdateVendorInfoAction extends Action {
    private FormBeanFactory<LoginForm> formBeanFactory = FormBeanFactory.getInstance(LoginForm.class);

    public UpdateVendorInfoAction() {
    }

    public String getName() {
        return "updatevendorinfodbaction.do";
    }

    public String perform(HttpServletRequest request) {
    	System.out.println("In update loved one info db action!!");
        JSONObject responseObj = new JSONObject();
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);
        SessionBean sessionBean = (SessionBean) request.getSession().getAttribute("session");
    	  if(sessionBean == null) {
    		  System.out.println("Session bean is null in careteam dashboard");
    	  }
			String email = sessionBean.getEmail();
			String circlename = sessionBean.getCircleName();
			Long circleid = sessionBean.getCircleId();
			
			String lovedone_firstName = request.getParameter("lovedone_firstName");
			String lovedone_LastName = request.getParameter("lovedone_LastName");
			String triggerEvent = request.getParameter("triggerEvent");
			String lovedoneURL = request.getParameter("lovedoneURL");
			String lovedoneaddr = request.getParameter("lovedoneaddr");
            String georel = request.getParameter("geoRel");
            String relat = request.getParameter("natureOfRel");
            System.out.println("In Update loved one info db before try: "+lovedone_firstName+" "+lovedone_LastName + " " + triggerEvent + " " +lovedoneURL + " " + lovedoneaddr + " " + georel + " " + relat);
            
        try {
                  String query = "http://localhost:8080/CurantisBackendService/curantis/updatelovedoneinfodb";
	        	  JSONObject json = new JSONObject();
	        	  json.put("email", email);
	        	  json.put("circleName", circlename);
	        	  json.put("circleId", circleid);
	        	  json.put("lovedone_firstName", lovedone_firstName);
	        	  json.put("lovedone_LastName", lovedone_LastName);
	        	  json.put("triggerEvent", triggerEvent);
	        	  json.put("pictureUrl", lovedoneURL);
	        	  json.put("lovedoneAddress", lovedoneaddr);
	        	  json.put("geoRel", georel);
	        	  json.put("natureOfRel", relat);
	        	  System.out.println("Inputting in JSON fields " +georel+" "+relat);
              try {
	                URL url = new URL(query);
	                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	                conn.setConnectTimeout(5000);
	                conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	                conn.setDoOutput(true);
	                conn.setDoInput(true);
	                conn.setRequestMethod("POST");
	                OutputStream os = conn.getOutputStream();
	                os.write(json.toString().getBytes("UTF-8"));
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
;
						
							Boolean success = responseObj.getBoolean("success");
							String message = responseObj.getString("message");
							if(success != true) {
								if(message.equals("Missing circleId!")) {
									errors.add("The circleId is missing. Please retry.");
									return "CareteamDashboard.jsp";
								} else if(message.equals("No caregiver in this circle!")) {
									errors.add("No caregiver in this circle! Please create a circle!");
								}else if(message.equals("User not in caregiver info table!")) {
									errors.add("You are not in the caregiver circle");
									return "CareteamDashboard.jsp";
								}
							}
							
						} catch (JSONException e) {
							e.printStackTrace();
						}
	                    //System.out.println(output);
	                }
	                conn.disconnect();
	
	              } catch (MalformedURLException e) {
	
	                e.printStackTrace();
	  
	              } catch (IOException e) {
	
	                e.printStackTrace();
	
	             }
              sessionBean.setCircleName(circlename);
              System.out.println("The circle name here is "+circlename);
              request.getSession().setAttribute("session", sessionBean);
          return "careteamDashboard.do";
        }catch (Exception e) {
            errors.add(e.getMessage());
            return "error.jsp";
        }
    }
}
