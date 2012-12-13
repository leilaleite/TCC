package ecommerce.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import ecommerce.dao.ClienteDao;

@FacesValidator("ecommerce.validator.LoginValidator")
public class LoginValidator implements Validator {

	private ClienteDao clienteDao;
	private EntityManager entityManager;

	
	public LoginValidator() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		this.entityManager = (EntityManager) req.getAttribute("entityManager");
		this.clienteDao = new ClienteDao(entityManager);
	}
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		boolean existe = clienteDao.isCadastrado(value.toString());
		if (existe) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login ja existe", "Login ja existe");
			throw new ValidatorException(msg);
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Login ainda nao cadastrado", "Login ainda nao cadastrado");
			throw new ValidatorException(msg);
		}
		
	}

}
