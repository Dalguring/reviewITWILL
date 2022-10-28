package component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex2 {
	
	public Ex2() {
		showFrame();
	}
	
	public void showFrame() {
		JFrame f = new JFrame("CheckBox 연습");
		f.setBounds(600, 400, 300, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 패널을 하나 생성한 후 프레임에 부착
		JPanel p = new JPanel();
		f.add(p);
		
		JCheckBox cb1 = new JCheckBox("Java");
		JCheckBox cb2 = new JCheckBox("JSP");
		JCheckBox cb3 = new JCheckBox("Android");
		JCheckBox cb4 = new JCheckBox("전체선택");
		p.add(cb1); p.add(cb2); p.add(cb3); p.add(cb4);
		
		/*
		 * 전체선택 체크박스에 대한 이벤트 처리
		 * => 전체선택 체크 시 ch1, ch2, ch3를 모두 체크하고 ch4에 텍스트 "전체선택 해제"로 변경
		 * 	  전체선택 체크 해제 시 ch1, ch2, ch3를 모두 체크해제하고 ch4에 텍스트 "전체선택"으로 변경
		 */
		cb4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean result = cb4.isSelected();
				JCheckBox[] cbs = {cb1, cb2, cb3};
				for(JCheckBox cb : cbs) {
					cb.setSelected(result);
				}
				cb4.setText(result ? "전체선택해제" : "전체선택");
			}
		});
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex2();
	}

}
