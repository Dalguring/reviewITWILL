package ex10_14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ex14 {

	public static void main(String[] args) {
		List<Book> bookList = new ArrayList<Book>();
		
		bookList.add(new Book("자바", 25000));
		bookList.add(new Book("파이썬", 15000));
		bookList.add(new Book("안드로이드", 30000));
		bookList.add(new Book("자바스크립트", 10000));
		bookList.add(new Book("JSP", 20000));
		bookList.add(new Book("SPRING", 34000));
		
		int total = bookList.stream().mapToInt(b -> b.getPrice()).sum();
		System.out.println(total);
		System.out.println("----------------------------------------------------");
		bookList.stream().filter(b -> b.getPrice() >= 20000)
						 .sorted((b1, b2) -> b1.getPrice() - b2.getPrice()) // 양수면 오름차순 음수면 내림차순
						 .forEach(b -> System.out.println(b));
		
		
	}

}

class Book {
	private String name;
	private int price;
	
	public Book(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", price=" + price + "]";
	}

	
	
	
	
}