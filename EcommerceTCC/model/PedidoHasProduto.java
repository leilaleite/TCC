package ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pedido_has_produto database table.
 * 
 */
@Entity
@Table(name="pedido_has_produto")
public class PedidoHasProduto implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PedidoHasProdutoPK id;

    public PedidoHasProduto() {
    }

	public PedidoHasProdutoPK getId() {
		return this.id;
	}

	public void setId(PedidoHasProdutoPK id) {
		this.id = id;
	}
	
}