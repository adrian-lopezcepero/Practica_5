package model.dao;

import java.sql.SQLException;
import java.sql.Statement;

import model.conection.MySQLConnection;

public class Dao {
	protected MySQLConnection conex = new MySQLConnection();
	protected boolean existe;
	
	/** Method for INSERT, UPDATE & DELETE Statements*/
	protected boolean modify(String sql) {
		conex = new MySQLConnection();
		
		try {
			Statement stm = conex.getConnection().createStatement();
			stm.executeUpdate(sql);
			stm.close();
			conex.disconnect();
			
		} 
		catch (SQLException e) {
            System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
//	/** Method for SELECT Statements */
//	protected ArrayList<Object> query(String sql) {
//		return new ArrayList<Object>();
//	}

}
