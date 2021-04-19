package Leture_210415;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class PritorityQueueTest {

	public static void main(String[] args) {
//		test1();
		
		MyQueue queue = new MyQueue();
		queue.offer(new Task("작업1", 3));
		queue.offer(new Task("작업2", 2));
		queue.offer(new Task("작업3", 5));
		queue.offer(new Task("작업4", 1));
		queue.offer(new Task("작업5", 4));
		for(int i = 0; i < 5; i++) {
			System.out.println(queue.poll());
		}
	}
	
	private static void test1() {
		// 직접 생성한 비교 가능한 객체로 만드는 클래스를 주면 Comparable을 이용한것과 똑같이 동작한다
		// Comparable 인터페이스를 구현한 클래스보다 직접 생성하여 우선순위 큐를 생성할 때 같이 생성해주는 것이 우선순위가 더 높다
//		Queue<Task> queue = new PriorityQueue<>(new TaskComparator());
		Queue<Task> queue = new PriorityQueue<>();
		
		// 우선순위 큐는 우선순위를 지정해 주어야 하는데 기본적으로 어떻게 우선순위를 정하는지 정해져 있지 않기 때문에
		// 런타임 에러가 발생하기 때문에
		// comparable을 이용해 객체를 비교 가능한 객체로 만들어준다
		
		// 우선순위 큐는 기본적으로 오름차순으로 인출된다
		queue.offer(new Task("작업1", 3));
		queue.offer(new Task("작업2", 2));
		queue.offer(new Task("작업3", 5));
		queue.offer(new Task("작업4", 1));
		queue.offer(new Task("작업5", 4));
		
		// 저장된 값을 출력
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
		this.priority = priority; // 작업의 우선순위
	}

	@Override
	public int compareTo(Task o) {
		// 이 객체의 값이 크면 양수, 같으면 0, 작으면 음수를 반환한다
		return this.priority - o.priority;
	}
	
	// toString 메소드를 구현해서 값을 출력해 볼 수 있게 한다
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
		
		// 새로운 객체가 들어올 때마다 선택정렬로 sorting한다
		for(int i = idx - 1; i >= 0; i--) {
			int max = i; 
			// 제일 마지막 원소가 최댓값이라 가정
			
			for(int j = 0; j < i; j++) {
				if(tasks[j].compareTo(tasks[max]) > 0) {
					max = j;
				}
			}
			
			// max, i를 swap
			Task tmp = tasks[max];
			tasks[max] = tasks[i];
			tasks[i] = tmp;
		}
	}
	
	public Task poll() {
		return tasks[pidx++];
	}
}