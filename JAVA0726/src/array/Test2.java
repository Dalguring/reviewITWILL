package array;

public class Test2 {

	public static void main(String[] args) {
		String[] sub = {"\t","국어\t", "영어\t", "수학\t"};
		String[] names = new String[] {"홍길동", "이순신", "강감찬", "김태희", "전지현"};
		int[][] score = {
				{80, 80, 80},
				{90, 80, 77},
				{60, 50, 60},
				{100, 100, 100},
				{50, 80, 100}
		};
		//과목 명 출력
		for(int i = 0; i < sub.length; i++) {
			System.out.print(sub[i]);
		}
		System.out.println();
		// 이름, 점수 출력
		for(int i = 0; i < names.length; i++) {
			System.out.print(names[i]);
			for(int j = 0; j < score[i].length; j++) {
				System.out.print("\t" + score[i][j]);
			}
			System.out.println();
		}
		System.out.println("-------------------------------------");
		System.out.println("< 학생별 총점>");
		
		int[] total = new int[names.length];

		for(int i = 0; i < total.length; i++) {
			for(int j = 0; j < score[i].length; j++) {
				total[i] += score[i][j]; 
			}
		}
		
		for(int i = 0; i < names.length; i++) {
			System.out.println(names[i] + " : " + total[i] + "점");
		}
		
	}

}
