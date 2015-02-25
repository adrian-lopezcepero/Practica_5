package modelo.beans;

import java.io.Serializable;

public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idUsuario;
	private String nombre;
	private String apellidos;
	private String email;
	private String alias;
	private String clave;
	private String direccion;
	
	public Usuario(int idUsuario, String nombre, String apellidos,
			String email, String alias, String clave, String direccion) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.alias = alias;
		this.clave = clave;
		this.direccion = direccion;
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + this.idUsuario + ", nombre="
				+ this.nombre + ", apellidos=" + this.apellidos + ", email="
				+ this.email + ", alias=" + this.alias + ", clave="
				+ this.clave + ", direccion=" + this.direccion + "]";
	}


}
