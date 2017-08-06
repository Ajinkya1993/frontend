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
import org.mybeans.form.FormBeanException;

import edu.cmu.cs.webapp.hw4.databean.SessionBean;
import edu.cmu.cs.webapp.hw4.formbean.LoginForm;

public class CareteamDashboardAction extends Action {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "careteamDashboard.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		System.out.println("The careteam name is "+request.getParameter("cnm"));
		 HttpSession session = request.getSession();
	        JSONObject responseObj = new JSONObject();
	        JSONObject responseObj_mem = new JSONObject();
	        List<String> errorsct = new ArrayList<String>();
	        List<String> members = new ArrayList<String>();
	        request.setAttribute("errorsct", errorsct);
    	  	String lovedone_firstName = new String();
    	  	String lovedone_LastName = new String();
    	  	String triggerEvent = new String();
    	  	String lovedoneURL = new String();
    	  	String lovedoneaddr = new String();

    	  	Boolean primaryCaregiver = false;
    	  	String subscribedServices = new String();
	          	  String query = "http://localhost:8080/CurantisBackendService/curantis/viewlovedoneinfo";
	          	String query_mem = "http://localhost:8080/CurantisBackendService/curantis/getusersofacircle";
		        	  JSONObject json = new JSONObject();
		        	  //String email = "c@gmail.com"; //comment this when email passed in session from login
		        	  
		        	  SessionBean sessionBean = (SessionBean) request.getSession().getAttribute("session");
		        	  if(sessionBean == null) {
		        		  System.out.println("Session bean is null in careteam dashboard");
		        	  }
		        	  
		           String email = sessionBean.getEmail();
		           String circleName = new String();
		        	  //String circleName = "Michael Jordan"; //comment this later
		           if(sessionBean != null && sessionBean.getCircleName() != null) { //returning frmo update loved one info
		        	   circleName = sessionBean.getCircleName();
		           } else {
		        	   circleName = request.getParameter("cnm");
		           }
		        	  //Long circleId = 3L;
		        	  long circleId;
		              try {
		            	  json.put("email", email);
			              json.put("circleName", circleName);
			              //json.put("circleId", 2);
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
		                System.out.println("Output from Server care team .... \n");
		                
		                //service and loved one info
		                while ((output = br.readLine()) != null) {
		                	try {
							responseObj = new JSONObject(output);
							System.out.println("In loop with response obj "+responseObj);
							circleId = responseObj.getLong("circleId");
							
							System.out.println("The circleId in careteam dashboard is "+circleId);
							//setting session ID here
							if(sessionBean == null) System.out.println("sesiion bean is null");
							sessionBean.setCircleId(circleId);
							sessionBean.setCircleName(circleName);
							json.put("circleId", circleId);
							lovedone_firstName =  responseObj.getString("lovedone_firstName");
							lovedone_LastName =  responseObj.getString("lovedone_LastName");
							triggerEvent =  responseObj.getString("triggerEvent");
							lovedoneURL= responseObj.getString("pictureUrl");
							lovedoneaddr =  responseObj.getString("lovedoneAddress");
							primaryCaregiver =  responseObj.getBoolean("primaryCaregiver");
							subscribedServices =  responseObj.getString("subscribedServices");
				              System.out.println("Initital check " + lovedone_firstName + " " + lovedone_LastName+ " " + triggerEvent+ " " + lovedoneURL+ " " + lovedoneURL+ " " +subscribedServices);

								
							} catch (JSONException e) {
								e.printStackTrace();
							}
		                    //System.out.println(output);
		                }
		                conn.disconnect();

		                
		                //team mebers
		                
		                String output_mem;
		                
		                // read the response
		                URL url_mem = new URL(query_mem);
		                HttpURLConnection conn_mem = (HttpURLConnection) url_mem.openConnection();
		                conn_mem.setConnectTimeout(5000);
		                conn_mem.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		                conn_mem.setDoOutput(true);
		                conn_mem.setDoInput(true);
		                conn_mem.setRequestMethod("POST");
		                OutputStream os_mem = conn_mem.getOutputStream();
		                os_mem.write(json.toString().getBytes("UTF-8"));
		                os_mem.close();
		                if (conn_mem.getResponseCode() != 200) {
		                    throw new RuntimeException("Failed : HTTP error code : "
		                        + conn_mem.getResponseCode());
		                }
		                BufferedReader br_mem = new BufferedReader(new InputStreamReader(
		                        (conn_mem.getInputStream())));
		
		                
		                while ((output_mem = br_mem.readLine()) != null) {
		                	try {
							responseObj_mem = new JSONObject(output_mem);
							System.out.println("In loop with response obj "+responseObj_mem);
							Boolean success = responseObj_mem.getBoolean("success");
							String message = responseObj_mem.getString("message");
							if(success != true) {
								if(message.equals("Missing circleId!")) {
									errorsct.add("The circleId is missing. Please retry.");
									return "CareteamDashboard.jsp";
								} else if(message.equals("No caregiver in this circle!")) {
									errorsct.add("No caregiver in this circle! Please create a circle!");
								}else if(message.equals("User not in caregiver info table!")) {
									errorsct.add("You are not in the caregiver circle");
									return "CareteamDashboard.jsp";
								}
							}
								
							} catch (JSONException e) {
								e.printStackTrace();
							}
		                    //System.out.println(output);
		                }
		                conn_mem.disconnect();
		              } catch (MalformedURLException e) {
		
		                e.printStackTrace();
		  
		              } catch (IOException e) {
		
		                e.printStackTrace();
		
		             }
	              
	              if(errorsct == null || errorsct.size() <= 0) {
		              List<String> careteammembers = new ArrayList<String>();
						try {
							JSONArray recs = responseObj_mem.getJSONArray("list");
							for (int i = 0; i < recs.length(); ++i) {
								System.out.println(i);
							    JSONObject rec = recs.getJSONObject(i);
							    System.out.println("The object actually is "+rec);
							    String info = rec.getString("firstName") + " " + rec.getString("lastName") + "|" + rec.getString("email") + "|"  + rec.getString("phoneNumber"); 
							    careteammembers.add(info);
							}    
						} catch (JSONException e) {
							e.printStackTrace();
						}
						request.setAttribute("careteammembers", careteammembers);
		              }
	              //System.out.println(lovedone_firstName + " " + lovedone_LastName+ " " + triggerEvent+ " " + lovedoneURL+ " " + lovedoneURL+ " " +subscribedServices);
	              request.setAttribute("lovedone_firstName", lovedone_firstName);
	              request.setAttribute("lovedone_LastName", lovedone_LastName);
	              request.setAttribute("triggerEvent", triggerEvent);
	              request.setAttribute("lovedoneURL", lovedoneURL);
	              request.setAttribute("lovedoneaddr", lovedoneaddr);
	              request.setAttribute("lovedoneURL", lovedoneURL);
	              request.setAttribute("subscribedServices", subscribedServices);
	              request.setAttribute("primaryCaregiver", primaryCaregiver);
	              request.getSession().setAttribute("session", sessionBean);
	          
	          return "CareteamDashboard.jsp";
	        } 		
	}

