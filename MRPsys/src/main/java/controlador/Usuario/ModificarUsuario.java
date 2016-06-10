package controlador.Usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Negocio.ApplicationService;

/**
 * Servlet implementation class ModificarProducto
 */
@WebServlet("/pages/ModificarUsuario")
public class ModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String username;
	private String mail;
	private String password;
	private String mensaje;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		username = request.getParameter("username");
		mail = request.getParameter("mail");
		password = request.getParameter("password");
		
		if(checkForm(request, response)) {
			if(ApplicationService.getInstance().existsUsuario(username) == true) {
				ApplicationService.getInstance().modificarUsuario(username, mail, password);
				request.getRequestDispatcher("/pages/main.jsp").forward(request, response);
			} else {
				mensaje = ApplicationService.getInstance().noExisteUsuarioException();
				request.getSession().setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("/pages/main.jsp").forward(request, response);
			}
		} else {
			mensaje = "faltan campos";
			request.getSession().setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("/pages/main.jsp").forward(request, response);
		}
	}
	
	private boolean checkForm(HttpServletRequest request, HttpServletResponse response) {
		if ((username.equals("")) || (mail.equals("")) || (password.equals(""))) {
			return false;
		} else {
			return true;
		}
	}

}
