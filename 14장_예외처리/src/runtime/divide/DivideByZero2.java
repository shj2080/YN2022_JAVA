/** ArithmeticException은 RuntimeException(실행오류 예외)의 자식 클래스로
 	프로그래머의 실수로 발생하는 예외이므로
  	try ~ catch() 로 처리하는 방법보다 실수를 수정하는 방법으로 해결하는 것이 더 좋다.
*/

package runtime.divide;

import java.util.Scanner;
//라이브러리용+실행용
public class DivideByZero2 {
	//기본생성자
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("두 개의 정수 입력 > ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		boolean divOK = divider(num1, num2); //divider(10, 0);
		
		if(divOK)
			System.out.println("나누기 연산 성공");
		else
			System.out.println("나누기 연산 실패");
		
		System.out.println(); //구분 빈 줄
		
		double result = divider2(num1, num2); //divider2(10, 0);
		if(result != 0) {	//나눗셈 결과가 0이 아니라면
			result = result + 100;	//결과에 100을 더함
			System.out.println("나눗셈 결과는 " + result);
		}
		
	}
	
	///두 수를 나누는 divider() 메서드 설계 - 2가지 방법
	static boolean divider(int num1, int num2) {
		if(num2 != 0) { //2번째 수가 0이 아닌 경우
			System.out.println("나눗셈 결과는 " + ((double)num1 / num2));
			return true; //나누기 성공
		}else {	//0인 경우
			System.out.println("0으로 나눌 수 없습니다.");
			return false; //나누기 실패
		}
		
	}

	static double divider2(int num1, int num2) {
		if(num2 != 0) { //2번째 수가 0이 아닌 경우
			//System.out.println("나눗셈 결과는 " + ((double)num1 / num2));
			System.out.println("나누기 연산 성공");
			return ((double)num1 / num2);
		}else {	//0인 경우
			System.out.println("0으로 나눌 수 없습니다.");
			System.out.println("나누기 연산 실패");
			return 0; //0 -> 0.0 자동형변환
		}
		
	}
}
