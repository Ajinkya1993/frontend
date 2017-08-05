// Name: Namita Sibal Date: 12/14/16 Course Number: 08672
package edu.cmu.cs.webapp.hw4.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void init() throws ServletException {    
        //Model model = new Model(getServletConfig());
    	/*
        Action.add(new AddAction(model));
        Action.add(new ChangePwdAction(model));
        Action.add(new DeleteAction(model));
        Action.add(new LoginAction(model));
        Action.add(new LogoutAction(model));
        Action.add(new NavigateAction(model));  
        Action.add(new RegisterAction(model));
        Action.add(new ToDoListAction(model));
        Action.add(new UpdateAction(model));
        */
        Action.add(new WelcomeAction());
        Action.add(new RegisterAction());
        Action.add(new LoginAction());
        Action.add(new CaregiverLandingAction());
        Action.add(new SeniorHousingOverviewAction());
        Action.add(new CareteamDashboardAction());
        Action.add(new PersonalDashboardAction());
        Action.add(new CreateTeamAction());
        Action.add(new PaymentAction());
        Action.add(new RegisterEducationAction());
        Action.add(new InviteAction());

        Action.add(new AddCareteamAction());
        Action.add(new DeleteCareteamAction());
        
        Action.add(new ManageSeniorHousing());
        Action.add(new AddSeniorHousingPrfAction());
        Action.add(new EditSeniorHousingPrfAction());
        Action.add(new ManageServices());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nextPage = performTheAction(request);
        sendToNextPage(nextPage, request, response);
    }

    /*
     * Extracts the requested action and (depending on whether the user is
     * logged in) perform it (or make the user login).
     * 
     * @param request
     * 
     * @return the next page (the view)
     */
    private String performTheAction(HttpServletRequest request) {
        //HttpSession session = request.getSession(true);
        String servletPath = request.getServletPath();
        //UserBean user = (UserBean) session.getAttribute("user");
        String action = getActionName(servletPath);

        /*if (user == null) {
        	return Action.perform("login.do", request);
        }*/
        // Let the logged in user run his chosen action
        return Action.perform(action, request);
    }

    /*
     * If nextPage is null, send back 404 If nextPage ends with ".do", redirect
     * to this page. If nextPage ends with ".jsp", dispatch (forward) to the
     * page (the view) This is the common case
     */
    private void sendToNextPage(String nextPage, HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        if (nextPage == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND,
                    request.getServletPath());
            return;
        }

        if (nextPage.endsWith(".do")) {
            response.sendRedirect(nextPage);
            return;
        }

        if (nextPage.endsWith(".jsp")) {
        	RequestDispatcher d = request.getRequestDispatcher("WEB-INF/JSP/" + nextPage);
            d.forward(request, response);
            return;
        }
        
        if (nextPage.startsWith("http")) {
        	response.sendRedirect(nextPage);
            return;
        }

        throw new ServletException(Controller.class.getName()
                + ".sendToNextPage(\"" + nextPage + "\"): invalid extension.");
    }

    /*
     * Returns the path component after the last slash removing any "extension"
     * if present.
     */
    private String getActionName(String path) {
        // We're guaranteed that the path will start with a slash
        int slash = path.lastIndexOf('/');
        int query = path.lastIndexOf('?');
        if (query == -1) {
        	return path.substring(slash + 1);
        } else {
        	return path.substring(slash + 1, query);
        }
    }
}
