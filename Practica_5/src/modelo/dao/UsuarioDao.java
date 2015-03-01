package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.beans.UsuarioBean;
import modelo.conexion.MySQLConnection;

public class UsuarioDao extends Dao {
	private UsuarioBean usuarioBean = new UsuarioBean();

	public boolean insertUsuario(UsuarioBean usuarioBean) {
		String sql = "INSERT INTO usuario SET nombre='"
				+ usuarioBean.getNombre() + "',apellidos='"
				+ usuarioBean.getApellidos() + "',direccion='"
				+ usuarioBean.getDireccion() + "',alias='"
				+ usuarioBean.getAlias() + "',clave='" + usuarioBean.getClave()
				+ "',email='" + usuarioBean.getEmail() + "'";
		System.out.println(sql);
		return modify(sql);
	}

	public boolean updateUsuario(UsuarioBean usuarioBean) {
		String format = "UPDATE usuario SET " + "nombre='%s', "
				+ "apellidos='%s', " + "direccion='%s', " + "alias='%s', "
				+ "clave='%s', " + "email='%s' WHERE id=%d";
		String sql = String.format(format, usuarioBean.getNombre(),
				usuarioBean.getApellidos(), usuarioBean.getDireccion(),
				usuarioBean.getAlias(), usuarioBean.getClave(),
				usuarioBean.getEmail(),usuarioBean.getId());
		return modify(sql);
	}

	public boolean deleteUsuario(int id) {
		String format = "DELETE FROM usuario WHERE id=%d";
		String sql = String.format(format, id);
		return modify(sql);
	}

	public ArrayList<UsuarioBean> selectAllUsuarios() {
		String sql = "SELECT * FROM usuario WHERE alias <> 'admin'";
		return query(sql);
	}

	public UsuarioBean selectUsuario(String alias, String clave) {
		String sql = "SELECT * FROM usuario " + "WHERE alias LIKE '" + alias
				+ "' " + "AND clave LIKE '" + clave + "'";
		return query(sql) != null ? query(sql).get(0) : null;
	}

	/** Method for SELECT Statements */
	private ArrayList<UsuarioBean> query(String sql) {
		conex = new MySQLConnection();
		ArrayList<UsuarioBean> usuarioBeans = new ArrayList<UsuarioBean>();

		try {
			Statement stm = conex.getConnection().createStatement();
			ResultSet res = stm.executeQuery(sql);
			while (res.next()) {
				existe = true;
				UsuarioBean usuarioBean = new UsuarioBean();
				usuarioBean.setId(res.getInt("id"));
				usuarioBean.setNombre(res.getString("nombre"));
				usuarioBean.setApellidos(res.getString("apellidos"));
				usuarioBean.setEmail(res.getString("email"));
				usuarioBean.setAlias(res.getString("alias"));
				usuarioBean.setClave(res.getString("clave"));
				usuarioBean.setDireccion(res.getString("direccion"));
				usuarioBeans.add(usuarioBean);
			}
			stm.close();
			conex.disconnect();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return (existe) ? usuarioBeans : null;
	}
}
