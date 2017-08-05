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

public class ManageServices extends Action {
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "manageServices.do";
	}
	
	@Override
	public String perform(HttpServletRequest request) {
		return "manageServices.jsp";
		/*
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
		 String email = "c@gmail.com";
		 String circleName = "Michael Jordan";
		 Long circleId = 3L;
		 */
	}

}
