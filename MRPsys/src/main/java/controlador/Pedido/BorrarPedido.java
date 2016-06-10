package controlador.Pedido;

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
@WebServlet("/pages/BorrarPedido")
public class BorrarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String referencia;
	private String mensaje;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BorrarPedido() {
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
		referencia = request.getParameter("referenciaPedido");
		if (ApplicationService.getInstance().existsPedido(referencia) == true) {
			ApplicationService.getInstance().borrarPedido(referencia);
			request.getRequestDispatcher("/pages/main.jsp").forward(request, response);
		} else {
			mensaje = ApplicationService.getInstance().noExistePedidoException();
			request.getSession().setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("/pages/LoadBorrarPedido").forward(request, response);
		}
	}
}
