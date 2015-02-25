package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.conexion.MySQLConnection;

public class UsuarioDao extends Dao {
	
	
	
	
	
	
	
	/** Method for SELECT Statements */
//	@override
//	private ArrayList<Usuario> query(String sql) {
//		conex = new MySQLConnection();
//		ArrayList<TutoriaVO> tutorias = new ArrayList<TutoriaVO>();
//		boolean existe = false;
//		
//		try {
//			Statement stm = conex.getConnection().createStatement();
//			ResultSet res = stm.executeQuery(sql);
//			while(res.next()){
//				existe = true;
//				ProfesorVO profesor = new ProfesorVO();
//				profesor.setId(res.getInt("idProfesor"));
//				profesor.setProfesor(res.getString("profesor"));
//				TutoriaVO tutoria = new TutoriaVO();
//				tutoria.setId(res.getInt("id"));
//				tutoria.setDia(res.getInt("dia"));
//				tutoria.setHora(res.getInt("hora"));
//				tutoria.setProfesor(profesor);
//				tutorias.add(tutoria);
//			}
//			stm.close();
//			conex.disconnect();
//		} 
//		catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		return (existe) ? tutorias : null;
//	}
}
