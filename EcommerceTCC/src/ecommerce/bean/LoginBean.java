 package ecommerce.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import ecommerce.dao.ClienteDao;
import ecommerce.model.Cliente;
import ecommerce.model.Pedido;
import ecommerce.util.JPAUtil;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String usuario;
	private String senha;
	private Cliente cliente;
	private EntityManager entityManager;
	private ClienteDao clienteDao;
	private Pedido carrinho;
	private HtmlDataTable datatableCarrinho;
	
	public LoginBean() {
		this.entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		this.clienteDao = new ClienteDao(entityManager);
		this.carrinho = new Pedido();
		this.usuario = "";
		this.senha = "";
	}
	
	
	public void login(ActionEvent actionEvent){
		if (this.cliente!=null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro: Cliente ja esta logado", "Cliente ja esta logado " + this.cliente.getLogin()));
		}
		this.cliente = clienteDao.getCliente(usuario, senha);
		
		if (this.cliente==null) {
			this.usuario = "";
			this.senha = "";
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro: Usuario e/ou senha invalido(s)", "Usuario ou senha invalido"));
		}
		
	}
	
	public String logout(){
		this.cliente = null;
		return null;
	}
	
	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pedido getCarrinho() {
	return carrinho;
	}
	
	public String finalizarCompra() {
		return "finalizar";
	}

	public String removerItem() {
		//System.out.println(this.carrinho.getQtdItens());
		//Produto p = ((CompraItem) this.datatableCarrinho.getRowData()).getProduto();
		//this.carrinho.removerProduto(p);
		//System.out.println(this.carrinho.getQtdItens());
		//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item ' "  + p.getNome() + " ' Removido com sucesso", "Removido"));
		
		return null;
	}
	public HtmlDataTable getDatatableCarrinho() {
		return datatableCarrinho;
	}


	public void setDatatableCarrinho(HtmlDataTable datatableCarrinho) {
		this.datatableCarrinho = datatableCarrinho;
	}




	public void setCarrinho(Pedido carrinho) {
		this.carrinho = carrinho;
	}
	
	
}
