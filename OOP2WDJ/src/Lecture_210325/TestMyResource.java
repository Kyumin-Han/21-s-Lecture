package Lecture_210325;

public class TestMyResource {

	public static void main(String[] args) {
//		test1();
		test2();
	}

	public static void test1() {
		MyResource r = new MyResource();

		try {

			System.out.println(r.getValue());
			System.out.println("���� ó��...");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			r.close();
		}
	}
	
	public static void test2() {
		// try with resource ���� ����Ϸ��� AutoCloseable�� implement�ϴ� Ŭ�����̾�� �Ѵ�
		try (MyResource r = new MyResource()) {

			System.out.println(r.getValue());
			System.out.println("���� ó��...");
		} catch(OutOfResourcesException e) {
			System.out.println(e.getMessage());
		}
	}
}
