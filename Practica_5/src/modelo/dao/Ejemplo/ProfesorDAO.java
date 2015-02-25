package modelo.dao;

import java.sql.*;
import java.util.ArrayList;
import modelo.conexion.MySQLConnection;
import modelo.vo.ProfesorVO;

public class ProfesorDAO {
	
	public boolean insert(ProfesorVO profesor) {
		String sql = "INSERT INTO profesores (profesor) "
				   + "VALUES ('" + profesor.getProfesor() + "')";
		return modify(sql);
	}
	
	public boolean update(ProfesorVO profesor) {
		String sql = "UPDATE profesores SET profesor = '" + profesor.getProfesor() + "' "
				   + "WHERE id = " + profesor.getId();
		return modify(sql);
	}
	
	public boolean delete(ProfesorVO profesor) {
		String sql = "DELETE FROM profesores WHERE id = " + profesor.getId();
		return modify(sql);
	}
	
	public boolean deleteAll() {
		String sql = "DELETE FROM profesores";
		return modify(sql);
	}
	
	public ArrayList<ProfesorVO> getAll() {
		String sql = "SELECT * FROM profesores ORDER BY profesor";
		return query(sql);
	}
	
	public ProfesorVO getById(int id) {
		String sql = "SELECT * FROM profesores WHERE id = " + id;
		return (query(sql) == null) ? null : query(sql).get(0);
	}
	
	
	/** Method for INSERT, UPDATE & DELETE Statements*/
	private boolean modify(String sql) {
		MySQLConnection conex = new MySQLConnection();
		
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
	
	/** Method for SELECT Statements */
	private ArrayList<ProfesorVO> query(String sql) {
		MySQLConnection conex = new MySQLConnection();
		ArrayList<ProfesorVO> profesores = new ArrayList<ProfesorVO>();
		boolean existe = false;
		
		try {
			Statement stm = conex.getConnection().createStatement();
			ResultSet res = stm.executeQuery(sql);
			while(res.next()){
				existe = true;
				ProfesorVO profesor = new ProfesorVO();
				profesor.setId(res.getInt("id"));
				profesor.setProfesor(res.getString("profesor"));
				profesores.add(profesor);
			}
			stm.close();
			conex.disconnect();
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return (existe) ? profesores : null;
	}
}
