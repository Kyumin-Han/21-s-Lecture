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
		// ������ ��Ÿ ������ �д´�
//		if(file.exists() == true) {
//			System.out.println(file.getAbsolutePath() + ": ������");
//		}
//		else {
//			System.out.println(file.getAbsolutePath() + ": �������� ����");
//		}
		
		// ���Ͽ� �а� ������ stream ��ü�� �̿��ؾ��Ѵ�
		// ���� ���� Input Stream
		// �� ���� Output Stream �� ���� �־�� �Ѵ�
		// steam�� �⺻������ Byte Stream�̴�
		// ���� ������ �а� �� ���� ���� ��Ʈ���� �̿��ϴ� ���� ���ϴ�
		// ���� ������ �Է� ��Ʈ���� Reader ��ü�� ǥ���ȴ�
		// ���� ������ ��� ��Ʈ���� Writer ��ü�� ǥ���Ѵ�

		int count = 0;
		BufferedReader bReader = null;
		
		try {
			// FileReader�� �� ���ھ� ���� �� ���
			FileReader fileReader = new FileReader(file);
			
			//���� ������ ������ �б� ���ؼ� BufferedReader�� �̿��Ѵ�
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
			// ������ �а� �� �� �� ������ ������ �ݾ��־���Ѵ�
			try {
				bReader.close();
			} catch (Exception e) {
				
			}
			
		}
		
		System.out.println("�ܾ� ��(�ߺ�����):" + count);
		System.out.println("�ܾ� ��(�ߺ� ������):" + set.size());
	}

}

