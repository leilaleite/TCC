package ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tamanho database table.
 * 
 */
@Entity
@Table(name="tamanho")
public class Tamanho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idtamanho;

	@Column(nullable=false, length=45)
	private String tamanho;

    public Tamanho() {
    }

	public int getIdtamanho() {
		return this.idtamanho;
	}

	public void setIdtamanho(int idtamanho) {
		this.idtamanho = idtamanho;
	}

	public String getTamanho() {
		return this.tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

}