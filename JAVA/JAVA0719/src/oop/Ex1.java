package oop;

public class Ex1 {

	public static void main(String[] args) {
//		Person p;
////		System.out.println(p); 초기화가 돼있지 않아 실행 불가
//		p = new Person();
		//1. 멤버 변수값 출력
		Person p = new Person();
		System.out.println("이름(p.name): " + p.name);
		System.out.println("나이(p.age): " + p.age);
		System.out.println("배고픔(p.isHungry): " + p.isHungry);
		//2. 메서드 호출
		p.eat();
		p.talk();
		System.out.println("===========================================");
		
		//인스턴스의 멤버변수 초기화(값 지정)
		//참조변수명.멤버변수명 = 값;
		p.name = "홍길동";
		p.age = 20;
		p.isHungry = true;
		System.out.println("이름(p.name): " + p.name);
		System.out.println("나이(p.age): " + p.age);
		System.out.println("배고픔(p.isHungry): " + p.isHungry);
		
		System.out.println("===========================================");
		
		//인스턴스 p2 생성
		Person p2 = new Person();
		p2.name = "서성민";
		p2.age = 28;
		p2.isHungry = false;
		System.out.println("이름(p2.name): " + p2.name);
		System.out.println("나이(p2.age): " + p2.age);
		System.out.println("배고픔(p2  .isHungry): " + p2.isHungry);
		
	}

}
