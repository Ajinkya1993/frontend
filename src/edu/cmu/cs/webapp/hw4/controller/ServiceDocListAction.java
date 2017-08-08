package edu.cmu.cs.webapp.hw4.controller;


import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
		// TODO Auto-generated method stub
		SessionBean sessionBean = (SessionBean) request.getSession().getAttribute("session");
    	if(sessionBean == null) {
  		  System.out.println("Session bean is null");
  		}
		
    	String email = sessionBean.getEmail();
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		JSONObject responseObj = new JSONObject();
     
        String subscribedServices = new String();
    	String query = "http://localhost:8080/CurantisBackendService/curantis/viewlovedoneinfo";
    	JSONObject json = new JSONObject();
    	
    
		String circleName = new String();
		if (request.getParameter("cnm") != null) {
			circleName = request.getParameter("cnm");
		} else {
			circleName = sessionBean.getCircleName();
		}
    	
  	  long circleId;
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
          String output = new String();
          if (output != null) {
          responseObj = new JSONObject(output);
          circleId = responseObj.getLong("circleId");
          sessionBean.setCircleId(circleId);
          if(sessionBean == null) System.out.println("session bean is null");
		  sessionBean.setCircleId(circleId);
		  sessionBean.setCircleName(circleName);
		  json.put("circleId", circleId);
		  subscribedServices =  responseObj.getString("subscribedServices");
		  conn.disconnect(); 
          }
	} catch (Exception e) {
		 e.printStackTrace();
	}
	return "ServiceDocList.jsp";
	}
}