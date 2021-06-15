package Lecture_210603;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

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
		while((line = bufReader.readLine()) != null) {
			System.out.println(line);
		}
		
		
	}

}
