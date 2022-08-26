package polymorphism;

public class B extends A {
	//기본생성자
	
	
	@Override
	void a() {
		System.out.println("B에서 a() 재정의");
	}	
	
	//추가
	void b() {
		System.out.println("B에서 b() 정의");
	}
}
