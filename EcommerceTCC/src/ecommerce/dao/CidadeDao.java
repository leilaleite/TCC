package ecommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ecommerce.model.Cidade;

public class CidadeDao extends GenericDAO<Cidade> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CidadeDao(EntityManager manager) {
		super(manager, Cidade.class);
	}

	
	@SuppressWarnings("unchecked")
	public List<Cidade> listar(int estadoId){
		Query query = manager.createQuery("SELECT c FROM Cidade c WHERE estado_idestado = :estadoId");
		query.setParameter("estadoId", estadoId);
		
		return query.getResultList();
	}

	

}
