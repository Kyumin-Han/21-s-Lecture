package Lecture_210329;

import java.util.ArrayList;

public class GenericExample {

	public static void main(String[] args) {
		// array�� �⺻������ �迭�� ũ�Ⱑ ������ �ֱ� ������ ���������� �迭�� ����ؾ� �Ҷ��� �����ϴ�
//		String[] arr1 = {"����", "�ٴ�", "��" };
//		arr1[3] = "�ź���";
		
		// ArrayList�� ����ϸ� ũ�⿡ ��� ���� ����� �� �ִ�
		ArrayList<String> strList = new ArrayList<>();
		
		for(int i = 0; i < 200; i++)
		{
			// ArrayList�� �� ���ҵ��� add �޼ҵ带 ����ؿ� �� �ε����� ���ҵ��� �߰��� �� �ִ�
			strList.add(String.valueOf(i));
		}
		
		for(int i = 0; i < strList.size(); i++) 
		{
			System.out.println(strList.get(i));
		}
		
		ArrayList<Student> stdList = new ArrayList<>();
		for(int i = 0; i < 100; i++)
		{
			stdList.add(new Student());
		}
	}

}
