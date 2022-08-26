package inheritance_test;

public class Customer {
	//Customer : GoldCustomer, VIPCustomer의 부모

	//1. 멤버변수
	//고객 아이디, 고객 이름, 고객 등급은 protected 접근제한자 지정
	protected int customerID; //고객 아이디
	protected String customerName;//고객 이름
	protected String customerGrade;//고객 등급

	int bonusPoint = 0;		//보너스 포인트
	double bonusRatio;		//적립 비율

	//2. 생성자 - 매개변수 없는 생성자, 매개변수 있는 생성자
	public Customer() {
		super();
		
		initCustomer();
	}

	public Customer(int customerID, String customerName) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		
		initCustomer();
	}

	//3. 메서드 : 자식의 공통된 기능만
	private void initCustomer() {
		customerGrade = "SILVER";
		bonusRatio = 0.01;
	}
	
	/*
	 * 제품에 대해 지불해야 하는 금액을 계산하여 반환
	 * (반환하기 전에 보너스포인트를 계산하여 누적)
	 */
	public int calcPrice(int productPrice) {
		bonusPoint += productPrice * bonusRatio;
		return productPrice;
	}
	
	//고객 정보 반환
	String showCustomerInfo() {
		return customerName + "님의 등급은 "+ customerGrade + ", 보너스포인트는 " + bonusPoint + "점입니다.";
	}
	//Object로부터 상속받은 메서드 중 "외부에서 주소만으로도 String을 리턴하는" 메서드 찾아 재정의
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", customerGrade="
				+ customerGrade + ", bonusPoint=" + bonusPoint + ", bonusRatio=" + bonusRatio + "]";
	}
	
	
	/*** get~() : 멤버변수 값을 얻어올 때, set~(매개변수) : 멤버변수의 값을 변경할 때 
	 ※ final : 자식에서 '재정의 불가'하도록 ***/
	
	final public int getCustomerID() {
		return customerID;
	}

	final public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	final public String getCustomerName() {
		return customerName;
	}

	final public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	final public String getCustomerGrade() {
		return customerGrade;
	}

	final public int getBonusPoint() {
		return bonusPoint;
	}

	public double getBonusRatio() {
		return bonusRatio;
	}
	
	void showSaleNOInfo() {
		System.out.println(customerName + "님의 할인 비율은 0% 입니다."); //SILVER 등급은 할인 없음.
	}
}
