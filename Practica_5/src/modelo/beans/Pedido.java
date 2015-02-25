package modelo.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Pedido implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Usuario usuario;
	private Calendar fecha;
	private ArrayList<LineaPedido> lineaPedidos;
	private Double importe;

	public Pedido() {
	}

	public Pedido(int id, Usuario usuario, Calendar fecha,
			ArrayList<LineaPedido> lineaPedidos, Double importe) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.fecha = fecha;
		this.lineaPedidos = lineaPedidos;
		this.importe = importe;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getFecha() {
		return this.fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public ArrayList<LineaPedido> getLineaPedidos() {
		return this.lineaPedidos;
	}

	public void setLineaPedidos(ArrayList<LineaPedido> lineaPedidos) {
		this.lineaPedidos = lineaPedidos;
	}

	public Double getImporte() {
		return this.importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + this.id + ", usuario=" + this.usuario
				+ ", fecha=" + this.fecha + ", lineaPedidos="
				+ this.lineaPedidos + ", importe=" + this.importe + "]";
	}

}
