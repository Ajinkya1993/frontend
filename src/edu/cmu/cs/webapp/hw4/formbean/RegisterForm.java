// Name: Namita Sibal Date: 12/14/16 Course Number: 08672
package edu.cmu.cs.webapp.hw4.formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class RegisterForm extends FormBean{
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    private String password;
    private String confirmPassword;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String phoneNumber;
    private String action;
	
    public String getEmail()  { return email; }
    public String getFirstName()  { return firstName; }
    public String getMiddleName()  { return middleName; }
    public String getLastName()  { return lastName; }
    public String getAddress()  { return address; }
    public String getPassword()  { return password; }
    public String getPhoneNo()  { return phoneNumber; }
    public String getAction()    { return action; }
    public String getConfirmPassword() { return confirmPassword; }
	
    public boolean isPresent() {
		if (action == null) {
			return false;
		}
		return action.equals("Register");
	}
	
    public void setEmail(String s)  { email = s.trim(); }
    public void setFirstName(String s)  { firstName = s.trim(); }
    public void setMiddleName(String s)  { middleName = s.trim(); }
    public void setLastName(String s)  { lastName = s.trim(); }
    public void setPhoneNo(String s)  { phoneNumber = s.trim(); }
    public void setPassword(String s)  { password = s.trim(); }
    public void setConfirmPassword(String s)  { confirmPassword = s.trim(); }
    public void setAction(String s)    { action   = s;        }
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();

        if (email == null || email.length() == 0) errors.add("Email Address is required");
        if (password == null || password.length() == 0) errors.add("Password is required");
        if (firstName == null || firstName.length() == 0)
			errors.add("First Name is required");
		if (lastName == null || lastName.length() == 0)
			errors.add("Last Name is required");
        if (action == null) errors.add("Button is required");

        if (errors.size() > 0) return errors;

        if (!action.equals("Register"))
			errors.add("Invalid button");
		if (!password.equals(confirmPassword)) {
			errors.add("Passwords do not match");
		}
		
        return errors;
    }
}
