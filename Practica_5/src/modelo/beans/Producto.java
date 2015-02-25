package modelo.beans;

import java.io.Serializable;

public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String descripcion;
	private Double precio;
	private String imagen;
	private Categoria categoria;
	
	public Producto() {
	}
	
	public Producto(int id, String nombre, String descripcion, Double precio,
			String imagen, Categoria categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.imagen = imagen;
		this.categoria = categoria;
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
	public String getDescripcion() {
		return this.descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return this.precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getImagen() {
		return this.imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Categoria getCategoria() {
		return this.categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	

}
