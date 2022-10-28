
public class Ex4 {

	public static void main(String[] args) {
		Child2 c = new Child2();
		
	}

}

class Parent2 {
//	public Parent2() {
//		System.out.println("Parent2 생성자 호출됨!");
//	}
	
	public Parent2(String name) {
		System.out.println("Parent2 생성자 호출됨!");
	}
}

class Child2 extends Parent2{
	public Child2() {
		super("홍길동");
		System.out.println("Child2 생성자 호출됨!");
	}
}
//------------------------------------------------------
class Person {
	String name;
	int age;
	
	public Person() {}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

class SpiderMan extends Person{
	boolean isSpider;
	
	
	
	
	//Alt + Shift + S -> O로 생성자 생성
	public SpiderMan(String name, int age, boolean isSpider) {
		super(name, age);
		this.isSpider = isSpider;
	}
	
//	//Alt + Shift + S -> C로 생성자 생성
//	public SpiderMan() {
//		super();
//	}
//
//	public SpiderMan(String name, int age) {
//		super(name, age);
//		
//	}

//	public SpiderMan(String name, int age, boolean isSpider) {
//		
////		this.name = name;
////		this.age = age;
//		
//		super(name, age);
//		this.isSpider = isSpider;
//		
//	}
	
	
}


