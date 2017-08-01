// Name: Namita Sibal Date: 12/14/16 Course Number: 08672
package edu.cmu.cs.webapp.hw4.formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class ChangePwdForm extends FormBean {
	private String confirmpassword;
	private String newpassword;
	
	public String getConfirmpassword() { return confirmpassword; }
	public String getNewpassword()     { return newpassword;     }
	
	public void setConfirmpassword(String s) { confirmpassword = s.trim(); }
	public void setNewpassword(String s)     { newpassword     = s.trim(); }

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (newpassword == null || newpassword.length() == 0) {
			errors.add("New Password is required");
		}
		
		if (confirmpassword == null || confirmpassword.length() == 0) {
			errors.add("Confirm Password is required");
		}
		
		if (errors.size() > 0) {
			return errors;
		}
		
		if (!newpassword.equals(confirmpassword)) {
			errors.add("Passwords Mismatch");
		}

		return errors;
	}
}

