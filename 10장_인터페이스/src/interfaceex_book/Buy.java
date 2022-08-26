package interfaceex_book; //교재_333p ~ 
/**
 * 한 클래스가 여러 인터페이스를 구현하는 경우
 *
 */
public interface Buy {
	void buy(); 			//반드시 재정의
	
	default void order() { //필요 시 재정의
		System.out.println("구매 주문");
	}
}
