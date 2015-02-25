package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.beans.Categoria;
import modelo.beans.LineaPedido;
import modelo.beans.Pedido;
import modelo.beans.Producto;
import modelo.beans.Usuario;
import modelo.conexion.MySQLConnection;

public class PedidoDao extends Dao {
	private Usuario usuario = new Usuario();
	private Categoria categoria = new Categoria();
	private ArrayList<LineaPedido> lineaPedidos = new ArrayList<LineaPedido>();
	private Pedido pedido = new Pedido();
	
	
	
	
	
	

	
	
/** De momento no tenemos consultas de Pedidos */	
//	/** Method for SELECT Statements */
//	private ArrayList<Pedido> query(String sql) {
//		conex = new MySQLConnection();
//		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
//		
//		try {
//			Statement stm = conex.getConnection().createStatement();
//			ResultSet res = stm.executeQuery(sql);
//			while(res.next()){
//				existe = true;
//				
//				// Usuario
//				
//				// Categoria
//				categoria.setId(res.getInt("idCat"));
//				categoria.setNombre(res.getString("nombreCat"));
//				
//				// Lineas de Pedido
//				
//				
//				// Pedido
//				pedido.setId(res.getInt("id"));
//				pedidos.add(pedido);
//			}
//			stm.close();
//			conex.disconnect();
//		} 
//		catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}		
//		
//		return (existe) ? pedidos : null;
//	}	
}
