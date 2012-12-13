package ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the foto database table.
 * 
 */
@Entity
@Table(name="foto")
public class Foto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idfoto;

	@Column(length=45)
	private String imag;

    public Foto() {
    }

	public int getIdfoto() {
		return this.idfoto;
	}

	public void setIdfoto(int idfoto) {
		this.idfoto = idfoto;
	}

	public String getImag() {
		return this.imag;
	}

	public void setImag(String imag) {
		this.imag = imag;
	}

}