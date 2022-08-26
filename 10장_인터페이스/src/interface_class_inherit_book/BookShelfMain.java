package interface_class_inherit_book;
/**
 * BookShelf(=책장) 클래스는 책을 넣은 순서대로 꺼낼 수 있는 클래스
 */
public class BookShelfMain {

	public static void main(String[] args) {
		BookShelf bookshelf = new BookShelf();
		//▼부모 인터페이스 = 자식객체;
		Queue queue = bookshelf;
		queue.endQueue("토지1");
		queue.endQueue("토지2");
		queue.endQueue("토지3");
		
		System.out.println("책장에 꽂힌 책의 수=" + queue.getSize());
		int size = queue.getSize(); //3
		/*
		System.out.println("[반복문 사용안함]");
		System.out.println(queue.firstQueue());
		System.out.println(queue.firstQueue());
		System.out.println(queue.firstQueue());
		*/
		
		System.out.println("[반복문 사용함]");
		/* queue 사이즈가 변화하기 때문에 그대로 사용X
		for(int i = 0; i < queue.getSize(); i++) {	//queue.getSize() : 3 -> 2 -> 1
			System.out.println(queue.firstQueue()); 
		}
		*/
		/** [출력결과] 
		    토지1
		    토지2
		    
		    "토지3" 출력안되는 이유? 반복문이 실행될 때 마다 queue.getSize()가 감소하므로
		 */
		
		//해결법:미리 queue.getSize()의 값을 변수(size)에 저장(16라인)
		for(int i = 0; i < size; i++) {
			System.out.println(queue.firstQueue()); 
		}
	}

}
