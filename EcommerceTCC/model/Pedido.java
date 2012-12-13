package ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@Table(name="pedido")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idpedido;

    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	private Date dataCompra;

	@Column(nullable=false, length=45)
	private String sabor;

	@Column(nullable=false, length=45)
	private String tamanho;

	private int usuario_idUsuario;

	//bi-directional many-to-one association to Enderecocomplemento
    @ManyToOne
	@JoinColumn(name="enderecocomplemento_idEnderecoComplemento")
	private Enderecocomplemento enderecocomplemento;

    public Pedido() {
    }

	public int getIdpedido() {
		return this.idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public Date getDataCompra() {
		return this.dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public String getSabor() {
		return this.sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public String getTamanho() {
		return this.tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public int getUsuario_idUsuario() {
		return this.usuario_idUsuario;
	}

	public void setUsuario_idUsuario(int usuario_idUsuario) {
		this.usuario_idUsuario = usuario_idUsuario;
	}

	public Enderecocomplemento getEnderecocomplemento() {
		return this.enderecocomplemento;
	}

	public void setEnderecocomplemento(Enderecocomplemento enderecocomplemento) {
		this.enderecocomplemento = enderecocomplemento;
	}
	
}