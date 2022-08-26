package cal;

import java.util.Scanner;

public class CalculatorMain4 {

	public static void main(String[] args) {
		/*
		 * 잘못된 방법 //각 부품 생성 Add a = new Add(); Sub s = new Sub(); Mul m = new Mul(); Div
		 * d = new Div();
		 * 
		 * new Calculator(a, s, m, d);
		 */

		/*
		 * [과제] 스캐너 객체 생성하여 -> "두 수와 연산자를 입력받아 결과 출력" -> " "반복됨(stop 입력받으면 계산 종료한 후 실행횟수
		 * 출력+총실행횟수(totalCnt)도 출력)
		 */

		/** 계산기 생성 **/
		Calculator cal = new Calculator();

		// 스캐너 객체 생성
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("정수 연산자(+,-,*,/) 정수 입력, 탈출은 0만 입력");
			System.out.println("split()을 사용한 계산기와 달리 1+2-3*4/5 처럼 연산자 혼용 가능함");
			String temp = sc.next().trim(); // -1*2-3, 1+2-3, 1+2-3*4, 1+2-3*4/5 등 혼용 가능
			
			if (temp.equalsIgnoreCase("stop") || temp.charAt(0) == '0') { // 탈출조건
				break;
			}

			// 첫번째 숫자가 음수인가?
			boolean isFirstNav = false;
			if (temp.charAt(0) == '-') {
				isFirstNav = true;
			}

			// 숫자 배열과 연산자 배열 길이를 설정하기 위해 연산자의 숫자를 검색
			// ex)1+2+3*4 => 연산자 총 3개
			// 이때 필요한 연산자 배열 길이 = 연산자 총 갯수
			// 숫자 배열 길이 = 연산자 총 갯수 + 1

			// 총 연산자 갯수 확인
			int opers = 0;// 연산자 갯수를 칭하는 변수
			for (int k = 0; k < temp.length(); k++) {
				if (temp.charAt(k) == '+' || temp.charAt(k) == '-' || temp.charAt(k) == '*' || temp.charAt(k) == '/') {
					opers++;
				}
			}

			int number = 0;// 숫자 배열의 index
			int N = 0;// 숫자 배열에 들어갈 숫자

			char operA[] = new char[opers];// 연산자 배열
			double numberA[] = new double[(opers + 1)];// 숫자 배열

			// 연산자와 숫자를 연산자배열과 숫자 배열로 분리 하는 과정
			// 첫번째 숫자가 음수일 경우 연산자 갯수와 숫자의 갯수가 동일 ex)-1+2-3*4 => 연산자 총 4개, 숫자도 4개
			for (int k = 0; k < temp.length(); k++) {
				if (temp.charAt(k) == '+' || temp.charAt(k) == '-' || temp.charAt(k) == '*' || temp.charAt(k) == '/') {
					// 연산자 위치와 종류를 저장
					switch (temp.charAt(k)) {
					case '+':
						operA[number] = temp.charAt(k);
						number++;
						// 연산자 이후에는 숫자가 나오기 때문에 N을 0으로 초기화 해야함
						N = 0;
						break;
					case '-':
						operA[number] = temp.charAt(k);
						number++;
						// 연산자 이후에는 숫자가 나오기 때문에 N을 0으로 초기화 해야함
						N = 0;
						break;
					case '*':
						operA[number] = temp.charAt(k);
						number++;
						// 연산자 이후에는 숫자가 나오기 때문에 N을 0으로 초기화 해야함
						N = 0;
						break;
					case '/':
						operA[number] = temp.charAt(k);
						number++;
						// 연산자 이후에는 숫자가 나오기 때문에 N을 0으로 초기화 해야함
						N = 0;
						break;
					}
				} else { // 숫자를 저장 ex)'-' '6' '2' '5' '+' 2+3*4 + 메서드들 => String객체
					N *= 10; //사람은 수를 10진수 N=0 (6*10=60) (62*10=620)
					N += Double.parseDouble(temp.substring(k, k + 1)); //(1, 1+1) => "6" -> 6.0, "2"->2.0
					numberA[number] = N; //[6] -> [62] -> 최종[625]
					// 해당 위치에 연산자가 없으면 숫자가 있는것
					// 625 숫자는 (6*10*10)+(2*10)+5로 만들어짐
					// 6을 읽고 저장하면 N = 6
					// 그다음 2를 읽고 저장하기전에 N에 10을 곱하면
					// 60 + 2 = 62 -> N에 저장
					// 다음 숫자를 읽기 전에 N에 10을 곱함
					// 620 + 5 = 625 ->N에 저장
					// 625 숫자를 온전히 저장 가능함
				}
				
			}//for문 끝
			
			
			// 첫번째 숫자가 음수일 경우
			// numberA[0]에는 아무것도 안들어가 있음
			// 고로 원할한 계산을 위하여 numberA[0]에 0을 넣어주어야 함
			/*
			if (isFirstNav) {	//true -> 음수, false->양수
				numberA[0] = 0;
			}
			*/
			
			// 숫자배열과 연산자 배열을 이용하여 계산
			// 첫번째 숫자 +(첫번째 연산자 + 두번째 숫자) + (두번째 연산자 + 세번째 숫자)......
			// k=0 k=0 k=0+1 k= 1 k= 1+1
			//
			double result = numberA[0];
			for (int k = 0; k < opers; k++) {
				switch (operA[k]) {
				case '+':
					result += numberA[k + 1];
					break;
				case '-':
					result -= numberA[k + 1]; //0 -1
					break;
				case '*':
					result *= numberA[k + 1];
					break;
				case '/':
					result /= numberA[k + 1];
					break;
				}
			}
			// 결과출력
			System.out.println(temp + " = ");
			System.out.println(result);
		}
		//cal.showOperatingTimes();
	}

}
