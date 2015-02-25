package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.beans.Categoria;
import modelo.conexion.MySQLConnection;

public class CategoriaDao extends Dao {
	private Categoria categoria = new Categoria();
	
	
	
	
	
	/** Method for SELECT Statements */
	private ArrayList<Categoria> query(String sql) {
		conex = new MySQLConnection();
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		
		try {
			Statement stm = conex.getConnection().createStatement();
			ResultSet res = stm.executeQuery(sql);
			while(res.next()){
				existe = true;
				categoria.setId(res.getInt("id"));
				categoria.setNombre(res.getString("nombre"));
				categorias.add(categoria);
			}
			stm.close();
			conex.disconnect();
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return (existe) ? categorias : null;
	}
}
