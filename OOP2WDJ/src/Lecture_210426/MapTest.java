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
		// HashMap ��ü�� �����Ѵ�
		// ���� <key, value>�� ������ �����ϰ�
		// key ���� ���� ���� ����
		// Map�̶�� Generic �������̽��� ������ Ŭ���� HashMap, TreeMap, LinkedHashMap Ŭ�������� GenericŬ�����̴�
		// ��ü���� ������ �� Ÿ���� ������ ��� �Ѵ�
		
		// Map�� <�й�, �л���ü>�� ����
		
		Map<String, Student> map = new HashMap<>();
		
		map.put("2000101", new Student(2000101, "ȫ�浿"));
		map.put("2000102", new Student(2000102, "������"));
		map.put("2000103", new Student(2000103, "�̸���"));
		map.put("2000104", new Student(2000104, "������"));
		map.put("2000105", new Student(2000105, "����"));
		
		Student value = map.get("2000103");
		System.out.println(value.getName());
		
		map.put("2000103", new Student(2000103, "�̻��"));
		value = map.get("2000103");
		System.out.println(value.getName());
		
		// map�̶�� �ڷᱸ���� �� �ִ� ��� ���ҵ��� �� ���� �� �ִ� ���
		// ù����: map���� ���� ���ҵ��� ��� Ű ���� ��û�ϰ� �� ������ �� ���Ҹ� ������ map���� ���� ��û�ϴ� ���
		// �ι�°: map���� <key, value> ������ ����� ��Ʈ�� ������ ��û�ؼ� �� ������ ���Ҹ� �ϳ��� �д� ���
		
		Set<String> keyset = map.keySet();
		// Set�� ���Ҹ� �ϳ��� �����ϴ� ���
		
//		Iterator<String> iter = keyset.iterator();
//		while(iter.hasNext()) {
//			String key = iter.next();
//			Student val = map.get(key);
//			System.out.println("key: " + key + ", value: " + val);
//		}
		
		// map���� ��Ʈ���� ���� <key, value>�� ������ ������ �ϳ��� ��ü
		// ��ü�� �� ��ü�� �����ϴ� Ŭ������ �ִٴ� �ǹ��̴�.
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
		// ��ȭ��ȣ�� �����ϴ� map ��ü �����ϱ�
		// map�� <�̸�, ��ȭ��ȣ>�� ����
		
		Map<String, String> phoneBook = new HashMap<>();
		String[] names = {"ȫ�浿", "������", "������", "�̸���"};
		String[] phones = {"010-1234-5678", "010-2234-5578", "010-1235-8399", "010-3632-7653"};
		
		for(int i = 0; i < names.length; i++) {
			phoneBook.put(names[i], phones[i]);
		}
		
		Scanner input = new Scanner(System.in);
		
		while(true) {
			System.out.print("ģ�� �̸�:");
			String name = input.nextLine();
			if(name.equals("")) break;
			String phone = phoneBook.get(name);
			System.out.println(name + "�� ��ȭ��ȣ�� " + phone + "�Դϴ�.");
		}
	}

}
