package edu.cmu.cs.webapp.hw4.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
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

import edu.cmu.cs.webapp.hw4.databean.SessionBean;

public class ManageServicesAction extends Action {
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "manageServices.do";
	}
	
	@Override
	public String perform(HttpServletRequest request) {
		
        SessionBean sessionBean = (SessionBean) request.getSession().getAttribute("session");
        if(sessionBean == null) {
  		  System.out.println("Session bean is null in personal dashboard");
  		  return "PersonalDashboard.jsp";
        }
        
		try {
			if (request.getParameter("addAction") != null) {		
				String subscribedServices = addService (request);
				System.out.println("add has been requested:" + subscribedServices);
				request.setAttribute("subscribedServices", subscribedServices);
				return "manageServices.jsp";
			}
			if (request.getParameter("deleteAction") != null) {		
				String subscribedServices = deleteService (request);
				System.out.println("delete has been requested:" + subscribedServices);
				request.setAttribute("subscribedServices", subscribedServices);
				return "manageServices.jsp";
			}
			if (request.getParameter("directAdd") != null) {		
				String subscribedServices = directAdd (request);
				System.out.println("add has been requested:" + subscribedServices);
				request.setAttribute("subscribedServices", subscribedServices);
				return "manageServices.jsp";
			}
			if (request.getParameter("directRemove") != null) {							
				String subscribedServices = directDelete (request);
				System.out.println("delete has been requested:" + subscribedServices);
				request.setAttribute("subscribedServices", subscribedServices);				
				return "manageServices.jsp";
			}
			HttpSession session = request.getSession();
		    JSONObject responseObj = new JSONObject();
		    String query = "http://localhost:8080/CurantisBackendService/curantis/manageservices/get";
		    Long circleId = sessionBean.getCircleId();
		    JSONObject request_json = new JSONObject();
		    request_json.put("circleId", circleId);
		    URL url = new URL(query);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setConnectTimeout(5000);
	        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	        conn.setDoOutput(true);
	        conn.setDoInput(true);
	        conn.setRequestMethod("POST");
	        OutputStream os = conn.getOutputStream();
	        os.write(request_json.toString().getBytes("UTF-8"));
	        os.close();
	        
	        if (conn.getResponseCode() != 200) {
	            throw new RuntimeException("Failed : HTTP error code : "
	                + conn.getResponseCode());
	        }
			 
	        BufferedReader br = new BufferedReader(new InputStreamReader(
	                (conn.getInputStream())));
	        
	        String output;
	        System.out.println("Output from Server care team .... \n");
	        String subscribedServices = new String();
	        while ((output = br.readLine()) != null) {
	        	try {
				responseObj = new JSONObject(output);
				System.out.println("Received response: "+responseObj);
				subscribedServices =  responseObj.getString("subscribedServices");
					
				} catch (JSONException e) {
					e.printStackTrace();
				}
	            
	        }
	        System.out.println("here" + subscribedServices);
	        request.setAttribute("subscribedServices", subscribedServices);
	        conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

        return "manageServices.jsp";
        
	}
	public String addService (HttpServletRequest request) {
		String subscribedServices = new String();
		try {
			HttpSession session = request.getSession();
		    JSONObject responseObj = new JSONObject();
		    String query = "http://localhost:8080/CurantisBackendService/curantis/manageservices/add";
		    SessionBean sessionBean = (SessionBean) request.getSession().getAttribute("session");
		    Long circleId = sessionBean.getCircleId();
		    JSONObject request_json = new JSONObject();
		    request_json.put("circleId", circleId);
		    String moreservices = request.getParameter("serviceToAdd");
		    request_json.put("services", moreservices);
		    URL url = new URL(query);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setConnectTimeout(5000);
	        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	        conn.setDoOutput(true);
	        conn.setDoInput(true);
	        conn.setRequestMethod("POST");
	        OutputStream os = conn.getOutputStream();
	        os.write(request_json.toString().getBytes("UTF-8"));
	        os.close();
	        
	        if (conn.getResponseCode() != 200) {
	            throw new RuntimeException("Failed : HTTP error code : "
	                + conn.getResponseCode());
	        }
			 
	        BufferedReader br = new BufferedReader(new InputStreamReader(
	                (conn.getInputStream())));
	        
	        String output;
	        System.out.println("Output from Server care team .... \n");
	        
	        while ((output = br.readLine()) != null) {
	        	try {
				responseObj = new JSONObject(output);
				System.out.println("Received response: "+responseObj);
				subscribedServices =  responseObj.getString("subscribedServices");
					
				} catch (JSONException e) {
					e.printStackTrace();
				}
	            
	        }
	        System.out.println("here" + subscribedServices);
	        request.setAttribute("subscribedServices", subscribedServices);
	        
	        conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subscribedServices;
		
	}
	
	public String directAdd (HttpServletRequest request) {
		String subscribedServices = new String();
		try {
			HttpSession session = request.getSession();
		    JSONObject responseObj = new JSONObject();
		    String query = "http://localhost:8080/CurantisBackendService/curantis/manageservices/add";
		    SessionBean sessionBean = (SessionBean) request.getSession().getAttribute("session");
		    Long circleId = sessionBean.getCircleId();
		    JSONObject request_json = new JSONObject();
		    request_json.put("circleId", circleId);
		    String moreservices = request.getParameter("service");
		    request_json.put("services", moreservices);
		    URL url = new URL(query);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setConnectTimeout(5000);
	        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	        conn.setDoOutput(true);
	        conn.setDoInput(true);
	        conn.setRequestMethod("POST");
	        OutputStream os = conn.getOutputStream();
	        os.write(request_json.toString().getBytes("UTF-8"));
	        os.close();
	        
	        if (conn.getResponseCode() != 200) {
	            throw new RuntimeException("Failed : HTTP error code : "
	                + conn.getResponseCode());
	        }
			 
	        BufferedReader br = new BufferedReader(new InputStreamReader(
	                (conn.getInputStream())));
	        
	        String output;
	        System.out.println("Output from Server care team .... \n");
	        
	        while ((output = br.readLine()) != null) {
	        	try {
				responseObj = new JSONObject(output);
				System.out.println("Received response: "+responseObj);
				subscribedServices =  responseObj.getString("subscribedServices");
					
				} catch (JSONException e) {
					e.printStackTrace();
				}
	            
	        }
	        System.out.println("here" + subscribedServices);
	        request.setAttribute("subscribedServices", subscribedServices);
	        
	        conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subscribedServices;
		
	}
	
	public String deleteService (HttpServletRequest request) {
		String subscribedServices = new String();
		try {
			HttpSession session = request.getSession();
		    JSONObject responseObj = new JSONObject();
		    String query = "http://localhost:8080/CurantisBackendService/curantis/manageservices/delete";
		    SessionBean sessionBean = (SessionBean) request.getSession().getAttribute("session");
		    Long circleId = sessionBean.getCircleId();
		    JSONObject request_json = new JSONObject();
		    request_json.put("circleId", circleId);
		    String moreservices = request.getParameter("serviceToDelete");
		    request_json.put("services", moreservices);
		    URL url = new URL(query);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setConnectTimeout(5000);
	        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	        conn.setDoOutput(true);
	        conn.setDoInput(true);
	        conn.setRequestMethod("POST");
	        OutputStream os = conn.getOutputStream();
	        os.write(request_json.toString().getBytes("UTF-8"));
	        os.close();
	        
	        if (conn.getResponseCode() != 200) {
	            throw new RuntimeException("Failed : HTTP error code : "
	                + conn.getResponseCode());
	        }
			 
	        BufferedReader br = new BufferedReader(new InputStreamReader(
	                (conn.getInputStream())));
	        
	        String output;
	        System.out.println("Output from Server care team .... \n");
	        
	        while ((output = br.readLine()) != null) {
	        	try {
				responseObj = new JSONObject(output);
				System.out.println("Received response: "+responseObj);
				subscribedServices =  responseObj.getString("subscribedServices");
					
				} catch (JSONException e) {
					e.printStackTrace();
				}
	            
	        }
	        System.out.println("here" + subscribedServices);
	        request.setAttribute("subscribedServices", subscribedServices);
	        
	        conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subscribedServices;
		
	}
	
	public String directDelete (HttpServletRequest request) {
		String subscribedServices = new String();
		try {
			HttpSession session = request.getSession();
		    JSONObject responseObj = new JSONObject();
		    String query = "http://localhost:8080/CurantisBackendService/curantis/manageservices/delete";
		    SessionBean sessionBean = (SessionBean) request.getSession().getAttribute("session");
		    Long circleId = sessionBean.getCircleId();
		    JSONObject request_json = new JSONObject();
		    request_json.put("circleId", circleId);
		    String moreservices = request.getParameter("service");
		    request_json.put("services", moreservices);
		    URL url = new URL(query);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setConnectTimeout(5000);
	        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	        conn.setDoOutput(true);
	        conn.setDoInput(true);
	        conn.setRequestMethod("POST");
	        OutputStream os = conn.getOutputStream();
	        os.write(request_json.toString().getBytes("UTF-8"));
	        os.close();
	        
	        if (conn.getResponseCode() != 200) {
	            throw new RuntimeException("Failed : HTTP error code : "
	                + conn.getResponseCode());
	        }
			 
	        BufferedReader br = new BufferedReader(new InputStreamReader(
	                (conn.getInputStream())));
	        
	        String output;
	        System.out.println("Output from Server care team .... \n");
	        
	        while ((output = br.readLine()) != null) {
	        	try {
				responseObj = new JSONObject(output);
				System.out.println("Received response: "+responseObj);
				subscribedServices =  responseObj.getString("subscribedServices");
					
				} catch (JSONException e) {
					e.printStackTrace();
				}
	            
	        }
	        System.out.println("here" + subscribedServices);
	        request.setAttribute("subscribedServices", subscribedServices);
	        
	        conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subscribedServices;
		
	}
}

