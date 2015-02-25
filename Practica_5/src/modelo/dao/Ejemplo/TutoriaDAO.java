package modelo.dao;

import java.sql.*;
import java.util.ArrayList;
import modelo.conexion.MySQLConnection;
import modelo.vo.ProfesorVO;
import modelo.vo.TutoriaVO;

public class TutoriaDAO {

	public boolean insert(TutoriaVO tutoria) {
		String sql = "INSERT INTO tutorias (dia, hora, profesor) "
				   + "VALUES (" + tutoria.getDia() + ","
				   		        + tutoria.getHora() + ","
				   		        + tutoria.getProfesor().getId() + ")";
		return modify(sql);
	}
	
	public boolean update(TutoriaVO tutoria) {
		String sql = "UPDATE tutorias SET dia = " + tutoria.getDia() + ","
				 					   + "hora = " + tutoria.getHora() + ","
				 					   + "profesor = " + tutoria.getProfesor().getId() + " "
				   + "WHERE id = " + tutoria.getId();
		return modify(sql);
	}
	
	public boolean delete(TutoriaVO tutoria) {
		String sql = "DELETE FROM tutorias WHERE id = " + tutoria.getId();
		return modify(sql);
	}
	
	public boolean deleteAll() {
		String sql = "DELETE FROM tutorias";
		return modify(sql);
	}
	
	public ArrayList<TutoriaVO> getAll() {
		String sql = "SELECT t.id id, dia, hora, p.id idProfesor, p.profesor profesor "
				   + "FROM tutorias t, profesores p "
				   + "WHERE t.profesor = p.id "
				   + "ORDER BY profesor, dia, hora";
		return query(sql);
	}
	
	public ArrayList<TutoriaVO> getByProfesor(ProfesorVO profesor) {
		String sql = "SELECT t.id id, dia, hora, p.id idProfesor, p.profesor profesor "
				   + "FROM tutorias t, profesores p "
				   + "WHERE t.profesor = p.id "
				   + "AND t.profesor = " + profesor.getId() + " "
				   + "ORDER BY dia, hora";
		System.out.println(sql);
		return query(sql);
	}
	
	public int getId(TutoriaVO tutoria) {
		String sql = "SELECT t.id id, dia, hora, p.id idProfesor, p.profesor profesor "
				   + "FROM tutorias t, profesores p "
				   + "WHERE t.profesor = p.id "
				   + "AND dia = " + tutoria.getDia() + " "
				   + "AND hora = " + tutoria.getHora() + " "
				   + "AND t.profesor = " + tutoria.getProfesor().getId();
		return (query(sql) == null) ? -1 : query(sql).get(0).getId();
	}
	
	public ArrayList<TutoriaVO> getAvailableAll() {
		String sql = "SELECT t.id id, dia, hora, p.id idProfesor, p.profesor profesor "
				   + "FROM tutorias t, profesores p "
				   + "WHERE t.profesor = p.id "
				   + "AND t.id NOT IN (SELECT tutoria FROM citas) "
				   + "ORDER BY profesor, dia, hora";
		return query(sql);
	}

	public ArrayList<TutoriaVO> getAvailableByProfesor(ProfesorVO profesor) {
		String sql = "SELECT t.id id, dia, hora, p.id idProfesor, p.profesor profesor "
				   + "FROM tutorias t, profesores p "
				   + "WHERE t.profesor = p.id "
				   + "AND t.profesor = " + profesor.getId() + " "
				   + "AND t.id NOT IN (SELECT tutoria FROM citas) "
				   + "ORDER BY dia, hora";
		return query(sql);
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
	private ArrayList<TutoriaVO> query(String sql) {
		MySQLConnection conex = new MySQLConnection();
		ArrayList<TutoriaVO> tutorias = new ArrayList<TutoriaVO>();
		boolean existe = false;
		
		try {
			Statement stm = conex.getConnection().createStatement();
			ResultSet res = stm.executeQuery(sql);
			while(res.next()){
				existe = true;
				ProfesorVO profesor = new ProfesorVO();
				profesor.setId(res.getInt("idProfesor"));
				profesor.setProfesor(res.getString("profesor"));
				TutoriaVO tutoria = new TutoriaVO();
				tutoria.setId(res.getInt("id"));
				tutoria.setDia(res.getInt("dia"));
				tutoria.setHora(res.getInt("hora"));
				tutoria.setProfesor(profesor);
				tutorias.add(tutoria);
			}
			stm.close();
			conex.disconnect();
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return (existe) ? tutorias : null;
	}
}
