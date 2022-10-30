package array;

public class Test2 {

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 2, 1};
		for(int i = 0; i < arr.length; i++) {
			
			int target = arr[i];
			String result = i+1 + ": ";
			for(int j = 0; j < arr.length; j++) {
				int num = arr[j];				
				if(i==j) continue; 
				if(target < num) 		result += "< ";
				else if(target > num)	result += "> ";
				else 					result += "= ";
				
			}
			System.out.println(result);
		}
		
	}

}
