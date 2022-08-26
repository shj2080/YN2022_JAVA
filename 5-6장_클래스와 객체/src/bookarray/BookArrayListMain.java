package bookarray;

import java.util.ArrayList;
import java.util.Arrays;

import book.Book;

public class BookArrayListMain {

	public static void main(String[] args) {
		/**
		 * 2. ArrayList를 이용하여 객체 관리
		 * 	  - 객체만 관리가능( = 클래스타입만 저장가능)
		 * 		(기본타입은 저장불가능, 그러나, 기본타입이 자동boxing되어 객체로 생성되기에 저장가능함)		
		 * 	  - 추가나 삭제가 편리
		 * 	  - ArrayList객체를 생성할 때부터 "초기화할 수 없는" 단점이 있다.(기본값으로 채워짐)
		 * 	 	 : [해결법]Arrays.asList()메서드를 사용하여 초기화 가능
		 * 	    (배열은 초기화가 가능(예) int[] arr = {1, 2, 3} )
		 */
		
		ArrayList<Book> library = new ArrayList<Book>(); //Book객체 또는 Book의 자식객체만 관리
		//add(E e) : E타입은 ArrayList객체가 생성될 때 타입이 결정됨 -> add(Book e)
		
		/*
		library.add(new Book("태백산맥", "조정래", 1));  
		library.add(new Book("토지", "박경리", 3));
		library.add(new Book("어린왕자", "생텍쥐베리", 4));
		*/
		
		Book b1 = new Book("태백산맥", "조정래", 1);
		library.add(b1); //index 0에 저장됨
		
		Book b2 = new Book("토지", "박경리", 3);
		library.add(b2); //index 1에 저장됨
		
		Book b3 = new Book("어린왕자", "생텍쥐베리", 4);
		library.add(b3); //index 2에 저장됨
		
		//library.add("문자열"); //오류?Book객체가 아니므로 추가불가
		
		System.out.println("** size() 사용 : 저장된 객체수 **");
		for(int i = 0; i < library.size() ; i++) {
			System.out.println(library.get(i));
			//System.out.println(library.get(i).toString());
		}
		System.out.println(); //구분용 빈 줄
		
		//향상된 for : 값을 참조할 때만 사용. 값 변경 불가(이유?index 사용하지 않아서) a[1]=3;
		System.out.println("*** 향상된 for문 사용 ***");
		for(Book b:library) {
			System.out.println(b);
		}
		System.out.println(); //구분용 빈 줄
		
		System.out.println("*** Book 객체 추가 ***");
		library.add(1, new Book("신데렐라", "작자미상", 2)); //index 1 위치에 추가
		for(Book b:library) {
			System.out.println(b);
		}
		System.out.println(); //구분용 빈 줄
		
		System.out.println("*** Book 객체 삭제-1(신데렐라Book) : index로 삭제***");
		System.out.println(library.remove(1));
		System.out.println(); //구분용 빈 줄
		
		for(Book b:library) {
			System.out.println(b);
		}
		
		System.out.println(); //구분용 빈 줄
		System.out.println("*** Book 객체 삭제-2(토지Book) : 객체로 삭제***");
		if(library.remove(b2)) 
			System.out.println("찾아서 삭제함");
		else
			System.out.println("찾았는데 없어서 삭제안함");
		
		for(Book b:library) {
			System.out.println(b);
		}

		//중요 : ["찾아서 삭제함"] 결과? Book클래스에 hashCode()와 equals()메서드를 멤버변수의 값으로 비교하도록 재정의
		if(library.remove(new Book("태백산맥", "조정래", 1))) 
			System.out.println("찾아서 삭제함");
		else
			System.out.println("찾았는데 없어서 삭제안함");
		
		for(Book b:library) {
			System.out.println(b);
		}
		System.out.println(); //구분용 빈 줄
		
		//library는 Book객체, new Integer(1) 또는 "홍길동 이야기"는 String객체
		if(library.remove(new Integer(1)))
			System.out.println("1을 찾아서 삭제함");
		else System.out.println("1을 찾았는데 없어서 삭제못함"); //"찾았는데 없어서 삭제못함"
		
		System.out.println("** toString() 사용 **");
		System.out.println(library.toString());
		//[주소1, 주소2, 주소3]
		//[주소1.toString(), 주소2.toString(),,]
		
		System.out.println(); //구분용 빈 줄
		System.out.println("------------------------Integer----------------------------------------");
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(new Integer(1));
		numbers.add(2);//자동boxing됨(int 2 -> Integer객체 2)
		numbers.add(3);
		numbers.add(4);
		
		System.out.println("*** 향상된 for 사용 ***");
		for(Integer value : numbers) {
			System.out.print(value + " ");
			//System.out.print(value.toString() + " "); //같은 결과
		}
		System.out.println(); //커서 아래로

		for(int value : numbers) {		//자동unboxing(Integer객체1 -> int 1)
			System.out.print(value + " ");
		}
		System.out.println(); //커서 아래로
		
		System.out.println("*** Integer 2 삭제 ***");
		System.out.println(numbers.remove(1));
		
		System.out.println("*** Integer 3을 찾아서 있으면 삭제 후 true ***");
		//결과로 삭제가 되었다면 Integer 클래스도 hashCode()와 equals()메서드가 이미 값으로 재정의됨
		//if(numbers.remove(new Integer(3))) {
		if(numbers.remove(Integer.valueOf(3))) {
			System.out.println("찾아서 삭제함");
		}else System.out.println("찾았는데 없어서 삭제못함");
		
		for(int value : numbers) {		//자동unboxing(Integer객체1 -> int 1)
			System.out.print(value + " ");
		}
		System.out.println(); //커서 아래로
		
		System.out.println("*** ArrayList의 toString() 이용하여 출력 ***");
		System.out.println(numbers.toString());
		System.out.println(numbers);
		
		System.out.println("------------------------String----------------------------------------");
		System.out.println("※ ArrayList 객체생성 시 초기화 안되는 단점 해결 방법 : Arrays.asList() 메서드 사용");
		//순서1. 배열객체 생성
		String[] fruitArr = {"apple", "banana", "mango", "kiwi"};
		//순서2. Arrays.asList(초기화된 배열객체) 사용하여 초기화된 ArrayList 객체생성함
		ArrayList<String> fruits = new ArrayList<String>(Arrays.asList(fruitArr));
		fruits.add("딸기");
		
		System.out.println("과일들=" + fruits); //과일들=[apple, banana, mango, kiwi, 딸기]
		fruits.remove(1);//index 삭제
		System.out.println("삭제 후=" + fruits);
		
		fruits.remove("kiwi"); //객체로 삭제
		System.out.println("삭제 후=" + fruits);
	}

}
