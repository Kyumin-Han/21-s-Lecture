package Lecture_210419;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		// Stack : Last In First Out
		// Generic : 클래스 내부에서 사용할 데이터 타입이 정해진 것이 아닌, 객체를 생성할 때 데이터 타입을 결정할 수 있다
		Stack<Integer> stack = new Stack();
		
		for(int i = 0; i < 10; i++) {
			stack.push(i + 1);
			// stack에서 데이터를 넣는 메소드는 push이다
		}
		
		System.out.println(stack);
		
		while(!stack.isEmpty()) {
			Integer val = stack.pop();
			System.out.print(val + " ");
		}

	}

}
