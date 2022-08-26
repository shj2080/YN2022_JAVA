package interface_abstract_inherit;

public interface Calc {
	//멤버변수는 모두 상수 - public static final 생략됨
	double PI = 3.14;
	int ERROR = -999999999; //오류값
	
	//추상메서드
	int add(int num1, int num2);
	int sub(int num1, int num2);
	int mul(int num1, int num2);
	double div(int num1, int num2);
	
	//추상메서드 아닌 예외 : 완성된 메서드
	//1. static 메서드 : 공유용=>재정의불가
	static int hap(int[] arr) {
		int hap = 0;
		
		for(int value:arr) {
			hap += value;
		}
		
		//myStaticMethod();
		return hap;
	}
	
	//2. default 메서드 : 필요시 재정의
	default void description() {
		System.out.println("정수 계산기를 구현합니다.");
		//myMethod();
	}
	
	//3. private 메서드 : 해당 인터페이스 안에서만 사용가능 (JDK1.9버전부터 정의가능)
	/*
	private void myMethod() {
		System.out.println("private 메서드입니다.");
	}
	
	private static void myStaticMethod() {
		System.out.println("private static 메서드입니다.");
	}
	*/
}
