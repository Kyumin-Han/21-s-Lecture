package Lecture_210325;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileError {

	public static void main(String[] args) {
			writeList();

	}
	
	public static void writeList() {
		PrintWriter out = null;
		FileWriter fw = null;
		
		try
		{
			// fw = new FileWriter("C:/abc/out.txt");
			fw = new FileWriter("out2.txt");
			out = new PrintWriter(fw);
			out.println("hello");
			System.out.println("�۾�����...");
//			out.close();
		} catch(IOException e) {
			System.out.println("catch:" + e.getMessage());
		} finally {
			System.out.println("finally code");
			if(out != null)
			{
				out.close();
			}
			System.out.println("finally end");
		}
		
	}

}
