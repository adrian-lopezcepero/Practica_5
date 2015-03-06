package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.beans.CategoryBean;
import model.conection.MySQLConnection;

public class CategoryDao extends Dao {

	public ArrayList<CategoryBean> selectAllCategorias() {
		String sql = "SELECT * FROM categoria ORDER BY nombre";
		return query(sql);
	}

	public CategoryBean selectCategoria(int idCat) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM categoria "
					+ "WHERE id = '" + idCat + "'";
		return (query(sql) != null) ? query(sql).get(0) : null;
	}

	/** Method for SELECT Statements */
	private ArrayList<CategoryBean> query(String sql) {
		conex = new MySQLConnection();
		ArrayList<CategoryBean> categoryBeans = new ArrayList<CategoryBean>();

		try {
			Statement stm = conex.getConnection().createStatement();
			ResultSet res = stm.executeQuery(sql);
			while (res.next()) {
				existe = true;
				CategoryBean categoryBean = new CategoryBean();
				categoryBean.setId(res.getInt("id"));
				categoryBean.setNombre(res.getString("nombre"));
				categoryBeans.add(categoryBean);
			}
			stm.close();
			conex.disconnect();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return (existe) ? categoryBeans : null;
	}

}
