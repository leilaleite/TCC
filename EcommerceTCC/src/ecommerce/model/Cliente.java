package ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name="cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idcliente;

	@Column(nullable=false)
	private byte administrador;

	@Column(length=255)
	private String apelido;

	@Column(length=11)
	private String cpf;

    @Temporal( TemporalType.DATE)
	@Column(name="data_nascimento")
	private Date dataNascimento;

	@Column(length=255)
	private String email;

	@Column(name="endereco_complemento", length=45)
	private String enderecoComplemento;

	@Column(name="endereco_numero", length=45)
	private String enderecoNumero;

	@Column(length=255)
	private String login;

	@Column(nullable=false, length=255)
	private String nome;

	@Column(length=255)
	private String rg;

	@Column(length=45)
	private String senha;

	@Column(length=45)
	private String sexo;

	//bi-directional many-to-one association to Endereco
    @ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="endereco_idendereco", nullable=true)
	private Endereco endereco;

	//bi-directional many-to-many association to Pedido
	@ManyToMany(mappedBy="clientes")
	private List<Pedido> pedidos;

	//bi-directional many-to-one association to Telefone
	@OneToMany(mappedBy="clienteBean")
	private List<Telefone> telefones;

    public Cliente() {
    }

	public int getIdcliente() {
		return this.idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public byte getAdministrador() {
		return this.administrador;
	}

	public void setAdministrador(byte administrador) {
		this.administrador = administrador;
	}

	public String getApelido() {
		return this.apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEnderecoComplemento() {
		return this.enderecoComplemento;
	}

	public void setEnderecoComplemento(String enderecoComplemento) {
		this.enderecoComplemento = enderecoComplemento;
	}

	public String getEnderecoNumero() {
		return this.enderecoNumero;
	}

	public void setEnderecoNumero(String enderecoNumero) {
		this.enderecoNumero = enderecoNumero;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public List<Telefone> getTelefones() {
		return this.telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
}