package enum_;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * enum에 속성 추가
		 * 
		 * 1. ordinal은 마치 배열처럼 0부터 시작한다.
		 * 	  그리고 ordinal은 정수 데이터이다.
		 * - 특정 데이터를 지정(연관)해 주고싶다!
		 * ex) 지역번호 : (서울 : 02, 경기도 : 031, 인천 : 052, 부산 : 051...)
		 * 	   URL : NAVER	(*https://www.naver.com*), 
		 * 			 DAUM	(*https://www.daum.net*),
		 * 			 GOOGLE	(*https://www.google.com*)
		 * 
		 * 2. 시스템 유지보수 중 enum에 멤버가 추가되거나 변경된다면?
		 * - 기존 ordinal이 깨질 수 있다.
		 * 	 => ordinal로 계산하고 있던 모든 로직을 찾아 수정해야한다.
		 *   예)	평일만 관리하고 있었다.	  (월 ~ 금 => 0 ~ 4)
		 *		주말도 관리해야 할 것 같다. (일 ~ 토 => 0 ~ 6)
		 * 
		 * 3. *모두 같은 뜻인데 DB의 테이블마다 다른 데이터로 관리되고 있다.
		 * 	 예)	학교 데이터 (졸업여부 : Y/N)
		 * 		공장 생산관리 데이터	(입고완료여부 : 1 / 0)
		 * 						(출고완료여부 : true / false) 
		 * 		배민 (결제완료여부 : T / F)
		 * 			(배달전,배달중,배달완료 : 0 / 1 / 2) 
		 * 		=> 이는 모두 상태값을 나타낸다.
		 */
		
		//1. 지역번호
		Area area = Area.부산;
		System.out.println(area);
		System.out.println(area.number);
		//2. 사이트
		Site 구글 = Site.GOOGLE;
		System.out.println(구글);
		System.out.println(구글.url);
		//3. 같은 뜻인데 다른 데이터로 관리되고 있을 경우
		Status s = Status.Y;
		System.out.println(s);
		System.out.println(s.value1);
		System.out.println(s.value2);
		System.out.println(s.value3);
		
		System.out.println("=====================================================");
		//if문에 조건식에 활용도 가능하다!
		if(s.value3) {}
		
		s = Status.N;
		System.out.println(s);
		System.out.println(s.value1);
		System.out.println(s.value2);
		System.out.println(s.value3);
		
		System.out.println("=====================================================");
		
		System.out.println(EnumTest.Y.e);
		System.out.println(EnumTest.Y.c.b);
		
		
	}

}

//1. 지역번호
enum Area {
	// enum에 멤버 추가 시 상수 마지막은 ;으로 끝나야함
	서울("02"), 경기도("031"), 인천("052"), 부산("051");
	String number;
	
	private Area(String number) {
		this.number = number;
	}
	
}

//2. 사이트
enum Site {
	NAVER("https://www.naver.com"),
	DAUM("https://www.daum.net"),
	GOOGLE("https://www.google.com");
	// enum의 멤버는 사실 Enum클래스명 참조변수명 = new Enum클래스명(); 으로 돼있고, 
	// 접근 시 Enum클래스명.변수를 통해 접근하므로
	// 파라미터를 갖는 생성자를 만들면 뒤에 파라미터를 줘서 만들어야함.
	String url;
	private Site(String url) {
		this.url = url;
	}
}

//3. 같은 뜻인데 다른 데이터로 관리되고 있을 경우
enum Status {
	Y(1, "T", true),
	N(0, "F", false);
	
	int value1;
	String value2;
	boolean value3;
	private Status(int value1, String value2, boolean value3) {
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
	}
	
}

enum EnumTest {
	Y(EnumType.T, new ClassType(1, true, 1.0, "T")),
	N(EnumType.F, new ClassType(0, false, 0.0, "F"));
	
	EnumType e;
	ClassType c;
	private EnumTest(EnumType e, ClassType c) {
		this.e = e;
		this.c = c;
	}
	
}
// enum을 enum과 연관시킴
enum EnumType {
	T, F
}

// enum을 class와 연관시킴
class ClassType {
	int i;
	boolean b;
	double d;
	String s;
	
	public ClassType(int i, boolean b, double d, String s) {
		super();
		this.i = i;
		this.b = b;
		this.d = d;
		this.s = s;
	}
}
