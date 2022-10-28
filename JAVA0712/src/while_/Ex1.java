package while_;

public class Ex1 {

	public static void main(String[] args) {
		int i = 1;
		while(i <= 10) {
			System.out.print(i + " ");
			i++;
		}
		System.out.println();
		System.out.println("==============================================");
		i = 2;
		while(i <= 10) {
			System.out.println(i + " ");
			i+=2;
		}
		System.out.println("==============================================");
		i = 10;
		while(i > 0) {
			System.out.println(i + " ");
			i--;
		}
	}

}
