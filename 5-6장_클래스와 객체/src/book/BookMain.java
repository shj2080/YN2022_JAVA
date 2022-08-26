//실행용 클래스 - main()있는 클래스 (프로그램 실행)
//라이브러리용 + 실행용 클래스
package book;

//같은 패키지에 있는 클래스는 자동 import됨(Book 클래스가 import됨)
//import book.Book;//경고

public class BookMain {
	//1. 필드=멤버변수
	static String s1 = "Book 만들기-1";
	String s2 = "Book 만들기-2";
	
	//2. 기본생성자
	//public BookMain() {}
	
	//3. 메서드
	public static void main(String[] args) {
		System.out.println("----------- [Book] -----------------------------");
		
		/***** static O 멤버변수와 메서드 ************************/
		//static O 멤버변수에 접근 방법-1 : "클래스명."으로 접근(권장)
		System.out.println("책 가격 : " + Book.BOOKPRICE);	  //1. 직접접근
		System.out.println("책 가격 : " + Book.getBookprice()); //2. 간접접근 : 접근가능한 메서드를 통해서
		
		//static O 멤버변수에 접근 방법-2 : "주소."로 접근(경고)
		Book b1 = new Book("뽀로로", "권은재", 11);
		System.out.println("책 가격 : " + b1.BOOKPRICE);		 //1. 직접접근
		System.out.println("책 가격 : " + b1.getBookprice());  //2. 간접접근 : 접근가능한 메서드를 통해서
		
		/***** static X 멤버변수와 메서드 ************************/
		//static X 멤버변수에 접근 방법 : 생성자를 호출 -> 객체 생성 -> 주소로 접근
		//(단, String은 "문자열 상수"만으로도 객체 생성됨)
		System.out.println("책 제목(변경 전)=" + b1.bookName);
		b1.bookName = "어린왕자";
		System.out.println("책 제목(변경 후)=" + b1.bookName);
		//b1.bacode=1; 	//final이므로 값 변경 불가
		
		//private 멤버변수는 다른 클래스에서 접근 불가하므로 "접근가능한 메서드"를 통해서 간접접근
		System.out.println("책 저자-1 : " + b1.getBookAuthor());
		
		//멤버변수의 값을 출력하는 방법-1
		System.out.println("Book [책제목=" + b1.bookName + ", 책저자=" + b1.getBookAuthor() + ", bacode=" + b1.bacode +
				", 책 가격=" + Book.BOOKPRICE + ", 출판사=" + Book.bookCompany +"]");
		//멤버변수의 값을 출력하는 방법-2
		b1.showBookInfo();
		
		/**
		 * 멤버변수의 값을 출력하는 방법-3 : 객체의 값들을 리턴하는 "재정의된 toString()메서드" 호출 결과가 출력됨
		 * Object의 toString()메서드 호출 : book.Book@15db9742(객체주소로 만든 16진수 해쉬코드)
		 * -> Book 클래스에서 Object의 toString()메서드를 재정의 : 재정의된 메서드가 돌려주는 멤버변수의 값
		 */
		System.out.println(b1);
		System.out.println(b1.toString());
		
		System.out.println("----------- [BookMain] -----------------------------");
		System.out.println(s1); //BookMain. 생략가능(?같은 클래스 안에 있으므로)
		
		//기본생성자로 객체 생성
		BookMain bm = new BookMain();
		System.out.println(bm.s1);	   //bm.생략가능(?같은 클래스 안에 있으므로)
		System.out.println(bm.s2); 	   //bm.생략가능?(?같은 클래스 안에 있으므로)
		
		BookMain bm2 = new BookMain();
		//this 사용불가(? main()은 static이므로 바로 메모리에 올라가 있으므로 this. 사용불가)
		//즉, static 메서드 안에서는 this. 사용불가
		//System.out.println(this.s1);
		//System.out.println(this.s2);
		
		
		
	}//main() 끝

	@Override
	public String toString() {	//BookMain. 생략가능? 같은 클래스 안에 있으므로
								//★this.은 사용가능? toString()는 static 없으므로 각 객체 안에 존재 -> 각 객체 안에는 자신의 주소를 가진 this가 존재
		return "BookMain [s1 =" + BookMain.s1 + ", s2=" + this.s2 + "]";
	}
	
	
}
