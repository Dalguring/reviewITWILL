package array;

public class Ex2 {

	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 35};
		int[] arr2 = new int[arr.length + 1];
		for(int i = 0; i < arr.length; i++) {
			arr2[i] = arr[i];
		}
		arr2[arr2.length - 1] = 40;
		for(int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		System.out.println("=========================================");
		int aNum = 10;
		int bNum = 20;
		bNum = aNum;
		
		int[] aArr = {1, 2, 3};
		int[] bArr = {4, 5, 6};
		int[] cArr = {7, 8, 9};
		
		aArr = bArr;
		
		bArr = cArr;
		
	}

}
