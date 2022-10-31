package array;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 다차원 배열(2차원 배열)
		 * */
		
		int[][]arr;
		arr = new int[2][3];
		arr[0][0] = 1; arr[0][1] = 2; arr[0][2] = 3;
		arr[1][0] = 4; arr[1][1] = 5; arr[1][2] = 6;
		
		System.out.println(arr[0][0] + " " + arr[0][1] + " " + arr[0][2]);
		System.out.println(arr[1][0] + " " + arr[1][1] + " " + arr[1][2]);
		System.out.println("------------------------------------------");
		
		for(int i = 0; i < arr.length; i++) {
			
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
 		}
		
		System.out.println("배열 arr의 행크기 : " + arr.length);
		System.out.println("배열 arr의 0번 행의 열크기 : " + arr[0].length);
		System.out.println("배열 arr의 1번 행의 열크기 : " + arr[1].length);
		
		System.out.println("==========================================");
		int[][]arr2 = { 
				{1, 2, 3}, 
				{4, 5, 6} 
		};
		for(int i = 0; i < arr2.length; i++) {
			
			for(int j = 0; j < arr2[i].length; j++) {
				System.out.print(arr2[i][j] + " ");
			}
			System.out.println();
 		}
		
		System.out.println("===========================================");
		
		int[][]arr3 = {
				{1, 2, 3},
				{4, 5},
				{6, 7, 8, 9, 10}
		};
		
//		for(int i = 0; i < arr3.length; i++) {
//			
//			for(int j = 0; j < arr3[i].length; j++) {
//				System.out.print(arr3[i][j] + " ");
//			}
//			System.out.println();
// 		}
		
		System.out.println("===========================================");
		
		int[][]arr4 = new int[3][];
//		arr4[0] = new int[3]; 
//		arr4[1] = new int[2];
//		arr4[2] = new int[5];
//		arr4[0] = {1, 2, 3}; //안됨.
//		arr4[1] = {4, 5};
//		arr4[2] = {6, 7, 8, 9, 10};
		
		arr4[0] = new int[] {1, 2, 3};
		arr4[1] = new int[] {4, 5};
		arr4[2] = new int[] {6, 7, 8, 9, 10};
		
		for(int i = 0; i < arr4.length; i++) {
			
			for(int j = 0; j < arr4[i].length; j++) {
				System.out.print(arr4[i][j] + " ");
			}
			System.out.println();
 		}
		
		
		
		
		
		
		
	}

}
