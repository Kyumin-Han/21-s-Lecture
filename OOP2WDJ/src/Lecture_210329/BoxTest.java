package Lecture_210329;

public class BoxTest {

	public static void main(String[] args) {
//		Box box = new Box();
//		
//		box.setContent("���ع��� ��λ���");
//		
//		String cont = box.getContent();
//		
//		System.out.println(cont);
		
//		Box2 box2 = new Box2();
//		box2.setContent(100);
//		
//		int count2 = box2.getContent();
//		System.out.println(count2);
		
//		Box3 box3 = new Box3();
//		Student std = new Student();
//		std.setName("ȫ�浿");
//		std.setDept("����");
//		std.setGrade(100);
//		box3.setContent(std);
//		std = box3.getContent();
//		
//		System.out.println(std.getName() + " : " std.getDept());
		
		Box4 box = new Box4();
		box.setContent(new Student());
		box.setContent(100);
		box.setContent("������ �⵵��");
	}

}
