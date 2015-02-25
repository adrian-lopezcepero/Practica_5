package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.beans.CategoriaBean;
import modelo.beans.ProductoBean;
import modelo.conexion.MySQLConnection;

public class ProductoDao extends Dao {
	private CategoriaBean categoriaBean = new CategoriaBean();
	private ProductoBean productoBean = new ProductoBean();
	
	// consultas: alias a las entidades que se propagan
	
	
	
	/** Method for SELECT Statements */
	private ArrayList<ProductoBean> query(String sql) {
		conex = new MySQLConnection();
		ArrayList<ProductoBean> productoBeans = new ArrayList<ProductoBean>();
		
		try {
			Statement stm = conex.getConnection().createStatement();
			ResultSet res = stm.executeQuery(sql);
			while(res.next()){
				existe = true;
				categoriaBean.setId(res.getInt("idCat"));
				categoriaBean.setNombre(res.getString("nombreCat"));
				
				productoBean.setId(res.getInt("id"));
				productoBean.setNombre(res.getString("nombre"));
				productoBean.setDescripcion(res.getString("descripcion"));
				productoBean.setPrecio(res.getDouble("precio"));
				productoBean.setImagen(res.getString("imagen"));
				productoBean.setCategoria(categoriaBean);
				productoBeans.add(productoBean);
			}
			stm.close();
			conex.disconnect();
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return (existe) ? productoBeans : null;
	}
}
