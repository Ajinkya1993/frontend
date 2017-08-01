// Name: Namita Sibal Date: 12/14/16 Course Number: 08672
package edu.cmu.cs.webapp.hw4.model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;

import edu.cmu.cs.webapp.hw4.databean.FavoriteBean;

public class FavoriteDAO extends GenericDAO<FavoriteBean> {
	public FavoriteDAO(ConnectionPool cp, String tableName) throws DAOException {
		super(FavoriteBean.class, tableName, cp);
	}
	public FavoriteBean[] getUserFavorites(int u) throws RollbackException {
		if (u <= 0) {
			throw new RollbackException("Invalid User Id");
		}
			FavoriteBean[] items = match(MatchArg.equals("userid", u));
			return items;
	}
	public void create(FavoriteBean bean) throws RollbackException {
		try {
			Transaction.begin();

			// Get item at top of list
			FavoriteBean[] a = match(MatchArg.min("position"));
			FavoriteBean topBean;
			if (a.length == 0) {
				topBean = null;
			} else {
				topBean = a[0];
			}
			int newPos;
			if (topBean == null) {
				// List is empty...just add it with position = 1
				newPos = 1;
			} else {
				// Create the new item with position one less than the top
				// bean's position
				newPos = topBean.getPosition() - 1;
			}
			bean.setPosition(newPos);
			// Note that GenericDAO.create() will use auto-increment when
			// the primary key field is an int or a long.
			super.create(bean);
			Transaction.commit();
		} finally {
			if (Transaction.isActive())
				Transaction.rollback();
		}
	}
	public void update(int favid) throws RollbackException {
		FavoriteBean[] beans = match(MatchArg.and(MatchArg.equals("favoriteid",favid)));
		if (beans == null || beans.length == 0) {
			throw new RollbackException("No favorites for this ID");			
		}
		if (beans.length > 1) {
			throw new RollbackException("Multiple favorites for this ID");			
		}
		beans[0].setClickcount(beans[0].getClickcount()+1);
		super.update(beans[0]);
		return;
	}
	}
