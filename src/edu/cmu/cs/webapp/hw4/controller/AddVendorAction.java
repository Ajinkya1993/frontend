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

public class AddVendorAction extends Action {
	
		@Override
		public String getName() {
			return "addVendorAction.do";
		}
		
		public String perform(HttpServletRequest request) {
			return "addVendor.jsp";
	    }
}
