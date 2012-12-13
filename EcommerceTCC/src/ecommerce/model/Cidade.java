package ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cidade database table.
 * 
 */
@Entity
@Table(name="cidade")
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idcidade;

	@Column(nullable=false, length=255)
	private String cidade;

	//bi-directional many-to-one association to Estado
    @ManyToOne
	@JoinColumn(name="estado_idestado", nullable=false)
	private Estado estado;

	//bi-directional many-to-one association to Endereco
	@OneToMany(mappedBy="cidade")
	private List<Endereco> enderecos;

    public Cidade() {
    }

	public int getIdcidade() {
		return this.idcidade;
	}

	public void setIdcidade(int idcidade) {
		this.idcidade = idcidade;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public List<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
}