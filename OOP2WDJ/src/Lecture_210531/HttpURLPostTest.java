package Lecture_210531;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLPostTest {

	public static void main(String[] args) throws Exception {
		String site = "http://localhost:9090/todos";
		URL url = new URL(site);
		
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		
		con.setDoInput(true);
		con.setDoOutput(true);
		con.setRequestMethod("POST");
		con.setRequestProperty("content-type", "application/x-www-form-urlencoded");
		
		String data = "id=kmhan&pw=1111";
		
		OutputStream ostream = con.getOutputStream();
		
		OutputStreamWriter owriter = new OutputStreamWriter(ostream, "UTF-8");
		
		PrintWriter writer = new PrintWriter(owriter);
		
		writer.println(data);
		writer.flush();

		InputStream stream = con.getInputStream();
		
		InputStreamReader streamReader = new InputStreamReader(stream);
		
		BufferedReader reader = new BufferedReader(streamReader);
		
		String line;
		
		while((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		System.out.println();
	}

}
