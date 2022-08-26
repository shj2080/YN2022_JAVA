package a_project_interface_test;

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
}

public class PI implements P{ //PI : 고객 클래스를 관리하는 '매니저 클래스'(이 클래스만 외부에 알리면 됨)
	//1.멤버변수
	//[포함 관계-1]
	private Person[] p;//[포함관계]로 Person(고객)을 관리하는 "배열"객체 생성
	
	int storedPersonNum = 0; //배열에 저장된 고객객체 수 + 다음에 저장될 고객객체의 배열의 위치
	
	//2.생성자
	//[포함 관계-2]
	public PI(int personNum) { //personNum : 고객수
		p = new Person[personNum];  	//매개변수 personNum를 이용하여 고객 수 크기의 배열객체 생성
	}
	
	//3.메서드
	@Override
	public void input() {
		if(p.length == storedPersonNum) {
			System.out.println("고객 정보를 저장할 공간이 없습니다.");
			return; //메서드 종료
		}
		
		System.out.print("이름을 입력해주세요 > ");
		String name = MenuViewer.sc.nextLine();
		
		System.out.print("주민등록번호를 입력해주세요 > ");
		String serialNumber = MenuViewer.sc.nextLine();
		
		//주민등록번호 중복 검사
		for(int index = 0; index < storedPersonNum; index++) {
			while(p[index].getSerialNumber().equals(serialNumber)) {
				System.out.print("중복된 주민등록번호 입니다. 다시 입력하세요 > ");
				serialNumber = MenuViewer.sc.nextLine();
				
				index = 0; //다시 처음부터 비교
			}
		}
		
		System.out.print("전화번호를 입력해주세요(전화번호가 없으면 0입력) > ");
		String phoneNumber = MenuViewer.sc.nextLine();
		
		System.out.print("주소를 입력해주세요(주소가 없으면 \"없음\"입력) > ");
		String address = MenuViewer.sc.nextLine();
		
		addPerson(name, serialNumber, phoneNumber, address);
	}

	private void addPerson(String name, String serialNumber, String phoneNumber, String address) { //객체 생성,저장하는 메서드
		if(phoneNumber.equals("0") && address.equals("없음")) {
			p[storedPersonNum++] = new Person(name, serialNumber);
		}else if(!phoneNumber.equals("0") && address.equals("없음")) { //주소 없는 경우
			p[storedPersonNum++] = new Person2(name, serialNumber, phoneNumber);
		}else if(phoneNumber.equals("0") && !address.equals("없음")) { //전화번호 없는 경우
			p[storedPersonNum++] = new Person3(name, serialNumber, address);
		}else {
			p[storedPersonNum++] = new Person4(name, serialNumber, phoneNumber, address);
		}
	}
	
	@Override
	public void search() {
		System.out.print("주민등록번호를 입력해주세요 > ");
		String serialNumber = MenuViewer.sc.nextLine();
		
		String personInfo = search(serialNumber); // 고객 정보 검색 후 personInfo에 담음
		
		if(personInfo != null) { //고객 정보를 찾았다면(null이 아니라면)
			show();
			System.out.println(personInfo);
		}else System.out.println("고객 정보를 찾지 못했습니다.");
	} 
	
	//주민등록번호를 매개값으로 받아 배열에서 찾은 그 고객의 정보를 리턴 - 실제 검색을 하는 메서드(외부에 보이지 않도록 숨겨짐)
	private String search(String serialNumber) { 
		String personInfo = ""; //출력 문자열 담을 문자열 객체
		
		for(int i = 0; i < storedPersonNum; i++) {
			if(p[i].getSerialNumber().equals(serialNumber)) {
				personInfo += "고객의 이름 : " + p[i].getName();
				
				if(p[i] instanceof Person2) {
					personInfo += ", 전화번호 : " + ((Person2)p[i]).getPhoneNumber();
				}else if(p[i] instanceof Person3) {
					personInfo += ", 주소 : " + ((Person3)p[i]).getAddress();
				}else if(p[i] instanceof Person4) {
					personInfo += ", 전화번호 : " + ((Person2)p[i]).getPhoneNumber();
					personInfo += ", 주소 : " + ((Person3)p[i]).getAddress();
				}
				
				return personInfo;
			}
		}
		
		return null;  // 고객정보 못 찾은 경우
	}

	
	/*************************인터페이스 문법적 설명위해 아래 코드 추가*******************************/
	@Override
	public void show() {
		//P.super.show();	//"[정보 출력]"   - 인터페이스명.super.show(); 인터페이스는 객체생성 안되므로
		System.out.println("**************** [고객 정보 출력] *****************");
		
	}
	
}
