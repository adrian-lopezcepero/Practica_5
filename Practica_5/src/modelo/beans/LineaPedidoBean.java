package modelo.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class LineaPedidoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int cantidad;
	private ArrayList<ProductoBean> productoBeans;
	
	public LineaPedidoBean() {
	}

	public LineaPedidoBean(int id, int cantidad, ArrayList<ProductoBean> productoBeans) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.productoBeans = productoBeans;
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

	public ArrayList<ProductoBean> getProductos() {
		return this.productoBeans;
	}

	public void setProductos(ArrayList<ProductoBean> productoBeans) {
		this.productoBeans = productoBeans;
	}

	@Override
	public String toString() {
		return "LineaPedidoBean [id=" + this.id + ", cantidad=" + this.cantidad
				+ ", productoBeans=" + this.productoBeans + "]";
	}

}
