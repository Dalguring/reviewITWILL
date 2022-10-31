package event_handling;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test2 {
	
	public Test2() {
		showFrame();
	}
	
	public void showFrame() {
		
		JFrame f = new JFrame("이벤트 처리 - 5");
		f.setBounds(600, 400, 300, 300);
		JButton btn = new JButton("버튼");
		f.add(btn);
		btn.addActionListener(e -> System.out.println("버튼 클릭됨"));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test2();
	}

}
