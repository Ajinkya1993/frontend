package edu.cmu.cs.webapp.hw4.controller;

import javax.servlet.http.HttpServletRequest;

public class PersonalDashboardAction extends Action {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "personalDashboard.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return "PersonalDashboard.jsp";
	}
}
