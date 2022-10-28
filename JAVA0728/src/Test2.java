import java.util.Scanner;
public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int[] N = new int[a];
		for(int i = 0; i < N.length; i++) {
			N[i] = sc.nextInt();
		}
		int b = sc.nextInt();
		int[] M = new int[b];
		for(int i = 0; i < M.length; i++) {
			M[i] = sc.nextInt();
		}
		int[] check = new int[b];
//		=========================================================================
		for(int i = 0; i < M.length; i++) {
			for(int j =0; j < N.length; j++) {
				if(M[i] == N[j]) {
					check[i] = 1;
					break;
				} else {
					check[i] = 0;
				}
			}
		}
		
		for(int i = 0; i < check.length; i++) {
			System.out.print(check[i] + " ");
		}
		
	}

}
