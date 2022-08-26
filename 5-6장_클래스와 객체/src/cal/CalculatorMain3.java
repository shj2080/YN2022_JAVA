package cal;

import java.util.Scanner;

public class CalculatorMain3 {

	public static void main(String[] args) {
		/*
		 * 잘못된 방법 //각 부품 생성 Add a = new Add(); Sub s = new Sub(); Mul m = new Mul(); Div
		 * d = new Div();
		 * 
		 * new Calculator(a, s, m, d);
		 */

		/*
		 * [과제] 스캐너 객체 생성하여 ->
		 * "두 수와 연산자를 입력받아 결과 출력"
		 * -> " "반복됨(stop 입력받으면 계산 종료한 후 실행횟수
		 * 출력+총실행횟수(totalCnt)도 출력)
		 */

		/** 계산기 생성 **/
		Calculator cal = new Calculator();

		// 스캐너 객체 생성
		Scanner sc = new Scanner(System.in);

		boolean flag = true;
		int totalCnt = 0; //연산한 총 횟수
		
		String tmp = null;
		String answer = null;  	//계산 종료 확인
		double n1, n2;

		do{
			System.out.print("계산할 두 수 입력(단, stop 입력하면 계산종료)> "); //"10 20엔터"
			tmp = sc.next().trim(); //"수(정수,실수)" "문자(stop, stop이외문자)"

			if (tmp.equalsIgnoreCase("stop")) {
				flag = false; //cpu 효율성을 위함
				break; //반복문을 빠져나감
			}
			
			//"10.2" -> 10.2  "10"->"10.0", "stop이외문자" => 예외발생
			try {
				n1 = Double.parseDouble(tmp);
			} catch (NumberFormatException e) { //"stop이외문자"=>예외발생하면 잡아서
				System.out.println("첫번째 입력한 수 : 잘못된 수를 입력하셨습니다."); //처리
				continue;
			}finally { //예외 발생 여부에 관계없이 무조건 실행
				//System.out.println("** 계산 중입니다. ********");
			}
			
			tmp = sc.next().trim(); //"수(정수,실수)" "문자(stop, stop이외문자)"
			
			if (tmp.equalsIgnoreCase("stop")) {
				flag = false;
				break; //반복문을 빠져나감
			}
			
			//"10.2" -> 10.2  "10"->"10.0", "stop이외문자" => 예외발생
			try {
				n2 = Double.parseDouble(tmp);
			} catch (NumberFormatException e) { //"stop이외문자"=>예외발생하면 잡아서
				System.out.println("두번째 입력한 수 : 잘못된 수를 입력하셨습니다."); //처리
				continue;
			}finally { //예외 발생 여부에 관계없이 무조건 실행
				//System.out.println("** 계산 중입니다. ********");
			}
			
			System.out.println("연산자 입력(+ - * /) > ");
			String opr = sc.next();
			
			switch(opr){
			case "+" : System.out.println(n1 + "+" + n2 + "=" + cal.add(n1, n2)); 
						totalCnt++;
						break;
			case "-" : System.out.println(n1 + "-" + n2 + "=" + cal.sub(n1, n2)); 
						totalCnt++;
						break;
			case "*" : System.out.println(n1 + "*" + n2 + "=" + cal.mul(n1, n2)); 
						totalCnt++;
						break;
			case "/" : System.out.println(n1 + "/" + n2 + "=" + cal.div(n1, n2)); 
						totalCnt++;
						break; 
			default : System.out.println("해당 계산기에 없는 연산자 또는 잘못된 연산자입니다."); //break; 생략 가능	
			}
			
			System.out.println(); //구분 위한 빈 줄
			
			System.out.println("계속 계산하시겠습니까? (Y/N) > ");
			answer = sc.next().trim();
			
			if(answer.equalsIgnoreCase("N")){
				System.out.println("계산을 종료하겠습니다.");
				break;
			}
			
			}while(answer.equalsIgnoreCase("Y"));
		
		cal.showOperatingTimes();
		if(totalCnt > 0) {
			System.out.println("--------------------------------------------");
			System.out.println("총 실행 횟수=" + totalCnt + "회");
		}
	}

}
