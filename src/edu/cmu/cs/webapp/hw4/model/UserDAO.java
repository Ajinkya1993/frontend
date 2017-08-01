// Name: Namita Sibal Date: 12/14/16 Course Number: 08672
package edu.cmu.cs.webapp.hw4.model;
import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;

import edu.cmu.cs.webapp.hw4.databean.UserBean;

public class UserDAO extends GenericDAO<UserBean> {
	public UserDAO(ConnectionPool cp, String tableName) throws DAOException {
		super(UserBean.class, tableName, cp);
	}
	public void create(UserBean u) throws RollbackException {
		try {
			Transaction.begin();
			UserBean a[] = match(MatchArg.equals("emailaddress", u.getEmailaddress()));
				if(a != null && a.length > 0) {throw new RollbackException("This email address already exists");}
				super.create(u);
			Transaction.commit();
	}
	finally {
		if(Transaction.isActive()) Transaction.rollback();
	}
	}
	
	public UserBean read(String email) throws RollbackException {
		UserBean a[] = match(MatchArg.equals("emailaddress", email));
		if(a == null || a.length == 0) {
			throw new RollbackException("Invalid email address");
		}
		if (a.length > 1) {
			throw new RollbackException("Multiple users with same email addres");
		}
		return a[0];
	}
	
	 public UserBean setNewPassword(String email, String password) throws RollbackException {
	        try {
	            Transaction.begin();
	            UserBean[] b = (UserBean[])match(MatchArg.equals("emailaddress", email));

	            if (b == null || b.length == 0) {
	                throw new RollbackException("No user exists for " + email);
	            }

	            b[0].setPassword(password);

	            update(b[0]);
	            Transaction.commit();
	            
	            return b[0];
	        } finally {
	            if (Transaction.isActive()) Transaction.rollback();
	        }
	    }
	 public UserBean[] getUsers() throws RollbackException {
	        UserBean[] users = match();
	        return users;
	    }
}
