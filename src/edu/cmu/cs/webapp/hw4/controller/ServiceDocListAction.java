package edu.cmu.cs.webapp.hw4.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import edu.cmu.cs.webapp.hw4.databean.SessionBean;

public class ServiceDocListAction extends Action {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "ServiceDocList.do";
	}

	@Override
	public String perform(HttpServletRequest request) {

        SessionBean sessionBean = (SessionBean) request.getSession().getAttribute("session");
        if(sessionBean == null) {
  		  System.out.println("Session bean is null in personal dashboard");
  		  return "ServiceDocList.jsp";
        }
        
		try {
			HttpSession session = request.getSession();
		    JSONObject responseObj = new JSONObject();
		    String query = "http://localhost:8080/CurantisBackendService/curantis/viewlovedoneinfo";
		    String email = sessionBean.getEmail();
		    String circleName = sessionBean.getCircleName();
		    JSONObject request_json = new JSONObject();
		    request_json.put("email", email);
		    request_json.put("circleName", circleName);
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
		return "ServiceDocList.jsp";
	}
	
}