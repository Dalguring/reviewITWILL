package ref_casting;

public class Ex1 {

	public static void main(String[] args) {
		int a = 10;
//		long l = a;
		long l = (long)a;
		//---------------------------------------------------
		// 1. 참조 데이터타입에서의 묵시적(자동) 형변환 = 업캐스팅
		//---------------------------------------------------
		Child c = new Child();
		c.parentPrn();
		c.childPrn();
		
		// 슈퍼클래스 타입 레퍼런스 변수 선언
		Parent p;
		p = c; //서브클래스 인스턴스 주소를 슈퍼클래스 타입 변수에 전달
		p.parentPrn();
//		p.childPrn(); //컴파일 에러 발생! 서브클래스에서 정의한 메서드는 접근 불가능! (은닉됨)
		System.out.println("===========================================");
		//---------------------------------------------------
		// 2. 참조 데이터타입에서의 명시적(강제) 형변환 = 다운캐스팅
		//---------------------------------------------------
		Parent p2 = new Parent();
		p2.parentPrn();
		Child c2;
//		c2 = (Child)p2; //컴파일 에러 발생(자동 형변환이 제공되지 않음)하므로 명시적 형변환이 필수! 
		
		//만약, 변환이 가능하다고 가정했을 때
		//서브클래스 타입 레퍼런스 변수 c2로 접근 가능한 메서드 : 2개
//		c2.parentPrn();
//		c2.childPrn(); //런타임 에러 발생! Parent를 참조하는 객체를 생성하여 실제로는 Child를 참조하는 객체가 생성되지 않았으므로
		
		//---------------------------------------------------
		// 3. 다운 캐스팅이 가능한 경우
		// => 이전에 이미 업캐스팅 된 인스턴스를 다시 다운캐스팅 하는 경우
		//---------------------------------------------------
		
		Parent p3 = new Child();
		p3.parentPrn();
//		p3.childPrn(); 접근 불가능
		Child c3 = (Child)p3;
		
		//다운캐스팅에 의해 참조 가능한 영역이 확대됨
		//따라서, 서브클래스 타입 c3로 접근 가능한 메서드 : 2개
		c3.parentPrn();
		c3.childPrn();
		//이전에 이미 업캐스팅 된 레퍼런스를 다시 다운캐스팅 하는 경우에만 안전하다! (그 외에는 런타임 오류발생)
		
		
	}

}

class Parent {
	public void parentPrn() {
		System.out.println("슈퍼클래스의 parentPrn");
	}
}

class Child extends Parent{
	public void childPrn() {
		System.out.println("서브클래스의 childPrn");
	}
}



