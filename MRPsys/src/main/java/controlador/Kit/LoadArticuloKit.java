package controlador.Kit;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Clases.Kit;
import modelo.Clases.Producto;
import modelo.Clases.Material;
import modelo.Negocio.ApplicationService;

/**
 * Servlet implementation class LoadAddKit
 */
@WebServlet("/pages/LoadArticuloKit")
public class LoadArticuloKit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String referencia;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadArticuloKit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		referencia = request.getParameter("referencia");
		Kit kit = ApplicationService.getInstance().getKit(referencia);
		request.setAttribute("kit", kit);
//		List <Producto> productos = ApplicationService.getInstance().getProductos();
		List <String> productos = ApplicationService.getInstance().getListaEleccionKit();
		request.setAttribute("productos", productos);
//		List <Material> materiales = ApplicationService.getInstance().getMateriales();
//		request.setAttribute("materiales", materiales);
		request.getRequestDispatcher("/pages/addArticuloKit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
