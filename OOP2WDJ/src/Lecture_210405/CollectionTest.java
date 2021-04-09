package Lecture_210405;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;
import java.util.stream.IntStream;

public class CollectionTest {

	public static void main(String[] args) {
		//		test2();
		//		test3();
		//		setTest1();
		lotto();
	}

	public static void test1() {
		/*
		 * List : 순서가 있고 중복이 허용되는 자료구조이다
		 */
		List<Integer> list1 = new ArrayList<>();
		List<String> list2 = new LinkedList<>();
		List<Double> list3 = new Vector<>();
		List<Integer> list4 = new Stack<>();

		for(int i = 0; i < 10; i++)
		{
			list1.add(i+1);
			list2.add(String.valueOf(i+1));
			list3.add(i * 1.0);
			list4.add(i+1);
		}
		//		
		//		System.out.println(list1);
		//		System.out.println(list2);
		//		System.out.println(list3);
		//		System.out.println(list4);

		//		for(int i = 0; i < list1.size(); i++)
		//		{
		//			System.out.print(list1.get(i) + " ");
		//		}

		//		for(String s : list2) {
		//			System.out.print(s + ", ");
		//		}

		// Iterator를 이용해서 값에 하나씩 접근할 때는
		// iter.hasNext()메소드를 이용하여 다음 값이 있는지 없는지 체크해서 사용해야한다
		Iterator<Double> iter = list3.iterator();
		while(iter.hasNext()) {
			Double d = iter.next();
			System.out.print(d + " ");
		}
	}

	public static void test2() {
		//		List<Integer> list = new ArrayList<>();
		List<Integer> list = new LinkedList<>();
		IntStream.rangeClosed(1, 100000).forEach(i -> list.add(i));
		long start = System.currentTimeMillis();

		//		for(int i = 0; i < 100000; i++)
		//		{
		//			list.add(i + 1);
		//		}

		//		for(int i = 0; i < 1000; i++) {
		//			list.add(30, 1000);
		//		}

		for(int i = 0; i < list.size(); i++) {
			list.get(i);
		}

		long end = System.currentTimeMillis();

		System.out.println((end-start) + "ms Elapsed...");
	}

	public static void test3() {
		ArrayList<String> list = new ArrayList<>();
		list.add("MILK");
		list.add("BREAD");
		list.add("BUTTER");
		System.out.println(list);
		list.add(1, "APPLE");
		System.out.println("APPLE을 1번 인덱스에 추가한 후 : " + list);
		list.set(2, "GRAPE");
		System.out.println("2번 인덱스의 원소를 GRAPE로 변경한 후 : " + list);
		list.remove(3);
		System.out.println("3번 인덱스의 원소를 삭제 한 후 : " + list);

		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}

		// iterator를 한번 돌고 난 후에 다시 next() 메소드를 호출하면 더이상 반환할 값이 없기 때문에
		// exception을 발생시킨다
		//		iter.next();
		System.out.println("끝");
	}


	public static void setTest1() {
		Set<String> set = new HashSet<>();
		String[] strArr = { "단어", "중복", "구절", "중복" };
		for(String s : strArr) {
			if(set.add(s) == false)
			{
				System.out.println(s + "값은 이미 존재!!!");
			}
		}

		System.out.println(set);
	}

	public static void lotto() {
		//		Set<Integer> lottoNums = new HashSet<>();
//		MyComparator comp = new MyComparator();
		Set<Integer> lottoNums = new TreeSet<>();
		//		Set<Integer> lottoNums = new LinkedHashSet<>();

		// lottoNums의 원소 수가 6이 될 때까지
		// 1~45까지의 무작위 숫자를 생성해 lottoNums에 넣는다

		while(lottoNums.size() < 6) {
			int num = (int)(Math.random()*45) + 1;
			if(lottoNums.add(num)) {
				System.out.print(num + ", ");
			}
			lottoNums.add((int)(Math.random()*45) + 1);
			//		}

			//		System.out.print(lottoNums);

			for(Integer ln : lottoNums) {
				
				System.out.print(ln + " ");
			}

			Iterator<Integer> iter = lottoNums.iterator();
			while(iter.hasNext()) {
				System.out.print(iter.next() + " ");
			}

			System.out.println();
		}
	}

	class MytComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return 0;
		}

	}
}
