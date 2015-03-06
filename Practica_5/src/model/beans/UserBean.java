package model.beans;

import java.io.Serializable;

public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String apellidos;
	private String email;
	private String alias;
	private String clave;
	private String direccion;
	private String sessionId;

	public UserBean() {
	}

	public UserBean(int id, String nombre, String apellidos, String email,
			String alias, String clave, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.alias = alias;
		this.clave = clave;
		this.direccion = direccion;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + this.id + ", nombre=" + this.nombre
				+ ", apellidos=" + this.apellidos + ", email=" + this.email
				+ ", alias=" + this.alias + ", clave=" + this.clave
				+ ", direccion=" + this.direccion + ", sessionId="
				+ this.sessionId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.alias == null) ? 0 : this.alias.hashCode());
		result = prime * result
				+ ((this.apellidos == null) ? 0 : this.apellidos.hashCode());
		result = prime * result
				+ ((this.clave == null) ? 0 : this.clave.hashCode());
		result = prime * result
				+ ((this.direccion == null) ? 0 : this.direccion.hashCode());
		result = prime * result
				+ ((this.email == null) ? 0 : this.email.hashCode());
		result = prime * result + this.id;
		result = prime * result
				+ ((this.nombre == null) ? 0 : this.nombre.hashCode());
		result = prime * result
				+ ((this.sessionId == null) ? 0 : this.sessionId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserBean other = (UserBean) obj;
		if (this.alias == null) {
			if (other.alias != null)
				return false;
		}
		else if (!this.alias.equals(other.alias))
			return false;
		if (this.apellidos == null) {
			if (other.apellidos != null)
				return false;
		}
		else if (!this.apellidos.equals(other.apellidos))
			return false;
		if (this.clave == null) {
			if (other.clave != null)
				return false;
		}
		else if (!this.clave.equals(other.clave))
			return false;
		if (this.direccion == null) {
			if (other.direccion != null)
				return false;
		}
		else if (!this.direccion.equals(other.direccion))
			return false;
		if (this.email == null) {
			if (other.email != null)
				return false;
		}
		else if (!this.email.equals(other.email))
			return false;
		if (this.id != other.id)
			return false;
		if (this.nombre == null) {
			if (other.nombre != null)
				return false;
		}
		else if (!this.nombre.equals(other.nombre))
			return false;
		if (this.sessionId == null) {
			if (other.sessionId != null)
				return false;
		}
		else if (!this.sessionId.equals(other.sessionId))
			return false;
		return true;
	}

}
