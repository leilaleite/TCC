package ecommerce.model.backup;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the telefone database table.
 * 
 */
@Entity
public class Telefone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTelefone;

	private String ddd;

	private String numero;

	private String operadora;

	private String tipo;

	//bi-directional many-to-one association to Cliente
    @ManyToOne
	@JoinColumn(name="Usuario_idUsuario")
	private Cliente cliente;

    public Telefone() {
    }

	public int getIdTelefone() {
		return this.idTelefone;
	}

	public void setIdTelefone(int idTelefone) {
		this.idTelefone = idTelefone;
	}

	public String getDdd() {
		return this.ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getOperadora() {
		return this.operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}