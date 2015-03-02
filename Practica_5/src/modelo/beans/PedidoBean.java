package modelo.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class PedidoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private UsuarioBean usuario;
	private Calendar fecha;
	private ArrayList<LineaPedidoBean> lineasPedido;
	private Double importe;

	public PedidoBean() {
	}

	public PedidoBean(int id, UsuarioBean usuario, Calendar fecha,
			ArrayList<LineaPedidoBean> lineasPedido, Double importe) {
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

	public UsuarioBean getUsuario() {
		return this.usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}
	
	public Calendar getFecha() {
		return this.fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public ArrayList<LineaPedidoBean> getLineasPedido() {
		return this.lineasPedido;
	}

	public void setLineasPedido(ArrayList<LineaPedidoBean> lineasPedido) {
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