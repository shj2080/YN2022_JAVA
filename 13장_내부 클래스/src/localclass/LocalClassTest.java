package localclass;

interface Readable {
	//미완성된 추상 메서드
	void read(); //public abstract 생략됨
}

class Outer { //외부 클래스
	//1. 멤버변수
	private String myName;
	
	//2. 생성자
	Outer(String myName) {
		super();
		this.myName = myName;
	}
	
	//3.메서드
	
	/** [★★ 로컬 클래스 : 메서드 내에 정의한 클래스 ★★]
	 * 1. 메서드가 실행할 때만 사용할 수 있다.
	 * 2. ★★메서드 내에서만 '객체 생성하고 사용'해야 한다.
	 * 3. 접근제한자(public, private) 및 static 붙일 수 없다.
	 * 	  이유? 메서드 내에서만 사용되므로 접근을 제한할 필요가 없기 때문
	 * 4. Outer$1Local.class  바이트 코드 파일 생성됨
	 * 5. 이 때 사용하는 지역변수는 final이 붙어 상수화되어 있어 메서드 호출이 끝난 후에도 사용가능
	 */
	Readable method() { //★★ 주의 : 리턴 타입으로 Local 사용 불가
		
		class Local implements Readable{	//로컬클래스

			@Override
			public void read() {
				//외부클래스의 private 멤버에도 접근가능
				System.out.println("외부 객체 name : " + myName);
				
			}
			
		}//Local 클래스 끝
		
		return new Local();
		
	} //method() 끝
	
}//Outer 끝

public class LocalClassTest {

	public static void main(String[] args) {
		Outer out1 = new Outer("첫 째");
		Readable local1 = out1.method();
		local1.read();

		Outer out2 = new Outer("둘 째");
		Readable local2 = out2.method();
		local2.read();
		
	}

}
