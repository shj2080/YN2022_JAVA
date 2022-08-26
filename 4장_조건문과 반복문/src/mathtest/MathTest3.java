package mathtest;

import java.util.Scanner;

public class MathTest3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String temp = null;
		
mathTest :while(true) {
			System.out.println("(1) 제곱");
			System.out.println("(2) 루트");
			System.out.println("(3) 로그");
			
			System.out.print("원하는 메뉴(1~3)를 선택하세요.(전체종료:stop)>"); //1
			//int menu = sc.nextInt();
			
			/* 입력하는 값들은 수나 문자다.
			 * 1. 수-정수 : 0보다 큰 정수(O), 0보다 작거나 같은 정수(X) => if문 해결가능,
			 * 		실수(X)=>InputMismatchException예외 생성 => try~catch()문 해결가능
			 * 2. 문자(X)=>InputMismatchException예외 생성 => try~catch()문 해결가능
			 */
			
			//정수 : "1" "2" "3"(O), 이외의 정수(X)
			//실수 : (X)
			
			//문자 : "stop"(=>끝)   "stop"이외의 문자들(X)
			temp = sc.next().trim(); //입력 받은 후 양쪽 공백 제거
			
			//1. stop처리
			if(temp.equalsIgnoreCase("stop")) {
				//System.out.println("------------------ 프로그램 종료 ------------------");
				break; //가장 가까운 반복문(=바깥 while문)을 빠져나감
			}
			
			//2. "1" "2" "3"(O), 이외의 정수(X), 실수(X) "stop"이외의 문자들(X)
			if( !( temp.equals("1") || temp.equals("2") || temp.equals("3") ) ) {
				System.out.println("다시 입력해주세요.");
				continue; //아래 내용을 실행하지 않고 반복문 위로 올라감
			}
			
			//3.String -> 정수 변환("1" -> 1, "2"->2, "3"->3) => 문법적인 설명위해 일부러 추가함
			//위의 과정에서 예외를 걸러냈으므로 try~catch문 필요없음.
			int menu = Integer.parseInt(temp);//주의 : "10진수로 된 문자열"->int로 변환 가능
			
			while(true) {
				System.out.print("계산할 값을 입력하세요.(계산종료:0, 전체종료:stop)>"); //3
				//int num = sc.nextInt();
				temp = sc.next().trim();
				
				//1. stop처리
				if(temp.equalsIgnoreCase("stop")) {
					//System.out.println("------------------ 프로그램 종료 ------------------");
					break mathTest; //레이블이 달린 while문(=바깥쪽 while문)을 빠져나감
				}
				
				//3.String -> 정수 변환 (이유? 비교연산자로 0과 비교하기 위해)
				int num = Integer.parseInt(temp); //★★이곳의 예외처리는 MathTest4 에서 처리
				
				if(num == 0) {
					System.out.println("------------------ 계산종료 ------------------");
					break; //가장 가까운 반복문(=안쪽 while문)을 빠져나감
				}
				
				switch(menu) {
					case 1 :
						System.out.println(num+"의 제곱 결과=" + num * num);
						break;
					case 2 :
						System.out.println(num+"의 루트 결과=" + Math.sqrt(num));
						break;
					case 3 :
						System.out.println(num+"의 로그 결과=" + Math.log(num));
						break;
					default :
						System.out.println("메뉴에 없습니다.");
				}
			}//안쪽 while문
			
		}//바깥쪽 while문
		
		System.out.println("------------------ 프로그램 종료 ------------------");
		sc.close();
	}//main() 끝

}
