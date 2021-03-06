package Lecture_210315;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextConverter extends JFrame implements ActionListener{

	private JButton convertBtn;
	private JButton cancelBtn;
	private JTextArea textIn;
	private JTextArea textOut;
	
	public TextConverter() {
		this.setTitle("텍스트 변환");
		
		textIn = new JTextArea(10, 14);
		textOut = new JTextArea(10, 14);
		textIn.setLineWrap(true);
		textOut.setLineWrap(true);
		textOut.setEditable(false);
		
		JPanel textAreaPanel = new JPanel(new GridLayout(1, 2, 20, 20));
		textAreaPanel.add(textIn);
		textAreaPanel.add(textOut);
		
		convertBtn = new JButton("변환");
		cancelBtn = new JButton("취소");
		convertBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		
		
		JPanel btnPanel = new JPanel();
		btnPanel.add(convertBtn);
		btnPanel.add(cancelBtn);
		
		JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
		mainPanel.add(textAreaPanel, BorderLayout.CENTER);
		mainPanel.add(btnPanel, BorderLayout.SOUTH);
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		this.add(mainPanel);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new TextConverter();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 변환 버튼이 클릭되었다면
		// 좌측 textArea (textIn)의 text를 읽어서 영어로 변환하고
		// 이 결과를 우측 textArea (textOut)에 append한다
		// 취소 버튼이 클릭 되었다면 우측 (textOut)을 빈 문자열로 설정
		
		if(e.getSource() == convertBtn)
		{
			String str = textIn.getText();
			String result = toEnglish(str);
			textOut.setText(result);
//			String str = toEnglish(textIn.getText());
		}
		else
		{
			textOut.setText("");
		}
		
	}
	
	private String toEnglish(String korean) {
		// korean 문자열을 영어로 변환해서 반환한다
		
		String result = null;
		//replace 메소드는 바뀌는 값에 대한 주소 값을 리턴한다
		result = korean.replace("텍스트", "text");
		result = result.replace("영어", "english");
		return result;
	}

	
}
