package study_check;

import java.util.Arrays;
import java.util.Scanner;

public class studentHomework0704 {

	public static void main(String[] args) {
		/*
		 * 0704 [과제-1] 다른 학생 파트
		*/
		char[] arr = { 'J', 'A', 'V', 'A' };
		Scanner sc = new Scanner(System.in);
		int i;
		
		System.out.println("--- 방법-1 --------------");
		char value;
		int size = 0;

		System.out.print("새로운 배열의 크기 입력>");
		size = sc.nextInt();
		char[] arr5 = new char[size];
		//1.size가 원본배열의 크기보다 작으면 부분배열 생성,
		//2.size가 원본배열의 크기보다 크면 원본보다 큰 배열이 생성되므로 for문에서 입력가능
		arr5 = Arrays.copyOfRange(arr, 0, size);
		
		System.out.println("arr배열이 대입된 새로운 배열 : " + Arrays.toString(arr5));
		
		for (i = 4; i < arr5.length; i++) {		//i = 4(중요)
			System.out.print(i + "번째 index 값을 char로 입력하세요>");
			value = sc.next().charAt(0);
			arr5[i] = value;
		}
		System.out.println("완성된 arrr배열은? : " + Arrays.toString(arr5));

	}

}
