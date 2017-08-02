package edu.cmu.cs.webapp.hw4.controller;

import javax.servlet.http.HttpServletRequest;

public class RegisterEducationAction extends Action {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "registerEducation.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return "registerEducation.jsp";
	}

}
