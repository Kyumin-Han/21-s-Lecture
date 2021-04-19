package Leture_210415;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class PritorityQueueTest {

	public static void main(String[] args) {
//		test1();
		
		MyQueue queue = new MyQueue();
		queue.offer(new Task("�۾�1", 3));
		queue.offer(new Task("�۾�2", 2));
		queue.offer(new Task("�۾�3", 5));
		queue.offer(new Task("�۾�4", 1));
		queue.offer(new Task("�۾�5", 4));
		for(int i = 0; i < 5; i++) {
			System.out.println(queue.poll());
		}
	}
	
	private static void test1() {
		// ���� ������ �� ������ ��ü�� ����� Ŭ������ �ָ� Comparable�� �̿��ѰͰ� �Ȱ��� �����Ѵ�
		// Comparable �������̽��� ������ Ŭ�������� ���� �����Ͽ� �켱���� ť�� ������ �� ���� �������ִ� ���� �켱������ �� ����
//		Queue<Task> queue = new PriorityQueue<>(new TaskComparator());
		Queue<Task> queue = new PriorityQueue<>();
		
		// �켱���� ť�� �켱������ ������ �־�� �ϴµ� �⺻������ ��� �켱������ ���ϴ��� ������ ���� �ʱ� ������
		// ��Ÿ�� ������ �߻��ϱ� ������
		// comparable�� �̿��� ��ü�� �� ������ ��ü�� ������ش�
		
		// �켱���� ť�� �⺻������ ������������ ����ȴ�
		queue.offer(new Task("�۾�1", 3));
		queue.offer(new Task("�۾�2", 2));
		queue.offer(new Task("�۾�3", 5));
		queue.offer(new Task("�۾�4", 1));
		queue.offer(new Task("�۾�5", 4));
		
		// ����� ���� ���
		while(queue.isEmpty() == false) {
			Task task = queue.poll();
			
			System.out.println(task);
		}
	}

}

class Task implements Comparable<Task>{
	String desc;
	int priority;
	
	public Task(String desc, int priority) {
		this.desc = desc;
		this.priority = priority; // �۾��� �켱����
	}

	@Override
	public int compareTo(Task o) {
		// �� ��ü�� ���� ũ�� ���, ������ 0, ������ ������ ��ȯ�Ѵ�
		return this.priority - o.priority;
	}
	
	// toString �޼ҵ带 �����ؼ� ���� ����� �� �� �ְ� �Ѵ�
	@Override
	public String toString() {
		return "[desc: " + desc + ", priority: " + priority + "]";
	}
	
	
	
	
}

class TaskComparator implements Comparator<Task> {

	@Override
	public int compare(Task o1, Task o2) {
		return o1.priority - o2.priority;
	}
	
}

class MyQueue {
	Task[] tasks = new Task[10];
	int idx = 0;
	int pidx = 0;
	
	public void offer(Task value) {
		tasks[idx++] = value;
		
		// ���ο� ��ü�� ���� ������ �������ķ� sorting�Ѵ�
		for(int i = idx - 1; i >= 0; i--) {
			int max = i; 
			// ���� ������ ���Ұ� �ִ��̶� ����
			
			for(int j = 0; j < i; j++) {
				if(tasks[j].compareTo(tasks[max]) > 0) {
					max = j;
				}
			}
			
			// max, i�� swap
			Task tmp = tasks[max];
			tasks[max] = tasks[i];
			tasks[i] = tmp;
		}
	}
	
	public Task poll() {
		return tasks[pidx++];
	}
}