package ecommerce.model.backup;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the fotos database table.
 * 
 */
@Entity
@Table(name="fotos")
public class Foto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idtable1;

	private String endereco;

	//bi-directional many-to-one association to Embalagen
	@OneToMany(mappedBy="foto")
	private Set<Embalagen> embalagens;

	//bi-directional many-to-one association to Produto
    @ManyToOne
	private Produto produto;

    public Foto() {
    }

	public int getIdtable1() {
		return this.idtable1;
	}

	public void setIdtable1(int idtable1) {
		this.idtable1 = idtable1;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Set<Embalagen> getEmbalagens() {
		return this.embalagens;
	}

	public void setEmbalagens(Set<Embalagen> embalagens) {
		this.embalagens = embalagens;
	}
	
	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}