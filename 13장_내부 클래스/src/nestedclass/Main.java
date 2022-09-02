package nestedclass;

public class Main {

	public static void main(String[] args) {
		A a = new A(); //외부(=바깥) 클래스
		System.out.println(); //구분 빈 줄
		
		/**---------- 1. 멤버 클래스 ---------------------**/
		/** 1-1. '인스턴스' 멤버(=Inner) 클래스 **/
		//외부 클래스 객체 생성 후 -> '인스턴스' 멤버 클래스 객체 생성 가능
		A.B b = a.new B(); //★★ 외부객체의 참조변수.new 내부();
		//A.B b = new A.B(); //오류 => static 멤버 클래스가 아니므로
		
		b.field1 = 6;
		b.method1();
		
		System.out.println(); //구분 빈 줄
		
		/** 1-2. '정적' 멤버(=Nested) 클래스-1 **/
		//외부 클래스 객체 생성하지 않고 -> '정적' 멤버 클래스 객체 생성 가능
		A.C c = new A.C();//외부.내부 참조변수 = new 외부.내부();
		
		c.field1 = 7;
		
		c.field2 = 8; //경고!
		A.C.field2 = 9; //권장
		
		c.method1();
		
		c.method2(); //경고!
		A.C.method2(); //권장
		
		System.out.println(); //구분 빈 줄
		
		/** 1-2. private '정적' 멤버(=Nested) 클래스-1 **/
		//외부에서 private '정적' 멤버 클래스 객체 생성 불가능
		//A.D d = new A.D(); //오류
		
		/**---------- 2. 로컬 클래스 ---------------------**/
		//로컬 클래스 객체 생성을 위한 메서드 호출
		a.method(); //메서드 내 E 객체는 메서드가 끝나면 소멸함
		
		
	}

}
