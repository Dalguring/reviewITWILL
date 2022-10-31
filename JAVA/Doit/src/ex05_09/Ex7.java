package ex05_09;

public class Ex7 {

	public static void main(String[] args) {
		int[] arr = new int[5];
		int total = 0;
		for(int i = 1; i <=10; i++) {
			if(i%2==1) continue;
			if(i%2==0) arr[i/2-1] = i;
		}
		//출력
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("=================================");
		//합
		for(int i = 0; i < arr.length; i++) total += arr[i];
		System.out.println(total);
		
		Dog[] dg = new Dog[5];
		dg[0] = new Dog("뽀삐", "시츄");
		dg[1] = new Dog("배추", "푸들");
		dg[2] = new Dog("토토", "말티즈");
		dg[3] = new Dog("누렁이", "진돗개");
		dg[4] = new Dog("코니", "비숑");
		
		for(Dog d : dg) {
			System.out.println(d.showDogInfo());
		}
		
	}
}

class Dog {
	private String name;
	private String type;
	public Dog(String name, String type) {
		this.name = name;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String showDogInfo() {
		return name + ", " + type;
	}
	
}
