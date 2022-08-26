package scannerstring;

import java.util.Scanner;	//클래스는 설계도

public class ScannerTest {

	public static void main(String[] args) {	//메서드안의 선언된 변수=>지역변수=(Local변수):기본타입(값), 클래스타입(주소)
		//키보드(=System.in)로부터 값을 입력받기 위해 Scanner객체 생성
		Scanner sc = new Scanner(System.in);	//Scanner 참조변수(주소)=Scanner객체 생성
		
		System.out.println("문장 입력 > ");
		//sc.nextLine();	//*버퍼의 제일 앞에 있는 엔터 처리방법 : ""값이 없는 문자열 객체 => 참조하지 않으면 쓰레기 객체, 향후 가비지컬렉터(=GC)가 삭제
		String str = sc.nextLine(); //*엔터까지 읽어들인 후 엔터를 버리고 나머지 문자들로 "문자열(=String)" 객체 생성
		System.out.println("문장 출력=" + str);
		
		/*
		 * 정수 nextInt(), 실수 nextDouble(), 단어 next() : 구분자(엔터, 스페이스바, 탭) 무시
		 */
		System.out.print("두 정수 입력 > ");
		int i1 = sc.nextInt();	//static 없는 메소드
		int i2 = sc.nextInt();
		//System.out.println("두 정수의 합="+(i1+i2));
		System.out.println(i1 + "+" + i2 + "=" +(i1+i2));
		System.out.println(i1 + "-" + i2 + "=" +(i1-i2));
		System.out.println(i1 + "*" + i2 + "=" +(i1*i2));
		System.out.println(i1 + "/" + i2 + "=" +((double)i1/i2));		//실수 출력
		
		System.out.println("문장 입력 > ");
		sc.nextLine();	//*버퍼의 제일 앞에 있는 엔터 처리방법 : ""값이 없는 문자열 객체 => 참조하지 않으면 쓰레기 객체, 향후 가비지컬렉터(=GC)가 삭제
		str = sc.nextLine(); //*엔터까지 읽어들인 후 엔터를 버리고 나머지 문자들로 "문자열(=String)" 객체 생성
		System.out.println("문장 출력=" + str);
		
		System.out.print("두 실수 입력 > ");
		double d1 = sc.nextDouble();
		double d2 = sc.nextDouble();
		
		System.out.println(d1 + "+" + d2 + "=" +(d1+d2));
		System.out.println(d1 + "-" + d2 + "=" +(d1-d2));
		System.out.println(d1 + "*" + d2 + "=" +(d1*d2));
		System.out.println(d1 + "/" + d2 + "=" +(d1/d2));
		
		System.out.print("두 단어 입력 > ");
		String s1 = sc.next(); //구분자 전까지 읽어들여 "문자열(=String)" 객체 생성
		String s2 = sc.next();
		System.out.println(s1 + "," + s2); 	//주소가 참조하는 문자열객체의 값이 출력
		//System.out.println(s1.toString() + "," + s2.toString());
		
		System.out.println("문장 입력 > ");
		sc.nextLine();	//*버퍼의 제일 앞에 있는 엔터 처리방법 : ""값이 없는 문자열 객체 => 참조하지 않으면 쓰레기 객체, 향후 가비지컬렉터(=GC)가 삭제
		str = sc.nextLine(); //*엔터까지 읽어들인 후 엔터를 버리고 나머지 문자들로 "문자열(=String)" 객체 생성
		System.out.println("문장 출력=" + str);
		//System.out.println("문장 출력=" + str.toString());
		
	}

}
