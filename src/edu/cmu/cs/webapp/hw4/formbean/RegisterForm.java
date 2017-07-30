// Name: Namita Sibal Date: 12/14/16 Course Number: 08672
package edu.cmu.cs.webapp.hw4.formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class RegisterForm extends FormBean{
    private String emailaddress;
    private String firstname;
    private String lastname;
    private String password;
    private String confirmpassword;
    private String action;
	
    public String getEmailaddress()  { return emailaddress; }
    public String getFirstname()  { return firstname; }
    public String getLastname()  { return lastname; }
    public String getPassword()  { return password; }
    public String getAction()    { return action; }
    public String getConfirmpassword() { return confirmpassword; }
	
    public boolean isPresent() {
		if (action == null) {
			return false;
		}
		return action.equals("Register");
	}
	
    public void setEmailaddress(String s)  { emailaddress = s.trim(); }
    public void setFirstname(String s)  { firstname = s.trim(); }
    public void setLastname(String s)  { lastname = s.trim(); }
    public void setPassword(String s)  { password = s.trim(); }
    public void setConfirmpassword(String s)  { confirmpassword = s.trim(); }
    public void setAction(String s)    { action   = s;        }

    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();

        if (emailaddress == null || emailaddress.length() == 0) errors.add("Email Address is required");
        if (password == null || password.length() == 0) errors.add("Password is required");
        if (firstname == null || firstname.length() == 0)
			errors.add("First Name is required");
		if (lastname == null || lastname.length() == 0)
			errors.add("Last Name is required");
        if (action == null) errors.add("Button is required");

        if (errors.size() > 0) return errors;

        if (!action.equals("Login") && !action.equals("Register"))
			errors.add("Invalid button");
		if (!password.equals(confirmpassword)) {
			errors.add("Passwords do not match");
		}
		
        return errors;
    }
}
