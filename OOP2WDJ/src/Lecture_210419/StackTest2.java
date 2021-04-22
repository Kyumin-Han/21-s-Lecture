package Lecture_210419;

import java.util.StringTokenizer;

public class StackTest2 {

	public static void main(String[] args) {
		String str = "apple banana carrot pineapple grape mango strawberry watermelon melon orange coconut kiwi lemon tomato cherry blueberry peach";

//		String s = str.substring(0, "apple".length());
//		System.out.println(s);
		
		// 공백 문자를 기준을 하나씩 잘라서 출력
		// 구분자를 입력으로 주고, 그 구분자로 구분되는 문자열들을 하나씩 뽑아쓸 수 있게하는 java.util패키지의 클래스가 StringTokenizer이다
		
		StringTokenizer st = new StringTokenizer(str, " ");
		
//		String s = st.nextToken();
//		System.out.println(s);
//		
//		s = st.nextToken();
//		System.out.println(s);
		
		System.out.println("token 수: " + st.countTokens());
		// 토큰을 다 출력해 보는 방법 1
		// 토큰의 수 만큼 for문 돌기
		
		// 토큰을 다 출력해 보는 방법 2
		// 받을 수 있는 토큰이 남아있는지 확인하고 있으면 nextToken() 메소드를 이용해 하나씩 받아 사용하기
		// 주로 이 방법을 많이 사용한다
		
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println("[" + token + "]");
		}
	}

}
