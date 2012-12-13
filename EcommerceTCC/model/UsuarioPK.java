package ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the usuario database table.
 * 
 */
@Embeddable
public class UsuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private int cpf;

	@Column(name="tipodeusuario_idtipodeusuario", unique=true, nullable=false)
	private int tipodeusuarioIdtipodeusuario;

	@Column(name="tipodeusuario_idtipodeusuario1", unique=true, nullable=false)
	private int tipodeusuarioIdtipodeusuario1;

    public UsuarioPK() {
    }
	public int getCpf() {
		return this.cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getTipodeusuarioIdtipodeusuario() {
		return this.tipodeusuarioIdtipodeusuario;
	}
	public void setTipodeusuarioIdtipodeusuario(int tipodeusuarioIdtipodeusuario) {
		this.tipodeusuarioIdtipodeusuario = tipodeusuarioIdtipodeusuario;
	}
	public int getTipodeusuarioIdtipodeusuario1() {
		return this.tipodeusuarioIdtipodeusuario1;
	}
	public void setTipodeusuarioIdtipodeusuario1(int tipodeusuarioIdtipodeusuario1) {
		this.tipodeusuarioIdtipodeusuario1 = tipodeusuarioIdtipodeusuario1;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UsuarioPK)) {
			return false;
		}
		UsuarioPK castOther = (UsuarioPK)other;
		return 
			(this.cpf == castOther.cpf)
			&& (this.tipodeusuarioIdtipodeusuario == castOther.tipodeusuarioIdtipodeusuario)
			&& (this.tipodeusuarioIdtipodeusuario1 == castOther.tipodeusuarioIdtipodeusuario1);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.cpf;
		hash = hash * prime + this.tipodeusuarioIdtipodeusuario;
		hash = hash * prime + this.tipodeusuarioIdtipodeusuario1;
		
		return hash;
    }
}