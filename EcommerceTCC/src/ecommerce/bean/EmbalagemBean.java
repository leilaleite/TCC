package ecommerce.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

@ManagedBean
public class EmbalagemBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	private EntityManager entityManager;
	
	private String lacoCor;
	private String papelCor;
	
	public EmbalagemBean() {
		this.lacoCor = "imagens/simImag/LACO/fita_bege.png";
		this.papelCor = "imagens/simImag/PAPEL/papel_bege.png";
//		this.entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
	}

	public String getLacoCor() {
		return lacoCor;
	}

	public void setLacoCor(String lacoCor) {
		this.lacoCor = lacoCor;
	}

	public String getPapelCor() {
		return papelCor;
	}

	public void setPapelCor(String papelCor) {
		this.papelCor = papelCor;
	}
	
	public List<SelectItem> getLacos(){
		List<SelectItem>  itens = new ArrayList<SelectItem>();
		for (String cor : getLacoCores()) {
			itens.add(new SelectItem("imagens/simImag/LACO/fita_" + cor + ".png", cor));
		}
		return itens;
	}
	
	public List<SelectItem> getPapeis(){
		List<SelectItem>  itens = new ArrayList<SelectItem>();
		for (String cor : getPapelCores()) {
			itens.add(new SelectItem("imagens/simImag/PAPEL/papel_" + cor + ".png", cor));
		}
		return itens;
	}
	
	
	public List<String> getPapelCores(){
		List<String> itens = new ArrayList<String>();
		itens.add("bege");
		itens.add("branco");
		itens.add("laranja");
		itens.add("lilas");
		itens.add("ouro");
		itens.add("prata");
		itens.add("rosa");
		itens.add("verde");
		itens.add("vermelho");
		return itens;
	}
	public List<String> getLacoCores(){
		List<String> itens = new ArrayList<String>();
		itens.add("bege");
		itens.add("branca");
		itens.add("laranja");
		itens.add("lilas");
		itens.add("ouro");
		itens.add("preta");
		itens.add("rosa");
		itens.add("verde");
		itens.add("verdeclaro");
		itens.add("vermelha");
		return itens;
	}
}
