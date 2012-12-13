package ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuarioPK id;

	@Column(nullable=false, length=45)
	private String nome;

	//bi-directional many-to-one association to Tipodeusuario
    @ManyToOne
	@JoinColumn(name="tipodeusuario_idtipodeusuario", nullable=false, insertable=false, updatable=false)
	private Tipodeusuario tipodeusuario1;

	//bi-directional many-to-one association to Tipodeusuario
    @ManyToOne
	@JoinColumn(name="tipodeusuario_idtipodeusuario1", nullable=false, insertable=false, updatable=false)
	private Tipodeusuario tipodeusuario2;

    public Usuario() {
    }

	public UsuarioPK getId() {
		return this.id;
	}

	public void setId(UsuarioPK id) {
		this.id = id;
	}
	
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Tipodeusuario getTipodeusuario1() {
		return this.tipodeusuario1;
	}

	public void setTipodeusuario1(Tipodeusuario tipodeusuario1) {
		this.tipodeusuario1 = tipodeusuario1;
	}
	
	public Tipodeusuario getTipodeusuario2() {
		return this.tipodeusuario2;
	}

	public void setTipodeusuario2(Tipodeusuario tipodeusuario2) {
		this.tipodeusuario2 = tipodeusuario2;
	}
	
}