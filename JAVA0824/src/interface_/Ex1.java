package interface_;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 인터페이스(Interface)
		 * - 클래스가 아니므로 선언 시 class 키워드 대신 interface 키워드 사용
		 * - 인터페이스는 추상메서드와 상수만 가질 수 있다.
		 *   => 모든 메서드는 무조건 public abstract가 붙은 추상메서드로 취급됨 (생략가능)
		 *   	(메서드 바디를 가질 수 없으며, public으로 인해서 누구나 접근이 가능함)
		 *   => 모든 멤버변수는 public static final 이 붙은 상수로 취급됨 (생략가능)
		 *   	(final로 인해서 값 변경 불가능, static으로 인해서 클래스 명만으로 접근가능, public으로 인해 누구나 접근 가능)
		 * - 추상 클래스와 마찬가지로 객체 생성이 불가능 (추상메서드 때문)
		 *   => 단, 참조변수 타입으로는 사용 가능 = 다형성 활용(업캐스팅) 가능
		 * - 추상메서드 구현을 강제하고, 변수를 상수로 강제하여 코드의 통일성이 향상됨 = 추상클래스와 유사하나 추상클래스보다 더 강력한 강제성 부여
		 *   (모든 메서드는 추상메서드이며 모든 멤버변수가 상수이기때문)
		 * - 서브클래스에서 인터페이스를 상속 받아 구현해야할 경우 implements 키워드 사용
		 *   => 클래스는 상속받아 확장의 개념(extends)이 강하지만, 인터페이스는 상속받아 추상메서드를 구현하는 개념(implements)이 강하다
		 * - 클래스는 다중상속이 불가능하지만, 인터페이스는 다중 구현(implements)이 가능함.
		 *   => 두 개 이상의 부모 인터페이스로부터 상속(구현) 가능
		 *   => class 서브클래스명 implements 부모인터페이스1, 부모인터페이스2, ...{}
		 * - 인터페이스끼리 상속받을 경우 extends 키워드 사용
		 * 
		 */
		//인터페이스도 추상클래스와 마찬가지로 인스턴스 생성 불가!
//		MyInterface mi = new MyInterface(); 
		
		//인터페이스를 구현한 구현체 클래스(서브클래스)를 통해 사용해야함
		MySubClass msc = new MySubClass();
		msc.method1();
		msc.method2();
		
		//인터페이스 내의 모든 변수는 상수이므로 값 변경 불가
		//=> 인터페이스를 구현한 구현체 클래스에도 동일한 상수가 상속됨
//		MyInterface.NUM1 = 10;	//변경불가
//		MyInterface.NUM2 = 20; 	//변경불가
//		MySubClass.NUM1 = 10;	//변경불가
//		msc.NUM1 = 10; 		  	//변경불가
		System.out.println("------------------------------------------------------------------");
		//인터페이스는 인스턴스 생성은 불가능하지만, 참조변수 타입으로 사용가능
		//=> 클래스의 인스턴스를 인터페이스 타입으로도 업캐스팅 가능함(상속 관계이므로)
		MyInterface mi = new MySubClass();
		//업캐스팅 후에는 참조영역이 축소되므로 상속된 메서드만 호출 가능함
		//=> 하지만 인터페이스가 정의한 추상메서드를 모두 오버라이딩했기 때문에
		//	 인터페이스의 모든 메서드는 참조영역이 축소되더라도 호출 가능함 (공통 메서드)
		mi.method1();
		mi.method2();
		
		//또한, 상수도 인터페이스에서 선언했으므로 접근가능!
		System.out.println(MyInterface.NUM1);
		System.out.println(MySubClass.NUM2);
		
	}

}

//인터페이스 정의
interface MyInterface {
	
	//인터페이스 내의 모든 멤버변수는 상수(public static final)이다.
	public static final int NUM1 = 10; //상수
	int NUM2 = 20; //상수
	
	//인터페이스 내의 모든 메서드는 추상메서드(public abstract)이다.
	public abstract void method1(); //추상메서드
	void method2(); //추상메서드
	
	
}
//인터페이스를 상속받아 구현하는 구현체 클래스 정의
class MySubClass implements MyInterface{
	
	//인터페이스를 상속받아 구현하는 서브클래스에서 반드시 추상메서드 오버라이딩 필수!
	@Override
	public void method1() {
		System.out.println("서브클래스에서 구현한 추상메서드 method1()");
	}
	
	//상속 관계에서 오버라이딩 시 부모의 접근제한자보다 좁아질 수 없다!
	//=> 인터페이스에서 method2()의 접근제한자를 생략했지만, 자동으로 public이 붙으므로
	// 	 오버라이딩 메서드는 public만 사용 가능함
	@Override
	public void method2() {
		System.out.println("서브클래스에서 구현한 추상메서드 method2()");
	}
	
}












