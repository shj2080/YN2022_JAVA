package cal;

import java.util.Scanner;

public class CalculatorMain {

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

		String tmp_num;
		double n1, n2;

		while (true) {
			System.out.print("계산할 두 수 입력 ,로 구분(stop:계산종료)> ");
			tmp_num = sc.next().trim();

			if (tmp_num.equalsIgnoreCase("stop")) {
				break;
			}
			
			String[] tmp = tmp_num.split(",");
			
			if(tmp.length < 2) { // 두 수가 아닌 경우
				System.out.println("계산할 숫자와 ,만 입력해주세요(예:1,2)");
				continue;
			}
			
			try {
				n1 = Double.parseDouble(tmp[0]);
				n2 = Double.parseDouble(tmp[1]);
			} catch (NumberFormatException e) {
				System.out.println("계산할 숫자와 ,만 입력해주세요(예:1,2)");
				continue;
			}

			System.out.print("연산자 입력(+ - * /)> ");
			String opr = sc.next();

			switch (opr) {
			case "+":
				System.out.println(n1 + "+" + n2 + "=" + cal.add(n1, n2));
				break;
			case "-":
				System.out.println(n1 + "-" + n2 + "=" + cal.sub(n1, n2));
				break;
			case "*":
				System.out.println(n1 + "*" + n2 + "=" + cal.mul(n1, n2));
				break;
			case "/":
				System.out.println(n1 + "/" + n2 + "=" + cal.div(n1, n2));
				break;
			default:
				System.out.println("해당 계산기에 없는 연산자이거나 잘못된 연산자입니다.");
				// break;
			}
		}
		cal.showOperatingTimes();
	}

}
