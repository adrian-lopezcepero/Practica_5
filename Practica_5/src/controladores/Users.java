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
import modelo.beans.UsuarioBean;

/**
 * Servlet implementation class Products
 */
@WebServlet("/Products")
public class Users extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logica logica;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Users() {
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

		if (request.getParameter("getAllUsers") != null) {
			ArrayList<UsuarioBean> allUsers = logica.getUsuarios();
			session.setAttribute("allUsers", allUsers);
			response.sendRedirect("views/admin.jsp");
		}
		if (request.getParameter("add") != null) {
			session.removeAttribute("usuarioModificar");
			response.sendRedirect("views/addUser.jsp");
		}
		if (request.getParameter("modify") != null) {
			ArrayList<UsuarioBean> users = (ArrayList<UsuarioBean>) session
					.getAttribute("allUsers");
			UsuarioBean usuarioSeleccionado = users.get(Integer
					.parseInt(request.getParameter("userSelected")));
			session.setAttribute("usuarioModificar", usuarioSeleccionado);
			response.sendRedirect("views/addUser.jsp");
		}
		if (request.getParameter("remove") != null) {
			ArrayList<UsuarioBean> users = (ArrayList<UsuarioBean>) session
					.getAttribute("allUsers");
			UsuarioBean usuarioSeleccionado = users.get(Integer
					.parseInt(request.getParameter("userSelected")));
			logica.deleteUsuario(usuarioSeleccionado.getId());
			// Vuelve a recargar la página para comprobar que se ha borrado
			response.sendRedirect("Products?getAllUsers=true");

		}
		if (request.getParameter("sendNew") != null) {
			UsuarioBean bean = new UsuarioBean(0, request
					.getParameter("name"), request.getParameter("surname"),
					request.getParameter("email"), request
							.getParameter("alias"), request
							.getParameter("password"), request
							.getParameter("address"));
			System.out.println(bean);
			logica.insertUsuario(bean);
			// Vuelve a recargar la página para comprobar que se ha añadido
			response.sendRedirect("Products?getAllUsers=true");
			
		}
		if (request.getParameter("sendModify") != null) {
			UsuarioBean usuarioBean = (UsuarioBean) session
					.getAttribute("usuarioModificar");
			logica.updateUsuario(new UsuarioBean(usuarioBean.getId(), request
					.getParameter("name"), request.getParameter("surname"),
					request.getParameter("email"), request
							.getParameter("alias"), request
							.getParameter("password"), request
							.getParameter("address")));
			// Vuelve a recargar la página para comprobar que se ha modificado
			response.sendRedirect("Products?getAllUsers=true");
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
