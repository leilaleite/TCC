package ecommerce.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * The persistent class for the item database table.
 * 
 */
@Entity
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int iditem;

	private int quantidade;

	@Column(name="tamanho_idtamanho")
	private int tamanhoIdtamanho;

    @ManyToOne
	@JoinColumn(name="produto_idproduto", nullable=false)
	private Produto produto;
    
    @ManyToOne
	@JoinColumn(name="pedido_idpedido", nullable=false)
    private Pedido pedido;
	
    public Item() {
    	this.quantidade = 1;
    }

	public int getIditem() {
		return this.iditem;
	}

	public void setIditem(int iditem) {
		this.iditem = iditem;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getTamanhoIdtamanho() {
		return this.tamanhoIdtamanho;
	}

	public void setTamanhoIdtamanho(int tamanhoIdtamanho) {
		this.tamanhoIdtamanho = tamanhoIdtamanho;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public float getValorTotal() {
		return this.quantidade * this.produto.getPreco();
	}
}