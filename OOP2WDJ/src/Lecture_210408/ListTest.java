package Lecture_210408;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		test1();
	}
	
	private static void test1() {
		List<String> list = new ArrayList<>();
		String[] sArr = { "자동차", "운동장", "유치원", "학교" };
		
		for(String s : sArr)
		{
			list.add(s);
		}
		
//		System.out.println(list); 
		// ArrayList의 toString() 메소드가 이용된다
		
		System.out.println("일반 for문 이용");
		// 일반 for문을 이용해서 ArrayList의 요소들 출력하기
		
		for(int i = 0; i < list.size(); i++)
		{
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		
		System.out.println("for-each(advanced for)문 이용");
		// for-each문을 이용해서 ArrayList의 요소들 출력하기
		
		for(String s : list)
		{
			System.out.print(s + " ");
		}
		System.out.println();
		
		System.out.println("Iterator 이용");
		Iterator<String> iter = list.iterator();
//		System.out.print(iter.next());
//		System.out.print(iter.next());
//		System.out.print(iter.next());
//		System.out.print(iter.next());
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		
		// overloading된 add 메소드로 원소를 중간에 삽입할 수 있다
		list.add(1, "벚꽃");
		iter = list.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		
		// 저장된 배열의 원소를 하나 삭제
		list.remove(3);
		// 네번째 원소 삭제
		System.out.print(list);
	}

}
