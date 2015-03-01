package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Logica;
import modelo.beans.UsuarioBean;
import modelo.beans.UsuariosBean;

/**
 * Servlet implementation class UsuarioBean
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String alias;
	private String clave;
	private UsuariosBean usuariosBean;
	private Logica logica;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		logica = new Logica();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		// En primer lugar obtenemos los usuarios que están logeados.
		usuariosBean = (UsuariosBean) getServletContext().getAttribute(
				"usuariosBean");
		if (usuariosBean == null) {
			usuariosBean = new UsuariosBean();
		}
		// Obtenemos el alias y la clave.
		alias = request.getParameter("alias");
		clave = request.getParameter("clave");

		if (request.getParameter("login") != null) {
			tryLogin(request, session);
			response.sendRedirect("index.jsp");
		}
		if (request.getParameter("logOut") != null) {
			UsuarioBean usuarioBean = (UsuarioBean) session
					.getAttribute("usuarioBean");
			usuariosBean.deleteUser(usuarioBean);
			getServletContext().setAttribute("usuariosBean", usuariosBean);
			session.setAttribute("usuarioBean", null);
			session.setAttribute("isLogin", false);
			session.setAttribute("isSameSession",true);
			response.sendRedirect("index.jsp");
		}

	}

	/**
	 * Check if the user is already logged and prevent a new login if the user
	 * has another session.
	 * 
	 * @param request
	 * @param session
	 */
	private void tryLogin(HttpServletRequest request, HttpSession session) {

		// Comprobamos si el usuario está ya logeado
		UsuarioBean userLogged = logica.getLoginResponse(alias, clave,
				usuariosBean);
		if (userLogged != null) {
			session.setAttribute("isSameSession", userLogged.getSessionId()
					.equals(session.getId()));

		}
		else {
			// El usuario no está logeado
			// Comprueba que existe el usuario
			UsuarioBean usuarioBean = logica.verificaUsuario(alias, clave);
			if (usuarioBean != null) {
				session.setAttribute("isAdmin", logica.isAdmin(usuarioBean));
				session.setAttribute("isLogin", true);
				usuarioBean.setSessionId(session.getId());
				session.setAttribute("usuarioBean", usuarioBean);
				usuariosBean.getLoggedUsers().add(usuarioBean);
				getServletContext().setAttribute("usuariosBean", usuariosBean);
			}
			else {
				// El usuario no existe, impedimos que inicie sesión.
				session.setAttribute("isLogin", false);
			}
		}
	}
}
