package modelo.Negocio;

import modelo.Datos.*;

import java.util.List;

import modelo.Clases.*;

public class GestorKit {

	Connect con = new Connect();

	public void addKit(String refKit, String refProd, String prod, String refMat, String mat) {
		int udProd = Integer.parseInt(prod);
		int udMat = Integer.parseInt(mat);
		if (existsKit(refKit) == false) {
			Kit k = new Kit(refKit, refProd, udProd, refMat, udMat);
			con.getIDao().añadirKit(k);
		} else {
			existeKitException();
		}
	}

	public boolean existsKit(String referencia) {
		boolean existe;
		existe = con.getIDao().existsKit(referencia);
		return existe;
	}

	public Kit getKit(String referencia) {
		Kit m = con.getIDao().getKit(referencia);
		return m;
	}

	public void borrarKit(String referencia) {
		Kit k = getKit(referencia);
		con.getIDao().borrarKit(k);
	}

	public void modificarKit(String refKit, String refProd, String prod, String refMat, String mat) {
		int udProd = Integer.parseInt(prod);
		int udMat = Integer.parseInt(mat);
		Kit k = getKit(refKit);
		k.setRefProd(refProd);
		k.setUdProd(udProd);
		k.setRefMat(refMat);
		k.setUdMat(udMat);
		con.getIDao().modificarKit(k);
	}

	public List<Kit> getKits() {
		List<Kit> lista = con.getIDao().getKits();
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
