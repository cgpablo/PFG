package controlador.Kit;

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
@WebServlet("/pages/AddArticuloKit")
public class AddArticuloKit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String refKit;
	private String refProd;
	private String prod;
	private String mensaje;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddArticuloKit() {
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
		refKit = request.getParameter("refKit");
		refProd = request.getParameter("refProd");
		prod = request.getParameter("prod");
		
		if(checkForm(request, response)) {
			if(ApplicationService.getInstance().existsKit(refKit) == true) {
				ApplicationService.getInstance().añadirArticulo(refKit, refProd, prod);
				request.getRequestDispatcher("/pages/main.jsp").forward(request, response);
			} else {
				mensaje = ApplicationService.getInstance().noExisteKitException();
				request.getSession().setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("/pages/LoadAddKit").forward(request, response);
			}
		}
	}
	
	private boolean checkForm(HttpServletRequest request, HttpServletResponse response) {
		if ((refProd.equals("")) || (prod.equals(""))) {
			mensaje = "Faltan campos";
			return false;
		} else {
			return true;
		}
	}

}
