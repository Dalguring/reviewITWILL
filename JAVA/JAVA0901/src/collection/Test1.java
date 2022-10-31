package collection;

import java.util.*;

public class Test1 {

	public static void main(String[] args) {
		
		int winCount = 0;
		while(true) {
			Set myLotto = new TreeSet();
			Random r = new Random();
			
			while(myLotto.size() < 6) {
				myLotto.add(r.nextInt(45)+1);
			}
			
			System.out.println("나의 로또 번호 : " + myLotto);
			
			Set thisWeekLotto = new TreeSet();
			
			while(thisWeekLotto.size() < 6) {
				thisWeekLotto.add(r.nextInt(45)+1);
			}
			
			System.out.println("1등 당첨 번호 : " + thisWeekLotto);
			
			int count=0;
			
//			for(Object o : thisWeekLotto) {
//				for(Object o1 : myLotto) {
//					if(o == o1) count++;
//				}
//			}
			
			for(Object o : thisWeekLotto) {
				if(myLotto.contains(o)) count++;
			}
			
			System.out.println("일치 갯수 : " + count + "개");
			
			switch (count) {
			case 0: case 1: case 2: System.out.println("꽝"); 	break;
			case 3: 				System.out.println("4등"); 	break;
			case 4: 				System.out.println("3등"); 	break;
			case 5: 				System.out.println("2등"); 	break;
			case 6: 				System.out.println("1등"); 	break;
			}
			
			winCount ++;
			if(count == 6) {
				break;
			}
			
			System.out.println("-------------------------------");
		}
		
		System.out.println("1등 당첨까지 걸린 추첨 횟수 : " + winCount);
		
		
	}

}
