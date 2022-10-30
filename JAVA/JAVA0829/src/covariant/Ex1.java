package covariant;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 공변(Covariant)
		 * - 공변의 사전적 의미는 '하나가 변하면 다음것이 따라 변한다'라는 뜻이다.
		 * 
		 * 오버라이딩 시 "공변 리턴 타입" (다형성 polymorphism의 일종)
		 * - 오버라이딩이란 "부모 메서드와 시그니처가 완전히 동일한 메서드를 재정의하는 것"
		 *   => 시그니처 : 리턴타입, 메서드명, 매개변수(갯수, 데이터타입, 순서)
		 * - 하지만 부모메서드의 리턴타입이 부모클래스일 경우 오버라이딩 시
		 *   자식클래스 범위안에서 자유롭게 수정 가능하다!
		 */
		
		//1. 실제 객체와 참조변수의 타입이 동일한 상황
		A a = new A();
		B b = new B();
		
		//2. 실제 객체와 참조변수의 타입이 다른 상황
		A a2 = new B();	// 업캐스팅
		B b2 = (B)a2;	// 다운캐스팅
		
		//각각의 참조변수로 print()메서드 호출
		a.print();
		b.print();
		a2.print();
		b2.print();
		// => print() 메서드가 오버라이딩 되어 있기 때문에
		// 	  동적 바인딩으로 인해 실행시점에서 실제 객체의 메서드가 실행된다!
		// 결론, 어느 타입에 저장되어 있느냐가 중요한게 아니라
		// 실제 객체가 무엇이냐가 중요함!
		
		System.out.println("=============================");
		
		A aType;
		B bType;
		
		//1. 실제 객체와 참조변수의 타입이 동일한 상황
		aType = a.method();
//		bType = (B)a.method(); // 오류! 실제 객체가 A타입이므로 실행시점에 오류발생
		bType = b.method();
//		aType = b.method(); //리턴타입이 자식클래스이므로 업캐스팅 가능!
		
		System.out.println("=============================");
		
		//2. 실제 객체와 참조변수의 타입이 다른 상황(공변(public B method()가 override된 상황)이 적용되어 가능한 상황)
		aType = a2.method();
		bType = (B)a2.method();
		
		bType = b2.method();
		aType = b2.method();
		
		
	}

}

class A {
	public void print() {
		System.out.println("A");
	}
	
	public A method() {
		System.out.println("A 메서드가 실행됨!");
		return this;
	}
}

class B extends A {
	@Override
	public void print() {
		System.out.println("B");
	}
	
	@Override
	public B method() {
		System.out.println("B 메서드가 실행됨!");
		return this;
	}
	
	
}










