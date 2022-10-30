package ex05_09;

public class Ex6 {

	public static void main(String[] args) {
		Person 김씨 = new Person();
		Person 이씨 = new Person();
		김씨.setMoney(10000);
		System.out.println(김씨.money);
		김씨.person(4000);
		
	}

}
class Person {
	String name;
	int money;
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public Person person(int price) {
		Person 사람 = new Person();
		money -= price;
		System.out.println(사람.money);
		return 사람;
	}
	
}
class Coffeeshop {
	String shop;
	String coffeename;
//	public Coffeeshop coffeshop(String 커피, int price) {
//		Coffeeshop 커피샵 = new Coffeeshop();
//		커피샵.coffeename = 커피;
//		커피샵.price = price;
//		return 커피샵;
//	}
}
	
