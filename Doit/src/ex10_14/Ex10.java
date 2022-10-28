package ex10_14;

public class Ex10 {

	public static void main(String[] args) throws Exception {
		System.out.println("정렬 방식을 선택하세요.");
		System.out.println("B : BubbleSort");
		System.out.println("H : HeapSort");
		System.out.println("Q : QuickSort");
		
		int ch = System.in.read();
		Sort sort = null;
		
		if(ch == 'B' || ch == 'b') {
			sort = new BubbleSort();
		} else if(ch == 'H' || ch == 'h') {
			sort = new HeapSort();
		} else if(ch == 'Q' || ch == 'q') {
			sort = new QuickSort();
		} else {
			System.out.println("지원되지 않는 기능입니다.");
			return;
		}
		
		int[] arr = new int[10];
		sort.ascending(arr);
		sort.descending(arr);
		sort.description();
		
		
	}

}

interface Sort {
	public default void ascending(int[] arr) {
		System.out.println(this.getClass().getSimpleName() + " ascending");
	};
	public default void descending(int[] arr) {
		System.out.println(this.getClass().getSimpleName() + " descending");
	};
	public default void description() {
		System.out.println("숫자를 정렬하는 알고리즘입니다.");
		System.out.println(this.getClass().getSimpleName()+"입니다.");
	};
}
class BubbleSort implements Sort {

}
class HeapSort implements Sort {

}
class QuickSort implements Sort {

}