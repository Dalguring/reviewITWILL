package inheritance;

public class Ex1 {

	public static void main(String[] args) {
		Child c = new Child();
		c.childPrn();
		c.name = "홍길동";
		c.parentPrn();
		
		Parent p = new Parent();
		p.name = "이순신";
		p.parentPrn();
		System.out.println("===========================================");
//		p.childPrn();
		System.out.println("=========아버지=========");
		아버지 아버지 = new 아버지();
		System.out.println(아버지.car);
		아버지.drawWell();
		System.out.println(아버지.house);
		아버지.singWell();
		System.out.println("==========나=========");
		나 나 = new 나();
		System.out.println(나.pc);
		나.programmingWell();
		System.out.println(나.house);
		System.out.println(나.car);
		나.singWell();
		나.drawWell();
	}

}

class 할아버지 {
	String house = "이층집";
	public void singWell() {
		System.out.println("노래를 잘한다!");
	}
}

class 아버지 extends 할아버지{
	String car = "자동차";
	public void drawWell() {
		System.out.println("그림을 잘 그린다!");
	}
}

class 나 extends 아버지 {
	String pc = "컴퓨터";
	public void programmingWell() {
		System.out.println("프로그래밍을 잘한다!");
	}
}

class Parent {
	String name;
	public void parentPrn() {
		System.out.println("슈퍼클래스 Parent의 parentPrn()");
	}
}

class Child extends Parent {
	public void childPrn() {
		System.out.println("서브클래스 Child의 childPrn()");
	}
}
