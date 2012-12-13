package ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pedido_has_produto database table.
 * 
 */
@Embeddable
public class PedidoHasProdutoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="pedido_idpedido", unique=true, nullable=false)
	private int pedidoIdpedido;

	@Column(name="produto_idproduto", unique=true, nullable=false)
	private int produtoIdproduto;

	@Column(name="produto_embalagem_idembalagem", unique=true, nullable=false)
	private int produtoEmbalagemIdembalagem;

    public PedidoHasProdutoPK() {
    }
	public int getPedidoIdpedido() {
		return this.pedidoIdpedido;
	}
	public void setPedidoIdpedido(int pedidoIdpedido) {
		this.pedidoIdpedido = pedidoIdpedido;
	}
	public int getProdutoIdproduto() {
		return this.produtoIdproduto;
	}
	public void setProdutoIdproduto(int produtoIdproduto) {
		this.produtoIdproduto = produtoIdproduto;
	}
	public int getProdutoEmbalagemIdembalagem() {
		return this.produtoEmbalagemIdembalagem;
	}
	public void setProdutoEmbalagemIdembalagem(int produtoEmbalagemIdembalagem) {
		this.produtoEmbalagemIdembalagem = produtoEmbalagemIdembalagem;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PedidoHasProdutoPK)) {
			return false;
		}
		PedidoHasProdutoPK castOther = (PedidoHasProdutoPK)other;
		return 
			(this.pedidoIdpedido == castOther.pedidoIdpedido)
			&& (this.produtoIdproduto == castOther.produtoIdproduto)
			&& (this.produtoEmbalagemIdembalagem == castOther.produtoEmbalagemIdembalagem);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.pedidoIdpedido;
		hash = hash * prime + this.produtoIdproduto;
		hash = hash * prime + this.produtoEmbalagemIdembalagem;
		
		return hash;
    }
}