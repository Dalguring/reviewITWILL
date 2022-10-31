package event_handling;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test1 {
	
	public Test1() {
		showFrame();
	}
	
	public void showFrame() {
		JFrame f = new JFrame("이벤트 처리 - 4");
		f.setBounds(600, 400, 300, 300);
		JButton btn = new JButton("버튼");
		f.add(btn);
		btn.addActionListener(listener);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	ActionListener listener = e -> System.out.println("버튼 클릭됨!");
	
	public static void main(String[] args) {
		new Test1();
	}

}
