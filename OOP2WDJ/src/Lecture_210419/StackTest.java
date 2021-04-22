package Lecture_210419;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		// Stack : Last In First Out
		// Generic : Ŭ���� ���ο��� ����� ������ Ÿ���� ������ ���� �ƴ�, ��ü�� ������ �� ������ Ÿ���� ������ �� �ִ�
		Stack<Integer> stack = new Stack();
		
		for(int i = 0; i < 10; i++) {
			stack.push(i + 1);
			// stack���� �����͸� �ִ� �޼ҵ�� push�̴�
		}
		
		System.out.println(stack);
		
		while(!stack.isEmpty()) {
			Integer val = stack.pop();
			System.out.print(val + " ");
		}

	}

}
