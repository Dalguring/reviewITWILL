package ex10_14;

import java.util.HashMap;
import java.util.Map;

public class Ex12 {

	public static void main(String[] args) {
		
		CarFactory factory = CarFactory.getInstance();
		Car sonata1 = factory.createCar("쏘나타");
		Car sonata2 = factory.createCar("쏘나타");
		System.out.println(sonata1 == sonata2);
		
		Car avante1 = factory.createCar("아반떼");
		Car avante2 = factory.createCar("아반떼");
		System.out.println(avante1 == avante2);
		System.out.println(sonata1 == avante1);
		
	}

}

class CarFactory extends HashMap {
	
	Car car;
	private static CarFactory instance = new CarFactory();
	Map<String, Car> carMap = new HashMap<String, Car>();
	
	private CarFactory() {}
	
	public static CarFactory getInstance() {
		return instance;
	}
	
	public Car createCar(String name) {
			
		if(carMap.containsKey(name)) {
			return carMap.get(name);
		}
		
		carMap.put(name, new Car());
		return carMap.get(name);
	}
	
}

class Car {
	String name;
	CarFactory fac;
	public Car() {}
	public Car(String name) {
		this.name = name;
	}
	
}

