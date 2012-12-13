package ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the enderecocomplemento database table.
 * 
 */
@Entity
@Table(name="enderecocomplemento")
public class Enderecocomplemento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idEnderecoComplemento;

	@Column(length=255)
	private String complemento;

	@Column(name="endereco_id")
	private int enderecoId;

	@Column(length=255)
	private String numero;

	private int usuario_idUsuario;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="enderecocomplemento")
	private List<Pedido> pedidos;

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

	public int getEnderecoId() {
		return this.enderecoId;
	}

	public void setEnderecoId(int enderecoId) {
		this.enderecoId = enderecoId;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getUsuario_idUsuario() {
		return this.usuario_idUsuario;
	}

	public void setUsuario_idUsuario(int usuario_idUsuario) {
		this.usuario_idUsuario = usuario_idUsuario;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
}