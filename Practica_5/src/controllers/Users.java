package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Logic;
import model.beans.UserBean;

/**
 * Servlet implementation class Products
 */
@WebServlet("/Users")
public class Users extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logic logic;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Users() {
		super();
		logic = new Logic();
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
			ArrayList<UserBean> allUsers = logic.getUsuarios();
			session.setAttribute("allUsers", allUsers);
			response.sendRedirect("views/admin.jsp");
		}
		if (request.getParameter("add") != null) {
			session.removeAttribute("usuarioModificar");
			response.sendRedirect("views/addUser.jsp");
		}
		if (request.getParameter("modify") != null) {
			ArrayList<UserBean> users = (ArrayList<UserBean>) session
					.getAttribute("allUsers");
			UserBean usuarioSeleccionado = users.get(Integer
					.parseInt(request.getParameter("userSelected")));
			session.setAttribute("usuarioModificar", usuarioSeleccionado);
			response.sendRedirect("views/addUser.jsp");
		}
		if (request.getParameter("remove") != null) {
			ArrayList<UserBean> users = (ArrayList<UserBean>) session
					.getAttribute("allUsers");
			UserBean usuarioSeleccionado = users.get(Integer
					.parseInt(request.getParameter("userSelected")));
			logic.deleteUsuario(usuarioSeleccionado.getId());
			// Vuelve a recargar la página para comprobar que se ha borrado
			response.sendRedirect("Users?getAllUsers=true");

		}
		if (request.getParameter("sendNew") != null) {
			UserBean bean = new UserBean(0, request
					.getParameter("name"), request.getParameter("surname"),
					request.getParameter("email"), request
							.getParameter("alias"), request
							.getParameter("password"), request
							.getParameter("address"));
			System.out.println(bean);
			logic.insertUsuario(bean);
			// Vuelve a recargar la página para comprobar que se ha añadido
			response.sendRedirect("Users?getAllUsers=true");
			
		}
		if (request.getParameter("sendModify") != null) {
			UserBean userBean = (UserBean) session
					.getAttribute("usuarioModificar");
			logic.updateUsuario(new UserBean(userBean.getId(), request
					.getParameter("name"), request.getParameter("surname"),
					request.getParameter("email"), request
							.getParameter("alias"), request
							.getParameter("password"), request
							.getParameter("address")));
			// Vuelve a recargar la página para comprobar que se ha modificado
			response.sendRedirect("Users?getAllUsers=true");
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
