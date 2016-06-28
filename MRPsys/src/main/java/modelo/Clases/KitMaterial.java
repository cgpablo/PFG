package modelo.Clases;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "kitmaterial")
public class KitMaterial implements Serializable {
	
	@Id
	private String referenciaKit;
	
	@Column(name="articuloReferencia")
	private String articuloReferencia;
	
	@Column(name="udsRequeridas")
	private int udsRequeridas;
	
	public KitMaterial() {
		
	}
	
	public KitMaterial(String referenciaKit, String articuloReferencia, int udsRequeridas){
		this.referenciaKit = referenciaKit;
		this.articuloReferencia = articuloReferencia;
		this.udsRequeridas = udsRequeridas;
	}

	public String getReferenciaKit() {
		return referenciaKit;
	}

	public void setReferenciaKit(String referenciaKit) {
		this.referenciaKit = referenciaKit;
	}

	public String getArticuloReferencia() {
		return articuloReferencia;
	}

	public void setArticuloReferencia(String articuloReferencia) {
		this.articuloReferencia = articuloReferencia;
	}

	public int getUdsRequeridas() {
		return udsRequeridas;
	}

	public void setUdsRequeridas(int udsRequeridas) {
		this.udsRequeridas = udsRequeridas;
	}
}