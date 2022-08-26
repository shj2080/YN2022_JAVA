package forex;

import java.util.Scanner;

public class Gugudan {

	public static void main(String[] args) {
		System.out.println("1.1. 구구단 출력 : 단 사이에 빈줄 넣기");
		int i;//단 : 2~9
		int j;//1~9
		for(i = 2; i <= 9; i++) { //i=2->3...->9(참) -> 10(거짓)
			//System.out.println(); //구분용 빈줄
			
			for(j = 1; j <= 9; j++) {
				System.out.println(i + " X " + j + " = " + (i*j)); //9 X 9
			}
			
			System.out.println(); //구분용 빈줄
		}
		System.out.println(); //구분용 빈줄
		
		System.out.println("1.2. 구구단 출력 : 단 사이에 빈줄 넣기 + *제 몇 단*");
		//int i;//단 : 2~9
		//int j;//1~9
		for(i = 2; i <= 9; i++) { //i=2->3...->9(참) -> 10(거짓)
			System.out.println("*제 " + i + " 단*");
			
			for(j = 1; j <= 9; j++) {
				System.out.println(i + " X " + j + " = " + (i*j)); //9 X 9
			}
			
			System.out.println(); //구분용 빈줄
		}
		System.out.println(); //구분용 빈줄
		
		System.out.println("2.1. 구구단 출력 : 옆으로 출력");
		for(i = 1; i <= 9; i++) { //i = 1
			
			for(j = 2; j <= 9; j++) { //j = 2 3 4 5 6 7 8 9
				System.out.print(j + "X" + i + "=" + (j * i) + "\t");
			}
			
			System.out.println(); //커서를 아래로
		}
		System.out.println(); //구분용 빈줄
		
		//[과제_6-21]---------------------------------------------------------------
		System.out.println("2.2. 구구단 출력 : 옆으로 출력 + *제 몇 단* [방법-1]");	//제 i 단
		//*제 몇 단*을 for문으로 따로 한 줄 출력함
		for(i = 2; i <= 9; i++) {
			System.out.print("*제" + i + "단*" + "\t");
		}
		System.out.println();	//커서를 아래로
				
		for(i = 1; i <= 9; i++) {
			for(j = 2; j <= 9; j++) {
				System.out.print(j + "X" + i + "=" + (j*i) + "\t");
			}
			System.out.println(); //커서 내리기
		}
		System.out.println(); //구분용 빈줄
		
		System.out.println("2.2. 구구단 출력 : 옆으로 출력 + *제 몇 단* [방법-2]");
		//*제 몇 단*을 중첩한 for문안에 if문을 이용하여 출력함
		for(i = 0; i <= 9; i++) {	//★i값을 0부터 시작
			for(j = 2; j <= 9; j++) {
				
				if(i==0) {
					System.out.print("*제" + j + "단*" + "\t");
				} else System.out.print(j + "X" + i + "=" + (j*i) + "\t");
				
			}
			System.out.println(); //커서 내리기
		}
		System.out.println(); //구분용 빈줄

		System.out.println("2.2. 구구단 출력 : 옆으로 출력 + *제 몇 단* [방법-3]");
		//*제 몇 단*을 중첩한 for문안에 if문을 이용하여 출력함
		for(i = 1; i <= 9; i++) {	//★i값을 1부터 시작
			if(i==1) {
				//for(i=2; i<=9; i++) { //i=2->3->..9(참)->10(거짓)	//=>결과X()
				//for(int k = 2; k<=9;k++) {	//=>결과OK
				for(j = 2; j<=9;j++) {	//=>결과OK
					System.out.print("*제"+j+"단*\t");
				}
				System.out.println(); 	//커서 아래로
			}
			//i=1;   //무한루프에 빠짐
			for(j = 2; j <= 9; j++) {
				System.out.print(j + "X" + i + "=" + (j*i) + "\t");
			}
			System.out.println(); //커서 내리기
		}
		System.out.println(); //구분용 빈줄
		//[과제_6-21]---------------------------------------------------------------
		System.out.println("3-1. 구구단 출력 : 2단~입력받은 단까지 아래로 출력");
		Scanner sc = new Scanner(System.in);
		System.out.print("단 입력:");
		int dan = sc.nextInt();
		
		for(i = 2; i <= dan; i++) { //i:단
			for(j = 1; j <= 9; j++) {
				System.out.println(i + "X" + j + "=" + (i*j)); // 9 X 9
			}
			System.out.println(); //구분용 빈줄
		}
		System.out.println(); //구분용 빈줄
		
		System.out.println("3-2. 구구단 출력 : 2단~입력받은 단까지 옆으로 출력");
		System.out.print("단 입력:");
		dan = sc.nextInt();
		
		for(i = 1; i <= 9; i++) { //i:단
			for(j = 2; j <= dan; j++) {
				System.out.print(j + "X" + i + "=" + (j * i) + "\t");
			}
			System.out.println(); //커서를 아래로
		}
		System.out.println(); //구분용 빈줄
		
		System.out.println("4-1. 구구단 중에서 \"두수를 곱해서 72가 되는 것만\" 아래로 출력");
		//[순서1] 2~9단 아래로 출력
		//[순서2] 두수를 곱해서 72가 되는 것만(=조건) 만족 => 출력
		for(i = 2; i <=9; i++) { //i:2->3..->9
			
			for(j = 1; j <= 9;j++) {
				if((i * j) == 72) {
					System.out.println(i + "X" + j + "=" + (i*j));
				}
			}
			//System.out.println(); //구분용 빈줄(8번)
		}
		System.out.println(); //구분용 빈줄
		
		System.out.println("4-2. 구구단 중에서 8X9=72(=조건)만 아래로 출력");
		//[순서1] 2~9단 아래로 출력
		//[순서2] 8X9=72(=조건) 만족 => 출력
		for(i = 2; i <=9; i++) { //i:2->3..->9
			
			for(j = 1; j <= 9;j++) {
				if(i == 8 && j == 9) {
					System.out.println(i + "X" + j + "=" + (i*j));
				}
			}
			//System.out.println(); //구분용 빈줄(8번)
		}
		System.out.println(); //구분용 빈줄
		
		System.out.println("4-3. 구구단 중에서 8X9=72(=조건)만 아래로 출력한 후 바깥쪽 반복문 멈추기");
		//[순서1] 2~9단 아래로 출력
		//[순서-2] 8X9=72(=조건) 만족 => 출력
		//[순서-3] 바깥쪽 반복문 멈추기
		outer:for(i = 2; i <=9; i++) { //i:2->3..->9
			
			for(j = 1; j <= 9;j++) {
				if(i == 8 && j == 9) {
					System.out.println(i + "X" + j + "=" + (i*j));
					//break; //가장 가까운 반복문(=안쪽 for문)을 빠져나감
					break outer; //바깥쪽 for문 빠져나감					break [레이블이름];
				}
			}//안쪽 for문
			
			//안쪽 for문 빠져나가면 여기로 옴(=>다시 i값이 9가 되어 for문을 돌림=>CPU의 효율↓)
			
			//System.out.println(); //구분용 빈줄(8번)
			
		}//바깥쪽 for문
		
		//바깥쪽 for문 빠져나가면 여기로 옴(=>CPU의 효율↑)
		
		System.out.println(); //구분용 빈줄
		
		sc.close();		//Scanner 종료
	}//main() 끝

}//class 끝
