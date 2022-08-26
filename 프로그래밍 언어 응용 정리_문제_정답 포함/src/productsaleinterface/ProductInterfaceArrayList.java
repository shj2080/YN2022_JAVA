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
class Product { //제품-부모:"자식의 공통된 특성"
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
}

public class ProductInterfaceArrayList {

	public static void main(String[] args) {
		
		
	}

}
