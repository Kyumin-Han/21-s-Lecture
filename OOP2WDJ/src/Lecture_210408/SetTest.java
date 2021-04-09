package Lecture_210408;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		test1();
	}
	
	private static void test1() {
		File file = new File("wordbook.txt");
		Set<String> set = new HashSet<>();
		// 파일의 메타 정보를 읽는다
//		if(file.exists() == true) {
//			System.out.println(file.getAbsolutePath() + ": 존재함");
//		}
//		else {
//			System.out.println(file.getAbsolutePath() + ": 존재하지 않음");
//		}
		
		// 파일에 읽고 쓰려면 stream 객체를 이용해야한다
		// 읽을 때는 Input Stream
		// 쓸 때는 Output Stream 을 열어 주어야 한다
		// steam은 기본적으로 Byte Stream이다
		// 문자 단위로 읽고 쓸 때는 문자 스트림을 이용하는 것이 편리하다
		// 문자 단위로 입력 스트림은 Reader 객체로 표현된다
		// 문자 단위의 출력 스트림은 Writer 객체로 표현한다

		int count = 0;
		BufferedReader bReader = null;
		
		try {
			// FileReader는 한 문자씩 읽을 때 사용
			FileReader fileReader = new FileReader(file);
			
			//라인 단위로 파일을 읽기 위해서 BufferedReader를 이용한다
			bReader = new BufferedReader(fileReader);
			
			String line = null;
			
			while((line = bReader.readLine()) != null) {
				System.out.println(line);
				set.add(line);
				count++;
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			
		} finally {
			// 파일을 읽고 난 후 다 읽으면 파일을 닫아주어야한다
			try {
				bReader.close();
			} catch (Exception e) {
				
			}
			
		}
		
		System.out.println("단어 수(중복포함):" + count);
		System.out.println("단어 수(중복 미포함):" + set.size());
	}

}

