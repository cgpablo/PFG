package controlador.Producto;

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
@WebServlet("/pages/ModificarProducto")
public class ModificarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String referencia;
	private String nombre;
	private String idioma;
	private String elemento;
	private String production;
	private String virtual;
	private String seguridad;
	private String mensaje;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarProducto() {
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
		referencia = request.getParameter("referencia");
		nombre = request.getParameter("nombre");
		idioma = request.getParameter("idioma");
		elemento = request.getParameter("elemento");
		production = request.getParameter("production");
		seguridad = request.getParameter("seguridad");
		virtual = request.getParameter("virtual");
		
		if(checkForm(request, response)) {
			if(ApplicationService.getInstance().existsProducto(referencia) == true) {
				ApplicationService.getInstance().modificarProducto(referencia, nombre, idioma, elemento, production, seguridad, virtual);
				request.getRequestDispatcher("/pages/main.jsp").forward(request, response);
			} else {
				mensaje = ApplicationService.getInstance().noExisteProductoException();
				request.getSession().setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("/pages/addProducto.jsp").forward(request, response);
			}
		} else {
			mensaje = "faltan campos";
			request.getSession().setAttribute("mensaje", mensaje);
			request.getRequestDispatcher("/pages/main.jsp").forward(request, response);
		}
	}
	
	private boolean checkForm(HttpServletRequest request, HttpServletResponse response) {
		if ((referencia.equals("")) || (nombre.equals("")) || (idioma.equals("")) || (elemento.equals("")) || (production.equals("")) || (virtual.equals("")) || (seguridad.equals(""))) {
			return false;
		} else {
			return true;
		}
	}

}
