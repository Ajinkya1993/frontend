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
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.cs.webapp.hw4.databean.SessionBean;
import edu.cmu.cs.webapp.hw4.formbean.RegisterForm;
import org.json.*;


public class RegisterAction extends Action {
    private FormBeanFactory<RegisterForm> formBeanFactory = FormBeanFactory.getInstance(RegisterForm.class);

    public RegisterAction() {
    }

    public String getName() {
        return "register.do";
    }

    public String perform(HttpServletRequest request) {
        SessionBean sessionBean = (SessionBean) request.getSession().getAttribute("session");
        if (sessionBean == null) {
			sessionBean = new SessionBean();
		}
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);
        JSONObject responseObj = new JSONObject();
        // If user is already logged in, redirect to personal Dashboard
        if (sessionBean != null && sessionBean.getEmail() != null) {
            return "personalDashboard.do";
        }

        try {
            RegisterForm form = formBeanFactory.create(request);
            request.setAttribute("form", form);

            // If no params were passed, return with no errors so that the form will be
            // presented (we assume for the first time).
            if (!form.isPresent()) {
                return "register.jsp";
            }

            // Any validation errors?
            errors.addAll(form.getValidationErrors());
            if (errors.size() != 0) {
                return "register.jsp";
            }

            if (form.getAction().equals("Register")) {
            	  String query = "http://localhost:8080/CurantisBackendService/curantis/register";
	        	  JSONObject json = new JSONObject();
	        	  
	              try {
	            	  json.put("email", form.getEmail());
		              json.put("password", form.getPassword());
		              json.put("firstName", form.getFirstName());
		              json.put("middleName",form.getMiddleName());
		              json.put("lastName", form.getLastName());
		              json.put("address", form.getAddress() + ">"+ form.getCity() +">"+ form.getState() + ">"+ form.getCountry());
		              json.put("phoneNo", form.getPhoneNumber());
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
	                System.out.println("Output from Server .... \n");
	                
	                while ((output = br.readLine()) != null) {
	                	try {
						responseObj = new JSONObject(output);
							Boolean success = responseObj.getBoolean("success");
							String message = responseObj.getString("message");
							if(success != true) {
								if(message.equals("Missing email or password!")) {
									errors.add("Missing email or password!");
									return "register.jsp";
									
								} else if(message.equals("Account already exist!")) {
									errors.add("Account already exist!");
									return "register.jsp";
								}
							}
							
						} catch (JSONException e) {
							e.printStackTrace();
						}
	                    System.out.println(output);
	                }
	
	                conn.disconnect();
	
	              } catch (MalformedURLException e) {
	
	                e.printStackTrace();
	
	              } catch (IOException e) {
	
	                e.printStackTrace();
	
	             }
                String firstName = new String();
                String lastName = new String();
                String email = new String();
				try {
					firstName = responseObj.getString("firstName");
					 lastName = responseObj.getString("lastName");
					 email = responseObj.getString("email");
				} catch (JSONException e) {
					e.printStackTrace();
				}
				sessionBean.setFirstName(firstName);
				sessionBean.setLastName(lastName);
				sessionBean.setEmail(email);
                return "registerEducation.do";
            } else {
            	return "register.jsp";
            }
        } catch (FormBeanException e) {
            errors.add(e.getMessage());
            return "register.jsp";
        }
    }
}
