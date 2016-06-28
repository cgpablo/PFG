package modelo.Clases;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "kitproducto")
public class KitProducto implements Serializable {
	
	@Id
	private String referenciaKit;
	
	@Column(name="productoReferencia")
	private String productoReferencia;
	
	public KitProducto() {
	
	}
	
	public KitProducto(String referenciaKit,String productoReferencia){
		this.referenciaKit = referenciaKit;
		this.productoReferencia = productoReferencia;
	}

	public String getReferenciaKit() {
		return referenciaKit;
	}

	public void setReferenciaKit(String referenciaKit) {
		this.referenciaKit = referenciaKit;
	}

	public String getProductoReferencia() {
		return productoReferencia;
	}

	public void setProductoReferencia(String productoReferencia) {
		this.productoReferencia = productoReferencia;
	}
}