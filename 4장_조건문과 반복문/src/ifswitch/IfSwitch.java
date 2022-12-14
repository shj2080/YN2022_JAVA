/*
 * 클래스 종류 3가지 : 모든 클래스에는 생성자가 존재한다.
 * 1. 라이브러리용(=설계도) : main() 없다.
 * 
 * 2. 실행용 : main() 있다.
 * 
 * 3. 라이브러리용 + 실행용 : main()도 있고
 * 					  + 필요한 멤버변수(=필드=filed)와 메서드들()을 추가하면
 * 					  이 실행용 클래스도 라이브러리용으로 사용가능함
 * 
 */
package ifswitch;

import java.util.Scanner;

public class IfSwitch {//부모=슈퍼클래스:Object
	//1.멤버변수=필드:옵션
	static final double PI = 3.14; //공유 + 변경 불가 => 상수
	
	//2.생성자:반드시 존재해야 함
	//기본생성자 : 생성자가 없으면 컴파일러가 컴파일하기 전에 public IfSwitch(){super();} 삽입
	
	//3.메서드:옵션
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수 입력(0~100)>");
		int n1 = sc.nextInt();	//88
		
		/** if()문
		 * 	()안에 들어갈 수 있는 내용 : true 또는 false를 결과로 가지는 것
		 */
		
		//단독 if문 : 서로 독립적 - 원하는 결과 안 나옴
		if(n1>=90) System.out.println("A");	//90~100
		if(n1>=80) System.out.println("B");
		if(n1>=70) System.out.println("C");
		if(n1>=60) System.out.println("D");
		if(n1<60) System.out.println("F");
		
		System.out.println(); 	//구분용 빈줄
		
		//단독 if문 : 서로 독립적 - [해결법-조건 추가]
		if(n1>=90) System.out.println("A");	//90~100
		
		if(80 <= n1 && n1 < 90) System.out.println("B");	//80~89
		
		if(70 <= n1 && n1 < 80) System.out.println("C");	//70~79
		
		if(60 <= n1 && n1 < 70) System.out.println("D");	//60~69
		
		if(n1<60) System.out.println("F");
		
		System.out.println(); 	//구분용 빈줄
		
		//if~else if....else : 서로 연결된 한덩어리 - 여러 조건문들 중 반드시 하나만 참
		if(n1>=90) System.out.print("A");	//90~100
		else if(n1>=80) System.out.print("B");	//else의미 : n1<90
		else if(n1>=70) System.out.print("C");	//else의미 : n1<80
		else if(n1>=60) System.out.print("D");	//else의미 : n1<70
		else System.out.print("F");	//else의미 : n1<60
		
		System.out.println(); 	//구분용 빈줄
		
		if(n1>=90) {
			System.out.print("A");	//90~100
			//System.out.println("학점");
		}
		else if(n1>=80) {	//else의미 :  n1<90
			System.out.print("B");	
			//System.out.println("학점");
		}
		else if(n1>=70) {	//else의미 : n1<80
			System.out.print("C");
			//System.out.println("학점");
		}
		else if(n1>=60) {	//else의미 : n1<70
			System.out.print("D");
			//System.out.println("학점");
		}
		else {				//else의미 : n1<60
			System.out.print("F");
			//System.out.println("학점");
		}
		
		System.out.println("학점");	// 무조건 실행
		
		System.out.println(); 	//구분용 빈줄
			
		//중첩 if문 : 95~100=>A+, 90~94=>A-
		if(n1>=90) {
			if(n1>=95) System.out.println("A+");
			else System.out.print("A-");	//n1>=90 && n1<95
		}
		else if(n1>=80) {	//else의미 :  n1<90
			if(n1>=85) System.out.println("B+");
			else System.out.print("B-");	//n1>=80 && n1<85
		}
		else if(n1>=70) {	//else의미 : n1<80
			if(n1>=75) System.out.println("C+");
			else System.out.print("C-");
		}
		else if(n1>=60) {	//else의미 : n1<70
			if(n1>=65) System.out.println("D+");
			else System.out.print("D-");
		}
		else {				//else의미 : n1<60
			System.out.print("F");
		}
		
		System.out.println("학점");	// 무조건 실행
		
		System.out.println(); 	//구분용 빈줄
		
		/** switch()문 : 여러 개 중 하나만 선택하여 실행 => sql문에서의 decode()
		 * if~else if..else문과 호환(switch문으로 해결할 수 없는 것까지 해결가능) => sql문에서의 case~end
		 * 
		 * switch()문의 ()안에 들어갈 수 있는 내용 : 정수, '문자', "문자열"을 결과로 가지는 것(★주의 : 실수 안 됨)
		 * 
		 */
		
		//예-1 : switch(정수)---------------------------------------------------------------
		System.out.println("--------------switch문의 정수 테스트-------------");
		switch(20) {
			case 10:
				System.out.println("10입니다.");
				break;
			case 20:
				System.out.println("20입니다.");
				break;
			case 30:
				System.out.println("30입니다.");
				break;
			default:
				System.out.println("10, 20, 30 이외입니다.");
				//break;
		}
		
		
		switch(add(10,20)) {	//switch(IfSwitch.add(10,20)) {
		case 10:
			System.out.println("10입니다.");
			break;
		case 20:
			System.out.println("20입니다.");
			break;
		case 30:
			System.out.println("30입니다.");
			break;
		default:
			System.out.println("10, 20, 30 이외입니다.");
			//break;
		}
		
		IfSwitch ifs = new IfSwitch();	//객체생성 후
		switch(ifs.add(5, 5, 10)) {	//주소로 접근.static없는 메서드
		case 10:
			System.out.println("10입니다.");
			break;
		case 20:
			System.out.println("20입니다.");
			break;
		case 30:
			System.out.println("30입니다.");
			break;
		default:
			System.out.println("10, 20, 30 이외입니다.");
			//break;
		}
		

		switch((int)(ifs.add(12.3, 10))) {	//★주의 : 실수 안 됨
		case 10:
			System.out.println("10입니다.");
			break;
		case 20:
			System.out.println("20입니다.");
			break;
		case 30:
			System.out.println("30입니다.");
			break;
		default:
			System.out.println("10, 20, 30 이외입니다.");
			//break;
		}
		
		double result = ifs.add(12.3, 10);	//22.3
		System.out.println(result + 20); //42.3

		System.out.println(ifs.add(12.3, 10)-20); //2.3
		
		ifs.add(12.3, 12.3);
		
		/*-----------------------------------------------------*/
		IfSwitch ifs2 = new IfSwitch();	//객체 생성 후
		//result = ifs2.area(3) + 20;
		result = ifs2.area(3);
		System.out.println("반지름 3의 원넓이+20=" + (result+20));
		
		//예-2 : switch('문자')-----------------------------------------------
		System.out.println("--------------switch문의 문자 테스트-----------------");
		switch('a') {	// 이름없는 메모리 '0'=>48의 2진수, 'a'=>97의 2진수
			case '0' :
				System.out.println("문자 0입니다.");
				break;
			case 97 :		//97의 2진수
				System.out.println("문자 a입니다.");
				break;
			default :
				System.out.println("문자 0,a 이외입니다.");
				break;
		}
		
		System.out.print("65~90사이의 정수 입력>");
		int num = sc.nextInt();	//65
		System.out.println("당신이 입력한 정수에 해당하는 문자는 ");
		switch(parseChar(num)) {		// 'A'
			case 'A' :
				System.out.println("A입니다.");
				break;
			case 'B' :
				System.out.println("B입니다.");
				break;
			case 'C' :
				System.out.println("C입니다.");
				break;
			default :
				System.out.println("A,B,C 이외의 문자입니다.");
				//break;
		}
		
		System.out.println("당신이 입력한 정수에 해당하는 문자는 ");
		switch(parseChar(num) + 32) {		// 'A'
			case 'A'+32 :
				System.out.println((char)('A'+32)+"입니다.");
				break;
			case 'B'+32 :
				System.out.println((char)('B'+32)+"입니다.");
				break;
			case 'C'+32 :
				System.out.println((char)('C'+32)+"입니다.");
				break;
			default :
				System.out.println("a,b,c 이외의 문자입니다.");
				//break;
		}
		
		System.out.println("당신이 입력한 정수에 해당하는 문자를 소문자로 표현하면 ");
		switch(parseChar(num)+32) {		// 'A'
			case 'a' :
				System.out.println("a입니다.");
				break;
			case 'b' :
				System.out.println("b입니다.");
				break;
			case 'c' :
				System.out.println("c입니다.");
				break;
			default :
				System.out.println("a,b,c 이외의 문자입니다.");
				//break;
		}
		
		//예-3 : switch("문자열")-----------------------------------------------
		System.out.println("--------------switch문의 문자열 테스트-----------------");
		System.out.print("단어 입력>");
		String word = sc.next();
		
		switch(word) {
			case "행복" :
				System.out.println("행복하세요~^^");
				break;
			case "사랑" :
				System.out.println("사랑하세요~^^");
				break;
			case "건강" :
				System.out.println("건강하세요~^^");
				break;
			default :
				System.out.println("이외 문자열~^^");
		}
		
		switch(word) {
			case "행복" :
			case "사랑" :
				System.out.println("행복 또는 사랑하세요~^^");
				break;
			case "건강" :
				System.out.println("건강하세요~^^");
				break;
			default :
				System.out.println("이외 문자열~^^");
		}
		
		switch(word) {		//case 달라도 같은 결과를 가질 때
			case "장미" :
			case "국화" :
				System.out.println("꽃입니다.~^^");
				break;
			case "소나무" :
			case "밤나무" :
				System.out.println("나무입니다.~^^");
				break;
			//default : System.out.println("이외 문자열~^^");
			default :
				System.out.println(word + "입니다.~^^");		//word는 word.toString()와 같다.
				break;
		}
		
		System.out.print("점수 입력(0~100)>");
		n1 = sc.nextInt();
		switch(n1 / 10) {
			case 10 :
			case 9 :
				System.out.print(n1+"점은 A");
				break;
			case 8 :
				System.out.print(n1+"점은 B");
				break;
			case 7 :
				System.out.print(n1+"점은 C");
				break;
			case 6 :
				System.out.print(n1+"점은 D");
				break;
			default :
				System.out.print(n1+"점은 F");	//0~59
				break;
		}
		System.out.println("학점");
		
		/** 카페에서 주문(손님 주문:입력) -> switch문으로 처리 -> 결과 출력 **/
		System.out.print("메뉴(아메리카노, 카페라떼, 카푸치노)중에서 주문>");
		String order = sc.next();	//"아메리카노"
		
		switch(order) {
			case "아메리카노" : 
			case "카페라떼" : 
			case "카푸치노" : 	
				System.out.println(order + "를 주문하셨습니다.");
				break;
			default :
				System.out.println("메뉴에 없습니다.");
				//break;
		}
		
		
		/** 반복문 사용 : 카페에서 주문(손님 주문:입력) -> switch문으로 처리 -> 결과 출력 **/
		int i;	
		for(i = 1;i <= 3;i++) {	// i : 카운팅 변수
			System.out.print("3번만 주문-1 : 메뉴(아메리카노, 카페라떼, 카푸치노)중에서 주문>");
			order = sc.next();	//"카페라떼"
			
			switch(order) {
			case "아메리카노" : 
			case "카페라떼" : 
			case "카푸치노" : 	
				System.out.println(order + "를 주문하셨습니다.");
				break;
			default :
				System.out.println("메뉴에 없습니다.");
				//break;
			}
		}	
		System.out.println("거짓이 되어 빠져나왔을 때 i=" + i);
		
		/** 반복문 사용 : 카페에서 주문(손님 주문:입력) -> switch문으로 처리 -> 결과 출력 **/
		//int i;	
		i = 1;	//1번만 실행
		for(;i <= 3;) {	// i : 카운팅 변수
			System.out.print("3번만 주문-2 : 메뉴(아메리카노, 카페라떼, 카푸치노)중에서 주문>");
			order = sc.next();	//"카페라떼"
			
			switch(order) {
			case "아메리카노" : 
			case "카페라떼" : 
			case "카푸치노" : 	
				System.out.println(order + "를 주문하셨습니다.");
				break;
			default :
				System.out.println("메뉴에 없습니다.");
				//break;
			}
			
			i++;
		}
		System.out.println("거짓이 되어 빠져나왔을 때 i=" + i);
		System.out.println(); //구분용 빈줄
		
		System.out.println("----------stop 입력받을 때까지 주문받음 (do~while문)-----------");
		do {
			System.out.print("메뉴(아메리카노, 카페라떼, 카푸치노)중에서 주문(단,주문안함 입력시 바로나감, stop입력 시 주문종료)>");
			order = sc.next();	//"주문안함"
			
			if(order.equalsIgnoreCase("주문안함")) break;
			
			switch(order) {
			case "아메리카노" : 
			case "카페라떼" : 
			case "카푸치노" : 	
				System.out.println(order + "를 주문하셨습니다.");
				break;
			case "stop" :
				System.out.println("그만 주문하겠습니다.");
				break;
			default :
				System.out.println("메뉴에 없습니다.");
				//break;
			}
			
		} while(!order.equalsIgnoreCase("stop"));
		System.out.println("거짓이 되어 빠져나왔을 때 i=" + i);
		
		
		sc.close(); //스캐너 종료
	}	//main()끝 = 프로그램의 끝
	
	/**
	 * 메서드 오버로딩 : 같은 이름의 메서드(단, 매개변수의 갯수나 타입이 달라야 한다.)
	 */
	
	/*
	 * [메서드 만드는 방법]
	 * return되는 결과타입 + 메서드명(매개변수 선언) {
	 * 		return 결과;
	 * }
	 * 
	 * return되는 결과타입은 돌려주는 결과가 없으면 void
	 */
	
	//메소드
	static int add(int n1, int n2) {	//IfSwitch.class가 메모리에 로딩 될 때 static 메서드들은 메모리에 올라옴
		return n1+n2;	//정수 + 정수 = 정수 (2+3=5->5.0)
	}
	
	int add(int n1, int n2, int n3) {
		return n1+n2+n3;	//정수 + 정수 = 정수
	}
	
	double add(double n3, int n4) {
		return n3+n4;	//실수 + 정수 = 실수 + 자동형변환되어 실수=실수
	}
	
	void add(double n3, double n4) {
		System.out.println(n3+n4);//결과 출력
	}
	
	double area(int r) {	//원의 넓이 = 원주율(3.1415...) * 반지름 * 반지름
		return PI * r * r;
	}
	
	static char parseChar(int num) {
		return (char)num;
	}
	
}	// 클래스 끝
