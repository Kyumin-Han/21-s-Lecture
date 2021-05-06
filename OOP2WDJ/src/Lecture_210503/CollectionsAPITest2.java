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
		// 1. 무작위 정수를 저장한 리스트에 대해 이진탐색은 잘못된 방식임
		// 2. 정렬된 리스트에 대해 이진 탐색을 수행해야 한다.

		Random random = new Random();
		List<Integer> list = new ArrayList<>();

		for(int i = 0; i < 20; i++) {
			list.add(random.nextInt(100) + 1);
		}
		
		Collections.sort(list);
		System.out.println(list);
		
		int idx = Collections.binarySearch(list, 73);
		if(idx >= 0) {
			System.out.println((idx+1) + "번째에 있습니다.");
		} else {
			System.out.println("해당 값은 리스트에 없습니다.");
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

		System.out.println("섞기 전");
		System.out.println(list);

		Collections.shuffle(list);

		System.out.println("섞은 후");
		System.out.println(list);

	}
}

class Student {
	int grade;

	public String toString() {
		return String.valueOf(grade);
	}
}
