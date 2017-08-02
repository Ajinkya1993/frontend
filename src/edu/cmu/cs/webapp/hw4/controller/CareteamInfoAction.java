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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CareteamInfoAction extends Action {
	
		@Override
		public String getName() {
			return "personalDashboard.do";
		}
		
		public String perform(HttpServletRequest request) {
			
	        HttpSession session = request.getSession();
	        JSONObject responseObj = new JSONObject();
	        JSONObject responseObj_invite = new JSONObject();
	        List<String> errors = new ArrayList<String>();
	        List<String> errors_invite = new ArrayList<String>();
	        request.setAttribute("errors", errors);
	      //getting the careteams
	        try { 
	          	  String query = "http://localhost:8080/CurantisBackendService/curantis/getcirclesofauser";
	          	String query_invite = "http://localhost:8080/CurantisBackendService/curantis/getinvitesofauser";
		        	  JSONObject json = new JSONObject();
		              try {
		            	  System.out.println("Here");
		            	  String email = "c@gmail.com";
		            	  json.put("email", email);
					} catch (JSONException e1) {
						e1.printStackTrace();
					}
	              try {
		                URL url = new URL(query);
		                URL url_invite = new URL(query_invite);
		                
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
		                
		                //for invite
		                HttpURLConnection conn_invite = (HttpURLConnection) url_invite.openConnection();
		                conn_invite.setConnectTimeout(5000);
		                conn_invite.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		                conn_invite.setDoOutput(true);
		                conn_invite.setDoInput(true);
		                conn_invite.setRequestMethod("POST");
		                OutputStream os_invite = conn_invite.getOutputStream();
		                os_invite.write(json.toString().getBytes("UTF-8"));
		                os_invite.close();
		                
		                // read the response
		                if (conn.getResponseCode() != 200) {
		                    throw new RuntimeException("Failed : HTTP error code : "
		                        + conn.getResponseCode());
		                }
		                
		                if (conn_invite.getResponseCode() != 200) {
		                    throw new RuntimeException("Failed : HTTP error code : "
		                        + conn.getResponseCode());
		                }
		
		                BufferedReader br = new BufferedReader(new InputStreamReader(
		                        (conn.getInputStream())));
		                BufferedReader br_invite = new BufferedReader(new InputStreamReader(
		                        (conn_invite.getInputStream())));
		
		                String output;
		                String output_invite;
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
										//return "PersonalDashboard.jsp";
									}
								}
								
								
							} catch (JSONException e) {
								e.printStackTrace();
							}
		                    System.out.println(output);
		                }
		                conn.disconnect();
		                
		                //invite
		                while ((output_invite = br_invite.readLine()) != null) {
		                	try {
		                
							responseObj_invite = new JSONObject(output_invite);
							System.out.println("ResponseJSON is "+responseObj_invite);
								Boolean success = responseObj_invite.getBoolean("success");
								String message = responseObj_invite.getString("message");
								if(success != true) {
									if(message.equals("Missing Email!")) {
										errors_invite.add("The email is missing. Please login again.");
										return "login.jsp";
									} else if(message.equals("No invitation for this caregiver!")) {
										errors_invite.add("You do not have any invitations!");
										//return "PersonalDashboard.jsp";
									}
								}
								
								
							} catch (JSONException e) {
								e.printStackTrace();
							}
		                    System.out.println(output);
		                }
		                conn_invite.disconnect();
		
		              } catch (MalformedURLException e) {
		
		                e.printStackTrace();
		
		              } catch (IOException e) {
		
		                e.printStackTrace();
		
		             }
	              
	              //getting the careteam
	              if(errors == null || errors.size() <= 0) {
	              List<String> careteam = new ArrayList<String>();
					try {
						JSONArray recs = responseObj.getJSONArray("list");
						for (int i = 0; i < recs.length(); ++i) {
						    JSONObject rec = recs.getJSONObject(i);
						    String response = rec.getString("circleName");
						    careteam.add(response);
						}   
					} catch (JSONException e) {
						e.printStackTrace();
					}
					session.setAttribute("careteamName", careteam);
	              }
	              
	              //getting the invitees
	              if(errors_invite == null || errors_invite.size() <= 0) {
		              List<String> invite = new ArrayList<String>();
						try {  
							JSONArray recs = responseObj_invite.getJSONArray("list");
							for (int i = 0; i < recs.length(); ++i) {
							    JSONObject rec = recs.getJSONObject(i);
							    String response = rec.getString("circleName");
							    invite.add(response);
							}     
						} catch (JSONException e) {
							e.printStackTrace();
						}
						session.setAttribute("invite", invite);
		              }
	              
	          return "PersonalDashboard.jsp";
	        }catch (Exception e) {
	            errors.add(e.getMessage());
	            return "error.jsp";
	        }
	    }
}
