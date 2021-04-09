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
		String[] sArr = { "�ڵ���", "���", "��ġ��", "�б�" };
		
		for(String s : sArr)
		{
			list.add(s);
		}
		
//		System.out.println(list); 
		// ArrayList�� toString() �޼ҵ尡 �̿�ȴ�
		
		System.out.println("�Ϲ� for�� �̿�");
		// �Ϲ� for���� �̿��ؼ� ArrayList�� ��ҵ� ����ϱ�
		
		for(int i = 0; i < list.size(); i++)
		{
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		
		System.out.println("for-each(advanced for)�� �̿�");
		// for-each���� �̿��ؼ� ArrayList�� ��ҵ� ����ϱ�
		
		for(String s : list)
		{
			System.out.print(s + " ");
		}
		System.out.println();
		
		System.out.println("Iterator �̿�");
		Iterator<String> iter = list.iterator();
//		System.out.print(iter.next());
//		System.out.print(iter.next());
//		System.out.print(iter.next());
//		System.out.print(iter.next());
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		
		// overloading�� add �޼ҵ�� ���Ҹ� �߰��� ������ �� �ִ�
		list.add(1, "����");
		iter = list.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		
		// ����� �迭�� ���Ҹ� �ϳ� ����
		list.remove(3);
		// �׹�° ���� ����
		System.out.print(list);
	}

}
