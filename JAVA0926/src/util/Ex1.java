package util;

import java.util.StringTokenizer;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * StringTokenizer 클래스
		 * - java.util 패키지
		 * - 문자열을 분리하여 토큰(Token = 분리된 각 문자열)을 생성하는 기능을 제공
		 * - 구분자를 기준으로 문자열을 분리하여
		 * 	 StringTokenizer 타입 객체로 관리
		 * 	 => 객체 내의 분리된 문자열을 토큰(Token)이라고 함
		 * 
		 * < 생성자 >
		 * StringTokenizer st = new StringTokenizer(원본문자열, 구분자);
		 * => 구분자(Delimeter)을 기준으로 원본문자열을 분리하여 객체로 생성
		 * 
		 * < 제공 메서드 >
		 * 1. countTokens()
		 * 2. hasMoreTokens() : boolean
		 * 3. nextToken()
		 * 
		 */
		
		String str = "자바/JSP/안드로이드";
		StringTokenizer st = new StringTokenizer(str, "/");		
		System.out.println("분리된 토큰 갯수 : " + st.countTokens());
//		System.out.println("다음 토큰이 존재하는가? : " + st.hasMoreTokens());
//		System.out.println("다음 토큰을 가져오기 : " + st.nextToken());
//		System.out.println("다음 토큰을 가져오기 : " + st.nextToken());
//		System.out.println("다음 토큰을 가져오기 : " + st.nextToken());
		
		while(st.hasMoreTokens()) {
			System.out.println("토큰 꺼내기 : " + st.nextToken());
		}
		
		String str2 = "자바.JSP.안드로이드";
		// StringTokenizer의 구분자로 사용될 문자열에 마침표 사용 시 그대로 사용 가능(".")
		// => String 클래스의 split() 와 달리 정규표현식을 적용하지 않음
		StringTokenizer st2 = new StringTokenizer(str2, ".");
		
		while(st2.hasMoreTokens()) {
			System.out.println(st2.nextToken());
		}
		
		System.out.println("==================================================");
		// 원본문자열에서 구분자로 사용해야할 문자가 복수개일 경우
		// StringTokenizer의 생성자 String delim 부분에
		// 1개의 문자열로 복수개의 구분자를 전달 시 각 문자 하나하나가 모두 구분자로 사용됨
		// 단, 구분자 문자열 순서는 무관
		// ex) StringTokenizer st = new StringTokenizer(str2, "/.$%");
		String str3 = "자바/JSP$안드로이드";
		StringTokenizer st3 = new StringTokenizer(str3, "$/");
		
		while(st3.hasMoreTokens()) {
			System.out.println(st3.nextToken());
		}
		
		System.out.println("==================================================");
		
		String str4 = "자바/JSP$안드로이드";
		String[] strs = str4.split("/|\\$");
		for(String s : strs) {
			System.out.println(s);
		}
		
	}

}
