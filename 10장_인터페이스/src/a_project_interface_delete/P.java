/*
 * 인터페이스 : 클라이언트 프로그램에 '어떤 메서드를 제공하는지' 미리 알려주는 명세 또는 약속
 */

/**
 * [추상 클래스와 인터페이스의 공통점]
 * 1. 자손에서 반드시 재정의해야 할 '미완성된 추상 메서드가 존재'. 자손에서 재정의 안하면 오류
 * 2. 객체 생성 불가 : 이유? 미완성이므로
 * 3. 그러나, 부모 역할 가능
 * - 추상클래스의 예
 * 	 (예1) void method(Electronics e) {  //Electronics의 자식객체(TV,VCR,TVCR)
 * 									-> 자동으로 Electronics로 형변환되어 받아들임 (UpCasting)
 * 		  }
 * 	  (예2)		Electronics e = new TV();		//자동으로 Electronics로 형변환되어 받아들임
 * 	  			Electronics e = new VCR();
 * 	  			Electronics e = new TVCR();
 * 
 * - 인터페이스의 예
 * 	 (예1) void method(P p) {	//P인터페이스를 구현한 PI객체
 * 								-> 자동으로 P로 형변환되어 받아들임 (UpCasting)
 * 		   }
 * 
 * 	 (예2) P p = new PI();
 * 
 * [추상 클래스만의 특징]
 * 1. 여러 메서드 중 단 1개라도 미완성된 추상 메서드가 있으면 이 클래스는 추상 클래스가 된다.
 * 
 * [인터페이스만의 특징]
 * 1. 모든 멤버변수가 '상수'
 * 		int A = 1; 	//public static final 생략되어 있음
 * 		public static final int A = 1;
 * 		접근방법 : 인터페이스명.멤버변수명 (예)P.A;
 * 
 * 2. 모든 메서드가 미완성된 추상 메서드 : 인터페이스를 구현하는 자손 클래스에서 반드시 재정의
   	  void a(); 		//public abstract 생략되어 있음
   	  public abstract void a();
   	  
   	  ★예외-1 : static 메서드() - 자체로 완성된 메서드로 "바로 메모리에 올라감". "클래스 생성과 무관하게 사용가능"
   	  		   => 구현한 자손 클래스에서 "재정의X" (공유용)
   	  		   (예)  static void 이름표시() {"핸드폰"출력}
   	  		   구현한 100개의 자손 클래스는 재정의안하고 그냥 '인터페이스이름 접근'하여 사용하면 됨
   	  		   
   	  ★예외-2 : default 메서드() {} - 자체로 완성된 메서드
   	  		   => 구현한 자손 클래스에서 "필요하면 재정의"하여 사용하면 됨
   	  		   (예-1) default void 접는기능() {}
   	  		   구현한 100개의 자손 클래스 중 필요한 클래스만 재정의하면 됨
   	  		   
   	  		   (예-2) default void 전화를 받는 기능() {"사람이 전화를 받는다."}
   	  		   구현한 100개의 자손 클래스 중 99개는 이 기능을 그대로 사용하지만
   	  		   1개 클래스는 자기 클래스에 맞게 재정의할 수 있다.
   	  		   		(예) default void 전화를 받는 기능() {"AI가 전화를 받는다."}
   	  		   		
   	  ★예외-3 : private 메서드() ('JDK1-9 = 자바9'부터 사용가능)
   	  		   - 인터페이스 내부에서만 기능을 제공하기 위해 구현하는 메서드
   	  		   => 구현한 자손 클래스에서 사용X, 재정의X
   	  		   
 */

/*
 * 홍 대표가
 * a회사에 2개의 메서드를 완성해달라고 의뢰
 * '인터페이스'에 담아서 의뢰
 * 
 */
package a_project_interface_delete;

public interface P {
	//입력, 검색, 삭제, 종료
	int INPUT = 1, SEARCH = 2, DELETE = 3 ,EXIT = 4;	//멤버변수 앞에 public static final 생략
	
	//1. 필수:[이름, 주민등록번호], 옵션:[전화번호, 주소]를 입력
	void input(); //public abstract 생략
	
	//2. 주민등록번호를 기반으로 고객의 이름이나 정보를 검색
	void search(); //public abstract 생략
	
	//3. 주민등록번호를 기반으로 고객객체 삭제
	void delete();
	
	/************인터페이스 문법적 설명위해 아래 코드 추가*************************************/
	//★예외-1 : 인터페이스를 구현한 모든 클래스에서 "클래스 생성과 무관하게 사용가능" - static 메서드()
	static int add(int...arr) { //P.add(10,20,30);호출하면 arr->[10,20,30](length가 3인 배열객체) - 가변인수에 들어온 값들을 배열에 담음
		int hap = 0;
		
		for(int value:arr) {
			hap += value;
		}
		//p1(); 	//오류?p1()메서드는 static아니므로... (메모리에 적재되어 있지 않은 메서드 참조)
		//p2();		//호출가능?p2()메서드는 static이므로...
		return hap;
	}
	
	//★예외-2 : 그대로 사용하기 싫은 자손클래스만 재정의하면 됨 - default 메서드()
	public default void show() {
		System.out.println("[정보 출력]");
		//p1();
	}
	
	//★예외-3 : 자바9(JDK1.9)부터 사용되므로 자바8(JDK1.8)에서는 오류발생 - private 메서드()
	/*
	private void p1() {
		System.out.println("----------- ^^ ------------");
	}
	private static void p2() {
		System.out.println("합을 구합니다.");
	}
	*/
}
