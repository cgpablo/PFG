/**
 * 
 */
package modelo.Clases;
import java.io.*;
import javax.persistence.*;
/**
 * @author ALUMNO
 * La clase hace referencia a qué materiales están implicados en la creación de cada producto
 */
@Entity
@Table(name="kit")
public class Kit implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private String referencia;
	@Column(name="referenciaProducto")
	private String refProd;
	@Column(name="udProductoRequeridas")
	private int udProd;
	@Column(name="referenciaMaterial")
	private String refMat;
	@Column(name="udMaterialRequeridas")
	private int udMat;	
	/**
	 * 
	 */
	
	public Kit() {
		
	}

	public Kit(String referenciaKit,String refProd, int udProd, String refMat, int udMat) {
		this.referencia=referenciaKit;
		this.refProd=refProd;
		this.udProd=udProd;
		this.refMat=refMat;
		this.udMat=udMat;
	}
	
	public String getReferencia() {
		return referencia;
	}

	public void setReferenciaKit(String refKit) {
		this.referencia = refKit;
	}

	public String getRefProd() {
		return refProd;
	}

	public void setRefProd(String refProd) {
		this.refProd = refProd;
	}

	public int getUdProd() {
		return udProd;
	}

	public void setUdProd(int udProd) {
		this.udProd = udProd;
	}

	public String getRefMat() {
		return refMat;
	}

	public void setRefMat(String refMat) {
		this.refMat = refMat;
	}

	public int getUdMat() {
		return udMat;
	}

	public void setUdMat(int udMat) {
		this.udMat = udMat;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
