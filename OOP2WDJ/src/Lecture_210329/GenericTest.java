package Lecture_210329;

public class GenericTest {

	public static void main(String[] args) {
		// generic은 객체를 생성할 때 타입을 지정해준다
		GenericBox<String> box1 = new GenericBox<String>();
		
		box1.setContent("동해물과");
//		box1.setContent(100); 오류
		String s = box1.getContent();
		System.out.println(s);
		
		GenericBox<Integer> box2 = new GenericBox<Integer>();
		box2.setContent(100);
		int n = box2.getContent();
		
		GenericBox<Student> box3 = new GenericBox<Student>();
		box3.setContent(new Student());

	}

}
