/**
 * 
 */
package modelo.Clases;
import javax.persistence.*;
/**
 * @author ALUMNO
 * Los artículos que comercializa la empresa
 */
@Entity
@Table(name="pedido")
public class Pedido {
		@Id
		private String referenciaPedido;
		@Column(name="referenciaProducto")
		private String refProd;
		@Column(name="udsOrdenadas")
		private int orden;

	public Pedido() {
		
	}
	
	public Pedido(String referenciaPedido, String refProd, int orden) {
		this.referenciaPedido=referenciaPedido;
		this.refProd=refProd;
		this.orden=orden;
	}

	public String getReferenciaPedido() {
		return referenciaPedido;
	}

	public void setReferenciaPedido(String referenciaPedido) {
		this.referenciaPedido = referenciaPedido;
	}

	public String getRefProd() {
		return refProd;
	}

	public void setRefProd(String refProd) {
		this.refProd = refProd;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}
}
		