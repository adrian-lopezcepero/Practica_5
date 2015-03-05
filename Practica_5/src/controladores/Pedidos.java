package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Logica;
import modelo.beans.LineaPedidoBean;
import modelo.beans.PedidoBean;
import modelo.beans.ProductoBean;
import modelo.beans.UsuarioBean;

/**
 * Servlet implementation class Pedidos
 */
@WebServlet("/Pedidos")
public class Pedidos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logica logica;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pedidos() {
        super();
        logica = new Logica();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		if (request.getParameter("addCesta") != null) {
			ArrayList<ProductoBean> cesta;
			int id = Integer.parseInt(request.getParameter("prod"));
			ProductoBean producto = logica.setProducto(id, Integer.parseInt(request.getParameter("cant")));

			if (session.getAttribute("cesta") != null) {
				cesta = (ArrayList<ProductoBean>) session.getAttribute("cesta");
				cesta.add(producto);
				session.setAttribute("cesta", cesta);
			} 
			else {
				cesta = new ArrayList<ProductoBean>();
				cesta.add(producto);
				session.setAttribute("cesta", cesta);
			}
			
			String page = request.getParameter("page");
			page += (page.equals("index.jsp")) ? "?cesta=" + cesta.size() : "&cesta=" + cesta.size();
			response.sendRedirect(page);
//			System.out.println(page);
//			System.out.println(cesta.toString());
		}
		
		if (request.getParameter("verCesta") != null) {
			if (session.getAttribute("cesta") != null) {
				ArrayList<ProductoBean> cesta = (ArrayList<ProductoBean>) session.getAttribute("cesta");
				session.setAttribute("pedido", getPedidoFromCesta(cesta, (UsuarioBean) session.getAttribute("isLogin")));
				response.sendRedirect("views/verCesta.jsp");
			}
			else {
				String page = request.getParameter("page");
				page += (page.equals("index.jsp")) ? "?verCesta=false" : "&verCesta=false";
				response.sendRedirect(page);
			}
		}

		if (request.getParameter("comprar") != null) {
			PedidoBean pedido = (PedidoBean) session.getAttribute("pedido"); 
			logica.insertPedido(pedido);
			session.removeAttribute("cesta");
			// TODO enviar email
			response.sendRedirect("views/comprar.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private PedidoBean getPedidoFromCesta(ArrayList<ProductoBean> cesta, UsuarioBean usuario) {
		ArrayList<LineaPedidoBean> lineasPedido = new ArrayList<LineaPedidoBean>();
		double importe = 0;
		
		int id = 1;
		for (ProductoBean producto : cesta) {
			LineaPedidoBean linea = new LineaPedidoBean();
			int index = estaDuplicado(producto, lineasPedido);
			
			if (index == -1) {
				linea.setId(id++);
				linea.setCantidad(producto.getCantidad());
				linea.setProducto(producto);
				lineasPedido.add(linea);
			}
			else {
				linea = lineasPedido.get(index);
				linea.setCantidad(linea.getCantidad() + producto.getCantidad());
				lineasPedido.set(index, linea);
			}
			importe += producto.getPrecio() * producto.getCantidad();
		}
		
		PedidoBean pedido = new PedidoBean();
		pedido.setUsuario(usuario);
		pedido.setImporte(importe);
		pedido.setLineasPedido(lineasPedido);
		
		return pedido;
	}
	
	/** Devuelve el indice (id - 1) del ArrayList<LineaPedidoBean> si el producto está duplicado en la cesta; 
	 *  si no, devuelve -1
	 */
	private int estaDuplicado(ProductoBean producto, ArrayList<LineaPedidoBean> lineasPedido) {
		for (int i = 0; i < lineasPedido.size(); i++) {
			if (lineasPedido.get(i).getProducto().getId() == producto.getId()) {
				return i;
			}
		}
		return -1;
	}

}
