package component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ex1 {
	
	public Ex1() {
		showFrame();
	}
	
	public void showFrame() {
		JFrame f = new JFrame("Dialog 기초");
		f.setBounds(600, 400, 300, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		 * JOptionPane
		 * - 다이얼로그(팝업창)을 생성하는 객체
		 * - 사용자에게 알림 메시지를 팝업창으로 표시하거나
		 * 	 사용자의 선택을 받거나, 사용자로부터 데이터 입력받는 용도로 사용
		 * 
		 * 1) MessageDialog : 사용자에게 메시지를 표시하기 위한 다이얼로그
		 * 2) ConfirmDialog : 사용자로부터 선택을 받도록 버튼을 표시하는 다이얼로그
		 * 3) InputDialog 	: 사용자로부터 데이터를 입력받기 위한 다이얼로그
		 */
		
		// JPanel 객체 생성하여 CENTER 영역에 부착
		JPanel p = new JPanel();
		f.add(p);
		
		// JButton 객체 3개 (Message, Confirm, Input)생성
		JButton btnMessage = new JButton("Message");
		JButton btnConfirm = new JButton("Confirm");
		JButton btnInput = new JButton("Input");
		
		p.add(btnMessage); p.add(btnConfirm); p.add(btnInput);
		
		// 각 버튼 이벤트 처리 - 4단계
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == btnMessage) {
					// MessageDialog
					// 간략한 메세지를 표시할 경우 대상 객체와 메세지만 지정 가능
					// => 제목 : 메시지, 메세지종류 : INFORMATION_MESSAGE로 자동 지정됨
					JOptionPane.showMessageDialog(f, "다이얼로그 메세지", "다이얼로그 제목", JOptionPane.INFORMATION_MESSAGE);
				} else if(e.getSource() == btnConfirm) {
					// ConfirmDialog
//					JOptionPane.showConfirmDialog(f, "종료하시겠습니까?");
					
					int select = JOptionPane.showConfirmDialog(f, "종료하시겠습니까?", "종료", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
//					System.out.println(select);
					// 0(Yes, Ok), 1(No), 2(Cancel), -1(X)
					if(select == JOptionPane.YES_OPTION) {
						System.out.println("종료");
					} else if(select == JOptionPane.NO_OPTION) {
						System.out.println("종료 안함!");
					} else if(select == JOptionPane.CANCEL_OPTION) {
						System.out.println("종료 취소!");
					} else if(select == JOptionPane.CLOSED_OPTION) {
						System.out.println("Confirm창 닫음");
					}
					
				} else if(e.getSource() == btnInput) {
					// InputDialog
					String input = JOptionPane.showInputDialog(f, "검색할 이름 입력");
					System.out.println(input);
				}
			}
		};
		
		btnMessage.addActionListener(listener);
		btnConfirm.addActionListener(listener);
		btnInput.addActionListener(listener);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex1();
	}

}
