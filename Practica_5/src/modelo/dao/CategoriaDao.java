package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.beans.CategoriaBean;
import modelo.conexion.MySQLConnection;

public class CategoriaDao extends Dao {

	public ArrayList<CategoriaBean> selectAllCategorias() {
		String sql = "SELECT * FROM categoria ORDER BY nombre";
		return query(sql);
	}

	public CategoriaBean selectCategoria(int idCat) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM categoria "
					+ "WHERE id = '" + idCat + "'";
		return (query(sql) != null) ? query(sql).get(0) : null;
	}

	/** Method for SELECT Statements */
	private ArrayList<CategoriaBean> query(String sql) {
		conex = new MySQLConnection();
		ArrayList<CategoriaBean> categoriaBeans = new ArrayList<CategoriaBean>();

		try {
			Statement stm = conex.getConnection().createStatement();
			ResultSet res = stm.executeQuery(sql);
			while (res.next()) {
				existe = true;
				CategoriaBean categoriaBean = new CategoriaBean();
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
