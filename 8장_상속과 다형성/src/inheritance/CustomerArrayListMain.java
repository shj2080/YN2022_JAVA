package inheritance;

import java.util.ArrayList;

public class CustomerArrayListMain {

	public static void main(String[] args) {
		//Customer과 Customer자손객체만 저장가능한 ArrayList 생성
		ArrayList<Customer> customerList = new ArrayList<>(); //ArrayList<Customer> 타입이 앞에 정의된 경우 앞의 new ArrayList<> 에 클래스 생략 가능
		
		customerList.add(new Customer(1, "장혜원"));
		customerList.add(new GoldCustomer(2, "김채우"));		//Customer형으로 UpCasting 됨.
		customerList.add(new VIPCustomer(3, "조용원", 1234));	//Customer형으로 UpCasting 됨.
		
		
		System.out.println("================== 고객 정보 출력 ========================");
		System.out.println(customerList);
		//System.out.println(customerList.toString()); //ArrayList는 자체적으로 toString() 재정의 되어 있음 [주소1, 주소2, 주소3]
		
		for(Customer c:customerList) {
			System.out.println(c.showCustomerInfo()); //자식의 재정의된 메서드 호출됨
		}
		
		System.out.println("================= 지불가격과 보너스포인트 출력 =====================");
		int productPrice = 10000;
		System.out.println("[제품가격 " + productPrice + "원에 대해] \n");
		
		for (Customer c:customerList) {
			int cost = c.calcPrice(productPrice); //자식의 재정의된 메서드 호출됨
			System.out.println(c.customerName + "님이 " + cost + "원을 지불하셨습니다.");
			System.out.println(c.customerName + "님의 현재 보너스 포인트는 " + c.bonusPoint + "점입니다.");
			//c.showSaleRatio();
			System.out.println();  //구분위한 빈줄
		}
		
		System.out.println("================= 고객의 세일비율 출력 =====================");
		//원래는 showSaleRatio()메서드를 재정의하는 것으로 설계하는 것이 좋으나 문법적인 설명을 위해 이름을 다르게 함
		/*
		for (Customer c:customerList) {
			c.showNOSaleRatio();
		}
		*/
		 
		//가장 마지막 자손클래스 부터 instanceof 로 구분(동등한 관계에 있는 자손클래스가 여러 개 있는 경우 그 중 아무거나)
		for (Customer c:customerList) {
			/* customerList가 참조하는 객체의 첫번째 값(=Customer객체주소)을  가져와
			 * -> Customer타입의 지역변수 c에 저장
			 * 
			 * [자손의 추가된 메서드를 호출하는 방법]
			 * 컴파일러가 자손객체를 부모인 Customer타입으로 인식하므로 자손의 추가된 메서드를 호출할 수 없으므로
			 * 어떤 자손객체인지 먼저 if문( instanceof )을 통해 확인 후
			 * -> 해당 자손객체로 강제형변환하여
			 * -> 자손에 추가된 메서드 호출가능함
			 * (★단, 가장 마지막 자손부터 확인)
			 */
			//c가 참조하는 객체가 VIPCustomer객체 또는 그 자손객체이면 true
			if(c instanceof VIPCustomer) {
				VIPCustomer vip = (VIPCustomer) c;
				vip.showSaleRatio();
			}else if(c instanceof GoldCustomer) { //c가 참조하는 객체가 GoldCustomer객체 또는 그 자손객체이면 true
				((GoldCustomer) c).showSaleRatio();
			}else //부모
				c.showNOSaleRatio();
			
			
		}
	}

}
