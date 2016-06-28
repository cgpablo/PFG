package modelo.Negocio;

import modelo.Datos.Connect;
import java.util.List;
import modelo.Clases.*;


public class GestorProducto {
	
	public void addProducto(String referencia, String nombre, String idioma, String elemento, String production,
			String seguridad, String virtual) {
		int productionTime = Integer.parseInt(production);
		int stockSeguridad = Integer.parseInt(seguridad);
		int stockVirtual = Integer.parseInt(virtual);
		int stockReal = calcularStockReal(stockSeguridad, stockVirtual);
		if (existsProducto(referencia) == false) {
			Producto p = new Producto(referencia, nombre, idioma, elemento, productionTime, stockReal, stockSeguridad,
					stockVirtual);
			Connect.getIDao().añadirProducto(p);
		} else {
			existeProductoException();
		}
	}
	
	public boolean existsProducto(String referencia) {
		boolean existe;
		existe = Connect.getIDao().existsProducto(referencia);
		return existe;
	}
	
	public Producto getProducto(String referencia) {
		Producto p = Connect.getIDao().getProducto(referencia);
		return p;
	}
	
	public void borrarProducto(String referencia) {
		Producto p = getProducto(referencia);
		Connect.getIDao().borrarProducto(p);
	}
	
	public void modificarProducto(String referencia, String nombre, String idioma, String elemento, String production,
			String seguridad, String virtual) {
		int productionTime = Integer.parseInt(production);
		int stockSeguridad = Integer.parseInt(seguridad);
		int stockVirtual = Integer.parseInt(virtual);
		Producto p = getProducto(referencia);
		p.setNombre(nombre);
		p.setIdioma(idioma);
		p.setElemento(elemento);
		p.setProduction(productionTime);
		p.setSeguridad(stockSeguridad);
		p.setVirtual(stockVirtual);
		p.setReal(calcularStockReal(stockSeguridad, stockVirtual));
		Connect.getIDao().modificarProducto(p);
	}
	
	public List<Producto> getProductos() {
		List <Producto> lista = Connect.getIDao().getProductos();
		return lista;
	}
	
	public String existeProductoException() {
		String mensaje = "Ya existe este producto";
		return mensaje;
	}
	
	public String noExisteProductoException() {
		String mensaje = "No existe este producto";
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
