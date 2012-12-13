package ecommerce.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ecommerce.model.Endereco;

public class EnderecoDao extends GenericDAO<Endereco> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EnderecoDao(EntityManager manager) {
		super(manager, Endereco.class);
	}

	
	public Endereco getEndereco(String cep) {
		Query query = manager.createQuery("SELECT e FROM Endereco e WHERE e.cep = :cep");
		query.setParameter("cep", cep);
		return (Endereco) query.getSingleResult();
	}

}
