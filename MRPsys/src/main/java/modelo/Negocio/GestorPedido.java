package modelo.Negocio;

import modelo.Datos.Connect;
import java.util.*;
import modelo.Clases.*;


public class GestorPedido {
	
	public void addPedido(String refPed, String refProd, String udProd) {
		int orden = Integer.parseInt(udProd);
		if(Connect.getIDao().existsPedido(refPed) == false) {
			Pedido p = new Pedido(refPed, refProd, orden);
			Connect.getIDao().añadirPedido(p);
		} else {
			existePedidoException();
		}
	}
	
	public void addPedidoProducto(String refPed, String refProd, int necesidad) {
		if(Connect.getIDao().existsPedidoProducto(refPed, refProd) == false) {
			PedidoProducto p = new PedidoProducto(refPed, refProd, necesidad);
			Connect.getIDao().añadirPedidoProducto(p);
		}
	}
	
	public void addPedidoKit(String refPed, String refKit, int necesidadProd) {
		if(Connect.getIDao().existsPedidoKit(refPed, refKit) == false) {
			PedidoKit k = new PedidoKit(refPed, refKit, necesidadProd);
			Connect.getIDao().añadirPedidoKit(k);
		}
	}
	
	public boolean existsPedido(String refPed) {
		boolean existe;
		existe = Connect.getIDao().existsPedido(refPed);
		return existe;
	}
	
	public Pedido getPedido(String refPed) {
		Pedido p = Connect.getIDao().getPedido(refPed);
		return p;
	}
	
	public PedidoKit getPedidoKit(String refPed, String refKit) {
		PedidoKit p = Connect.getIDao().getPedidoKit(refPed, refKit);
		return p;
	}
	
	public PedidoProducto getPedidoProducto(String refPed, String refProd) {
		PedidoProducto p = Connect.getIDao().getPedidoProducto(refPed, refProd);
		return p;
	}
	
	public void borrarPedido(String refPed) {
		Pedido p = getPedido(refPed);
		Connect.getIDao().borrarPedido(p);
	}
	
	public void borrarPedidoKit(String referenciaPedido, String refKit) {
		// TODO Auto-generated method stub
		PedidoKit p = getPedidoKit(referenciaPedido, refKit);
		Connect.getIDao().borrarPedidoKit(p);
	}
	
	public void borrarPedidoProducto(String referenciaPedido, String refProd) {
		// TODO Auto-generated method stub
		PedidoProducto p = getPedidoProducto(referenciaPedido, refProd);
		Connect.getIDao().borrarPedidoProducto(p);
	}
	
	public void modificarPedido(String refPed, String refProd, String udProd) {
		int orden = Integer.parseInt(udProd);
		Pedido p = getPedido(refPed);
		p.setRefProd(refProd);
		p.setOrden(orden);
		Connect.getIDao().modificarPedido(p);
	}
	
	public List<Pedido> getPedidos() {
		List <Pedido> lista = Connect.getIDao().getPedidos();
		return lista;
	}
	
	public List<PedidoProducto> getPedidoProductos() {
		List <PedidoProducto> lista = Connect.getIDao().getPedidoProductos();
		return lista;
	}
	
	public List<PedidoKit> getPedidoKits() {
		List <PedidoKit> lista = Connect.getIDao().getPedidoKits();
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
