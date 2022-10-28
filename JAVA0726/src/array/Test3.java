package array;

public class Test3 {

	public static void main(String[] args) {
		//			  2     4      6
		//출 	70 80 60 20 30 50 10 88 77 89
		//		  	 ㅣㅣ    ㅣㅣ   ㅣㅣ
		//		70 60 40 50 55 65 23 44 37 88 도
		int[] a = {70, 80, 60, 20, 30, 50, 10, 88, 77, 89};
		int[] b = {70, 60, 40, 50, 55, 65, 23, 44, 37, 88};
		int[] bridge = {2, 4, 6};
		int[] total = new int[bridge.length];
		for(int k = 0; k < bridge.length; k++) {
			for(int i = 0; i <= bridge[k]; i++) {
				total[k] += a[i];
			}
			for(int j = bridge[k]; j < b.length; j++) {
				total[k] += b[j];
			}
			System.out.println(total[k]);
		}
		System.out.println("=====================================");
//		System.out.println(bridge[0]);
//		System.out.println(bridge[1]);
//		System.out.println(bridge[2]);
		int min = 700;
		int minIndex = 0;
		for(int i=0; i < bridge.length-1; i++) {
			if(total[i]> total[i+1]) {
				min = total[i+1];
				minIndex = i+1;
			}
		}
		System.out.println("최소 경로 다리 번호 : " + bridge[minIndex] + " \n최소값 : " + min);
		
	}
}
