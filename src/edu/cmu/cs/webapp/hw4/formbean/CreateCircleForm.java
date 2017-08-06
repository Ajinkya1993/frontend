package edu.cmu.cs.webapp.hw4.formbean;

import java.util.ArrayList;
import java.util.List;
import org.mybeans.form.FormBean;

public class CreateCircleForm extends FormBean {
	private String teamname;
	private String lovefirstname;
	private String lovelastname;
	private String lovephoto;
    private String loveaddress;
    private String relation;
    private String georelation;
    private String event;
    private String action;
    
    public boolean isPresent() {
    	if (action == null) {
    		return false;
    	}
    	return action.equals("Create Team");
    }
    
    public String getTeamname() {
		return teamname;
	}
    public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
    public String getLovefirstname() {
		return lovefirstname;
	}

	public void setLovefirstname(String lovefirstname) {
		this.lovefirstname = lovefirstname;
	}

	public String getLovelastname() {
		return lovelastname;
	}

	public void setLovelastname(String lovelastname) {
		this.lovelastname = lovelastname;
	}

	public String getLovephoto() {
		return lovephoto;
	}

	public void setLovephoto(String lovephoto) {
		this.lovephoto = lovephoto;
	}
	public String getLoveaddress() {
		return loveaddress;
	}
	public void setLoveaddress(String loveaddress) {
		this.loveaddress = loveaddress;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getGeorelation() {
		return georelation;
	}
	public void setGeorelation(String georelation) {
		this.georelation = georelation;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
    
    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();

        if (teamname == null || teamname.length() == 0) errors.add("Team Name is required");
        if (action == null) errors.add("Button is required");

        if (errors.size() > 0) return errors;
        
        if (!action.equals("Create Team")) {
        	errors.add("Invalid button");
        }
		
        return errors;
    }
    
    
}
