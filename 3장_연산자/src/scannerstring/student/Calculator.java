package scannerstring.student;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("연산자는 무조건 같은 것으로 사용할것! 에러 유발됨");

			System.out.print("숫자 연산자(+,-,*,/) 숫자 입력, ※종료방법 : 1. stop입력, 2. +,-,*,/ 연산자가 없으면 반복문 종료됨 ");

			String temp = sc.next().trim();// " 1+2+3 " -> "1+2+3"
			// temp = temp.trim();//"1+2+3"
			
			if(temp.equalsIgnoreCase("stop")) {
				System.out.println("------ 프로그램 끝! ------");
				break;
			}
			
			if (temp.contains("+")) {
				String[] temp2 = temp.split("\\+");// "1" "2" "3"
				// int num = Integer.valueOf(temp2[0]);
				int num = Integer.parseInt(temp2[0]);//"1" -> 1
				for (int j = 1; j < temp2.length; j++) {
					num = num + Integer.valueOf(temp2[j]);// 1+2+3
				}
				System.out.println(temp + " = " + num);
			}
			
			else if (temp.contains("-")) {
				String[] temp2 = temp.split("\\-");
				// int num = Integer.valueOf(temp2[0]);
				int num = Integer.parseInt(temp2[0]);
				for (int j = 1; j < temp2.length; j++) {
					num -= Integer.valueOf(temp2[j]);
				}
				System.out.println(temp + " = " + num);
			}
			
			else if (temp.contains("*")) {
				String[] temp2 = temp.split("\\*");
				// int num = Integer.valueOf(temp2[0]);
				int num = Integer.parseInt(temp2[0]);
				for (int j = 1; j < temp2.length; j++) {
					num *= Integer.valueOf(temp2[j]);
				}
				System.out.println(temp + " = " + num);
			}
			
			else if (temp.contains("/")) {
				String[] temp2 = temp.split("/");
				// double num = Double.valueOf(temp2[0]);
				double num = Double.parseDouble(temp2[0]);
				for (int j = 1; j < temp2.length; j++) {
					num /= Double.valueOf(temp2[j]);
				}
				System.out.println(temp + " = " + num);
			}
			
			else {// + - * / 문자가 없으면
				System.out.println("------ 프로그램 끝! ------");
				break;
			}
		}

	}

}
