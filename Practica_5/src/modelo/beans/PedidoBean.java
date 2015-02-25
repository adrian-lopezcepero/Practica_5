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
	private UsuarioBean usuarioBean;
	private Calendar fecha;
	private ArrayList<LineaPedidoBean> lineaPedidoBeans;
	private Double importe;

	public PedidoBean() {
	}

	public PedidoBean(int id, UsuarioBean usuarioBean, Calendar fecha,
			ArrayList<LineaPedidoBean> lineaPedidoBeans, Double importe) {
		super();
		this.id = id;
		this.usuarioBean = usuarioBean;
		this.fecha = fecha;
		this.lineaPedidoBeans = lineaPedidoBeans;
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

	public ArrayList<LineaPedidoBean> getLineaPedidos() {
		return this.lineaPedidoBeans;
	}

	public void setLineaPedidos(ArrayList<LineaPedidoBean> lineaPedidoBeans) {
		this.lineaPedidoBeans = lineaPedidoBeans;
	}

	public Double getImporte() {
		return this.importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	@Override
	public String toString() {
		return "PedidoBean [id=" + this.id + ", usuarioBean=" + this.usuarioBean
				+ ", fecha=" + this.fecha + ", lineaPedidoBeans="
				+ this.lineaPedidoBeans + ", importe=" + this.importe + "]";
	}

}
