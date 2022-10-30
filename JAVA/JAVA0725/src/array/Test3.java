package array;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
//		int[] arr = {1, 2, 3, 4, 5};
//		for(int i = 0; i < arr.length; i++) {
//			for(int j = 0; j < arr.length; j++) {
//				System.out.print(arr[j] + " ");
//			}
//		
//			System.out.println();
//			int temp = arr[0];
//			for(int j = 0; j < arr.length-1; j++) {
//				arr[j] = arr[j+1];
//			}
//			arr[arr.length-1] = temp;
//		}
		System.out.println("=====================================================");
//		int[] arr = {1, 2, 3, 4, 5};
//		arr[0] = arr[1];
//		arr[1] = arr[2];
//		arr[2] = arr[3];	
//		arr[3] = arr[4];	규칙 찾기
//		for(int i=0; i < arr.length; i++) {
//			
//			for(int j = 0; j < arr.length; j++) {
//				System.out.print(arr[j] + " ");
//			}
//			System.out.println();
//			int temp = arr[0];
//			for(int j = 0; j < arr.length-1; j++) {
//				arr[j] = arr[j+1];
//			}
//			arr[arr.length-1] = temp;
//			
//		}
		System.out.println("=====================================================");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n*2];
		for(int i = 0; i < n; i++) {
			int num = sc.nextInt();
			arr[i] = num;
			arr[i+n] = num;
		}
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n + i; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		}
		
	}
	public static void rotation(int[] arr) { 
		int temp = arr[0];
		for(int j = 0; j < arr.length-1; j++) {
			arr[j] = arr[j+1];
		}
		arr[arr.length-1] = temp;
	}
}
