package static_;

public class Ex2 {

	public static void main(String[] args) {
		//생성자에 private이 적용되어 객체생성할 방법이 없는 상황
//		new Car();
		Car car1 = Car.getInstance();
		Car car2 = Car.getInstance();
		System.out.println(car1 == car2);
		System.out.println(car1);
		System.out.println(car2);
		
		NormalClass n1 = new NormalClass();
		NormalClass n2 = new NormalClass();
		System.out.println(n1 == n2);
		System.out.println(n1);
		System.out.println(n2);
	}

}

class NormalClass {
	
}

class Car {
	static Car car;
	private Car() {}
	static Car getInstance() {
		if(car==null) {
			car = new Car();
		}
		return car;
	}
}




