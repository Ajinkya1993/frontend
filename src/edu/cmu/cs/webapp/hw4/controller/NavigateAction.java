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

public class NavigateAction extends Action {
	
	private FavoriteDAO favoriteDAO;
    private UserDAO userDAO;

    public NavigateAction(Model model) {
        favoriteDAO = model.getItemDAO();
        userDAO = model.getUserDAO();
    }

    public String getName() {
        return "navigate.do";
    }
    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);
        try {
        	request.setAttribute("userlist", userDAO.getUsers());
        } catch (RollbackException e) {
        	errors.add(e.getMessage());
        }
        HttpSession session = request.getSession();
        UserBean user = (UserBean)session.getAttribute("user");
        if (user == null) {
        	if (request.getParameter("navact").equals("login")) {
	        	return "login.jsp";
	        } else if (request.getParameter("navact").equals("register")) {
	        	return "register.jsp";
	        } else if (request.getParameter("navact").equals("otherslist")) {
	        	try {
	    	        if (request.getParameter("uid") != null) {
	    	        	try {
	    	        		int userid = Integer.parseInt(request.getParameter("uid"));
	    	        		request.setAttribute("favorites", favoriteDAO.getUserFavorites(userid));
	    	        		UserBean otherusr = userDAO.read(userid);
	    	        		request.setAttribute("guestlname", otherusr.getLastname());
	    	        		request.setAttribute("guestfname", otherusr.getFirstname());
	    		            return ("otheruserslist.jsp");
	    	        	} catch (NumberFormatException e) {
	    	        		errors.add("No details for this user");
	    	        		return "error.jsp";
	    	        	}
	    	        } else {
	    	        	errors.add("No information corresponding to this user");
	    	        	return "error.jsp";
	    	        }
	            } catch (RollbackException e) {
	            	errors.add(e.getMessage());
	            	return "error.jsp";
	            }
	        } else {
        		errors.add("Navigation bar cannot perform this action");
        		return "error.jsp";
        	}
        } else {
        	if (request.getParameter("navact").equals("myfav")) {
        		try {
     	            request.setAttribute("favorites", favoriteDAO.getUserFavorites(user.getUserid()));
     	            return ("todolist.jsp");
     	        } catch (RollbackException e) {
     	            errors.add(e.getMessage());
     	            return "error.jsp";
     	        }
        	} else if (request.getParameter("navact").equals("logout")) {
                session.setAttribute("user", null);
                return "login.jsp";
        	} else if (request.getParameter("navact").equals("otherslist")) {
        		try {
        	        if (request.getParameter("uid") != null) {
        	        	try {
        	        		int userid = Integer.parseInt(request.getParameter("uid"));
        	        		request.setAttribute("favorites", favoriteDAO.getUserFavorites(userid));
        	        		UserBean otheruser = userDAO.read(userid);
        	        		request.setAttribute("guestfname", otheruser.getFirstname());
        		            request.setAttribute("guestlname", otheruser.getFirstname());
        		            return ("otheruserslist.jsp");
        	        	} catch (NumberFormatException e) {
        	        		errors.add("No information corresponding to this user");
        	        		return "error.jsp";
        	        	}
        	        } else {
	    	        	errors.add("No information corresponding to this user");
	    	        	return "error.jsp";
	    	        }
                } catch (RollbackException e) {
                	errors.add(e.getMessage());
                	return "error.jsp";
                }
	        } else if (request.getParameter("navact").equals("change-pwd")) {
	        	try {
     	            request.setAttribute("favorites", favoriteDAO.getUserFavorites(user.getUserid()));
     	            return ("change-pwd.jsp");
     	        } catch (RollbackException e) {
     	            errors.add(e.getMessage());
     	            return "error.jsp";
     	        }
        	} else {
        		errors.add("Navigation bar cannot perform this action");
        		return "error.jsp";
        	}
        }
    }
}