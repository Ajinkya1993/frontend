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
import org.json.JSONException;
import org.json.JSONObject;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;
import edu.cmu.cs.webapp.hw4.databean.SessionBean;
import edu.cmu.cs.webapp.hw4.formbean.PaymentForm;

public class PaymentAction extends Action {
	private FormBeanFactory<PaymentForm> formBeanFactory = FormBeanFactory.getInstance(PaymentForm.class);
    public PaymentAction() {
        
    }

    @Override
    public String getName() {
        return "payment.do";
    }
    
    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);
        /*
        //Taking CircleId and Email from session bean
        SessionBean sessionBean = (SessionBean) request.getSession().getAttribute("session");
        Integer circleId;
        String email;
        if (sessionBean != null) {
        	circleId = sessionBean.getCircleId();
        	email = sessionBean.getEmail();
        }else {
        	errors.add("Circle Does Not Exist or You Are Not in the Circle!");
        	return "payment.jsp";
        }
        */
        JSONObject responseObj = new JSONObject();

        try {
            PaymentForm form = formBeanFactory.create(request);
            request.setAttribute("form", form);

            // If no params were passed, return with no errors so that the form will be
            // presented (we assume for the first time).
            if (!form.isPresent()) {
                return "payment.jsp";
            }

            // Any validation errors?
            errors.addAll(form.getValidationErrors());
            if (errors.size() != 0) {
                return "payment.jsp";
            }

            if (form.getAction().equals("Subscribe")) {
            	  String query = "http://localhost:8080/CurantisBackendService/curantis/addpayment";
	        	  JSONObject json = new JSONObject();
	        	  
	              try {
	            	  //json.put("email", email);
	            	  //json.put("circleId", circleId);
		              json.put("firstName", form.getFirstName());
		              json.put("middleName",form.getMiddleName());
		              json.put("lastName", form.getLastName());
		              json.put("cardNumber", form.getCardNumber());
		              json.put("cardType", form.getCardType());
		              json.put("cardExpiry", form.getCardExpiry());
		              json.put("cardCVC", form.getCardCVC());
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
								if(message.equals("Circle does not exist!")) {
									errors.add("The Care Team you are subscribing for, does not exist!");
									return "payment.jsp";
									
								} else {
									errors.add(responseObj.getString("message"));
									return "payment.jsp";
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
                return "careteamDashboard.do";
            } else if (form.getAction().equals("Continue to PayPal")){
            	System.out.print("PayPal");
            }
            return "payment.jsp";
        } catch (FormBeanException e) {
            errors.add(e.getMessage());
            return "payment.jsp";
        }
    }
}