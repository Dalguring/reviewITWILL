package event_handling;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class Ex1 {
	
	public Ex1() {
		showFrame();
	}
	
	public void showFrame() {
		JFrame f = new JFrame("이벤트 처리 - 1");
		f.setBounds(600, 400, 300, 300);
		
		MyWindowListener listener = new MyWindowListener();
		f.addWindowListener(listener);
		
		f.setVisible(true);
		
		
	}
	
	
	public static void main(String[] args) {
		new Ex1();
		
	}

}

// 이벤트 처리 1단계
// 이벤트 처리를 위해 리스너 인터페이스를 구현하는 핸들러 클래스를 별도로 정의
class MyWindowListener implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
		// 맨 처음 프로그램이 실행될 때 프레임이 생성되어 표시되면 호출되는 메서드 (1회)
		System.out.println("windowOpened");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// 맨 마지막 프로그램이 종료될 때 닫기 버튼을 클릭하면 호출되는 메서드
		System.out.println("windowClosing");
		System.exit(0); // 프로그램 종료 (0 : 정상 종료, 0이외의 값 : 비정상 종료)
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// 창이 닫히고 난 후에 호출되는 메서드
		System.out.println("windowClosed");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// 프레임의 최소화 버튼 클릭 시 호출되는 메서드
		System.out.println("windowIconified");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// 프레임의 최소화가 해제될 때 호출되는 메서드
		System.out.println("windowDeiconified");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// 프레임이 사용자와 상호작용이 가능한 상태가 될 때 호출되는 메서드
		System.out.println("windowActivated");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// 프레임이 사용자와 상호작용이 불가능한 상태가 될 때 호출되는 메서드
		// ex) 다른 프로그램에 가려진 상태가 될 때
		System.out.println("windowDeactivated");
	}
	
}



