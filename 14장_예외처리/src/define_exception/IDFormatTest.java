//이지스 교재 506p~ 참조

/** [사용자 정의 '예외 클래스']
 * '예외 클래스' 만드는 방법
 */
package define_exception;

//1. 반드시 Exception을 부모로 상속받는다.
class IDFormatException extends Exception{
	//멤버변수
	
	//생성자
	public IDFormatException(String message) {
		super(message); //예외발생 시 얻어 올 예외메세지
		//message가 Exception() 생성자한테 전달되어 e.getMessage()메서드 호출하면 리턴되는 문자열
	}
	
	//메서드
	
}

//실행용+라이브러리용
public class IDFormatTest {
	private String userID; //사용자 아이디 : 8자 이상 ~ 20자 이하
	
	//기본생성자

	public String getUserID() {
		return userID;
	}

	/**
	   예외처리하는 두 번째 방법 : 호출한 메서드로 예외를 던져서 처리(호출한 쪽에서 처리하도록)
  	   throws 예외클래스
	 */
	public void setUserID(String userID) throws IDFormatException {
		/*
		if(userID == null) {
			System.out.println("아이디는 null일 수 없습니다.");
			return;
		}
		else if( !(8 <= userID.length() && userID.length() <= 20) ) {
			System.out.println("아이디는 8자 이상 20자 이하로 쓰세요.");
			return;
		}
		
		//return;  //여기에 쓰면 안됨
		
		this.userID = userID;
		*/
		
		if(userID == null) {
			//사용자 정의 예외 객체는 수동으로 생성
			throw new IDFormatException("아이디는 null일 수 없습니다.");
		}
		else if( !(8 <= userID.length() && userID.length() <= 20) ) { //8자 이상, 20자 이하가 아니라면 (논리연산자 !)
			throw new IDFormatException("아이디는 8자 이상 20자 이하로 쓰세요.");
		}
		
		this.userID = userID;
	}
	
	//두번째 처리 방법 : main() 호출한 JVM이 처리하도록 던짐 -> 프로그램이 강제 종료
	public static void main(String[] args) { //throws IDFormatException {
		IDFormatTest test = new IDFormatTest(); //기본생성자
		
		String userID = null;
		try {
			test.setUserID(userID);
		} catch (IDFormatException e) {
			//e.printStackTrace();
			System.out.println(e);
		}
		
		userID = "1234567";
		try {
			test.setUserID(userID);
		} catch (IDFormatException e) {
			//e.printStackTrace();
			System.out.println(e);
		}
		
		System.out.println("실행");
	}

}
