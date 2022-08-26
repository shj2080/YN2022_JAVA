package inheritance_test;

public class VIPCustomer extends Customer{
	//멤버변수
	/* 상속받은 멤버변수
	protected int customerID; //고객 아이디
	protected String customerName;//고객 이름
	protected String customerGrade;//고객 등급

	int bonusPoint = 0;		//보너스 포인트
	double bonusRatio;		//적립 비율
	 */
	private double saleRatio; //세일 비율
	final private int agentID;  // VIP 전담 상담사 ID
	
	
	//생성자
	public VIPCustomer(int customerID, String customerName) {
		super(customerID, customerName); //부모생성자 호출
		
		bonusRatio = 0.05; //적립비율 5%
		saleRatio = 0.10;  //할인비율 10%
		agentID = 100;
	}

	public VIPCustomer(int customerID, String customerName, int agentID) {
		super(customerID, customerName); //부모생성자 호출
		
		bonusRatio = 0.05; //적립비율 5%
		saleRatio = 0.10;  //할인비율 10%
		this.agentID = agentID;
	}

	//메서드
	@Override
	public int calcPrice(int productPrice) {
		// TODO 자동 생성된 메소드 스텁
		return super.calcPrice(productPrice);
	}
	
	public double getSaleRatio() {
		return saleRatio;
	}

	

	public int getAgentID() {
		return agentID;
	}
	
	
}
