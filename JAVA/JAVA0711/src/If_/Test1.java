package If_;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		int num1 = 0, num2 = 0;
		char ch = 'a';
		System.out.println("===============1=============");
		if (num1>0) {
			System.out.println("양수");
		} else if (num1<0) {
			System.out.println("음수");
		} else {
			System.out.println("0");
		}
		System.out.println("===============2=============");
		if (num2%2==1) {
			System.out.println("홀수");
		} else if (num2!=0 && num2%2==0) {
			System.out.println("짝수");
		} else {
			System.out.println("0");
		}
		System.out.println("===============3=============");
		if (ch >= 'A' && ch <= 'Z') {
			System.out.println(ch+=32);
		} else if (ch >= 'a' && ch <= 'z') {
			System.out.println(ch-=32);
		} else {
			System.out.println("ch는 영문자가 아닙니다!");
		}
		System.out.println("=============================");
		Scanner sc = new Scanner(System.in);
		
		int score = sc.nextInt(); String grade = "";
//		if 		(score >= 90) grade = "A학점";
//		else if (score >= 80) grade = "B학점"; 
//		else if (score >= 70) grade = "C학점";
//		else if (score >= 60) grade = "D학점";
//		else 				  grade = "F학점";
		grade = score >= 90 ? "A" : 
				score >= 80 ? "B" :
				score >= 70 ? "C" :
				score >= 60 ? "D" : "F";
		
		grade += "학점"; 
		System.out.println(grade);
	
	
	}	
		
}
