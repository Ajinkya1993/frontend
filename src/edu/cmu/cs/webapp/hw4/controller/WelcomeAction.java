package edu.cmu.cs.webapp.hw4.controller;

import javax.servlet.http.HttpServletRequest;


/**
 * @author Ajinkya Nimbalkar (2nd May 2017)
 */
public class WelcomeAction extends Action {

    public WelcomeAction() {
        
    }

    @Override
    public String getName() {
        return "welcome.do";
    }

    @Override
    public String perform(HttpServletRequest request) {
        return "PersonalDashboard.jsp";
    }
}
