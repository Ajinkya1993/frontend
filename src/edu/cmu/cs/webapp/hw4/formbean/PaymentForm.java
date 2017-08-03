package edu.cmu.cs.webapp.hw4.formbean;

import java.util.ArrayList;
import java.util.List;
import org.mybeans.form.FormBean;

public class PaymentForm extends FormBean {
	private String firstName;
    private String middleName;
    private String lastName;
    private String cardNumber;
    private String cardType;
    private String cardExpiry;
    private String cardCVC;
    private String action;

	public boolean isPresent() {
		if (action == null) {
			return false;
		}
		return action.equals("Subscribe");
	}
	public List<String> getValidationErrors() {
	    List<String> errors = new ArrayList<String>();
	
	    if (firstName == null || firstName.length() == 0)
			errors.add("First Name is required");
		if (lastName == null || lastName.length() == 0)
			errors.add("Last Name is required");
	    if (action == null) errors.add("Button is required");
	
	    if (errors.size() > 0) return errors;
	
	    if (!action.equals("Subscribe"))
			errors.add("Invalid button");
		
	    return errors;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardExpiry() {
		return cardExpiry;
	}
	public void setCardExpiry(String cardExpiry) {
		this.cardExpiry = cardExpiry;
	}
	public String getCardCVC() {
		return cardCVC;
	}
	public void setCardCVC(String cardCVC) {
		this.cardCVC = cardCVC;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
}
