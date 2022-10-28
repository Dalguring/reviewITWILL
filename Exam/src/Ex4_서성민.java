
public class Ex4_서성민 {

	public static void main(String[] args) {
		
		// 1. 문자열 대소문자 관계없이 일치 판별 문제
		String id = "admin";
		if(id.equalsIgnoreCase("ADMIN")) {
			System.out.println("아이디가 일치합니다.");
		} else {
			System.out.println("아이디가 일치하지 않습니다.");
		}
		
		// =====================================================================
		
		// 2. jumin에 대한 성별 판별 문제
		String jumin = "901010-1234567";
		switch (jumin.split("-")[1].charAt(0)) {
		case '1': case '3': System.out.println("남성입니다."); break;
		case '2': case '4': System.out.println("여성입니다."); break;
		case '5': case '6': System.out.println("외국인입니다."); break;
		}
		
		// =====================================================================
		
		// 3. company에 대한 문자열 추출 문제
		String company = "아이티윌 부산 교육센터";
		System.out.println(company.split(" ")[1]);
		
	}

}
