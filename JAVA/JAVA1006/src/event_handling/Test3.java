package event_handling;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test3 {

	public Test3() {
		showFrame();
	}
	
	public void showFrame() {
		JFrame f = new JFrame("이벤트 처리 - 3");
		f.setBounds(600, 400, 300, 300);
		JButton btn = new JButton("버튼"); 
		f.add(btn);
		MyMemberActionListener actionListener = new MyMemberActionListener();
		btn.addActionListener(actionListener);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new Test3();
	}
	
	class MyMemberActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("버튼 클릭됨");
		}
		
	}
	
	
}
