package static_;

public class Ex3 {

	public static void main(String[] args) {
		
		Hero2 h = new Hero2();
		h.setJob("전사");
		// ----- 아이템 장착 전 ----------
		System.out.println(h.getLeft()); 
		
		
		// ----- 아이템 장착 후 ----------
		Sword sword1 = new Sword();
		sword1.demage = 100;
		
		h.setLeft(sword1);
		System.out.println(h.getLeft().demage); 
		
		Sword sword2 = new Sword();
		sword2.demage = 10000;
		h.setLeft(sword2);
		System.out.println(h.getLeft().demage); 
		
		
	}

}

class Hero2 {
	// 멤버변수
	private String job;
	private int hp;
	private int mp;
	private Sword left;
	private Shield right;
	
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Sword getLeft() {
		return left;
	}
	public void setLeft(Sword left) {
		this.left = left;
	}
	public Shield getRight() {
		return right;
	}
	public void setRight(Shield right) {
		this.right = right;
	}
	
	
	
	
}

// 칼
class Sword {
	int demage;
}

// 방패
class Shield {
	int armor;
}







