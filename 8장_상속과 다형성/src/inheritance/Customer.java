/** 
 * [접근제한자] public > protected > 아무것도 없는 것(=default) > private
 * 1. public : 어디서든지 접근 가능
 * 2. protected : 같은 패키지에서는 접근 가능(단, 자식은 어디서든 접근 가능=다른 패키지의 자식이라도 접근가능)
 * 3. 아무것도 없는 것(=default) : 같은 패키지에서만 접근 가능(=다른 패키지에서는 접근 불가)
 * 4. private : 같은 클래스안에서만 접근가능(=다른 클래스에서는 접근 불가)
 *  - private 멤버변수는 접근가능한 메서드를 통해서 간접접근할 수 있다.
 *  - private 멤버는 상속불가
 *  
 *  ※ class 앞에 public 있으면 "어디서든지" import 할 수 있다.
 *  			       없으면 "같은 패키지에서만" import 할 수 있다.
 */

package inheritance; //상속
/*
 * 부모 : 자식의 공통된 특징(속성과 기능)
 */
public class Customer { //고객 : 부모
	//1. 멤버변수(=필드) : 속성 - 자식들의 공통된 속성
	//아래 3개 : protected(같은 패키지에서 접근 가능. 다른 패키지에서는 자식만 접근가능)
	protected int customerID;			//고객 아이디
	protected String customerName;		//고객 이름
	protected String customerGrade;		//고객 등급
	
	//아래 2개 : 같은 패키지에서만 접근 가능
	int bonusPoint = 0;		//보너스 포인트
	double bonusRatio;		//적립 비율
	
	//2. 생성자 : 고객 등급="SILVER", 적립 비율=0.01=1%
	public Customer() {
		super();
		
		initCustomer();
		/*
		customerGrade = "SILVER";
		bonusRatio = 0.01;
		*/
		
		//나머지 멤버변수는 기본값으로 채워짐
	}
	
	//매개변수가 있는 생성자(고객 아이디, 고객 이름)
	public Customer(int customerID, String customerName) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		
		initCustomer();
		/*
		customerGrade = "SILVER";
		bonusRatio = 0.01;
		*/
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
	public int calcPrice(int productPrice) { // (물건값이 10000원이라면)
		bonusPoint += productPrice * bonusRatio; // 10000 * 0.01 = 100
		return productPrice; //10000원 지불
	}
	
	//메서드 작성할 때 리턴타입으로 작성할지 여부를 고민
	//고객 정보 반환
	public String showCustomerInfo() {
		return customerName + "님의 등급은 " + customerGrade + "이며, 보너스 포인트는 " + bonusPoint + "점 입니다.";
	}
	
	
	//Object로부터 상속받은 메서드 중 "외부에서 주소만으로도 String을 리턴하는" 메서드 찾아 재정의
	//즉, toString()를 호출하는 측에서 "주소만"으로도 "고객정보"를 리턴받을 수 있도록 재정의함
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", customerGrade="
				+ customerGrade + ", bonusPoint=" + bonusPoint + ", bonusRatio=" + bonusRatio + "]";
	}
	
	/*** get~() : 멤버변수 값을 얻어올 때, set~(매개변수) : 멤버변수의 값을 변경할 때 
	 	 ※ final : 자식에서 '재정의 불가'하도록 ***/
	
	public final int getCustomerID() {
		return customerID;
	}

	public final void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public final String getCustomerName() {
		return customerName;
	}

	public final void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public final String getCustomerGrade() {
		return customerGrade;
	}

	public final void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}

	public final int getBonusPoint() {
		return bonusPoint;
	}
	
	//주석처리는 개발자의 설계에 따라 달라짐
	/*
	public final void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	*/
	
	public final double getBonusRatio() {
		return bonusRatio;
	}

	/*
	public final void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}
	*/
	
	void showNOSaleRatio() { // void showSaleRatio() {
		
		System.out.println(customerGrade + "등급은 세일비율이 0%입니다.");
	}
}
