package constructor;

class DefaultPerson{
	
	String name;
	//생성자를 아무것도 정의하지 않으면 컴파일러에 의해 자동으로 기본생성자가 생성됨
	public DefaultPerson() {}
}
class DefaultPertson2{
	String name;
	
	public DefaultPertson2() {
		System.out.println("DefaultPerson2() 생성자 호출됨!");
		name = "홍길동";
	}
}
class ParameterPerson{
	String name;
	
	public ParameterPerson(String newName) {
		System.out.println("ParameterPerson(String) 생성자 호출됨!");
		name = newName;
	}
}
class ParameterPerson2{
	String name;
	int age;
	boolean isHungry;
	
	public ParameterPerson2(String name, int age, boolean isHungry) {
		super();
		this.name = name;
		this.age = age;
		this.isHungry = isHungry;
	}
	
	
//	public ParameterPerson2(String newName, int newAge, boolean newIsHungry) {
//		System.out.println("ParameterPerson2(String, int, boolean) 생성자 호출됨!");
//		name = newName;
//		age = newAge;
//		isHungry = newIsHungry;
//		
//	}
	
	
}




public class Ex1 {

	public static void main(String[] args) {
		DefaultPerson dp = new DefaultPerson();
		System.out.println("DefaultPerson의 name : " + dp.name);
		System.out.println("=======================================");
		
		DefaultPertson2 dp2 = new DefaultPertson2();
		System.out.println("DefaultPerson2 : " + dp2.name);
		System.out.println("=======================================");
		
		ParameterPerson p = new ParameterPerson("소지섭");
		System.out.println("ParameterPerson의 name : " + p.name);
		System.out.println("=======================================");
		
		ParameterPerson2 p2 = new ParameterPerson2("우영우", 20, true);
		System.out.println("ParameterPerson의 name : " + p2.name);
		System.out.println("ParameterPerson의 age : " + p2.age);
		System.out.println("ParameterPerson의 isHungry : " + p2.isHungry);
		
//		new ParameterPerson2();
		
	}

}
