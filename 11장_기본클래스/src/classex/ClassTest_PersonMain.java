/**
 * [Class 클래스]
 * 자바의 모든 클래스와 인터페이스는 컴파일을 하면 class파일 생성됨
 * Class 클래스는 컴파일된 "class파일에 저장된 클래스나 인터페이스 정보를 가져오는데" 사용함
 */
package classex;

public class ClassTest_PersonMain {

	public static void main(String[] args) {
		/** Class 클래스를 선언하고 클래스 정보를 가져오는 3가지 방법 **/
		
		//[방법-1] : 생성된 객체 필요
		Person person = new Person();
		Class p1 = person.getClass();
		System.out.println(p1.getName()); //classex.Person
		
		//[방법-2]
		Class p2 = Person.class; //컴파일된 파일을 대입
		System.out.println(p2.getSimpleName()); //Person (클래스이름만 얻어옴)
		
		//[방법-3]★★
		//컴파일러가 Person클래스를 찾아서 있으면 메모리에 로딩 시킴(=동적로딩)
		Class p3 = null;
		try {
			p3 = Class.forName("classex.Person");
		} catch (ClassNotFoundException e) { //이름과 일치하는 클래스가 없는 경우
			e.printStackTrace(); //ClassNotFoundException예외발생은 반드시 처리
		}
		
		System.out.println(p3.getSimpleName()); //Person (클래스이름만 얻어옴)
	}

}
