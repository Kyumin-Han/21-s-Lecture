package Lecture_210325;

public class MyResource implements AutoCloseable {

	public MyResource() {
		System.out.println("MyResource 생성");
	}
	
	public int getValue() throws OutOfResourcesException {
		int random = (int)(Math.random()*2);
		if(random == 0)
		{
			// 개발자가 예외를 발생시킬때는 throw new Exception을 통해 임의로 예외를 발생 시킬 수 있다
			// 예외 이름을 만들어서 사용할 수도 있다(클래스를 만들어서)
			throw new OutOfResourcesException("자원 고갈 오류");
		}
		return (int)(Math.random()*100);
	}
	
	public void close() {
		System.out.println("close... 자원 반납");
	}

}
