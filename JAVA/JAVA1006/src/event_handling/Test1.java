package event_handling;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test1 {
	public Test1() {
		showFrame();
	}
	
	public void showFrame() {
		JFrame f = new JFrame("이벤트 처리연습 - 1");
		JButton btn = new JButton("버튼");
		f.setSize(300, 200);
		f.add(btn);
		MyActionListener listener = new MyActionListener();
		btn.addActionListener(listener);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		JFrame f2 = new JFrame("버튼 연습");
		f2.setBounds(300, 300, 300, 300);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btn2 = new JButton("버튼2");
		f2.add(btn2);
		
		btn2.addActionListener(listener);
		
		f2.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		new Test1();
		
	}

}

class MyActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼 클릭됨");
	}
	
}
