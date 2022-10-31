package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex2 {
	
	public Ex2() {
		showFrame();
	}
	
	public void showFrame() {
		
		JFrame f = new JFrame("JFrame Ex2");
		f.setBounds(600, 400, 300, 300);
		
		/*
		 * JButton 클래스
		 * - 버튼 기능(클릭)을 수행하는 컴포넌트
		 * - 생성자 파라미터에 문자열 전달 시 버튼의 텍스트 설정 가능
		 * - 단독으로 사용은 불가능하며, 컨데이너(프레임 또는 패널 등)에 부착해서 사용 필요
		 * 	 => 해당 컨테이너의 add() 메서드 호출하여 추가(부착)
		 */
		JButton btn = new JButton("버튼");
		f.add(btn);
		
//		btn.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("버튼클릭!");
//				
//			}
//		});
		
		btn.addActionListener(e -> System.out.println("버튼클릭!"));
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex2();
		
	}

}
