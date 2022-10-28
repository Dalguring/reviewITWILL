package review;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new int[i+1];
			arr[i][0] = 1;
			arr[i][arr[i].length-1] = 1;
		}
		for(int i = 2; i < arr.length; i++) {
			for(int j = 1; j < arr[i].length-1; j++) {
				arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
			}
		}
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
	}

}
