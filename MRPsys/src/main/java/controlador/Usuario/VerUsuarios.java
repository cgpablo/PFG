package controlador.Usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import modelo.Negocio.ApplicationService;
import modelo.Clases.Usuario;
import modelo.Datos.Connect;

/**
 * Servlet implementation class VerReferenciaProductos
 */
@WebServlet("/pages/VerUsuarios")
public class VerUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Connect c = new Connect();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List <Usuario> usuarios = ApplicationService.getInstance().getUsuarios();
		request.getSession().setAttribute("usuarios", usuarios);
		request.getRequestDispatcher("/pages/verUsuarios.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
