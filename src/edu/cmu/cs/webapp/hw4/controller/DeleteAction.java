// Name: Namita Sibal Date: 12/14/16 Course Number: 08672
package edu.cmu.cs.webapp.hw4.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.cs.webapp.hw4.databean.UserBean;
import edu.cmu.cs.webapp.hw4.formbean.IdForm;
import edu.cmu.cs.webapp.hw4.model.FavoriteDAO;
import edu.cmu.cs.webapp.hw4.model.Model;
import edu.cmu.cs.webapp.hw4.model.UserDAO;

public class DeleteAction extends Action {
	private FormBeanFactory<IdForm> idFormFactory = FormBeanFactory.getInstance(IdForm.class);

	private FavoriteDAO itemDAO;
	private UserDAO userDAO;

	public DeleteAction(Model model) {
		itemDAO = model.getItemDAO();
		userDAO = model.getUserDAO();
	}

	public String getName() {
		return "delete.do";
	}

	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		UserBean u = (UserBean) request.getSession().getAttribute("user");
		try {
        	request.setAttribute("userlist", userDAO.getUsers());
    } catch (RollbackException e) {
        	errors.add(e.getMessage());
    }
	 
	if (u == null) {
		errors.add("You can't delete any item without logging in");
		return "login.jsp";
	}
		try {
			IdForm form = idFormFactory.create(request);
			errors.addAll(form.getValidationErrors());
			if (errors.size() > 0) {
				return "error.jsp";
			}

			itemDAO.delete(form.getIdAsInt());
			request.setAttribute("favorites", itemDAO.getUserFavorites(u.getUserid()));	
			return "todolist.jsp";

		} catch (RollbackException e) {
			errors.add(e.getMessage());
			return "error.jsp";
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "error.jsp";
		}
	}
}
