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
	
	// Collections의 sort 메소드는 List 타입을 인자로 가진다.
	System.out.println("정렬 전");
	System.out.println(list);
	
	// 오름차순 정렬
	Collections.sort(list);
	
	// 내림 차순 정렬
	// 원소의 타입 클래스를 지정할 수 있으면 Comparable 인터페이스를 구현해서 정렬 방법을 변경할 수 있다
	// 원소의 타입 클래스를 지정 할 수 없으면(String, Integer 등등) Comparator 클래스를 구현해서 정렬 방법을 얄려줘야한다
	// 원소의 타입 클래스를 지정할 수 있어도 그 클래스를 변경하지 않고 정렬 방법을 변경할 때도 Comparator 클래스를 구현해 준다
	Collections.sort(list, new MyComparator());
	
	System.out.println("정렬 후");
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
		// 문자열 값의 비교는 Comparable 인터페이스를 구현하고 있는 String 클래스의 compare메소드를 호출하면 된다.
		
		return o1.compareTo(o2) * (-1);
	}

	

	
	
	
}
