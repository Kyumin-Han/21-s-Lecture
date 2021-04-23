package Lecture_210422;

import java.util.*;

public class StackTest {

	public static void main(String[] args) {
		// ( �� ���ÿ� �ְ�
		// ) �� ������ pop�ؼ� ���ÿ��� ����
		// �־��� ���� �� ó�������� ������ empty�� �ȴ�
		// empty�� �ƴϸ� �߸��� ���̴�
		
		// ������ ���� �Է� �޴´�
		
		Scanner input = new Scanner(System.in);
		// �ܼ� �Է��� ���� Scanner ��ü ����
		System.out.println("������ �Է��ϼ���.");
		
		String exp = input.nextLine();
		// �Է��� ������ ������ ���ڿ��� �޴´�.
		
		// �Է� ���� ������ ������ �������� ���ڿ� ��ū���� �и�����
		StringTokenizer st = new StringTokenizer(exp);
		// exp ���ڿ� ������ ���� ������ �������� ���ڿ� ��ū��� �и�
		// StringTokenizer�� �ι�° ���ڷ� �����ڸ� �� �� �ִµ� �����ϸ� �⺻���� �����̴�.
		
		// �и��� ��ū�� �ϳ��� ���鼭 ( �̸� ���ÿ� push
		// ) �̸� ���ÿ��� pop�Ѵ�
		
		Stack<String> stack = new Stack<>();
		
		while(st.hasMoreTokens()) {
			// ��ū�� �����ִ� ���� �ݺ��Ѵ�.
			// hasMoreElements()�� ����ص� �ȴ�
			
			String token = st.nextToken();
			
			// token�� ( �̸� stack�� push
			if(token.equals("(")) {
				stack.push("(");
			}
			// token�� ) �̸� stack���� pop
			else if(token.equals(")")) {
				if(stack.isEmpty()) {
					System.out.println("�߸��� ���Դϴ�.");
					return;
				}
				stack.pop();
			}
			// stack�� ���Ұ� �ϳ��� ���ٸ� �ݴ� ��ȣ�� ��Ī�Ǵ� ���� ��ȣ�� ���ٴ� �ǹ��̴�.
			// �̴� �߸��� ���̱� ������ �ٸ� ��ū�� �� �ʿ䰡 ����.
		}
		
		// ��� ��ū ó���� ������, �� ������ �߸��� ��ȣ�� �߰ߵ��� �ʾҴٸ�
		// ���α׷� �帧�� ������� �Դٴ� ���� �Ŀ� �߸��� ���� ���ų�, ���� ��ȣ�� �� ���� ����̴�
		
		if(stack.isEmpty() != true) {
			// ���� ��ȣ�� �� ���ٴ� �ǹ�
			System.out.println("�߸��� ���Դϴ�.");
			return;
		}
		
		System.out.println("��ȿ�� ���Դϴ�.");
	}

}
