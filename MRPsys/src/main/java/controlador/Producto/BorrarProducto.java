package controlador.Producto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import modelo.Negocio.ApplicationService;
import modelo.Clases.Kit;
import modelo.Clases.Pedido;

/**
 * Servlet implementation class AddMaterial
 */
@WebServlet("/pages/BorrarProducto")
public class BorrarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String referencia;
	private String mensaje;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BorrarProducto() {
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
		referencia = request.getParameter("referencia");

		if (ApplicationService.getInstance().existsProducto(referencia) == true) {
			
			List <Pedido> pedidos = ApplicationService.getInstance().getPedidos();
			List <Kit> kits = ApplicationService.getInstance().getKits();
			

			for(Pedido p: pedidos) {
				if(p.getRefProd().equals(referencia)) {
					ApplicationService.getInstance().borrarPedido(p.getReferenciaPedido());
				}
			}
			
			for(Kit k: kits) {
				if(k.getRefProd().equals(referencia)) {
					ApplicationService.getInstance().borrarKit(k.getReferencia());
				}
			}
			
			ApplicationService.getInstance().borrarProducto(referencia);
			request.getRequestDispatcher("/pages/main.jsp").forward(request, response);
		} else {
			mensaje = ApplicationService.getInstance().noExisteProductoException();
			request.getSession().setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("/pages/LoadBorrarProducto").forward(request, response);
		}
	}
}
