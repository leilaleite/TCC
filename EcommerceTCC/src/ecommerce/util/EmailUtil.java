package ecommerce.util;


	import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

	public class EmailUtil {
		public static boolean DEBUG=false;
		
		private static final String USUARIO_SMTP = "juntosebemcasado@gmail.com";
		private static final String SENHA_SMTP = "juntosebemcasados";

		public static String DE_EMAIL = "juntosebemcasado@gmail.com";
		public static String DE_NOME = "Site Juntos e Bem Casado";
		
		public static String SERVIDOR_SMTP = "smtp.gmail.com";
		
		
		public static void enviar(String[] para, String assunto, String conteudo) throws Exception {
//			Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
			Properties props = new Properties();
			props.setProperty("mail.transport.protocol", "smtp");
			props.setProperty("mail.host", SERVIDOR_SMTP);

			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");

			props.put("mail.debug", DEBUG);
			props.put("mail.smtp.socketFactory.port", "465");

			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.fallback", "false");

			Session session = Session.getDefaultInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(USUARIO_SMTP,	SENHA_SMTP);
						}
					});
			session.setDebug(DEBUG);
			Transport transport = session.getTransport();
			InternetAddress addressFrom = new InternetAddress(DE_EMAIL, DE_NOME);
			MimeMessage message = new MimeMessage(session);
			message.setSender(addressFrom);

			message.setSubject(assunto);
//			message.setContent(conteudo, "text/plain");
			message.setContent(conteudo, "text/html");
			if (para != null) {
				InternetAddress[] addressTo = new InternetAddress[para.length];
				for (int i = 0; i < para.length; i++) {
					addressTo[i] = new InternetAddress(para[i]);
				}
				message.setRecipients(Message.RecipientType.TO, addressTo);
			}
			transport.connect();
			Transport.send(message);
			transport.close();
		}
	}


