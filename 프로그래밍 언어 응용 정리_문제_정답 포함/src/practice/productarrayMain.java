
package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



interface ProductInterface {
	int TV = 1;
	int COMPUTER = 2;
	int AUDIO = 3;
	int REFUND = 4;

	static void buyerEnter() {
		System.out.println("구매자가 전자카트에 입장하셨습니다.");
	}

	default void defaultMethod() {
	}

	void menu();

}

abstract class Product {
	final String makeCountry = "korea";
	int productPrice;
	int bonusPoint;

	public Product(int productPrice) {
		super();
		this.productPrice = productPrice;
		bonusPoint = (int) (productPrice / 10.0);
	}

	abstract void show();

}

class TV extends Product {
	final String makeCompany = "Samsung";

	TV() {
		super(200);
		bonusPoint = (int) (productPrice / 5.0);

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

class Computer extends Product {

	final String brand = "LG 그램";

	public Computer() {
		super(100);
	}

	@Override
	void show() {

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

class Buyer {
	int money;
	int bonusPoint;

	List<Product> item = new ArrayList<Product>(); // 프로덕트 ARRAYLIST 배열객체 생성

	public Buyer(int money) { // 돈 들어갈 생성자생성 ★★★★★★★★★★★
		super();
		this.money = money;
	}

	void askInfo(Product p) { // 제품정보 부탁+ 출력 메서드[Product 클래스의 show()호출]
		System.out.println(p + " 제품에 대한 정보 부탁드립니다.");

		p.show();
	}

	void buy(Product p) {
		if (this.money < p.productPrice) {

			System.out.println("잔액이 부족하여 " + p + "제품을 구매할 수 없습니다.");
			return;
		}
		this.money -= p.productPrice; // this.&&&&&&&&&&
		this.bonusPoint += p.bonusPoint; // this.&&&&&&&&&

		item.add(p);

		System.out.println(p + "제품을(를) 구매하셨습니다.");
	}

	void refund(Product p) {
		// 해당 제품을 목록에서 찾아서 있으면 제거
		// 환불받은 돈을 구매자의 돈에 추가
		// 구매자의 보너스포인트는 감소

		if (item.remove(p)) {

			this.money += p.productPrice; // 제품 가격을 환불(구매자한테 돈 되돌려줌)
			this.bonusPoint -= p.bonusPoint; // 보너스포인트 반환(환불했으므로 포인트 소멸)
			
			System.out.println(p+ "를(을) 반품하셨습니다..");
		}
		else if(item.isEmpty()) {
			System.out.println("제품을 구매하지 않으셨습니다.");
			return;
		}
		
	}

	void summary() {		//구매한 제품들의 정보를 출력하는 메서드
		int sum = 0; // 구매한 제품 가격 합계
		int cntTV = 0, cntComputer = 0, cntAudio = 0;
		int totalCnt = 0;
		
		
		for(int i=0;i<item.size() ; i++) {
			Product p = item.get(i);
			
			
			if (p == null)
				break;
			
			
			if (p instanceof TV) {
				cntTV++;
				totalCnt++;
			} else if (p instanceof Computer) {
				cntComputer++;
				totalCnt++;
			} else if (p instanceof Audio) {
				cntAudio++;
				totalCnt++;
			}
			sum += p.productPrice;
		}

		if (sum == 0) {
			System.out.println("구매자는 제품을 구매하지 않았습니다.");
			return;
		}

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
		
		/*
		System.out.println("출력방법-2");
		System.out.println("구입하신 제품은 [" + productList + "]이고");
	    System.out.println();//구분위한빈줄
		System.out.println("구입하신 제품의 총 금액은 " + sum + "만원입니다.\n");
		*/
		
		System.out.println("출력방법-[3]");
	    productList = String.join(",", item.toString());
	    System.out.println("구입하신 제품은 "+productList+"이고 ");
	    System.out.println();//구분위한빈줄
	    System.out.println("구입하신 제품의 총 금액은 " + sum + "만원입니다.\n");
	    
	}

}

public class productarrayMain implements ProductInterface {

	@Override
	public void menu() {
		System.out.println();
		System.out.println("**************** 가전 제품 목록 ************************");
		System.out.println("1. TV     2. Computer     3. Audio     4. 환불");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Buyer b = new Buyer(1000);

		ProductInterface.buyerEnter();

		TV tv = new TV();
		Computer com = new Computer();
		Audio audio = new Audio();

		productarrayMain pi = new productarrayMain();

		while (b.money != 0) {
			pi.menu();

			System.out.print("구매하고 싶은 가전제품 번호 입력. 종료는 stop>");
			String tmp = sc.next();

			if (tmp.equalsIgnoreCase("stop"))
				break;

			int num = 0;
			try {
				num = Integer.parseInt(tmp);
			} catch (NumberFormatException e) {
				System.out.println("잘못된 값을 입력하셨습니다.");
				System.out.println(e.getMessage()); //for input string : 
				continue;
			}

			if (!(1 <= num && num <= 4)) {
				System.out.println("잘못된 번호입니다. 다시 입력해 주세요~");
				continue;
			}

			switch (num) {
			case ProductInterface.TV:
				b.askInfo(tv);
				b.buy(tv);
				break;
			case ProductInterface.COMPUTER:
				b.askInfo(com);
				b.buy(com);
				break;
			case ProductInterface.AUDIO:
				b.askInfo(audio);
				b.buy(audio);
				break;

			case ProductInterface.REFUND:
				System.out.print("환불할 제품 입력(TV, Computer, Audio) > ");
				String refund = sc.next();
				switch (refund.toLowerCase()) {
				case "tv":
					b.refund(tv);
					break;
				case "computer":
					b.refund(com);
					break;
				case "audio":
					b.refund(audio);
					break;
				default:
					System.out.println("해당 제품은 저희 매장에 없거나 저희 매장에서 구입하시지 않으셨습니다.");
				}

			}

		}
		System.out.println("\n*---------------- [가전제품 판매 종료] ---------------------------*");

		b.summary();

	}

}
