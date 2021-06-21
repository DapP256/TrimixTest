package trimix.test.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Persona")
public class Persona implements Serializable{
	
	@Id
	@Column(name="perId", nullable = false)
	private long perId;
	
	@Column( nullable = false)
	private String perTipoDocumento;
	
	@Column(nullable = false)
	private long perNumeroDocumento;
	
	@Column(nullable = false)
	private String perNombre;
	
	@Column(nullable = false)
	private String perApellido;
	
	@Column(nullable = false)
	private Date perFechaNacimiento;

	public long getPerId() {
		return perId;
	}

	public void setPerId(long perId) {
		this.perId = perId;
	}

	public String getPerTipoDocumento() {
		return perTipoDocumento;
	}

	public void setPerTipoDocumento(String perTipoDocumento) {
		this.perTipoDocumento = perTipoDocumento;
	}

	public long getPerNumeroDocumento() {
		return perNumeroDocumento;
	}

	public void setPerNumeroDocumento(long perNumeroDocumento) {
		this.perNumeroDocumento = perNumeroDocumento;
	}

	public String getPerNombre() {
		return perNombre;
	}

	public void setPerNombre(String perNombre) {
		this.perNombre = perNombre;
	}

	public String getPerApellido() {
		return perApellido;
	}

	public void setPerApellido(String perApellido) {
		this.perApellido = perApellido;
	}

	public Date getPerFechaNacimiento() {
		return perFechaNacimiento;
	}

	public void setPerFechaNacimiento(Date perFechaNacimiento) {
		this.perFechaNacimiento = perFechaNacimiento;
	}

	@Override
	public String toString() {
		return "Persona [perId=" + perId + ", perTipoDocumento=" + perTipoDocumento + ", perNumeroDocumento="
				+ perNumeroDocumento + ", perNombre=" + perNombre + ", perApellido=" + perApellido
				+ ", perFechaNacimiento=" + perFechaNacimiento + "]";
	}
	
	
	
	
}
