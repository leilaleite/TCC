package ecommerce.model.backup;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the itens database table.
 * 
 */
@Entity
@Table(name="itens")
public class Iten implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idItens;

	private int quantidade;

	private BigDecimal valor;

	//bi-directional many-to-one association to Embalagen
    @ManyToOne
	@JoinColumn(name="embalagens_idembalagens")
	private Embalagen embalagen;

	//bi-directional many-to-one association to Pedido
    @ManyToOne
	private Pedido pedido;

	//bi-directional many-to-one association to Produto
    @ManyToOne
	private Produto produto;

    public Iten() {
    }

	public int getIdItens() {
		return this.idItens;
	}

	public void setIdItens(int idItens) {
		this.idItens = idItens;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Embalagen getEmbalagen() {
		return this.embalagen;
	}

	public void setEmbalagen(Embalagen embalagen) {
		this.embalagen = embalagen;
	}
	
	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}