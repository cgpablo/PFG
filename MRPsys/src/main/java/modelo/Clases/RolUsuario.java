package modelo.Clases;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "rolusuario")
public class RolUsuario implements Serializable {
	
	@Id
	private String username;
	
	@Id
	private String rol;
	
	public RolUsuario(){
		
	}

	public RolUsuario(String username,String rol){
		this.username = username;
		this.rol = rol;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getRol() {
		return rol;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}
}
