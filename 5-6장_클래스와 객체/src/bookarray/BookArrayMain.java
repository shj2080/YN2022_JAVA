package bookarray;

import book.Book;

public class BookArrayMain {

	public static void main(String[] args) {
		/**
		 * 1. 배열을 이용하여 객체 관리
		 */
		Book[] library = new Book[3];//[null,null,null]
		
		library[0] =  new Book("태백산맥", "조정래", 1);
		library[1] =  new Book("토지", "박경리", 2);
		library[2] =  new Book("어린왕자", "생텍쥐베리", 3);
		
		//컴파일오류 없으나 ArrayIndexOutOfBoundsException예외발생하여 프로그램 멈춤
		//library[3] =  new Book("신데렐라", "작자미상", 4);
		
		System.out.println("*** 반복문 for 사용 ***");
		for(int i = 0; i < library.length; i++) {
			System.out.println(library[i]); //재정의한 toString()메서드 호출된 결과를 리턴받아 출력
		}
		
		System.out.println("*** 향상된 for 사용 ***");
		for(Book b:library) {
			System.out.println(b); //재정의한 toString()메서드 호출된 결과를 리턴받아 출력
		}
		
		System.out.println("-----------------------------------------------------");
		for(Book b:library) {
			b.showBookInfo();
		}
		
		System.out.println("----- [토지] 객체 삭제 후 출력 ------------------------------------------------");
		//우리가 "토지"가 저장된 배열위치를 안다면
		library[1] = library[2]; //"토지"주소=뒤주소("어린왕자"주소)
		library[2] = null;
		
		for(Book b:library) {
			if(b != null) {
				b.showBookInfo();
			}
		}
		System.out.println("----- [새Book] 객체 추가 후 출력 ------------------------------------------------");
		//우리가 library[2]가 null 이라는 사실을 안다면
		library[2] = new Book("신데렐라", "작자미상", 4);
		
		for(Book b:library) {
			if(b != null) {
				b.showBookInfo();
			}
		}
		
		/**
		 * 배열로 객체를 관리할 때 문제점
		 * 1. 배열은 크기가 고정 : 메모리를 비효율적으로 사용
		 * 					(예) length == 100, 그런데 1개만 사용하는 상황 :  나머지 99개는 비어 있는 문제(메모리 낭비)
		 * 						 length == 100, 그런데 1개가 더 필요한 상황 : 크기를 101로 변경못함. 즉, 1개 더 추가 못하는 문제점(메모리 추가 할당 불가)
		 * 
		 * 2. 추가와 삭제에 대한 코드를 프로그래머가 작성해야 하지만
		 *  [컬렉션 프레임워크]의 클래스나 인터페이스를 이용하여 간단하게 해결할 수 있다.
		 *  (예:ArrayList, Vector, LinkedList / ...)
		 */
		
	}

}
