package Lecture_210329;

public class GenericTest {

	public static void main(String[] args) {
		// generic�� ��ü�� ������ �� Ÿ���� �������ش�
		GenericBox<String> box1 = new GenericBox<String>();
		
		box1.setContent("���ع���");
//		box1.setContent(100); ����
		String s = box1.getContent();
		System.out.println(s);
		
		GenericBox<Integer> box2 = new GenericBox<Integer>();
		box2.setContent(100);
		int n = box2.getContent();
		
		GenericBox<Student> box3 = new GenericBox<Student>();
		box3.setContent(new Student());

	}

}
