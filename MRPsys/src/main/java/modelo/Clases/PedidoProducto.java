package modelo.Clases;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "pedidoproducto")
public class PedidoProducto implements Serializable {
	
	@Id
	private String referenciaPedido;
	
	@Id
	private String productoReferencia;
	
	@Column(name = "necesidad")
	int necesidad;
	
	public PedidoProducto(){
		
	}
	
	public PedidoProducto(String referenciaPedido,String productoReferencia, int necesidad){
		this.referenciaPedido = referenciaPedido;
		this.productoReferencia = productoReferencia;
		this.necesidad = necesidad;
	}

	public String getProductoReferencia() {
		return productoReferencia;
	}

	public void setProductoReferencia(String productoReferencia) {
		this.productoReferencia = productoReferencia;
	}

	public String getReferenciaPedido() {
		return referenciaPedido;
	}

	public void setReferenciaPedido(String referenciaPedido) {
		this.referenciaPedido = referenciaPedido;
	}
	
	public int getNecesidad() {
		return necesidad;
	}
	
	public void setNecesidad(int necesidad) {
		this.necesidad = necesidad;
	}
}