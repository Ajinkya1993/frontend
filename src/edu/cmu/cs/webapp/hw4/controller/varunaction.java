
package edu.cmu.cs.webapp.hw4.controller;

import javax.servlet.http.HttpServletRequest;


/**
 * @author Ajinkya Nimbalkar (2nd May 2017)
 */
public class varunaction extends Action {

    public varunaction() {   
    }

    @Override
    public String getName() {
        return "varun.do";
    }

    @Override
    public String perform(HttpServletRequest request) {
        return "dashboard.jsp";
    }
}
