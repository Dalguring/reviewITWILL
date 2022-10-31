import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		int[] a = new int [8];
		int m = 50000;
		for(int i = 0; i < 8; i++) {
			if(i%2==0) {
				a[i] = N/m;
				System.out.println(m + "원 : " + a[i] + "개");
				N%=m;
				m/=5;
			} else if(i%2==1) {
				a[i] = N/m;
				System.out.println(m + "원 : " + a[i] + "개");
				N%=m;
				m/=2;
			}
		}
		
		
	}

}
