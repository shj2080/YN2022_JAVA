package inheritance;

public class GoldCustomer extends Customer {
	/**
	 * 부모의 멤버(멤버변수, 메서드)를 상속(단, 생성자, private, 초기화 블럭 상속불가)
	 * + 자식만의 특징(속성이나 기능) 추가
	 */
	
	//1. 멤버변수 = 부모(5) + 자식추가(1)
	public double saleRatio; 	//세일비율(실수) 추가 : "Gold"부터 물건을 살 때 세일을 해 줌

	//2. 생성자 : 고객 등급 = "Gold", 적립 비율=0.02=2%, 세일 비율=0.05=5%
	//매개변수가 있는 생성자(고객 아이디, 고객 이름)
	public GoldCustomer(int customerID, String customerName) {
		//1. 부모생성자를 매개값을 가지고 호출하여 먼저 부모객체 생성
		super(customerID, customerName);
		//2. 그대로 상속받아 자식에서 변경하고자 하는 멤버변수의 값으로 변경
		customerGrade = "GOLD";
		bonusRatio = 0.02;
		
		saleRatio = 0.05; 	//5% 세일
	}

	//3. 메서드 : 어디서든지 접근 가능(public)
	//상속받은 메서드 + 메서드 추가
	@Override
	public int calcPrice(int productPrice) { 	//물건값이 10000원 이라면
		bonusPoint += productPrice * bonusRatio; // 10000 * 0.02 = 200
		//return productPrice - (int)(productPrice * saleRatio); //10000-500=9500원 지불
		return (int)(productPrice * (1 - saleRatio)); // 10000 * (1 - 0.05) = 10000 * 0.95 = 9500.0(실수) -> 9500
	}

	//showCustomerInfo() : 재정의하지 않고 그대로 상속 받아 사용
	/*
	public String showCustomerInfo() {
		return customerName + "님의 등급은 " + customerGrade + "이며, 보너스 포인트는 " + bonusPoint + "점 입니다.";
	}
	*/
	
	//Customer로부터 상속받은 메서드 중 "주소만으로도 String을 리턴하는" 메서드 찾아 재정의
	@Override
	public String toString() {
		return "GoldCustomer [saleRatio=" + saleRatio + ", customerID=" + customerID + ", customerName=" + customerName
				+ ", customerGrade=" + customerGrade + ", bonusPoint=" + bonusPoint + ", bonusRatio=" + bonusRatio
				+ "]";
	}

	/************** get~() set~() *****************/
	//자식에만 추가한 메서드
	public final double getSaleRatio() {
		return saleRatio;
	}

	/*
	public final void setSaleRatio(double saleRatio) {
		this.saleRatio = saleRatio;
	}
	*/
	
	//자식에만 추가한 메서드
	void showSaleRatio() {
		System.out.println(customerName + "님은 " + customerGrade + "등급으로 세일비율이 " + saleRatio + "입니다.");
	}
	
}
