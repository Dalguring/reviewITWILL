package method;

class Calculator2 {
	
	public void calc(char opr, int...nums) {
		int total=nums[0];
		System.out.print(nums[0]);
		if(opr == '+') {
			for(int i = 1; i < nums.length-1; i++) {
				System.out.print(" + " + nums[i]);
				total+=nums[i];
			}
			for(int i = nums.length-1; i < nums.length; i++) {
				System.out.print(" + " + nums[i] + " = ");
				total+=nums[i];
				System.out.print(total);
			}
		} else if(opr == '-') {
			for(int i = 1; i < nums.length-1; i++) {
				System.out.print(" - " + nums[i]);
				total-=nums[i];
			}
			for(int i = nums.length-1; i < nums.length; i++) {
				System.out.print(" - " + nums[i] + " = ");
				total-=nums[i];
				System.out.print(total);
			} 
		} else if(opr == '*') {
			for(int i = 1; i < nums.length-1; i++) {
				System.out.print(" * " + nums[i]);
				total*=nums[i];
			}
			for(int i = nums.length-1; i < nums.length; i++) {
				System.out.print(" * " + nums[i] + " = ");
				total*=nums[i];
				System.out.print(total);
			} 
		} else if(opr == '/') {
			for(int i = 1; i < nums.length-1; i++) {
				System.out.print(" / " + nums[i]);
				total-=nums[i];
			}
			for(int i = nums.length-1; i < nums.length; i++) {
				System.out.print(" / " + nums[i] + " = ");
				total/=nums[i];
				System.out.print(total);
			} 
		}
	
	}
}


public class Test4 {

	public static void main(String[] args) {
		
		Calculator2 cal = new Calculator2();
		cal.calc('+', 120, 2, 3, 4, 5);
		
		
		
		
	}

}
