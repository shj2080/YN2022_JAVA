package polymorphism;

public class C extends B {	//A <- B <- C
	//기본생성자
	
	@Override
	void a() {
		System.out.println("C에서 a() 재정의");
	}

	@Override
	void b() {
		System.out.println("C에서 b() 재정의");
	} 	
	
	void c() {
		System.out.println("C에서 c() 정의");
	}
	
}
