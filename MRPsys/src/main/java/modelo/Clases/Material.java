/**
 * 
 */
package modelo.Clases;
import javax.persistence.*;
/**
 * @author ALUMNO
 * Los diferentes materiales que no se comercializan, pero que se utilizan para construir el producto
 */

@Entity
@Table(name="material")
public class Material {
	@Id
	private String referencia;
	@Column(name="nombre")
	private String nombre;
	@Column(name="idioma")
	private String idioma;
	@Column(name="elemento")
	private String elemento;
	@Column(name="leadTime")
	private int lead;
	@Column(name="stockReal")
	private int real;
	@Column(name="stockSeguridad")
	private int seguridad;
	@Column(name="stockVirtual")
	private int virtual;
	
	public Material() {
		
	}
	
	public Material(String referencia, String nombre, String idioma, String elemento, int lead, int real, int seguridad, int virtual) {
		this.referencia=referencia;
		this.nombre=nombre;
		this.idioma=idioma;
		this.elemento=elemento;
		this.referencia=referencia;
		this.lead=lead;
		this.real=real;
		this.seguridad=seguridad;
		this.virtual=virtual;
	}
	
	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public int getLead() {
		return lead;
	}

	public void setLead(int lead) {
		this.lead = lead;
	}

	public int getReal() {
		return real;
	}

	public void setReal(int real) {
		this.real = real;
	}

	public int getSeguridad() {
		return seguridad;
	}

	public void setSeguridad(int seguridad) {
		this.seguridad = seguridad;
	}

	public int getVirtual() {
		return virtual;
	}

	public void setVirtual(int virtual) {
		this.virtual = virtual;
	}	
}
