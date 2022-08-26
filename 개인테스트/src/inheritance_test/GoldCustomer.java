package inheritance_test;

public class GoldCustomer extends Customer{
	//멤버변수
	/* Customer클래스에서 상속받은 변수
	protected int customerID; //고객 아이디
	protected String customerName;//고객 이름
	protected String customerGrade;//고객 등급

	int bonusPoint = 0;		//보너스 포인트
	double bonusRatio;		//적립 비율
	 */
	private double saleRatio; //세일비율
	
	//생성자
	public GoldCustomer(int customerID, String customerName) {
		super(customerID, customerName);
		
		customerGrade = "GOLD";
		bonusRatio = 0.02;  // 2% 적립
		saleRatio = 0.01;   // 1% 할인
	}

	//메서드
	@Override
	public int calcPrice(int productPrice) {
		bonusPoint += productPrice * bonusRatio; //보너스 포인트 누적
		return productPrice - (int)(productPrice * saleRatio);  //할인한 최종 지불금액 리턴
	}

	void showSaleInfo() {
		System.out.println(customerName + "님의 할인 비율은 " + (getSaleRatio() * 100) + "% 입니다.");
	}
	
	public double getSaleRatio() {
		return saleRatio;
	}
	
	
	
}
