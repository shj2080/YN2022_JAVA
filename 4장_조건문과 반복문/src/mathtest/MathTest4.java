package mathtest;

import java.util.Scanner;

public class MathTest4 {

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
			
			/*
			//2. "1" "2" "3"(O), 이외의 정수(X), 실수(X) "stop"이외의 문자들(X)
			if( !( temp.equals("1") || temp.equals("2") || temp.equals("3") ) ) {
				System.out.println("다시 입력해주세요.");
				continue; //아래 내용을 실행하지 않고 반복문 위로 올라감
			}
			*/
			
			/* [2 주석처리하기 전]
			 * parseInt()는 NumberFormatException예외를 처리해 줘야 하나
			 * 이미 위에서 예외발생가능한 상황들은 걸러
			 * "1" "2" "3"만 여기까지 도달하기 때문에 예외처리 안해줘도 됨
			 */
			
			/* [2 주석처리하기 후]
			 * 위 2에서 걸러준 상황들을 대신 3에서 예외발생 가능한 상황들을 걸러줘야 함
			 */
			
			//3.String -> 정수 변환("1" -> 1, "2"->2, "3"->3) => 문법적인 설명위해 일부러 추가함
			//위의 과정에서 예외를 걸러냈으므로 try~catch문 필요없음.
			//주의 : "10진수로 된 문자열"->int로 변환 가능
			int menu;
			try { // "1" "2" "3"(O)  "이외의 정수"(예외발생안함) / 실수(X) "stop"이외의 문자들(X)
				menu = Integer.parseInt(temp);//"실수"나 "stop"이외의 문자들=>예외객체 생성
			} catch (NumberFormatException e) {
				//e.printStackTrace(); //JVM이 처리하는 방법
				System.out.println("다시 입력해주세요~");
				continue; //아래 부분 실행하지 않고 반복문의 위로 올라감
			}
			
			/* [2 주석처리하기 후] => default 부분이 없어도 됨
			 * 1 2 3(O)  이외의 정수(X)
			 */
			if( !(1 <= menu && menu <= 3) ) {
				System.out.println("다시 입력해주세요~");
				continue;
			}
			
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
				//실수(O) / 문자(X)
				double num;
				try {
					num = Double.parseDouble(temp);
				} catch (NumberFormatException e) {
					//e.printStackTrace();
					System.out.println("문자를 입력했습니다. 수를 다시 입력해주세요~");
					continue;
				}
				
				if(num == 0) {  //0.0  ==  0.0(자동형변환)
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
						if(num > 0) {
							System.out.println(num+"의 로그 결과=" + Math.log(num));
						}else { //else 의미 num < 0
							System.out.println("로그는 계산할 값으로 0보다 큰 수를 입력해주세요~");
						}
						break;
						
					//[2 주석처리하기 후 ]
					default :
						System.out.println("메뉴에 없습니다."); 
				}
			}//안쪽 while문
			
		}//바깥쪽 while문
		
		System.out.println("------------------ 프로그램 종료 ------------------");
		sc.close();
	}//main() 끝

}
