package Lecture_210422;

import java.util.*;

public class StackTest {

	public static void main(String[] args) {
		// ( 를 스택에 넣고
		// ) 를 만나면 pop해서 스택에서 뺀다
		// 주어진 식을 다 처리했을때 스택이 empty가 된다
		// empty가 아니면 잘못된 식이다
		
		// 수식을 먼저 입력 받는다
		
		Scanner input = new Scanner(System.in);
		// 콘솔 입력을 위한 Scanner 객체 생성
		System.out.println("수식을 입력하세요.");
		
		String exp = input.nextLine();
		// 입력한 내용을 한줄의 문자열로 받는다.
		
		// 입력 받은 수식을 공백을 기준으로 문자열 토큰으로 분리하자
		StringTokenizer st = new StringTokenizer(exp);
		// exp 문자열 변수의 값을 공백을 기준으로 문자열 토큰들로 분리
		// StringTokenizer에 두번째 인자로 구분자를 줄 수 있는데 생략하면 기본으로 공백이다.
		
		// 분리된 토큰을 하나씩 보면서 ( 이면 스택에 push
		// ) 이면 스택에서 pop한다
		
		Stack<String> stack = new Stack<>();
		
		while(st.hasMoreTokens()) {
			// 토큰이 남아있는 동안 반복한다.
			// hasMoreElements()를 사용해도 된다
			
			String token = st.nextToken();
			
			// token이 ( 이면 stack에 push
			if(token.equals("(")) {
				stack.push("(");
			}
			// token이 ) 이면 stack에서 pop
			else if(token.equals(")")) {
				if(stack.isEmpty()) {
					System.out.println("잘못된 식입니다.");
					return;
				}
				stack.pop();
			}
			// stack에 원소가 하나도 없다면 닫는 괄호에 매칭되는 여는 괄호가 없다는 의미이다.
			// 이는 잘못된 식이기 때문에 다른 토큰을 볼 필요가 없다.
		}
		
		// 모든 토큰 처리가 끝났고, 그 때까지 잘못된 괄호가 발견되지 않았다면
		// 프로그램 흐름이 여기까지 왔다는 것은 식에 잘못된 것이 없거나, 여는 괄호가 더 많은 경우이다
		
		if(stack.isEmpty() != true) {
			// 여는 괄호가 더 많다는 의미
			System.out.println("잘못된 식입니다.");
			return;
		}
		
		System.out.println("유효한 식입니다.");
	}

}
