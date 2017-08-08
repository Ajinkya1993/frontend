package edu.cmu.cs.webapp.hw4.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import edu.cmu.cs.webapp.hw4.databean.DocumentPeopleBean;
import edu.cmu.cs.webapp.hw4.databean.SessionBean;

public class ChangeAccessAction extends Action {

    @Override
    public String getName() {
        return "changeAccess.do";
    }

    @Override
    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<>();
        HttpSession session = request.getSession();
        SessionBean sessionBean = (SessionBean) request.getSession().getAttribute("session");
        request.setAttribute("curTab", "document");
//      if (sessionBean == null) {
//      errors.add("Session expired. Please log in.");
//      return "login.jsp";
//      }
        
        JSONObject object = new JSONObject();
        JSONObject responseObj = new JSONObject();
        List<DocumentPeopleBean> memberList = (List<DocumentPeopleBean>) session.getAttribute("documentPeople");
        
        try {
            //email, targetEmail, circleId, service, documentName, documentUrl
            object.put("email", sessionBean.getEmail());
            object.put("targetEmail", memberList.get(0).getEmail());
        } catch(JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
