package ecommerce.bean;


import java.util.ArrayList;
import java.util.List;

	public class PromocaoBean {

	    private List<String> images;
	    
	    

	    public PromocaoBean() {
	        images = new ArrayList<String>();
	        images.add("pro1.jpg");
	        images.add("pro1.jpg");
	        images.add("pro1.jpg");
	        images.add("pro1.jpg");
	       
	    }

	    public List<String> getImages() {
	        return images;
	    }
	}

