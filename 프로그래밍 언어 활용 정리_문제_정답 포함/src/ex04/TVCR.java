package ex04;

abstract class Electronics { //부모:자손의 공통된 속성과 기능
	//1.멤버변수(=필드) - 변수 타입과 변수명 등은 문제에서 주어짐(★문제에서 주어진 경우 반드시 문제에 나온대로 써야함)
	final String country = "한국";	//만든나라 : "한국"로 초기화(》명시적,생성자) -> 값 변경 불가(final)
	String company; //만든회사
	boolean power;
	
	//2. 기본생성자
	
	//3. 메서드 : 반드시 자손 클래스에서 알맞게 재정의하여 사용
	abstract void power();
}

class TV extends Electronics{
	/* [상속받은 멤버변수]
	 final String country = "한국";
	 String company;
	 boolean power;
	 */
	
	//1. 멤버변수(=필드) 추가
	int channel;
	
	//2. 생성자 : 멤버변수명과 매개변수명이 같다.
	TV(String company) {
		this.company = company;
	}
	
	//3. 메서드
	@Override
	void power() {
		power = !power;
		
		if(power) System.out.println("TV 전원 ON");
		else System.out.println("TV 전원 OFF");
	}
	
	void channelUp() {
		channel++;
	}
	
	void channelDown() {
		channel--;
	}
	
}

class VCR extends Electronics{
	/* [상속받은 멤버변수]
	 final String country = "한국";
	 String company;
	 boolean power;
	 */
	
	//3. 메서드
	@Override
	void power() {
		power = !power;
		
		if(power) System.out.println("VCR 전원 ON");
		else System.out.println("VCR 전원 OFF");
	}
	
	//메서드 추가 : 실질적인 기능
	void play(){ //호출하면 "재생"을 출력
		System.out.println("재생");
	}
	
	void stop() { //호출하면 "멈춤"을 출력
		System.out.println("멈춤");
	}
	
}

public class TVCR extends TV{
	//1. 멤버변수(=필드) : VCR 클래스를 포함한 후 정보은닉(=>캡슐화)
	private VCR vcr; //[포함순서-1]
	
	//2. 생성자
	public TVCR(String company) { //"삼성"
		super(company);		//부모클래스의 TV(String company) 호출
		vcr = new VCR(); //[포함순서-2] 생성자를 통해 VCR객체 생성
	}
	
	//3. 메서드 : [포함순서-3] 외부에 노출된 버튼의 메서드 호출하여 실질적인 기능을 가진 메서드 실행시킴
	public void play() {
		vcr.play();
	}
	
	public void stop() {
		vcr.stop();
	}
	
	@Override
	public void power() { 	//★주의 : TVCR power() 재정의 안하면 상속받은 부모클래스 TV의 power() 사용함!
		power = !power;
		
		if(power) System.out.println("TVCR 전원 ON");
		else System.out.println("TVCR 전원 OFF");
	}
	
	void showTVCR() { //호출하면 TVCR의 각 멤버변수의 값을 출력
		//콘솔 출력 결과를 보고 채우기
		System.out.println("만든 나라:" + country + ", 만든 회사:" + company + ", 전원:" + power + ", 현재 채널:" + channel);
		
	}//만든 나라:한국, 만든 회사:삼성, 전원:true, 현재 채널:5
}
