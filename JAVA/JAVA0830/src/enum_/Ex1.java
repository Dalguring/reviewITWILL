package enum_;

import java.time.LocalDate;
import java.time.Month;

public class Ex1 {

	public static void main(String[] args) {
		BadWeek bw = new BadWeek();
		
		//Setter 호출하여 파라미터로 요일 전달 시 정확한 정수값을 몰라도
		//상수 호출만으로 해당 정수 사용 및 전달이 가능
		
		bw.setMyWeek(BadWeek.WEEK_SATURDAY);
		
		if(bw.getMyWeek() == BadWeek.WEEK_SATURDAY) {
			System.out.println("오늘은 토요일 입니다!");
		}
		
		//요일 정보를 상수로 관리하는 경우의 문제점
		//=> 상수 데이터들이 정수일 경우 해당 정수를 전달받은 메서드(Setter) 호출 시 
		//	 상수 범위 값이 아닌 다른 값을 전달해도 컴파일에러(문법적 오류)가 발생하지 않는다!
		bw.setMyWeek(10); //10이라는 정수값을 갖는 요일은 없으나 int 타입 파라미터이므로 컴파일시점에서 아무런 문제가 없음
						  //그러나 해당 데이터를 사용하기 위한 시점에는 문제가 발생할 수 있다.
						  //=> 따라서, 별도로 해당 범위 내의 데이터인지 판별하여 추가적인 작업을 수행해야함!
		
		System.out.println("===============================================");
		
		//열거타입 사용
//		EnumWeek myWeek = new EnumWeek(); // 열거타입도 인스턴스 생성 불가!
		EnumWeek myWeek = EnumWeek.FRIDAY;
		System.out.println("오늘은 " + myWeek + " 입니다."); // 주소가 나오는 것이 아니라 자신의 변수명이 나옴
		if(myWeek == EnumWeek.FRIDAY) {// 상수 비교 방법이 동일함
			System.out.println("오늘은 금요일 입니다.");
		}
		
		System.out.println("===============================================");
		GoodWeek gw = new GoodWeek();
		gw.setMyWeek(EnumWeek.TUESDAY);
		System.out.println("오늘의 요일 : " + gw.getMyWeek());
		gw.printWeek();
		
		//열거타입 사용 시 장점
		//=> 정의 시 지정된 상수 외의 다른 값은 절대 전달 불가능!
//		gw.setMyWeek(5);
//		gw.setMyWeek("MONDAY");
		//=> 반드시 열거타입 명.상수명으로 지정된 값만 전달해야함!
		gw.setMyWeek(EnumWeek.SATURDAY);
		
		System.out.println("===============================================");
		
		//LocalDate 클래스의 getMonth() 메서드 호출
		LocalDate today = LocalDate.now();
//		LocalDate today2 = LocalDate.now();
//		System.out.println(today == today2);
		System.out.println(today);
		
		int monthValue = today.getMonthValue();
		System.out.println("오늘은 " + monthValue + "월 입니다!");
		
		Month month = today.getMonth();
		System.out.println("오늘은 " + month + "월 입니다!");
		
		//switch - case문으로 월 판별
		switch (month) {
		case JANUARY:System.out.println("오늘은 1월입니다.");	break;
		case FEBRUARY:System.out.println("오늘은 2월입니다.");	break;
		case AUGUST:System.out.println("오늘은 8월입니다.");	break;
		}
		
	}

}

//열거타입 정의
enum EnumWeek {
	//열거형 정의 시 중괄호 내에는 값을 갖는 상수 이름만 나열함 (별도의 값을 지정하지 않는다)
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

//열거타입을 사용하는 클래스 (Has - a)
class GoodWeek {
	
	EnumWeek myWeek; //클래스 내에서 열거타입 변수 선언 가능(로컬변수로도 가능)

	public EnumWeek getMyWeek() {
		return myWeek;
	}

	public void setMyWeek(EnumWeek myWeek) {
		this.myWeek = myWeek;
	}
	
	public void printWeek() {
		//저장된 요일(myWeek)을 판별하여 월요일 ~ 일요일까지 출력 => switch - case 사용
		//- 주의사항! switch문에 enum타입 변수를 전달할경우
		//	case문에서 비교값으로 enum 타입 값을 지정할 때 열거타입명 없이 상수 사용 가능!
		switch (myWeek) {
		case MONDAY: System.out.println("오늘은 월요일 입니다!"); break;
		case TUESDAY: System.out.println("오늘은 화요일 입니다!"); break;
		case WEDNESDAY: System.out.println("오늘은 수요일 입니다!"); break;
		case THURSDAY: System.out.println("오늘은 목요일 입니다!"); break;
		case FRIDAY: System.out.println("오늘은 금요일 입니다!"); break;
		case SATURDAY: System.out.println("오늘은 토요일 입니다!"); break;
		case SUNDAY: System.out.println("오늘은 일요일 입니다!"); break;
		}
		
	}
	
}

//----------------------------------------------
// 열거 타입을 사용하지 않고, 상수만 사용하는 경우
class BadWeek {
	
	//요일 정보를 상수로 관리하는 경우의 장점
	//=> 외부에서 실제 데이터를 정확하게 알지 못해도 상수명(변수명)만으로 값을 사용 가능하며
	//	 클래스명만으로 접근 가능하여 접근이 쉬움, 또한 값 변경이 불가능하여 안전함
	public static final int WEEK_MONDAY 	= 0;
	public static final int WEEK_TUESDAY 	= 1;
	public static final int WEEK_WEDNESDAY 	= 2;
	public static final int WEEK_THURSDAY	= 3;
	public static final int WEEK_FRIDAY 	= 4;
	public static final int WEEK_SATURDAY	= 5;
	public static final int WEEK_SUNDAY 	= 6;
	
	private int myWeek;

	public int getMyWeek() {
		return myWeek;
	}

	public void setMyWeek(int myWeek) {
//		this.myWeek = myWeek;
		if(myWeek >= WEEK_MONDAY && myWeek <= WEEK_SUNDAY) {
			this.myWeek = myWeek;
		} else {
			System.out.println("요일 입력 에러!");
		}
	}
	
}







