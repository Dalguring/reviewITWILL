package polymorphism;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 동적 바인딩
		 * - 컴파일(번역) 시점에서 실행될 것으로 예상되는 코드와
		 * 	 실제 실행 시점에서 해당 객체의 타입 기준으로 메서드가 달라지는 것
		 * 
		 * 
		 */
		
		Employee emp = new Employee("홍길동", 3000);
		System.out.println("emp.getEmployee() : " + emp.getEmployee());
		System.out.println("=====================================");
		
		Manager man = new Manager("이순신", 4000, "개발팀");
		System.out.println("man.getEmployee() : " + man.getEmployee()); 
		System.out.println("=====================================");
		
		emp = man;
		//아래는 동적 바인딩
		System.out.println("emp.getEmployee() : " + emp.getEmployee());
		//=> 코드상(컴파일시점)으로는 Employee 클래스의 getEmployee() 메서드가 호출될 것으로 보이지만
		//	 실제 emp 변수에 저장된 인스턴스(객체) Manager 클래스의 인스턴스 이므로
		//	 실행 시점에는 Manager 클래스에 오버라이딩 된 getEmployee() 메서드가 실행됨!
		System.out.println("=====================================");
		
		Engineer eng = new Engineer("강감찬", 2000, "자바개발");
		System.out.println("eng.getEmployee() : " + eng.getEmployee());
		Employee emp2;
		emp2 = eng;
		System.out.println("emp2.getEmployee() : " + emp2.getEmployee());
		
		emp2 = new Manager("이순신", 4000, "개발팀2"); 
		//출력문에서 실행되는 메서드는 문법적으로 차이가 없지만
		//실제 참조하는 인스턴스가 달라지므로 결과값이 다르다!
		System.out.println("emp2.getEmployee() : " + emp2.getEmployee());
		
	}

}

class Employee {
	String name;
	int salary;
	public Employee() {}
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public String getEmployee() {
		String ns = this.name + ", " + this.salary;
		return ns;
	}
	
}

class Manager extends Employee {
	String depart;
	
	public Manager(String name, int salary, String depart) {
		super(name, salary);
		this.depart = depart;
	}

	@Override
	public String getEmployee() {
		return super.getEmployee() + ", " + this.depart;
	}
}

class Engineer extends Employee {
	String skill;

	public Engineer(String name, int salary, String skill) {
		super(name, salary);
		this.skill = skill;
	}

	@Override
	public String getEmployee() {
		return super.getEmployee() + ", " + this.skill;
	}
	
}






