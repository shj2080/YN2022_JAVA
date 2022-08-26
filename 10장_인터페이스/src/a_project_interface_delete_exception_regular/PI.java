//예외객체 구현 + 정규식 사용 패키지
package a_project_interface_delete_exception_regular;

import java.util.Arrays;

/**
 * PI클래스는 P인터페이스를 구현함.
 * 
 * - 부모는 1개 상속, 인터페이스는 여러 개 구현 가능 - 예제)interfaceex_book 패키지 참조
 * 	(예) public class PI extends A implements P, P2, P3{
 * 		- 부모 A클래스의 멤버는 상속받아 사용(단, 생성자, 초기화블록, private멤버는 상속되지 않는다.)
 * 		  필요시 상속받은 부모의 메서드를 재정의할 수 있다.
 * 
 * 		- P, P2, P3인터페이스의 미완성된 추상메서드는 반드시 재정의해야 함.
 * 		}
 * 
 */

class Person { //이름과 주민등록번호를 가진 고객 클래스 - 같은패키지만 접근 가능(default)
	//private : 고객 정보를 보안하기 위해
	private String name;			//이름 - 
	private String serialNumber;	//주민번호
	
	//생성자가 있으면 컴파일러가 기본생성자를 삽입해주지 않음
	//Person(){}
	Person(String name, String serialNumber) {
		super();
		this.name = name;
		this.serialNumber = serialNumber;
	}

	String getName() {
		return name;
	}

	String getSerialNumber() {
		return serialNumber;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", serialNumber=" + serialNumber + "]";
	}
	
	
}

class Person2 extends Person{ //이름, 주민등록번호, 전화번호를 가진 고객 클래스
	//[멤버변수 추가]
	private String phoneNumber; //전화번호

	//생성자
	Person2(String name, String serialNumber, String phoneNumber) {
		super(name, serialNumber);
		this.phoneNumber = phoneNumber;
	}

	//메서드 추가
	String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public String toString() {
		return "Person2 [name=" + getName() + ", serialNumber=" + getSerialNumber() + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
}

class Person3 extends Person{ //이름, 주민등록번호, 주소를 가진 고객 클래스
	//[멤버변수 추가]
	private String address; //주소
	
	//생성자
	Person3(String name, String serialNumber, String address) {
		super(name, serialNumber);
		this.address = address;
	}

	//메서드 추가
	String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Person3 [name=" + getName() + ", serialNumber=" + getSerialNumber() + ", address=" + address + "]";
	}
	
	
}

class Person4 extends Person{ //이름, 주민등록번호, 전화번호, 주소를 가진 고객 클래스
	//[멤버변수 추가]
	private String phoneNumber; //전화번호
	private String address; 	//주소
	
	//생성자
	Person4(String name, String serialNumber, String phoneNumber, String address) {
		super(name, serialNumber);
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	//메서드 추가
	String getPhoneNumber() {
		return phoneNumber;
	}

	String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Person4 [name=" + getName() + ", serialNumber=" + getSerialNumber() + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}
	
}

public class PI implements P{ //PI : 고객 클래스를 관리하는 '매니저 클래스'(이 클래스만 외부에 알리면 됨)
	//1.멤버변수
	//[포함 관계-1]
	private Person[] p;//[포함관계]로 Person(고객)을 관리하는 "배열"객체 생성
	
	private int storedPersonNum = 0; //배열에 저장된 고객객체 수 + 다음에 저장될 고객객체의 배열의 위치
	
	//2.생성자
	//[포함 관계-2]
	public PI(int personNum) { //personNum : 고객수
		p = new Person[personNum];  	//매개변수 personNum를 이용하여 고객 수 크기의 배열객체 생성
	}
	
	//3.메서드
	@Override
	//public void input() { //[예외 처리 방법-1]
	public void input() throws PersonSizeException{ //[예외 처리 방법-2]
		/*
		if(p.length == storedPersonNum) { //배열의 크기와 배열에 저장된 고객객체 수가 같으면
			System.out.println("\"더 이상 고객 정보를 저장할 공간이 없습니다.~");
			return; //input()메서드 종료
		}
		*/
		
		/**
		 * 예외 처리 방법-1
		 * try {
		 * 	  예외가 발생할 가능성 있는 부분
		 * 	  (예)실행문1;
		 * 		 실행문2; =>1.여기서 예외발생
		 * 	     실행문3; =>이부분 실행안됨★★
		 * }catch(2.예외 객체가 발생하면 예외 객체 잡아서) {
		 * 	  //3.처리
		 * }finally {
		 * 	 //4.try 영역에 진입하면 예외발생유무에 관계없이 무조건 실행
		 * }
		 * 
		 * [예외 처리 방법-2]
		 *  예외발생한 input()를 호출한 메서드(=main())로 던져서 처리
		 */
		
		//[예외 처리 방법-2]
		if(p.length == storedPersonNum) { //배열의 크기와 배열에 저장된 고객객체 수가 같으면
			throw new PersonSizeException();//수동으로 예외객체 생성 후 예외객체 던짐
		}
		
		/*
		//[예외 처리 방법-1]
		try {
			if(p.length == storedPersonNum) { //배열의 크기와 배열에 저장된 고객객체 수가 같으면
				throw new PersonSizeException();//수동으로 예외객체 생성 후 예외객체 던짐
			}
		} catch(PersonSizeException e) { //예외객체 잡아서
			//e.printStackTrace(); //e.getMessage()가 포함되어 '예외메세지 출력' + '예외클래스 종류'와 '예외발생경로'
			
			//System.out.println(e); //'예외클래스 종류' + '예외메세지' 출력
			
			System.out.println(e.getMessage()); //'예외메세지' 출력
			return; //input() 메서드 종료되어 다시 main()메서드 반복문 안의 그 다음 실행문(break;)로 돌아가 계속 프로그램이 실행됨.
		}
		*/
		
		System.out.println("---- 고객 정보 입력을 시작합니다. ----");
		//input() 순서-1 : 데이터 입력
		
		String regExpName = "^[가-힣a-zA-Z]{2,}$"; //한글, 영어 대소문자만 허용(2자리 이상) {2,}
		String name = "";
		
		boolean flag = true;
		while(flag) {
			System.out.print("이름을 입력하세요 > ");
			//nextLine() : 엔터까지 읽어들인 후 엔터를 버리고 나머지 문자들로 문자열 객체를 만듦
			name = MenuViewer.sc.nextLine().trim();//지역변수
			
			if(name.matches(regExpName)==true) {				
				flag = false;
			} else {
				System.out.println("잘못된 이름을 입력하셨습니다.");
				continue;
			}
		}
		
		/** 아래 내용에 대한 코드는 생략함=> 정규식으로 처리 ****************************
		 * 주민번호길이 확인 : 주민번호 앞자리(6자리)-주민번호 뒷자리(7자리)
		 * 주민번호 앞자리, 주민번호 뒷자리 모두 정수로 변환되는 지 여부 확인
		 * 주민번호 뒷자리의 시작번호가 1 2 3 4로 시작하는지의 여부 확인
		 *****************************************************/
		
		/** 주민등록번호 정규식 참고자료:https://jamesdreaming.tistory.com/200
		 * 예) 123456 - 1234567
		 * 	1. 첫 6자리 : 12 (출생년도)
		 * 				34 (출생 월)
		 * 				56 (출생 일)
		 *     뒤 7자리 : 1 (1:남자, 2:여자, 3:2000년 이후 출생한 남자, 4:2000년 이후 출생한 여자)
		 *     			2345 (지역코드)
		 *     			6(출생신고지 기준 접수 순번
		 *     			7(검증번호=앞 12자리 숫자를 특정 공식에 대입 시 딱 하나의 숫자만 나올 수 있음)
		 *     
		 * <아래 정규식 의미>
		 * ^\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|[3][01])\\-[1-4][0-9]{6}$
		 * 
		 * ^ 시작
		 * 
		 * ^\\d{2} = ^[0-9]{2}  		(예)출생년도 ^00~99 로 시작
		 * (0[1-9]|1[0-2])				(예)출생 월 01~09 또는 10~12
		 * (0[1-9]|[12][0-9]|[3][01])	(예)출생 일 01~09 또는 10~19, 20~29 또는 30,31
		 * 
		 * \\-							(예)"-" 구분자
		 * [1-4][0-9]{6}				(예)첫자리는 1~4 중 하나, 나머지 6자리는 0~9사이 수
		 * 
		 * $ 종료
		 */
		String regExpSerialNumber = "^\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|[3][01])\\-[1-4][0-9]{6}$";
		String serialNumber = "";
		
		flag = true;
		while(flag) {
			System.out.print("주민등록번호를 입력하세요(-포함) > ");
			serialNumber = MenuViewer.sc.nextLine().trim();//지역변수
			
			if(serialNumber.matches(regExpSerialNumber)) {		//matches 리턴(boolean) : true, false		
				flag = false;
			} else {
				System.out.println("잘못된 주민등록번호를 입력하셨습니다.");
				continue;
			}
		}
		
		
		//중복된 주민등록번호가 있으면 입력을 다시 하기
		//[방법-1] : 1번만 더 주민등록번호 입력가능
		/*
		for(Person person:p) {				//배열 길이만큼 반복
			
			if(person.getSerialNumber().equals(serialNumber)) {	//객체가 들어가지 않은 null 참조할 경우 예외 발생함
				System.out.println("중복된 주민등록번호가 있습니다. 다시 입력해주세요 > ");
				serialNumber = MenuViewer.sc.next().trim(); //지역변수
				break;
			}
		}
		*/
		
		//[방법-2] : 여러 번 주민등록번호 입력가능 - 중첩된 반복문
		for(int index = 0 ; index < storedPersonNum; index++) { 	//고객 정보 검색
			
			//while(serialNumber.equals(p[index].getSerialNumber())) {
			while(p[index].getSerialNumber().equals(serialNumber)) {			//중복된 주민등록번호 발견시
				System.out.println("=== 중복된 주민등록번호가 있습니다. 다시 입력해주세요 === ");
				//serialNumber = MenuViewer.sc.nextLine().trim(); //지역변수
				
				
				flag = true;
				while(flag) {
					System.out.print("주민등록번호를 입력하세요(-포함) > ");
					serialNumber = MenuViewer.sc.nextLine().trim();//지역변수
					
					if(serialNumber.matches(regExpSerialNumber)) {		//matches 리턴(boolean) : true, false		
						flag = false;
					} else {
						System.out.println("잘못된 주민등록번호를 입력하셨습니다.");
						continue;
					}
				} //주민등록번호 정규식에 맞는지 확인하는 안쪽 while문 끝
				
				index = 0; //★★다시 입력받은 주민번호와 배열의 처음 저장된 고객의 정보를 비교하기 위해서 (입력된 주민번호와 배열 내 고객 주민번호 재비교)
				
			}//바깥 while문 끝
			
		}//for문 끝
		
		//System.out.print("전화번호를 입력하세요(전화번호가 없으면 0입력) > ");

		String regExpPhoneNumber = "^\\d{3}-\\d{3,4}-\\d{4}$";  // \d 숫자[0-9]와 동일, \D:숫자를 제외한 모든 문자
		String phoneNumber = "";
		
		flag = true;
		while(flag) {
			System.out.print("전화번호를 입력하세요(전화번호가 없으면 그냥 엔터) > ");
			phoneNumber = MenuViewer.sc.nextLine().trim(); //지역변수
			
			if(phoneNumber.matches(regExpPhoneNumber) || phoneNumber.equals("")) {		//matches 리턴(boolean) : true, false		
				flag = false;
			} else {
				System.out.println("잘못된 전화번호를 입력하셨습니다.");
				continue;
			}
		}
		
		//MenuViewer.sc.nextLine(); //★★버퍼의 제일 앞에 있는 엔터 처리
		
		//System.out.print("주소를 입력하세요(주소가 없으면 \"없음\"입력) > ");
		System.out.print("주소를 입력하세요(주소가 없으면 그냥 엔터) > ");
		//nextLine() : 엔터("\n")까지 읽어들인 후 엔터를 버리고 나머지 문자들로 문자열 객체를 만듦
		String address = MenuViewer.sc.nextLine().trim(); //지역변수 - next()는 공백, "\n"을 만나면 끝남 (공백을 포함하여 입력받으려면 nextLine 사용)
		
		/*
		//input() 순서-2 : 입력받은 데이터로 고객객체 생성 -> 생성된 고객객체를 배열 저장
		if(phoneNumber.equals("0") && address.equals("없음")) {				//전화번호와 주소가 없는 경우
			p[storedPersonNum++] = new Person(name, serialNumber);
		}else if(!phoneNumber.equals("0") && address.equals("없음")) {		//주소만 없는 경우
			p[storedPersonNum++] = new Person2(name, serialNumber, phoneNumber);
		}else if(phoneNumber.equals("0") && !address.equals("없음")) {		//전화번호만 없는 경우
			p[storedPersonNum++] = new Person3(name, serialNumber, address);
		}else {																//그 외 (전화번호와 주소가 모두 있는 경우)
			p[storedPersonNum++] = new Person4(name, serialNumber, phoneNumber, address);
		}
		*/
		
		addPerson(name, serialNumber, phoneNumber, address); //객체 생성-저장 과정을 별도의 메서드에 담음
	}

	private void addPerson(String name, String serialNumber, String phoneNumber, String address) {
		//input() 순서-2 : 입력받은 데이터로 고객객체 생성 -> 생성된 고객객체를 배열 저장
		/*
		if(phoneNumber.equals("0") && address.equals("없음")) {				//전화번호와 주소가 없는 경우
			p[storedPersonNum++] = new Person(name, serialNumber);
		}else if(!phoneNumber.equals("0") && address.equals("없음")) {		//주소만 없는 경우
			p[storedPersonNum++] = new Person2(name, serialNumber, phoneNumber);
		}else if(phoneNumber.equals("0") && !address.equals("없음")) {		//전화번호만 없는 경우
			p[storedPersonNum++] = new Person3(name, serialNumber, address);
		}else {																//그 외 (전화번호와 주소가 모두 있는 경우)
			p[storedPersonNum++] = new Person4(name, serialNumber, phoneNumber, address);
		}
		*/
		if(phoneNumber.equals("") && address.equals("")) {				//전화번호와 주소가 없는 경우
			p[storedPersonNum++] = new Person(name, serialNumber);
		}else if(!phoneNumber.equals("") && address.equals("")) {		//주소만 없는 경우
			p[storedPersonNum++] = new Person2(name, serialNumber, phoneNumber);
		}else if(phoneNumber.equals("") && !address.equals("")) {		//전화번호만 없는 경우
			p[storedPersonNum++] = new Person3(name, serialNumber, address);
		}else {																//그 외 (전화번호와 주소가 모두 있는 경우)
			p[storedPersonNum++] = new Person4(name, serialNumber, phoneNumber, address);
		}
	}
	/**
	 * 메서드 오버로딩 : 메서드명은 같아도 된다. 단 매개변수의 수나 타입은 달라야 한다.
	 */
	
	@Override
	public void search() { 	//외부에 노출된 메서드(주민등록번호를 입력받아 고객의 정보를 출력)
		if(storedPersonNum == 0) {
			System.out.println("등록된 고객 정보가 없어 검색할 수 없습니다.");
			return; //search 메서드 종료
		}

		System.out.println("---- 고객 정보 검색을 시작합니다. ----");
		
		System.out.print("주민등록번호를 입력하세요 > ");
		String serialNumber = MenuViewer.sc.nextLine().trim(); //지역변수
		
		String personInfo = search(serialNumber);
		
		if(personInfo != null) { //주민등록번호를 찾은 경우
			show(); //[고객 정보 출력] 재정의 내용 출력
			System.out.println(personInfo); //personInfo.toString()
		}else //주민등록번호를 찾지 못한 경우
			System.out.println("입력한 주민등록번호에 해당하는 고객은 없습니다."); 
	} 
	
	//주민등록번호를 매개값으로 받아 배열에서 찾은 그 고객의 정보를 리턴 - 실제 검색을 하는 메서드(외부에 보이지 않도록 숨겨짐)
	private String search(String serialNumber) {	//사용자가 입력한 주민등록번호
		for(Person person:p) { //person:배열에 저장된 값(=고객객체의 주소)
			
			if(person == null) //★★검색 시 향상된 for문 사용 중 null을 만난 경우 종료 (예외발생 방지)
				return null; //고객정보 찾지 못함.
			
			String personInfo = ""; //주의 : null아님 (빈 문자열 객체 생성)
			
			if(serialNumber.equals(person.getSerialNumber())) { //일치하는 주민등록번호 발견 시
				personInfo += "고객의 이름 : " + person.getName(); //문자열 연결된 객체로 대입 - 고객 이름은 무조건 출력
				
				if(person instanceof Person2) { 	//Person 의 자식 Person2,3,4 는 동등한 관계이므로 아무거나
					personInfo += ", 전화번호 : " + ((Person2)person).getPhoneNumber(); //강제 형변환 (Person->Person2)
				}else if(person instanceof Person3) {
					personInfo += ", 주소 : " + ((Person3)person).getAddress(); //강제 형변환 (Person->Person3)
				}else if(person instanceof Person4){
					personInfo += ", 전화번호 : " + ((Person4)person).getPhoneNumber();
					personInfo += ", 주소 : " + ((Person4)person).getAddress();
				}/* else if(person instanceof Person) {} */
				
				return personInfo; //return 만나면 메서드 종료되어 더 이상 반복문 실행안함
			} //if문(주민등록번호 검사) 끝
			
		}//for문 끝 = 반복문으로 찾아도 같은 주민번호가 없으면
		
		return null; //고객 정보를 찾지 못한 경우 null 리턴(반복문으로 검색했으나 같은 주민등록번호 찾지 못 함)
	}

	@Override
	public void delete() { // ★★[08/12 과제]삭제 메서드 구현 - 향상된 for문 사용 불가. index필요
		//삭제된 공간을 메우기 위해 뒤의 고객객체들을 앞으로 당김 (주의:삭제 후 storedPersonNum 감소해야 함)
		if(storedPersonNum == 0) {
			System.out.println("등록된 고객 정보가 없어 삭제할 수 없습니다.");
			return; //delete 메서드 종료
		}else showAllPersonInfo();
		
		System.out.println("---- 고객 정보 삭제를 시작합니다. ----");
		//delete() 순서-1 : 주민등록번호 입력
		System.out.print("삭제할 고객님의 주민등록번호를 입력해주세요 > ");
		String serialNumber = MenuViewer.sc.nextLine();
		
		
		//delete() 순서-2 : private 리턴타입 delete(주민등록번호) - 실질적인 삭제 작업을 담당하는 메서드
		
		//delete() 순서-3 : 리턴값을 받아서 찾는 고객이 있으면 "삭제완료"
		//									  없으면 "삭제안됨" 출력
		if(delete(serialNumber)) {
			System.out.println("고객님의 정보가 삭제되었습니다.");
		}else System.out.println("입력하신 주민등록번호에 해당하는 고객님을 찾을 수 없습니다.");
	}
	
	
	private boolean delete(String serialNumber) { //실질적인 삭제를 담당하는 메서드
		//향상된 for문 사용불가능(이유?index로 접근하여 값을 변경시켜야 하므로...)
		for(int i = 0; i < storedPersonNum; i++) {
			if(serialNumber.equals(p[i].getSerialNumber())) { //p[i]에 저장된 주민등록번호와 일치한다면(해당 고객을 찾으면)
				System.out.println("삭제할 고객 정보 : " + p[i]); //p[i].toString()
				
				/* ★
				 * int currentIndex = i (시작위치 중요)
				 * currentIndex <= storedPersonNum-1 (=>권장함)  = (currentIndex < storedPersonNum)
				 * => (가장 마지막 배열값은 null로 채워져 다음에 삭제 시
				 * 		"삭제할 고객 정보 : .."가 출력될 때 삭제된 고객정보는 출력안됨
				 * 
				 * currentIndex < storedPersonNum - 1		=  (currentIndex <= storedPersonNum - 2)
				 * =>(가장 마지막 배열값은 바로 앞과 같은 값으로 채워져? 다음에 삭제 시
				 * 		"삭제할 고객 정보 : .."가 출력될 때 삭제된 고객정보도 함께 출력됨(앞으로 객체들을 당겼으나 마지막 index를 null로 만들지 않음)
				 */
				for(int currentIndex = i; currentIndex <= storedPersonNum - 1; currentIndex++) { //주민번호가 일치한 인덱스부터 저장된 고객정보 마지막index(길이-1) 까지 반복
					//찾은 고객이 배열의 가장 마지막 index(위치)에 있다면 (currentIndex == storedPersonNum - 1)
					if(currentIndex == p.length-1) {
						p[currentIndex] = null;
					}else { //그렇지 않으면 배열 뒤의 값을 앞으로 이동
						p[currentIndex] = p[currentIndex + 1];
					}
				}
				storedPersonNum--; //삭제 후 저장된 고객정보 길이 감소 (감소시키지 않으면 null참조 예외 발생) 
				return true;  //삭제성공
			}
		}//바깥 for문 끝
		
		return false; //삭제실패
	}
	
	
	private void showAllPersonInfo() {
		System.out.println("---------------[고객 정보 List]--------------------------------");
		
		//[방법-1]
		System.out.println(Arrays.toString(p));
		
		//[방법-2]
		for(Person person:p) {   //주의 : 배열 길이만큼 반복
			System.out.println(person); //person.toString()
		}
		System.out.println("------------------------------------------------------------");
	}
	
	/*************************인터페이스 문법적 설명위해 아래 코드 추가*******************************/
	@Override
	public void show() {
		//P.super.show();	//"[정보 출력]"   - 인터페이스명.super.show(); 인터페이스는 객체생성 안되므로
		System.out.println("**************** [고객 정보 출력] *****************");
		
	}

	
	
}
