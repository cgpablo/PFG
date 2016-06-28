package modelo.Negocio;

import java.util.*;
import modelo.Clases.*;

public class ApplicationService {
	private GestorMaterial GM;
	private GestorProducto GP;
	private GestorPedido GD;
	private GestorUsuario GU;
	private GestorKit GK;
	private static ApplicationService appServ = null;

	public ApplicationService() {
		GM = new GestorMaterial();
		GP = new GestorProducto();
		GD = new GestorPedido();
		GU = new GestorUsuario();
		GK = new GestorKit();
	}

	public static synchronized ApplicationService getInstance() {
		if (appServ == null) {
			appServ = new ApplicationService();
		}
		return appServ;
	}

	/* Material */
	public void nuevoMaterial(String referencia, String nombre, String idioma, String elemento, String lead,
			String seguridad, String virtual) {
		GM.addMaterial(referencia, nombre, idioma, elemento, lead, seguridad, virtual);
	}

	public boolean existsMaterial(String referencia) {
		boolean existe = GM.existsMaterial(referencia);
		return existe;
	}

	public String existeMaterialException() {
		String mensaje = GM.existeMaterialException();
		return mensaje;
	}

	public String noExisteMaterialException() {
		String mensaje = GM.noExisteMaterialException();
		return mensaje;
	}

	public Material getMaterial(String referencia) {
		Material m = GM.getMaterial(referencia);
		return m;
	}

	public List<Material> getMateriales() {
		// TODO Auto-generated method stub
		List<Material> m = GM.getMateriales();
		return m;
	}

	public void borrarMaterial(String referencia) {
		GM.borrarMaterial(referencia);
	}

	public void modificarMaterial(String referencia, String nombre, String idioma, String elemento, String lead,
			String seguridad, String virtual) {
		GM.modificarMaterial(referencia, nombre, idioma, elemento, lead, seguridad, virtual);
	}

	/* Producto */
	public void nuevoProducto(String referencia, String nombre, String idioma, String elemento, String production,
			String seguridad, String virtual) {
		GP.addProducto(referencia, nombre, idioma, elemento, production, seguridad, virtual);
	}

	public boolean existsProducto(String referencia) {
		boolean existe = GP.existsProducto(referencia);
		return existe;
	}

	public String existeProductoException() {
		String mensaje = GP.existeProductoException();
		return mensaje;
	}

	public String noExisteProductoException() {
		String mensaje = GP.noExisteProductoException();
		return mensaje;
	}

	public Producto getProducto(String referencia) {
		Producto p = GP.getProducto(referencia);
		return p;
	}

	public List<Producto> getProductos() {
		// TODO Auto-generated method stub
		List<Producto> p = GP.getProductos();
		return p;
	}

	public void borrarProducto(String referencia) {
		GP.borrarProducto(referencia);
	}

	public void modificarProducto(String referencia, String nombre, String idioma, String elemento, String production,
			String seguridad, String virtual) {
		GP.modificarProducto(referencia, nombre, idioma, elemento, production, seguridad, virtual);
	}

	/* Kit */
	public void nuevoKit(String refKit, String refProd, String prod) {
		GK.addKit(refKit, refProd, prod);
		GK.addKitMaterial(refKit, refProd, prod);
	}
	
	public void añadirArticulo(String refKit, String refProd, String prod) {
		GK.addKitMaterial(refKit, refProd, prod);
	}

	public boolean existsKit(String refKit) {
		boolean existe = GK.existsKit(refKit);
		return existe;
	}

	public String existeKitException() {
		String mensaje = GK.existeKitException();
		return mensaje;
	}

	public String noExisteKitException() {
		String mensaje = GK.noExisteKitException();
		return mensaje;
	}

	public Kit getKit(String refKit) {
		Kit k = GK.getKit(refKit);
		return k;
	}

	public List<Kit> getKits() {
		// TODO Auto-generated method stub
		List<Kit> k = GK.getKits();
		return k;
	}
	
	public List<KitMaterial> getKitMateriales() {
		List<KitMaterial> p = GK.getKitMateriales();
		return p;
	}

	public void borrarKit(String refKit) {
		GK.borrarKit(refKit);
		for(KitMaterial km: getKitMateriales()) {
			GK.borrarKitMaterial(km.getReferenciaKit(), km.getArticuloReferencia());
		}
	}

	public void modificarKit(String refKit, String refProd, String prod) {
		GK.modificarKit(refKit, refProd, prod);
	}

	/* Pedido */
	public void nuevoPedido(String refPed, String refProd, String orden) {
		GD.addPedido(refPed, refProd, orden);
	}

	public boolean existsPedido(String refPed) {
		boolean existe = GD.existsPedido(refPed);
		return existe;
	}

	public String existePedidoException() {
		String mensaje = GD.existePedidoException();
		return mensaje;
	}

	public String noExistePedidoException() {
		String mensaje = GD.noExistePedidoException();
		return mensaje;
	}

	public Pedido getPedido(String refPed) {
		Pedido p = GD.getPedido(refPed);
		return p;
	}

	public List<Pedido> getPedidos() {
		List<Pedido> p = GD.getPedidos();
		return p;
	}

	public List<String> getListaEleccionPedido() {
		List<String> lista = new ArrayList<String>();
		List<Producto> productos = getProductos();
		List<Kit> kits = getKits();

		for (Producto p : productos) {
			lista.add(p.getReferencia());
		}

		for (Kit k : kits) {
			lista.add(k.getReferencia());
		}

		return lista;
	}
	
	public List<String> getListaEleccionKit() {
		List<String> lista = new ArrayList<String>();
		List<Producto> productos = getProductos();
		List<Material> materiales = getMateriales();

		for (Producto p : productos) {
			lista.add(p.getReferencia());
		}

		for (Material m: materiales) {
			lista.add(m.getReferencia());
		}

		return lista;
	}

	public void añadirCalcularPedido(String referencia) {

		Pedido d = getPedido(referencia);
		List<Producto> productos = getProductos();
		List<Kit> kits = getKits();

		for (Producto p : productos) {
			if (d.getRefProd().equals(p.getReferencia())) {
				int necesidad = p.getReal() - d.getOrden();
				if (necesidad > 0) {
					necesidad = 0;
					GD.addPedidoProducto(d.getReferenciaPedido(), p.getReferencia(), necesidad);
				} else {
					necesidad = necesidad * -1;
					GD.addPedidoProducto(d.getReferenciaPedido(), p.getReferencia(), necesidad);
				}
			}
		}

		for (Kit k : kits) {
			if (d.getRefProd().equals(k.getReferencia())) {
//				int necesidadMat = k.getUdMat() - d.getOrden();
				int necesidadProd = k.getUdProd() - d.getOrden();
//				if (necesidadMat > 0) {
//					necesidadMat = 0;
//				} else if (necesidadMat < 0) {
//					necesidadMat = necesidadMat * -1;
//					GD.addPedidoKit(d.getReferenciaPedido(), k.getReferencia(), necesidadMat, necesidadProd);
//				}
				
				if (necesidadProd > 0) {
					necesidadProd = 0;
					GD.addPedidoKit(d.getReferenciaPedido(), k.getReferencia(), necesidadProd);
				} else if (necesidadProd < 0) {
					necesidadProd = necesidadProd * -1;
				}
				GD.addPedidoKit(d.getReferenciaPedido(), k.getReferencia(), necesidadProd);
			}
		}
	}
	
	public List <PedidoProducto> calcularPedidoProducto(String referencia) {
		List <PedidoProducto> list = new ArrayList<PedidoProducto>();
		List <PedidoProducto> pp = GD.getPedidoProductos();
		
		for(PedidoProducto p: pp) {
			if(referencia.equals(p.getReferenciaPedido())) {
				list.add(p);
			}
		}
		return list;
	}
	
	public List <PedidoKit> calcularPedidoKit(String referencia) {
		List <PedidoKit> list = new ArrayList<PedidoKit>();
		List <PedidoKit> pk = GD.getPedidoKits();
		
		for(PedidoKit k: pk) {
			if(referencia.equals(k.getReferenciaPedido())) {
				list.add(k);
			}
		}
		return list;
	}

	public List<PedidoProducto> getPedidoProductos() {
		List<PedidoProducto> p = GD.getPedidoProductos();
		return p;
	}

	public List<PedidoKit> getPedidoKits() {
		List<PedidoKit> p = GD.getPedidoKits();
		return p;
	}

	public void borrarPedido(String refPed) {
		GD.borrarPedido(refPed);
		for(PedidoKit pk: getPedidoKits()) {
			GD.borrarPedidoKit(pk.getReferenciaPedido(), pk.getReferenciaKit());
		}
		for(PedidoProducto pp: getPedidoProductos()) {
			GD.borrarPedidoProducto(pp.getReferenciaPedido(), pp.getProductoReferencia());
		}
	}

	public void modificarPedido(String refPed, String refProd, String orden) {
		GD.modificarPedido(refPed, refProd, orden);
	}

	/* Usuario */
	public void nuevoUsuario(String username, String mail, String password) {
		GU.addUsuario(username, mail, password);
	}

	public boolean existsUsuario(String username) {
		boolean existe = GU.existsUsuario(username);
		return existe;
	}

	public String existeUsuarioException() {
		String mensaje = GU.existeUsuarioException();
		return mensaje;
	}

	public String noExisteUsuarioException() {
		String mensaje = GU.noExisteUsuarioException();
		return mensaje;
	}

	public Usuario getUsuario(String username) {
		Usuario u = GU.getUsuario(username);
		return u;
	}

	public List<Usuario> getUsuarios() {
		List<Usuario> u = GU.getUsuarios();
		return u;
	}

	public void borrarUsuario(String username) {
		GU.borrarUsuario(username);
	}

	public void modificarUsuario(String username, String mail, String password) {
		GU.modificarUsuario(username, mail, password);
	}

	/* LogIn */
	public void logIn(String username, String password) {
		GU.logIn(username, password);
	}
}
