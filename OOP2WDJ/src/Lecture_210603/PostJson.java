package Lecture_210603;

import com.google.gson.Gson;

public class PostJson {

	public static void main(String[] args) throws Exception {
		Gson gson = new Gson();

		String site = "https://jsonplaceholder.typicode.com/posts";
		
		// 연결
		// 결과를 입력스트림으로 받아서 문자열로 저장
		// 저장된 문자열로부터 자바 객체 생성
		
		// 자바 객체를 이용해서 여러가지 처리를 할 수 잇게된다.
		// 예를들어, DB에 저장 할 수도 있다.
	}

}
