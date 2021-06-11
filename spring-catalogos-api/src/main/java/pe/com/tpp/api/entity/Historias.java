package pe.com.tpp.api.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "historias")
public class Historias implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_historia")
	private Long id;

	@Column(name = "id_usuario")
	private Long id_usuario;

	@Column(name = "id_como")
	private Long id_como;

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

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Long getId_como() {
		return id_como;
	}

	public void setId_como(Long id_como) {
		this.id_como = id_como;
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

}
