package Lecture_210325;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileError2 {

	public static void main(String[] args) {
		writeList();

	}
	
	public static void writeList() {
		PrintWriter out = null;
		
		// close�޼ҵ尡 �ҷ����� �ϴ� ��ü�� try���� ��ȣ�� �־��ָ� �ȴ�
		// finally���� ��� ���ܿ� ��� ���� close �޼ҵ带 �θ� �� �ִ�
		// AutoCloseable �������̽��� �����ؾ� �Ѵ�
		// �� ��ü�� try with resources ���� ��� �� �� �ִ�
		try (FileWriter fw = new FileWriter("out3.txt");) {
			out = new PrintWriter(fw);
			out.println("hello3");
			System.out.println("�۾�����...");
			// out.close();
		} catch(IOException e) {
			System.out.println("catch:" + e.getMessage());
		} 
		
	}
}
