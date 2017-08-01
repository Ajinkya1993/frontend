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

public class PersonalDashboardAction extends Action {
	
		@Override
		public String getName() {
			return "personalDashboard.do";
		}
		
		public String perform(HttpServletRequest request) {
			//return "index.jsp";
	        HttpSession session = request.getSession();
	        JSONObject responseObj = new JSONObject();
	        List<String> errors = new ArrayList<String>();
	        request.setAttribute("errors", errors);
	        //Boolean success = false;
	        try { 
	          	  String query = "http://localhost:8080/CurantisBackendService/curantis/getusersofacircle";
		        	  JSONObject json = new JSONObject();
		              try {
		            	  System.out.println("Here");
		            	  String email = "varunp@andrew.cmu.edu";
		            	  json.put("email", email);
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
							System.out.println("Output is "+output);
							System.out.println("ResponseJSON is "+responseObj);
								Boolean success = responseObj.getBoolean("success");
								String message = responseObj.getString("message");
								if(success != true) {
									if(message.equals("Missing Email!")) {
										errors.add("The email is missing. Please login again.");
										return "login.jsp";
									} else if(message.equals("No circle for this caregiver!")) {
										errors.add("You do not have any circle yet! Please create a circle.");
										return "PersonalDashboard.jsp";
									}
								}
								
							} catch (JSONException e) {
								e.printStackTrace();
							}
		                    System.out.println(output);
		                }
		                conn.disconnect();
		
		              } catch (MalformedURLException e) {
		
		                e.printStackTrace();
		
		              } catch (IOException e) {
		
		                e.printStackTrace();
		
		             }
	              String email = "varunp@andrew.cmu.edu";
	             // if(success) {
	             // String email = new String();
				//	try {
						//email = responseObj.getString("email");
				//	} catch (JSONException e) {
				//		e.printStackTrace();
				//	}
				//session.setAttribute("email", email);
	            //  }
	          return "PersonalDashboard.jsp";
	        }catch (Exception e) {
	            errors.add(e.getMessage());
	            return "error.jsp";
	        }
	    }
}
