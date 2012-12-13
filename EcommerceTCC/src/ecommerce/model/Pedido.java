package ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@Table(name="pedido")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idpedido;

    @Temporal( TemporalType.DATE)
	@Column(name="data_compra")
	private Date dataCompra;

    @Temporal( TemporalType.DATE)
	@Column(name="data_entrega")
	private Date dataEntrega;

    @Temporal( TemporalType.DATE)
	@Column(name="data_prevista_entrega")
	private Date dataPrevistaEntrega;

	//bi-directional many-to-many association to Cliente
    @ManyToMany
	@JoinTable(
		name="cliente_has_pedido"
		, joinColumns={
			@JoinColumn(name="pedido_idpedido", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="cliente_idcliente", nullable=false)
			}
		)
	private List<Cliente> clientes;

    public Pedido() {
    }

	public int getIdpedido() {
		return this.idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public Date getDataCompra() {
		return this.dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Date getDataEntrega() {
		return this.dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Date getDataPrevistaEntrega() {
		return this.dataPrevistaEntrega;
	}

	public void setDataPrevistaEntrega(Date dataPrevistaEntrega) {
		this.dataPrevistaEntrega = dataPrevistaEntrega;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
}