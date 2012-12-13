package ecommerce.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ecommerce.util.JPAUtil;




public class GenericDAO<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected EntityManager manager;
	protected Class<?> tipo;
	protected String nomeTabela;
	

	public GenericDAO(EntityManager manager, Class<?> tipo) {
		this.manager = manager;
		this.tipo = tipo;
		this.nomeTabela = JPAUtil.getTableName(tipo);
	}
	
	public void criar(T t) {
		manager.persist(t);
		manager.flush();
	}
	
	@SuppressWarnings("unchecked")
	public T ler(int codigo){
		return (T) manager.getReference(tipo, codigo);
	}
	
	public void remover(T t){
		manager.remove(t);
		manager.flush();
	}
	
	public void atualizar(T t){
		manager.merge(t);
		manager.flush();
	}

	@SuppressWarnings("unchecked")
	public List<T> listarTodos(int pagina, int quantidadePorPagina){
		Query query = manager.createQuery("SELECT x FROM " + nomeTabela + " x");
		query.setFirstResult(pagina);
		query.setMaxResults(quantidadePorPagina);
		return query.getResultList();
	}
	
	public long getTotal() {
		Query query = manager.createQuery("SELECT COUNT(p) FROM " + nomeTabela + " p");
		Number result = (Number) query.getSingleResult();
		return result.longValue();
	}

	
	
}
