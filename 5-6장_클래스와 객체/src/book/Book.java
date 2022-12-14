//라이브러리용 : main()없는 클래스

/**
 * [접근제한자] public > protected > 아무것도 없는 것(=default) > private
 * 1. public : 어디서든지 접근 가능
 * 2. protected : 같은 패키지에서는 접근 가능(단, 자식은 어디서든 접근 가능=다른 패키지의 자식이라도 접근가능)
 * 3. 아무것도 없는 것(=default) : 같은 패키지에서만 접근 가능(=다른 패키지에서는 접근 불가)
 * 4. private : 같은 클래스안에서만 접근가능(=다른 클래스에서는 접근 불가)
 *  - private 멤버변수는 접근가능한 메서드를 통해서 간접접근할 수 있다.
 *  - private 멤버는 상속불가
 *  
 *  ※ class 앞에 public 있으면 "어디서든지" import 할 수 있다.
 *  			       없으면 "같은 패키지에서만" import 할 수 있다.
 *  
 * [멤버변수에 값을 저장하는 방법]
 * 1. 기본값 : 기본타입(값)	     - int(0) double(0.0), boolean(false), char('\0' 널문자)
	   		클래스타입(객체의 주소) - null(=참조하는 객체가 없다.)
 * 2. 명시적으로 초기화 (예) int a = 10; String s = "b";
 * 3. 생성자를 통해 초기화 : static final 멤버변수는 값을 명시적으로 초기화 한 채 바로 메모리에 올라감
 * 					   그런데 생성자를 통해 값을 변경하려면 오류(이유?final이므로 값 변경불가)
 * 
 * ※ static 영역 = 정적 영역 = 데이터 영역 = 메서드 영역 : 공유
 * 	  heap 영역	= 동적 영역 : 생성자를 통해 객체 생성
 * 	  stack 영역 : 지역변수 (매개변수도 지역변수다.) - 기본타입(값), 클래스타입(객체의 주소)
 * 
 * [멤버변수, 메서드]
 * 1. static 있는 것(=클래스 변수 또는 클래스 메서드 : 클래스이름으로 접근하므로) : 공유
 * 	 - Book 클래스(Book.class)가 메모리에 로딩될 때 그 때 함께 올라감
 * 	   (이 때, static 멤버변수는 초기화되어 올라감)
 * 	 - 만약, static 멤버변수는 '명시적인 값으로 초기화'하지 않으면 '기본값'으로 채워짐
 * 	   그러나, final 있으면 반드시 최초의 1번은 '명시적인 값으로 초기화'시켜줘야 함
 * 	   따라서  static final 은 반드시 '명시적인 값으로 초기화'시켜줘야 함
 * 
 * 	   [static 멤버변수에 값을 저장하는 방법]
 * 		메모리에 올라갈 때 기본값 또는 명시적인 값으로 초기화하여 올라감
 * 	  1. 기본값
 * 	  2. 명시적으로 초기화
 * 	  3. 생성자를 통해 값 변경 가능
 * 		★단, static final은 생성자를 통해 값 변경 안 됨(이유?이미 값이 채워져 있어 값 변경 불가)
 * 
 * 	 - '클래스이름'으로 접근 가능(권장)
 * 	 - '객체주소'로도 접근 가능(경고)
 * 
 * 2. static 없는 것(=instance 변수 또는 instance 메서드) : 객체 안에 존재
 * 	 - '생성자를 통해 멤버변수에 값을 채워' 객체 생성되면 메모리에 올라감
 * 	 - static 없는 멤버변수/메서드는 그 해당 객체 안에 존재
 * 
 * 	   [static 없는 멤버변수에 값을 저장하는 방법]
 * 	  1. 기본값
 * 	  2. 명시적으로 초기화
 * 	  3. 생성자를 통해 초기화
 * 	  ※ 이 때, final 멤버변수 : 반드시 최초의 1번은 초기화(2 또는 3 방법으로 초기화)
 * 							2. 명시적으로 초기화 : 모든 객체의 final 멤버변수의 '값이 같아짐'
 * 							3. 생성자를 통해 초기화 : 생성자의 매개값에 따라 각 객체 안의 final 멤버변수의 '값이 달라짐'
 * 
 * 	 - 반드시 객체의 '주소로만' 접근가능
 * 	   (this : 자신의 객체주소, 해당 객체 안에만 존재. this로 static 멤버에 접근가능하나 경고)
 * 
 * 3. final 멤버변수 : 반드시 '최초의 1번은 초기화'시켜 주고 -> 값 변경 불가
 * 					 변수이름은 '대문자'로 사용(권장)
 * 
 * 					[초기화 방법]
 * 					1. 기본값(X)
 * 					-- 아래 2가지 방법 중 1가지만 사용해야 함
 * 	  				2. 명시적으로 초기화 : 모든 객체의 final 멤버변수의 '값이 같아짐'
 * 	  				3. 생성자를 통해 초기화 : 생성자의 매개값에 따라 각 객체 안의 final 멤버변수의 '값이 달라짐'
 * 
 * 4. static final 멤버변수 : 반드시 '명시적으로 초기화'해야 함
 * 							static(공유) + final(값 변경 불가)
 * 
 * 5. private 멤버변수 : 다른 클래스에서는 접근 불가 -> 정보 보안(=캡슐화)
 * 					  [접근방법]
 * 					  '같은 클래스 안의 접근가능한 메서드를 통해' 간접접근하여 값을 얻거나(=get~())
 * 					  다른 값으로 변경(=set~())할 수 있다.
 * 		※ private 멤버변수/메서드는 상속불가
 
   [final]
   1. final class 클래스명 : 상속불가(=부모 클래스가 될 수 없다.) 즉, 마지막 클래스 이므로 자식이 없다.
   2. final 멤버변수 : 값 변경 불가
   3. final 메서드  : 재정의 불가
   
   [static 메서드가 되는 조건]
   1. 조건 : 메서드()가 static없는 멤버변수(=instance 변수)를 필요로 하지 않고
   			'static있는 멤버변수 또는 매개변수'를 필요로 한다.
   			이 조건을 만족하면 메서드 앞에 static 붙일 수 있다.
   			
   static 있는 멤버변수나 메서드는 해당 클래스(Math.class)가 메모리에 로딩될 때 함께 메모리에 올라옴
   static 없는 멤버변수나 메서드는 생성자를 통해 객체 생성하여 메모리에 올라올 때 그 객체 안에 존재
 */

package book;

import java.util.Objects;

public final class Book {
	/**
	 * 1. 속성 => 멤버변수(=field 필드) : 옵션
	 */
	public String bookName;   //책제목
	private String bookAuthor;//책저자
	//final : 반드시 1번만 초기화(명시적 또는 생성자)
	public final int bacode;	//각 책의 바코드값을 다르게 설정하고 싶을 때-생성자를 통해 최초의 1번만 초기화
	
	//static final = static은 메모리에 값을 채워 올라감(기본값 또는 '명시적'인 값) + final : 반드시 1번만 초기화('명시적' 또는 생성자)
	//=> static final은 반드시 명시적으로 값을 초기화해줘야 함
	public static final int BOOKPRICE;	  //책가격
	
	public static String bookCompany = "영남출판사";		//출판사
	
	/* [static 초기화 블록] static 멤버변수에 초기값을 적용
	 * - 언제 사용? '복잡한 계산'을 해야 하거나 '메서드 호출한 결과'를 초기값으로 세팅시켜야 할 때
	 */
	static {
		//'복잡한 계산' 1~100까지의 합계 대입
		int hap = 0;
		for(int i = 1; i <= 100;i++) {
			hap += i;
		}
		//BOOKPRICE = hap;
		
		//'메서드 호출한 결과'-예 : 반드시 static 메서드만 호출 가능
		BOOKPRICE = hap(10, 100);//오류? final이므로 값 변경 불가
	}
	
	/* [instance 초기화 블록] 생성자가 호출되기 직전에 초기화 블록이 실행됨
	 * - 언제 사용? '복잡한 계산'을 해야 하거나 '메서드 호출한 결과'를 초기값으로 세팅시켜야 할 때
	 */
	/*
	{
		System.out.println("*** 초기화 블록 ***");
		bacode = Math.abs(-12345)+10;
		//bacode +- 10;//오류? final이므로 값 변경 불가
	}
	*/
	
	/**
	 * 2. 생성자는 반드시 존재
	 * [생성자 역할] 멤버변수에 값을 채워 객체 생성
	 * - 생성자는 반환타입(=리턴타입)이 없다. void 자체도 없음.
	 * - 객체 안에 생성자는 존재하지 않음
	 * 
	 * - 생성자 없으면 컴파일러가 컴파일하기 전, 자동으로 기본생성자 삽입
	 * - 생성자 {}안에 super();가 없으면 컴파일러가 컴파일하기 전, 자동으로 ★첫 줄에 삽입
	 *   ★반드시 첫 줄에 super();삽입하는 이유? super(); 부모 생성자를 호출 -> 부모 객체 생성
	 *   
	 * [기본생성자]
	   public class Book {	public Book() { super(); }	}
	   		  class Book {		   Book() { super(); }	}
	   - 기본생성자는 super(); 호출하여 부모 생성 -> 자식의 멤버변수에 '기본값'으로 채워 자식 객체 생성
	   - 기본값 : 기본타입(값)	     - int(0) double(0.0), boolean(false), char('\0' 널문자)
	   			클래스타입(객체의 주소) - null(=참조하는 객체가 없다.)
	   			
	 * super.부모의 멤버변수/메서드 : 'super(부모의 주소)'로 접근
	 * super();				  : '부모의 생성자'호출
	 * 						    반드시 자식생성자 안에서만 사용가능
	 * 
	 * this.자신의 멤버변수/메서드	  : 'this(자신의 주소)'로 접근
	 * this();				   : 생성자 안에서 '자신의 다른 생성자'를 호출할 때 사용
	 * 						     매개변수 적은 생성자 안에서 매개변수가 많은 생성자를 호출할 때 사용
	 * 							 반드시 생성자 안에서만 사용가능
	 */
	public Book() {
		super();
		//'초기화 블록 주석해제'하면 오류? final bacode : 초기화 블록을 통해 초기화 후 생성자를 통해 값 변경 불가
		this.bacode = 11111;//각 객체의 바코드 값이 동일해짐
		//this.생략가능 ? 같은 클래스안에 있으므로
		
		bookCompany = "기술출판사";
	}

	public Book(String bookName, String bookAuthor) {
		//4줄
		//super();
		//this.bookName = bookName;
		//this.bookAuthor = bookAuthor;
		//bacode = 22222;//각 객체의 바코드 값이 동일해짐
		
		/* this. 생략 불가 ? 멤버변수명과 매개변수명이 같아 구분하기 위해
		 * 
		 * this(); ★이 코드 위에는 어떠한 실행문도 있어서는 안 됨
		 * 
		 * 1. this() 이용하여 다른 생성자를 호출할 때는 첫 번째 줄에 super(); 호출하면 안됨
		 * 	  이유? 2개의 부모가 생성되므로. 자바는 단일부모로 단일상속됨
		 * 2. 부모 생성 후 자식의 멤버변수에 값을 채워 자식객체 생성하므로
		 */
		//super(); //=>오류 발생-1의 예
		//bacode = 22222; //=>오류 발생-2의 예
		this(bookName, bookAuthor, 22222); //1줄로 간략화됨
	}

	public Book(String bookName, String bookAuthor, int bacode) {
		super(); //반드시 생성자의 맨 첫 줄에. 1. 부모(Object) 생성자 호출 -> 부모 객체 생성
		
		this.bookName = bookName;	//  2. 자식의 각 멤버변수에 값을 채워 자식 객체 생성
		this.bookAuthor = bookAuthor;		//this. 생략불가? 멤버변수와 매개변수를 구분하기 위해
		this.bacode = bacode;//매개값에 따라 바코드값이 달라짐
	}
	
	
	
	/**
	 * 3. 기능 => 메서드 : 옵션
	 * get~() 		: 멤버변수의 값을 얻어올 때
	 * set~(매개변수) 	: 전달받은 매개값으로 멤버변수의 값을 변경할 때 
	 */
	
	/*------- static O ------------------------------*/
	//'메서드 호출한 결과'-예
	static int hap(int start, int end) { //10, 100
		int hap = 0;
		
		for(int i = start; i <= end; i++) {
			hap += i;
		}
		
		return hap;
	}
	
	public static int getBookprice() {
		return Book.BOOKPRICE; //Book.생략가능 ? 같은 클래스 안에 존재하므로...
		//이 때, static메서드가 아닐 때는 this.로도 접근가능하다. => 경고
		//그러나 static메서드일 때는 this.는 사용불가? static 메서드는 객체 생성 이전에 이미 메모리에 올라와 있으므로...)
	}
	
	/*------- static X ------------------------------*/
	public String getBookName() {
		return bookName; //this.생략
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public int getBacode() {
		return bacode;
	}
	
	//final이므로 값 변경 불가 -> 따라서 처음부터 이 메서드를 안 만듦
	/*
	public void setBacode(int bacode) {
		this.bacode = bacode; //오류
	}
	*/
	
	public void showBookInfo() { //this.생략가능 Book.생략가능 => 이유? 같은 클래스 안에 있으므로
		System.out.println("Book [bookName=" + this.bookName + ", bookAuthor=" + bookAuthor + ", bacode=" + bacode +
				", 책 가격=" + Book.BOOKPRICE + ", 출판사=" + bookCompany +"]");
	}
	
	/**
	 * [메서드 재정의] : 부모로부터 상속받은 메서드를 그대로 사용하지 않고 자식클래스에서 재정의
	 * 1. '리턴타입과 메서드이름(매개변수)'가 부모와 같아야 한다.
	 * 	  (단, 리턴타입은 자식클래스 타입으로 변경가능하다. => 뒤에서 예제와 함께 설명 : 11장_StudentClone.java)
	 * 
	 * 2. ★★ 재정의할 때 '접근제한자는 부모와 같거나 더 넓은 범위로' 한다.
	 * (그래야 부모의 메서드를 재정의된 자식의 메서드로 덮어씌워
	 * 컴파일러가 재정의된 자식 메서드만 호출할 수 있도록 한다.)
	 * ※ public > protected > 아무것도 없는 것(=default) > private
	 * 
	 * 3. 예외는 부모 클래스 메서드의 예외보다 더 많이 선언할 수 없다.
	 * 	  (예-1) 부모메서드() throws IOException, SQLException
	 * 			자식메서드() throws IOException  (O)
	 * 			자식메서드() throws SQLException (O)
	 * 
	 * 	  자식메서드는 부모메서드의 예외 중 '자식예외클래스'는 사용가능
	 * 	  (예-2) 부모메서드() throws IOException, SQLException
	 * 			자식메서드() throws SocketException (O) : 이유? SocketException(자식) extends IOException(부모)
	 * 			자식메서드() throws Exception 	  	 (X) : 이유? Exception은 모든 예외의 부모
	 * 
	 * 	  재정의 메서드는 재정의된 메서드가 예외를 선언하는지 여부에 관계없이 확인되지 않은 (런타임=실행) 예외를 throws 할 수 있다.
	 * 	  (예-3:예외) 부모메서드() {..}
	 * 			자식메서드() throws IOException {..}
	 * 			자식메서드() throws SocketException {..}
	 * 			자식메서드() throws NumberFormatException {..}
	 * 			=> 오류 유무는 자바컴파일러한테 맡김
	 */
	
	/**
	 * [toString() 재정의하는 이유]
	 * Object의 toString() : book.Book@15db9742(객체주소로 만든 16진수 해쉬코드)
	 * -> Object의 toString()를 재정의하여 원하는 값을 리턴하기 위해서...
	 * 
	 * @Override : 어노테이션 - 감시자 역할 (재정의할 때 문법적으로 맞는지 확인하여 틀리면 오류를 띄워줌)
	 */
	
	//toString() 재정의하는 방법-1 : 마우스우클 -> 소스 -> 메서드 대체/구현(=Overriding) -> 재정의할 메서드 선택 -> 확인 
	/*
	@Override
	public String toString() {
		//return super.toString(); //super : 부모(=Object)의 주소
		return "Book";
	}
	*/
	
	//toString() 재정의하는 방법-2 : 마우스우클 -> 소스 -> Generate toString().. -> 필드 선택 -> 확인
	@Override
	public String toString() {	//this.생략가능 Book.생략가능 => 같은 클래스안에 있으므로
		return "Book [bookName=" + this.bookName + ", bookAuthor=" + bookAuthor + ", bacode=" + bacode +
				", 책 가격=" + Book.BOOKPRICE + ", 출판사=" + bookCompany +"]";
	}


	
	//hashCode() 재정의 : 멤버변수의 값으로 해쉬코드 만듦 -> Hash~시작하는 클래스에서 같은 객체로 취급하여 추가할 수 없도록 함
	//Object의 hashCode()는 객체의 주소로 만듦 -> 객체의 멤버변수의 값으로 만듦
	
	@Override
	public int hashCode() {
		return Objects.hash(bacode, bookAuthor, bookName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return bacode == other.bacode && Objects.equals(bookAuthor, other.bookAuthor)
				&& Objects.equals(bookName, other.bookName);
	}
	
}
