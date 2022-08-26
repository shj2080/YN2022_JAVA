import java.util.Scanner;

public class MainStringArray {	//부모=슈퍼:Object
	/*
	 * 1. 속성 => 멤버변수=필드(field) : 기본값(기본타입:0, 클래스타입:null)
	 */
	
	/*
	 * 2. 생성자 : 생성자는 반드시 존재 (생성자 없으면 컴파일러가 컴파일하기 전에 기본생성자를 자동 삽입)
	 * 	  생성자 역할 : 생성자는 멤버변수가 있으면 멤버변수에 값을 채워 객체 생성
	 * 							   없으면 그냥 "객체 생성"
	 */
	//기본생성자	public MainStringArray(){super();}
	
	/*
	 * 3. 기능 => 메서드
	 */
	
	/* JVM이
	 * MainStringArray.class 파일을 메모리에 로딩할 때 static 붙은 멤버들은 함께 메모리에 올라감
	 * 이 때, JVM이 main()을 호출할 때 "length가 0인 String[] 배열객체" 생성하여 호출함
	 */
	public static void main(String[] args) {	//인수=인자=매개변수=argument
		System.out.println("args가 참조하는 배열의 길이="+args.length);
		
		if(args.length != 4) {		//args의 길이가 4가 아닌 경우
			System.out.println("실행할 때 4개의 숫자를 입력하세요.(정수 2개, 실수 2개)");
			return; //해당 메서드(=main()) 종료 => 프로그램 종료
			//System.exit(0); //프로그램 종료
		}
		
		//향상된 for문 : 배열에서 값을 참조만 가능, 값 변경 불가
		for(String addr:args) {
			System.out.println(addr);
		}
		
		/*
		int i;
		for(i = 0; i < args.length; i++) {
			System.out.println(args[i].charAt(0));
		}
		*/
		
		System.out.println("------두 정수와 두 실수 연산 ------");
		
		//String s1 = args[0];//String "10"을 참조하는 객체의 주소
		//String s2 = args[1];//String "20"을 참조하는 객체의 주소
		String s3 = args[2];//String "1.23"을 참조하는 객체의 주소
		String s4 = args[3];//String "2.5"을 참조하는 객체의 주소
		
		//1.연산하기 위해 문자열 -> 수 변환
		int i1 = Integer.parseInt(args[0]); //"10"->10
		int i2 = Integer.parseInt(args[1]);//"20"->20
		
		double d1 = Double.parseDouble(s3);//"1.23"->1.23
		double d2 = Double.parseDouble(s4);//"2.5"->2.5
		
		MainStringArray msa1 = new MainStringArray();
		MainStringArray msa2 = new MainStringArray();		//새 객체는 얼마든지 생성가능
		
		//2-1.연산자를 입력받아 두 정수를 연산한 결과 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1. [두 정수 연산] 연산자 입력(+-*/) > ");
		String opr = sc.next();
		
				
		switch(opr) {
		case "+":
			System.out.println(i1 + "+" + i2 + "=" + MainStringArray.add(i1,i2)); //30.0
			break;
		case "-":
			System.out.println(i1 + "-" + i2 + "=" + sub(i1,i2)); //-10
			break;
		case "*":
			msa1.mul(i1, i2);
			break;
		case "/":
			msa1.div(i1, i2);
			break;
			default:
				System.out.println("잘못된 연산자입니다.");
				//break;
		}
		
		System.out.print("2. [두 실수 연산] 연산자 입력(+-*/) > ");
		opr = sc.next();
		
		switch(opr) {
		case "+":
			System.out.println(d1 + "+" + d2 + "=" + MainStringArray.add(d1, d2));
			break;
		case "-":
			System.out.println(d1 + "-" + d2 + "=" + sub(d1, d2));
			break;
		case "*":
			msa2.mul(d1, d2);
			break;
		case "/":
			msa2.div(d1, d2);
			break;
			default:
				System.out.println("잘못된 연산자입니다.");
				//break;
		}
		System.out.println("----------끝-------------");
		
		sc.close();
	} //main() 종료
	
	/** 두 정수 연산 메서드(결과 리턴) **/
	//+, - : static 메서드
	static double add(int i1, int i2){
		return i1 + i2;	//결과 int 30 -> double 30.0 자동형변환되어 리턴
	}
	
	static int sub(int i1, int i2){
		return i1 - i2;	//결과 int -10
	}
	
	//*, / : static 없는 메서드
	void mul(int i1, int i2){		//void : 리턴되는 결과 없음
		System.out.println(i1 + "*" + i2 + "="  + (i1*i2));
	}
	
	void div(int i1, int i2) {
		System.out.println(i1 + "/" + i2 + "="  + ((double)i1/i2));
	}
	
	/** 두 실수 연산 메서드 **/
	//+, - : static 메서드
	static double add(double d1, double d2) {
		return d1 + d2;
	}
	
	static double sub(double d1, double d2) {
		return d1 - d2;
	}
		
	//*, / : static 없는 메서드
	void mul(double d1, double d2) {	//void : 리턴되는 결과 없음
		System.out.println(d1 + "*" + d2 + "=" + (d1 * d2));
	}
	
	void div(double d1, double d2) {
		System.out.println(d1 + "/" + d2 + "=" + (d1 / d2));
	}
}//class 끝
