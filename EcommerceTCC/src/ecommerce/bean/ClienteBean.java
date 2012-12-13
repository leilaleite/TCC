package ecommerce.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.hibernate.exception.ConstraintViolationException;

import ecommerce.dao.CidadeDao;
import ecommerce.dao.ClienteDao;
import ecommerce.dao.EnderecoDao;
import ecommerce.dao.GenericDAO;
import ecommerce.model.Cidade;
import ecommerce.model.Cliente;
import ecommerce.model.Endereco;
import ecommerce.model.Estado;
import ecommerce.util.JPAUtil;

@ManagedBean
public class ClienteBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	private ClienteDao clienteDao;
	EnderecoDao enderecoDao;
	private EntityManager entityManager;
	private int cidade;
	private int estado;

//	private String cep;
//	private Endereco endereco;
	
	public ClienteBean() {
		this.cliente = new Cliente();
		this.cliente.setEndereco(new Endereco());
		this.estado = 26;
		
		this.entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		this.clienteDao = new ClienteDao(entityManager);
		this.enderecoDao = new EnderecoDao(entityManager);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String gravar() {
		System.out.println("Gravando cliente " + cliente.getNome());
		CidadeDao cidadeDao = new CidadeDao(entityManager);
		cliente.getEndereco().setCidade(cidadeDao.ler(cidade));
		
		entityManager.getTransaction().begin();
		
		
		try {
			
			clienteDao.atualizar(cliente);

			entityManager.getTransaction().commit();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente criado com sucesso", "")
					);
			return "index";
		} catch (ConstraintViolationException e) {
			entityManager.getTransaction().rollback();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login ja existe", "Erro " + e.getLocalizedMessage())
					);
			e.printStackTrace();
			return null;
		} catch (PersistenceException e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro ao criar o cliente", "Erro "	+ e.getLocalizedMessage())
					);
			return null;
		}

	}

	public String remover() {
		entityManager.getTransaction().begin();
		try {
			clienteDao.atualizar(cliente);
			entityManager.getTransaction().commit();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Cliente removido com sucesso", ""));
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Ocorreu um erro ao remover o cliente", "Erro "
									+ e.getLocalizedMessage()));
		}
		return null;
	}

	public List<Estado> getEstados() {
		GenericDAO<Estado> estadoDao = new GenericDAO<Estado>(entityManager,
				Estado.class);
		return estadoDao.listarTodos(0, 50);
	}

	public List<Cidade> getCidades() {
		CidadeDao cidadeDao = new CidadeDao(entityManager);
		return cidadeDao.listar(estado);
	}

	public int getCidade() {
		return cidade;
	}

	public void setCidade(int cidade) {
		this.cidade = cidade;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public void consultaCEP(){
		System.out.println("Consultar cep " + cliente.getEndereco().getCep());
		
		//Endereco end = null;
		Endereco end ;
		try {
			end = enderecoDao.getEndereco(cliente.getEndereco().getCep());
			
			this.cliente.setEndereco(end);
			//this.cidade = end.getCidade().getIdcidade();
			//this.estado = end.getCidade().getEstado().getIdestado();
//			this.endereco = end;
		} catch (NoResultException e) {
			System.out.println("CEP nao encontrado, criando novo");
			//this.cliente.setEndereco(new Endereco());
			//this.cliente.getEndereco().setCep(cep);
			//this.endereco = new Endereco();
			/*
			entityManager.getTransaction().begin();
			try {
				end = new Endereco();
				end.setCep(cep);
				enderecoDao.criar(end);
				entityManager.getTransaction().commit();
				cliente.setEndereco(end);
			} catch (PersistenceException e1) {
			}
			*/
		}
		
		System.out.println("Consultado cep " + cliente.getEndereco().getCep());
	}

	

}
