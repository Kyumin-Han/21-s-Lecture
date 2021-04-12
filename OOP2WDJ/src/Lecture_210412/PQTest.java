package Lecture_210412;

import java.util.PriorityQueue;
import java.util.Queue;

public class PQTest {

	public static void main(String[] args) {
		test1();
	}
	
	public static void test1() {
		Queue<String> sq = new PriorityQueue<>();
		// �켱���� ť�� ������������ ���ĵǾ��ִ�
		// Queue���� ���� �߰� offer/add
		sq.offer("PineApple");
		sq.offer("Banana");
		sq.offer("Carrot");
		sq.offer("Cherry");
		sq.offer("Strawberry");
		
		// Queue���� ���� ���Ұ� �������� ���⸸ �ϴ� ��(��� x)
		// peek/element
		System.out.println(sq.peek());
		
		// Queue�� ����Ǿ� �ִ� ���ҵ��� �ϳ��� ���
		// poll/remove
		while(sq.size() > 0) {
			System.out.println(sq.remove());
		}
	}

}
