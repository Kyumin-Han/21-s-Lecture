package Lecture_210510;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

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
	public static final String driverClassName = "org.mariadb.jdbc.Driver";
	
	
	// Map��ü�� �ܾ��� �������� ���
	// key�� �ѱ۴ܾ�, value�� �����Ǵ� ���� �ܾ �����Ѵ�
	private Map<String, String> words = new HashMap<>();
	private static final String DIC_FILE_NAME = "dict.props";

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
		// DB���� ���ڵ带 �а�, �� ���ڵ带 �̿��ؼ� dict���� �����Ѵ�.
		
		buildDictionaryFromDB();
		
		buildDictionaryFromFile();
	}
	
	private void buildDictionaryFromDB() {
		
	}
	
	private void buildDictionaryFromFile() {
		// Properties��
		// key, value�� Ÿ���� ���� String, String���� ������ ������ ���̴�. 
		Properties props = new Properties();
//		props.put("���", "apple");
		
		
		// ���Ͽ��� �о props ��ü�� <key, value>���� ������ �� �ִ�.
		// ������ �������� FileReader�� �������ش�
		
//		FileReader fReader = new FileReader(DIC_FILE_NAME);
//		props.load(fReader);
		
		try(FileReader fReader = new FileReader(DIC_FILE_NAME)) {
			props.load(fReader);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		Set<Object> set = props.keySet();
		for(Object obj : set) {
			words.put((String)obj, (String)props.get(obj));
		}
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
			// DB�� <key, value>�� ���� �ϳ��� ���ڵ�� �����Ѵ�.
			
			String value = JOptionPane.showInputDialog(this, key, "�� ���� �Ǵ� ���� �ܾ �Է��ϼ���.");
			
			if(value.trim().length() == 0) return;
			words.put(key, value);
			addToDB(key, value);
			addWordToFile(key, value);
			JOptionPane.showMessageDialog(this, "[" + value + "]" + "���� �ܾ �߰��Ǿ����ϴ�.", key, JOptionPane.INFORMATION_MESSAGE);
		}
		
//		inputField.setText("");
		
	}
	
	private void addToDB(String key, String value) {
		// 1. Database ����: ���� JDBC Driver�� �ε� �ؾ� �Ѵ�
		// 2. select �� ����
		// 3. select ���� �������� ��ȯ�� ���ڵ带 �̿��� dict Map ��ü�� ����
		// 4. Database ���� ����.
	}
	
	private void addWordToFile(String key, String value) {
		try(FileWriter fWriter = new FileWriter(DIC_FILE_NAME, true)) {
			// FileWriter�� write�� ��� ����Ƿ� �������� �߰��� �͸� ���Ͽ� ���´�.
			fWriter.write(key + "=" + value + "\n");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
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