package interface_class_inherit_book; //교재_339p~
/**
 * BookShelf(=책장) 클래스는 책을 넣은 순서대로 꺼낼 수 있는 클래스
 */
public interface Queue { //FIFO(=First In First Out)
	//추상 메서드
	void endQueue(String title); //맨 마지막에 String title을 추가
	String firstQueue(); //제일 앞의 내용 반환
	
	int getSize();		 //현재 Queue에 있는 개수 반환
}
