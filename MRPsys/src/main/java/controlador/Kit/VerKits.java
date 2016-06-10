package controlador.Kit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import modelo.Negocio.ApplicationService;
import modelo.Clases.Kit;
import modelo.Datos.Connect;

/**
 * Servlet implementation class VerReferenciaProductos
 */
@WebServlet("/pages/VerKits")
public class VerKits extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//Connect c = new Connect();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerKits() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List <Kit> kits = ApplicationService.getInstance().getKits();
		request.setAttribute("kits", kits);
		request.getRequestDispatcher("/pages/verKits.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
