/*​
	< 변수 사용 시 선언 방법에 따른 접근 순서 >
	
	1. 변수명만 지정했을 경우
	현재 선언된 메서드 내에서 먼저 탐색 → 없을 경우 자신의 멤버변수에서 탐색 → 부모의 멤버변수에서 탐색

	2. this.변수명을 지정했을 경우
	자신의 멤버변수에서 탐색 → 부모의 멤버변수에서 탐색

	3. super.변수명을 지정했을 경우
	부모의 멤버변수에서 탐색 
 */
package tvvcr;

class TV{ //부모
	//1. 멤버변수 (=field) : 속성
	boolean power; //전원 : on->true, off->false(기본값)
	int channel;	//채널(기본값 0)
	
	int bacode; //바코드
	
	//2. 생성자
	//기본생성자 TV(){super();}
	TV(){super();}
	
	TV(int bacode){	//서로 다른 바코드를 가진 TV
		super(); //Object() 생성자 호출 -> Object객체 생성
		this.bacode = bacode;
	}//TV객체 생성
	
	//3. 메서드 : 기능
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
		return "TV [power=" + power + ", channel=" + channel + ", bacode=" + bacode + "]";
	}
	
}

class VCR { //부품 클래스(TVCR에 포함관계)
	//1. 멤버변수
	boolean power;//전원
	
	//2. 기본생성자
	
	//3. 메서드
	void power(){
		power = !power; //!false->true, !true->false
		
		if(power) System.out.println("VCR 전원 On");
		else System.out.println("VCR 전원 Off");	
	}
	
	//실질적인 기능
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
	 * - TV의 bacode는 super.bacode로 접근
	 * - TVCR의 bacode는 this.bacode로 접근
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
		
		this.bacode = 111; //바코드값이 111로 같은 TVCR객체 생성
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
		return "TVCR [power=" + power + ", channel=" + channel + ", bacode=" + bacode + "]";
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
		return super.bacode; //0이 아니라 111(이유? 부모의 멤버변수 참조)
	}

	int getTVCRBacode() {
		return this.bacode;	//(★TVCR에는 bacode 멤버변수 재정의(=Overriding)가 없으므로 부모의 멤버변수 사용)
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

/*
[상황-1] 결과 - int bacode;  같은 이름의 바코드가 부모클래스에만 있을 때
TV 전원 ON
TV 전원 Off
------------------------------------------------
TVCR 전원 ON
TVCR 전원 Off
TVCR 전원 ON
채널 UP 전 : TVCR [power=true, channel=0, bacode=111]
채널 UP 후 : TVCR [power=true, channel=10, bacode=111]
TV 바코드-1:111
TVCR 바코드-1:111
TV 바코드-1-1:333
TVCR 바코드-1-1:333
TV 바코드-1-2:444
TVCR 바코드-1-2:444
------------------------------------------------
TVCR [power=false, channel=0, bacode=222]
TV 바코드-2:222
TVCR 바코드-2:222
TV 바코드-2-1:555
TVCR 바코드-2-1:555
TV 바코드-2-2:666
TVCR 바코드-2-2:666
-------------------------------------------------------------------------------------
[상황-2] 결과 - int bacode;  같은 이름의 바코드가 자식클래스에 추가했을 때
TV 전원 ON
TV 전원 Off
------------------------------------------------
TVCR 전원 ON
TVCR 전원 Off
TVCR 전원 ON
채널 UP 전 : TVCR [power=true, channel=0, bacode=111]
채널 UP 후 : TVCR [power=true, channel=10, bacode=111]
TV 바코드-1:0
TVCR 바코드-1:111
TV 바코드-1-1:333
TVCR 바코드-1-1:111
TV 바코드-1-2:333
TVCR 바코드-1-2:444
------------------------------------------------
TVCR [power=false, channel=0, bacode=222]
TV 바코드-2:111
TVCR 바코드-2:222
TV 바코드-2-1:555
TVCR 바코드-2-1:222
TV 바코드-2-2:555
TVCR 바코드-2-2:666
 */