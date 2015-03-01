package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.beans.CategoriaBean;
import modelo.beans.ProductoBean;
import modelo.conexion.MySQLConnection;

public class ProductoDao extends Dao {
	
	public boolean insertProducto(ProductoBean producto) {
		String sql = "INSERT INTO producto (nombre, descripcion, precio, imagen, idCategoria) "
				   + "VALUES ('" + producto.getNombre() + "', "
				   		   + "'" + producto.getDescripcion() + "', "
				   		   + "'" + producto.getPrecio() + "', "
				   		   + "'" + producto.getImagen() + "', "
				   		   + "'" + producto.getCategoria().getId() + "');";
		return modify(sql);
	}
	
	public boolean updateProducto(ProductoBean producto) {
		String sql = "UPDATE producto "
				   + "SET  nombre =  '" + producto.getNombre() + "', "
				   		+ "descripcion =  '" + producto.getDescripcion() + "', "
				   		+ "precio =  '" + producto.getPrecio() + "', "
				   		+ "imagen =  '" + producto.getImagen() + "',"
				   		+ "idCategoria = '" + producto.getCategoria().getId() + "' "
				   		+ "WHERE  id=" + producto.getId() + ";";
		
		return modify(sql);
	}
	
	public boolean deleteProducto(int id) {
		String sql = "DELETE FROM tutorias WHERE id=" + id;
		return modify(sql);
	}
	
	
	public ProductoBean selectProducto(int id) {
		String sql = "SELECT * "
				   + "FROM producto p, categoria c "
				   + "WHERE p.id=" + id + " "
				   + "AND p.idCategoria = c.id";
		return query(sql).get(0);
	}
	
	public ArrayList<ProductoBean> selectProductos(int idCategoria) {
		String sql = "SELECT * "
				   + "FROM producto p, categoria c "
				   + "WHERE p.idCategoria=" + idCategoria + " "
				   + "AND p.idCategoria = c.id";
		return query(sql);		
	}
	
	public ArrayList<ProductoBean> selectProductosNovedades(int cantidad) {
		String sql = "SELECT * "
				   + "FROM producto p, categoria c "
				   + "WHERE p.idCategoria = c.id "
//				   + "ORDER BY p.id DESC "
				   + "ORDER BY descripcion "
				   + "LIMIT 0 , "+ cantidad + ";";
		return query(sql);		
	}
	
	
	
	/** Method for SELECT Statements */
	private ArrayList<ProductoBean> query(String sql) {
		conex = new MySQLConnection();
		ArrayList<ProductoBean> productoBeans = new ArrayList<ProductoBean>();
		
		try {
			Statement stm = conex.getConnection().createStatement();
			ResultSet res = stm.executeQuery(sql);
			while(res.next()){
				existe = true;
				CategoriaBean categoriaBean = new CategoriaBean();
				categoriaBean.setId(res.getInt("c.id"));
				categoriaBean.setNombre(res.getString("c.nombre"));
				
				ProductoBean productoBean = new ProductoBean();
				productoBean.setId(res.getInt("p.id"));
				productoBean.setNombre(res.getString("p.nombre"));
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
