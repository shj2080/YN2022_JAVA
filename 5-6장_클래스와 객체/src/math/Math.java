/* 라이브러리용 : main()없는 클래스
 * 
 * [static 메서드가 되는 조건]
 * 1. 조건 : 메서드()가 static없는 멤버변수를 필요로 하지 않고
 * 			"static 있는 멤버변수 또는 매개변수"를 필요로 한다.
 * 			이 조건을 만족하면 메서드 앞에 static 붙일 수 있다.
 * 			즉, static없는 멤버변수를 필요로 하지 않을 때
 * 
 * static 있는 멤버변수나 메서드는 해당 클래스(Math.class)가 메모리에 로딩될 때 메모리에 올라옴
 * static 없는 멤버변수나 메서드는 생성자로 객체 생성하여 메모리에 올라올 때 그 객체 안에 존재
 */

package math;

public class Math { //수학 관련 클래스
	//1. 멤버변수(=field) : 속성
	public static final double PI = 3.14; //공유 + 값변경 불가
	
	//2. 생성자 : 반드시 존재
	//생성자가 없으면 컴파일러가 기본생성자 자동 삽입 public Math() {super();}
	//클래스 안의 모든 멤버들이 static 일 때 private 생성자로 만듦
	private Math(){}
	
	//3. 메서드 : 기능
	/* 메서드 오버로딩 : 같은이름의 메서드 정의 가능(단, 매개변수의 타입이나 수가 달라야 한다.)
	 * 생성자 오버로딩 : 
	 */
	//원의 넓이=반지름 * 반지름 * 3.141592...(원주율)
	public static double circleArea(int r) { //반지름
		return r * r * PI;
	}
	
	public static double circleArea(double r) { //반지름
		return r * r * PI;
	}
	
	//원의 둘레=2*반지름*3.14...
	public static double circleLength(int r) { //반지름
		return 2 * r * PI;
	}
	
	public static double circleLength(double r) { //반지름
		return 2 * r * PI;
	}
	
	//두 정수를 더하여 결과 리턴
	public static int add(int num1, int num2) { //두 매개변수로 두 매개값(=정수)을 입력받아
		return num1 + num2;	//두 수를 더한 결과를 리턴
	}
	
	//두 정수를 곱하여 결과 리턴
	public static int mul(int num1, int num2) {
		return num1 * num2;
	}
	
	/*------------------------------------------------------------------------------------------*/
	//★★	... 가변인수 : 여러 매개값들을 "배열"로 처리	(매개변수=인수=argument)
	//매개값들의 수 = 배열의 크기
	public static double add(double...num) { //Math.add(10,20,30)	배열객체[10.0,20.0,30.0]
		double result = 0;	//★초기값 주의
		
		int i; //index : 0부터 시작 (※SQL : 1부터 시작)
		/*
		for(i=0; i < num.length; i++) { //length : 배열의 멤버변수(배열의 길이, 읽기전용)
			result += num[i]; //0+10.0+20.0+30.0
		}
		*/
		
		//향상된 for문 사용 : index이용X -> 그래서 값참조만 가능, 값변경 불가
		for(double value:num) {
			result += value;
		}
		
		return result; //60.0
	}
	
	public static double mul(double...num) {
		double result = 1;	//★초기값 주의 (곱할 때는 1로 초기화)
		
		for(int i = 0; i < num.length; i++) {
			result *= num[i];
		}
		
		return result;
	}
	
	public static double max(double...num) {
		double result = num[0];
		
		int i;
		for(i = 1; i < num.length; i++) {
			
		}
		
		return result;
	}
}
