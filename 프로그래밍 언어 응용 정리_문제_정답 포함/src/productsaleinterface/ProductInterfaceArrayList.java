package productsaleinterface;

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
	
	//구매자의 제품 목록
	//[방법-1] 배열 : 반드시 같은 타입만 저장, 크기 고정되므로 처음부터 최대크기로 선언. 추가와 삭제에 대한 코드를 직접 작성해야 하는 번거로움
	Product[] item = new Product[10]; //최대 10개의 제품만 구매가능함 [null,null,...]기본값으로 채워짐
	
	//2. 생성자 : 돈을 가진 구매자
	Buyer(int money) {
		super();
		this.money = money;
		//this. 생략불가(이유?멤버변수와 매개변수를 구분하기 위해)
	}
	
	//3. 메서드 : 기능
	//제품에 대해 물어본다.
	void askInfo() {
		
	}
	
}

/*-------------------------------------------------------------------------------------------*/

public class ProductInterfaceArrayList {

	public static void main(String[] args) {
		
		
	}

}
