package controlador.Usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.validator.routines.EmailValidator;

import modelo.Negocio.ApplicationService;

/**
 * Servlet implementation class Register
 */
@WebServlet("/pages/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String username;
    private String mail;
    private String password;
    private String repeatPassword;
    private String mensaje = "";
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		repeatPassword = request.getParameter("repeatPassword");
		
		if(checkForm(request, response)) {
			if(ApplicationService.getInstance().existsUsuario(username) == false) {
				ApplicationService.getInstance().nuevoUsuario(username, mail, password);
				request.getRequestDispatcher("/pages/logIn.jsp").forward(request, response);
			} else {
				mensaje = ApplicationService.getInstance().existeUsuarioException();
				request.getSession().setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
			}
		}
	}
	
	private boolean checkForm(HttpServletRequest request, HttpServletResponse response) {
		if ((username.equals("")) || (mail.equals("")) || (password.equals("")) || (repeatPassword.equals(""))) {
			mensaje = "Faltan campos";
			return false;
		} else {
			if (!password.equals(repeatPassword)) {
				mensaje = "Contraseñas no coinciden";
				return false;
			} else {
				if (!EmailValidator.getInstance().isValid(mail)) {
					mensaje = "Mail no válido";
					return false;
				} else {
					return true;
				}
			}
		}
	}
}
