package ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the endereco database table.
 * 
 */
@Entity
@Table(name="endereco")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idendereco;

	@Column(nullable=false, length=255)
	private String bairro;

	@Column(nullable=false, length=8, unique=true)
	private String cep;

	@Column(nullable=false, length=255)
	private String rua;

	//bi-directional many-to-one association to Cliente
	@OneToMany(cascade=CascadeType.ALL, mappedBy="endereco")
	private List<Cliente> clientes;

	//bi-directional many-to-one association to Cidade
    @ManyToOne
	@JoinColumn(name="cidade_idcidade", nullable=true)
	private Cidade cidade;

    public Endereco() {
    }

	public int getIdendereco() {
		return this.idendereco;
	}

	public void setIdendereco(int idendereco) {
		this.idendereco = idendereco;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return this.rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
}