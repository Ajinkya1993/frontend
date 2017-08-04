package edu.cmu.cs.webapp.hw4.formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class SeniorHousingPrfForm extends FormBean {
	private String price;
	private String location;
	private String action;
	public boolean isPresent() {
		if (action == null) {
			return false;
		}
		return action.equals("Submit");
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();

        if (location == null || location.length() == 0 || price == null || price.length() == 0) {
        	errors.add("At least one field is required.");
        }
		
        return errors;
    }
}
