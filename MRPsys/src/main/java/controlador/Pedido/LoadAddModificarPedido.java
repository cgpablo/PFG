package controlador.Pedido;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Clases.Pedido;
import modelo.Negocio.ApplicationService;

/**
 * Servlet implementation class LoadAddKit
 */
@WebServlet("/pages/LoadAddModificarPedido")
public class LoadAddModificarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String referencia;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadAddModificarPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		referencia = request.getParameter("referencia");
		Pedido pedido = ApplicationService.getInstance().getPedido(referencia);
		request.setAttribute("pedido", pedido);
		List <String> productos = ApplicationService.getInstance().getListaEleccionPedido();
		request.setAttribute("productos", productos);
		request.getRequestDispatcher("/pages/ModificarPedido.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
