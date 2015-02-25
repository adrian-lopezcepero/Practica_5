package modelo.dao;

import java.sql.*;
import java.util.ArrayList;
import modelo.conexion.MySQLConnection;
import modelo.vo.CitaVO;
import modelo.vo.ProfesorVO;
import modelo.vo.TutoriaVO;

public class CitaDAO {
	
	public boolean insert(CitaVO cita) {
	String sql = "INSERT INTO citas (alumno, asunto, tutoria) "
			   + "VALUES ('" + cita.getAlumno() + "',"
			   		   + "'" + cita.getAsunto() + "',"
			   		   		 + cita.getTutoria().getId() + ")";
	return modify(sql);
	}

//public boolean update(CitaVO cita) {
//	String sql = "UPDATE citas SET alumno = '" + cita.getAlumno() + "',"
//			 					+ "asunto = '" + cita.getAsunto() + "',"
//			 					+ "tutoria = " + cita.getTutoria().getId() + " "
//			   + "WHERE id = " + cita.getId();
//	return modify(sql);
//}

//public boolean delete(CitaVO cita) {
//	String sql = "DELETE FROM citas WHERE id = " + cita.getId();
//	return modify(sql);
//}

//public boolean deleteAll() {
//	String sql = "DELETE FROM citas";
//	return modify(sql);
//}
	
	public ArrayList<CitaVO> getAll() {
	String sql = "SELECT c.id id, alumno, asunto, t.id idTutoria, dia, hora, p.id idProfesor, p.profesor profesor "
			   + "FROM citas c, tutorias t, profesores p "
			   + "WHERE c.tutoria = t.id "
			   + "AND t.profesor = p.id "
			   + "ORDER BY profesor, dia, hora, alumno";
	return query(sql);
	}
	
	public ArrayList<CitaVO> getByProfesor(ProfesorVO profesor) {
		String sql = "SELECT c.id id, alumno, asunto, t.id idTutoria, dia, hora, p.id idProfesor, p.profesor profesor "
				   + "FROM citas c, tutorias t, profesores p "
				   + "WHERE c.tutoria = t.id "
				   + "AND t.profesor = p.id "
				   + "AND t.profesor = " + profesor.getId() + " "
				   + "ORDER BY dia, hora, alumno";
		return query(sql);
	}
	
	public ArrayList<CitaVO> getByAlumno(String alumno) {
		String sql = "SELECT c.id id, alumno, asunto, t.id idTutoria, dia, hora, p.id idProfesor, p.profesor profesor "
				+ "FROM citas c, tutorias t, profesores p "
				+ "WHERE c.tutoria = t.id "
				+ "AND t.profesor = p.id "
				+ "AND alumno = '" + alumno + "' "
				+ "ORDER BY dia, hora, alumno";
		return query(sql);
	}
	
	public CitaVO getByTutoria(TutoriaVO tutoria) {
		String sql = "SELECT c.id id, alumno, asunto, t.id idTutoria, dia, hora, p.id idProfesor, p.profesor profesor "
				   + "FROM citas c, tutorias t, profesores p "
				   + "WHERE c.tutoria = t.id "
				   + "AND t.profesor = p.id "
				   + "AND c.tutoria = " + tutoria.getId();
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
	private ArrayList<CitaVO> query(String sql) {
		MySQLConnection conex = new MySQLConnection();
		ArrayList<CitaVO> citas = new ArrayList<CitaVO>();
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
				tutoria.setId(res.getInt("idTutoria"));
				tutoria.setDia(res.getInt("dia"));
				tutoria.setHora(res.getInt("hora"));
				tutoria.setProfesor(profesor);
				CitaVO cita = new CitaVO();
				cita.setId(res.getInt("id"));
				cita.setAlumno(res.getString("alumno"));
				cita.setAsunto(res.getString("asunto"));
				cita.setTutoria(tutoria);
				citas.add(cita);
			}
			stm.close();
			conex.disconnect();
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return (existe) ? citas : null;
	}

}
