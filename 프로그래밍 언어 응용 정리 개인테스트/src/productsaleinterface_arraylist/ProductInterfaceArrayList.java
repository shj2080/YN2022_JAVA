package productsaleinterface_arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//'제품' 인터페이스
interface ProductInterface {
	//1. 멤버변수(=필드) : 모두 상수 (public static final 생략되어 있음)
	//int TV = 1;
	//int COMPUTER = 2;
	//int AUDIO = 3;
	//int REFUND = 4;
	
	int TV = 1, COMPUTER = 2, AUDIO = 3, REFUND = 4;
	
	//2. 메서드 : 미완성 추상 메서드 (예외1:static, default, private JDK1-9버전부터 사용가능)
	static void buyerEnter() { //객체생성없이 바로 메모리에 올라감(공유용)->재정의불가
		System.out.println("구매자가 전자마트에 입장하셨습니다.");
	} 
	
	default void defaultMethod() {} 	//구현한 클래스에서 필요하면 재정의
	
	//이외는 1.8버전에서는 모두 미완성된 추상 메서드 : 구현한 클래스에서 반드시 재정의
	void menu();
}

//'제품' 추상 클래스
abstract class Product { //제품-부모:"자식의 공통된 특성"
	//1. 부모의 멤버변수(=필드) : 자식의 공통된 속성
	final String makeCountry = "korea"; //제조국가="korea" 명시적 초기화 한 후 변경 불가
	int productPrice;		//제품가격
	int bonusPoint;			//포인트 점수
	
	//2. 매개변수가 있는 생성자 : 가격이 있는 제품 생성
	Product(int productPrice) {
		super();
		this.productPrice = productPrice;
		bonusPoint = (int)(productPrice / 10.0); // 200.0 / 10.0 = 20.0 => 20
	}
	
	//부모의 메서드 : 자식의 공통된 기능
	abstract void show(); //미완성된 추상 메서드 : 상속한 자식클래스에서 반드시 재정의
}//Product 클래스 끝

class TV extends Product {
	//부모 상속받은 필드(3) + 추가 필드(1)
	final String makeCompany = "SamSung"; //만든 회사="SamSung" 명시적 초기화 한 후 변경 불가
	TV() {
		super(200); //부모생성자 Product(200) 호출 -> Product객체 생성
		bonusPoint = (int)(productPrice / 5.0);//만약 TV 는 보너스포인트가 5%
	}

	@Override
	void show() { //주의 : 출력결과에 맞게 글자수정
		System.out.println("TV [TV 제조국=" + makeCompany + ", makeCountry=" + makeCountry + ", productPrice=" + productPrice
				+ ", bonusPoint=" + bonusPoint + "]");
	}

	@Override
	public String toString() {
		return "TV";
	}
	
	
}

class Computer extends Product {
	//부모 상속받은 필드(3) + 추가 필드(1)
	final String brand = "LG 그램"; //브랜드="LG 그램" 명시적 초기화 한 후 변경 불가
	
	Computer() {
		super(100);
	}

	@Override
	void show() { //주의 : 출력결과에 맞게 글자수정
		System.out.println("Computer [brand=" + brand + ", makeCountry=" + makeCountry + ", productPrice=" + productPrice
				+ ", bonusPoint=" + bonusPoint + "]");
		
	}

	@Override
	public String toString() {
		return "Computer";
	}
	
	
}

class Audio extends Product {
	//부모 상속받은 필드(3) + 추가 필드 없음
	
	Audio() {
		super(50);
	}

	@Override
	void show() { //주의 : 출력결과에 맞게 글자수정
		System.out.println("Audio [makeCountry=" + makeCountry + ", productPrice=" + productPrice + ", bonusPoint=" + bonusPoint
				+ "]");
	}

	@Override
	public String toString() {
		return "Audio";
	}
	
	
}

/*-------------------------------------------------------------------------------------------*/

//구매자
class Buyer {
	//1. 멤버변수=필드 : 속성
	int money;		//돈
	int bonusPoint;	//구매자의 보너스포인트
	//int productCnt = 0; //멤버변수 - 보통 클래스 내용의 맨 앞에 배치해두는 게 좋음
	
	//구매자의 제품 목록
	//[방법-1] 배열 : 반드시 같은 타입만 저장, 크기 고정되므로 처음부터 최대크기로 선언. 추가와 삭제에 대한 코드를 직접 작성해야 하는 번거로움
	//Product[] item = new Product[10]; //최대 10개의 제품만 구매가능함 [null,null,...]기본값으로 채워짐
	
	//[방법-2] ArrayList 객체를 참조하는 변수 item
	ArrayList<Product> item = new ArrayList<Product>();
	
	//2. 생성자 : 돈을 가진 구매자
	Buyer(int money) {
		super();
		this.money = money;
		//this. 생략불가(이유?멤버변수와 매개변수를 구분하기 위해)
	}
	
	//3. 메서드 : 기능
	//제품에 대해 물어본다.
	void askInfo(Product p) { //Product의 자식객체(TV, Computer, Audio) 중 하나를 Product타입으로 자동형변환되어 받아들임
		System.out.println(p + "제품에 대한 정보 부탁드립니다.");
		//System.out.println(p.toString() + "제품에 대한 정보 부탁드립니다.");	
		//p.toString() : 자식객체(TV, Computer, Audio)의 재정의된 toString()호출된 결과 리턴
		
		p.show(); //자식객체(TV, Computer, Audio)의 재정의된 show()호출
	}
	
	//'제품'을 구매한다.
	int productCnt = 0; //멤버변수 : 구매자가 구매한 제품 수
	void buy(Product p) {
		//구매자 돈 제품가격 비교하여 구매자의 돈이 더 적으면 메서드 종료
		if(this.money < p.productPrice) {
			System.out.println("잔액이 부족하여 " + p + "제품을 구매할 수 없습니다.");
			return; // 해당 메서드(=buy()) 종료처리.       ※System.exit(0); //-> 프로그램 종료
		}
		
		this.money -= p.productPrice; 		//구매자의 돈은 제품가격만큼 감소
		this.bonusPoint += p.bonusPoint;	//구매자의 보너스포인트는 증가
		
		//[방법-1] 제품목록(배열)에 제품 추가
		//item[productCnt++] = p; //productCnt++는 이 구문이 실행된 후 값이 증가됨
		
		//[방법-2] ArrayList에 제품 추가
		item.add(p);
		productCnt++;
		
		System.out.println(p + "를(을) 구매하셨습니다.");
	}
	
	//[방법-2] 구매한 제품 환불
	void refund(Product p) {
		//해당 제품을 목록에서 찾아서 있으면 제거
		//환불받은 돈을 구매자의 돈에 추가
		//구매자의 보너스포인트는 감소
		
		if(item.isEmpty()) { //구매리스트가 비어 있는 경우
			System.out.println("매장에서 제품을 구매 하신 적이 없습니다.");
			return;
		}
		else if(item.remove(p)) {	//일치하는 제품 객체 발견 시 구매리스트에서 제거됨 (ArrayList.remove(Object o))
				
				this.money += p.productPrice; 		//제품 가격을 환불(구매자한테 돈 되돌려줌)
				this.bonusPoint -= p.bonusPoint;	//보너스포인트 반환(환불했으므로 포인트 소멸)
				
				System.out.println(p.toString() + "를(을) 환불해드렸습니다.");
				System.out.println("환불금액 : " + p.productPrice + "만원");
				System.out.println("반환된 포인트 : " + p.bonusPoint + "p");
		}
		else	//해당 제품을 목록에서 찾았는데 없으면
			System.out.println("구입하신 제품은 저희 매장 제품이 아닙니다.");
	}
	
	
	//구매한 제품 정보 요약해서 출력
	void summary() {
		/* 구입하신 제품은 [TV, Computer]이고
		 * 구입하신 제품의 총 금액은 500만원입니다.
		 * 
		 * ※ TV 2대, Computer 1대이므로 총 3대입니다. (=>테스트없음)
		 */
		int sum = 0;	//구매한 제품 가격 합계
		
		//※ TV 2대, Computer 1대이므로 총 3대입니다. (=>테스트없음)
		int cntTV = 0, cntComputer = 0, cntAudio = 0; //각 제품을 몇 대 구입했는지 카운팅하는 변수
		int totalCnt = 0;  //총 제품 수
		
		//※ for문을 이용해서 구입한 제품의 '총 가격'과 '목록'을 만들어
		for(Product p : item) {
			if(p == null)
				break;
			
			//※ TV 2대, Computer 1대이므로 총 3대입니다. (=>테스트없음)
			if(p instanceof TV) {
				cntTV++;
				totalCnt++;
			}else if(p instanceof Computer) {
				cntComputer++;
				totalCnt++;
			}else if(p instanceof Audio) {
				cntAudio++;
				totalCnt++;
			}
			
			sum += p.productPrice;
		}

		if(sum==0) { //if(totalCnt==0) {		//구매한 제품이 없는 경우 메서드 종료
			System.out.println("구매자는 제품을 구매하지 않았습니다.");
			return;
		}
		
		//출력
		String productList = "";
		String productCntList = "";		
		if(cntTV > 0) {
			productList += "TV, ";
			//※ TV 2대, Computer 1대이므로 총 3대입니다. (=>테스트없음)
			productCntList += "TV " + cntTV + "대, ";
		}
		
		if(cntComputer > 0) {
			productList += "Computer, ";
			productCntList += "Computer " + cntComputer + "대, ";
		}
		
		if(cntAudio > 0) {
			productList += "Audio, ";
			productCntList += "Audio " + cntAudio + "대, ";
		}
		
		//"TV, Computer, " -> "TV, Computer"
		productList = productList.substring(0, productList.length() - 2);

		//※ TV 2대, Computer 1대이므로 총 3대입니다. (=>테스트없음)
		//"TV 2대, Computer 1대, " -> "TV 2대, Computer 1대"
		productCntList = productCntList.substring(0, productCntList.length() - 2);
		
		System.out.println("구입하신 제품은 [" + productList + "]이고");
		//System.out.println("구입하신 제품은 " + Arrays.toString(item) + "이고"); //중복된 제품명과 null값이 출력됨
		System.out.println("구입하신 제품의 총 금액은 " + sum + "만원입니다.\n");
		
		//※ TV 2대, Computer 1대이므로 총 3대입니다. (=>테스트없음)
		System.out.println(productCntList + "이므로 총 " + totalCnt + "대입니다.");
	}
}

/*-------------------------------------------------------------------------------------------*/

/* 1개의 파일에 여러 개의 클래스가 있다면 public 붙일 수 있는 클래스는 단 1개
 * main() 실행용 클래스 = 파일명
 */
public class ProductInterfaceArrayList implements ProductInterface {

	@Override
	public void menu() {
		System.out.println();	//구분위한 빈줄
		System.out.println("**************** 가전 제품 목록 ************************");
		System.out.println("1. TV     2. Computer     3. Audio     4. 환불");
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);//키보드로부터 입력
		
		//1000만원 가진 구매자 생성
		Buyer b=new Buyer(1000);
		//구매자가 전자마트에 입장
		ProductInterface.buyerEnter();
		
		//TV,Computer,Audio 객체 생성
		TV tv=new TV();
		Computer com=new Computer();
		Audio audio=new Audio();
		
		//menu() 호출
		ProductInterfaceArrayList pi = new ProductInterfaceArrayList();
		
		while(b.money != 0) {
			pi.menu();
			
			//재정의-1(예)
			//ProductInterfaceArray pi2 = (ProductInterfaceArray) pi.menu2();
			//ProductInterfaceArray pi2 = pi.menu2();//강제형변환하는 번거로움이 사라져 편리함
			
			System.out.print("구매하고 싶은 가전제품 번호 입력. 종료는 stop>");
			//정수 1~3(O), 1보다 작은 수 or 3보다 큰수(x) / 실수1.23(x)  문자 a ㅁ(x) / stop StOp
			String tmp = sc.next();
			
			//stop StOp
			if(tmp.equalsIgnoreCase("stop")) break;
			
			//실수1.23(x)  문자 a ㅁ(x) => 예외발생
			int num = 0;//지역변수 초기화
			try {
				num = Integer.parseInt(tmp);
			} catch (NumberFormatException e) {				
				System.out.println("잘못된 값을 입력하셨습니다.");
				System.out.println(e.getMessage());//예외메세지 출력
				continue;//반복문의 제일 위로
			}
			
			//[방법-1]정수 1~4(O), 1보다 작은 수 or 4보다 큰수(x)			
			if(!(1<=num && num<=4)) {
				System.out.println("잘못된 번호입니다. 다시 입력해 주세요~");
				continue;//반복문의 제일 위로
			}
			
			switch(num) {
			case ProductInterface.TV :      b.askInfo(tv); 
			                           		b.buy(tv); 
			                           		break;
			case ProductInterface.COMPUTER :b.askInfo(com);			                      
									        b.buy(com);
									        break;
			case ProductInterface.AUDIO :   b.askInfo(audio);			                      
									        b.buy(audio);
									        break;
            
			case ProductInterface.REFUND :  System.out.print("환불할 제품 입력(TV, Computer, Audio) > ");
			                                String refund =sc.next();
			                                switch(refund.toLowerCase()) {
			                                case "tv"       : b.refund(tv); break;
			                                case "computer" : b.refund(com); break;
			                                case "audio"    : b.refund(audio); break;
			                                default         : System.out.println("해당 제품은 저희 매장에 없거나 저희 매장에서 구입하시지 않으셨습니다.");
			                                }
				
				
			//[방법-2]정수 1~4(O), 1보다 작은 수 or 4보다 큰수(x)	
			//default : System.out.println("잘못된 번호입니다. 다시 입력해 주세요~");
                     //break;				        
			}//switch문 끝
			
		}//while문 끝
		System.out.println("\n*---------------- [가전제품 판매 종료] ---------------------------*");
		
		b.summary();

	}

}
