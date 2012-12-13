package ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;


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
	@Column(unique=true, nullable=false)
	private int idembalagens;

	@Column(length=255)
	private String cod;

	@Column(length=255)
	private String cor;

	@Column(length=255)
	private String tamanho;

	@Column(length=255)
	private String tipo;

	//bi-directional many-to-one association to Foto
    @ManyToOne
	@JoinColumn(name="fotos_idtable1")
	private Foto foto;

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
	
}