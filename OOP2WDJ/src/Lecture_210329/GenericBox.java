package Lecture_210329;

public class GenericBox<T> {
	private T content;
//	private int size;

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}
}
