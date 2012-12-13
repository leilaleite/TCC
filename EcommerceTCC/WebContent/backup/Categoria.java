package ecommerce.model.backup;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idcategoria;

	@Column(name="bem_casado")
	private String bemCasado;

	@Column(name="bem_nascido")
	private String bemNascido;

	@Column(name="bem_sucedido")
	private String bemSucedido;

	@Column(name="bem_vivido")
	private String bemVivido;

	private String lembrancinha;

	private String presente;

	//bi-directional many-to-one association to Produto
	@OneToMany(mappedBy="categoriaBean")
	private Set<Produto> produtos;

    public Categoria() {
    }

	public int getIdcategoria() {
		return this.idcategoria;
	}

	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getBemCasado() {
		return this.bemCasado;
	}

	public void setBemCasado(String bemCasado) {
		this.bemCasado = bemCasado;
	}

	public String getBemNascido() {
		return this.bemNascido;
	}

	public void setBemNascido(String bemNascido) {
		this.bemNascido = bemNascido;
	}

	public String getBemSucedido() {
		return this.bemSucedido;
	}

	public void setBemSucedido(String bemSucedido) {
		this.bemSucedido = bemSucedido;
	}

	public String getBemVivido() {
		return this.bemVivido;
	}

	public void setBemVivido(String bemVivido) {
		this.bemVivido = bemVivido;
	}

	public String getLembrancinha() {
		return this.lembrancinha;
	}

	public void setLembrancinha(String lembrancinha) {
		this.lembrancinha = lembrancinha;
	}

	public String getPresente() {
		return this.presente;
	}

	public void setPresente(String presente) {
		this.presente = presente;
	}

	public Set<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}
	
}