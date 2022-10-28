package for_;

public class Ex1 {

	public static void main(String[] args) {
		for(int i=1; i <=10; i++) {
			System.out.println(i + " : Hello, World!");
		}
		for(int i = 2; i <=10; i +=2) {
			System.out.println(i + " ");
		}
		System.out.println();
		System.out.println("==============================");
		for(int i = 10; i>0; i--) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("==============================");
		int i = 1;
		for(;i <=10; i++) {//바깥에 동일한 변수로 선언이 돼있다면 ;로 구성요소 제외 가능
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("for문 종료 후 제어변수 i = " + i);
		
		for(i = 1; i <= 10; i++) { //이는 선언을 한게 아니고 초기화 한 것이기에 사용 가능
			System.out.print(i + " ");
		}
		System.out.println("for문 종료 후 제어변수 i = " + i);

		
		
	}

}
