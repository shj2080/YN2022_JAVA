package inheritance_test;

public class CustomerMain {

	public static void main(String[] args) {
		int initPayMoney = 10000;
		
		Customer c1 = new Customer(1, "홍길동");
		int payMoney = c1.calcPrice(initPayMoney); 	//지불할 금액 (등급별로 할인 비율 다름, SILVER는 할인 없음)
		System.out.println(c1);
		System.out.println(c1.customerName + "님이 " + payMoney + "원을 지불하셨습니다.");
		System.out.println(c1.showCustomerInfo());
		
		GoldCustomer v1 = new GoldCustomer(2, "이순신");
		payMoney = v1.calcPrice(initPayMoney);
		System.out.println(v1.customerName + "님이 " + payMoney + "원을 지불하셨습니다.");
		System.out.println(v1.showCustomerInfo());
		payMoney = v1.calcPrice(initPayMoney);
		System.out.println(v1.customerName + "님이 " + payMoney + "원을 지불하셨습니다.");
		System.out.println(v1.showCustomerInfo());
		
		System.out.println("===========[할인비율]===============");
		c1.showSaleNOInfo();
		v1.showSaleInfo();
	}

}
