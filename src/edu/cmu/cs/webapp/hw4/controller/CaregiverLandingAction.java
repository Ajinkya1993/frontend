package edu.cmu.cs.webapp.hw4.controller;

import javax.servlet.http.HttpServletRequest;

import edu.cmu.cs.webapp.hw4.databean.SessionBean;

public class CaregiverLandingAction extends Action {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "caregiverLanding.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		SessionBean sessionBean = (SessionBean) request.getSession().getAttribute("session");
		if (sessionBean == null) {
			sessionBean = new SessionBean();
		}
		
		// Set 'caregiverType' session attribute
		String type = request.getParameter("caregiverType");
		if (type != null) {
			sessionBean.setCaregiverType(Integer.parseInt(type));
		}
		if (request.getParameter("register") != null) {
			// Set 'serviceChosen' session attribute
			String[] services = request.getParameterValues("services");

			StringBuilder servicesStr = new StringBuilder();
			if (services != null) {
				for (String service : services) {
					servicesStr.append(service + ",");
				}
			}
			sessionBean.setServiceChosen(servicesStr.toString());
			// Set 'getGuide' session attribute
			if (request.getParameter("getGuide") == null) {
				sessionBean.setGetGuide(false);
			} else {
				sessionBean.setGetGuide(true);
			}
			request.getSession().setAttribute("session", sessionBean);
			return "register.do";
		}
		request.getSession().setAttribute("session", sessionBean);
		return "caregiverLanding.jsp";
	}

}
