package modelo.Negocio;

import modelo.Datos.*;
import java.util.*;
import modelo.Clases.*;


public class GestorPedido {
	
	Connect con = new Connect();
	
	public void addPedido(String refPed, String refProd, String udProd) {
		int orden = Integer.parseInt(udProd);
		if(con.getIDao().existsPedido(refPed) == false) {
			Pedido p = new Pedido(refPed, refProd, orden);
			con.getIDao().añadirPedido(p);
		} else {
			existePedidoException();
		}
	}
	
	public boolean existsPedido(String refPed) {
		boolean existe;
		existe = con.getIDao().existsPedido(refPed);
		return existe;
	}
	
	public Pedido getPedido(String refPed) {
		Pedido p = con.getIDao().getPedido(refPed);
		return p;
	}
	
	public void borrarPedido(String refPed) {
		Pedido p = getPedido(refPed);
		con.getIDao().borrarPedido(p);
	}
	
	public void modificarPedido(String refPed, String refProd, String udProd) {
		int orden = Integer.parseInt(udProd);
		Pedido p = getPedido(refPed);
		p.setRefProd(refProd);
		p.setOrden(orden);
		con.getIDao().modificarPedido(p);
	}
	
	public List<Pedido> getPedidos() {
		List <Pedido> lista = con.getIDao().getPedidos();
		return lista;
	}
	
	public String existePedidoException() {
		String mensaje = "Ya existe este pedido";
		return mensaje;
	}

	public String noExistePedidoException() {
		String mensaje = "No existe este pedido";
		return mensaje;
	}
	
}
