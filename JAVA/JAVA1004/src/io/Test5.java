package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Test5 {

	public static void main(String[] args) {
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); OutputStream os = System.out;) {
			os.write(br.readLine().getBytes());
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
