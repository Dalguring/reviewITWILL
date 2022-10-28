package method;

public class Test1 {

	public static void main(String[] args) {
		hello();
		hello2("ㅎㅇ" , 7);
		System.out.println(sum());
		int sum = sum2(10);
		sum3(100);
		
		
		//5. 리턴이 없는 경우 return문
		
		
	}

	public static void hello() {
		int i = 1;
		while(i <= 10) {
			System.out.println("Hello, World!");
			i++;
		}
	}
	
	public static void hello2(String msg, int count) {
		int i=1;
		while(i <= count) {
			System.out.println(i + " :  " +msg);
			i++;
		}
		System.out.println("반복횟수 : " + count);
	}
	
	public static int sum() {
		int i = 1, k = 0;
		while(i <=10) {
			k+=i;
			i++;
		}
		return k;
	}
	
	public static int sum2(int end) {
		int i = 1, p = 0;
		while(i <= end) {
			p+=i;
			i++;
		}
		return p;
	}
	
	public static void sum3(int limit) {
		int sum = 0;
		for(int i = 1; i <= limit; i++) {
			sum+=i;
		}
		System.out.println("return전 : " + sum);
		if(sum > 100) return;
		System.out.println("return후 : " + sum);
	}
}
