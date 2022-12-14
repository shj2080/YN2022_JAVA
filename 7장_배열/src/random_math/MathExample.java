package random_math;

import java.util.Arrays;

public class MathExample {

	public static void main(String[] args) {
		//절대값 : 음수/양수 -> 무조건 양수
		int v1 = Math.abs(-5);		// |-5| => 5
		System.out.println("|-5|=>" + v1);
		
		double v2 = Math.abs(-3.14);		// |-3.14| => 3.14
		System.out.println("|-3.14|=>" + v2);
		
		//ceil() : 보다 큰 정수를 double형으로 반환
		System.out.println(Math.ceil(5.3));//6.0
		System.out.println(Math.ceil(-5.3));//-5.0
		
		//floor() : 보다 작은 정수를 double형으로 반환
		System.out.println(Math.floor(5.3));		//5.0
		System.out.println(Math.floor(-5.3));	//-6.0
		
		//rint() : 가까운 정수를 실수값
		System.out.println(Math.rint(5.3));		//5.0
		System.out.println(Math.rint(-5.3));	//-5.0
		
		//max(값1, 값2) : 두 수 중 큰 값을 반환
		System.out.println(Math.max(5, 3));			//5
		System.out.println(Math.max(5.3, 3.7));		//5.3

		//min(값1, 값2) : 두 수 중 작은 값을 반환
		System.out.println(Math.min(5, 3));			//3
		System.out.println(Math.min(5.3, 3.7));		//3.7
		
		//pow(a, b) : a의 b승
		System.out.println(Math.pow(5, 3)); 		//5의 3승 = 5 * 5 * 5 = 125.0
		
		//sqrt(수) : 루트
		System.out.println(Math.sqrt(25));   		//루트25 => 5
		
		/**
		 * random() : 난수 발생
		 * 0.0 <= Math.random() < 1.0 실수값   (예:0.00000123, 0.1)
		 * 
		 * 1~6사이의 난수
		 * 0.0 <= 	  Math.random() *6 			< 6.0		실수값	 (예:5.1234)
		 * 0   <= (int)(Math.random() * 6)		< 6			정수값	 (예:0~5사이의 정수값)
		 * 0+1 <= (int)(Math.random() * 6)+1	< 6+1		정수값	 (예:1~6사이의 정수값)
		 * 
		 * ★★ 시작~끝 사이의 난수 발생
		 * (int)(Math.random() * (끝-시작+1개)) + 시작
		 */
		
		//random() : 난수 발생
		System.out.println(Math.random());
		
		//1~6 난수 생성 (int)(Math.random() * (끝-시작+1)) + 시작
		System.out.println((int)(Math.random() * (6-1+1)) + 1);
		
		//88~110 난수 생성
		System.out.println((int)(Math.random() * (110 - 88 + 1)) + 88);
		
		//알파벳을 랜덤하게 발생시키고 싶다면(대문자:A(=65)~Z까지 26개, 소문자:a(=97)~z까지 26개)
		
		char[] arr1 = new char[10];	//['\0','\0',..,'\0'] -> 랜덤으로 대문자로
		char[] arr2 = new char[10];	//['\0','\0',..,'\0'] -> 랜덤으로 소문자로
		
		int i;
				
		for(i = 0; i < arr1.length; i++) {
			arr1[i] = (char)((int)(Math.random() * 26) + 65);//(char)65~90 => 대문자
			
			double dValue = Math.random(); // 변수 저장 후
			arr2[i] = (char)((int)(dValue * 26) + 97);//(char)97~122 => 소문자
		}
				
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
	}

}
