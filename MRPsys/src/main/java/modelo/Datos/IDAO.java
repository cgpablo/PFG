package modelo.Datos;
import java.util.List;
import modelo.Clases.Kit;
import modelo.Clases.KitMaterial;
import modelo.Clases.KitProducto;
import modelo.Clases.Material;
import modelo.Clases.Pedido;
import modelo.Clases.PedidoKit;
import modelo.Clases.PedidoProducto;
import modelo.Clases.Producto;
import modelo.Clases.Usuario;
import modelo.Clases.Rol;
import modelo.Clases.RolUsuario;

public interface IDAO {
	
	public void añadirRol(Rol entity);
	public Rol getRol(String rol);
	public boolean existsRol(String rol);
	public void modificarRol(Rol entity);
	public void borrarRol(Rol entity);
	public List<Rol> getRoles();
	
	public void añadirUsuario(Usuario entity);
	public Usuario getUsuario(String username);
	public boolean existsUsuario(String username);
	public void modificarUsuario(Usuario entity);
	public void borrarUsuario(Usuario entity);
	public List<Usuario> getUsuarios();
	
	public void añadirRolUsuario(RolUsuario entity);
	public RolUsuario getRolUsuario(String rol, String username);
	public boolean existsRolUsuario(String rol, String username);
	public void modificarRolUsuario(RolUsuario entity);
	public void borrarRolUsuario(RolUsuario entity);
	public List<RolUsuario> getRolUsuarios();

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
	
	public void añadirKitMaterial(KitMaterial entity);
	public KitMaterial getKitMaterial(String refKit, String refMat);
	public boolean existsKitMaterial(String refKit, String refMat);
	public void modificarKitMaterial(KitMaterial entity);
	public void borrarKitMaterial(KitMaterial entity);
	public List<KitMaterial> getKitMateriales();
	
	public void añadirKitProducto(KitProducto entity);
	public KitProducto getKitProducto(String refKit, String refProd);
	public boolean existsKitProducto(String refKit, String refProd);
	public void modificarKitProducto(KitProducto entity);
	public void borrarKitProducto(KitProducto entity);
	public List<KitProducto> getKitProductos();
	
	public void añadirPedido(Pedido entity);
	public Pedido getPedido(String refPed);
	public boolean existsPedido(String refPed);
	public void modificarPedido(Pedido entity);
	public void borrarPedido(Pedido entity);
	public List<Pedido> getPedidos();
	
	public void añadirPedidoKit(PedidoKit entity);
	public PedidoKit getPedidoKit(String refPed, String refKit);
	public boolean existsPedidoKit(String refPed, String refKit);
	public void modificarPedidoKit(PedidoKit entity);
	public void borrarPedidoKit(PedidoKit entity);
	public List<PedidoKit> getPedidoKits();
	
	public void añadirPedidoProducto(PedidoProducto entity);
	public PedidoProducto getPedidoProducto(String refPed, String refProd);
	public boolean existsPedidoProducto(String refPed, String refProd);
	public void modificarPedidoProducto(PedidoProducto entity);
	public void borrarPedidoProducto(PedidoProducto entity);
	public List<PedidoProducto> getPedidoProductos();
	
}
