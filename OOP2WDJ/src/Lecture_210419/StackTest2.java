package Lecture_210419;

import java.util.StringTokenizer;

public class StackTest2 {

	public static void main(String[] args) {
		String str = "apple banana carrot pineapple grape mango strawberry watermelon melon orange coconut kiwi lemon tomato cherry blueberry peach";

//		String s = str.substring(0, "apple".length());
//		System.out.println(s);
		
		// ���� ���ڸ� ������ �ϳ��� �߶� ���
		// �����ڸ� �Է����� �ְ�, �� �����ڷ� ���еǴ� ���ڿ����� �ϳ��� �̾ƾ� �� �ְ��ϴ� java.util��Ű���� Ŭ������ StringTokenizer�̴�
		
		StringTokenizer st = new StringTokenizer(str, " ");
		
//		String s = st.nextToken();
//		System.out.println(s);
//		
//		s = st.nextToken();
//		System.out.println(s);
		
		System.out.println("token ��: " + st.countTokens());
		// ��ū�� �� ����� ���� ��� 1
		// ��ū�� �� ��ŭ for�� ����
		
		// ��ū�� �� ����� ���� ��� 2
		// ���� �� �ִ� ��ū�� �����ִ��� Ȯ���ϰ� ������ nextToken() �޼ҵ带 �̿��� �ϳ��� �޾� ����ϱ�
		// �ַ� �� ����� ���� ����Ѵ�
		
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println("[" + token + "]");
		}
	}

}
