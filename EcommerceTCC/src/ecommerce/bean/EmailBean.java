package ecommerce.bean;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import ecommerce.util.EmailUtil;

@ManagedBean
public class EmailBean {


	private String para = "leilamilk18@hotmail.com";
	
	private String assunto = "Email enviado do site";

	
	private String nome;
	private String email;
	private String telefone;
	private String comentario;

	public String enviarEmail() {

		String conteudo = "Quem: " + nome + " <br />";
		conteudo += "Telefone: " + telefone + " <br />";
		conteudo += "Email: " + email + " <br />";
		conteudo += "Comentario: " + comentario + " <br />";
		
		try {
			EmailUtil.enviar(new String[] {para}, assunto, conteudo);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, 
							"Email enviado com sucesso", 
							"")
					);

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							"Erro ao enviar o email " + e.getLocalizedMessage(), 
							"")
					);

			e.printStackTrace();
		}

		return null;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getComentario() {
		return comentario;
	}


	public void setComentario(String comentario) {
		this.comentario = comentario;
	}



}


