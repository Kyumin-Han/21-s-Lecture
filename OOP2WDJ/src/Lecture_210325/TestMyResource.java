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
			System.out.println("정상 처리...");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			r.close();
		}
	}
	
	public static void test2() {
		// try with resource 절에 사용하려면 AutoCloseable을 implement하는 클래스이어야 한다
		try (MyResource r = new MyResource()) {

			System.out.println(r.getValue());
			System.out.println("정상 처리...");
		} catch(OutOfResourcesException e) {
			System.out.println(e.getMessage());
		}
	}
}
