package modelo.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class LineaPedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int cantidad;
	private ArrayList<Producto> productos;
	
	public LineaPedido() {
	}

	public LineaPedido(int id, int cantidad, ArrayList<Producto> productos) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.productos = productos;
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

	public ArrayList<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "LineaPedido [id=" + this.id + ", cantidad=" + this.cantidad
				+ ", productos=" + this.productos + "]";
	}

}
