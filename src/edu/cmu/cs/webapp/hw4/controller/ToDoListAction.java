// Name: Namita Sibal Date: 12/14/16 Course Number: 08672
package edu.cmu.cs.webapp.hw4.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;

import edu.cmu.cs.webapp.hw4.databean.UserBean;
import edu.cmu.cs.webapp.hw4.model.FavoriteDAO;
import edu.cmu.cs.webapp.hw4.model.Model;
import edu.cmu.cs.webapp.hw4.model.UserDAO;

public class ToDoListAction extends Action {
	private FavoriteDAO itemDAO;
	private UserDAO userDAO;

	public ToDoListAction(Model model) {
		itemDAO = model.getItemDAO();
		userDAO = model.getUserDAO();
	}

	public String getName() { return "todolist.do"; }
    
    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        try {
        	request.setAttribute("userlist", userDAO.getUsers());
        } catch (RollbackException e) {
        	errors.add(e.getMessage());
        }
        HttpSession session = request.getSession();
       
        if (session.getAttribute("user") == null) {
        	return "login.jsp";
        }
        
        
        UserBean u = (UserBean)session.getAttribute("user");
        if (u != null) {
	        try {
	            request.setAttribute("favorites", itemDAO.getUserFavorites(u.getUserid()));
	            return ("todolist.jsp");
	        } catch (RollbackException e) {
	            errors.add(e.getMessage());
	            return "error.jsp";
	        }
        } else {
        	errors.add("You are not logged in");
        	return ("error.jsp");
        }
    }
}
