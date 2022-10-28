import java.util.Scanner;
public class Test3 {

	public static void main(String[] args) {
//		ms[1][2] = 1; 0 1 1
//		ms[3][3] = 2; 2 2 2
//		ms[2][1] = 3; 1 0 3
//				ms[3][1] = 4; 
//		ms[2][2] = 5;
//		ms[1][3] = 6;
//				ms[2][3] = 7;
		//1. 행 감소 시 마지막열로 가는거 어떻게??
		//1- 감소(마지막행) 증가
		//2- 감소 증가(첫번째 열) 
		//3- 증가 유지
//		===================================================================
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][]ms=new int[n][n];
		int row = 0, col=n/2;

		for(int i = 1; i <= ms.length*n; i++) {
			ms[row][col] = i;
			if(i%n==0) {
				row+=1;
				if(row<0) row+=n;
				continue;
			}
			row-=1; col+=1;
			if(row<0) 	row+=n;
			if(col>n-1) col-=n;
		
		}
//	====================================================================
		for(int i = 0; i < ms.length; i++) {
			for(int j = 0; j < ms.length; j++) {
				System.out.print(ms[i][j] + "\t");
			}
			System.out.println();
		}
		
	}
	
}
	
	
	
	
	
