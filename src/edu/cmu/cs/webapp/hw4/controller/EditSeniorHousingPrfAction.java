package edu.cmu.cs.webapp.hw4.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.cs.webapp.hw4.formbean.SeniorHousingPrfForm;

public class EditSeniorHousingPrfAction extends Action {
	private FormBeanFactory<SeniorHousingPrfForm> formBeanFactory = FormBeanFactory.getInstance(SeniorHousingPrfForm.class);
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "editSeniorHousingPrf.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);
        
        try {
			SeniorHousingPrfForm form = formBeanFactory.create(request);
			request.setAttribute("form", form);
			if (form.getAction() == null) {
				return "SeniorHousingPrfEdit.jsp";
			}
			if (form.getAction().equals("Cancel")) {
				return "manageSeniorHousing.do";
			}
			if (form.getAction().equals("Submit")) {
				String query = "http://localhost:8080/CurantisBackendService/curantis/seniorhousing/addPreference";
	      	    JSONObject json = new JSONObject();
	      	    
	      	    JSONObject prf = new JSONObject();
	      	    prf.put("location", form.getLocation());
	      	    prf.put("price", form.getPrice());
	      	    json.put("circleId", 4);
	      	    json.put("preference", prf.toString());
	      	    
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
	          	    String message = responseObj.getString("message");
	          	    if (!success) {
	          		    errors.add(message);
	          		    return "SeniorHousingPrfEdit.jsp";
	          	    }
	            }
	            return "manageSeniorHousing.do";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return "SeniorHousingPrfEdit.jsp";
	}

}
