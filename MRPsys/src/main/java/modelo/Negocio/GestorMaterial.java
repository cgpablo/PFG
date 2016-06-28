package modelo.Negocio;

import modelo.Datos.Connect;
import java.util.List;
import modelo.Clases.*;

public class GestorMaterial {

	public void addMaterial(String referencia, String nombre, String idioma, String elemento, String lead,
			String seguridad, String virtual) {
		int leadTime = Integer.parseInt(lead);
		int stockSeguridad = Integer.parseInt(seguridad);
		int stockVirtual = Integer.parseInt(virtual);
		int stockReal = calcularStockReal(stockSeguridad, stockVirtual);
		if (existsMaterial(referencia) == false) {
			Material m = new Material(referencia, nombre, idioma, elemento, leadTime, stockReal, stockSeguridad,
					stockVirtual);
			Connect.getIDao().añadirMaterial(m);
		} else {
			existeMaterialException();
		}
	}

	public boolean existsMaterial(String referencia) {
		boolean existe;
		existe = Connect.getIDao().existsMaterial(referencia);
		return existe;
	}

	public Material getMaterial(String referencia) {
		Material m = Connect.getIDao().getMaterial(referencia);
		return m;
	}

	public void borrarMaterial(String referencia) {
		Material m = getMaterial(referencia);
		Connect.getIDao().borrarMaterial(m);
	}

	public void modificarMaterial(String referencia, String nombre, String idioma, String elemento, String lead, String seguridad, String virtual) {
		int leadTime = Integer.parseInt(lead);
		int stockVirtual = Integer.parseInt(virtual);
		int stockSeguridad = Integer.parseInt(seguridad);
		Material m = getMaterial(referencia);
		m.setNombre(nombre);
		m.setIdioma(idioma);
		m.setElemento(elemento);
		m.setLead(leadTime);
		m.setSeguridad(stockSeguridad);
		m.setVirtual(stockVirtual);
		m.setReal(calcularStockReal(stockSeguridad, stockVirtual));
		Connect.getIDao().modificarMaterial(m);
	}

	public List<Material> getMateriales() {
		List<Material> lista = Connect.getIDao().getMateriales();
		return lista;
	}

	public String existeMaterialException() {
		String mensaje = "Ya existe este material";
		return mensaje;
	}

	public String noExisteMaterialException() {
		String mensaje = "No existe este material";
		return mensaje;
	}

	public int calcularStockReal(int seguridad, int virtual) {
		int real;
		if (seguridad > virtual) {
			real = 0;
		} else {
			real = virtual - seguridad;
		}
		return real;
	}
}
