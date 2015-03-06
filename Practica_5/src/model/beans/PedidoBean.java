package model.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class PedidoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private UserBean usuario;
	private Calendar fecha;
	private ArrayList<PurchaseLineBean> lineasPedido;
	private Double importe;

	public PedidoBean() {
	}

	public PedidoBean(int id, UserBean usuario, Calendar fecha,
			ArrayList<PurchaseLineBean> lineasPedido, Double importe) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.fecha = fecha;
		this.lineasPedido = lineasPedido;
		this.importe = importe;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserBean getUsuario() {
		return this.usuario;
	}

	public void setUsuario(UserBean usuario) {
		this.usuario = usuario;
	}
	
	public Calendar getFecha() {
		return this.fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public ArrayList<PurchaseLineBean> getLineasPedido() {
		return this.lineasPedido;
	}

	public void setLineasPedido(ArrayList<PurchaseLineBean> lineasPedido) {
		this.lineasPedido = lineasPedido;
	}

	public Double getImporte() {
		return this.importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	@Override
	public String toString() {
		return "PedidoBean [id=" + this.id + ", usuario=" + this.usuario
				+ ", fecha=" + this.fecha + ", lineasPedido="
				+ this.lineasPedido + ", importe=" + this.importe + "]";
	}
}