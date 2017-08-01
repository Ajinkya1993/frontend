package edu.cmu.cs.webapp.hw4.controller;

import javax.servlet.http.HttpServletRequest;

public class CaregiverLandingAction extends Action {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "caregiverLanding.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.getSession().setAttribute("caregiverType", request.getParameter("caregiverType"));
		if (request.getParameter("register") != null) {
			// Set 'services' session attribute
			String[] services = request.getParameterValues("services");
			request.getSession().setAttribute("services", services);
			for (String service : (String[]) request.getSession().getAttribute("services")) {
				System.out.println(service);
			}
			// Set 'email' session attribute
			request.getSession().setAttribute("email", request.getParameter("email"));
			System.out.println(request.getSession().getAttribute("email"));
			// Set 'getGuide' session attribute
			if (request.getParameter("getGuide") == null) {
				request.getSession().setAttribute("getGuide", false);
				System.out.println(request.getSession().getAttribute("getGuide"));
			} else {
				request.getSession().setAttribute("getGuide", true);
				System.out.println(request.getSession().getAttribute("getGuide"));
			}
			return "register.do";
		}
		return "caregiverLanding.jsp";
	}

}
