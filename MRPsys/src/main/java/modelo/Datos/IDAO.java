package modelo.Datos;

import java.util.List;

import modelo.Clases.Kit;
import modelo.Clases.Material;
import modelo.Clases.Pedido;
import modelo.Clases.Producto;
import modelo.Clases.Usuario;

public interface IDAO {
	
	public void añadirUsuario(Usuario entity);
	public Usuario getUsuario(String username);
	public boolean existsUsuario(String username);
	public void modificarUsuario(Usuario entity);
	public void borrarUsuario(Usuario entity);
	public List<Usuario> getUsuarios();

	public void añadirProducto(Producto entity);
	public Producto getProducto(String refProd);
	public boolean existsProducto(String refProd);
	public void modificarProducto(Producto entity);
	public void borrarProducto(Producto entity);
	public List<Producto> getProductos();
	
	public void añadirMaterial(Material entity);
	public Material getMaterial(String refMat);
	public boolean existsMaterial(String refMat);
	public void modificarMaterial(Material entity);
	public void borrarMaterial(Material entity);
	public List<Material> getMateriales();
	
	public void añadirKit(Kit entity);
	public Kit getKit(String refKit);
	public boolean existsKit(String refKit);
	public void modificarKit(Kit entity);
	public void borrarKit(Kit entity);
	public List<Kit> getKits();
	
	public void añadirPedido(Pedido entity);
	public Pedido getPedido(String refPed);
	public boolean existsPedido(String refPed);
	public void modificarPedido(Pedido entity);
	public void borrarPedido(Pedido entity);
	public List<Pedido> getPedidos();
	
}
