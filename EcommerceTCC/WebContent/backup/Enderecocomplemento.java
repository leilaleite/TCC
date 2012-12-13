package ecommerce.model.backup;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the enderecocomplemento database table.
 * 
 */
@Entity
public class Enderecocomplemento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idEnderecoComplemento;

	private String complemento;

	private String numero;

	//bi-directional many-to-one association to Cliente
    @ManyToOne
	@JoinColumn(name="Usuario_idUsuario")
	private Cliente cliente;

	//bi-directional many-to-one association to Endereco
    @ManyToOne
	private Endereco endereco;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="enderecocomplemento")
	private Set<Pedido> pedidos;

    public Enderecocomplemento() {
    }

	public int getIdEnderecoComplemento() {
		return this.idEnderecoComplemento;
	}

	public void setIdEnderecoComplemento(int idEnderecoComplemento) {
		this.idEnderecoComplemento = idEnderecoComplemento;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Set<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
}