package constructor;

class OverloadingPerson{
	
	String name;
	int age;
	boolean ishungry;
	
	public void print() {
		System.out.println("이름 : " + this.name);
		System.out.println("나이 : " + this.age);
		System.out.println("배고픔 : " + this.ishungry);
	}

	public OverloadingPerson() {
		System.out.println("OverloadingPerson() 생성자 호출됨!");
		this.name="홍길동";
		this.age=30;
		this.ishungry=true;
	}

	public OverloadingPerson(String name, int age, boolean ishungry) {
		System.out.println("OverloadingPerson(String, int, boolean) 생성자 호출됨!");
		this.name = name;
		this.age = age;
		this.ishungry = ishungry;
	}

	public OverloadingPerson(String name) {
		this.name = name;
	}

	public OverloadingPerson(int age) {
		this.age = age;
	}

	public OverloadingPerson(boolean ishungry) {
		this.ishungry = ishungry;
	}

	public OverloadingPerson(String name, int age) {
		this.name = name;
		this.age = age;
	}
	//같아도 파라미터 순서가 다르면 상관없이 오버로딩 됨
	public OverloadingPerson(int age, String name) {
		this.name = name;
		this.age = age;
	}
	
	
}
public class Ex2 {

	public static void main(String[] args) {
		//생성자 오버로딩 : 파라미터가 다른 생성자를 여러번 정의하는 것
		
		OverloadingPerson op = new OverloadingPerson();
		op.print();
		System.out.println("===============================");
		OverloadingPerson op2 = new OverloadingPerson("이순신", 44, false);
		op2.print();
	
	
	
	
	
	
	
	}

}
