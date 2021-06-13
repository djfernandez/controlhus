package pe.com.tpp.api.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "historias")
public class Historia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_historia")
	private Long id;

	@ManyToOne
	private Usuario usuario;

	@ManyToOne
	private Persona persona;

	@NotEmpty
	@Column(name = "necesita")
	private String necesita;

	@NotEmpty
	@Column(name = "para")
	private String para;

	@Column(name = "estado")
	private Integer estado;

	@Column(name = "registro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;
	
	@PrePersist
	public void prePersist() {
		fechaRegistro = new Date();
		estado = 1;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNecesita() {
		return necesita;
	}

	public void setNecesita(String necesita) {
		this.necesita = necesita;
	}

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	

}
