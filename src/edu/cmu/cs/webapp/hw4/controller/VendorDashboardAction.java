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
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.cmu.cs.webapp.hw4.databean.SessionBean;

public class VendorDashboardAction extends Action {

		@Override
		public String getName() {
			return "vendorDashboard.do";
		}
		
		public String perform(HttpServletRequest request) {
			
	        //HttpSession session = request.getSession();
			SessionBean sessionBean = (SessionBean) request.getSession().getAttribute("session");
      	  if(sessionBean == null) {
      		  System.out.println("Session bean is null in vendor dashboard");
      	  }
	        //System.out.println("Checking if caretem passed as "+session.getAttribute("careteam"));
	        JSONObject responseObj = new JSONObject();
	        List<String> errors = new ArrayList<String>();
	        List<String> errorsinvite = new ArrayList<String>();
	        request.setAttribute("errors", errors);
	       Long circleId;
	        //getting the careteams
	        try { 
	          	  String query = "http://localhost:8080/CurantisBackendService/curantis/getvendorsofcircle";
		        	  JSONObject json = new JSONObject();
		              try {
		            	  circleId = sessionBean.getCircleId();
		            	  json.put("circleId", circleId);
					} catch (JSONException e1) {
						e1.printStackTrace();
					}
	              try {
		                URL url = new URL(query);
		                
		                //for careteam
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
		                
		                //careteam
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
										return "error.jsp";
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
	            //getting the vendors
	            /*  if(errors == null || errors.size() <= 0) {
	              List<String> vendors = new ArrayList<String>();
					try {
						JSONArray recs = responseObj.getJSONArray("list");
						for (int i = 0; i < recs.length(); ++i) {
						    JSONObject rec = recs.getJSONObject(i);
						    JSONObject recf = rec.getJSONObject("identity");
						    String response = recf.getString("vendorName"); 
						    vendors.add(response);
						}    
					} catch (JSONException e) {
						e.printStackTrace();
					}
					request.setAttribute("vendorName", vendors);
	              }*/
	              
	              if(errors == null || errors.size() <= 0) {
		              List<String> vendors = new ArrayList<String>();
						try {
							JSONArray recs = responseObj.getJSONArray("set");
							System.out.println("recs"+recs);
							for (int i = 0; i < recs.length(); ++i) {
							    String vname = recs.getString(i);
							    System.out.println("vname "+vname);
							    vendors.add(vname);
							}    
						} catch (JSONException e) {
							e.printStackTrace();
						}
						request.setAttribute("vendorName", vendors);
		              }
	              
	              
	              //session.setAttribute("email", email);
	              //sessionBean.setEmail("c@gmail.com");
	              System.out.println("Size of normal error is "+ errors.size());
	              request.getSession().setAttribute("session", sessionBean);
	          return "VendorDashboard.jsp";
	        }catch (Exception e) {
	            errors.add(e.getMessage());
	            return "error.jsp";
	        }
	    }
}
