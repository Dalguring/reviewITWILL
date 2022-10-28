package string;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String jumin = sc.nextLine();
//		char ch = jumin.charAt(7);
		
		switch (jumin.split("-")[1].charAt(0)) { // 뒷자리 첫 번째
		case '1': case '3': System.out.println("남성"); break;
		case '2': case '4': System.out.println("여성"); break;
		case '5': case '6': System.out.println("외국인"); break;
		default			  : System.out.println("괴물"); break;
		}
		
		String data1 = "Address:부산광역시 부산진구 동천로:109";
		System.out.println(data1.substring(data1.indexOf(":")+1));
		String data2 = "이름: 홍길동, 나이: 20";
		data2 = data2.replace(" ", "").trim();
		System.out.println(data2.substring(data2.indexOf(":")+1, data2.indexOf(",")));
		
	}

}
