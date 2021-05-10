package Lecture_210506;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Properties;

public class Test {
	public static void main(String[] args) {
		// ���Ͽ� Ű�� ���� �о�ͼ� �˻����ش�.
		Properties props = new Properties();
		try(FileReader read = new FileReader("dict.props")) {
			props.load(read);	
		} catch(Exception err) {
			System.out.println(err.getMessage());
		}
		
		System.out.println(props.get("���"));

		FileOutputStream out = null;
		props.put("���", "rose");
		try { 
			out = new FileOutputStream("dict.props");
			props.store(out, "���� �ѿ�����");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				out.close();
			} catch(Exception ignore) {}
		}
		
		System.out.println(props.get("���"));
	}
}
