package Lecture_210503;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsAPITest {
	private String name;
	
	public CollectionsAPITest() {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public static void main(String[] args) {
	
	String[] sample = { "i", "walk", "the", "line" };
	List<String> list = Arrays.asList(sample);
	
	// Collections�� sort �޼ҵ�� List Ÿ���� ���ڷ� ������.
	System.out.println("���� ��");
	System.out.println(list);
	
	// �������� ����
	Collections.sort(list);
	
	// ���� ���� ����
	// ������ Ÿ�� Ŭ������ ������ �� ������ Comparable �������̽��� �����ؼ� ���� ����� ������ �� �ִ�
	// ������ Ÿ�� Ŭ������ ���� �� �� ������(String, Integer ���) Comparator Ŭ������ �����ؼ� ���� ����� �������Ѵ�
	// ������ Ÿ�� Ŭ������ ������ �� �־ �� Ŭ������ �������� �ʰ� ���� ����� ������ ���� Comparator Ŭ������ ������ �ش�
	Collections.sort(list, new MyComparator());
	
	System.out.println("���� ��");
	System.out.println(list);
	
	int sum = add(3, 4);
	System.out.println(sum);
	}
	
	public static int add(int n1, int n2) {
		return n1 + n2;
	}
}

class MyComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// ���ڿ� ���� �񱳴� Comparable �������̽��� �����ϰ� �ִ� String Ŭ������ compare�޼ҵ带 ȣ���ϸ� �ȴ�.
		
		return o1.compareTo(o2) * (-1);
	}

	

	
	
	
}
