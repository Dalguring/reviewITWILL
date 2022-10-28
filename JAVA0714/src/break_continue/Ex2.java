package break_continue;

public class Ex2 {

	public static void main(String[] args) {
		OUTER:
		for(int dan =2; dan <=9; dan++) {
			System.out.println("< " + dan + "단 >");
			INNER:
			for(int i = 1; i <= 9; i++) {
				if(dan == 6) {
//					break; //안쪽 for문을 종료
//					continue; //아래쪽 실행문을 생략하고 안쪽 for문의 증감식(i++)로 이동
//					break OUTER; 바깥쪽 for문을 종료하고 프로그램 종료
//					continue OUTER; 바깥쪽 for문의 증감식(dan++)으로 이동
				}
				System.out.println(dan + " * " + i + " = " + dan*i);
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
	}

}
