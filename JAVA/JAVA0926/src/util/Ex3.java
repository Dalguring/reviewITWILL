package util;

import java.util.Calendar;
import java.util.Date;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * java.util.Calendar 클래스
		 * - 날짜 및 시간을 관리하는 클래스(Date 클래스와 유사)
		 * - 주로 날짜 및 시간정보를 조정하는 용도로 사용
		 *   (과거에는 Calendar 클래스로 날짜 조작, Date 클래스로 날짜 표현함)
		 * - 추상클래스이므로 인스턴스 생성이 불가능하며,
		 * 	 미리 시스템으로부터 생성되어 제공되는 인스턴스를 리턴받아 사용
		 * 	 (싱글톤 디자인 패턴(Singleton Design Pattern) 활용)
		 * - toString() 메서드가 오버라이딩 되어 있으나 일반적인 날짜 식별은 어려움
		 * - get() 메서드로 날짜 및 시간 정보에 대한 항목을 지정하여 값을 가져오고,
		 * 	 set() 메서드로 날짜 및 시간 정보에 대한 항목을 지정하여 값을 설정한다.
		 * 	 => 파라미터로 사용될 대상 항목은 Calendar 클래스의 상수를 활용
		 * 	 ex) cal.get(Calendar.YEAR) => 연도 가져오기
		 * 
		 */
		
//		Calendar cal = new Calender(); // 추상클래스이므로 인스턴스 생성 불가!
		
		// 진짜 싱글톤인지 아닌지 확인하는 방법
//		Calendar cal = Calendar.getInstance();
//		Calendar cal2 = Calendar.getInstance();
//		System.out.println(cal == cal2); // true가 나와야 진짜 싱글톤 패턴
		
		Calendar cal = Calendar.getInstance();
//		System.out.println(cal);
		
		int year = cal.get(Calendar.YEAR);
		System.out.println(year);
		
		int month = cal.get(Calendar.MONTH) + 1;
		System.out.println(month);
		
		int day = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		
		System.out.println(year + "년도 " + month + "월 " + day + "일");
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(dayOfWeek); // 일요일 : 1 ~ 토요일 : 7
		
		// 오전/오후
		int amPm = cal.get(Calendar.AM_PM);
		System.out.println(amPm);
		
		String strAmPm = amPm == Calendar.AM ? "오전" : "오후";
		System.out.println(strAmPm);
		
		System.out.println("=====================================================");
		
		// 시, 분, 초
//		int hour = cal.get(Calendar.HOUR); 			// 12시간제
		int hour = cal.get(Calendar.HOUR_OF_DAY); 	// 24시간제
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		
		System.out.println(hour + "시 " + min + "분 " + sec + "초");
		System.out.println("=====================================================");
		
		// Calendar <-> Date 객체 상호 변환
		
		// 1. Calendar -> Date로 변환
		Date date = cal.getTime(); // 현재 날짜 및 시간 정보가 Date 타입으로 리턴됨
		System.out.println(date);
		
		// 2. Date -> Calendar 변환
		// => Calendar 객체가 있는 상태에서 setTime() 메서드 파라미터로 Date 객체를 전달
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date);
		System.out.println(cal2.get(Calendar.YEAR));
		
	}

}
