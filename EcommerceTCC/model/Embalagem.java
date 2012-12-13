package ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the embalagem database table.
 * 
 */
@Entity
@Table(name="embalagem")
public class Embalagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idembalagem;

	@Column(nullable=false, length=45)
	private String cod;

	@Column(length=45)
	private String cor;

	@Column(length=45)
	private String foto;

	@Column(length=45)
	private String item;

	@Column(name="item_iditem", nullable=false)
	private int itemIditem;

	@Column(nullable=false, length=45)
	private String tamanho;

	@Column(nullable=false, length=45)
	private String tipo;

    public Embalagem() {
    }

	public int getIdembalagem() {
		return this.idembalagem;
	}

	public void setIdembalagem(int idembalagem) {
		this.idembalagem = idembalagem;
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

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getItemIditem() {
		return this.itemIditem;
	}

	public void setItemIditem(int itemIditem) {
		this.itemIditem = itemIditem;
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

}