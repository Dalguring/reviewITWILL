package switch_case;

public class Test1 {

	public static void main(String[] args) {
		int score = 100; String grade = "";
		if(score >= 0 && score <= 100) {
			switch (score/10) {
			case 10:
			case 9:	 grade = "A학점"; break;
			case 8:	 grade = "B학점"; break;
			case 7:	 grade = "C학점"; break;
			case 6:	 grade = "D학점"; break;
			default: grade = "F학점"; break;
			}
		} else {
			grade = "점수 입력 오류";
		} 
		System.out.println(grade);
		
		System.out.println("========================================");
		int grade2 = 3; double pee = 50000;
//		if (grade2==1) 		pee*=0.95;
//		else if (grade2==2) pee*=0.85;
//		else if (grade2==3) pee*=0.70;
//		else System.out.println("회원 등급 오류!");
//		System.out.println("결제 금액 : " + (int)pee + "원");
		System.out.println("========================================");
		if (grade2>=1 && grade2<=3) {
			switch (grade2) {
			case 1: pee*=0.95; break;
			case 2: pee*=0.85; break;
			case 3: pee*=0.70; break;
			}
		} else System.out.println("회원 등급 오류");
		System.out.println("결제 금액 : " + (int)pee + "원");
		
		
		
		
	}

}
