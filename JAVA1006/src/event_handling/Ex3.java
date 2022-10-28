package event_handling;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Ex3 {
	public Ex3() {
		showFrame();
	}
	
	public void showFrame() {
		JFrame f = new JFrame("이벤트 처리 - 3");
		f.setBounds(600, 400, 300, 300);
		/*
		 * 이벤트 처리 3단계 (내부클래스 형태로 정의)
		 * - 이벤트 리스너 구현체는 보통 GUI 클래스에서만 사용됨(= 전용클래스)
		 * 	 따라서, 별도의 클래스로 외부에 정의하기 보다는 내부클래스 형태로 정의해서 사용
		 * - GUI 클래스 내부에 핸들러 클래스를 정의하면 내부클래스가 됨
		 * - 외부에 정의하는 방법과 클래스 모양은 동일하나 클래스 정의 위치만 달라짐
		 * 
		 * [ 위치에 따른 차이점 ]
		 * 1) 멤버 레벨에 정의하는 멤버 내부클래스 (인스턴스 내부 클래스)
		 * 	  => 멤버 변수의 성격과 동일한 클래스가 됨 (= 접근 범위가 멤버변수와 동일)
		 * 2) 메서드 내부에 정의하는 로컬 내부클래스 
		 * 	  => 로컬 변수의 성격과 동일한 클래스가 됨 (= 접근 범위가 로컬변수와 동일)
		 * 
		 */
		// 멤버 내부클래스 형태를 연결
//		MyMemberWindowAdapter adapter = new MyMemberWindowAdapter();
//		f.addWindowListener(adapter);
		
		// 로컬 내부 클래스 형태로 정의
		// => 로컬 변수와 동일한 범위에서만 접근 가능
		
		class MyLocalWindowAdapter extends WindowAdapter {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("windowClosing");
				System.exit(0);
			}
		}
		MyLocalWindowAdapter adapter = new MyLocalWindowAdapter();
		f.addWindowListener(adapter);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex3();
	}
	
	// 멤버 내부클래스 형태로 정의
	class MyMemberWindowAdapter extends WindowAdapter {
		
		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("windowClosing");
			System.exit(0);
		}
	}
	
	
}
