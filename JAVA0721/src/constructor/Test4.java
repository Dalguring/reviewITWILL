package constructor;

class Account3 {
	String accountNo;
	String ownerName;
	int balance;
	
	public Account3() {
		this("111-111", "A", 1111);
	}

	public Account3(String accountNo) {
		this(accountNo, "B", 2222);
	}
	//무엇을 호출할 지 식별이 불가능해서 오류발생
//	public Account3(String ownerName) {
//		this("111-111", ownerName, 100000);
//	}
	
	public Account3(String accountNo, String ownerName) {
		this(accountNo, ownerName, 3333);
	}

	public Account3(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	public void print() {
		System.out.println("계좌번호 : " + accountNo);
		System.out.println("예금주명 : " + ownerName);
		System.out.println("계좌잔고 : " + balance);
	}
}

public class Test4 {

	public static void main(String[] args) {
		
		Account3 acc1 = new Account3();
		acc1.print();
		System.out.println("===============================");
		Account3 acc2 = new Account3("222-222");
		acc2.print();
		System.out.println("===============================");
		Account3 acc3 = new Account3("333-333", "C");
		acc3.print();
		System.out.println("===============================");
		Account3 acc4 = new Account3("444-444", "D", 4444);
		acc4.print();
		
	}

}
