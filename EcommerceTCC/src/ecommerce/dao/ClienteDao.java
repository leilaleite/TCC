package ecommerce.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import ecommerce.model.Cliente;
import ecommerce.util.CriptografiaUtil;

public class ClienteDao extends GenericDAO<Cliente> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteDao(EntityManager manager) {
		super(manager, Cliente.class);
	}

	public Cliente getCliente(String usuario, String senha) {
		Query query = manager.createNamedQuery("Cliente.validarLogin", this.tipo);
		query.setParameter("login", usuario);
		query.setParameter("senha", new CriptografiaUtil().criptografar(senha));

		try {
			return (Cliente) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

	public boolean isCadastrado(String usuario) {
		Query query = manager.createNamedQuery("Cliente.loginExiste", this.tipo);
		query.setParameter("login", usuario);
		
		try {
			return (query.getSingleResult()!=null);
		} catch (NoResultException e) {
			return false;
		}
	}
}
