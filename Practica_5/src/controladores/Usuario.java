package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import modelo.Logica;

/**
 * Servlet implementation class UsuarioBean
 */
@WebServlet("/UsuarioBean")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String alias;
	private String clave;
	private Logica logica;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Usuario() {
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
		// El login debe ser variables de sesión para mantener el acceso durante
		// toda la duración de la misma.
		session.setAttribute("alias", request.getParameter("alias"));
		session.setAttribute("clave", request.getParameter("clave"));
		alias = (String) session.getAttribute("alias");
		clave = (String) session.getAttribute("clave");

		// Para controlar la sessión única, el atributo de aplicación se
		// inicializa en el index.jsp como atributo de aplicación.
		String ultimaSesion = (String) getServletContext().getAttribute(
				"ultimaSesion");
		String respuestaLogin = logica.getLoginResponse(session.getId(),
				ultimaSesion, alias, clave);

		response.sendRedirect("login.jsp");

	}

}
