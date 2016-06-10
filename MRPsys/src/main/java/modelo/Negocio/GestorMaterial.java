package modelo.Negocio;

import modelo.Datos.*;

import java.util.List;

import modelo.Clases.*;

public class GestorMaterial {

	Connect con = new Connect();

	public void addMaterial(String referencia, String nombre, String idioma, String elemento, String lead,
			String seguridad, String virtual) {
		int leadTime = Integer.parseInt(lead);
		int stockSeguridad = Integer.parseInt(seguridad);
		int stockVirtual = Integer.parseInt(virtual);
		int stockReal = calcularStockReal(stockSeguridad, stockVirtual);
		if (existsMaterial(referencia) == false) {
			Material m = new Material(referencia, nombre, idioma, elemento, leadTime, stockReal, stockSeguridad,
					stockVirtual);
			con.getIDao().aņadirMaterial(m);
		} else {
			existeMaterialException();
		}
	}

	public boolean existsMaterial(String referencia) {
		boolean existe;
		existe = con.getIDao().existsMaterial(referencia);
		return existe;
	}

	public Material getMaterial(String referencia) {
		Material m = con.getIDao().getMaterial(referencia);
		return m;
	}

	public void borrarMaterial(String referencia) {
		Material m = getMaterial(referencia);
		con.getIDao().borrarMaterial(m);
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
		con.getIDao().modificarMaterial(m);
	}

	public List<Material> getMateriales() {
		List<Material> lista = con.getIDao().getMateriales();
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
