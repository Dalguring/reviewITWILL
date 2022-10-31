package break_continue;

import java.util.Random;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Random r =new Random();
		int target = r.nextInt((88)+1);
//		System.out.println(target);
		Scanner sc = new Scanner(System.in);
		int count = 0;
		
		OUTER:
		for(int i = 0; i<=count; i++) {
			INNER:
			for(int n = sc.nextInt(); n!=target; ) {
				if(n<target) {
				System.out.println("UP");
				break;
				}
				else if(n>target) {
				System.out.println("DOWN");
				break;
				} 
				else if(n==target) {
				break OUTER;
				} 
				
			}
		}
		System.out.println("정답 : " + target + ", 횟수 : " + count);
		
		
		
		
		
		
	}

}
