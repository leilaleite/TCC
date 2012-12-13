package ecommerce.util;


public class CriptografiaUtil {
	private String algoritmo;
	
	public CriptografiaUtil() {
		//MD2, SHA, SHA-1, SHA-256, SHA-384 e SHA-512
		this.setAlgoritmo("MD5");
	}

	public String criptografar(String senha){
//	       try {     
//	            MessageDigest digest = MessageDigest.getInstance(this.algoritmo);      
//	            digest.update(senha.getBytes());      
//	            BASE64Encoder encoder = new BASE64Encoder();      
//	            return encoder.encode(digest.digest());      
	    	   return senha;
//	       } catch (NoSuchAlgorithmException ns) {     
//	            ns.printStackTrace ();
//	            return null;
//	       }    

	}

	public String getAlgoritmo() {
		return algoritmo;
	}

	public void setAlgoritmo(String algoritmo) {
		this.algoritmo = algoritmo;
	}
}
