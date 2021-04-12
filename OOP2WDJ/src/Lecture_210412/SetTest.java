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
		 * ������ = set1.addAll(set2) {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
		 * ������ = set1.retainAll(set2) = {3, 5, 9}
		 * ������ = set1.removeAll(set2) => set1 - set2 = {2, 4, 6, 8, 10}
		 * 		= set2.removeAll(set1) => set2 - set1 = {1, 7}
		 */
		// Generic Ŭ���� ��ü�� ������ �� Ÿ�� �Ķ���ʹ� 
		// ������Ƽ��(������) Ÿ���� �� �� ����. ��ü Ÿ�Ը� �� �� �ִ�.
		// HashSet, LinkedHashSet, TreeSet�� �ִ�
		// LinkedHashSet�� �Է� ������� ���
		// TreeSet�� ���� ���� ���ĵ� ������ ����
		Set<Integer> set1 = new HashSet<>();
		// {2, 3, 4, 5, 6, 8, 9, 10}
		// �迭�� Collection���� ������ִ� �޼ҵ尡 �ִ�
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
		// addAll�� ����� boolean���� ��ȯ�ǹǷ� �޼ҵ带 ������ ���� ������ set�� ����غ��� �ȴ�

		System.out.println("set1�� set2�� ������: " + unionSet);

		Set<Integer> intersectionSet = new HashSet<>(set1);
		intersectionSet.retainAll(set2);
		System.out.println("set1�� set2�� ������: " + intersectionSet);

		Set<Integer> diffSet = new HashSet<>(set1);
		diffSet.removeAll(set2);
		System.out.println("set1�� set2�� ������ (set1 - set2): " + diffSet);

		//		for(int i = 0; i < diffSet.size(); i++)
		//		{
		//			diffSet.get(i);
		//		}

		// for-each�� ���
		for(Integer val : diffSet) {
			System.out.print(val + " ");
		}
		System.out.println();

		// iterator �̿�
		//		Iterator<Integer> iter = diffSet.iterator();
		Iterator<Integer> iter = set1.iterator();
		while(iter.hasNext()) {
			Integer val = iter.next();
			System.out.print(val + " ");
		}
		System.out.println();

		Set<Integer> diffSet2 = new HashSet<>(set2);
		diffSet2.removeAll(set1);
		System.out.println("set1�� set2�� ������ (set2 - set1): " + diffSet2);

		// ���ҿ� �ϳ��ϳ� �����Ҷ�
	}

	public static void test2() {
		List<Integer> list = Arrays.asList(10, 9, 5234, 8, 6, 5, 4, 3, 2);
		//		Set<Integer> set1 = new LinkedHashSet<>();
		//		Set<Integer> set1 = new TreeSet<>();
		Set<Integer> set1 = new TreeSet<>(new MyComparator());
		set1.addAll(list);
		Iterator<Integer> iter = set1.iterator();
		// �Էµ� ������� ��µ�(LinkedHashSet)
		// ���� ������� ��µ�(TreeSet)
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
	}

}

class MyComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		// ù��° ���ڷ� ���޵� ���� ũ�� ���
		// ������ 0
		// �ι�° ���ڷ� ���޵� ���� ũ�� ����
		// �������� ����
		return o1 - o2;
	}
}

