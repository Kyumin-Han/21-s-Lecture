package Lecture_210318;

public class SubString {

	public static void main(String[] args) {
		String s = "���ع��� ��λ��� ������ �⵵�� �ϴ����� �����ϻ� �츮���� ����";
		
//		for(int i = 0; i < s.length(); i++)
//		{
//			System.out.print(s.charAt(i));
//		}
		
		// �ش� ���ڿ��� �����ϴ� ��ġ�� index�� ��ȯ�Ѵ�
		int idx = s.indexOf("��λ�");
//		System.out.println(idx);
		
		// substring�� ���� �ε����� �ָ� �� �ε������� �����ؼ� �������� ���ڿ��� ��ȯ�ϰ�
		// ���۰� ���� �ε����� �ָ� ���� �ε��� - 1������ ���ڿ��� ��ȯ�Ѵ�
		String subs = s.substring(idx, idx + "��λ�".length());
		System.out.println(subs);
		
		subs = s.substring(idx, s.indexOf("������"));
		System.out.println("[" + subs + "]");
	}

}
