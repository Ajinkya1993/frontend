// Name: Namita Sibal Date: 12/14/16 Course Number: 08672
package edu.cmu.cs.webapp.hw4.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.cs.webapp.hw4.formbean.FavoriteForm;
import edu.cmu.cs.webapp.hw4.model.FavoriteDAO;
import edu.cmu.cs.webapp.hw4.model.Model;
import edu.cmu.cs.webapp.hw4.model.UserDAO;

public class UpdateAction extends Action {
    private FormBeanFactory<FavoriteForm> favoriteFormFactory = FormBeanFactory
            .getInstance(FavoriteForm.class);

    private FavoriteDAO favoriteDAO;
    private UserDAO userDAO;

    public UpdateAction(Model model) {
        favoriteDAO = model.getItemDAO();
        userDAO = model.getUserDAO();
    }

    public String getName() {
        return "update.do";
    }

    public String perform(HttpServletRequest request) {
    	
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);
        try {
        	request.setAttribute("userlist", userDAO.getUsers());
        } catch (RollbackException e) {
        	errors.add(e.getMessage());
        }
       
        try {
            // Fetch the items now, so that in case there is no form or there
            // are errors
            // We can just dispatch to the JSP to show the item list (and any
            // errors)
        	if (request.getParameter("updateid") != null) {
        		try {
        			int favid = Integer.parseInt(request.getParameter("updateid"));
        			Transaction.begin();
        			favoriteDAO.update(favid);
        			Transaction.commit();
        			
        		} catch (NumberFormatException e) {
        			errors.add("update ID is not a number");
        		} finally {
        			if (Transaction.isActive()){
        				Transaction.rollback();
        			}
        		}
        	}
            //request.setAttribute("favorites", favoriteDAO.getUserFavorites(user.getUserId()));

            FavoriteForm form = favoriteFormFactory.create(request);
            request.setAttribute("form", form);

            //errors.addAll(form.getValidationErrors());
            if (errors.size() > 0) {
                return "error.jsp";
            }
            
            // Fetch the items again, since we modified the list
            //request.setAttribute("favorites", favoriteDAO.getUserFavorites(user.getUserId()));
            
            if (request.getParameter("link") != null) {
            	return request.getParameter("link");
            } else {
            	errors.add("do not change request parameter");
            }
            return "error.jsp";

        } catch (RollbackException e) {
            errors.add(e.getMessage());
            return "error.jsp";
        } catch (FormBeanException e) {
            errors.add(e.getMessage());
            return "error.jsp";
        }
    }
}
