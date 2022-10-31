package ex05_09;

public class Ex5 {

	public static void main(String[] args) {
		MyDate date1 = new MyDate(30, 2, 2000);
		System.out.println(date1.isValid());
		MyDate date2 = new MyDate(2, 10, 2000);
		System.out.println(date2.isValid());
		MyDate date3 = new MyDate(31, 9, 2000);
		System.out.println(date3.isValid());
		MyDate date4 = new MyDate(31, 10, 2000);
		System.out.println(date4.isValid());
		MyDate date5 = new MyDate(-10, -5, 2000);
//		System.out.println(date5.getDay());
//		System.out.println(date5.getMonth());
//		System.out.println(date5.getYear());
	}
}
class MyDate {
	private int day;
	private int month;
	private int year;
	public boolean isValid() {
//		if(month==1 || month==3 || month==5 ||month==7 ||month==8 ||month==10 ||month==12) {
//			if(day<=31) return true;
//			else 		return false;
//		} else if(month==2){
//			if(day<=28) return true;
//			else 		return false;
//		} else {
//			if(day<=30) return true;
//			else 		return false;
//		}
		boolean result = true;
		if(day<1) {
			return false;
		}
		switch (month) {
		case 1:case 3:case 5:case 7:case 8:case 10:case 12:
			if(day>31) result = false;
			break;
		case 4:case 6:case 9:case 11:
			if(day>30) result = false;
			break;
		case 2:
			if(day>28) result = false;
			break;
		}
		return result;
	}
	public MyDate(int day, int month, int year) {
//		if(day <= 0) day = 1;
//		if(month <= 0) month = 1;
//		if(year <= 0) year = 1;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public int getDay() {
		return day;
	}
//	public void setDay(int day) {
//		this.day = day;
//	}
	public int getMonth() {
		return month;
	}
//	public void setMonth(int month) {
//		this.month = month;
//	}
	public int getYear() {
		return year;
	}
//	public void setYear(int year) {
//		this.year = year;
//	}
	
}