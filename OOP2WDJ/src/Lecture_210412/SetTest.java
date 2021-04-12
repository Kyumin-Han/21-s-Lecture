package Lecture_210412;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		//		test1();
		test2();
	}

	public static void test1() {
		/*
		 * set1 = {2, 3, 4, 5, 6, 8, 9, 10}
		 * set2 = {1, 3, 5, 7, 9}
		 * 합집합 = set1.addAll(set2) {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
		 * 교집합 = set1.retainAll(set2) = {3, 5, 9}
		 * 차집합 = set1.removeAll(set2) => set1 - set2 = {2, 4, 6, 8, 10}
		 * 		= set2.removeAll(set1) => set2 - set1 = {1, 7}
		 */
		// Generic 클래스 객체를 생성하 때 타입 파라미터는 
		// 프리미티브(원시형) 타입을 줄 수 없다. 객체 타입만 줄 수 있다.
		// HashSet, LinkedHashSet, TreeSet이 있다
		// LinkedHashSet은 입력 순서대로 출력
		// TreeSet은 값에 따라 정렬된 순서로 인출
		Set<Integer> set1 = new HashSet<>();
		// {2, 3, 4, 5, 6, 8, 9, 10}
		// 배열을 Collection으로 만들어주는 메소드가 있다
		//		List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 8, 9, 10);
		List<Integer> list = Arrays.asList(10, 9, 5234, 8, 6, 5, 4, 3, 2);
		set1.addAll(list);
		//		set1.add(2); set1.add(3); set1.add(4); set1.add(5); set1.add(6); set1.add(8); set1.add(9); set1.add(10);

		Set<Integer> set2 = new HashSet<>();
		List<Integer> list2 = Arrays.asList(1, 3, 5, 7, 9);
		set2.addAll(list2);

		System.out.println("set1: " + set1);
		System.out.println("set2: " + set2);

		Set<Integer> unionSet = new HashSet<>(set1);

		unionSet.addAll(set2);
		// addAll의 결과는 boolean값이 반환되므로 메소드를 실행한 이후 원래의 set을 출력해보면 된다

		System.out.println("set1과 set2의 합집합: " + unionSet);

		Set<Integer> intersectionSet = new HashSet<>(set1);
		intersectionSet.retainAll(set2);
		System.out.println("set1과 set2의 교집합: " + intersectionSet);

		Set<Integer> diffSet = new HashSet<>(set1);
		diffSet.removeAll(set2);
		System.out.println("set1과 set2의 차집합 (set1 - set2): " + diffSet);

		//		for(int i = 0; i < diffSet.size(); i++)
		//		{
		//			diffSet.get(i);
		//		}

		// for-each문 사용
		for(Integer val : diffSet) {
			System.out.print(val + " ");
		}
		System.out.println();

		// iterator 이용
		//		Iterator<Integer> iter = diffSet.iterator();
		Iterator<Integer> iter = set1.iterator();
		while(iter.hasNext()) {
			Integer val = iter.next();
			System.out.print(val + " ");
		}
		System.out.println();

		Set<Integer> diffSet2 = new HashSet<>(set2);
		diffSet2.removeAll(set1);
		System.out.println("set1과 set2의 차집합 (set2 - set1): " + diffSet2);

		// 원소에 하나하나 접근할때
	}

	public static void test2() {
		List<Integer> list = Arrays.asList(10, 9, 5234, 8, 6, 5, 4, 3, 2);
		//		Set<Integer> set1 = new LinkedHashSet<>();
		//		Set<Integer> set1 = new TreeSet<>();
		Set<Integer> set1 = new TreeSet<>(new MyComparator());
		set1.addAll(list);
		Iterator<Integer> iter = set1.iterator();
		// 입력된 순서대로 출력됨(LinkedHashSet)
		// 값의 순서대로 출력됨(TreeSet)
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
	}

}

class MyComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		// 첫번째 인자로 전달된 것이 크면 양수
		// 같으면 0
		// 두번째 인자로 전달된 것이 크면 음수
		// 오름차순 정렬
		return o1 - o2;
	}
}

