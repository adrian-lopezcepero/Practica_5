package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.beans.UserBean;
import model.conection.MySQLConnection;

public class UserDao extends Dao {

	public boolean insertUsuario(UserBean userBean) {
		String sql = "INSERT INTO usuario SET nombre='"
				+ userBean.getNombre() + "',apellidos='"
				+ userBean.getApellidos() + "',direccion='"
				+ userBean.getDireccion() + "',alias='"
				+ userBean.getAlias() + "',clave='" + userBean.getClave()
				+ "',email='" + userBean.getEmail() + "'";
		System.out.println(sql);
		return modify(sql);
	}

	public boolean updateUsuario(UserBean userBean) {
		String format = "UPDATE usuario SET " + "nombre='%s', "
				+ "apellidos='%s', " + "direccion='%s', " + "alias='%s', "
				+ "clave='%s', " + "email='%s' WHERE id=%d";
		String sql = String.format(format, userBean.getNombre(),
				userBean.getApellidos(), userBean.getDireccion(),
				userBean.getAlias(), userBean.getClave(),
				userBean.getEmail(),userBean.getId());
		return modify(sql);
	}

	public boolean deleteUsuario(int id) {
		String format = "DELETE FROM usuario WHERE id=%d";
		String sql = String.format(format, id);
		return modify(sql);
	}

	public ArrayList<UserBean> selectAllUsuarios() {
		String sql = "SELECT * FROM usuario WHERE alias <> 'admin'";
		return query(sql);
	}

	public UserBean selectUsuario(String alias, String clave) {
		String sql = "SELECT * FROM usuario " + "WHERE alias LIKE '" + alias
				+ "' " + "AND clave LIKE '" + clave + "'";
		return query(sql) != null && query(sql).size() != 0 ? query(sql).get(0) : null;
	}

	/** Method for SELECT Statements */
	private ArrayList<UserBean> query(String sql) {
		conex = new MySQLConnection();
		ArrayList<UserBean> userBeans = new ArrayList<UserBean>();

		try {
			Statement stm = conex.getConnection().createStatement();
			ResultSet res = stm.executeQuery(sql);
			while (res.next()) {
				existe = true;
				UserBean userBean = new UserBean();
				userBean.setId(res.getInt("id"));
				userBean.setNombre(res.getString("nombre"));
				userBean.setApellidos(res.getString("apellidos"));
				userBean.setEmail(res.getString("email"));
				userBean.setAlias(res.getString("alias"));
				userBean.setClave(res.getString("clave"));
				userBean.setDireccion(res.getString("direccion"));
				userBeans.add(userBean);
			}
			stm.close();
			conex.disconnect();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return (existe) ? userBeans : null;
	}
}
