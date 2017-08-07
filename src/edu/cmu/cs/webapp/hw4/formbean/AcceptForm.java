package edu.cmu.cs.webapp.hw4.formbean;

import org.mybeans.form.FormBean;

public class AcceptForm extends FormBean{
    private String relationship;
    private String geoRel;
    private String action;
    public String getRelationship() {
        return relationship;
    }
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public String getGeoRel() {
        return geoRel;
    }
    public void setGeoRel(String geoRel) {
        this.geoRel = geoRel;
    }
    
}
