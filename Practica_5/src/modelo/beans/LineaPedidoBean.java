package modelo.beans;

import java.io.Serializable;

public class LineaPedidoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int cantidad;
	private ProductoBean producto; 
	
	public LineaPedidoBean() {
	}

	public LineaPedidoBean(int id, int cantidad, ProductoBean producto) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.producto = producto;
	}

	/**
	 * @return the producto
	 */
	public ProductoBean getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(ProductoBean producto) {
		this.producto = producto;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	@Override
	public String toString() {
		return "LineaPedidoBean [id=" + this.id + ", cantidad=" + this.cantidad
				+ ", productoBeans=" + this.producto + "]";
	}

}