package edu.cmu.cs.webapp.hw4.controller;

import javax.servlet.http.HttpServletRequest;

public class EditSeniorHousingPrfAction extends Action {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "editSeniorHousingPrf.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return "SeniorHousingPrfEdit.jsp";
	}

}
