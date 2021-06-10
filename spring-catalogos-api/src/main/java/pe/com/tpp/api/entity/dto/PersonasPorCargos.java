package pe.com.tpp.api.entity.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "personasporcargos")
public class PersonasPorCargos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(insertable = false, updatable = false)
	private Long id_persona;
	
	@Column(name = "nombres")
	private String nombres;
	
	@Column(name = "apellidos")
	private	String apellidos;
	
	@Column(name = "nombre")
	private String cargo;	
	
	public Long getId_persona() {
		return id_persona;
	}
	public void setId_persona(Long id_persona) {
		this.id_persona = id_persona;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
}
