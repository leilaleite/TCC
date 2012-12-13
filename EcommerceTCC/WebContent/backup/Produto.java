package ecommerce.model.backup;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 * The persistent class for the produto database table.
 * 
 */
@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idproduto;

	private String categoria;

	private int cod;

	private String nome;

	private BigDecimal preco;

	private String sabor;

	private String tamanho;

	//bi-directional many-to-one association to Foto
	@OneToMany(mappedBy="produto")
	private List<Foto> fotos;

	//bi-directional many-to-one association to Iten
	@OneToMany(mappedBy="produto")
	private Set<Iten> itens;

	//bi-directional many-to-one association to Categoria
    @ManyToOne
	@JoinColumn(name="categoria_idcategoria")
	private Categoria categoriaBean;

    public Produto() {
    }

	public int getIdproduto() {
		return this.idproduto;
	}

	public void setIdproduto(int idproduto) {
		this.idproduto = idproduto;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getCod() {
		return this.cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return this.preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getSabor() {
		return this.sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public String getTamanho() {
		return this.tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public List<Foto> getFotos() {
		return this.fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}
	
	public Set<Iten> getItens() {
		return this.itens;
	}

	public void setItens(Set<Iten> itens) {
		this.itens = itens;
	}
	
	public Categoria getCategoriaBean() {
		return this.categoriaBean;
	}

	public void setCategoriaBean(Categoria categoriaBean) {
		this.categoriaBean = categoriaBean;
	}
	
}