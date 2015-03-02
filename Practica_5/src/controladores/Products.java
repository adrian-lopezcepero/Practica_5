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
import modelo.beans.CategoriaBean;
import modelo.beans.ProductoBean;

/**
 * Servlet implementation class Products
 */
@WebServlet("/Products")
public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logica logica;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Products() {
		super();
		logica = new Logica();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		if (request.getParameter("getAllProducts") != null) {
			ArrayList<ProductoBean> allProducts = logica.getProductos();
			session.setAttribute("allProducts", allProducts);
			response.sendRedirect("views/adminProduct.jsp");
		}
		if (request.getParameter("add") != null) {
			session.removeAttribute("productoModificar");
			response.sendRedirect("views/addProduct.jsp");
		}
		if (request.getParameter("modify") != null) {
			ArrayList<ProductoBean> product = (ArrayList<ProductoBean>) session
					.getAttribute("allProducts");
			ProductoBean productoSeleccionado = product.get(Integer
					.parseInt(request.getParameter("productSelected")));
			session.setAttribute("productoModificar", productoSeleccionado);
			response.sendRedirect("views/addProduct.jsp");
		}
		if (request.getParameter("remove") != null) {
			ArrayList<ProductoBean> products = (ArrayList<ProductoBean>) session
					.getAttribute("allProducts");
			ProductoBean productoSeleccionado = products.get(Integer
					.parseInt(request.getParameter("userSelected")));
			logica.deleteUsuario(productoSeleccionado.getId());
			// Vuelve a recargar la página para comprobar que se ha borrado
			response.sendRedirect("Products?getProducts=true");

		}
		if (request.getParameter("sendNew") != null) {
			CategoriaBean categoria = logica.getCategoria(request.getParameter("categoria"));
			ProductoBean producto = new ProductoBean(0,
					request.getParameter("nombre"),
					request.getParameter("descripcion"),
					Double.parseDouble(request.getParameter("precio")),
					request.getParameter("imagen"), categoria);
			logica.insertProducto(producto);
			// Vuelve a recargar la página para comprobar que se ha añadido
			response.sendRedirect("Products?getAllProducts=true");

		}
		if (request.getParameter("sendModify") != null) {
			ProductoBean productoBean = (ProductoBean) session
					.getAttribute("productoModificar");
			CategoriaBean categoria = logica.getCategoria(request.getParameter("categoria"));
			ProductoBean producto = new ProductoBean(productoBean.getId(),
					request.getParameter("nombre"),
					request.getParameter("descripcion"),
					Double.parseDouble(request.getParameter("precio")),
					request.getParameter("imagen"), categoria);
			logica.updateProducto(producto);
			// Vuelve a recargar la página para comprobar que se ha modificado
			response.sendRedirect("Products?getAllProducts=true");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
