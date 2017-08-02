package edu.cmu.cs.webapp.hw4.formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class InvitationForm extends FormBean {
    private String email;
    private String action;

    public String getAction() {
        return action;
    }

    public String getEmail() {
        return email;
    }
    
    public void setAction(String action) {
        this.action = action;
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }
    
    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();
        if (email == null || email.length() == 0) {
            errors.add("Please enter an email to invite people!");
        }
        if (errors.size() > 0) {
            return errors;
        }
        if (!action.equals("Send Invitation")) {
            errors.add("Invalid Button");
        }
        return errors;
    }
}
