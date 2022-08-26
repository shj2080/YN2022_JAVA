/*
 	주석 : 소스 이해용 설명 달기 - 컴파일 되지 않는 참고용 문구(컴파일러가 '바이트코드'로 번역안하고 건너띔)
 	2줄 이상
 */
package second;		// 패키지 = 폴더 : 소문자

//import java.lang.*;		// 이클립스 컴파일러가 컴파일 하기 전에 자동으로 삽입
public class Hello {	// 클래스명 : 반드시 대문자로 시작

	public static void main(String[] args) {		// 메소드 = 함수 : 소문자로 시작~(), 프로그램의 시작과 끝을 담당
		// 주석 : 1줄 설명 달 때
		System.out.println(1);			// 정수
		System.out.println(-1);			// 정수
		System.out.println(1+2);		// 정수 + 정수 연산
		System.out.println('1');		// '문자1개'(문자1은 메모리에 49의 2진수로 변환되어 표현됨)
		System.out.println((int)'1');	// '문자1개'(정수integer로 출력)
		System.out.println("1");		// "문자열"(String 클래스)
		
		System.out.println("문자열 입력한 그대로 출력(단, 이스케이프 문자 제외)");
		System.out.println("Next\n");		// 다음줄로
		System.out.println("탭 크기만큼\t띄워쓰기");
		
		/*
		 * + : 2가지 기능
		 * 첫째, 수+수 => 더하는 연산자
		 * 둘째, "문자열"+수=수+"문자열"=>문자열을 연결하는 +
		 */
		System.out.println("2+5="+2+5);		// "2+5="+"2"(문자열) => "2+5=2"+5 => "2+5=25"
		System.out.println("2+5="+(2+5));		// "2+5=7"
		
		System.out.println("2-5="+(2-5));		// "2+5=" + "-3" => 2-5=-3
		System.out.println("2*5="+2*5);
		System.out.println("5/2="+5/2);		//몫
		
	} // main()의 끝 = 프로그램의 끝

}
