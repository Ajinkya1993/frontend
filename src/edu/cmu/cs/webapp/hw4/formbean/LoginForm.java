// Name: Namita Sibal Date: 12/14/16 Course Number: 08672
package edu.cmu.cs.webapp.hw4.formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class LoginForm extends FormBean{
    private String emailaddress;
    private String password;
    private String action;
	
    public String getEmailaddress()  { return emailaddress; }
    public String getPassword()  { return password; }
    public String getAction()    { return action; }
	
    public void setEmailaddress(String s)  { emailaddress = s.trim(); }
    public void setPassword(String s)  { password = s.trim(); }
    public void setAction(String s)    { action   = s;        }

    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();

        if (emailaddress == null || emailaddress.length() == 0) errors.add("Email Address is required");
        if (password == null || password.length() == 0) errors.add("Password is required");
        if (action == null) errors.add("Button is required");

        if (errors.size() > 0) return errors;

        if (!action.equals("Login") && !action.equals("Registration Link")) {
        	errors.add("Invalid button");
        }
		
        return errors;
    }
}
