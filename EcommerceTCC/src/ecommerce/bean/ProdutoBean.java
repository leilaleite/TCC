package ecommerce.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import ecommerce.dao.ProdutoDao;
import ecommerce.model.Pedido;
import ecommerce.model.Produto;
import ecommerce.util.JPAUtil;

@ManagedBean
@SessionScoped
public class ProdutoBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProdutoDao produtoDao;
	private EntityManager entityManager;
	private List<Produto> produtos;
	private LazyProdutoDataModel lazyProdutoDataModel;
	private Produto produtoSelecionado;
	private HtmlDataTable datatableProdutos;
	private Produto produto;
	private Pedido pedido;
	
	
	@ManagedProperty(value="#{carrinhoDeCompraBean}")
	private CarrinhoDeCompraBean carrinhoBean;
	
	
	
	
	
	
	public ProdutoBean() {
		this.entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		this.produtoDao = new ProdutoDao(entityManager);
		this.setLazyProdutoDataModel(new LazyProdutoDataModel(produtoDao));
		this.produtoSelecionado = null;
		this.produtos = null;
		
		
	
	}
	
	public List<Produto> getProdutos(){
		if (this.produtos==null) {
			this.produtos = produtoDao.listarTodos(0, 100);
		}
		return this.produtos;
	}

	public String comprar() {
		Produto p = (Produto) getLazyProdutoDataModel().getRowData();
		getCarrinhoBean().adicionarProduto(p);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto '" + p.getNome() + "' adicionado ao carrinho de compra  " + p.getPreco(), "Ok"));
		return "produtocompra";
		
	}
	
	public String comprarTabela() {
		/*
		Produto p = (Produto) datatableProdutos.getRowData();
		loginBean.getCarrinho().adicionarproduto(p);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto '" + p.getNome() + "' adicionado ao carrinho de compra", "Ok"));
		*/
		return null;
		
	}
	
	public LazyProdutoDataModel getLazyProdutoDataModel() {
		return lazyProdutoDataModel;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public HtmlDataTable getDatatableProdutos() {
		return datatableProdutos;
	}

	public void setDatatableProdutos(HtmlDataTable datatableProdutos) {
		this.datatableProdutos = datatableProdutos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setLazyProdutoDataModel(LazyProdutoDataModel lazyProdutoDataModel) {
		this.lazyProdutoDataModel = lazyProdutoDataModel;
	}

	public CarrinhoDeCompraBean getCarrinhoBean() {
		return carrinhoBean;
	}

	public void setCarrinhoBean(CarrinhoDeCompraBean carrinhoBean) {
		this.carrinhoBean = carrinhoBean;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}




	
}
