package edu.cmu.cs.webapp.hw4.controller;

import javax.servlet.http.HttpServletRequest;

public class SeniorHousingDocManageAction extends Action {
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "seniorHousingDocManage.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		return "SeniorHousingDocument.jsp";
	}
}
