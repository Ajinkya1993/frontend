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

import edu.cmu.cs.webapp.hw4.formbean.LoginForm;

public class DeleteCareteamAction extends Action {
	
		@Override
		public String getName() {
			return "deleteCareteamAction.do";
		}
		
		public String perform(HttpServletRequest request) {
			String careteam = request.getParameter("careteam");
			HttpSession session = request.getSession();
			String email = (String)session.getAttribute("email");
			//System.out.println("Email is "+session.getAttribute("email"));
			//return "PersonalDashboard.jsp";
			JSONObject responseObj = new JSONObject();
	        List<String> errors = new ArrayList<String>();
	        request.setAttribute("errors", errors);
			 String query = "http://localhost:8080/CurantisBackendService/curantis/declineinvitation";
			  JSONObject json = new JSONObject();
			  
			  try {
				  json.put("email", email);
				  System.out.println("email is "+email);
			      json.put("circleName", careteam);  //"circleName" in circleinput in backend should be revised to careteamname
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
			    
			    while ((output = br.readLine()) != null) {
			    	try {
					responseObj = new JSONObject(output);
						Boolean success = responseObj.getBoolean("success");
						String message = responseObj.getString("message");
						if(success != true) {
							if(message.equals("Missing email!")) {
								errors.add("Missing email");
								return "error.jsp";
							} else if(message.equals("Missing CircleName!")) {
								errors.add("Missing CircleName!");
								return "error.jsp";
							}else if(message.equals("Joined already!")) {
								errors.add("Joined already!");
								return "error.jsp";
							}else if(message.equals("Not invited to this circle!")) {
								errors.add("Not invited to this circle or Declined already!");
								return "error.jsp";
							} else if(message.equals("Declining Invitation failed!")) {
								errors.add("Join circle failed!");
								return "error.jsp";
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
        return "personalDashboard.do";
	    }
}
