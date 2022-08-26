/*
 * 클래스 종류 3가지
 * 1.main() 있는 것 : 실행용
 * 2.main() 없는 것 : 라이브러리용(예:java.lang.*)
 * 3.실행용+라이브러리용
 * 
 * import는 public 있으면 모든 패키지의 클래스에서 해당 클래스를 import 가능함
 * 			public 없으면 같은 패키지의 클래스만 해당 클래스를 import 가능함
 */
package third;

import java.util.Scanner;
//이클립스 컴파일러가 컴파일('바이트코드'로 변환)하기 전에 자동으로 삽입
//import java.lang.*;	//java.lang 패키지 안의 모든 클래스를 import

public class OperationExample {

	public static void main(String[] args) {	// 프로그램의 시작
		/** 산술 연산자 + - * 나누기(/몫, %나머지) **/
		int iv1=10;
		int iv2=3;
		
		System.out.println(iv1 + iv2);
		System.out.println(iv1 - iv2);
		System.out.println(iv1 * iv2);
		//나누기 할 때 연산자 2가지 존재 이유? '정수'와 '정수'를 연산하면 '결과로 정수', 따라서 몫, 나머지 구함
		System.out.println(iv1 / iv2);// 몫 3(10/3=3)
		System.out.println(iv1 % iv2);// 나머지 1(10%3=1)
		
		System.out.println((double)iv1/iv2);	// 강제10.0/자동3.0=3.33333...실수
		
		System.out.println((double)(iv1/iv2));	//주의 : 몫3 -> 강제3.0
		
		/*
		 * 강제로 형변환하면 데이터 손실 발생 가능성 있음
		 * =>데이터 손실이 발생하기 전 점검
		 */
		byte b1 = (byte) 1234;
		System.out.println(b1);//데이터 손실!
		
		
		/*
		 * 비교(=관계) 연산자 : 수와 수를 비교 > < >= <= ==(같다) !=(같지 않다.다르다) ※sql 같지 않다 != <> ^=
		 * 				   65>97 -> 결과가 false
		 * 				   'A'(65의 2진수) < 'a'(97의 2진수) -> 결과가 true
		 * 
		 * 논리 연산자 : !단항연산자 (예) !(65>97) => !false => true
		 * 						  !('A'<'a') => !true => false
		 * 
		 * 				&&		(예) 65>97 && 'A'<'a' => false && => false
		 * 							둘 다 참일 때만 참
		 * 							65<97 || 'A'>'a' => true && false => false
		 * 
		 * 				||		(예) 65>97 || 'A'<'a' => false || true => true
		 * 							둘 중 하나만 참이면 참
		 * 							65<97 || 'A'>'a' = > true || => true
		 * 
		 * 				※sql : not 참 -> 거짓, and:둘 다 참이면 참, or:둘 중 하나만 참이면 참
		 * 
		 * 따라서, 비교연산자와 논리연산자는 '결과가 무조건 참 또는 거짓'이므로 '조건문'에서 많이 활용됨
		 * 
		 * 조건문은 무조건 결과가 참 또는 거짓이 나와야 함
		 * if(조건문) {조건문이 참이면 실행}
		 * else {조건문이 거짓이면 실행}
		 */
		int i = 300;
		System.out.println("그냥 i="+i);
		System.out.println("byte로 강제형변환된 i="+(byte)i);
		//i = (byte)i;
		System.out.println("i="+i);//300
		
		System.out.println("[방법-1]");
		//[방법-1] 300<(최소값-128) || 300>(최대값-127) => false || true => true
		if(i<Byte.MIN_VALUE || i>Byte.MAX_VALUE) {
			System.out.println(i+"은(는) byte 타입으로 변환할 수 없습니다.");
			System.out.println("값을 다시 확인해 주세요!");
		}else System.out.println("byte로 강제형변환된 i="+(byte)i);

		System.out.println("[방법-2]");
		//[방법-2] 300>=(최소값-128) && 300<=(최대값-127) => false || false => false
		if(Byte.MIN_VALUE <=i && i<=Byte.MAX_VALUE) {
			System.out.println("byte로 강제형변환된 i="+(byte)i);
		}else {
			System.out.println(i+"은(는) byte 타입으로 변환할 수 없습니다.");
			System.out.println("값을 다시 확인해 주세요!");
		}

		System.out.println("[방법-3]");
		//[방법-3] 300>=(최소값-128) && 300<=(최대값-127) => false && false => false => !false => true
		if(!(Byte.MIN_VALUE <=i && i<=Byte.MAX_VALUE)) {
			System.out.println(i+"은(는) byte 타입으로 변환할 수 없습니다.");
			System.out.println("값을 다시 확인해 주세요!");
		}else {
			System.out.println("byte로 강제형변환된 i="+(byte)i);
		}

		System.out.println("[방법-4]");
		//[방법-4] 300<(최소값-128) || 300>(최대값-127) => false || true => true => !true => false
		if(!(i<Byte.MIN_VALUE || i>Byte.MAX_VALUE)) {
			System.out.println("byte로 강제형변환된 i="+(byte)i);
		}else {
			System.out.println(i+"은(는) byte 타입으로 변환할 수 없습니다.");
			System.out.println("값을 다시 확인해 주세요!");
		}
		
		System.out.println("i="+i);//300
		
		i = 127;
		// 127<(최소값-128) || 127>(최대값-127) => false || false => false
		if(i<Byte.MIN_VALUE || i>Byte.MAX_VALUE) {
			System.out.println(i+"은(는) byte 타입으로 변환할 수 없습니다.");
			System.out.println("값을 다시 확인해 주세요!");
		}else System.out.println("byte로 강제형변환된 i="+(byte)i);
		
		
		System.out.println("*** && || 에 대해 부작용 발생가능성과 해결방법 ***");
		int i1 = 10, i2 = 2;	//i1 = 20
		boolean value = (i1 = i1 + 10) < 10 && (i2 = i2+2) < 10;	//false && => 결과 false
		System.out.println("value="+value); //false
		System.out.println("i1="+i1); //20
		System.out.println("i2="+i2); //2(부작용 발생)
		
		System.out.println(); // 구분용 빈줄
		
		i1 = 10;
		i2 = 2;	//i1 = 20
		value = (i1 = i1 + 10) > 10 || (i2 = i2+2) < 10;	//true || => 결과 true
		System.out.println("value="+value); //true
		System.out.println("i1="+i1); //20
		System.out.println("i2="+i2); //2(부작용 발생)
		
		System.out.println(); // 구분용 빈줄
		
		i1 = 10;
		i2 = 2;	//i1 = 20, i2=4
		value = (i1 = i1 + 10) < 10 || (i2 = i2+2) < 10;	//false || true => 결과 true
		System.out.println("value="+value); //true
		System.out.println("i1="+i1); //20
		System.out.println("i2="+i2); //4(부작용 발생X)
		
		System.out.println(); // 구분용 빈줄
		
		i1 = 10;
		i2 = 2;	//i1 = 20
		value = (i1 += 10) > 10 && (i2 += 2) < 10;	//true && true => 결과 true
		System.out.println("value="+value); //true
		System.out.println("i1="+i1); //20
		System.out.println("i2="+i2); //4(부작용 발생X)
		
		System.out.println(); // 구분용 빈줄
		
		System.out.println("--부작용 해결 방법-------------------");
		i1 = 10; i2 = 2;	//i1 = 20
		i2 = i2 + 2;
		value = (i1 = i1 + 10) < 10 && i2 < 10;	//false && => 결과 false
		System.out.println("value="+value); //false
		System.out.println("i1="+i1); //20
		System.out.println("i2="+i2); //4(부작용 없어짐)
		
		System.out.println(); // 구분용 빈줄
		
		i1 = 10; i2 = 2;	//i1 = 20
		i2 = i2 + 2;
		value = (i1 = i1 + 10) > 10 || i2 < 10;	//true || => 결과 true
		System.out.println("value="+value); //true
		System.out.println("i1="+i1); //20
		System.out.println("i2="+i2); //4(부작용 없어짐)
		
		System.out.println(); // 구분용 빈줄
		
		System.out.println("** 정수 자료형의 값은 사이클을 돈다. \"최대값+1=최소값\" ** \n");
		byte b =  126;	//★대입연산자를 통해서만 변수의 값이 변경된다.
		System.out.println(b+1);//127
		System.out.println(b);//126
		
		++b;//b=b+1;
		System.out.println(b);//127(최대값)
		
		b++;//b=b+1;	최대값+1=최소값
		System.out.println(b);//-128(최소값)
		
		System.out.println(++b);//b=b+1; 증가 후 출력 -127
		System.out.println(b++);//-127 출력 후 b=b+1; 증가
		System.out.println(b);//-126
		
		/*
		 * 단항연산자 ++b		b=b+1
		 * 		  b++		b=b+1
		 * ++ 단독일 때는 자신의 값을 1증가
		 * 
		 * 단항연산자 --b		b=b-1
		 * 		  b--		b=b-1
		 * -- 단독일 때는 자신의 값을 1감소
		 */
		int a1 = 10, a2 = 20, a3;
		a1++;	//단독 a1=a1+1;	a1=11
		++a1;	//단독 a1=a1+1;	a1=12
		System.out.println(a1+", " + a2);	//12, 20
		
		System.out.println(a1+", " + ++a2);	//a2값을 1 증가 후 출력 12, 21
		System.out.println(a1+", " + a2++);	//출력 후 a2값을 1 증가 12, 21
		
		System.out.println(a1+", " + a2);	//12, 22
		//단항 연산자의 ()는 가독성을 높일 뿐 우선순위를 바꾸는 것이 아니다.
		
		System.out.println(a1+", " +(++a2));	//a2값을 1 증가 후 출력 12, 23
		System.out.println(a1+", " + (a2++));	//출력 후 a2값을 1 증가 12, 23
		
		System.out.println(a1+", " + a2);	//12, 24
		
		/*
		 * ++ 또는 -- 단독이 아닐 때, 앞에 있으면 '가장 먼저' 실행
		 * 						 뒤에 있으면 '가장 마지막에' 실행
		 */
		a1 = 10; a2 = 20;
		a3 = ++a1 + a2--;
		//a1=11 -> 11+20 = 31 -> 31을 a3에 대입 -> a2=19
		System.out.println(a1+"," + a2 + "," + a3);
		
		/*
		 * 부호(+,-)도 연산자이다. -1, +1
		 */
		int n1 = 5;
		System.out.println(n1);//5
		System.out.println(+n1);//5
		System.out.println(-n1);//-5
		
		short n2 = 7;
		short n3 = (short) +n2;//정수(int) -> short에 대입하려니 문제발생 -> 강제형변환하여 대입(데이터 손실 발생 가능성)
		int n4 = +n2;
		
		/*
		 * 복합 대입 연산자 : 이지스 교재 80p 참조
		 */
		i = 1;	//대입연산자
		i++;	// i=i+1; i값은 2
		
		i += 1;//i=i+1; 복합 대입 연산자.  i값은 3
		i += 3;//i=i+3;	i값은 6
		i -= 3;//i=i-3;	i값은 3
		i *= 3;//i=i*3;	i값은 9
		i /= 2;//i=i/2;	i값은 4
		i %= 2;//i=i%2;	i값은 0
		
		i2 = 7;
		i += i2;
		System.out.println(i);
		
		/*
		 * 단항연산자 : !, ++, --, ~
		 * 
		 * 논리연산자 : !참 <-> 거짓, &&:둘 다 참이면 참, ||:둘 중 하나만 참이면 참
		 * 			 논리 연산자는 참 또는 거짓을 다룸
		 * 
		 * '비트'연산자 : 비트연산자는 1 또는 0을 다룸 
		 * 			  	~2진수1<->2진수0 		(예)~1010 => 0101, ~1000 => 0111
		 * 			  	&:둘 다 1이면 1 		(예)1&1=>1
		 * 				|:둘 중 하나만 1이면 1 	(예)1|0=1
		 * 				^:다르면 1			(예)1^0=1, 0^1=1, 0^0=0, 1^1=0
		 * 
		 * 비트이동연산자로 '산술연산'을 할 수 있다.
		 * << 곱하기		>> 나누기(몫)		>>>
		 */
		int num1 = 5, num2 = 3;
		System.out.println("5의 2진수="+Integer.toBinaryString(num1));//5의 "2진수" 101
		System.out.println("3의 2진수="+Integer.toBinaryString(num2));//3의 "2진수" 11
		
		System.out.println("5&3="+(num1&num2));
		System.out.println("5|3="+(num1|num2));
		System.out.println("5^3="+(num1^num2));
		
		System.out.println("~5=" + ~num1);//-6
		System.out.println("~5+1="+ (~num1+1));//-5
		
		System.out.println(~7+1);//-7
		System.out.println(~(-7)+1);//7
		
		/** 비트이동연산자 : 
		 * 수<<이동하는 비트수 => 수*2의 비트수승			0으로 채워짐
		 * 수>>이동하는 비트수 => 수/2의 비트수승 (몫)	양수는 0으로 채워짐, 음수는 1로 채워짐
		 **/
		System.out.println(2<<1);	// 수2*2=4
		System.out.println(2<<2);	// 수2*2*2=8
		System.out.println(2<<3);	// 수2*2*2*2=16

		System.out.println(3<<1);	// 수3*2=6
		System.out.println(3<<2);	// 수3*2*2=12
		System.out.println(3<<3);	// 수3*2*2*2=24
		
		System.out.println(16>>2);	// 16/2=8/2=4
		System.out.println(16>>3);	// 16/2=8/2=4/2=2
		
		//[문제] : 음수(0보다 작다)를 양수 바꾸기------------------
		int x = -10;
		
		if(x >= 0) {	// x가 양수라면
			//System.out.println(x);
		} else {		// x < 0
			x = -x;//-(-10) = 10
			//System.out.println(x);
		}
		System.out.println(x);
		//System.out.println(x+"=>" + x);
		/*------------------------------------*/
		x = -10;
		int x2;//x:값은 그대로 보전, x2에 변경된 값을 대입
		if(x >= 0) {	// x가 양수라면
			x2 = x;
			//System.out.println(x);
		} else {		// x < 0
			x2 = -x;//-(-10) = 10
			//System.out.println(x);
		}
		//System.out.println(x);
		System.out.println(x+"=>" + x2);	//-10 => 10
		
		/*
		 * Scanner 객체 생성하여 키보드로부터 입력받은 값을 x에 대입 후 음수이면 양수로 변환시켜 출력
		 * 6번 반복(반복문 사용 안함)
		 */
		Scanner sc= new Scanner(System.in);
		
		System.out.print("1.정수 입력:");
		x = sc.nextInt();
		
		if(x >= 0) {	// x가 양수라면
			x2 = x;
		} else {		// x < 0
			x2 = -x;//-(-10) = 10
		}
		System.out.println(x+"=>" + x2);	//-10 => 10
		
		System.out.print("2.정수 입력:");
		x = sc.nextInt();
		
		if(x >= 0) {	// x가 양수라면
			x2 = x;
		} else {		// x < 0
			x2 = -x;//-(-10) = 10
		}
		System.out.println(x+"=>" + x2);	//-10 => 10
		
		System.out.print("3.정수 입력:");
		x = sc.nextInt();
		
		if(x >= 0) {	// x가 양수라면
			x2 = x;
		} else {		// x < 0
			x2 = -x;//-(-10) = 10
		}
		System.out.println(x+"=>" + x2);	//-10 => 10
		
		/** 조건연산자  (조건문)?참:거짓 **/
		System.out.print("4.정수 입력:");
		x = sc.nextInt();
		x2 = ((x>=0)?x:-x);
		System.out.println(x+"=>"+x2);

		System.out.print("5.정수 입력:");
		x = sc.nextInt();
		x2 = ((x>=0)?x:-x);
		System.out.println(x+"=>"+x2);
		
		System.out.print("6.정수 입력:");
		x = sc.nextInt();
		x2 = ((x>=0)?x:-x);
		System.out.println(x+"=>"+x2);
		
		//"4장_조건문과 반목문에서" 위 긴 소스코드를 반복문을 이용하여 간단하게 처리
		/*
		for(변수 선언과 동시에 초기화;조건문 참;변수증가/감소) {
			반복해서 실행될 실행문;
		}
		*/
		for(int k = 1; k <= 3; k++) {	//3번 반복
			System.out.print(k +".정수 입력:");
			x = sc.nextInt();
			x2 = ((x>=0)?x:-x);
			System.out.println(x+"=>"+x2);
		}
		
		
		sc.close();
	}	// 프로그램의 끝

}
