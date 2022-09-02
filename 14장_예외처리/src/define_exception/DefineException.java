package define_exception;

import java.util.InputMismatchException; //'입력타입 불일치' 예외클래스
import java.util.Scanner;

class AgeInputException extends Exception {
	public AgeInputException() {
		super("유효하지 않은 나이가 입력되었습니다.");
	}
}

public class DefineException {

	public static void main(String[] args) { //throws AgeInputException {
		
		for(int i = 1; i <= 3; i++) {
			System.out.print("나이 입력 > ");
			
			int age;
			try {
				age = readAge();
				System.out.println("당신은 " + age + "세입니다."); //실행안하고
			} catch (AgeInputException | InputMismatchException e) { //잡아서
				if(e instanceof AgeInputException) {
					System.out.println(e);  //처리
				}else if(e instanceof InputMismatchException) {
					System.out.println("문자나 실수는 나이로 적합하지 않습니다.");
				}
			}
			
		}//for문 끝
		
		System.out.println("** 프로그램 종료 **");
	}

	private static int readAge() throws AgeInputException, InputMismatchException {
		Scanner sc = new Scanner(System.in);
		
		int age = sc.nextInt();
		
		if(age < 0) throw new AgeInputException(); //수동으로 예외객체
		
		return age;
	}

}
