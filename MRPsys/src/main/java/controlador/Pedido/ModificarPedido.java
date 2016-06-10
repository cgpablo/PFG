package controlador.Pedido;

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
@WebServlet("/pages/ModificarPedido")
public class ModificarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String refPed;
	private String refProd;
	private String udProd;
	private String mensaje;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarPedido() {
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
		refPed = request.getParameter("refPed");
		refProd = request.getParameter("refProd");
		udProd = request.getParameter("udProd");
		
		if(checkForm(request, response)) {
			if(ApplicationService.getInstance().existsPedido(refPed) == true) {
				ApplicationService.getInstance().modificarPedido(refPed, refProd, udProd);
				request.getRequestDispatcher("/pages/main.jsp").forward(request, response);
			} else {
				mensaje = ApplicationService.getInstance().noExistePedidoException();
				request.getSession().setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("/pages/addPedido").forward(request, response);
			}
		}
	}
	
	private boolean checkForm(HttpServletRequest request, HttpServletResponse response) {
		if ((refProd.equals("")) || (udProd.equals(""))) {
			mensaje = "Faltan campos";
			return false;
		} else {
			return true;
		}
	}

}
