package a_project_interface_homework;

/**
 * PI클래스는 P인터페이스를 구현함.
 * 
 * - 부모는 1개 상속, 인터페이스는 여러 개 구현 가능
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
	
	private int personCnt; //고객 정보가 저장될 인덱스 - PI객체 생성될 때 기본값인 0으로 초기화됨.
	
	//2.생성자
	//[포함 관계-2]
	public PI(int personNum) { //personNum : 고객수
		p = new Person[personNum];  	//매개변수 personNum를 이용하여 고객 수 크기의 배열객체 생성
	}
	
	//3.메서드
	@Override
	public void input() {
		if(personCnt > p.length-1) { 	//저장공간이 꽉 찬 경우(배열공간 모두 사용)
			System.out.println("더 이상 고객 정보를 저장할 공간이 없습니다.~");
			return; //input()메서드 종료
		}
		
		System.out.print("이름을 입력하세요 > ");
		String personName = MenuViewer.sc.next().trim();
		
		System.out.print("주민등록번호를 입력하세요 > ");
		String serialNumber = MenuViewer.sc.next().trim();
		
		System.out.print("전화번호를 입력하세요(전화번호가 없으면 0입력) > ");
		String phoneNumber = MenuViewer.sc.next().trim();
		
		MenuViewer.sc.nextLine(); //주소 입력 전에 버퍼 정리
		
		System.out.print("주소를 입력하세요(주소가 없으면 \"없음\"입력) > ");
		String address = MenuViewer.sc.nextLine().trim(); 	//주소 처리 시 nextLine()
		
		if(phoneNumber.equals("0") && address.equals("없음")) {
			p[personCnt] = new Person(personName, serialNumber);
		}
		else if(address.equals("없음")) {
			p[personCnt] = new Person2(personName, serialNumber, phoneNumber);
		}
		else if(phoneNumber.equals("0")) {
			p[personCnt] = new Person3(personName, serialNumber, address);
		}
		else {
			p[personCnt] = new Person4(personName, serialNumber, phoneNumber, address);
		}
		personCnt++; //다음 배열index에 고객정보를 저장하기 위해 증가 (순차적 저장)
	}

	@Override
	public void search() {
		
		if(personCnt == 0) { //저장을 전혀 하지 않은 경우
			System.out.println("저장된 고객 정보가 없습니다!");
			return;  //검색 메서드 종료
		}
		
		System.out.print("주민등록번호를 입력하세요 > ");
		String serialNumber = MenuViewer.sc.next().trim();
		
		for(Person person:p) {	//p 배열객체 검색
			if(person == null) //고객정보가 생성되지 않은 곳에 접근한 경우 반복문 종료
				break;
			
			if(person.getSerialNumber().equals(serialNumber)) {	//일치하는 주민등록번호가 있다면
				System.out.println("************ [고객 정보 출력] *************");
				if(person instanceof Person4) {
					Person4 p4 = (Person4)person;
					System.out.println("고객의 이름:" + p4.getName() + ", 전화번호:" + p4.getPhoneNumber() + ", 주소:" + p4.getAddress());
					break; //고객 정보를 찾아 출력했으므로 반복문 종료
				}else if(person instanceof Person3) {
					Person3 p3 = (Person3)person;
					System.out.println("고객의 이름:" + p3.getName() + ", 주소:" + p3.getAddress());
					break; //고객 정보를 찾아 출력했으므로 반복문 종료
				}else if(person instanceof Person2) {
					Person2 p2 = (Person2)person;
					System.out.println("고객의 이름:" + p2.getName() + ", 전화번호:" + p2.getPhoneNumber());
					break; //고객 정보를 찾아 출력했으므로 반복문 종료
				}else {
					System.out.println("고객의 이름:" + person.getName());
					break; //고객 정보를 찾아 출력했으므로 반복문 종료
				}
			}
				
		}
		//고객의 이름:홍, 전화번호:010-1111-1111, 주소:
	} 
	
}
