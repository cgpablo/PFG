package modelo.Datos;

public class Connect {
	
	public static IDAO iDao = null;

	public Connect() {
		
	}

	public static synchronized IDAO getIDao() {
		if(iDao == null){
			iDao = new DAO();
		}
		return iDao;
	}
}
