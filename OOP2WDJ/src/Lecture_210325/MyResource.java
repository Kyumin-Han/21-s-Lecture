package Lecture_210325;

public class MyResource implements AutoCloseable {

	public MyResource() {
		System.out.println("MyResource ����");
	}
	
	public int getValue() throws OutOfResourcesException {
		int random = (int)(Math.random()*2);
		if(random == 0)
		{
			// �����ڰ� ���ܸ� �߻���ų���� throw new Exception�� ���� ���Ƿ� ���ܸ� �߻� ��ų �� �ִ�
			// ���� �̸��� ���� ����� ���� �ִ�(Ŭ������ ����)
			throw new OutOfResourcesException("�ڿ� �� ����");
		}
		return (int)(Math.random()*100);
	}
	
	public void close() {
		System.out.println("close... �ڿ� �ݳ�");
	}

}
