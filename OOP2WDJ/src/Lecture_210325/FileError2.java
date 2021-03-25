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
		
		// close메소드가 불려져야 하는 객체를 try뒤의 괄호에 넣어주면 된다
		// finally절이 없어도 예외에 상관 없이 close 메소드를 부를 수 있다
		// AutoCloseable 인터페이스를 구현해야 한다
		// 그 객체는 try with resources 절에 사용 될 수 있다
		try (FileWriter fw = new FileWriter("out3.txt");) {
			out = new PrintWriter(fw);
			out.println("hello3");
			System.out.println("작업종료...");
			// out.close();
		} catch(IOException e) {
			System.out.println("catch:" + e.getMessage());
		} 
		
	}
}
