package operator;

public class Ex1 {

	public static void main(String[] args) {
		int x1 = 5;
		int y1 = ++x1;
		System.out.println("x1: " + x1 + ", y1: " + y1); //y1=x1+1이랑 다름. 이는 x1자체 값을 바꾼 것임
		
		int x2 = 5;
		int y2 = x2++;
		System.out.println("x2: " + x2 + ", y2: " + y2); 
		
		int x = 10, y = 5;
		int z = ++x + y--;
		System.out.println(x + ", " + y  + ", " + z);
		System.out.println("===========================");
		
		int i = 3;
		i++;
		System.out.println(i);
		++i;
		System.out.println(i);
		
		System.out.println(++i);
		System.out.println(i++);
		System.out.println(i);
		System.out.println("===========================");

		int dan = 2;
		int index = 1; 
		System.out.println("< 2단 >");
		System.out.println(dan + " * " + index + " = " + dan*index);
		System.out.println(dan + " * " + ++index + " = " + dan*index);
		System.out.println(dan + " * " + ++index + " = " + dan*index);
		System.out.println(dan + " * " + ++index + " = " + dan*index);
		System.out.println(dan + " * " + ++index + " = " + dan*index);
		System.out.println(dan + " * " + ++index + " = " + dan*index);
		System.out.println(dan + " * " + ++index + " = " + dan*index);
		System.out.println(dan + " * " + ++index + " = " + dan*index);
		System.out.println(dan + " * " + ++index + " = " + dan*index);

		
		
		
	}

}
