// Name: Namita Sibal Date: 12/14/16 Course Number: 08672
package edu.cmu.cs.webapp.hw4.controller;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.cs.webapp.hw4.databean.FavoriteBean;
import edu.cmu.cs.webapp.hw4.databean.UserBean;
import edu.cmu.cs.webapp.hw4.formbean.FavoriteForm;
import edu.cmu.cs.webapp.hw4.model.FavoriteDAO;
import edu.cmu.cs.webapp.hw4.model.Model;
import edu.cmu.cs.webapp.hw4.model.UserDAO;

public class AddAction extends Action {
	private FormBeanFactory<FavoriteForm>  itemFormFactory  = FormBeanFactory.getInstance(FavoriteForm.class);
	
	private FavoriteDAO itemDAO;
	private UserDAO userDAO;

	public AddAction(Model model) {
		itemDAO = model.getItemDAO();
		userDAO = model.getUserDAO();
	}

	public String getName() { return "add.do"; }
    
    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        HttpSession session = request.getSession();
        UserBean u = (UserBean) session.getAttribute("user");
        try {
        	request.setAttribute("userlist", userDAO.getUsers());
        } catch (RollbackException e) {
        	errors.add(e.getMessage());
        }
        if (session.getAttribute("user")==null) {
        	return "login.jsp";
        }

        try {
            // Fetch the items now, so that in case there is no form or there
            // are errors
            // We can just dispatch to the JSP to show the item list (and any
            // errors)
            request.setAttribute("favorites", itemDAO.getUserFavorites(u.getUserid()));

            FavoriteForm form = itemFormFactory.create(request);
            request.setAttribute("form", form);

            errors.addAll(form.getValidationErrors());
            if (errors.size() > 0) {
                return "todolist.jsp";
            }

            FavoriteBean bean = new FavoriteBean();
            bean.setUrl(form.getUrl());
            bean.setComment(form.getComment());
            bean.setUserid((u.getUserid()));

            if (form.getAction().equals("Add to Favorites")) {
                itemDAO.create(bean);
            } else {
                errors.add("Invalid action: " + form.getAction());
            }

            // Fetch the items again, since we modified the list
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
