package edu.cmu.cs.webapp.hw4.databean;

public class SessionBean {
	private String firstName;
	private String lastName;
	private String email;
	private String serviceChosen;
	private String circleName;
	private long circleId;
	private int caregiverType;
	private boolean getGuide;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getServiceChosen() {
		return serviceChosen;
	}
	public void setServiceChosen(String serviceChosen) {
		this.serviceChosen = serviceChosen;
	}
	public String getCircleName() {
		return circleName;
	}
	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}
	public long getCircleId() {
		return circleId;
	}
	public void setCircleId(long circleId) {
		this.circleId = circleId;
	}
	public int getCaregiverType() {
		return caregiverType;
	}
	public void setCaregiverType(int caregiverType) {
		this.caregiverType = caregiverType;
	}
	public boolean isGetGuide() {
		return getGuide;
	}
	public void setGetGuide(boolean getGuide) {
		this.getGuide = getGuide;
	}
}
