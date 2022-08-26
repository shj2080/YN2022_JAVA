/**
 * 다른 클래스의 멤버를 사용하는 방법 : 상속, 포함
 */
package cal;

//부품 클래스들
class Add{ //더하기 클래스
	private int cntAdd = 0;//메서드가 호출될 때 마다 1씩 증가하는 카운터 변수
	
	//기본생성자
	
	//실질적인 기능
	double add(double n1, double n2) {
		cntAdd++;
		return n1 + n2;
	}

	int getCntAdd() {
		return cntAdd;
	}	
	
}

class Sub{	//빼기 클래스
	private int cntSub = 0;//메서드가 호출될 때 마다 1씩 증가하는 카운터 
	
	//기본생성자
	
	//실질적인 기능
	double sub(double n1, double n2) {
		cntSub++;
		return n1 - n2;
	}	
	
	int getCntSub() {
		return cntSub;
	}	
}

class Mul{	//곱하기 클래스
	private int cntMul = 0;//메서드가 호출될 때 마다 1씩 증가하는 카운터 
	
	//기본생성자
	
	//실질적인 기능
	double mul(double n1, double n2) {
		cntMul++;
		return n1 * n2;
	}

	int getCntMul() {
		return cntMul;
	}
	
}

class Div{	//나누기 클래스
	private int cntDiv = 0;//메서드가 호출될 때 마다 1씩 증가하는 카운터 
	
	//기본생성자
	
	//실질적인 기능
	double div(double n1, double n2) {
		cntDiv++;
		return n1 / n2;
	}

	int getCntDiv() {
		return cntDiv;
	}
	
}

/*
 * 1개의 소스파일에 여러 클래스를 설계할 때
 * public은 반드시 1개의 클래스에만 붙일 수 있다.
 * 파일이름 = public붙은 클래스이름
 * (※public은 부품 클래스(Add,Sub,Mul,Div)에 붙이지 않기)
 * 
 * 만약 main() 클래스가 있다면
 * public은 무조건 main() 클래스에만 붙일 수 있다.
 * 파일이름 = main() 클래스이름
 */
public class Calculator { //계산기
	//[포함 관계 만드는 순서]
	//1. 포함할 클래스를 멤버변수(=필드)로 선언
	private Add a;				//6. private으로 정보은닉시켜 "캡슐화"함
	private Sub s;
	private Mul m;
	private Div d;
	
	private int totalCnt = 0;
	
	//★2.생성자
	/* 잘못된 방법
	public Calculator(Add a, Sub s, Mul m, Div d) {
		super();
		this.a = a;
		this.s = s;
		this.m = m;
		this.d = d;
	}
	*/	
	
	public Calculator() { //2. 매개변수가 없는 생성자 호출
		super(); 		  //3. 부모 객체 생성
		
		a = new Add();	  //4. 부품들 생성
		s = new Sub();
		m = new Mul();
		d = new Div();
	}				  	  //5. 최종적으로 계산기 객체 생성

	//7. 외부에 노출된 기능을 가진 버튼([+] [-] [*] [/])
	
	public double add(double n1, double n2) { //버튼[+]
		totalCnt++;
		return a.add(n1, n2);
	}
	
	/*
	public void add(int n1, int n2) { //버튼[+]
		System.out.println(n1+" + " + n2 + " = " + a.add(n1, n2));
	}
	*/
	
	public double sub(double n1, double n2) { //버튼[-]
		totalCnt++;
		return s.sub(n1, n2);
	}
	
	public double mul(double n1, double n2) { //버튼[*]
		totalCnt++;
		return m.mul(n1, n2);
	}
	
	public double div(double n1, double n2) { //버튼[/]
		totalCnt++;
		return d.div(n1, n2);
	}
	
	//실행횟수 출력
	void showOperatingTimes() {	
		
		if(a.getCntAdd() != 0) {
			System.out.println("덧셈 횟수 : " + a.getCntAdd());
		}
		if(s.getCntSub() != 0) {
			System.out.println("뺄셈 횟수 : " + s.getCntSub());
		}
		if(m.getCntMul() != 0) { // > 0
			System.out.println("곱셈 횟수 : " + m.getCntMul());
		}
		if(d.getCntDiv() != 0) {
			System.out.println("나눗셈 횟수 : " + d.getCntDiv());
		}
		//System.out.println("총 실행 횟수 : " + getTotalCnt());
	}

	int getTotalCnt() {
		return totalCnt;
	}
	
	
}
