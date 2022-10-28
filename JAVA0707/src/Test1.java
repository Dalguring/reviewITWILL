
public class Test1 {

	public static void main(String[] args) {
		char ch = '%';
		String str = (ch >= 65 && ch <= 90)	 ? "대문자" :
					 (ch >= 97 && ch <= 122) ? "소문자" : "기타문자";
		System.out.println(str);
		System.out.println("========================================");
		int price = 30000, age = 25;
		
		double result = (age <= 5) 				? price*0.3	: 
					 	(age >= 6 && age <= 64) ? price 	: price*0.5;
		System.out.println(result);
		System.out.println("========================================");
		
		
		
		
	}

}
