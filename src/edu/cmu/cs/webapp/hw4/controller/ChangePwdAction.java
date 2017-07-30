// Name: Namita Sibal Date: 12/14/16 Course Number: 08672
package edu.cmu.cs.webapp.hw4.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.cs.webapp.hw4.databean.UserBean;
import edu.cmu.cs.webapp.hw4.formbean.ChangePwdForm;
import edu.cmu.cs.webapp.hw4.model.Model;
import edu.cmu.cs.webapp.hw4.model.UserDAO;

public class ChangePwdAction extends Action {
	private FormBeanFactory<ChangePwdForm> formBeanFactory = FormBeanFactory
			.getInstance(ChangePwdForm.class);
	
	private UserDAO userDAO;

	public ChangePwdAction(Model model) {
		userDAO = model.getUserDAO();
	}
	
	public String getName() {
		return "change-pwd.do";
	}

	public String perform(HttpServletRequest request) {
		// Set up error list
		 List<String> errors = new ArrayList<String>();
	        request.setAttribute("errors",errors);
	        
	        try {
	       		// Fetch the items now, so that in case there is no form or there are errors
	       		// We can just dispatch to the JSP to show the item list (and any errors)
	        	request.setAttribute("userlist", userDAO.getUsers());
	       		ChangePwdForm form = formBeanFactory.create(request);
	        	request.setAttribute("form", form);

			// If no params were passed, return with no errors so that the form
			// will be
			// presented (we assume for the first time).
			if (!form.isPresent()) {
				return "change-pwd.jsp";
			}

			// Check for any validation errors
			errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {
				return "change-pwd.jsp";
			}
			
			HttpSession session = request.getSession();
			UserBean user = (UserBean) session.getAttribute("user");

			UserBean updatedUser = userDAO.setNewPassword(user.getEmailaddress(), form.getNewpassword());
			
			session.setAttribute("user", updatedUser);
			request.setAttribute("message", "Password changed for " + user.getFirstname());
			return "success.jsp";
		} catch (RollbackException e) {
			errors.add(e.toString());
			return "error.jsp";
		} catch (FormBeanException e) {
			errors.add(e.toString());
			return "error.jsp";
		}
	}
}
