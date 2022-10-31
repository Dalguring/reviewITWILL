
public class Employee {
	String name;
	int salary;
	
	public String getEmployee() {
		return name + " " + salary;
	}
}

class Manager extends Employee {
	String name;
	int salary;
	String depart;
	
	public String getManager() {
		return name + " " + salary + " " + depart;
	}
}