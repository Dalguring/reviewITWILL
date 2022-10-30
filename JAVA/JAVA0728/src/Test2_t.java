import java.util.Scanner;

public class Test2_t {

	public static void main(String[] args) {
		// 기억력 테스트
		// N 개의 숫자를 먼저 말해준다.
		// M 개의 질문을 받아 그 숫자가 있었는지 판별하시오.
		// 있으면 1 없으면 0을 출력
		// 입력예시)
		//			5
		//			2 52 23 55 100
		//			4
		//			5 2 55 99
		// 출력예시)
		//			0 1 1 0
		
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int[] numbers = new int[N];
//		for(int i = 0; i < numbers.length; i++) {
//			numbers[i] = sc.nextInt();
//		}
//		
//		for(int i = 0; i < numbers.length; i++) {
//			System.out.println(numbers[i]);
//		}
		
		int[] target = {2, 52, 23, 55, 100};
		int[] nums = {5, 2, 55, 99};
		for(int i = 0; i < nums.length; i++) {
			System.out.print(existsNum(target, nums[i]) ? "1 " : "0 ");
		}
	} // main() 메서드 끝
	
	public static boolean existsNum(int[] target, int num) {
		for(int i = 0; i < target.length; i++) {
			if(num == target[i]) {	// 찾음
				return true;
			}
		}
		return false;
	}
	
	
	

}
