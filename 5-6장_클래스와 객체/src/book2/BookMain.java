//실행용 클래스 - main()있는 클래스 (프로그램 실행)
//라이브러리용 + 실행용 클래스
package book2;

/*
 * 다른 패키지에 있는 클래스는 반드시 import해서 사용해야 함
 * 이 때, 'public' class Book이어야 다른 패키지에서도 Book 클래스를 import 할 수 있다.
 */
import book.Book;

public class BookMain {
	//기본생성자
	//public BookMain() {}
	
	//메서드
	public static void main(String[] args) {
		Book b1 = new Book();
		System.out.println(b1.bacode);
				
		System.out.println(b1.getBookAuthor());//null
		b1.setBookAuthor("서동규");
		System.out.println(b1.getBookAuthor());
		
		Book b2 = new Book();
		System.out.println(b2.bacode);
		
		Book b3 = new Book("자바", "황보창민");
		System.out.println(b3.bacode);
		
		Book b4 = new Book("오라클", "김도영", 12345);
		System.out.println(b4.bacode);
		//b4.bacode = 11111;
		
		Book b5 = new Book("HTML", "김도영", 67899);
		System.out.println(b5.bacode);
	}

}
