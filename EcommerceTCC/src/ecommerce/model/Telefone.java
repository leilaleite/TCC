package ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the telefone database table.
 * 
 */
@Entity
@Table(name="telefone")
public class Telefone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idtelefone;

	@Column(length=45)
	private String cliente;

	@Column(nullable=false, length=9)
	private String ddd;

	@Column(nullable=false, length=45)
	private String numero;

	@Column(length=45)
	private String operadora;

	//bi-directional many-to-one association to Cliente
    @ManyToOne
	@JoinColumn(name="cliente_idcliente", nullable=false)
	private Cliente clienteBean;

    public Telefone() {
    }

	public int getIdtelefone() {
		return this.idtelefone;
	}

	public void setIdtelefone(int idtelefone) {
		this.idtelefone = idtelefone;
	}

	public String getCliente() {
		return this.cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getDdd() {
		return this.ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getOperadora() {
		return this.operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public Cliente getClienteBean() {
		return this.clienteBean;
	}

	public void setClienteBean(Cliente clienteBean) {
		this.clienteBean = clienteBean;
	}
	
}