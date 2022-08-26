package cal;

import java.util.Scanner;

public class CalculatorMain5 {

	public static void main(String[] args) {
		/* 잘못된 방법
		//각 부품 생성
		Add a = new Add();
		Sub s = new Sub();
		Mul m = new Mul();
		Div d = new Div();
		
		new Calculator(a, s, m, d);
	    */
		
		/** 계산기 생성 **/
		Calculator cal = new Calculator();
		
		/* [과제]
		 * 스캐너 객체 생성하여 두수와 연산자를 입력받아 결과 출력
		 * ->반복하여 사용하다가 stop입력받으면 계산을 종료한 후 실행횟수 출력
		 * (예) 5+2=7 * 2=14-2=12
		 */
		
		// 스캐너 객체 생성
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		//String tmp = null;
		
		int totalCnt = 0;//연산한 총 수
		double result = 0;
		
		while(flag) {
			
			
			if(totalCnt == 0) {
				System.out.print("계산할 두 수 입력(단, stop 입력하면 계산종료) > ");//"10 20엔터"
				String tmp = sc.next();//"수(정수, 실수)" / "문자(stop, stop이외)"
				
				if(tmp.equalsIgnoreCase("stop")) {
					flag = false;
					break;
				}
				
				double n1;
				try {
					n1 = Double.parseDouble(tmp);//"10"->10.0 ,"문자(stop이외)"->예외
				} catch (Exception e) {//예외객체 잡아서 처리			
					System.out.println("첫번째 입력한 수 > 잘못된 수를 입력하셨습니다.");
					continue;
				}finally {//예외 발생 여부에 관계없이 무조건 실행
					//System.out.println("**계산 중입니다.******");
				}
				
				//n1 : "수(정수, 실수)" -> 실수
				
				String tmp2 = sc.next();
				
				if(tmp2.equalsIgnoreCase("stop")) {
					flag = false;
					break;
				}
				
				double n2;
				try {
					n2 = Double.parseDouble(tmp2);//"10"->10.0 ,"문자(stop이외)"->예외
				} catch (Exception e) {//예외객체 잡아서 처리			
					System.out.println("두번째 입력한 수 >잘못된 수를 입력하셨습니다.");
					continue;
				}finally {//예외 발생 여부에 관계없이 무조건 실행
					//System.out.println("**계산 중입니다.******");
				}
				
				//n2 : "수(정수, 실수)" -> 실수
				
				System.out.print("연산자(+ - x /) 입력 >");//x X			
				String opr = sc.next();
				
				switch(opr.trim().toUpperCase()) {//앞뒤 공백 제거->대문자로 변환
				case "+" : 
					System.out.println(n1 + "+" + n2 + "=" + cal.add(n1, n2));
					result = cal.add(n1, n2);
					totalCnt++;
					break;
				case "-" : 
					System.out.println(n1 + "-" + n2 + "=" + cal.sub(n1, n2));
					result = cal.sub(n1, n2);
					totalCnt++;
					break;
				case "X" : //반드시 대문자 
					System.out.println(n1 + "X" + n2 + "=" + cal.mul(n1, n2));
					result = cal.mul(n1, n2);
					totalCnt++;
					break;
				case "/" : 
					System.out.println(n1 + "/" + n2 + "=" + cal.div(n1, n2));
					result = cal.div(n1, n2);
					totalCnt++;
					break;
				default : System.out.println("해당 계산기에 없는 연산자이거나 잘못된 연산자입니다.");
				} 
			
			}else {
				System.out.print("앞의 계산과 연결하시겠습니까?(단, 그만하고 싶으면 stop 입력)"
						+ "앞의 계산과 연결하고 싶으면 '앞의 계산과 연결하여 연산할 수 입력' > ");
				String tmp = sc.next();
				if(tmp.equalsIgnoreCase("stop")) {
					flag = false;
					break;
				}
				
				double n2;
				try {
					n2 = Double.parseDouble(tmp);//"10"->10.0 ,"문자(stop이외)"->예외
				} catch (Exception e) {//예외객체 잡아서 처리			
					System.out.println("연결하여 입력한 수 : 잘못된 수를 입력하셨습니다.");
					continue;
				}finally {//예외 발생 여부에 관계없이 무조건 실행
					//System.out.println("**계산 중입니다.******");
				}
				
				System.out.print("연산자(+ - x /) 입력 >");//x X			
				String opr = sc.next();
				
				switch(opr.trim().toUpperCase()) {//앞뒤 공백 제거->대문자로 변환
				case "+" : 					
						System.out.println(result + " + " + n2 + " = " + cal.add(result, n2)); 
						result = cal.add(result, n2);
					
					    totalCnt++;
					    break;
				case "-" : 					
						System.out.println(result + " - " + n2 + " = " + cal.sub(result, n2));
						result = cal.sub(result, n2);				
					
						totalCnt++;
						break;
				case "X" : //반드시 대문자 					
						System.out.println(result + " * " + n2 + " = " + cal.mul(result, n2));
						result = cal.mul(result, n2);
					
						totalCnt++;
						break;
				case "/" : 					
						System.out.println(result + " / " + n2 + " = " + cal.div(result, n2));
						result = cal.div(result, n2);
					
						totalCnt++;
						break;				
				default : System.out.println("해당 계산기에 없는 연산자이거나 잘못된 연산자입니다.");
				} //switch문 끝
				
			}//else문 끝
			
				
		}//while문
		
		System.out.println("====계산 종료====");
		cal.showOperatingTimes();
		if(totalCnt != 0) {
			System.out.println("--------------");
			System.out.println("총 실행 횟수="+totalCnt+"회");
		}
		
		
	}

}






