package io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * 키보드로부터 데이터를 입력받아 처리하는 방법
		 * 3. InputStreamReader 객체를 사용하여 char 단위로 입력데이터를 처리하는 방법
		 * 		- InputStream 객체를 파라미터로 갖는 InputStreamReader 객체 생성
		 * 		- read() 메서드를 호출하여 입력데이터를 char단위(2Byte)만큼 읽어와서 저장
		 * 		- 아무리 많은 데이터가 입력되어도 2Byte(char) 만큼만 다룰 수 있기 때문에
		 * 		  더 많은 데이터나 더 큰 단위 처리가 불가능
		 * 		- InputStream 보다는 유용하지만, 여전히 낮은 수준의 입력 처리 방식
		 */
		
		// 1. System.in을 사용하여 입력스트림 가져오기
//		InputStream is = System.in;
		// 2. InputStreamReader 객체 생성 => 파라미터로 InputStream 객체를 전달
//		InputStreamReader reader = new InputStreamReader(is);
		
		// ------------- 위의 문법을 한 문장으로 결합 ----------------
//		InputStreamReader reader = new InputStreamReader(System.in);
		
//		System.out.println("데이터를 입력하세요.");
//		try(InputStreamReader reader = new InputStreamReader(System.in);) {
//			
//			int n = reader.read();
//			System.out.println("입력된 데이터 : " + (char)n);
//			
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
		
		/*
		 * 키보드로부터 데이터를 입력받아 처리하는 방법
		 * 4. InputStreamReader 객체를 사용하여 char단위로 읽어온 데이터를
		 * 	  배열을 사용하여 한번에 여러 문자로 모아서 처리하는 방법
		 */
		System.out.println("데이터를 입력하세요.");
		
		try(InputStreamReader reader = new InputStreamReader(System.in)) {
			
			// 여러개의 char 단위 데이터를 저장할 char[] 배열 생성
			char[] chArr = new char[10];
			
			int n = reader.read(chArr);
			
			System.out.println("입력데이터(문자열) : " + new String(chArr));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
