package modelo.Datos;

public class Connect {
	private IDAO iDao = null;

	public Connect() {
		iDao = new DAO();
	}

	public IDAO getIDao() {
		return this.iDao;
	}
}
