package Lecture_210426;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
//		test1();
		test2();
	}
	
	public static void test1() {
		// HashMap 객체를 생성한다
		// 맵은 <key, value>의 쌍으로 저장하고
		// key 값을 통해 값을 인출
		// Map이라는 Generic 인터페이스를 구현한 클래스 HashMap, TreeMap, LinkedHashMap 클래스들은 Generic클래스이다
		// 객체들을 생성할 때 타입을 지정해 줘야 한다
		
		// Map에 <학번, 학생객체>로 저장
		
		Map<String, Student> map = new HashMap<>();
		
		map.put("2000101", new Student(2000101, "홍길동"));
		map.put("2000102", new Student(2000102, "일지매"));
		map.put("2000103", new Student(2000103, "이몽룡"));
		map.put("2000104", new Student(2000104, "성춘향"));
		map.put("2000105", new Student(2000105, "방자"));
		
		Student value = map.get("2000103");
		System.out.println(value.getName());
		
		map.put("2000103", new Student(2000103, "이삼룡"));
		value = map.get("2000103");
		System.out.println(value.getName());
		
		// map이라는 자료구조에 들어가 있는 모든 원소들을 다 읽을 수 있는 방법
		// 첫번쨰: map에게 가진 원소들의 모든 키 값을 요청하고 그 집합의 각 원소를 가지고 map에게 값을 요청하는 방법
		// 두번째: map에게 <key, value> 쌍으로 저장된 엔트리 집합을 요청해서 그 집합의 원소를 하나씩 읽는 방법
		
		Set<String> keyset = map.keySet();
		// Set의 원소를 하나씩 접근하는 방법
		
//		Iterator<String> iter = keyset.iterator();
//		while(iter.hasNext()) {
//			String key = iter.next();
//			Student val = map.get(key);
//			System.out.println("key: " + key + ", value: " + val);
//		}
		
		// map에서 엔트리라 함은 <key, value>의 쌍으로 구성된 하나의 객체
		// 객체는 이 객체를 정의하는 클래스가 있다는 의미이다.
		Set<Entry<String, Student>> entryset = map.entrySet();
		Iterator<Entry<String, Student>> eIter = entryset.iterator();
		while(eIter.hasNext()) {
			Entry<String, Student> entryObj = eIter.next();
			String key = entryObj.getKey();
			Student val = entryObj.getValue();
			System.out.println("key: " + key + ", value - " + val);
		}
		
	}
	
	public static void test2() {
		// 전화번호를 저장하는 map 객체 생성하기
		// map에 <이름, 전화번호>로 저장
		
		Map<String, String> phoneBook = new HashMap<>();
		String[] names = {"홍길동", "일지매", "성춘향", "이몽룡"};
		String[] phones = {"010-1234-5678", "010-2234-5578", "010-1235-8399", "010-3632-7653"};
		
		for(int i = 0; i < names.length; i++) {
			phoneBook.put(names[i], phones[i]);
		}
		
		Scanner input = new Scanner(System.in);
		
		while(true) {
			System.out.print("친구 이름:");
			String name = input.nextLine();
			if(name.equals("")) break;
			String phone = phoneBook.get(name);
			System.out.println(name + "의 전화번호는 " + phone + "입니다.");
		}
	}

}
