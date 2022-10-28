package method;

class OverloadingMethod {
	
	public void add(int a, int b) {
		System.out.println("add(int, int)호출됨!");
		System.out.println(a+b);
	}
	
	public void add(double a, double b) {
		System.out.println("add(double, double)호출됨!");
		System.out.println(a+b);
	}
	
	public void add(long a, long b) {
		System.out.println("add(long, long)호출됨!");
		System.out.println(a+b);
	}
}

public class Test2 {

	public static void main(String[] args) {
		OverloadingMethod om = new OverloadingMethod();
		om.add(10, 10);
		om.add(3.14, 3.14);
		om.add(10L, 10L);
		System.out.println("--------------------");
		om.add(10, 2.2);
		om.add(3.14, 100L);
		
	}

}
