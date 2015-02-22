package modelo.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class LineaPedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idLineaPedido;
	private int cantidad;
	private ArrayList<Producto> productos;
	
	public int getIdLineaPedido() {
		return this.idLineaPedido;
	}
	public void setIdLineaPedido(int idLineaPedido) {
		this.idLineaPedido = idLineaPedido;
	}
	public int getCantidad() {
		return this.cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public ArrayList<Producto> getProductos() {
		return this.productos;
	}
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

}
