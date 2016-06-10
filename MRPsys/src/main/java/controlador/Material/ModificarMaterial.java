package controlador.Material;

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
@WebServlet("/pages/ModificarMaterial")
public class ModificarMaterial extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String referencia;
	private String nombre;
	private String idioma;
	private String elemento;
	private String lead;
	private String virtual;
	private String seguridad;
	private String mensaje;
	private boolean success;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarMaterial() {
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
		lead = request.getParameter("lead");
		seguridad = request.getParameter("seguridad");
		virtual = request.getParameter("virtual");
		
		if(checkForm(request, response)) {
			if(ApplicationService.getInstance().existsMaterial(referencia) == true) {
				ApplicationService.getInstance().modificarMaterial(referencia, nombre, idioma, elemento, lead, seguridad, virtual);
				success = true;
				mensaje = "Material modificado correctamente";
				request.getSession().setAttribute("mensaje", mensaje);
				request.getSession().setAttribute("success", success);
				request.getRequestDispatcher("/pages/main.jsp").forward(request, response);
			} else {
				mensaje = ApplicationService.getInstance().noExisteMaterialException();
				request.getSession().setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("/pages/main.jsp").forward(request, response);
			}
		} else {
			success = false;
			mensaje = "faltan campos";
			request.getSession().setAttribute("mensaje", mensaje);
			request.getSession().setAttribute("success", success);
			request.getRequestDispatcher("/pages/main.jsp").forward(request, response);
		}
	}
	
	private boolean checkForm(HttpServletRequest request, HttpServletResponse response) {
		if ((referencia.equals("")) || (nombre.equals("")) || (idioma.equals("")) || (elemento.equals("")) || (lead.equals("")) || (virtual.equals("")) || (seguridad.equals(""))) {
			return false;
		} else {
			return true;
		}
	}

}
