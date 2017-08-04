package edu.cmu.cs.webapp.hw4.formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class InvitationForm extends FormBean {
    private String emailToAdd;
    private String action;

    public String getAction() {
        return action;
    }

    public String getEmailToAdd() {
        return emailToAdd;
    }
    
    public void setAction(String action) {
        this.action = action;
    }

    public void setEmailToAdd(String emailToAdd) {
        this.emailToAdd = emailToAdd.trim();
    }
    
    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();
        if (emailToAdd == null || emailToAdd.length() == 0) {
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
