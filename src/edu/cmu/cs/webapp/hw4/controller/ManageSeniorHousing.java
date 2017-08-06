package edu.cmu.cs.webapp.hw4.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;

import edu.cmu.cs.webapp.hw4.databean.SessionBean;

public class ManageSeniorHousing extends Action {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "manageSeniorHousing.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);
        
		SessionBean sessionBean = (SessionBean) request.getSession().getAttribute("session");
		if (sessionBean == null || sessionBean.getEmail() == null) {
			return "login.do";
		} else if (sessionBean.getCircleId() == 0) {
			errors.add("Not in a care team!");
			return "SeniorHousingPreference.jsp";
		}
		
		String query = "http://localhost:8080/CurantisBackendService/curantis/seniorhousing/getPreference";
  	    JSONObject json = new JSONObject();
  	    try {
			json.put("circleId", sessionBean.getCircleId());
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

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output = null;
            if ((output = br.readLine()) != null) {
            	JSONObject responseObj = new JSONObject(output);
            	boolean success = responseObj.getBoolean("success");
            	
            	if (success) {
            		String preference = responseObj.getString("preference");
            		JSONObject preferenceObj = new JSONObject(preference);
                	request.setAttribute("price", preferenceObj.getString("price"));
                	request.setAttribute("location", preferenceObj.getString("location"));
            		request.setAttribute("noPreference", false);
            	} else {
            		request.setAttribute("noPreference", true);
            	}
            }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "SeniorHousingPreference.jsp";
	}

}
