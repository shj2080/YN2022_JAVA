package polymorphism;

public class M {
	//기본생성자
	
	static void w(A a) { //A객체와 A자손객체를 받아들임(단, A자손객체(B객체 C객체)는 A타입으로 자동형변환(UpCasting)되어 받아들임)
		a.a();
		
		/* 컴파일 오류 없으나 실행 시 java.lang.ClassCastException예외객체 발생 -> 프로그램이 강제 종료
		 * 이유? 실질적인 A객체에는 b()메서드가 존재하지 않으므로...
		 */
		((B)a).b(); //A객체를 B타입으로 형변환 할 수 없음.
	}

	//★★ w()메서드의 문제점을 해결한 메서드
	static void w2(A a) { //A객체와 A자손객체를 받아들임(단, A자손객체(B객체 C객체)는 A타입으로 자동형변환(UpCasting)되어 받아들임)
		//a가 참조하는 객체가 C객체이거나 C자손객체이면 true
		if(a instanceof C) { 	//가장 마지막 자식부터
			C c = (C)a;		// C타입으로 강제 형변환 (DownCasting)
			c.a();		
			c.b();
			c.c(); 	
		}
		else if(a instanceof B) {
			B b = (B)a;		// B타입으로 강제 형변환 (DownCasting)
			b.a();		
			b.b();
		}
		else {	//남은 객체 타입은 A
			a.a();
		}
	}
	
	public static void main(String[] args) {
		A a = new A();
		w2(a);		//w(a);
		System.out.println("**************************");
		
		B b = new B();
		w2(b);		//w(b);
		System.out.println("**************************");
		
		C c = new C();
		w2(c);		//w(c);
		System.out.println("**************************");
		
		System.out.println("---------[다형성]---------------");
		/**
		 * ※ 클래스 대상
		 * [자동 형변환]
		 * 1. 자식객체 -> 부모타입으로 자동 형변환됨(UpCasting)
		 * 	  (예) w(A a), w2(A a)
		 * 
		 * [강제 형변환]
		 * 1. 자식객체 - 부모타입으로 강제 형변환가능(UpCasting)
		 * 2. 부모객체(실제부모) -> 자식타입으로 강제 형변환 가능하지만(=컴파일오류는 없지만)
		 * 					  '실행 시 예외발생'하여 프로그램 강제 종료
		 * 3. 실제 자식 객체 -> 부모타입으로 자동형변환 -> 실제 자식 타입으로 강제형변환 가능 (DownCasting)
		 */
		
		System.out.println("-- [자동-1예] --");
		B b2 = new C(); // 부모 = 자식
		b2.a(); b2.b();
		
		System.out.println("-- [강제-1예] --");
		((A)b2).a();
		
		System.out.println("-- [강제-2예] --");
		A a2 = new B(); //[자동-1예]
		a2.a();
		
		//[강제-2예] (C)a2부분에서 ClassCastException 예외발생(B cannot be cast to C) - 부모객체를 자식타입으로 강제 형변환 불가
		//C c2 = (C)a2;
		//c2.a();
		//c2.b();
		//c2.c();
		
		if(a2 instanceof C) { 		//a2가 참조하는 객체 타입이 C인 경우
			C c2 = (C)a2;
			c2.a();
			c2.b();
			c2.c();
		}
		else if(a2 instanceof B) { 	//a2가 참조하는 객체 타입이 B인 경우
			B b3 = (B)a2;
			b3.a();
			b3.b();
		} else {
			a2.a();
		}
		
		System.out.println("-- [강제-3예] --");
		A a3 = new C();		//[자동-1예]
		a3.a();
		
		((C)a3).c();//[강제-3예]실제 자식 객체 -> 부모타입으로 자동형변환 -> 실제 자식 타입으로 강제형변환
		a3.a(); //★주의 : a3는 여전히 A타입임(이유? 강제형변환 후 대입연산자로 C타입으로 타입변경 안해서)
		
		if(a3 instanceof C) { 		//a3가 참조하는 객체 타입이 C인 경우
			System.out.println("C타입으로 강제형변환");
			C c2 = (C)a3;
			c2.a();
			c2.b();
			c2.c();
		}
		else if(a3 instanceof B) { 	//a3가 참조하는 객체 타입이 B인 경우
			System.out.println("B타입으로 강제형변환");
			B b3 = (B)a3;
			b3.a();
			b3.b();
		} else {
			a3.a();
		}
		
	}

}
