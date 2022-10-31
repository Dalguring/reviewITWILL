package review;


class Person {
	//클래스 안에는 아래의 3가지(멤버변수, 생성자, 메서드)밖에 못옴
	//1. 멤버변수(속성, 필드) => has - a
	String name;
	int age;
	//2. 생성자(클래스 이름과 동일) : (생성자 오버로딩 : 식별이 가능하면 된다!)
	public Person() {
//		this. //멤버변수, 멤버메서드에 접근
		this("홍길동", 20); // 다른 생성자 호출 this()
		System.out.println("생성자 호출됨!"); //단, 첫줄에 와야함(this())
	}
	public Person(String name) {
		this.name = name;
	}
	public Person(int age) {}
	public Person(String name, int age) {}
	public Person(int age, String name) {}
	
	//3. 메서드
	//[접근제한자] 리턴타입, 메서드명(매개변수...) {구현!}
	void method() {
		//메서드 오버로딩(식별이 가능하면 됨!)
	}
	void method(String s) {}
	void method(int i) {}
	int method(String s, int i) { return 0;}
	void method(int i, String s) {}
	void method(String s1, String s2) {}
//	void method(String s2, String s1) {} 식별이 안되므로 오버로딩 불가능
	
	//접근제한자 
	//public > protected > default > private
	
}

public class Ex1 {
	
	//static(클래스변수 => 인스턴스마다 공유)
	//=> 메모리에 로딩되는 시점이 더 빠르다!!
	int a = 10;
	String nName = "서성민";
	static int b = 20;
	static String sName = "우영우";
	
	public void normalMethod() {
		System.out.println(a);
		System.out.println(nName);
		System.out.println(b);
		System.out.println(sName);
	}
	
	public static void main(String[] args) {
//		System.out.println(a);
//		System.out.println(nName);
//		System.out.println(b);
//		System.out.println(sName);
		
		
		
		
		
	}

}

//상속
class P {
	String house = "이층집";
	public void run() {
		System.out.println("느리게 뜀");
	}
}

class C extends P {
	String car = "자동차";
	@Override
	public void run() {
		System.out.println("좀 빨리 뜀");
	}
	
}

class S extends C {
	String computer = "컴퓨터";
	//어노테이션 : 컴파일러 주석
	@Override
	public void run() {
		System.out.println("개빠름");
	}
	
}

class AA {
	String name;
}

class BB extends AA {
	String name;
}

class CC extends BB {
	String name;
	public void method() {
		String name;
//		System.out.println(name);
		System.out.println(this.name);
		System.out.println(super.name);
	}
}
