package Lecture_210419;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class DequeTest {

	public static void main(String[] args) {
		// Deque�� �������̽��̰� �� �������̽��� ������ Ŭ������ ArrayDeque�̴�
		Deque<Integer> deque = new ArrayDeque<>();
		
		// Queue�� a, b�޼ҵ尡 ���� �Ǿ� �ְ� ArrayQueue�� a, b, c, d, e �޼ҵ尡 �ְ� Qeue�� q��� ������ �����Ǿ� ������
		// q.a(), q.b()�� ȣ�� �ϴ� ���� ����������
		// q.c()���ʹ� ȣ�� �� �� ����.
		
		// ť�� ������ ���� 10�� �ְ�
		// �ȿ� ��� ������ ���ִ��� ����
		// FIFO ������ �������� Ȯ���� ����
		
		for(int i = 0; i < 10; i++) {
			deque.add(i + 1);
		}
		
//		System.out.println(deque);
		
		while(deque.size() > 0) {
			Integer val = deque.poll(); 
			// ���ʴ�� �ϳ��� ���Ҹ� ���� ť�� ����� 1�� �����Ѵ�
			System.out.print(val + " ");
		}
		
		// poll�� �ϸ� ť�� ����Ǿ� �ִ� �ڷḦ ���� �ϳ��� �����ϴ� ���̶� ��� poll�ϸ� �����ȴ�
		System.out.println("\nť�� ����...");
		System.out.println(deque);
	}

}
