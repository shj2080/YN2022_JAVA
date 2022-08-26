package interfaceex_inherit_book;

public class MyClassMain {

	public static void main(String[] args) {
		MyClass myClass = new MyClass();
		
		//X, Y 인터페이스를 상속받은 MyInterface를 구현한 MyClass를 X타입으로 자동형변환
		
		//인터페이스 X로 받으면 X에 선언한 메서드만 호출 가능  x()
		X x = myClass;		
		x.x();//재정의
		
		//인터페이스 Y로 받으면 Y에 선언한 메서드만 호출 가능  y()
		Y y = myClass;
		y.y();
		
		//인터페이스 MyInterface로 받으면 "MyInterface에 선언한 메서드+상속한 메서드 모두" 호출 가능
		MyInterface m1 = myClass;
		m1.x();
		m1.y();
		m1.myMethod();
	}

}
