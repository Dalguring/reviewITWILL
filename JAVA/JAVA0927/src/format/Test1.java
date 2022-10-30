package format;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test1 {

	public static void main(String[] args) {
		
		String sdfNow = new SimpleDateFormat("yyyy년 M월 dd일 (E) [a] h시 mm분 ss초").format(new Date());
		System.out.println(sdfNow);
		
		String dtfNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년 M월 dd일 (E) [a] h시 mm분 ss초"));
		System.out.println(dtfNow);
		
		
		
		
		
	}

}
