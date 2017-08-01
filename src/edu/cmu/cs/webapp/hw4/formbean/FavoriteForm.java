// Name: Namita Sibal Date: 12/14/16 Course Number: 08672
package edu.cmu.cs.webapp.hw4.formbean;

import java.util.ArrayList;
import java.util.List;
import org.mybeans.form.FormBean;

public class FavoriteForm extends FormBean{
    private String url;
    private String comment;
    private String action;
    
    public String getAction() {
    	return action;
    }
    public String getUrl() {
        return url;
    }
    public void setAction(String s) {
        action = s;
    }
    public void setUrl(String s) {
    	String a  = sanitize(s);
        url = a;
    }
    public String getComment() {
        return comment;
    }

    public void setComment(String s) {
    	String a  = sanitize(s);
        comment = a;
    }
    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();
        
        if (action == null || action.length() == 0) {
            errors.add("Action is required");
        }

        if (url == null || url.length() == 0) {
            errors.add("Url is required");
        }
        return errors;

    }
    private String sanitize(String s) {
        return s.replace("&", "&amp;").replace("<", "&lt;")
                .replace(">", "&gt;").replace("\"", "&quot;");
    }
}
