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
		this.setTitle("�ؽ�Ʈ ��ȯ");
		
		textIn = new JTextArea(10, 14);
		textOut = new JTextArea(10, 14);
		textIn.setLineWrap(true);
		textOut.setLineWrap(true);
		textOut.setEditable(false);
		
		JPanel textAreaPanel = new JPanel(new GridLayout(1, 2, 20, 20));
		textAreaPanel.add(textIn);
		textAreaPanel.add(textOut);
		
		convertBtn = new JButton("��ȯ");
		cancelBtn = new JButton("���");
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
		// ��ȯ ��ư�� Ŭ���Ǿ��ٸ�
		// ���� textArea (textIn)�� text�� �о ����� ��ȯ�ϰ�
		// �� ����� ���� textArea (textOut)�� append�Ѵ�
		// ��� ��ư�� Ŭ�� �Ǿ��ٸ� ���� (textOut)�� �� ���ڿ��� ����
		
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
		// korean ���ڿ��� ����� ��ȯ�ؼ� ��ȯ�Ѵ�
		
		String result = null;
		//replace �޼ҵ�� �ٲ�� ���� ���� �ּ� ���� �����Ѵ�
		result = korean.replace("�ؽ�Ʈ", "text");
		result = result.replace("����", "english");
		return result;
	}

	
}
