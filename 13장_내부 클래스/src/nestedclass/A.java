/**
 * [내부 클래스=중첩 클래스]
 * - 클래스 내부에 선언한 클래스
 * 
 * - 클래스가 여러 클래스와 관계를 맺는 경우에는 독립적으로 선언하는 것이 좋으나,
 * 	 특정 클래스와 관계를 맺는 경우에는 관계를 클래스 내부에 선언하는 것이 좋다.
 * 
 * - 중첩 클래스를 사용하면 두 클래스의 멤버들을 서로 쉽게 접근할 수 있다는 장점과
 * 	 외부에는 불필요한 관계 클래스를 감춤으로써 코드의 복잡성을 줄일 수 있다.
 * 
 * - 중첩 클래스는 클래스 내부에 선언되는 위치에 따라서 두 가지로 분류
 * 	 1. '클래스 멤버'로서 선언되는 중첩 클래스 : 멤버 클래스
 * 	 2. '메서드 내부'에서 선언되는 중첩 클래스 : 로컬 클래스
 * 	 => '멤버 클래스'는 클래스나 객체가 사용 중이라면 언제든지 재사용이 가능하지만
 * 		'로컬 클래스'는 메서드 실행 시에만 사용되고 메서드가 실행 종료되면 없어진다.
 */
package nestedclass;

/** 외부(=바깥) 클래스 **/
public class A {
	public A() { //외부(=바깥) 클래스의 생성자 내에서
		System.out.println("A 객체가 생성됨");
		
		/** '인스턴스' 멤버(=Inner) 클래스 객체 생성 가능 **/
		B b = new B();
		b.field1 = 1;
		b.method1();
		
		/** '정적' 멤버(=Nested) 클래스-1 객체 생성 가능 **/
		C c = new C();
		c.field1 = 2;
		c.method1();
		
		//static 멤버는 주소로 접근할 수 있지만(경고)
		c.field2 = 3;	//static 필드
		c.method2();	//static 메서드
		
		//static 멤버는 '클래스이름'으로 접근 (권장)
		C.field2 = 3;	//static 필드
		C.method2();	//static 메서드
		
		/** private '정적' 멤버(=Nested) 클래스-2 객체 생성 가능 **/
		D d = new D();
		
		//static 멤버는 주소로 접근할 수 있지만(경고)
		d.field2 = 4;	//static 필드
		d.method2();	//static 메서드
		
		//static 멤버는 '클래스이름'으로 접근 (권장)
		D.field2 = 4;	//static 필드
		D.method2();	//static 메서드
	}
/**-- 1. 멤버 클래스 : A$B.class, A$C.class, A$D.class '바이트 코드' 파일 생성됨 --**/
	/*-------- 1-1. 인스턴스 멤버(=Inner) 클래스 ----------*/
	/** 인스턴스 멤버 클래스
	 * 1. A 객체를 생성해야만 사용할 수 있다.
	 * 	  A 객체를 생성한 후 B 객체를 생성해야 한다.
	 * 2. static 필드나 메서드 선언 불가
	 */
	class B {
		B() { System.out.println("B 객체가 생성됨"); }
		
		int field1;
		//static int field2;	//static 필드나 메서드 선언 불가 (A 객체를 생성해야만 접근가능하므로)
		
		void method1() {}
		//static void method2() {}
	}
	
	/*------------ 1-2. '정적' 멤버(=Nested) 클래스 ------------*/
	// 공통점 : static 필드나 메서드 선언
	
	/** '정적' 멤버(=Nested) 클래스-1
	 * 1. 외부 A 클래스로 바로 접근할 수 있다.
	 */
	static class C {
		C() { System.out.println("C 객체가 생성됨"); }
		
		int field1;
		static int field2;	//static 필드나 메서드 선언 가능
		
		void method1() {}
		static void method2() {}
	}

	/** private '정적' 멤버(=Nested) 클래스-2 **/
	private static class D {
		D() { System.out.println("D 객체가 생성됨"); }
		
		int field1;
		static int field2;	//static 필드나 메서드 선언 가능
		
		void method1() {}
		static void method2() {}
	}
		
/**---------------- 2. 로컬 클래스 ---------------------------------**/	
	void method() {
		/** [★★ 로컬 클래스 ★★]
		 * 1. 메서드가 실행할 때만 사용할 수 있다.
		 * 2. ★★메서드 내에서만 객체 생성하고 사용해야 한다.
		 * 3. 접근제한자(public, private) 및 static 붙일 수 없다.
		 * 	  이유? 메서드 내에서만 사용되므로 접근을 제한할 필요가 없기 때문
		 * 4. A$1E.class  바이트 코드 파일 생성됨
		 * 5. 이 때 사용하는 지역변수는 final이 붙어 상수화되어 있어 메서드 호출이 끝난 후에도 사용가능
		 */
		class E {
			E() { System.out.println("E 객체가 생성됨"); }
			
			int field1;
			//static int field2;	//static 필드나 메서드 선언 가능
			
			void method1() {}
			//static void method2() {}
		}
		
		//★★메서드 내에서만 객체 생성하고 사용해야 한다.
		E e = new E();
		e.field1 = 5;
		e.method1();
	} //method() 끝
	
}//외부 A 클래스의 끝
