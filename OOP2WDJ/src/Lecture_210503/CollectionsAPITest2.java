package Lecture_210503;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CollectionsAPITest2 {
	public static void main(String[] args) {
		//		shuffleTest();

		binarySearchTest();
	}

	public static void binarySearchTest() {
		// 1. ������ ������ ������ ����Ʈ�� ���� ����Ž���� �߸��� �����
		// 2. ���ĵ� ����Ʈ�� ���� ���� Ž���� �����ؾ� �Ѵ�.

		Random random = new Random();
		List<Integer> list = new ArrayList<>();

		for(int i = 0; i < 20; i++) {
			list.add(random.nextInt(100) + 1);
		}
		
		Collections.sort(list);
		System.out.println(list);
		
		int idx = Collections.binarySearch(list, 73);
		if(idx >= 0) {
			System.out.println((idx+1) + "��°�� �ֽ��ϴ�.");
		} else {
			System.out.println("�ش� ���� ����Ʈ�� �����ϴ�.");
		}
	}

	public static void shuffleTest() {
		List<Integer> list = new ArrayList<>();
		List<Student> list2 = new ArrayList<>();

		for(int i = 0; i < 10; i++) {
			Student std = new Student();
			std.grade = (i+1) * 100;
			list2.add(std);
		}

		System.out.println("���� ��");
		System.out.println(list);

		Collections.shuffle(list);

		System.out.println("���� ��");
		System.out.println(list);

	}
}

class Student {
	int grade;

	public String toString() {
		return String.valueOf(grade);
	}
}
