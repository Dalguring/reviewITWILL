package static_;

public class Ex3 {

	public static void main(String[] args) {
		
		
//		System.out.println(s1.a); 안됨.객체 생성 전임
		System.out.println("StaticMember.a = " + StaticMember.a);
//		System.out.println("StaticMember.b = " + StaticMember.b); static멤버로 선언되지 않은 인스턴스 멤버변수
		StaticMember s1 = new StaticMember();
		StaticMember s2 = new StaticMember();
		System.out.println("s1.a = " + s1.a + ", s2.a = " + s2.a);
		System.out.println("s1.b = " + s1.b + ", s2.b = " + s2.b);
//		s1.a=99;
		StaticMember.a=99;
		System.out.println("s1.a = " + s1.a + ", s2.a = " + s2.a);
		
		s2.b=999;
		System.out.println("s1.b = " + s1.b + ", s2.b = " + s2.b);
		System.out.println("=====================================");
		s1.normalMethod();
		s1.staticMethod();
//		StaticMember.normalMethod(); 오류! 일반 메서드는 클래스명만으로 호출 불가능!
		StaticMember.staticMethod();
		
		
		
		
		
		
	}

}

class StaticMember {
	
	static int a = 10;
	int b = 20;
	
	public void normalMethod() {
		System.out.println("일반 메서드!");
	}
	
	public static void staticMethod() {
		System.out.println("static 메서드!");
	}
}
