/** [Queue 인터페이스]
 * Queue : '선착순'
 * 			줄을 선 대기열처럼 먼저 추가된 데이터부터 꺼내서 사용하는 방식 (FIFO : First In First Out)
 */
package queue;

import java.util.ArrayList;

//ArrayList로 Queue 구현하기
class MyQueue {
	//멤버변수 : ArrayList 포함관계
	//[포함관계 순서-1]
	private ArrayList<String> arrayQueue;

	MyQueue() { //[포함관계 순서-2]
		arrayQueue = new ArrayList<String>();
	}
	
	//[포함관계 순서-3]
	//외부에 노출된 메서드
	void offer(String data) { //Queue의 맨 뒤에 추가
		arrayQueue.add(data); //실질적인 메서드
	}
	
	String poll() { //큐의 맨 앞에서 꺼내어 제거 
		//int number = arrayQueue.size(); //실질적인 메서드
		int number = size();
		
		if(number == 0) {
			System.out.println("큐가 비었습니다.");
			return null;
		}
		
		return arrayQueue.remove(0); //실질적인 메서드
	}
	
	int size() { 
		return arrayQueue.size(); //실질적인 메서드
	}
	
	boolean isEmpty() {
		return arrayQueue.isEmpty(); //실질적인 메서드
	}
}//MyQueue 클래스 끝

public class QueueTest_ArrayList {

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		
		queue.offer("A");
		queue.offer("B");
		queue.offer("C");
		queue.offer("D");
		
		/*
		System.out.println("----[방법-1]----");
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		*/
		
		
		System.out.println("----[방법-2]----");
		int size = queue.size();  //변수를 queue size로 고정
		for(int i = 0; i < size; i++) { 
			System.out.print(queue.poll() + " "); //A B C D
		}
		System.out.println(); //커서를 아래로
		
		/*
		System.out.println("----[방법-3]----");
		while(!queue.isEmpty()) {
			System.out.print(queue.poll() + " "); //A B C D
		}
		System.out.println(); //커서를 아래로
		*/
		
		/*
		System.out.println("----[방법-4]----");
		for(int i = queue.size() ; i > 0; i--) {
			System.out.print(queue.poll() + " "); //A B C D
		}
		System.out.println(); //커서를 아래로
		*/
	}

}
