package ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cidade database table.
 * 
 */
@Entity
@Table(name="cidade")
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CidadePK id;

	@Column(length=250)
	private String cidade;

	@Column(length=45)
	private String estado;

	//bi-directional many-to-one association to Estado
    @ManyToOne
	@JoinColumn(name="estado_idestado", nullable=false, insertable=false, updatable=false)
	private Estado estadoBean;

    public Cidade() {
    }

	public CidadePK getId() {
		return this.id;
	}

	public void setId(CidadePK id) {
		this.id = id;
	}
	
	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Estado getEstadoBean() {
		return this.estadoBean;
	}

	public void setEstadoBean(Estado estadoBean) {
		this.estadoBean = estadoBean;
	}
	
}