package Lecture_210318;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;







public class TextConverterParsing extends JFrame implements ActionListener{

	private JButton convertBtn;
	private JButton cancelBtn;
	private JTextArea textIn;
	private JTextArea textOut;
	// ����� Ŭ���̾�Ʈ ID, SECRET�� �־�� ��
	private final String CLIENT_ID = "izMq4AIgO9e0TzBb0mbh";
	private final String CLIENT_SECRET = "fmlqAWB7fl";

	public TextConverterParsing() {
		this.setTitle("�ؽ�Ʈ ��ȯ");

		textIn = new JTextArea(10, 14);
		textOut = new JTextArea(10, 14);
		textIn.setLineWrap(true);
		textOut.setLineWrap(true);
		textOut.setEditable(false);

		JPanel textAreaPanel = new JPanel(new GridLayout(1, 2, 20, 20));
		textAreaPanel.add(textIn);
		textAreaPanel.add(textOut);

		convertBtn = new JButton("��ȯ");
		cancelBtn = new JButton("���");
		convertBtn.addActionListener(this);
		cancelBtn.addActionListener(this);


		JPanel btnPanel = new JPanel();
		btnPanel.add(convertBtn);
		btnPanel.add(cancelBtn);

		JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
		mainPanel.add(textAreaPanel, BorderLayout.CENTER);
		mainPanel.add(btnPanel, BorderLayout.SOUTH);

		this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		this.add(mainPanel);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new TextConverterParsing();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ��ȯ ��ư�� Ŭ���Ǿ��ٸ�
		// ���� textArea (textIn)�� text�� �о ����� ��ȯ�ϰ�
		// �� ����� ���� textArea (textOut)�� append�Ѵ�
		// ��� ��ư�� Ŭ�� �Ǿ��ٸ� ���� (textOut)�� �� ���ڿ��� ����

		if(e.getSource() == convertBtn)
		{
			String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
			String text = null;
			String str = textIn.getText();
	        try {
	            text = URLEncoder.encode(str, "UTF-8");
	        } catch (UnsupportedEncodingException uee) {
	            throw new RuntimeException("���ڵ� ����", uee);
	        }

	        Map<String, String> requestHeaders = new HashMap<>();
	        requestHeaders.put("X-Naver-Client-Id", CLIENT_ID);
	        requestHeaders.put("X-Naver-Client-Secret", CLIENT_SECRET);

	        
//	        result = result.substring(result.indexOf("translatedText") + "translatedText".length() + 3, result.indexOf("engineType") - 3);

	        String inString = post(apiURL, requestHeaders, text);
	        JSONParser jsonParser = new JSONParser();
	        try 
	        {
	        	JSONObject obj = (JSONObject) jsonParser.parse(inString);
	        	JSONObject objmessage = (JSONObject) obj.get("message");
	        	JSONObject objresult = (JSONObject) objmessage.get("result");
	        	String value = (String) objresult.get("translatedText");
	        	textOut.setText(value);
	        } catch (ParseException pe) {
	        	Logger.getLogger(TextConverterParsing.class.getName()).log(Level.SEVERE, null, pe);
	        }
		}
		else
		{
			textOut.setText("");
		}

	}



	private static String post(String apiUrl, Map<String, String> requestHeaders, String text){
		HttpURLConnection con = connect(apiUrl);
		String postParams = "source=ko&target=en&text=" + text; //�������: �ѱ��� (ko) -> �������: ���� (en)
		try {
			con.setRequestMethod("POST");
			for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}

			con.setDoOutput(true);
			try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
				wr.write(postParams.getBytes());
				wr.flush();
			}

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // ���� ����
				return readBody(con.getInputStream());
			} else {  // ���� ����
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API ��û�� ���� ����", e);
		} finally {
			con.disconnect();
		}
	}

	private static HttpURLConnection connect(String apiUrl){
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection)url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL�� �߸��Ǿ����ϴ�. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("������ �����߽��ϴ�. : " + apiUrl, e);
		}
	}

	private static String readBody(InputStream body){
		InputStreamReader streamReader = new InputStreamReader(body);

		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();

			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}

			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API ������ �дµ� �����߽��ϴ�.", e);
		}
	}


}
