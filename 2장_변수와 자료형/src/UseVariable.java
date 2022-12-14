import java.math.BigDecimal;
import java.util.Scanner;


public class UseVariable {
	//메소드(지역변수의 일종인 '매개변수':매개값을 받아서 해당 메소드가 호출되므로...)
	public static void main(String[] args) {	//로컬변수 = 지역변수:해당 메소드에서만 사용가능(중복된 이름의 변수는 사용불가)
		/*
		 * = (대입연산자)  		==(같다)	3==3
		 * 반드시 왼쪽에는 '변수'만 존재함 = 오른쪽에는 리터럴(1, -2, '1' 등) 또는 메소드 또는 연산식...
		 */
		
		/*** 논리형 : 참(true) or 거짓(false) *********************/
		System.out.println("----- 논리형 ------------------------");
		
		boolean b = true;	// 자료형 변수명 = 리터럴
		System.out.println(b);	// 변수 안의 값 출력
		
		b = false;	// 변수 안의 값을 변경
		System.out.println(b);
		
		// 논리형은 참과 거짓을 판별하는 if문(조건 참/거짓)
		if(b) System.out.println("조건이 참이면 실행");
		else System.out.println("조건이 거짓이면 실행");
		
		if(true) System.out.println("참1");
		else System.out.println("거짓1");
		
		if(false) System.out.println("참2");
		else System.out.println("거짓2");
		
		/*** 정수 : 음수 0 양수 *********************/
		System.out.println("----- 정수형 ------------------------");
		int i;	// 변수 선언
		i = 7;	// 변수 초기화
		
		int i2 = 3;		// 변수 선언과 동시에 초기화
		
		if(i == i2) System.out.println("1-두수가 같다.");
		else System.out.println("1-두수가 다르다.");
		
		i2 = 7;
		if(i == i2) System.out.println("2-두수가 같다.");
		else System.out.println("2-두수가 다르다.");
		
		
		Scanner sc = new Scanner(System.in);	//SC:참조변수(반드시 객체의 주소)
		
		System.out.print("정수 입력>");
		int num1 = sc.nextInt(); // 정수를 읽어들임
		
		System.out.print("정수 입력>");
		int num2 = sc.nextInt(); // 정수를 읽어들임
		
		System.out.println(num1 + num2);
		
		if(num1 > num2) System.out.println("앞의 정수가 크다.");	
		else if(num1 < num2)System.out.println("뒤의 정수가 크다.");	// else num1<=num2
		else System.out.println("두수가 같다.");
		
		
		int i3 = 12, i4 = 15;	// 같은 타입
		
		int i5, i6;	// 선언
		i5 = 20; i6 = 30;	// i5 = 20, i6 = 30; (오류)
		
		/*
		 * 자료형 변수형 = 리터럴
		 * 리터럴(이름없는 메모리에 저장):정수-int 타입 4바이트, L:8바이트
		 * 						 실수-double 타입 8바이트, f/F:float 타입 4바이트
		 */
		short s = (short)123456;	// 강제 형변환 후 데이터 손실 발생
		System.out.println("short로 형변환한 값 : "+s);
		
		int s2 = 123456;
		System.out.println(s2);
		
		//자동형변환 : 자료형 큰 범위 = 작은 범위
		long s3 = 123456;	//long(8) = int(4) : int가 long으로 "자동형변환"되어 대입
		
		long i7 = 12345678912L;	//L:4->8바이트(long)
		System.out.println("i7="+i7); 	// 데이터 손실X
		
		int i8 = (int)12345678912L; //강제 형변환 후 데이터 손실 발생
		System.out.println("i8="+i8);
		
		int i9 = (int)123L; //강제 형변환 하여도 데이터 손실 발생 안함(이유?잘린 앞의 4바이트엔 의미없는 0으로 채워져서)
		System.out.println("i9="+i9);
		
		/*** 실수 : float(4), double(8) 정밀도가 double이 좋다. *********************/
		float f = 1;	//1(정수) -> 1.0(실수 float)로 자동형변환되어 대입
		System.out.println("f="+f);
		
		double d = 1;	//1(정수) -> 1.0(실수 double)로 자동형변환되어 대입
		System.out.println("d="+d);
		
		float f2 = 1.0F;	//1.0(double) -> 1.0(F:float)
		System.out.println("f2="+f2);
		
		float f3 = 12345678912L; 	//long이 float으로 자동형변환되어 대입
		System.out.println("f3="+f3);
		
		double d2 = 12345678912L;	//long이 double로 자동형변환되어 대입
		System.out.println("d2="+d2);
		
		b = true;
		/*
		 * 정수 연산 : 연산결과로 오차 발생 안 함(연산결과가 정확)
		 * 정수는 cpu의 연산장치 4바이트(int)에 담겨 연산됨=>따라서, 연산결과도 4바이트(int)
		 */
		short sh1 = 12, sh2 = 7;
		//short sh3 = (short) (sh1 + sh2);	//19 : 데이터 손실 발생 가능성 있음
		int sh3 = sh1 + sh2;
		System.out.println("sh3="+sh3);
		
		sh1 -= sh2;	// 5 +=복합대입연산자 [자동형변환 규칙 예외사항]복합대입연산자를 사용하면 자동으로 형변환되어 대입됨
		
		short sh4=30000, sh5=30000;
		long sh6 = sh4 + sh5;
		
		System.out.println("short 최대값="+Short.MAX_VALUE);
		System.out.println("short 최소값="+Short.MIN_VALUE);
		
		System.out.println("int 최대값="+Integer.MAX_VALUE);
		System.out.println("int 최소값="+Integer.MIN_VALUE);
		
		System.out.println("double 최대값=" + Double.MAX_VALUE);
		System.out.println("double 최소값=" + Double.MIN_VALUE);
		
		/*
		 * 실수 연산 : 연산결과로 오차 발생 가능성 있음
		 */
		double d3 = 0.0000001;
		System.out.println("d3="+d3);
		
		double d4 = 1.0000001;
		System.out.println("d4="+d4);
		
		System.out.println("d3+d4="+(d3+d4));	//1.0000002000000001 (오차)
		
		//**아래와 같이 사용하면 안됨 : 오차가 발생한 결과가 나옴
		//BigDecimal bigd3 = new BigDecimal(d3);	// 사용하면 오차가 발생한 값으로 객체 생성함.
		//BigDecimal bigd4 = new BigDecimal(d4);	// 사용하면 오차가 발생한 값으로 객체 생성함.
		
		//오차없이 연산결과 출력하는 방법-1
		//BigDecimal bigd3 = BigDecimal.valueOf(d3);
		//BigDecimal bigd4 = BigDecimal.valueOf(d4);
		
		//오차없이 연산결과 출력하는 방법-2
		//BigDecimal bigd3 = BigDecimal.valueOf(0.0000001);
		//BigDecimal bigd4 = BigDecimal.valueOf(1.0000001);
		
		//오차없이 연산결과 출력하는 방법-3 : "실수"문자열로 객체 생성하면 오차없는 결과
		BigDecimal bigd3 = new BigDecimal("0.0000001");
		BigDecimal bigd4 = new BigDecimal("1.0000001");
		
		BigDecimal bigResult = bigd3.add(bigd4);
		System.out.println("bigResult="+bigResult);	// 1.00000020
		
		bigResult = bigd4.subtract(bigd3);
		System.out.println("bigResult="+bigResult);	// 1.0000001
		
		/*** 문자 : char(2바이트:유니코드) 0~65535(65536개의 문자) *******************************************/
		System.out.println("--문자 : char(자바는 2바이트:'유니코드' 참조, C는 1바이트:'아스키코드' 참조) -----------");
		char c1;	// 변수 선언
		c1 = 'a';	// 변수 초기화(97의 2진수)
		System.out.println("c1="+c1); 	// 문자 출력
		
		char c2 = 'b', c3 = 'c', c4 = ' '; //'b':98의 2진수, 'c':99의 2진수, ' ':32의 2진수
		System.out.println(c2+","+c3+","+c4); // 229
		System.out.println((int)c2+","+(int)c3+","+ (int)c4);
		
		char c5 = '다';
		System.out.println((int)'가'+","+(int)'나'+","+ c5+"의 코드값=" + (int)c5);
		
		System.out.println((char)45796); 	// 다
		System.out.println((int)'다'); 	// 45796
		
		char c6 = 'A';	///65의 2진수
		System.out.println(c6+"의 코드값="+(int)c6);
		
		System.out.println('A'+32); //65의 2진수+32의 진수=97의 2진수=>97 출력
		System.out.println((char)32+'A'); // ' '(32) + 'A'(65)
		System.out.println((char)(32+'A')); //97의 2진수=>문자'a'
		
		c6 = (char) (c6+32);	//97의 2진수
		System.out.println(c6 + "=" + (int)c6);
		
		/*
		 * 자바는 유니코드 : 문자 2바이트 = 16Bit(16Bit로 표현 가능한 정보의 수:2의 16승=65536)
		 * 정수 0~65535에 1:1로 대응하는 '문자'가 존재
		 */
		int n1 = 97;	//97의 2진수
		System.out.println(n1+":" + (char)n1);
		
		n1 = 0xAC00;	//0x16진수(hex=16진수:0123...9ABCDEF)
		System.out.println(n1+":"+(char)n1);
		
		int n2 = 44032;	//10진수 -> 2진수로
		System.out.println(n2+":"+(char)n2);
		
		if(n1 == n2) System.out.println("두 수는 같다.");
		else System.out.println("두 수는 다르다.");
		
		char ch1 = '\uAC00';	// '\\u16진수'		'가'
		System.out.println(ch1 + ":" + (int)ch1);
		
		if(n1 == ch1) System.out.println("두 변수의 값은 같다.");
		else System.out.println("두 변수의 값은 다르다.");
		
		int n3 = 077; //08진수:0~7   ( 7 + 1 = 10)
		System.out.println("8진수77="+n3);	//10진수로 출력;
		
		int n4 = 0B1010; // 0B2진수(0,1)
		System.out.println("2진수1010="+n4);
		
		n4 = 01010; // 08진수(0~7)
		System.out.println("8진수1010="+n4);
		
		n4 = 0x1010; // 0x16진수(0~9ABCDEF)
		System.out.println("16진수1010="+n4);
		
		//이지스 교재 68p
		double dNum1 = 1.2;
		float fNum2 = 0.9F;
		
		int iNum3 = (int)dNum1 + (int)fNum2;	// 1.2->1   0.9->0		1+0 = 1
		System.out.println(iNum3);		// 1
		
		iNum3 = (int)(dNum1 + fNum2);	// 2.1->2 
		System.out.println(iNum3);	// 2
		
		// 정수와 실수가 연산을 할 때 같은 타입으로 연산(이 때, 정수->실수로 변환되어 연산됨)
		int n5 = 12;
		double d5 = 12;	// 12->12.0 형변환
		double result = n5 + d5;	//정수12가 12.0으로 자동형변환+12.0=24.0(실수 double)
		System.out.println(n5 + "+" + d5 + "=" + result);	// 24.0
		
		/* 자동 형변환 시 주의 사항 : 정수가 실수로 자동형변환 시
		 * 실수 	 =  부호(1)+지수부   +가수부
		 * float =  부호(1)+지수부(8)+가수부(23)
		 * double = 부호(1)+지수부(11)+가수부(52)
		 */
		int n6 = 1234567891;
		int n7 = 1234567891;
		
		float n8 = n7; //1234567891.0 실수로 자동형변환되어 대입(오차 발생O-가수부가 담기에 큰 수이므로)
		n7 = (int)n8;	// 1234567891.0 -> 1234567891 정수로 강제형변환하여 대입
		
		System.out.println(n6-n7); 	// 0?		-45가 결과로 나옴
		
		n6 = 1234567891;
		n7 = 1234567891;
		
		double n9 = n7; //1234567891.0 실수로 자동형변환되어 대입(오차 발생X-가수부가 담기에 충분한 수이므로)
		n7 = (int)n9;	// 1234567891.0 -> 1234567891 정수로 강제형변환하여 대입
		
		System.out.println(n6-n7); 	// 0?		0 결과로 나옴
		
		sc.close();  	// 스캐너 사용 후 반드시 닫아줘야함
	}

}
