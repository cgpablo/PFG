package modelo.Datos;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import modelo.Clases.Kit;
import modelo.Clases.Material;
import modelo.Clases.Pedido;
import modelo.Clases.Producto;
import modelo.Clases.Usuario;

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

}
