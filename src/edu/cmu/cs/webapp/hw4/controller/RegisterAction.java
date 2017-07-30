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
import edu.cmu.cs.webapp.hw4.formbean.RegisterForm;
import edu.cmu.cs.webapp.hw4.model.Model;
import edu.cmu.cs.webapp.hw4.model.UserDAO;


public class RegisterAction extends Action {
    private FormBeanFactory<RegisterForm> formBeanFactory = FormBeanFactory.getInstance(RegisterForm.class);

    private UserDAO userDAO;

    public RegisterAction(Model model) {
        userDAO = model.getUserDAO();
    }

    public String getName() {
        return "register.do";
    }

    public String perform(HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);

        try {
        	request.setAttribute("userlist", userDAO.getUsers());
        } catch (RollbackException e) {
        	errors.add(e.getMessage());
        }

        // If user is already logged in, redirect to todolist.do
        if (session.getAttribute("user") != null) {
            return "todolist.do";
        }

        try {
            RegisterForm form = formBeanFactory.create(request);
            request.setAttribute("form", form);

            // If no params were passed, return with no errors so that the form will be
            // presented (we assume for the first time).
            if (!form.isPresent()) {
                return "register.jsp";
            }

            // Any validation errors?
            errors.addAll(form.getValidationErrors());
            if (errors.size() != 0) {
                return "register.jsp";
            }

            if (form.getAction().equals("Register")) {
                UserBean newUser = new UserBean();
                newUser.setEmailaddress(form.getEmailaddress());
                newUser.setFirstname(form.getFirstname());
				newUser.setLastname(form.getLastname());
                newUser.setPassword(form.getPassword());
                userDAO.create(newUser);
                session.setAttribute("user", newUser);
                return "todolist.do";
            } else {
            	return "register.jsp";
            }
        } catch (RollbackException e) {
            errors.add(e.getMessage());
            return "register.jsp";
        } catch (FormBeanException e) {
            errors.add(e.getMessage());
            return "register.jsp";
        }
    }
}
