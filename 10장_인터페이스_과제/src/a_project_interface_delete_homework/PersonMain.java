/**
 * 홍대표는 기다리지 않고 프로젝트를 수행해나간다.
 */
package a_project_interface_delete_homework;

//import java.util.Scanner;

public class PersonMain {

	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		
		//MenuViewer menuViewer = new MenuViewer();
		
		System.out.print("저장할 고객 수 > ");
		//int personNum = menuViewer.sc.nextInt(); //생성된 객체이름으로 접근(static이 없는 경우)
		int personNum = MenuViewer.sc.nextInt();   //클래스이름으로 접근(static이 있는 경우)
		MenuViewer.sc.nextLine(); //★★버퍼의 제일 앞에 있는 엔터 처리(다음 입력을 받을 때 nextLine을 쓸 경우 그 전에 처리)
		
		/* 홍대표는 a회사에서 알려준 '매니저 클래스'만 알면 된다.
		 * 
		 * 부모 인터페이스 = 구현한 자손클래스객체
		 * '매니저 클래스'로 객체 생성하고 인터페이스 P로 대입받음
		 * (PI객체가 자동으로 P타입으로 형변환되어 받아들임) - UpCasting
		 */
		P p = new PI(personNum);
		
		boolean flag = true;
		while(flag) {
			MenuViewer.showMenu();
			/* [showMenu() 호출시 출력결과]
			System.out.println("선택하세요...");
			System.out.println("1. 고객 데이터 [입력]");
			System.out.println("2. 주민등록번호로 이름과 전화번호 또는 주소 [검색]");
			System.out.println("3. 주민등록번호로 고객정보 [삭제]");
			System.out.println("4. 프로그램 [종료]");
			
			System.out.print("선택(1~4 사이 정수 입력) > ");
			 */
			try { //try{예외발생 가능성 있는 부분}
				//"1" "2" "3" "4"(O) /  "1~4이외의 정수"(O) / "1.23", "ㅁ"(X):NumberFormatException
				String temp = MenuViewer.sc.nextLine();  //"달서구"
				int choice = Integer.parseInt(temp);
				
				switch(choice) {
					case P.INPUT:
						p.input();
						break;
					case P.SEARCH:
						p.search();
						break;
					case P.DELETE:
						p.delete();
						break;
					case P.EXIT:
						System.out.println("프로그램을 종료합니다.");
						flag = false;
						return;  //[방법-1] 해당메서드(=main()) 종료 -> 프로그램 종료(main메서드가 종료된 경우)
						//System.exit(0); //[방법-2] 시스템 종료 : 어느 메서드에 존재하는지 관계없이 프로그램 종료
					default: //1~4이외의 정수
						System.out.println("1~4사이의 정수를 입력해주세요.");
						//break;
				}
			} catch(NumberFormatException e) { //예외 잡아서
				 System.out.println("잘못된 값을 입력하셨습니다. 1~4사이의 정수를 입력해주세요.");//처리
			} finally { //예외발생유무에 관계없이 반드시 실행
				System.out.println("고객님~ 복 많이 받으세요~~^^ \n");
			} //try~catch~finally의 끝
		}//while의 끝		
		
	}//main() 끝

}//class 끝
