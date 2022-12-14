/** [Stack 클래스]
 * Stack : 맨 나중에 추가된 데이터를 먼저 꺼내는 방식(LIFO : Last In First Out)
 * 
 * 가장 최근에 추가된 자료부터 반환해주므로
 * 가장 최근에 검색한 단어를 찾는다던가,
 * 장기 체스 같은 게임에서 수를 무를 때 응용할 수 있다.
 * 
 */
package stack;

import java.util.ArrayList;

//ArrayList로 Stack 구현하기 : 제공되는 Stack클래스는 존재하지만 내가 원하는 Stack을 만들기 위해서...
class MyStack {
	//멤버변수 : ArrayList 포함관계
	//[포함관계 순서-1]
	private ArrayList<String> arrayStack;

	MyStack() { //[포함관계 순서-2]
		arrayStack = new ArrayList<String>();
	}
	
	//[포함관계 순서-3]
	//외부에 노출된 메서드 - push, pop, size
	void push(String data) {
		arrayStack.add(data); //실질적인 메서드
	}
	
	String pop() { 
		//int number = arrayStack.size(); //실질적인 메서드
		int number = size();
		
		if(number == 0) {
			System.out.println("스택이 비었습니다.");
			return null;
		}
		
		return arrayStack.remove(number-1); //실질적인 메서드     (전체 size -1 = ArrayList의 마지막 index)
	}
	
	int size() { 
		return arrayStack.size(); //실질적인 메서드
	}
	
	boolean isEmpty() {
		return arrayStack.isEmpty(); //실질적인 메서드
	}
}//MyStack 클래스 끝

public class StackTest_ArrayList {

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		
		stack.push("A"); //0
		stack.push("B"); //1
		stack.push("C"); //2
		stack.push("D"); //3
		
		/*
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		*/
		
		/*
		 * D  C 결과 이유?
		 * stack.size() 비교하면
		 * 0<4 -> 1<3(참) -> 2<2(거짓)
		 */
		
		/*	[★문제가 생기는 반복문-사용금지★]
		for(int i = 0; i < stack.size(); i++) {
			System.out.println(stack.pop() + " ");   //D   C
		}
		
		System.out.println(); //커서 아래로
		System.out.println("----------------------");
		*/
		
		
		int size = stack.size(); 
		for(int i = 0; i < size; i++) { //변수를 stack size로 고정
			System.out.print(stack.pop());
		}
		System.out.println(); //커서 아래로
		System.out.println("----------------------");
		
		/* 다른 처리 방법 (i가 stack size 만큼 초기값이 주어지고 i--)
		for(int i = stack.size(); i > 0; i--) {
			System.out.println(stack.pop());
		}
		*/
		
	}

}
