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

	// 단어 입력 받을 수 있는 JTextField
	// 검색 버튼, 추가 버튼
	// 단어장 구현을 위한 자료 구조로 Map 객체 생성
	
	private JTextField inputField = new JTextField(30);
	private JButton searchBtn = new JButton("검색");
	private JButton addBtn = new JButton("추가");
	public static final String driverClassName = "org.mariadb.jdbc.Driver";
	
	
	// Map객체를 단어장 구현으로 사용
	// key는 한글단어, value는 대응되는 영어 단어를 저장한다
	private Map<String, String> words = new HashMap<>();
	private static final String DIC_FILE_NAME = "dict.props";

	public SimpleDictionary() {
		// Panel의 기본 레이아웃은 FlowLayout
		this.add(inputField);
		this.add(searchBtn);
		this.add(addBtn);
		
		
		// 각 버튼에 글릭 이벤트가 발생 했을때 처리할 리스너를 지정
		searchBtn.addActionListener(this);
		addBtn.addActionListener(this);
		
		this.setPreferredSize(new Dimension(600, 50));
		
		// 파일에 key=value 형태로 저장된 엔트리들을 읽어서, words를 구성하기
		// DB에서 레코드를 읽고, 그 레코드를 이용해서 dict맵을 구성한다.
		
		buildDictionaryFromDB();
		
		buildDictionaryFromFile();
	}
	
	private void buildDictionaryFromDB() {
		
	}
	
	private void buildDictionaryFromFile() {
		// Properties는
		// key, value의 타입이 각각 String, String으로 고정된 일종의 맵이다. 
		Properties props = new Properties();
//		props.put("사과", "apple");
		
		
		// 파일에서 읽어서 props 객체의 <key, value>쌍을 구성할 수 있다.
		// 파일을 읽으려면 FileReader를 생성해준다
		
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
			// 입력된 단어를 추출하여
			// 그 단어를 key 값으로 가지는 대응된느 맵 엔트리가 있는지 검사 words.get(단어);
			// 그 단어에 대응되는 값이 있으면 JOptionPane.showMessageDialog() 메서드를 호출해서 대응되는 값을 보여준다
			// 값이 없으면 (null) JOptionPane.showMessageDialog() 메서드를 호출해서
			// 단어를 찾을 수 없습니다 라고 출력해준다
			// inputField를 빈 문자열로 설정한다
			
			System.out.println("[" + key + "]");
			String value = words.get(key);
			
			if(value != null) {
				// 대응되는 단어가 있는 경우
				JOptionPane.showMessageDialog(this, value, key, JOptionPane.INFORMATION_MESSAGE);
			} else {
				// 대응되는 단어가 없는 경우
				JOptionPane.showMessageDialog(this, "단어를 찾을 수 없습니다.", key, JOptionPane.ERROR_MESSAGE);
			}
		} else if(e.getSource() == addBtn) {
			// 입력된 단어를 추출
			// JOptionPane.showInputDialog() 메서드를 호출해서 추가할 영어 단어를 입력 받는다
			// words.put(입력 필드에 입력된 단어, inputDialog에 입력된 단어)
			// DB에 <key, value>의 쌍을 하나의 레코드로 저장한다.
			
			String value = JOptionPane.showInputDialog(this, key, "에 대응 되는 영어 단어를 입력하세요.");
			
			if(value.trim().length() == 0) return;
			words.put(key, value);
			addToDB(key, value);
			addWordToFile(key, value);
			JOptionPane.showMessageDialog(this, "[" + value + "]" + "영어 단어가 추가되었습니다.", key, JOptionPane.INFORMATION_MESSAGE);
		}
		
//		inputField.setText("");
		
	}
	
	private void addToDB(String key, String value) {
		// 1. Database 연결: 먼저 JDBC Driver를 로딩 해야 한다
		// 2. select 문 수행
		// 3. select 문의 수행으로 반환된 레코드를 이용해 dict Map 객체를 구성
		// 4. Database 연결 해제.
	}
	
	private void addWordToFile(String key, String value) {
		try(FileWriter fWriter = new FileWriter(DIC_FILE_NAME, true)) {
			// FileWriter의 write는 계속 덮어쓰므로 마지막에 추가된 것만 파일에 남는다.
			fWriter.write(key + "=" + value + "\n");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new SimpleDictionary());
		
		frame.setTitle("한영사전");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}
	
}