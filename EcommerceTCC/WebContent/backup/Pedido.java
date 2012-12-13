package ecommerce.model.backup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPedido;


	private String sabor;

	private String tamanho;

	//bi-directional many-to-one association to Iten
	@OneToMany(mappedBy="pedido")
	private List<Iten> itens;

	//bi-directional many-to-one association to Cliente
    @ManyToOne
	@JoinColumn(name="Usuario_idUsuario")
	private Cliente cliente;

	//bi-directional many-to-one association to Enderecocomplemento
    @ManyToOne
	private Enderecocomplemento enderecocomplemento;

    public Pedido() {
    	this.itens = new ArrayList<Iten>();
    }
    
    public void adicionarproduto(Produto p){
    	Iten i = new Iten();
    	i.setProduto(p);
    	i.setQuantidade(1);
    	this.itens.add(i);
    }

	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
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

	public List<Iten> getItens() {
		return this.itens;
	}

	public void setItens(List<Iten> itens) {
		this.itens = itens;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Enderecocomplemento getEnderecocomplemento() {
		return this.enderecocomplemento;
	}

	public void setEnderecocomplemento(Enderecocomplemento enderecocomplemento) {
		this.enderecocomplemento = enderecocomplemento;
	}
	
}