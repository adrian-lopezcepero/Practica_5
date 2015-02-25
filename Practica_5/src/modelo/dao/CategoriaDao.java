package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.beans.CategoriaBean;
import modelo.conexion.MySQLConnection;

public class CategoriaDao extends Dao {
	private CategoriaBean categoriaBean = new CategoriaBean();
	
	
	
	
	
	/** Method for SELECT Statements */
	private ArrayList<CategoriaBean> query(String sql) {
		conex = new MySQLConnection();
		ArrayList<CategoriaBean> categoriaBeans = new ArrayList<CategoriaBean>();
		
		try {
			Statement stm = conex.getConnection().createStatement();
			ResultSet res = stm.executeQuery(sql);
			while(res.next()){
				existe = true;
				categoriaBean.setId(res.getInt("id"));
				categoriaBean.setNombre(res.getString("nombre"));
				categoriaBeans.add(categoriaBean);
			}
			stm.close();
			conex.disconnect();
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return (existe) ? categoriaBeans : null;
	}
}
