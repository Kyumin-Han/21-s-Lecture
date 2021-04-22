package Lecture_210419;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class DequeTest {

	public static void main(String[] args) {
		// Deque는 인터페이스이고 이 인터페이스를 구현한 클래스는 ArrayDeque이다
		Deque<Integer> deque = new ArrayDeque<>();
		
		// Queue에 a, b메소드가 구현 되어 있고 ArrayQueue에 a, b, c, d, e 메소드가 있고 Qeue가 q라는 변수로 구현되어 있을때
		// q.a(), q.b()를 호출 하는 것은 가능하지만
		// q.c()부터는 호출 할 수 없다.
		
		// 큐에 임의의 수를 10개 넣고
		// 안에 어떠한 순서로 들어가있는지 보고
		// FIFO 순으로 나오는지 확인해 본다
		
		for(int i = 0; i < 10; i++) {
			deque.add(i + 1);
		}
		
//		System.out.println(deque);
		
		while(deque.size() > 0) {
			Integer val = deque.poll(); 
			// 차례대로 하나씩 원소를 빼서 큐의 사이즈가 1씩 감소한다
			System.out.print(val + " ");
		}
		
		// poll을 하면 큐에 저장되어 있던 자료를 빼서 하나씩 삭제하는 것이라 모두 poll하면 삭제된다
		System.out.println("\n큐의 상태...");
		System.out.println(deque);
	}

}
