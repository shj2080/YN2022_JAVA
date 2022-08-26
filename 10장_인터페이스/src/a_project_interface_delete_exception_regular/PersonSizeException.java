package a_project_interface_delete_exception_regular;
/**
 * 예외 클래스 만드는 방법 *
 */

//1. 반드시 Exception을 부모로 상속받는다.
public class PersonSizeException extends Exception{
	//2. 멤버변수 추가(=>옵션)
	
	//3. 생성자
	public PersonSizeException() {
		super("더 이상 고객 정보를 저장할 공간이 없습니다.~"); //예외 발생 시 출력하고 싶은 예외메세지
		//Exception(String message)생성자에게 전달되어 e.getMessage()메서드 호출하면 리턴되는 문자열
	}
	
	//4. 메서드 추가(=>옵션)
}
