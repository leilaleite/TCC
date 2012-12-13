package ecommerce.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import ecommerce.model.Categoria;
import ecommerce.model.Item;
import ecommerce.model.Produto;
import ecommerce.util.JPAUtil;

@ManagedBean
@SessionScoped
public class CarrinhoDeCompraBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EntityManager entityManager;
	
	private String teste;
	private List<Item> itens;
	private HtmlDataTable datatableCarrinho;
	
	public CarrinhoDeCompraBean() {
		this.entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		this.setItens(new ArrayList<Item>());
//		popularProduto();
	}
	
	private void popularProduto() {
		String[] tamanho = new String[]{"Pequeno","Medio","Grande"};
		System.out.println("CarrinhoDeCompraBean.popularProdutos");
		try {
			entityManager.getTransaction().begin();
			for (int i=0;i<10;i++) {
				Categoria c = new Categoria("Categoria " + i);
				entityManager.merge(c);
				entityManager.flush();
				
			}
			entityManager.getTransaction().commit();
		
		
		
			entityManager.getTransaction().begin();
			for (int i=0;i<100;i++) {
				
				Produto p = new Produto("teste " + i, (float) Math.random()*9, "imagens/bemCasado/BemCasado_1.jpg", "Sabor", tamanho[ Math.round((float)Math.random()*2)], entityManager.getReference(Categoria.class, Math.round((float) Math.random()*9)+1 ));
				entityManager.merge(p);
				entityManager.flush();
			
			}
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}
	
	public void adicionarProduto(Produto p) {
		
		for (Item it : itens) {
			System.out.println(it.getProduto().getNome() + " : " + it.getValorTotal());
			if (it.getProduto().getIdproduto() == p.getIdproduto()) {
				it.setQuantidade(it.getQuantidade()+1);
				return;
			}
		}
		
		Item i = new Item();
		i.setProduto(p);
		i.setQuantidade(1);
		i.setTamanhoIdtamanho(1);
		this.itens.add(i);
	}
	
	public int getTamanhoCarrinho() {
		return this.itens.size();
	}
	
	public String finalizar() {
		
		return "produtoFinalizar";
	}

	public HtmlDataTable getDatatableCarrinho() {
		return datatableCarrinho;
	}

	public void setDatatableCarrinho(HtmlDataTable datatableCarrinho) {
		this.datatableCarrinho = datatableCarrinho;
	}
	
	public String removerItem() {
		Produto p = ((Item) this.datatableCarrinho.getRowData()).getProduto();
		for (int i=0;i<itens.size();i++) {
			Item it = itens.get(i);
			if (p.getIdproduto()==it.getProduto().getIdproduto()) {
				itens.remove(it);
			}
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item ' "  + p.getNome() + " ' Removido com sucesso", "Removido"));
		
		return null;

	}
	
	public float getValorTotalCompra() {
		float valor = 0;
		for (Item it : itens) {
			System.out.println(it.getProduto().getNome() + " : " + it.getValorTotal());
			valor += it.getValorTotal();
		}
		
		return valor;
	}
}
