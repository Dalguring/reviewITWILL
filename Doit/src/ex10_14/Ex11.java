package ex10_14;

public class Ex11 {

	public static void main(String[] args) {
		
		MyDog dog = new MyDog("멍멍이", "진돗개");
		System.out.println(dog);
		
	}

}

class MyDog {
	String bark;
	String name;
	
	public MyDog(String bark, String name) {
		this.bark = bark;
		this.name = name;
	}

	@Override
	public String toString() {
		return name + " " + bark;
	}

	
}
