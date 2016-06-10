package controlador.Kit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import modelo.Negocio.ApplicationService;
import modelo.Clases.Pedido;

/**
 * Servlet implementation class AddMaterial
 */
@WebServlet("/pages/BorrarKit")
public class BorrarKit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String referencia;
	private String mensaje;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BorrarKit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		referencia = request.getParameter("referenciaKit");
		if (ApplicationService.getInstance().existsKit(referencia) == true) {
			ApplicationService.getInstance().borrarKit(referencia);
			request.getRequestDispatcher("/pages/main.jsp").forward(request, response);
		} else {
			mensaje = ApplicationService.getInstance().noExistePedidoException();
			request.getSession().setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("/pages/LoadBorrarKit").forward(request, response);
		}
	}
}
