package ecommerce.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * The persistent class for the item database table.
 * 
 */
@Entity
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int iditem;

	@Column(name="pedido_idpedido")
	private int pedidoIdpedido;

	private String produto;

	@Column(name="produto_idproduto")
	private int produtoIdproduto;

	private String quantidade;

	@Column(name="tamanho_idtamanho")
	private int tamanhoIdtamanho;

	private float valor;

    public Item() {
    }

	public int getIditem() {
		return this.iditem;
	}

	public void setIditem(int iditem) {
		this.iditem = iditem;
	}

	public int getPedidoIdpedido() {
		return this.pedidoIdpedido;
	}

	public void setPedidoIdpedido(int pedidoIdpedido) {
		this.pedidoIdpedido = pedidoIdpedido;
	}

	public String getProduto() {
		return this.produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public int getProdutoIdproduto() {
		return this.produtoIdproduto;
	}

	public void setProdutoIdproduto(int produtoIdproduto) {
		this.produtoIdproduto = produtoIdproduto;
	}

	public String getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public int getTamanhoIdtamanho() {
		return this.tamanhoIdtamanho;
	}

	public void setTamanhoIdtamanho(int tamanhoIdtamanho) {
		this.tamanhoIdtamanho = tamanhoIdtamanho;
	}

	public float getValor() {
		return this.valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

}