package modelo.beans;

import java.io.Serializable;
import java.util.ArrayList;


public class UsuariosBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<UsuarioBean> loggedUsers;
	
	
	public UsuariosBean() {
		// TODO Auto-generated constructor stub
		this.loggedUsers = new ArrayList<UsuarioBean>();
	}
	
	public ArrayList<UsuarioBean> getLoggedUsers() {
		return loggedUsers;
	}
	public void setLoggedUsers(ArrayList<UsuarioBean> loggedUsers) {
		this.loggedUsers = loggedUsers;
	}
	
	public boolean deleteUser(UsuarioBean usuarioBean) {
		for (int i = 0; i < loggedUsers.size(); i++) {
			UsuarioBean usuario = loggedUsers.get(i);
			if (usuarioBean.getId() == usuario.getId()) {
				loggedUsers.remove(i);
				return true;
			}
		}
		return false;
	}
	
}
