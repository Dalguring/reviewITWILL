package util;

import java.util.StringTokenizer;

public class Test1 {

	public static void main(String[] args) {
		
		String data = "Address:부산광역시 부산진구 동천로109,Floor:7층,Tel:051-803-0909";
		StringTokenizer st = new StringTokenizer(data, ",");
		while(st.hasMoreTokens()) {
			StringTokenizer st2 = new StringTokenizer(st.nextToken(), ":");
			st2.nextToken();
			System.out.println(st2.nextToken());
		}
		
	}

}
