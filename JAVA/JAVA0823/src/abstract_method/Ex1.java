package abstract_method;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 추상메서드 (abstract method)
		 * - 메서드 구현부(= 바디{})가 없는 메서드 (미완성 메서드)
		 * - 메서드의 동작을 기술하는 구현부가 없는 추상메서드는
		 *   실행할 수 있는 코드가 없으므로 외부로부터 호출하면 안됨
		 *   => 따라서, 추상메서드를 갖는 클래스는 반드시 추상클래스로 선언되어야 한다!
		 * - 메서드 정의 시 선언부의 접근제한자 뒤에 abstract 키워드를 붙여서 정의
		 *   => abstract 키워드가 붙은 메서드는 추상메서드이므로 바디{}를 가질 수 없다!
		 *   	(따라서 메서드 선언부 마지막에 바디{}대신 세미콜론으로 끝남)
		 * - 서브클래스에서 반드시 오버라이딩 하도록 강제성을 부여해야하는 메서드는
		 *   슈퍼클래스에서 추상메서드로 선언하면 서브클래스가 무조건 오버라이딩 필수!
		 *   => 강제성을 통해 업캐스팅 시 코드의 통일성을 더욱 향상시킬 수 있다
		 * 
		 * < 추상메스더 정의 기본 문법 >
		 * [접근제한자] abstract [리턴타입] 메서드명([매개변수...]);
		 * 
		 * ------------------------------------------------------------------------------
		 * 추상클래스 (abstract Class)
		 * - 객체를 생성할 수 없는 클래스(미완성 클래스)
		 *   => 따라서 new 연산자를 통해 생성자 호출 불가능
		 * - 추상메서드를 가질 수 있는 클래스
		 *   => 상속받는 서브클래스에서 반드시 오버라이딩 해야한다!
		 * - 추상클래스는 추상메서드, 일반메서드, 생성자, 멤버변수를 모두 가질 수 있다
		 * - 상속을 통해 서브클래스에서 사용가능하며
		 *   업캐스팅을 통한 다형성 활용이 가능함
		 * - 구현의 강제성 부여를 통해 코드의 통일성이 향상됨
		 *   (일부 메서드에 대한 구현에 강제성을 부여)
		 * 
		 * < 추상 클래스 정의 기본 문법 >
		 * abstract class 클래스명 {
		 * 		//멤버변수	(인스턴스멤버, 클래스(static)멤버)
		 * 		//생성자
		 *		//메서드 (abstract 추상 메서드 포함)
		 * }
		 * 
		 */
		
//		AbstractClass ac = new AbstractClass();
		//추상클래스는 인스턴스 생성이 불가능한 클래스이다!
		SubClass sc = new SubClass();
		sc.abstractMethod();
		
		//추상클래스는 인스턴스 생성은 불가능하지만, 다형성 활용은 가능
		// => 즉, 변수의 클래스 타입으로 사용할 수 있다!
		
		AbstractClass ac = sc; // 업캐스팅
		//업캐스팅 시 참조영역이 축소되지만, 추상메서드는 반드시 구현되어 존재하므로
		//슈퍼클래스 타입으로 상속되어 구현된 추상메서드 호출이 가능하다!
		ac.abstractMethod();
		
		System.out.println("==================================================");
		
//		MiddleClass mc = new MiddleClass();
		SubClass2 sc2 = new SubClass2();
		sc2.abstractMethod();
		
		AbstractClass ac2 = sc2;
		ac2.abstractMethod();
		
		MiddleClass mc = (MiddleClass)ac2;
		mc.abstractMethod();
	}

}

abstract class AbstractClass {
	//주의! abstract 키워드가 붙은 메서드는 추상메서드이므로 바디를 가질 수 없다!
	//바디를 정의할 경우 오류 발생!
//	public abstract void abstractMethod() { // 오류 발생!
//		
//	}
	
	public abstract void abstractMethod();
	
	//======================================================
	//추상클래스는 멤버변수와 일반 메서드 (static 메서드 포함), 생성자도 가질 수 있다.
	//아래 모두 가능
	int a;
	static int b;
	
	public AbstractClass() {}
	public void print() {}
	public static void print2() {}
}

class SubClass extends AbstractClass{
	
	//추상클래스를 상속받은 서브클래스는 추상클래스에 추상메서드가 존재할 경우 반드시 오버라이딩을 통해 추상메서드의 구현부(바디{})를 정의해야함!
	//만약 오버라이딩을 하지 않을 경우 상속이 불가능하며 현재의 서브클래스도 추상클래스로 선언해야한다!
	
	@Override
	public void abstractMethod() {
		//메서드 오버라이딩을 통해 바디만 구현하면 메서드 내의 코드는
		//서브클래스에서 자유롭게 기술할 수 있다!
		System.out.println("서브클래스에서 오버라이딩을 통해 구현한 추상메서드!");
	}
	
}

abstract class MiddleClass extends AbstractClass {
	//추상메서드를 포함하는 추상클래스를 상속 받은 경우 오버라이딩이 필수지만
	//만약, 오버라이딩을 하지 안흥ㄹ 경우 서브클래스도 추상클래스로 선언해야한다!
	//=> 추상클래스로 선언하게 되면 해당 서브클래스도 인스턴스 생성 불가!
	//	 현재 서브클래스를 상속받는 다른 서브클래스를 통해 추상메서드 구현 강제
}

class SubClass2 extends MiddleClass {
	//추상클래스의 서브클래스가 추상클래스로 선언된 상태에서
	//해당 클래스를 상속받은 서브클래스에서 추상메서드를 구현
	@Override
	public void abstractMethod() {
		System.out.println("AbstractClass -> MiddleClass -> SubClass2 상속을 통해 구현");
	}
	
}

