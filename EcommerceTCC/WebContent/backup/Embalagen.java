package ecommerce.model.backup;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the embalagens database table.
 * 
 */
@Entity
@Table(name="embalagens")
public class Embalagen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idembalagens;

	private String cod;

	private String cor;

	private String tamanho;

	private String tipo;

	//bi-directional many-to-one association to Foto
    @ManyToOne
	@JoinColumn(name="fotos_idtable1")
	private Foto foto;

	//bi-directional many-to-one association to Iten
	@OneToMany(mappedBy="embalagen")
	private Set<Iten> itens;

    public Embalagen() {
    }

	public int getIdembalagens() {
		return this.idembalagens;
	}

	public void setIdembalagens(int idembalagens) {
		this.idembalagens = idembalagens;
	}

	public String getCod() {
		return this.cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getCor() {
		return this.cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTamanho() {
		return this.tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Foto getFoto() {
		return this.foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}
	
	public Set<Iten> getItens() {
		return this.itens;
	}

	public void setItens(Set<Iten> itens) {
		this.itens = itens;
	}
	
}