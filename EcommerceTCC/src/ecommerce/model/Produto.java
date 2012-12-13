package ecommerce.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the produto database table.
 * 
 */
@Entity
@Table(name="produto")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idproduto;

	@Column(length=255)
	private String foto;

	@Column(nullable=false, length=45)
	private String nome;

	@Column(nullable=false, precision=10)
	private float preco;

	@Column(nullable=false, length=45)
	private String quantidade;

	@Column(nullable=false, length=45)
	private String sabor;

	@Column(nullable=false, length=45)
	private String tamanho;

	//bi-directional many-to-one association to Categoria
    @ManyToOne
	@JoinColumn(name="categoria_idcategoria", nullable=false)
	private Categoria categoria;

    public Produto() {
    }
    
    

	public Produto(String nome, float preco, String foto, String sabor, String tamanho, Categoria categoria) {
		this.nome = nome;
		this.preco = preco;
		this.foto = foto;
		this.sabor = sabor;
		this.tamanho = tamanho;
		this.categoria = categoria;
		this.quantidade = "1";
	}



	public int getIdproduto() {
		return this.idproduto;
	}

	public void setIdproduto(int idproduto) {
		this.idproduto = idproduto;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return this.preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
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

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}