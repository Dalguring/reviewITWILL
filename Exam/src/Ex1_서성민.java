import java.util.Random;

public class Ex1_서성민 {

	public static void main(String[] args) {
		
		Random random = new Random();
		int pee = 50000;
		int age = random.nextInt(100)+1;
		
		if(age < 5 || age >= 65) {
			pee = (int)(pee*0.5);
			System.out.println("나이가 " + age + "세이므로 입장료는 " + pee +"원입니다.");
		} else if(age >= 5 && age <= 19) {
			pee = (int)(pee*0.7);
			System.out.println("나이가 " + age + "세이므로 입장료는 " + pee +"원입니다.");
		} else {
			System.out.println("나이가 " + age + "세이므로 입장료는 " + pee +"원입니다.");
		}
		
	}

}
