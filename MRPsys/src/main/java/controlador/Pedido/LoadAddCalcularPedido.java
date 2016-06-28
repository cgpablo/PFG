package controlador.Pedido;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Clases.Pedido;
import modelo.Clases.PedidoProducto;
import modelo.Clases.PedidoKit;
import modelo.Negocio.ApplicationService;

/**
 * Servlet implementation class LoadAddKit
 */
@WebServlet("/pages/LoadAddCalcularPedido")
public class LoadAddCalcularPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String referencia;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadAddCalcularPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		referencia = request.getParameter("referencia");
		ApplicationService.getInstance().añadirCalcularPedido(referencia);
		List <PedidoProducto> pedidoProductos = ApplicationService.getInstance().calcularPedidoProducto(referencia);
		request.setAttribute("pedidoProductos", pedidoProductos);
		List <PedidoKit> pedidoKits = ApplicationService.getInstance().calcularPedidoKit(referencia);
		request.setAttribute("pedidoKits", pedidoKits);
		request.getRequestDispatcher("/pages/CalcularPedido.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
