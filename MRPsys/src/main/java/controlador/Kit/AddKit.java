package controlador.Kit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Negocio.ApplicationService;

/**
 * Servlet implementation class AddKit
 */
@WebServlet("/pages/AddKit")
public class AddKit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String refKit;
	private String refProd;
	private String prod;
	private String refMat;
	private String mat;
	private String mensaje;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddKit() {
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
		refMat = request.getParameter("refMat");
		mat = request.getParameter("mat");
		
		if(checkForm(request, response)) {
			if(ApplicationService.getInstance().existsKit(refKit) == false) {
				ApplicationService.getInstance().nuevoKit(refKit, refProd, prod, refMat, mat);
				request.getRequestDispatcher("/pages/main.jsp").forward(request, response);
			} else {
				mensaje = ApplicationService.getInstance().existeKitException();
				request.getSession().setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("/pages/addKit.jsp").forward(request, response);
			}
		}
	}
	
	private boolean checkForm(HttpServletRequest request, HttpServletResponse response) {
		if ((refKit.equals("")) || (refProd.equals("")) || (prod.equals("")) || (refMat.equals("")) || (mat.equals(""))) {
			mensaje = "Faltan campos";
			return false;
		} else {
			return true;
		}
	}
}
