/** [Queue 인터페이스]
 * Queue : '선착순'
 * 			줄을 선 대기열처럼 먼저 추가된 데이터부터 꺼내서 사용하는 방식 (FIFO : First In First Out)
 * 
 * LinkedList : List<E>, Queue<E> 인터페이스 구현함
 */
package queue.mail;

import java.util.LinkedList;
import java.util.Queue;

public class MailQueueMain {

	public static void main(String[] args) {
		//부모 Queue 인터페이스 = 구현한 객체
	 	Queue<Mail> mail = new LinkedList<Mail>();
		
	 	//메일이 큐에 순서대로 저장 : 재정의된 offer() 호출	  (offer()안에서 add()호출한 결과를 다시 리턴)
	 	mail.offer(new Mail("권은재", "안부인사"));
	 	mail.offer(new Mail("박혜나", "여행계획"));
	 	mail.offer(new Mail("김은경", "볼링계모임"));

	 	mail.offer(new Mail("장혜원", "안부인사"));
	 	
	 	System.out.println(mail.peek());	//객체 하나를 꺼내서 리턴하지만 큐에서 제거하지는 않는다.
	 	
	 	System.out.println("\n** [큐에서 객체 하나씩 꺼내서 제거] **");
	 	
	 	while(!mail.isEmpty()) { //큐가 비어있지 않는 동안
	 		Mail eachMail = mail.poll();	//객체 하나를 꺼내서 리턴 후 큐에서 제거한다.
	 		
	 		switch(eachMail.getMailTitle().substring(0, 1+1)) { //시작index~끝index+1
		 		case "안부":
		 			System.out.println(eachMail);
		 			System.out.println("안부인사합니다.~");
		 			break;
		 		case "여행": 			
		 			System.out.println(eachMail);
		 			System.out.println("여행갑니다.~");
		 			break;
		 		case "볼링":
		 			System.out.println(eachMail);
		 			System.out.println("볼링 치러 갑시다.~");
		 			break;
	 		} //switch문 끝
	 	}//while문 끝
	 	
	 	System.out.println("큐에 남은 Mail 객체 수 : " + mail.size());
	}

}
