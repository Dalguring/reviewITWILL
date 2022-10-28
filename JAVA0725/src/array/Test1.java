package array;

public class Test1 {

	public static void main(String[] args) {
		int[] score = new int[] {80, 100, 50, 90, 77};
		int total = 0; double aver = 0;
		for(int i = 0; i < score.length; i++) {
			total += score[i];
		}
		System.out.println("총점 : " + total + "점");
		aver = (double)total/score.length;
		System.out.println("평균 : " + aver + "점");
		
		String[] name = new String[] {"이순신", "홍길동", "김강헌", "김태희", "전지현"};
		for(int i = 0; i < name.length; i++) {
			name[i] +=" " + score[i];
			System.out.println(name[i]);
		}
		
		int i = 0, max = 0 ,min = 100;
//		while(i < name.length) {
//			if(max < score[i]) {
//				max = score[i];
//			} 
//			if(min > score[i]) {
//				min = score[i];
//			}
//			i++;
//		}
		
		for(int num : score) {
			max = max < num ? num : max;
			min = min < num ? min : num;
		}
		
		System.out.println("최고점수 : " + max);
		System.out.println("최저점수 : " + min);
		System.out.println("========================================");
		String[] class1 = {"김윤진", "차동원", "소지섭"};
		for(int k = 0; k < class1.length; k++) {
			String name1 = class1[k];
			System.out.println(name1 + "이 상담받았습니다.");
		}
		
		for(String name1 : class1) {
			System.out.println(name1 + "이 상담받았습니다!");
		}
		
		
		
		
		
		
	}
}
