package modelo.beans;

import java.io.Serializable;

public class ProductoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String descripcion;
	private Double precio;
	private String imagen;
	private CategoriaBean categoriaBean;
	
	public ProductoBean() {
	}
	
	public ProductoBean(int id, String nombre, String descripcion, Double precio,
			String imagen, CategoriaBean categoriaBean) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.imagen = imagen;
		this.categoriaBean = categoriaBean;
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
	public CategoriaBean getCategoria() {
		return this.categoriaBean;
	}
	public void setCategoria(CategoriaBean categoriaBean) {
		this.categoriaBean = categoriaBean;
	}

	

}
