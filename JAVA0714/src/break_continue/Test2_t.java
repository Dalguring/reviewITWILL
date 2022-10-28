package break_continue;

import java.util.Random;
import java.util.Scanner;

public class Test2_t {

	public static void main(String[] args) {
		/*
		 * UP & DOWN 게임 만들기
		 * 1 ~ 999 사이의 난수 하나를 target에 저장
		 * 20번 반복하면서 정수를 입력받는다.
		 * 	- target 보다 작은수를 입력받았을경우 "UP" 출력
		 *  - target 보다 큰 수를 입력받았을경우 "DOWN" 출력
		 *  - 일치하는 숫자를 입력받았을 경우 target과 몇회만에 맞췄는지 출력 후 반복 종료
		 *    정답: XXX, 횟수: XXX
		 *  - 20번 안에 정답을 맞추지 못한 경우 "실패! 정답: XXX" 출력
		 *  
		 * 추가) 난이도를 선택할 수 있도록 프로그램변경
		 * 상, 중, 하 (2, 1, 0) 중 하나를 입력받는다.
		 * => 단, 이외 숫자가 입력될 경우 "입력오류: 상(2)/중(1)/하(0)중 입력!"
		 *    출력 후 계속 입력받음
		 * 상: 반복횟수 8번
		 * 중: 반복횟수 12번
		 * 하: 반복횟수 20번    
		 * */
		
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("< UP & DOWN GAME!! >");
		
		// 난이도 설정
		System.out.print("난이도를 선택하세요. 상(2)/중(1)/하(0) : ");
		int mode;
		int count;
		WHILE:
		while(true) {
			mode = sc.nextInt();
			
			switch (mode) {
			case 2:
				count = 8;
				break WHILE;
			case 1:
				count = 12;
				break WHILE;
			case 0:
				count = 20;
				break WHILE;
			default:
				System.out.println("입력오류: 상(2)/중(1)/하(0)중 입력!");
				System.out.print("난이도를 선택하세요. 상(2)/중(1)/하(0) : ");
				break;
			}
			
//			if(mode == 2) {	// 상
//				count = 8;
//				break;
//			} else if(mode == 1) { // 중
//				count = 12;
//				break;
//			} else if(mode == 0) { // 하
//				count = 20;
//				break;
//			} else {
//				System.out.println("입력오류: 상(2)/중(1)/하(0)중 입력!");
//				System.out.print("난이도를 선택하세요. 상(2)/중(1)/하(0) : ");
//			}
		}
		
		System.out.println("난이도가 '" + mode + "'로 설정 되었습니다. 기회(" + count + "회)");
		
		// UP & DOWN
		int target = r.nextInt(999) + 1;
//		int target = 10;
		
		boolean isSuccess = false;
		
		for(int i = 0; i < count; i++) {
			System.out.print("1 ~ 999 사이 정수를 입력 : ");
			int num = sc.nextInt();
			
			if(target > num) {
				System.out.println("UP");
			} else if(target < num) {
				System.out.println("DOWN");
			} else { // 정답
				System.out.println("정답: " + target + ", 횟수: " + i);
				isSuccess = true;
				break;
			}
		}
		
		if(!isSuccess) System.out.println("실패 (정답: " + target + ") ^^;");
		
		
	}

}
