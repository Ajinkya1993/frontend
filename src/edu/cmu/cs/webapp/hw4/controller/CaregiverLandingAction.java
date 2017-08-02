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
			StringBuilder servicesStr = new StringBuilder();
			if (services != null) {
				for (String service : services) {
					servicesStr.append(service + ",");
				}
			}
			request.getSession().setAttribute("services", servicesStr.toString());
			System.out.println(request.getSession().getAttribute("services"));
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
			return "registerEducation.do";
		}
		return "caregiverLanding.jsp";
	}

}
