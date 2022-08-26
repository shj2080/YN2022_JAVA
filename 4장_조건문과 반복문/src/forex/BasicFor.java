package forex;

import java.util.Scanner;

public class BasicFor {

	public static void main(String[] args) {
		/** 1. 반복문을 사용안하면 **/
		System.out.println("지금 이순간 최선을...");
		System.out.println("지금 이순간 최선을...");
		System.out.println("지금 이순간 최선을...");
		System.out.println("지금 이순간 최선을...");
		System.out.println("지금 이순간 최선을...");
		
		System.out.println(); //구분용 빈줄
		
		/**
		 * ★★ '같은 실행문'이거나 '일정한 규칙성'이 있어야 반복문을 사용할 수 있다.
		 */
		
		/** 1. 반복문을 사용하면 : 카운터 변수 **/
		/**
		 * for(1.변수선언 및 초기화(한번만) ; 2.조건문; 4.변수증가/감소 -> 2) {
		 * 	3. 조건문이 참이면 실행
		 * }
		 * 3. 조건문이 거짓이면 for문을 빠져나옴(=반복문 끝)
		 */
		
		//※변수 i를 카운터 변수로만 사용한다면 초기값은 어떤 정수라도 가능함
		int i;	//카운터 변수 1 2 3 4 5 <= 5(참), 6 <= 5(거짓)
		for(i=1 ; i <= 5 ; i++) {
			System.out.println("지금 이순간 최선을...");
		}
		System.out.println("거짓이 되어 for문 빠져나올 때의 i=" + i);
		System.out.println(); // 구분용 빈줄
		
		// 카운터 변수 0 1 2 3 4 <= 4(참), 5 <= 4(거짓)
		for(i=0;i <= 4;i++) {
			System.out.println("지금 이순간 최선을...");
		}
		System.out.println("거짓이 되어 for문 빠져나올 때의 i=" + i + "\n");	// 구분용 빈줄
		
		// 카운터 변수 5 4 3 2 1 >= 1(참), 0 >= 1(거짓)
		for(i=5; i >= 1;i--) {
			System.out.println("지금 이순간 최선을...");
		}
		System.out.println("거짓이 되어 for문 빠져나올 때의 i=" + i + "\n");	// 구분용 빈줄

		// 카운터 변수 1 4 7 10 13 <= 13(참), 16 <= 13(거짓)
		for(i=1; i <= 13; i += 3) {
			System.out.println("지금 이순간 최선을...");
		}
		System.out.println("거짓이 되어 for문 빠져나올 때의 i=" + i + "\n");	// 구분용 빈줄
					
		/**
		 * 반복문 : for문(배열에서 많이 사용), while문, do~while문(적어도 한번은 실행)
		 */
		
		// 카운터 변수 -3 -1 1 3 5 <= 5(참), 7 <= 5(거짓)
		i = -3;//최초에 1번만 초기화
		for( ; i <= 5 ; ) {	//조건문 생략하면 true와 같다.
			System.out.println("지금 이순간 최선을...");
			i += 2;
		}
		System.out.println("거짓이 되어 for문 빠져나올 때의 i=" + i + "\n");	// 구분용 빈줄
		
		//while 문
		i = -3;
		while(i <= 5) {		// (조건문 참일 동안 반복) 조건문 생략 불가 (=>for문과 다른점)
			System.out.println("지금 이순간 최선을...");
			i += 2;
		}
		System.out.println("거짓이 되어 for문 빠져나올 때의 i=" + i + "\n");	// 구분용 빈줄
		
		//do ~ while 문
		i = -3;
		do {
			System.out.println("지금 이순간 최선을...");
			i += 2;
		} while(i <= 5);	// (조건문이 아래에 있으므로 참거짓에 관계없이 무조건 한번은 실행) (=>for문,while문과 다른점)
		System.out.println("거짓이 되어 for문 빠져나올 때의 i=" + i + "\n");	// 구분용 빈줄
		
		/** 2. 반복문을 사용 안하면 **/
		System.out.print(1+ " ");
		System.out.print(2+ " ");
		System.out.print(3+ " ");
		System.out.print(4+ " ");
		System.out.print(5+ " ");
		
		System.out.println(); 	//커서를 아래로
		
		/** 2. 반복문을 사용하면 : i(카운터 변수+반복문의 실행문) **/
		for(i = 1; i <= 5; i++) {		// 가장 많이 사용하는 방식
			System.out.print(i + " ");
		}
		System.out.println(); 	//커서를 아래로

		for(i = 0; i <= 4; i++) { //i 0 1 2 3 4
			System.out.print((i+1) + " "); //1 2 3 4 5
		}
		System.out.println(); 	//커서를 아래로
		
		int j;
		for(i = 1, j = 0; i <= 9; i+=2, j++) { //i 1 3 5 7 9,  j=0 1 2 3 4
			System.out.print((i-j) + " "); //1 2 3 4 5
		}
		System.out.println(); 	//커서를 아래로
		
		//-10 -> -9 -> .. -6 까지 출력 (1씩 증가)
		for(i = -10; i <= -6 ; i++) {
			System.out.println(i+ " ");
		}
		System.out.println(); 	//커서를 아래로
		
		/** 3.반복문을 사용 안하여 1+2+3+4+...+10 합 출력 ? **/
		int hap = 1+2+3+4+5+6+7+8+9+10;
		System.out.println("[반복문 사용안함]1~10까지 합계=" + hap);//55
		
		/** 3.반복문을 사용하여 1+2+3+4+...+10 합 출력 ? **/
		hap = 0; 	//반드시 0으로 초기화
		for(i = 1; i<=10 ;i++) {		//10번 반복(i = 1 -> 2...9->10(참) ->11(거짓)
			hap = hap + i; // 0+1+2+3...+9+10
		}
		System.out.println("[반복문 사용함]1~10까지 합계=" + hap);//55
		
		//0~10 사이의 수 중 짝수의 합 = ?
		hap = 0; 	//반드시 0으로 초기화
		for(i = 0; i <= 10;i += 2) { //i=0->2->4->6->8->10(참) -> 12(거짓)
			hap = hap + i;	//0 + 0
		}
		System.out.println("[i값 2증가]0~10사이의 짝수의 합계=" + hap); //30
	
		//0~10 사이의 수 중 홀수의 합 = ?
		hap = 0; 	//반드시 0으로 초기화
		for(i = 1; i < 10;i += 2) { //i=1->3->5->7->9(참) -> 11(거짓)
			hap = hap + i;	//0 + 1
		}
		System.out.println("[i값 2증가]0~10사이의 홀수의 합계=" + hap); //25
		
		//0~10 사이의 수 중 짝수의 합 = ?
		hap = 0; 	//반드시 0으로 초기화
		for(i = 0; i <= 10;i++) { //i=0->1->2->...10(참) -> 11(거짓)
			//조건 : i가 짝수일 때만 실행, 짝수가 아니면 실행X
			//i를 2로 나눈 나머지가 0과 같다면 짝수
			if(i % 2 == 0) hap = hap + i; //i 0 2 4 6 8 10
		}
		System.out.println("[if문 이용]0~10사이의 짝수의 합계=" + hap);	//30
		
		//0~10 사이의 수 중 홀수의 합 = ?
		hap = 0; 	//반드시 0으로 초기화
		for(i = 0; i <= 10;i++) { //i=0->1->2->...10(참) -> 11(거짓)
			//조건 : i가 홀수일 때만 실행, 홀수가 아니면 실행X
			//i를 2로 나눈 나머지가 1과 같다면 홀수
			if(i % 2 == 1) hap = hap + i; //i 1 3 5 7 9
		}
		System.out.println("[if문 이용]0~10사이의 홀수의 합계=" + hap); // 25
		
		/** 1~입력받은 수까지 더한 결과 **/
		Scanner sc = new Scanner(System.in);
		System.out.print("1~입력받은 정수까지 더한 결과를 보여줍니다. 정수 입력> ");
		int lastNum = sc.nextInt();
		
		hap = 0;		//★반드시 0으로 초기화
		for(i = 1;i <= lastNum;i++) {
			hap += i;
		}
		System.out.println("1~"+ lastNum + "까지 더한 결과=" + hap);
		
		/** firstNum(시작값)~lastNum(끝값)까지 더한 결과 **/
		System.out.print("시작값(정수) 입력> ");
		int firstNum = sc.nextInt();
		
		System.out.print("끝값(시작값보다 크거나 같은 정수) 입력> ");
		lastNum = sc.nextInt();
		
		hap = 0;	//★반드시 0으로 초기화
		for(i = firstNum; i <= lastNum;i++) {
			hap += i;
		}
		System.out.println(firstNum + "~"+ lastNum + "까지 더한 결과=" + hap);
		
		/** firstNum(시작값)~lastNum(끝값)까지 increNum(증가값)씩 증가한 수를 더한 결과 **/
		System.out.print("시작값(정수) 입력> ");
		firstNum = sc.nextInt(); 	//1
		
		System.out.print("끝값(시작값보다 크거나 같은 정수) 입력> ");
		lastNum = sc.nextInt(); 	//10
		
		System.out.print("증가값(양수) 입력> ");
		int increNum = sc.nextInt();	//2
		
		hap = 0;	//★반드시 0으로 초기화
		for(i = firstNum; i <= lastNum;i += increNum) { 	//i = i + increNum
			hap += i;
		}
		System.out.println(firstNum + "~"+ lastNum + "까지 " + increNum + "씩 증가한 수를 더한 결과=" + hap);
		
		/** 구구단 중 5단만 출력 - 반복문 사용안하고 **/
		System.out.println("5 X " + 1 + " = " + (5*1));
		System.out.println("5 X " + 2 + " = " + (5*2));
		System.out.println("5 X " + 3 + " = " + (5*3));
		System.out.println("5 X " + 4 + " = " + (5*4));
		System.out.println("5 X " + 5 + " = " + (5*5));
		System.out.println("5 X " + 6 + " = " + (5*6));
		System.out.println("5 X " + 7 + " = " + (5*7));
		System.out.println("5 X " + 8 + " = " + (5*8));
		System.out.println("5 X " + 9 + " = " + (5*9));
		
		System.out.println(); //구분용 빈줄
		
		/** 구구단 중 5단만 출력 - 반복문 사용하고 **/
		int k;
		for(k = 1; k <= 9;k++) {
			System.out.println("5 X " + k + " = " + (5*k));
		}
		System.out.println(); //구분용 빈줄
		
		/** 키보드로 입력받은 단 출력 **/
		System.out.print("출력할 단 입력> ");	//7
		int dan = sc.nextInt();
		
		for(k = 1;k <= 9 ;k++) {
			System.out.println(dan + " X " + k + " = " + (dan*k));
		}
		
		System.out.println(); //구분용 빈줄
		
		/** 초기화 여러 개, 증감식 여러개 가능 **/
		for(i = 1, k = 10; k >= 1;i++, k--) {	//10번 반복(i:1->2...->10, k:10->9...->1)
			System.out.println(i + "+" + k + "=" + (i+k));
		}
	}

}
