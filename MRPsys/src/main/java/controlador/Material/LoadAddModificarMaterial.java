package controlador.Material;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Clases.Material;
import modelo.Negocio.ApplicationService;

/**
 * Servlet implementation class LoadAddKit
 */
@WebServlet("/pages/LoadAddModificarMaterial")
public class LoadAddModificarMaterial extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String referencia;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadAddModificarMaterial() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		referencia = request.getParameter("referencia");
		Material material = ApplicationService.getInstance().getMaterial(referencia);
		request.setAttribute("material", material);
		request.getRequestDispatcher("/pages/ModificarMaterial.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
