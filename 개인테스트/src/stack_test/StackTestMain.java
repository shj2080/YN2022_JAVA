package stack_test;

class MyStack {
	//멤버변수
	private String[] stringStack;
	int top;	//저장된 데이터길이
	
	//생성자
	MyStack(int StackSize) {
		stringStack = new String[StackSize];
	}
	
	//메서드
	void push(String data) {
		if(top == stringStack.length) {		//저장된 데이터와 배열길이가 같을 때 추가하려는 경우
			System.out.println("스택이 전부 찼습니다.");
			return;
		}
		
		stringStack[top++] = data;  //스택에 저장
	}
	
	String pop() {
		if(top == 0) {
			System.out.println("스택이 비었습니다.");
			return null;
		}
		String value = stringStack[top-1];
		top--;
		
		return value; 	//스택에서 값 리턴 후 제거
	}
	
	int size() {
		return stringStack.length;
	}
	
} //MyStack 클래스 끝

public class StackTestMain {

	public static void main(String[] args) {
		MyStack mystack = new MyStack(3);		//Stack 크기 3
		System.out.println(mystack.size());
		
		mystack.push("a");
		mystack.push("b");
		mystack.push("c");
		mystack.push("d");
		
		System.out.println("마지막 값 : " + mystack.pop());
		System.out.println("마지막 값 : " + mystack.pop());
		System.out.println("마지막 값 : " + mystack.pop());
		System.out.println("마지막 값 : " + mystack.pop());
	}

}
