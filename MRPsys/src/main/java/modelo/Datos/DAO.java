package modelo.Datos;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import modelo.Clases.Kit;
import modelo.Clases.KitMaterial;
import modelo.Clases.KitProducto;
import modelo.Clases.Material;
import modelo.Clases.Pedido;
import modelo.Clases.PedidoProducto;
import modelo.Clases.PedidoKit;
import modelo.Clases.Producto;
import modelo.Clases.Usuario;
import modelo.Clases.Rol;
import modelo.Clases.RolUsuario;

public class DAO implements IDAO {

	private SessionFactory sessionFactory;

	public DAO() {
		sessionFactory = createSessionFactory();
	}

	private static SessionFactory createSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void añadirRol(Rol entity) {
		// TODO Auto-generated method stub
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(entity);
		tx.commit();
		session.close();
	}

	public Rol getRol(String rol) {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Rol Rol = null;
		Transaction tx = session.beginTransaction();
		Rol = (Rol) session.get(Rol.class, rol);
		tx.commit();
		session.close();
		return Rol;
	}

	public boolean existsRol(String username) {
		// TODO Auto-generated method stub
		boolean exists = false;
		if (getRol(username) != null) {
			exists = true;
		}
		return exists;
	}

	public void modificarRol(Rol entity) {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		session.update(entity);
		tx.commit();
		session.close();
	}

	public void borrarRol(Rol entity) {
		// TODO Auto-generated method stub
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(entity);
		tx.commit();
		session.close();
	}

	public List<Rol> getRoles() {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(Rol.class);
		@SuppressWarnings("unchecked")
		List<Rol> listaRoles = criteria.list();

		tx.commit();
		session.close();

		return listaRoles;
	}

	public void añadirUsuario(Usuario entity) {
		// TODO Auto-generated method stub
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(entity);
		tx.commit();
		session.close();
	}

	public Usuario getUsuario(String username) {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Usuario usuario = null;
		Transaction tx = session.beginTransaction();
		usuario = (Usuario) session.get(Usuario.class, username);
		tx.commit();
		session.close();
		return usuario;
	}

	public boolean existsUsuario(String username) {
		// TODO Auto-generated method stub
		boolean exists = false;
		if (getUsuario(username) != null) {
			exists = true;
		}
		return exists;
	}

	public void modificarUsuario(Usuario entity) {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		session.update(entity);
		tx.commit();
		session.close();
	}

	public void borrarUsuario(Usuario entity) {
		// TODO Auto-generated method stub
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(entity);
		tx.commit();
		session.close();
	}

	public List<Usuario> getUsuarios() {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(Usuario.class);
		@SuppressWarnings("unchecked")
		List<Usuario> listaUsuarios = criteria.list();

		tx.commit();
		session.close();

		return listaUsuarios;
	}

	public void añadirRolUsuario(RolUsuario entity) {
		// TODO Auto-generated method stub
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(entity);
		tx.commit();
		session.close();
	}

	public RolUsuario getRolUsuario(String rol, String username) {
		RolUsuario rolUsuario = null;
		for (RolUsuario ru : getRolUsuarios()) {
			if (ru.getUsername().equals(username)) {
				rolUsuario = ru;
			}
		}
		return rolUsuario;
	}

	public boolean existsRolUsuario(String rol, String username) {
		// TODO Auto-generated method stub
		boolean exists = false;
		if (getRolUsuario(rol, username) != null) {
			exists = true;
		}
		return exists;
	}

	public void modificarRolUsuario(RolUsuario entity) {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		session.update(entity);
		tx.commit();
		session.close();
	}

	public void borrarRolUsuario(RolUsuario entity) {
		// TODO Auto-generated method stub
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(entity);
		tx.commit();
		session.close();
	}

	public List<RolUsuario> getRolUsuarios() {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(RolUsuario.class);
		@SuppressWarnings("unchecked")
		List<RolUsuario> listaRolUsuarios = criteria.list();

		tx.commit();
		session.close();

		return listaRolUsuarios;
	}

	public void añadirProducto(Producto entity) {
		// TODO Auto-generated method stub
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(entity);
		tx.commit();
		session.close();
	}

	public Producto getProducto(String refProd) {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Producto producto = null;
		Transaction tx = session.beginTransaction();
		producto = (Producto) session.get(Producto.class, refProd);
		tx.commit();
		session.close();
		return producto;
	}

	public boolean existsProducto(String refProd) {
		// TODO Auto-generated method stub
		boolean exists = false;
		if (getProducto(refProd) != null) {
			exists = true;
		}
		return exists;
	}

	public void modificarProducto(Producto entity) {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		session.update(entity);
		tx.commit();
		session.close();
	}

	public void borrarProducto(Producto entity) {
		// TODO Auto-generated method stub
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(entity);
		tx.commit();
		session.close();
	}

	public List<Producto> getProductos() {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Producto.class);
		@SuppressWarnings("unchecked")
		List<Producto> listaProductos = criteria.list();
		tx.commit();
		session.close();
		return listaProductos;
	}

	public void añadirMaterial(Material entity) {
		// TODO Auto-generated method stub
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(entity);
		tx.commit();
		session.close();
	}

	public Material getMaterial(String refMat) {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Material material = null;
		Transaction tx = session.beginTransaction();
		material = (Material) session.get(Material.class, refMat);
		tx.commit();
		session.close();
		return material;
	}

	public boolean existsMaterial(String refMat) {
		// TODO Auto-generated method stub
		boolean exists = false;
		if (getMaterial(refMat) != null) {
			exists = true;
		}
		return exists;
	}

	public void modificarMaterial(Material entity) {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		session.update(entity);
		tx.commit();
		session.close();
	}

	public void borrarMaterial(Material entity) {
		// TODO Auto-generated method stub
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(entity);
		tx.commit();
		session.close();
	}

	public List<Material> getMateriales() {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Material.class);
		@SuppressWarnings("unchecked")
		List<Material> listaMateriales = criteria.list();
		tx.commit();
		session.close();
		return listaMateriales;
	}

	public void añadirKit(Kit entity) {
		// TODO Auto-generated method stub
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(entity);
		tx.commit();
		session.close();
	}

	public Kit getKit(String refKit) {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Kit kit = null;
		Transaction tx = session.beginTransaction();
		kit = (Kit) session.get(Kit.class, refKit);
		tx.commit();
		session.close();
		return kit;
	}

	public boolean existsKit(String refKit) {
		// TODO Auto-generated method stub
		boolean exists = false;
		if (getKit(refKit) != null) {
			exists = true;
		}
		return exists;
	}

	public void modificarKit(Kit entity) {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		session.update(entity);
		tx.commit();
		session.close();
	}

	public void borrarKit(Kit entity) {
		// TODO Auto-generated method stub
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(entity);
		tx.commit();
		session.close();
	}

	public List<Kit> getKits() {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Kit.class);
		@SuppressWarnings("unchecked")
		List<Kit> listaKits = criteria.list();
		tx.commit();
		session.close();
		return listaKits;
	}

	public void añadirKitMaterial(KitMaterial entity) {
		// TODO Auto-generated method stub
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(entity);
		tx.commit();
		session.close();
	}

	public KitMaterial getKitMaterial(String refKit, String refMat) {
		// TODO Auto-generated method stub
		KitMaterial kitMaterial = null;
		for (KitMaterial km : getKitMateriales()) {
			if (km.getArticuloReferencia().equals(refMat)) {
				kitMaterial = km;
			}
		}
		return kitMaterial;
	}

	public boolean existsKitMaterial(String refKit, String refMat) {
		// TODO Auto-generated method stub
		boolean exists = false;
		if (getKitMaterial(refKit, refMat) != null) {
			exists = true;
		}
		return exists;
	}

	public void modificarKitMaterial(KitMaterial entity) {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		session.update(entity);
		tx.commit();
		session.close();
	}

	public void borrarKitMaterial(KitMaterial entity) {
		// TODO Auto-generated method stub
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(entity);
		tx.commit();
		session.close();
	}

	public List<KitMaterial> getKitMateriales() {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(KitMaterial.class);
		@SuppressWarnings("unchecked")
		List<KitMaterial> listaKitMateriales = criteria.list();
		tx.commit();
		session.close();
		return listaKitMateriales;
	}

	public void añadirKitProducto(KitProducto entity) {
		// TODO Auto-generated method stub
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(entity);
		tx.commit();
		session.close();
	}

	public KitProducto getKitProducto(String refKit, String refProd) {
		// TODO Auto-generated method stub
		KitProducto kitProducto = null;
		for (KitProducto kp : getKitProductos()) {
			if (kp.getProductoReferencia().equals(refProd)) {
				kitProducto = kp;
			}
		}
		return kitProducto;
	}

	public boolean existsKitProducto(String refKit, String refProd) {
		// TODO Auto-generated method stub
		boolean exists = false;
		if (getKitProducto(refKit, refProd) != null) {
			exists = true;
		}
		return exists;
	}

	public void modificarKitProducto(KitProducto entity) {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		session.update(entity);
		tx.commit();
		session.close();
	}

	public void borrarKitProducto(KitProducto entity) {
		// TODO Auto-generated method stub
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(entity);
		tx.commit();
		session.close();
	}

	public List<KitProducto> getKitProductos() {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(KitMaterial.class);
		@SuppressWarnings("unchecked")
		List<KitProducto> listaKitProductos = criteria.list();
		tx.commit();
		session.close();
		return listaKitProductos;
	}

	public void añadirPedido(Pedido entity) {
		// TODO Auto-generated method stub
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(entity);
		tx.commit();
		session.close();
	}

	public Pedido getPedido(String refPed) {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Pedido pedido = null;
		Transaction tx = session.beginTransaction();
		pedido = (Pedido) session.get(Pedido.class, refPed);
		tx.commit();
		session.close();
		return pedido;
	}

	public boolean existsPedido(String refPed) {
		// TODO Auto-generated method stub
		boolean exists = false;
		if (getPedido(refPed) != null) {
			exists = true;
		}
		return exists;
	}

	public void modificarPedido(Pedido entity) {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		session.update(entity);
		tx.commit();
		session.close();
	}

	public void borrarPedido(Pedido entity) {
		// TODO Auto-generated method stub
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(entity);
		tx.commit();
		session.close();
	}

	public List<Pedido> getPedidos() {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Pedido.class);
		@SuppressWarnings("unchecked")
		List<Pedido> listaPedidos = criteria.list();
		tx.commit();
		session.close();
		return listaPedidos;
	}

	public void añadirPedidoProducto(PedidoProducto entity) {
		// TODO Auto-generated method stub
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(entity);
		tx.commit();
		session.close();
	}

	public PedidoProducto getPedidoProducto(String refPed, String refProd) {
		// TODO Auto-generated method stub
		PedidoProducto pedidoProducto = null;
		for(PedidoProducto pp: getPedidoProductos()) {
			if(pp.getProductoReferencia().equals(refProd)) {
				pedidoProducto = pp;
			}
		}
		return pedidoProducto;
	}

	public boolean existsPedidoProducto(String refPed, String refProd) {
		// TODO Auto-generated method stub
		boolean exists = false;
		if (getPedidoProducto(refPed, refProd) != null) {
			exists = true;
		}
		return exists;
	}

	public void modificarPedidoProducto(PedidoProducto entity) {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		session.update(entity);
		tx.commit();
		session.close();
	}

	public void borrarPedidoProducto(PedidoProducto entity) {
		// TODO Auto-generated method stub
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(entity);
		tx.commit();
		session.close();
	}

	public List<PedidoProducto> getPedidoProductos() {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(PedidoProducto.class);
		@SuppressWarnings("unchecked")
		List<PedidoProducto> listaPedidoProductos = criteria.list();
		tx.commit();
		session.close();
		return listaPedidoProductos;
	}
	
	public void añadirPedidoKit(PedidoKit entity) {
		// TODO Auto-generated method stub
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(entity);
		tx.commit();
		session.close();
	}

	public PedidoKit getPedidoKit(String refPed, String refKit) {
		// TODO Auto-generated method stub
		PedidoKit pedidoKit = null;
		for(PedidoKit pk: getPedidoKits()) {
			if(pk.getReferenciaKit().equals(refKit)) {
				pedidoKit = pk;
			}
		}
		return pedidoKit;
	}

	public boolean existsPedidoKit(String refPed, String refKit) {
		// TODO Auto-generated method stub
		boolean exists = false;
		if (getPedidoKit(refPed, refKit) != null) {
			exists = true;
		}
		return exists;
	}

	public void modificarPedidoKit(PedidoKit entity) {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		session.update(entity);
		tx.commit();
		session.close();
	}

	public void borrarPedidoKit(PedidoKit entity) {
		// TODO Auto-generated method stub
		SessionFactory factory = getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(entity);
		tx.commit();
		session.close();
	}

	public List<PedidoKit> getPedidoKits() {
		// TODO Auto-generated method stub
		SessionFactory sesion = getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(PedidoKit.class);
		@SuppressWarnings("unchecked")
		List<PedidoKit> listaPedidoKits = criteria.list();
		tx.commit();
		session.close();
		return listaPedidoKits;
	}
}
