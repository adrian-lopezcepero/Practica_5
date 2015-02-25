package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.beans.Usuario;
import modelo.conexion.MySQLConnection;

public class UsuarioDao extends Dao {
	private Usuario usuario = new Usuario();

	public boolean insertUsuario(Usuario usuario) {
		String sql = "INSERT INTO usuario VALUES( " + "nombre="
				+ usuario.getNombre() + "apellidos=" + usuario.getApellidos()
				+ "dirección=" + usuario.getDireccion() + "alias="
				+ usuario.getAlias() + "clave=" + usuario.getClave() + "email="
				+ usuario.getEmail() + ")";
		return modify(sql);
	}

	public boolean updateUsuario(Usuario usuario) {
		String format = "UPDATE usuario SET " + "nobmre='%s' "
				+ "apellidos='%s' " + "direccion='$s' " + "alias='%s' "
				+ "clave='%s' " + "email='%s' ";
		String sql = String.format(format, usuario.getNombre(),
				usuario.getApellidos(), usuario.getDireccion(),
				usuario.getAlias(), usuario.getClave(), usuario.getEmail());
		return modify(sql);
	}

	public boolean deleteUsuario(int id) {
		String format = "DELETE FROM usuario WHERE id=%d";
		String sql = String.format(format, id);
		return modify(sql);
	}

	public ArrayList<Usuario> selectAllUsuarios() {
		String sql = "SELECT * FROM usuario WHERE alias <> 'admin'";
		return query(sql);
	}

	public Usuario selectUsuario(String alias, String clave) {
		String sql = "SELECT * FROM usuario " + "WHERE alias LIKE '" + alias
				+ "' " + "AND clave LIKE '" + clave + "'";
		return query(sql).get(0);
	}

	/** Method for SELECT Statements */
	private ArrayList<Usuario> query(String sql) {
		conex = new MySQLConnection();
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			Statement stm = conex.getConnection().createStatement();
			ResultSet res = stm.executeQuery(sql);
			while (res.next()) {
				existe = true;
				usuario.setId(res.getInt("id"));
				usuario.setNombre(res.getString("nombre"));
				usuario.setApellidos(res.getString("apellidos"));
				usuario.setEmail(res.getString("email"));
				usuario.setAlias(res.getString("alias"));
				usuario.setClave(res.getString("clave"));
				usuario.setDireccion(res.getString("direccio"));
				usuarios.add(usuario);
			}
			stm.close();
			conex.disconnect();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return (existe) ? usuarios : null;
	}
}
