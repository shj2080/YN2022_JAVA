package interfaceex_book;

public class CustomerMain {

	public static void main(String[] args) {
		//인터페이스도 부모역할
		//Buy buyer = new Customer();
		Customer customer = new Customer();
		Customer2 customer2 = new Customer2();
		
		System.out.println("--[Buy]--");
		Buy buyer = customer;
		buyer.buy(); 	//재정의
		buyer.order(); //재정의
		
		System.out.println("--[Sell]--");
		/**
		 * Sell를 구현한 클래스-1을
		 * Sell을 구현한 클래스-2로 변경해도 아래 소스는 그대로 사용
		 * (※ 이때, 프로그램 상황에 맞게 변경)
		 */
		Sell seller = customer; 	//Sell를 구현한 클래스-1을
		//Sell seller = customer2;  //Sell을 구현한 클래스-2로 변경해도 아래 소스는 그대로 사용
		
		seller.sell(); //재정의
		seller.order(); //재정의
		
		System.out.println("--[Customer]--");
		customer.order();
		
		System.out.println("--[자식에 추가된 멤버 사용하기 위해]--");
		if(seller instanceof Customer) { 	//seller 참조객체가 Customer인 경우
			Customer c = (Customer)seller;
			c.customerMethod();
		}else if(seller instanceof Customer2) {
			Customer2 c2 = (Customer2)seller;
			c2.customerMethod();
		}
		
	}

}
