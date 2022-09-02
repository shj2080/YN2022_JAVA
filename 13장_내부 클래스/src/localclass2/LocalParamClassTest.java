/**
 * LocalClass로 참조변수를 선언하지도 못하고 method() 반환형으로 선언하지도 못하며
 * LocalClass로 객체 생성할 때도 LocalClass를 감싸는 method() 내에서만 생성할 수 있으므로
 * 굳이 이름을 붙일 이유가 없으므로 '익명(=anonymous)클래스'로 만들어 사용한다.
 * 
 * '익명 내부 클래스' 사용처 : 자바 UI에서 이벤트 처리할 때 많이 사용
 * 						안드로이드 프로그램에서 이벤트를 처리
 */
package localclass2;

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
	
	/* int ID -> final int ID 이유? (★★자동 final 붙여짐)
	 * method() 호출 결과 객체가 생성되어 그 주소값이 전달되면 지역변수나 매개변수는 Stack 메모리에서 사라진다.
	 * 그러나, final 키워드를 붙이면 지역변수나 매개변수의 복사본을 객체가 생성될 때
	 * 항상 접근 가능한 메모리에 두고 값 변경시키지 못하게 한다. (원본과 복사본 일치하도록)
	 * read()호출하면 사라지지 않은 지역변수나 매개변수의 복사본 값이 출력되도록 한다.
	 */
	Readable method(final int ID) { //★★ 주의 : 리턴 타입으로 Local 사용 불가
		
		class Local implements Readable{	//로컬클래스

			@Override
			public void read() {
				//외부클래스의 private 멤버에도 접근가능
				System.out.println("외부 객체 name : " + myName); //멤버변수
				
				//메서드의 매개변수(지역변수) 값 출력
				System.out.println("로컬 객체 ID : " + ID);
			}
			
		}//Local 클래스 끝
		
		return new Local();
		
	} //method() 끝
	
}//Outer 끝

public class LocalParamClassTest {

	public static void main(String[] args) {
		Outer out1 = new Outer("첫 째");
		Readable local1 = out1.method(111);
		local1.read(); //ID 출력

		Outer out2 = new Outer("둘 째");
		Readable local2 = out2.method(222);
		local2.read();
		
	}

}
