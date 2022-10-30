package oop;

class Account {
	String accountNo;
	String ownerName;
	String balance;
}
public class Test1 {
	public static void main(String[] args) {
		Account sm = new Account();
		sm.accountNo = "114002-04-258890";
		sm.ownerName = "서성민";
		sm.balance = "6,841,354원";
		System.out.println(sm.accountNo);
		System.out.println(sm.ownerName);
		System.out.println(sm.balance);
		
		
	}

}

