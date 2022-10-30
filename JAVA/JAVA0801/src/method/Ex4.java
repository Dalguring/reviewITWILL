package method;

public class Ex4 {

	public static void main(String[] args) {
		int dan = 2;
		int i = 3;
		System.out.printf("%d * %d = %d\n", dan, i, dan*i);
		System.out.printf("%d %d %d %d %d\n", 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println("==========================================");
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		ArrayArguments aa = new ArrayArguments();
		aa.print(arr);
		System.out.println("==========================================");
		VariableArguments va = new VariableArguments();
		va.print(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		va.print(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9);
		va.print(arr);
	}

}

class VariableArguments {
	public void print(int...nums) {
		System.out.println("print(int...nums)호출됨!");
		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		
	}
	
}

class ArrayArguments {
	
	public void print(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}

