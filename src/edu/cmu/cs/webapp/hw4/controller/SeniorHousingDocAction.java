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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.cmu.cs.webapp.hw4.databean.DocumentBean;
import edu.cmu.cs.webapp.hw4.databean.SessionBean;

public class SeniorHousingDocAction extends Action {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "seniorHousingDoc.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);
		List<DocumentBean> docList;
		
		SessionBean sessionBean = (SessionBean) request.getSession().getAttribute("session");
		if (sessionBean == null || sessionBean.getEmail() == null) {
			return "login.do";
		} else if (sessionBean.getCircleId() == 0) {
			errors.add("Not in a care team!");
			return "SeniorHousingDocument.jsp";
		}
		
		try {
			docList = getDocs(sessionBean.getEmail(), sessionBean.getCircleId(), 1);
			request.setAttribute("docList", docList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "SeniorHousingDocument.jsp";
	}
	
	private List<DocumentBean> getDocs(String email, long circleId, int service) throws JSONException, IOException {
		List<DocumentBean> list = new ArrayList<DocumentBean>();
		
		String query = "http://localhost:8080/CurantisBackendService/curantis/listDocuments";
  	    JSONObject json = new JSONObject();
		
  	    json.put("email", email);
  	    json.put("service", service);
  	    json.put("circleId", circleId);
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
        		JSONArray docs = responseObj.getJSONArray("listofdocs");
        		for (int i = 0; i < docs.length(); i++) {
        			JSONObject doc = docs.getJSONObject(i);
        			DocumentBean docBean = new DocumentBean();
        			docBean.setName(doc.getString("docname"));
        			docBean.setUrl(doc.getString("docurl"));
        			docBean.setAccessLevel(doc.getBoolean("accessLevel"));
        			list.add(docBean);
        		}
        	}
        }
		
		return list;
	}
}
