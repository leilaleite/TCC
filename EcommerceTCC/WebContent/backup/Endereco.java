package ecommerce.model.backup;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the endereco database table.
 * 
 */
@Entity
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String bairro;

	private String cep;

	private String rua;

	//bi-directional many-to-one association to Cidade
    @ManyToOne
	private Cidade cidade;

	//bi-directional many-to-one association to Enderecocomplemento
	@OneToMany(mappedBy="endereco")
	private Set<Enderecocomplemento> enderecocomplementos;

    public Endereco() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public Set<Enderecocomplemento> getEnderecocomplementos() {
		return this.enderecocomplementos;
	}

	public void setEnderecocomplementos(Set<Enderecocomplemento> enderecocomplementos) {
		this.enderecocomplementos = enderecocomplementos;
	}
	
}