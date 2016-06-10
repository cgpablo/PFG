package controlador.Producto;

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
@WebServlet("/pages/LoadAddModificarProducto")
public class LoadAddModificarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String referencia;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadAddModificarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		referencia = request.getParameter("referencia");
		Producto producto = ApplicationService.getInstance().getProducto(referencia);
		request.setAttribute("producto", producto);
		request.getRequestDispatcher("/pages/ModificarProducto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
