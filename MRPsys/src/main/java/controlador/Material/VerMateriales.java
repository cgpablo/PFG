package controlador.Material;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import modelo.Negocio.ApplicationService;
import modelo.Clases.Material;
import modelo.Datos.Connect;

/**
 * Servlet implementation class VerReferenciaProductos
 */
@WebServlet("/pages/VerMateriales")
public class VerMateriales extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//Connect c = new Connect();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerMateriales() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List <Material> materiales = ApplicationService.getInstance().getMateriales();
		request.setAttribute("materiales", materiales);
		request.getRequestDispatcher("/pages/verMateriales.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
