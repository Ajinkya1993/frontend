// Name: Namita Sibal Date: 12/14/16 Course Number: 08672
package edu.cmu.cs.webapp.hw4.model;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import edu.cmu.cs.webapp.hw4.databean.FavoriteBean;
import edu.cmu.cs.webapp.hw4.databean.UserBean;

public class Model {
	private FavoriteDAO itemDAO;
	private UserDAO userDAO;

	public Model(ServletConfig config) throws ServletException {
		try {
			String jdbcDriver = config.getInitParameter("jdbcDriverName");
			String jdbcURL    = config.getInitParameter("jdbcURL");
			
			ConnectionPool pool = new ConnectionPool(jdbcDriver,jdbcURL);
			
			userDAO  = new UserDAO(pool, "namitas_user");
			itemDAO = new FavoriteDAO(pool, "namitas_favorite");
			int nusers = (int)userDAO.getCount();
            	for (int i=nusers; i<3; i++) {
            		UserBean u = new UserBean();
            		u.setEmailaddress(new String("emailaddress" + i));
            		u.setFirstname(new String("firstname" + i));
            		u.setLastname(new String("lastname" + i));
            		u.setPassword(new String("password" + i));
            		userDAO.create(u);
            		//System.out.println(i);
            		UserBean[] users = userDAO.match(MatchArg.equals("emailaddress", u.getEmailaddress()));
            		FavoriteBean favorite = new FavoriteBean();
            		for (int k=0; k<4; k++) {
	            		favorite.setUserid(users[0].getUserid());
	            		favorite.setUrl(new String("http://www." + k + "amazon.com"));
	            		favorite.setComment(new String("Favorite #: " + k));
	            		favorite.setClickcount(0);
	            		itemDAO.create(favorite);
	            		//System.out.println(k);
            		}
            	}
            
		} catch (DAOException e) {
			throw new ServletException(e);
		} catch (RollbackException f) {
        	throw new ServletException(f);
        }
	}
	
	public FavoriteDAO getItemDAO()  { return itemDAO; }
	
	public UserDAO getUserDAO()  { return userDAO; }
}
