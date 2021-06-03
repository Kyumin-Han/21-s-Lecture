package Lecture_210531;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Host2InetAddr {
	public static void main(String[] args) {
		String hostName = "www.naver.com";
		
		try {
			InetAddress address = InetAddress.getByName(hostName);
			System.out.println("IP �ּ� : " + address.getHostAddress());
		} catch (UnknownHostException e) {
			System.err.println(e.getMessage());
		}
	}
}
