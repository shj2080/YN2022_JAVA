package ex04;

abstract class Electronics{ //부모:자손의 공통된 속성과 기능
	//1.멤버변수(=필드)
	country//만든나라 :"한국"로 초기화(ˇ명시적,생성자) -> 값변경 불가(final)
	company//만든회사
	power  //전원
	
	//2.기본생성자
	
	//3.메서드 : 자손 클래스에서 알맞게 재정의하여 사용
	power
}


class TV extends Electronics{	
	/* 상속받은 멤버변수
	 final String country = "한국";
	 String company; 
	 boolean power;
	 */
	
	//1.멤버변수(=필드) 추가
	channel
	
	//2. 생성자 : 멤버변수와 매개변수의 이름이 같다.
	TV(String company) {
		
	}
	
	//3. 메서드
	
	
	
	channelUp


	channelDown

	
}

class VCR extends Electronics{
	/* 상속받은 멤버변수
	 final String country = "한국";
	 String company; 
	 boolean power;
	 */

	//3. 메서드
	
	//메서드 추가 : 실질적인 기능
	play//호출하면 "재생"을 출력
		
	
	
	stop//호출하면 "멈춤"을 출력
		
	
}

public class TVCR extends TV{
	//1. 멤버변수(=필드) : VCR 클래스를 포함한 후 정보은닉(=>캡슐화)
	//[포함순서-1]

	//2. 생성자
	public TVCR(String company) {//"삼성"
		//[포함순서-2]
	}
	
	//3. 메서드 : //[포함순서-3] 외부에 노출된 버튼의 메서드 호출하여 실질적인 기능을 가진 메서드 실행시킴 
	play
	stop
	
	
	
	showTVCR(){//호출하면 TVCR의 각 멤버변수의 값을 출력
		
	}//만든 나라:한국, 만든 회사:삼성, 전원:true, 현재 채널:5

}









