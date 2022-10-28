package format;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Test2 {

	public static void main(String[] args) throws ParseException {
		
		int num = 128000;
		DecimalFormat df = new DecimalFormat("#,###원");
		String sNum = df.format(num);
		System.out.println(sNum);
		
		int oriNum = df.parse(sNum).intValue();
		System.out.println(oriNum);
		
		
		
	}

}
