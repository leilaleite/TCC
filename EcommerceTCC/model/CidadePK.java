package ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the cidade database table.
 * 
 */
@Embeddable
public class CidadePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private int idcidade;

	@Column(name="endereco_idendereco", unique=true, nullable=false)
	private int enderecoIdendereco;

	@Column(name="estado_idestado", unique=true, nullable=false)
	private int estadoIdestado;

    public CidadePK() {
    }
	public int getIdcidade() {
		return this.idcidade;
	}
	public void setIdcidade(int idcidade) {
		this.idcidade = idcidade;
	}
	public int getEnderecoIdendereco() {
		return this.enderecoIdendereco;
	}
	public void setEnderecoIdendereco(int enderecoIdendereco) {
		this.enderecoIdendereco = enderecoIdendereco;
	}
	public int getEstadoIdestado() {
		return this.estadoIdestado;
	}
	public void setEstadoIdestado(int estadoIdestado) {
		this.estadoIdestado = estadoIdestado;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CidadePK)) {
			return false;
		}
		CidadePK castOther = (CidadePK)other;
		return 
			(this.idcidade == castOther.idcidade)
			&& (this.enderecoIdendereco == castOther.enderecoIdendereco)
			&& (this.estadoIdestado == castOther.estadoIdestado);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idcidade;
		hash = hash * prime + this.enderecoIdendereco;
		hash = hash * prime + this.estadoIdestado;
		
		return hash;
    }
}