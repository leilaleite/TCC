package ecommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ecommerce.model.Produto;

public class ProdutoDao extends GenericDAO<Produto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProdutoDao(EntityManager manager) {
		super(manager, Produto.class);
	}

	public List<Produto> listar(int pagina, int quantidadePorPagina){
		return listar(pagina, quantidadePorPagina, "");
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listar(int pagina, int quantidadePorPagina, String filtro){
		Query query = manager.createQuery("SELECT p FROM Produto p WHERE UPPER(p.nome) like :nome");
		query.setFirstResult(pagina);
		query.setMaxResults(quantidadePorPagina);
		query.setParameter("nome", "%" + filtro.toUpperCase() + "%");
		
		return query.getResultList();
	}

	
	public long getTotal() {
		return getTotal("");
	}	
	public long getTotal(String filtro) {
		Query query = manager.createQuery("SELECT COUNT(p) FROM Produto p WHERE UPPER(p.nome) like :nome");
		query.setParameter("nome", "%" + filtro.toUpperCase() + "%");
		Number result = (Number) query.getSingleResult();
		return result.longValue();
	}

}
