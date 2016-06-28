package modelo.Clases;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "pedidokit")
public class PedidoKit implements Serializable {
	
	@Id
	private String referenciaPedido;
	
	@Id
	private String referenciaKit;
	
//	@Column(name="necesidadMaterial")
//	private int necesidadMat;
	
	@Column(name="necesidadProducto")
	private int necesidadProd;
	
	public PedidoKit(){
		
	}
	
	public PedidoKit(String referenciaPedido,String referenciaKit, int necesidadProd){
		this.referenciaPedido = referenciaPedido;
		this.referenciaKit = referenciaKit;
//		this.necesidadMat = necesidadMat;
		this.necesidadProd = necesidadProd;
	}

	public String getReferenciaPedido() {
		return referenciaPedido;
	}

	public void setReferenciaPedido(String referenciaPedido) {
		this.referenciaPedido = referenciaPedido;
	}

	public String getReferenciaKit() {
		return referenciaKit;
	}

	public void setReferenciaKit(String referenciaKit) {
		this.referenciaKit = referenciaKit;
	}
	
//	public int getNecesidadMat() {
//		return necesidadMat;
//	}
//	
//	public void setNecesidadMat(int necesidadMat) {
//		this.necesidadMat = necesidadMat;
//	}
	
	public int getNecesidadProd() {
		return necesidadProd;
	}
	
	public void setNecesidadProd(int necesidadProd) {
		this.necesidadProd = necesidadProd;
	}
}