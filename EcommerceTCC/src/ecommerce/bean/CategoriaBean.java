package ecommerce.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import ecommerce.dao.GenericDAO;
import ecommerce.model.Categoria;
import ecommerce.util.JPAUtil;

@ManagedBean
public class CategoriaBean {
	
	private Categoria categoria;
	private GenericDAO<Categoria> categoriaDao;
	private EntityManager entityManager;
	
	public CategoriaBean() {
		this.categoria = new Categoria();
		this.entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		this.categoriaDao = new GenericDAO<Categoria>(entityManager, Categoria.class);
	}
	
	public String criar() {
		this.entityManager.getTransaction().begin();
		try {
			this.categoriaDao.criar(categoria);
			this.entityManager.getTransaction().commit();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Categoria criada com sucesso", ""));
			return "index";
		
		} catch (PersistenceException e) {
			this.entityManager.getTransaction().rollback();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Categoria nao criada", ""));
			return null;
		}
			
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
