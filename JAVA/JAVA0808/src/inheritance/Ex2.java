package inheritance;

public class Ex2 {

	public static void main(String[] args) {
		
		Spiderman sm = new Spiderman();
		sm.name = "피터 파커";
		sm.age = 20;
		sm.nickname = "친절한 이웃 스파이더맨";
		sm.eat();
		sm.jump();
		sm.fireWeb();
//		sm.normalLife(); private 접근제한자로 선언되어 상속이 안됨.
		
//		Person p = new Person();
//		Spiderman sm2 = new Spiderman("피터 파커", 20); 오류! 슈퍼클래스의 생성자는 상속되지 않음
		
	}

}

class Person {
	String name;
	int age;
	
	public Person() {}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void eat() {
		System.out.println("밥 먹기!");
	}
	public void jump() {
		System.out.println("점프!");
	}
	private void normalLife() {
		System.out.println("평범한 삶");
	}
}

class Spiderman extends Person {
	public Spiderman() {
		super("홍길동", 20);
	}
	String nickname;
//	public Spiderman(String name, int age) {
//		this.name = name;
//		this.age = age;
//	}
	public void fireWeb() {
		System.out.println("거미줄 발사!");
	}
}








