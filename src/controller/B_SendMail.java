package controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class B_SendMail {
	public String generateCertPassword() {
		char[] certChar = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
				'n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G',
				'H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','!',
				'@','#','$','%','&','*','1','2','3','4','5','6','7','8','9','0'};
		StringBuffer certpassword = new StringBuffer();
		
		for(int i = 0; i < 8; i++) {			
			int random = (int)(Math.random()*70);
			certpassword.append(certChar[random]);
		}
//		System.out.println(certpassword);
		return certpassword.toString();
	}

	public void sendMail(String certpassword, String email) throws MessagingException{
		
		//보내시는분
		String smtpServer = "smtp.naver.com";
		final String sendId = "l_jiho1007";
		final String sendPass = "dl191117!";
		String sendEmailAddress = "l_jiho1007@naver.com";
		int smtpPort = 465;
		
		//받는분
		String recieveEmailAddress = email;
		String subject = "[Dobbys] 이메일 인증을 위한 인증번호가 발급되었습니다. ";
		String content = "이메일 인증 번호는 " + certpassword + "입니다.";
		
		Properties props = System.getProperties(); // 정보를 담기 위한 객체 생성
		
		//SMTP 서버 정보 설정
		props.put("mail.smtp.host", smtpServer);
		props.put("mail.smtp.port", smtpPort);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", smtpServer);
		
		//Session 생성
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sendId, sendPass);
			}
		});
		
		session.setDebug(true); // for debug
		
		Message mimeMessage = new MimeMessage(session);
		mimeMessage.setFrom(new InternetAddress(sendEmailAddress));
		mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recieveEmailAddress));
		mimeMessage.setSubject(subject);
		mimeMessage.setText(content);
		Transport.send(mimeMessage);
	}
}
