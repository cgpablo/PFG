package modelo.Negocio;

import modelo.Datos.Connect;
import java.util.List;
import modelo.Clases.*;

public class GestorKit {

	public void addKit(String refKit, String refProd, String prod) {
		int udProd = Integer.parseInt(prod);
		if (existsKit(refKit) == false) {
			Kit k = new Kit(refKit, refProd, udProd);
			Connect.getIDao().añadirKit(k);
		} else {
			existeKitException();
		}
	}
	
	public void addKitMaterial(String refKit, String refProd, String prod) {
		int udProd = Integer.parseInt(prod);
		KitMaterial k = new KitMaterial(refKit, refProd, udProd);
		Connect.getIDao().añadirKitMaterial(k);
	}

	public boolean existsKit(String referencia) {
		boolean existe;
		existe = Connect.getIDao().existsKit(referencia);
		return existe;
	}

	public Kit getKit(String referencia) {
		Kit m = Connect.getIDao().getKit(referencia);
		return m;
	}
	
	public KitMaterial getKitMaterial(String referencia, String articuloReferencia) {
		KitMaterial m = Connect.getIDao().getKitMaterial(referencia, articuloReferencia);
		return m;
	}

	public void borrarKit(String referencia) {
		Kit k = getKit(referencia);
		Connect.getIDao().borrarKit(k);
	}
	
	public void borrarKitMaterial(String referenciaKit, String articuloReferencia) {
		// TODO Auto-generated method stub
		KitMaterial p = getKitMaterial(referenciaKit, articuloReferencia);
		Connect.getIDao().borrarKitMaterial(p);
	}

	public void modificarKit(String refKit, String refProd, String prod) {
		int udProd = Integer.parseInt(prod);
//		int udMat = Integer.parseInt(mat);
		Kit k = getKit(refKit);
		k.setRefProd(refProd);
		k.setUdProd(udProd);
//		k.setRefMat(refMat);
//		k.setUdMat(udMat);
		Connect.getIDao().modificarKit(k);
	}

	public List<Kit> getKits() {
		List<Kit> lista = Connect.getIDao().getKits();
		return lista;
	}
	
	public List<KitMaterial> getKitMateriales() {
		List<KitMaterial> lista = Connect.getIDao().getKitMateriales();
		return lista;
	}

	public String existeKitException() {
		String mensaje = "Ya existe este kit";
		return mensaje;
	}

	public String noExisteKitException() {
		String mensaje = "No existe este kit";
		return mensaje;
	}
}
