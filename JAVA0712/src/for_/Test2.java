package for_;

public class Test2 {

	public static void main(String[] args) {
		int a = 3, b = 9, sum=0; 
		for(int i = a; i<=b; i++) {
			if(i %3 ==0) {
				sum+=i;
			}
		}
		System.out.println(a + " ~ " + b + " 까지의 3의 배수의 합 : " + sum);
		System.out.println("=====================================");
		
//		for(int i = 1; i <= 100; i++)
//			if(i %10 == 3 || i %10 == 6 || i %10 == 9) {
//				System.out.print("짝 ");
//			} else {
//				System.out.print(i + " ");
//			}
//		System.out.println();
//		System.out.println("=====================================");
		for(int i2=1; i2<=100; i2++) {
			switch (i2%10) {
			case 3:
			case 6:
			case 9:
				System.out.println("짝 ");
				break;
			default:
				System.out.println(i2 + " ");
			}
		}
//			System.out.println();
//			int n = 1777, count = 0; 
//				while(n>0) {
//					if(n %10 == 7) {
//					count += 1;
//					} 
//					n /=10;
//				}
//			System.out.println(count);
//			int n = 657895417;
//			int count = 0;
//			while(n > 0) {
//				if(n%10 == 7) {
//					count++;
//				}
//				n/=10;
//			}
//			System.out.println(count);
			System.out.println("============================");
//			int count = 0;
//			for(int n = 1777; n !=0; n /= 10) {
//				if(n % 10 == 7) {
//					count++;
//				}
//			}
//			System.out.println(count);
			
		
		
		
	}
}

