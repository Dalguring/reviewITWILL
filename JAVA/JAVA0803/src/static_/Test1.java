package static_;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
//		  2     4      6
	//출 	70 80 60 20 30 50 10 88 77 89
	//		  	 ㅣㅣ    ㅣㅣ   ㅣㅣ
	//		70 60 40 50 55 65 23 44 37 88 도
		
		Road r1 = new Road();
		r1.Rd1();
	}

}

class Road {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int[] rd1 = new int[n];
	int[] rd2 = new int[n];
	public void Rd1() {
		for(int i = 0; i < rd1.length; i++) {
			rd1[i] = sc.nextInt();
		}
		for(int i = 0; i < rd1.length; i++) {
			System.out.print(rd1[i] + " ");
		}
	}
	public void Rd2() {
		for(int i = 0; i < rd2.length; i++) {
			rd2[i] = sc.nextInt();
		}
		for(int i = 0; i < rd2.length; i++) {
			System.out.print(rd2[i] + " ");
		}
	}
}

class Bridge {
	Scanner sc = new Scanner(System.in);
	int n2 = sc.nextInt(); 
	int[] br = new int[n2];
	public void Br() {
		for(int i = 0; i < br.length; i++) {
			br[i] = sc.nextInt();
		}
	}
}
