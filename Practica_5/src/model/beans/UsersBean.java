package model.beans;

import java.io.Serializable;
import java.util.ArrayList;


public class UsersBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<UserBean> loggedUsers;
	
	
	public UsersBean() {
		// TODO Auto-generated constructor stub
		this.loggedUsers = new ArrayList<UserBean>();
	}
	
	public ArrayList<UserBean> getLoggedUsers() {
		return loggedUsers;
	}
	public void setLoggedUsers(ArrayList<UserBean> loggedUsers) {
		this.loggedUsers = loggedUsers;
	}
	
	public boolean deleteUser(UserBean userBean) {
		for (int i = 0; i < loggedUsers.size(); i++) {
			UserBean usuario = loggedUsers.get(i);
			if (userBean.getId() == usuario.getId()) {
				loggedUsers.remove(i);
				return true;
			}
		}
		return false;
	}
	
}
