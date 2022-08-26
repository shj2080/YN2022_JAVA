/**
 * 상황 : power(){} 완성된 메서드이면 자식 클래스에서 power()를 재정의하지 않아도 오류 발생 안함
 * 		그런데, 부모입장에서는 반드시 power()를 자식이 재정의해서 사용하기를 원함
 * 
 * 해결책 : 'power()를 미완성된 추상 메서드'로 만들어 반드시 자식클래스에서 재정의하도록 함
 * 		   자식클래스에서 재정의안하면 오류 발생 - 오류 해결방법-1 : 자식 클래스에서 재정의
 * 									  - 오류 해결방법-2 : 자식 클래스도 추상 클래스로 만듦
 * 
 * [abstract class 클래스명 = 추상 클래스]
 * 1. 여러 메서드 중 1개라도 미완성된 추상 메서드가 있으면 이 클래스도 미완성이므로 abstract class가 됨
 * 2. 객체 생성 불가 : 이유? 미완성 클래스이므로
 * 3. 그러나, 부모 역할 가능
 * 	 (예1) method(Electronics e) {  //Electronics의 자식객체(TV,VCR,TVCR)
 * 									-> 자동으로 Electronics로 형변환되어 받아들임
 * 		  }
 * 	  (예2)		Electronics e = new TV();		//자동으로 Electronics로 형변환되어 받아들임
 * 	  			Electronics e = new VCR();
 * 	  			Electronics e = new TVCR();
 * 
 */
package tvvcr_abstract;

abstract class Electronics { //조부모 : 전자제품 - 자식의 공통된 속성과 기능
	//1. 멤버변수 (=field) : 속성
	boolean power;
	static final String makeCountry = "한국"; //공유+값변경불가(상수)  - static인 경우 객체 안에 없고 공유 메모리에 올라감
	
	//2. 기본생성자
	
	//3. 메서드
	//void power() {} //완성된 메서드
	//미완성 추상 메서드 : 반드시 자식클래스에서 재정의하도록 하기 위함(이유?서로 다른 내용으로 채워져야 하므로)
	abstract void power();
}

class TV extends Electronics{ //TVCR부모, Electronics의 자식
	//1. 멤버변수 (=field) : 속성
	//boolean power; //전원 : on->true, off->false(기본값)
	int channel;	//채널(기본값 0)
	
	int bacode; //바코드
	
	//2. 생성자
	//기본생성자 TV(){super();}
	TV(){super();} //기본값으로 채워진 객체 생성
	
	TV(int bacode){ //서로 다른 바코드를 가진 TV
		super(); //Object() 생성자 호출 -> Object객체 생성
		this.bacode = bacode;
	}//TV객체 생성
	
	//3. 메서드 : 기능
	
	@Override
	void power(){
		power = !power; //!false->true, !true->false
		
		if(power) System.out.println("TV 전원 On");
		else System.out.println("TV 전원 Off");
		
	}
	
	
	void channelUp() {
		channel++;
	}
	
	void channelDown() {
		channel--;
	}

	@Override
	public String toString() {
		//makeCountry는 static이므로 클래스이름(=Electronics)으로 접근하나 상속관계이므로 생략가능함
		return "TV [제조국=" + makeCountry + ", power=" + power + ", channel=" + channel + ", bacode=" + bacode + "]";
	}
	
}

class VCR extends Electronics{ //부품 클래스(TVCR에 포함관계), Electronics 부모로 정의
	//1. 멤버변수
	//boolean power;//전원
	
	//2. 기본생성자
	
	//3. 메서드
	void power(){
		power = !power; //!false->true, !true->false
		
		if(power) System.out.println("VCR 전원 On");
		else System.out.println("VCR 전원 Off");	
	}
	
	//추가 : 실질적인 기능
	void play() {
		System.out.println("재생");
	}
	void stop() {
		System.out.println("멈춤");
	}
	void rewind() {
		System.out.println("되감기");
	}
	void fast_forward() {
		System.out.println("빨리감기");
	}

	@Override
	public String toString() {
		return "VCR [제조국=" + makeCountry + ", power=" + power + "]";
	}
	
	//추가
	void capture() {
		System.out.println("화면 캡쳐");
	}
}

/*
 * 여러 개의 클래스를 하나의 파일에 설계할 때
 * public은 단 1개의 클래스에만 붙일 수 있다.
 * 
 * public 붙은 클래스=파일이름
 * 
 *  main()있는 클래스에 public 붙이고
 * ※ main() 있는 클래스이름=파일이름
 */
public class TVCR extends TV{ //TVCR(자식)-TV(부모1개):단일상속, VCR(포함관계)
	/*
	 * TV(부모)의 멤버(멤버변수,메서드)만 상속,
	 * ※ 생성자, 초기화블럭, private멤버는 상속되지 않는다.
	 * 
	 * [상황-1] bacode가 TV인 부모한테만 있을 때
	 * 이 때, 부모의 bacode 멤버변수를 자식이 접근
	 * bacode가 부모인 TV클래스에만 있으므로
	 * - this.bacode나 super.bacode는 TV클래스의 bacode로 접근
	 * 
	 * [상황-2] : bacode가 부모인 TV와 자식인 TVCR에 각각 있다면
	 * - TV의 bacode는 super.bacode로 접근 (부모클래스의 멤버변수 접근)
	 * - TVCR의 bacode는 this.bacode로 접근 (자식클래스의 멤버변수 접근)
	 */
	
	//1. 멤버변수 : 상속(3)+추가(1)
	/* = 상속된 멤버변수 =
	boolean power; //전원 : on->true, off->false(기본값)
	int channel;	//채널(기본값 0)
	
	int bacode;	//상황-1: 상속받은 바코드만 있을 때(TV)
	*/
	
	int bacode;		//상황-2: 같은 이름의 바코드가 자식클래스에 추가했을 때
	
	private VCR vcr; //[포함]순서-1

	//2. 생성자
	public TVCR() {
		super();		//부모 생성자 호출
		
		this.bacode = 111;	//바코드값이 111로 같은 TVCR객체 생성	(부모에게서 상속된 변수 bacode 공유)
		vcr = new VCR();//[포함]순서-2
	}

	public TVCR(int bacode) { //222
		super(111); //TV의 bacode값이 111 그대로 상속 후
		this.bacode = bacode; // 자식클래스에서 bacode 멤버변수 찾지 못했으므로 부모의 상속된 멤버변수 공유(상황-1의 경우)
		
		vcr = new VCR();//[포함]순서-2
	}

	//3. 메서드
	@Override
	void power() {
		power = !power; //!false->true, !true->false
		
		if(power) System.out.println("TVCR 전원 On");
		else System.out.println("TVCR 전원 Off");
	}
	
	
	/*
	void channelUp() {
		channel++;
	}
	
	void channelDown() {
		channel--;
	}
	*/	
	
	//[포함]순서-3 : 외부에 노출된 버튼(private멤버변수에 접근가능한 메서드를 통해 간접접근)
	public void play() {
		vcr.play();
	}
	public void stop() {
		vcr.stop();
	}
	public void rewind() {
		vcr.rewind();
	}
	public void fast_forward() {
		vcr.fast_forward();
	}

	@Override
	public String toString() {
		return "TVCR [제조국=" + makeCountry + ", power=" + power + ", channel=" + channel + ", bacode=" + bacode + "]";
	}
	
	/*
	 * [상황-1] : bacode가 부모인 TV클래스에만 있으므로
	 * 			 this.bacode나 super.bacode는 TV클래스의 bacode값을 의미함.
	 * 
	 * [상황-2] : TV의 bacode는 super.bacode로 접근
	 * 			TVCR의 bacode는 this.bacode로 접근
	 * 
	 * 각 상황에 따라 출력되는 결과는 다르다.
	 */
	
	int getTVBacode() {
		return super.bacode; //0이 아니라 111(이유? 부모의 멤버변수 참조)-상황1의 경우
	}

	int getTVCRBacode() {
		return this.bacode;	//(★TVCR에는 bacode 멤버변수 재정의(=Overriding)가 없으므로 부모의 멤버변수 사용)-상황1의 경우
	}
	
	void setTVBacode(int bacode) { //333
		super.bacode = bacode;
	}
	
	void setTVCRBacode(int bacode) { //444
		this.bacode = bacode;
	}
}

/*
 * public class TVCRmain { public static void main(String[] args) {
 * 
 * } }
 */