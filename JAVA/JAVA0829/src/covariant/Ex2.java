package covariant;

public class Ex2 {

	public static void main(String[] args) {
		
		Customer cus = new Customer();
		VipCustomer vip = new VipCustomer();
		
		Employee emp = new Employee();
		VipEmployee vipEmp = new VipEmployee();
		
		//1. 공변 리턴 타입 적용 X
		cus.setAcc(emp.getAccount()); // 일반 고객이 일반계좌를 개설
//		vipEmp.setItwillBank(vipEmp.getAccount());
		// => vip 고객의 멤버변수는 itwillBank 타입이므로
		//	  vip 직원에게 개설한 계좌를 다운캐스팅 하여 전달해야한다!
		vip.setItwillBank((ItwillBank)vipEmp.getAccount());
		// => 하지만 이런 서브클래스가 굉장히 많다면?
		//	  매번 instanceof로 객체 확인 후 다운캐스팅을 통해 사용해야한다.
		
		//2. 공변 리턴타입 적용 됨
		vip.setItwillBank(vipEmp.getAccount());
		// 다운캐스팅 할 필요없이 바로 적용 가능!
		
	}

}

class Customer {
	private Account acc;
	private int money;
	String name;
	
	public Account getAcc() {
		return acc;
	}
	public void setAcc(Account acc) {
		this.acc = acc;
	}
}

class VipCustomer extends Customer {
	private int grade;
	private ItwillBank itwillBank;
	
	public ItwillBank getItwillBank() {
		return itwillBank;
	}
	public void setItwillBank(ItwillBank itwillBank) {
		this.itwillBank = itwillBank;
	}
	
}

// 일반 직원
class Employee {
	public Account getAccount() {
		return new Account();
	}
}

// Vip 직원
class VipEmployee extends Employee{
	//1. 공변 리턴 타입 적용 X
//	@Override
//	public Account getAccount() {
//		return new ItwillBank();
//	}
	
	//2. 공변 리턴타입 적용 됨
	@Override
	public ItwillBank getAccount() {
		return new ItwillBank();
	}
}


class Account {
	
}

class ItwillBank extends Account {
	
}





