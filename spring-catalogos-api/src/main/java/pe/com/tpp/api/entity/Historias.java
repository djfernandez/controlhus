package pe.com.tpp.api.entity;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	@Column(name = "necesita")
	private String necesita;
	
	@Column(name = "para")
	private String para;
	
	@Column(name = "estado", nullable = false, columnDefinition="int default '1'")
	private Integer estado;

	@Column(name = "registro", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registro;

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

	public Date getRegistro() {
		return registro;
	}

	public void setRegistro(Date registro) {
		this.registro = registro;
	}
	
}
