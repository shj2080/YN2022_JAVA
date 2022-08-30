
package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



interface ProductInterface {	//제품 인터페이스
	int TV = 1;
	int COMPUTER = 2;
	int AUDIO = 3;
	int REFUND = 4;

	static void buyerEnter() {	//구현하는 클래스가 재정의 못함
		System.out.println("구매자가 전자카트에 입장하셨습니다.");
	}

	default void defaultMethod() {	//구현하는 클래스가 재정의 가능함
	}

	void menu();	//구현하는 클래스가 이 메서드를 반드시 재정의 해야함

}

abstract class Product {	//각 제품들의 부모 클래스(추상 클래스)
	final String makeCountry = "korea";
	int productPrice;
	int bonusPoint;

	public Product(int productPrice) {	//생성자 : 멤버변수 '제품 가격'을 매개변수 '제품 가격'으로 초기화함.
		super();
		this.productPrice = productPrice; //멤버변수 '제품 가격'을 매개변수 '제품 가격'으로 초기화함.
		bonusPoint = (int) (productPrice / 10.0);	//보너스포인트 (제품가격 / 보너스포인트비율)
	}

	abstract void show();	//상속받은 클래스에서 반드시 재정의 해야 하는 메서드

}

class TV extends Product {
	final String makeCompany = "Samsung";

	TV() {
		super(200);
		bonusPoint = (int) (productPrice / 5.0);	//상속받은 보너스포인트 멤버변수값 변경
		//★★주의 : 상속받은 멤버변수값을 변경할 경우 부모의 멤버변수값도 바뀜 (Product.bonusPoint)

	}

	@Override
	void show() {
		System.out.println("TV [makeCompany=" + makeCompany + ", makeCountry=" + makeCountry + ", productPrice="
				+ productPrice + ", bonusPoint=" + bonusPoint + "]");

	}

	@Override
	public String toString() {
		return "TV";
	}

}

class Computer extends Product {	//컴퓨터

	final String brand = "LG 그램";

	public Computer() {
		super(100);
	}

	@Override
	void show() {	//컴퓨터 정보 출력

		System.out.println("Computer [makeCountry=" + makeCountry + ", productPrice=" + productPrice + ", bonusPoint="
				+ bonusPoint + "]");
	}

	@Override
	public String toString() {
		return "Computer";
	}

}

class Audio extends Product {

	public Audio() {
		super(50);

	}

	@Override
	void show() {
		System.out.println("Audio [makeCountry=" + makeCountry + ", productPrice=" + productPrice + ", bonusPoint="
				+ bonusPoint + "]");

	}

	@Override
	public String toString() {
		return "Audio";
	}

}

class Buyer {	//구매자 클래스
	int money;		//구매자가 가진 돈
	int bonusPoint;	//구매자가 가진 보너스포인트

	List<Product> item = new ArrayList<Product>(); // Product ArrayList 배열객체 생성 (ArrrayList -> List 자동형변환)

	public Buyer(int money) { // 돈 들어갈 생성자생성 ★★★★★★★★★★★
		super();	//부모 생성(Object)
		this.money = money;	//매개변수값으로 멤버변수 money 값 초기화
	}

	void askInfo(Product p) { // 제품정보 부탁+ 출력 메서드[Product 클래스의 show()호출]
		System.out.println(p + " 제품에 대한 정보 부탁드립니다.");

		p.show();	//각 제품 클래스(TV, Computer, Audio)에서 재정의된 show() 호출)
	}

	void buy(Product p) {
		if (this.money < p.productPrice) {

			System.out.println("잔액이 부족하여 " + p + "제품을 구매할 수 없습니다.");
			return;
		}
		this.money -= p.productPrice; // this.&&&&&&&&&&
		this.bonusPoint += p.bonusPoint; // this.&&&&&&&&&

		item.add(p);	//ArrayList에 제품 객체를 추가함.

		System.out.println(p + "제품을(를) 구매하셨습니다.");
	}

	void refund(Product p) {	//제품 환불 메서드
		// 해당 제품을 목록에서 찾아서 있으면 제거
		// 환불받은 돈을 구매자의 돈에 추가
		// 구매자의 보너스포인트는 감소

		if(item.isEmpty()) {		//구매리스트가 빈 경우(매장 구매이력이 없는 경우)
			System.out.println("매장에서 제품을 구매한 이력이 없습니다.");
			return;
		}
		else if (item.remove(p)) {		//구매리스트 검색(찾는 제품 객체가 있으면 삭제 후 true)

			this.money += p.productPrice; // 제품 가격을 환불(구매자한테 돈 되돌려줌)
			this.bonusPoint -= p.bonusPoint; // 보너스포인트 반환(환불했으므로 포인트 소멸)
			
			System.out.println(p+ "를(을) 반품하셨습니다..");
		}
		else System.out.println("이 제품을 구매하신 적이 없습니다.");
		
		
	}

	
	void summary() {		//구매한 제품들의 정보를 출력하는 메서드
		int sum = 0; // 구매한 제품 가격 합계
		int cntTV = 0, cntComputer = 0, cntAudio = 0;	//제품들을 구매한 횟수
		int totalCnt = 0;	//제품 구매한 횟수 합계
		
		if (item.isEmpty()) {
			System.out.println("구매자는 제품을 구매하지 않았습니다.");
			return;
		}
		
		for(int i=0;i<item.size() ; i++) {
			Product p = item.get(i);	//item의 객체를 Product p에 담음
			
			if (p instanceof TV) {		//p 객체가 TV타입인가?
				cntTV++;
				totalCnt++;
			} else if (p instanceof Computer) {	//p 객체가 Computer타입인가?
				cntComputer++;
				totalCnt++;
			} else if (p instanceof Audio) {	//p 객체가 Audio타입인가?
				cntAudio++;
				totalCnt++;
			}
			sum += p.productPrice;	//구매한 제품들의 가격을 모두 더함 (p.productPrice = 각 제품들의 가격)
		}

		/* item.isEmpty(), item.size() 로 체크할 수도 있음
		if (sum == 0) {
			System.out.println("구매자는 제품을 구매하지 않았습니다.");
			return;
		}
		*/

		String productList = ""; //[출력방법-1]
		String productCntList = "";
		if (cntTV > 0) {
			productList += "TV, ";
		}

		if (cntComputer > 0) {
			productList += "Computer, ";
		}
		if (cntAudio > 0) {
			productList += "Audio, ";
		}

		productList = productList.substring(0, productList.length() - 2);

		//출력-[방법-1] itemList+ "TV" + ",Computer"
		//productList = productList +((i==0)? ""+p : ","+p);
		//productList = productList +((i==0)? "" + p.toString()+","+p);
		
		
		System.out.println("출력방법-2");
		System.out.println("구입하신 제품은 [" + productList + "]이고");
	    System.out.println();//구분위한빈줄
		System.out.println("구입하신 제품의 총 금액은 " + sum + "만원입니다.\n");
		
		
		/*
		System.out.println("출력방법-[3]");
	    productList = String.join(",", item.toString());
	    System.out.println("구입하신 제품은 "+productList+"이고 ");
	    System.out.println();//구분위한빈줄
	    System.out.println("구입하신 제품의 총 금액은 " + sum + "만원입니다.\n");
	    */
		
	}

}

public class productarrayMain implements ProductInterface {

	@Override
	public void menu() {	//ProductInterface의 menu메서드 재정의
		System.out.println();
		System.out.println("**************** 가전 제품 목록 ************************");
		System.out.println("1. TV     2. Computer     3. Audio     4. 환불");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		//입력을 받기 위한 Scanner 객체 생성 (변수명 : sc)

		Buyer b = new Buyer(1000);	//구매자 객체 생성(1000만원을 가진 구매자)

		ProductInterface.buyerEnter(); //구매자 입장 안내 메시지(인터페이스 내 static 메서드-재정의 불가)

		//제품 객체들을 생성
		TV tv = new TV();
		Computer com = new Computer();
		Audio audio = new Audio();

		productarrayMain pi = new productarrayMain();

		while (b.money != 0) {
			pi.menu();	//menu 출력

			System.out.print("구매하고 싶은 가전제품 번호 입력. 종료는 stop>");
			String tmp = sc.next();

			if (tmp.equalsIgnoreCase("stop"))	//stop 입력 시 종료(대소문자 구분 없음)
				break;

			int num = 0;	//0으로 초기화
			try {		//try ~ catch문으로 예외 잡아냄
				num = Integer.parseInt(tmp);
			} catch (NumberFormatException e) {	//정수값이 아닌 경우 예외를 잡아서 처리
				System.out.println("잘못된 값을 입력하셨습니다.");
				System.out.println(e.getMessage()); //for input string : 
				continue;
			}

			if (!(1 <= num && num <= 4)) {		//입력된 정수가 1 ~ 4 범위가 아닌 경우
				System.out.println("잘못된 번호입니다. 다시 입력해 주세요~");
				continue;
			}

			switch (num) {	//정수로 변환된 값으로 체크함
			case ProductInterface.TV:			//1
				b.askInfo(tv);	//제품 정보를 물음
				b.buy(tv);		//제품을 구매함
				break;
			case ProductInterface.COMPUTER:		//2
				b.askInfo(com);
				b.buy(com);
				break;
			case ProductInterface.AUDIO:		//3
				b.askInfo(audio);
				b.buy(audio);
				break;
			case ProductInterface.REFUND:		//4
				System.out.print("환불할 제품 입력(TV, Computer, Audio) > ");
				String refund = sc.next();
				switch (refund.toLowerCase()) {	//입력받은 문자열 값을 소문자로 변환
				case "tv":
					b.refund(tv);		//환불 메서드 실행
					break;
				case "computer":
					b.refund(com);
					break;
				case "audio":
					b.refund(audio);
					break;
				default:	//없는 제품을 입력한 경우(위의 조건들이 모두 false인 경우)
					System.out.println("해당 제품은 저희 매장에 없거나 저희 매장에서 구입하시지 않으셨습니다.");
				}

			}//switch문 끝

		}	//while문 끝
		System.out.println("\n*---------------- [가전제품 판매 종료] ---------------------------*");

		b.summary();	//구매 정보 요약

	}

}
