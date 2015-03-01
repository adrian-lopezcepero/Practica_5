package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.beans.CategoriaBean;
import modelo.beans.LineaPedidoBean;
import modelo.beans.PedidoBean;
import modelo.beans.ProductoBean;
import modelo.beans.UsuarioBean;
import modelo.conexion.MySQLConnection;

public class PedidoDao extends Dao {
//	private UsuarioBean usuarioBean = new UsuarioBean();
//	private CategoriaBean categoriaBean = new CategoriaBean();
//	private ArrayList<LineaPedidoBean> lineaPedidoBeans = new ArrayList<LineaPedidoBean>();
//	private PedidoBean pedidoBean = new PedidoBean();
	
	public boolean insertPedido(PedidoBean pedido) {
		String sql1 = "INSERT INTO pedido (importe, idUsuario) "
					+ "VALUES ('" + pedido.getImporte() + "', '" + pedido.getUsuarioBean().getId() + "');";

		String sql2 = "INSERT INTO lineapedido (idPedido, idLineaPedido, cantidad, idProducto) ";
		ArrayList<LineaPedidoBean> lineas = pedido.getLineaPedidoBeans();
		for (LineaPedidoBean linea : lineas) {
					sql2 += "		  VALUES (((SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES "
						  + "                   WHERE TABLE_SCHEMA = '" + conex.getDATABASE() + "' AND TABLE_NAME = 'pedido') - 1),"
						  + 				   linea.getId() + "," + linea.getCantidad() + "," + linea.getProducto().getId() + "), ";
			
		}
		sql2 = sql2.substring(0, sql2.length() - 1) + ";";
		
		return (modify(sql1) && modify(sql2));
	}
	
	
	
	

	
	
/** De momento no tenemos consultas de Pedidos */	
//	/** Method for SELECT Statements */
//	private ArrayList<PedidoBean> query(String sql) {
//		conex = new MySQLConnection();
//		ArrayList<PedidoBean> pedidos = new ArrayList<PedidoBean>();
//		
//		try {
//			Statement stm = conex.getConnection().createStatement();
//			ResultSet res = stm.executeQuery(sql);
//			while(res.next()){
//				existe = true;
//				
//				// UsuarioBean
//				
//				// CategoriaBean
//				categoriaBean.setId(res.getInt("idCat"));
//				categoriaBean.setNombre(res.getString("nombreCat"));
//				
//				// Lineas de PedidoBean
//				
//				
//				// PedidoBean
//				pedidoBean.setId(res.getInt("id"));
//				pedidos.add(pedidoBean);
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
