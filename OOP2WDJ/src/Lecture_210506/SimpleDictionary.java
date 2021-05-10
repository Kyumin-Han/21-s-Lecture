package Lecture_210506;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleDictionary extends JPanel implements ActionListener {

	// �ܾ� �Է� ���� �� �ִ� JTextField
	// �˻� ��ư, �߰� ��ư
	// �ܾ��� ������ ���� �ڷ� ������ Map ��ü ����
	
	private JTextField inputField = new JTextField(30);
	private JButton searchBtn = new JButton("�˻�");
	private JButton addBtn = new JButton("�߰�");
	
	
	// Map��ü�� �ܾ��� �������� ���
	// key�� �ѱ۴ܾ�, value�� �����Ǵ� ���� �ܾ �����Ѵ�
	private Map<String, String> words = new HashMap<>();

	public SimpleDictionary() {
		// Panel�� �⺻ ���̾ƿ��� FlowLayout
		this.add(inputField);
		this.add(searchBtn);
		this.add(addBtn);
		
		// �� ��ư�� �۸� �̺�Ʈ�� �߻� ������ ó���� �����ʸ� ����
		searchBtn.addActionListener(this);
		addBtn.addActionListener(this);
		
		this.setPreferredSize(new Dimension(600, 50));
		
		// ���Ͽ� key=value ���·� ����� ��Ʈ������ �о, words�� �����ϱ�
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String key = inputField.getText();
		if(key.trim().length() == 0) return;
		
		if(e.getSource() == searchBtn) {
			// �Էµ� �ܾ �����Ͽ�
			// �� �ܾ key ������ ������ �����ȴ� �� ��Ʈ���� �ִ��� �˻� words.get(�ܾ�);
			// �� �ܾ �����Ǵ� ���� ������ JOptionPane.showMessageDialog() �޼��带 ȣ���ؼ� �����Ǵ� ���� �����ش�
			// ���� ������ (null) JOptionPane.showMessageDialog() �޼��带 ȣ���ؼ�
			// �ܾ ã�� �� �����ϴ� ��� ������ش�
			// inputField�� �� ���ڿ��� �����Ѵ�
			
			System.out.println("[" + key + "]");
			String value = words.get(key);
			
			if(value != null) {
				// �����Ǵ� �ܾ �ִ� ���
				JOptionPane.showMessageDialog(this, value, key, JOptionPane.INFORMATION_MESSAGE);
			} else {
				// �����Ǵ� �ܾ ���� ���
				JOptionPane.showMessageDialog(this, "�ܾ ã�� �� �����ϴ�.", key, JOptionPane.ERROR_MESSAGE);
			}
		} else if(e.getSource() == addBtn) {
			// �Էµ� �ܾ ����
			// JOptionPane.showInputDialog() �޼��带 ȣ���ؼ� �߰��� ���� �ܾ �Է� �޴´�
			// words.put(�Է� �ʵ忡 �Էµ� �ܾ�, inputDialog�� �Էµ� �ܾ�)
			
			String value = JOptionPane.showInputDialog(this, key, "�� ���� �Ǵ� ���� �ܾ �Է��ϼ���.");
			
			if(value.trim().length() == 0) return;
			words.put(key, value);
			JOptionPane.showMessageDialog(this, "[" + value + "]" + "���� �ܾ �߰��Ǿ����ϴ�.", key, JOptionPane.INFORMATION_MESSAGE);
		}
		
		inputField.setText("");
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new SimpleDictionary());
		
		frame.setTitle("�ѿ�����");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}
	
}