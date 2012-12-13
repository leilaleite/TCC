package ecommerce.model.backup;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idUsuario;

	private String apelido;

	private String cpf;

    @Temporal( TemporalType.DATE)
	@Column(name="data_de_nascimento")
	private Date dataDeNascimento;

	private String email;

	private String login;

	private String nome;

	private String rg;

	private String senha;

	private String sexo;

	private int telefone;

    private boolean administrador;
    
	//bi-directional many-to-one association to Enderecocomplemento
	@OneToMany(mappedBy="cliente")
	private Set<Enderecocomplemento> enderecocomplementos;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="cliente")
	private Set<Pedido> pedidos;

	//bi-directional many-to-one association to Telefone
	@OneToMany(mappedBy="cliente")
	private Set<Telefone> telefones;
	
    public Cliente() {
    	this.setAdministrador(false);
    }

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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

	public Date getDataDeNascimento() {
		return this.dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getTelefone() {
		return this.telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	public Set<Enderecocomplemento> getEnderecocomplementos() {
		return this.enderecocomplementos;
	}

	public void setEnderecocomplementos(Set<Enderecocomplemento> enderecocomplementos) {
		this.enderecocomplementos = enderecocomplementos;
	}
	
	public Set<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public Set<Telefone> getTelefones() {
		return this.telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	
}