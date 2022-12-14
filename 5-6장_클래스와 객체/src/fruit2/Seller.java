package fruit2;

public class Seller {
	// 1. 속성 : 멤버변수=필드(field) (기본값->명시적 값->생성자)
	final String sellerName;	//간판이름 (final)
	
	private int firstMoney;		//기존 돈 =원금
	private int money;       	//원금 + 사과 판매하고 받은 돈(=수익)	(예)1300+1000*2
	
	private int numOfApple = 100;  // 사과 수 (private : 정보보안)
	private int numOfAppleSale = 0;	//판매한 사과수	(예)0+2
	
	//static final int APPLE_PRICE = 1000; //사과 가격 공유 + 값 변경불가
	
	private final int APPLE_PRICE; //생성자를 통해 : 각 판매자마다 사과가격을 다르게 하고 가격변경불가 하게 하고 싶다면

	// 2. 기본생성자 public Seller(){super();}
	
	public Seller(String sellerName , int money, int numOfApple, int apple_price) {
		super();
		this.sellerName = sellerName;
		
		this.firstMoney = money;
		this.money = money;
		
		this.numOfApple = numOfApple;
		this.APPLE_PRICE = apple_price;
	}
	
	// 3. 기능 : 메서드
	//사과가격을 말한다. [방법-1]
	public void answerApplePrice() {
		System.out.println(APPLE_PRICE + "원입니다.");
	}
	
	//사과가격을 말한다. [방법-2]
	public int getAPPLE_PRICE() {
		return APPLE_PRICE;
	}
	
	//사과 수를 말한다. [방법-1]
	public void answerNumOfApple() {
		System.out.println(numOfApple + "개입니다.");
	}
	
	//사과 수를 말한다. [방법-2]
	public int getNumOfApple() {
		return numOfApple;
	}

	//돈을 받아 받은 돈만큼의 사과를 돌려준다.
	int sale(int money) {
		int numOfSale = money / APPLE_PRICE;//	5000/1000 = 5(몫)
		
		this.money += money; 	//받은 돈만큼 판매자의 돈은 증가
		numOfApple -= numOfSale; //판매한 사가수만큼 판매자의 사과수는 감소
		
		this.numOfAppleSale += numOfSale; 	//판매한 사과수를 누적
		
		return numOfSale;	//구매자에게 사과수를 리턴
	}
	
	void showSale() {
		System.out.println("판매 후 남은 사과 수 : " + numOfApple);
		System.out.println("판매한 사과 수 : " + numOfAppleSale);		
		System.out.println("판매자가 가진 기존 돈(=원금) : " + firstMoney);
		System.out.println("판매자의 수익[방법-1] : " + (money - firstMoney));
		System.out.println("판매자의 수익[방법-2] : " + (numOfAppleSale * APPLE_PRICE));
		System.out.println("판매자가 가진 전체 돈 : " + money);
	}

	@Override
	public String toString() {
		return "사과판매자님";
	}

	
	
}
