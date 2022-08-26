package scannerstring.student;

import java.util.Scanner;

public class Calculator2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("연산자는 무조건 같은 것으로 사용할것! 에러 유발됨");

			System.out.print("숫자 연산자(+,-,*,/) 숫자 입력, ※종료방법 : 1. stop입력, 2. +,-,*,/ 연산자가 없으면 반복문 종료됨 ");

			String temp = sc.next().trim();// " 1+2+3 " -> "1+2+3"
			// temp = temp.trim();//"1+2+3"
			
			if(temp.equalsIgnoreCase("stop")) {
				//System.out.println("------ 프로그램 끝! ------");
				break;	//가장 가까운 반복문을 빠져나감
			}
			
			double result = 0;
			
			if (temp.contains("+")) {
				String[] temp2 = temp.split("\\+");// "1" "2" "3"
				/*
				// int num = Integer.valueOf(temp2[0]);
				int num = Integer.parseInt(temp2[0]);//"1" -> 1
				for (int j = 1; j < temp2.length; j++) {
					num = num + Integer.valueOf(temp2[j]);// 1+2+3
				}
				System.out.println(temp + " = " + num);
				*/
				
				//[문제] 주석처리한 소스 대신 메서드를 만들어 처리
				result = add(temp2);	//주소를 매개값으로 add()호출
				System.out.println(temp+ " = "+result);
			}
			
			else if (temp.contains("-")) {
				String[] temp2 = temp.split("\\-");
				
				/*
				// int num = Integer.valueOf(temp2[0]);
				int num = Integer.parseInt(temp2[0]);
				for (int j = 1; j < temp2.length; j++) {
					num -= Integer.valueOf(temp2[j]);
				}
				System.out.println(temp + " = " + num);
				*/
				
				//[문제] 주석처리한 소스 대신 메서드를 만들어 처리
				result = substract(temp2);	//주소를 매개값으로 substract()호출
				System.out.println(temp + " = " + result);
			}
			
			else if (temp.contains("*")) {
				String[] temp2 = temp.split("\\*");
				
				/*
				// int num = Integer.valueOf(temp2[0]);
				int num = Integer.parseInt(temp2[0]);
				for (int j = 1; j < temp2.length; j++) {
					num *= Integer.valueOf(temp2[j]);
				}
				System.out.println(temp + " = " + num);
				*/
				
				//[문제] 주석처리한 소스 대신 메서드를 만들어 처리
				result = multi(temp2);	//주소를 매개값으로 multi()호출
				System.out.println(temp + " = " + result);
			}
			
			else if (temp.contains("/")) {
				String[] temp2 = temp.split("/");
				
				/*
				// double num = Double.valueOf(temp2[0]);
				double num = Double.parseDouble(temp2[0]);
				for (int j = 1; j < temp2.length; j++) {
					num /= Double.valueOf(temp2[j]);
				}
				System.out.println(temp + " = " + num);
				*/
				
				//[문제] 주석처리한 소스 대신 메서드를 만들어 처리
				result = divide(temp2);	//주소를 매개값으로 divide()호출
				System.out.println(temp + " = " + result);
			}
			
			else {			// + - * / 문자가 없으면
				//System.out.println("------ 프로그램 끝! ------");
				break;
			}
		}//while문 끝
		
		System.out.println("------ 프로그램 끝! ------");
		
	}//main() 끝	= 프로그램의 끝
	
	static double add(String[] input) {	//""		더하기
		//★★result 초기화 주의
		/*
		double result = 0;
		
		for (int run = 0; run < input.length; run++) {		//0.0 + 1.0 + 2.0 + 3.0 = 6.0 		String[] 배열의 길이까지 반복 작업
			result = result + Double.parseDouble(input[run]);	//문자열을 실수로 변경 후 더함
		}
		*/
		double result = Double.parseDouble(input[0]);
		
		for (int run = 1; run < input.length; run++) {		//1.0 + 2.0 + 3.0 = 6.0 		String[] 배열의 길이까지 반복 작업
			result = result + Double.parseDouble(input[run]);	//문자열을 실수로 변경 후 더함
		}
		
		return result; 	//6.0
	}
	
	static double substract(String[] input) {		// 빼기
		//★★result 초기화 주의
		double result = Double.parseDouble(input[0]);	//"1" -> 1.0 			첫 숫자를 미리 대입(연산문제 방지)
		
		for(int i = 1; i < input.length; i++) {		// 1.0 - 2.0 - 3.0 = -4.0
			result -= Double.parseDouble(input[i]);		//문자열을 실수로 변경 후 더함
		}
		
		return result;	//-4.0
	}
	
	static double multi(String[] input) {			// 곱하기
		//★★result 초기화 주의
		/*
		double result = 1;	//1 -> 1.0 		곱하기는 초기값을 1			첫 숫자를 미리 대입(연산문제 방지)
		
		for(int i = 0; i < input.length;i++) {	// 1 * 1.0 * 2.0 * 3.0 = 6.0
			result *= Double.parseDouble(input[i]);		//문자열을 실수로 변경 후 더함
		}
		*/
		double result = Double.parseDouble(input[0]);
		
		for(int i = 1; i < input.length; i++) {		// 1 * 1.0 * 2.0 * 3.0 = 6.0
			result *= Double.parseDouble(input[i]);	//문자열을 실수로 변경 후 더함
		}
		
		return result;	//6.0
	}
	
	static double divide(String[] input) {			// 나누기
		//★★result 초기화 주의
		double result = Double.parseDouble(input[0]);	// 첫 숫자를 미리 대입(연산문제 방지)
		
		for(int i = 1; i < input.length;i++) {	// 1.0 / 2.0 / 3.0 = 0.16666666666666666
			result /= Double.parseDouble(input[i]);	//문자열을 실수로 변경 후 더함
		}
		
		return result;	//0.16666666666666666
	}

}
