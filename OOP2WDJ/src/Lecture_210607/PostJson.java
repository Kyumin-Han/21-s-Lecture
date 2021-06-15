package Lecture_210607;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.google.gson.Gson;

public class PostJson {

	public static void main(String[] args) throws Exception {
		Gson gson = new Gson();

		String site = "https://jsonplaceholder.typicode.com/posts";
		
		// ����
		// ����� �Է½�Ʈ������ �޾Ƽ� ���ڿ��� ����
		// ����� ���ڿ��κ��� �ڹ� ��ü ����
		
		// �ڹ� ��ü�� �̿��ؼ� �������� ó���� �� �� �հԵȴ�.
		// �������, DB�� ���� �� ���� �ִ�.
		
		URL url = new URL(site);
		
		URLConnection con = url.openConnection();
		
		InputStream stream = con.getInputStream();
		
		InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
		
		BufferedReader bufReader = new BufferedReader(reader);
	
		String line = null;
		String jsonString = "";
		while((line = bufReader.readLine()) != null) {
//			System.out.println(line);
			jsonString += line;
		}
		
//		String json = "{'userId': 1, 'id': 1, 'title': 'test', 'body': 'test body'}, {'userId': 2, 'id': 2, 'title': 'test2', 'body': 'test body2'}";
		Post[] posts = gson.fromJson(jsonString, Post[].class);
		
//		System.out.println(post.getUserId());
//		System.out.println(post.getId());
//		System.out.println(post.getTitle());
//		System.out.println(post.getBody());
		
		for(Post post : posts) {
			System.out.println(post.getUserId());
			System.out.println(post.getId());
			System.out.println(post.getTitle());
			System.out.println(post.getBody());
			System.out.println("################");
		}
		
		insertIntoDB(posts);
	}
	
	private static void insertIntoDB(Post[] posts) throws Exception {
		// 1. Class.forName(...);���� JDBC ����̹� �޸𸮿� ����
		// 2. Connection con = DriverManager.getConnection(...); �� DB ������ ����
		// 3. String sql = "inserrt into posts(userId, id, title, body) valsue(?, ?, ?, ?);
		//    con.perpareStatement(sql);
		//    PreparedStatement pstmt = con.prepareStatement(sql);
		// 4. ? �ڸ��� �� ���� pstmt�� �˸��� set �޼ҵ带 �̿��Ͽ� �������ش�
		// 5. pstmt.executeUpdate();
		// 6. con.close();
		
		Class.forName("org.mariadb.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/oop";
		String id = "root";
		String pwd = "110419";
		Connection con = DriverManager.getConnection(url, id, pwd);
		
		String sql = "insert into posts(userId, id, title, body) values(?, ?, ?, ?)";
		PreparedStatement pstmt =con.prepareStatement(sql);
		
		for(Post post : posts) {
			pstmt.setInt(1,  post.getUserId());
			pstmt.setInt(2, post.getId());
			pstmt.setString(3, post.getTitle());
			pstmt.setString(4, post.getBody());
			pstmt.executeUpdate();
		}
		
		con.close();
	}

}
