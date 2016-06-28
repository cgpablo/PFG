package modelo.Clases;
import javax.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {
	
	@Id
	private String rol;
	
	public Rol(String rol){
		this.rol = rol;
	}
	
	public Rol(){

	}

	public String getRol() {
		return rol;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}
}
