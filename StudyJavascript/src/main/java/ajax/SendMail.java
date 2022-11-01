package ajax;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class SendMail {
	
	// 메일 발송 작업을 수행하는 sendMail() 메서드 정의
	// => 파라미터 : 수신자 주소, 메일 제목, 메일 본문
	// => 리턴타입 : 메일 발송 성공 여부를 boolean 타입(isSendSuccess)
	public boolean sendMail(String receiver, String title, String content) {
		boolean isSendSuccess = false;
		String sender = "admin@itwillbs.co.kr"; // 상용 메일 사이트에는 변경 불가능

		try {
			// 시스템(서버)의 속성 정보(= 서버 정보)를 관리하는 java.util.Properties 객체 리턴받기
			// => System 클래스의 getProperties() 메서드 사용
			Properties properties = System.getProperties();

			// 메일 발송 프로토콜 정보 설정
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
			// 메일 전송에 사용할 메일 서버 지정 => 각 메일 서비스에 설정 방법 설명되어 있음
			properties.put("mail.smtp.host", "smtp.gmail.com"); // 구글 메일 발송 서버 주소 지정
			properties.put("mail.smtp.auth", "true");			// 인증 여부 설정(로그인 필요 시)
			properties.put("mail.smtp.port", "587");			// 메일 전송에 사용될 서비스 포트 설정(SMTP 포트) 
																// => 기본은 25번이지만 각 서비스별로 달라질 수 있음
																
			// 메일 서버에 대한 인증 정보를 관리하는 사용자 정의 클래스(GoogleSMTPAuthenticator)의 인스턴스 생성
			Authenticator authenticator = new GoogleSMTPAuthenticator(); // 슈퍼클래스 타입으로 업캐스팅

			// 자바 메일 기본 전송단위를 javax.mail.Session 객체 단위로 관리
			Session mailSession = Session.getDefaultInstance(properties, authenticator);

			// 메일 발송 정보를 관리할 javax.mail.internet.MimeMessage 객체 생성
			Message mailMessage = new MimeMessage(mailSession);

			// 전송할 메일에 대한 발송 정보 설정
			Address sender_address = new InternetAddress(sender, "아이티윌");
			//2. 수신자 정보 설정(InternetAddress 객체를 사용하여 수신자 주소 설정)
			Address receiver_address = new InternetAddress(receiver);
			//3. 위에서 생성한 Message 객체를 활용하여 전송할 메일 정보 설정
			mailMessage.setHeader("content-type", "text/html; charset=UTF-8");
			mailMessage.setFrom(sender_address);
			mailMessage.addRecipient(RecipientType.TO, receiver_address);
			mailMessage.setSubject(title);
			mailMessage.setContent(content, "text/html; charset=UTF-8");
			mailMessage.setSentDate(new Date());

			// 메일 전송
			Transport.send(mailMessage);
			System.out.println("메일이 정상적으로 전송되었습니다!");
			
			isSendSuccess = true;
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("SMTP 서버 설정 또는 서비스 문제 발생!");
		}

		return isSendSuccess;
	}
	
}
