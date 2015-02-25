package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.beans.Categoria;
import modelo.beans.Producto;
import modelo.conexion.MySQLConnection;

public class ProductoDao extends Dao {
	private Categoria categoria = new Categoria();
	private Producto producto = new Producto();
	
	// consultas: alias a las entidades que se propagan
	
	
	
	/** Method for SELECT Statements */
	private ArrayList<Producto> query(String sql) {
		conex = new MySQLConnection();
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		try {
			Statement stm = conex.getConnection().createStatement();
			ResultSet res = stm.executeQuery(sql);
			while(res.next()){
				existe = true;
				categoria.setId(res.getInt("idCat"));
				categoria.setNombre(res.getString("nombreCat"));
				
				producto.setId(res.getInt("id"));
				producto.setNombre(res.getString("nombre"));
				producto.setDescripcion(res.getString("descripcion"));
				producto.setPrecio(res.getDouble("precio"));
				producto.setImagen(res.getString("imagen"));
				producto.setCategoria(categoria);
				productos.add(producto);
			}
			stm.close();
			conex.disconnect();
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return (existe) ? productos : null;
	}
}
