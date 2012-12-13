package ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipodeusuario database table.
 * 
 */
@Entity
@Table(name="tipodeusuario")
public class Tipodeusuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idtipodeusuario;

	private int adm;

	private int cliente;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tipodeusuario1")
	private List<Usuario> usuarios1;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tipodeusuario2")
	private List<Usuario> usuarios2;

    public Tipodeusuario() {
    }

	public int getIdtipodeusuario() {
		return this.idtipodeusuario;
	}

	public void setIdtipodeusuario(int idtipodeusuario) {
		this.idtipodeusuario = idtipodeusuario;
	}

	public int getAdm() {
		return this.adm;
	}

	public void setAdm(int adm) {
		this.adm = adm;
	}

	public int getCliente() {
		return this.cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public List<Usuario> getUsuarios1() {
		return this.usuarios1;
	}

	public void setUsuarios1(List<Usuario> usuarios1) {
		this.usuarios1 = usuarios1;
	}
	
	public List<Usuario> getUsuarios2() {
		return this.usuarios2;
	}

	public void setUsuarios2(List<Usuario> usuarios2) {
		this.usuarios2 = usuarios2;
	}
	
}