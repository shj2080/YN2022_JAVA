/**
 * 함수형 프로그래밍 (FP : Functional Programming)
 * 
 * 자바 제공 함수형 프로그래밍 방식 : 람다식 (Lambda expression)
 * - 매개변수 자료형 생략 가능
 * - 매개변수가 하나일 경우 매개변수 감싸는 괄호 생략 가능하나, 2개 이상일 경우 괄호 생략 불가
 * - 구현부가 1줄일 경우 중괄호 생략 가능하나, 구현부가 2줄 이상일 경우 반드시 중괄호 사용
 * 
 * 예)
 * [기존 함수 구현]
 * int add(int x, int y) {
 * 	return x + y;
 * }
 * 
 * [람다식 사용]
 * (int x, int y) -> {return x + y;}
 * 
 */
package lambda;

//함수형 인터페이스
@FunctionalInterface	//애노테이션으로 함수형 인터페이스임을 명시적으로 표기, 필수는 아니지만 오류 발생 시 참고 가능
public interface MyNumber {
	int getMax(int num1, int nu2); //구현할 클래스에서 반드시 재정의 해야함.
	//람다식으로 인터페이스 내 메서드를 구현할 경우 인터페이스에는 하나의 메서드만 선언할 수 있음.
	//2개 이상의 메서드를 선언하면 오류 발생함
}
