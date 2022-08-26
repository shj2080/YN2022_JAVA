/**
 * 홍대표는 기다리지 않고 프로젝트를 수행해나간다.
 */
package a_project_interface_delete_exception_regular;

//import java.util.Scanner;

public class PersonMain {
	//[예외 처리 방법-2] : JVM에게 예외를 처리하도록 던지면 e.printStackTrace(); 호출한 결과로 처리 후 "프로그램 종료"
	public static void main(String[] args) throws PersonSizeException{ //[예외 처리 방법-2]
	//public static void main(String[] args) { //[예외 처리 방법-1]
		//Scanner sc = new Scanner(System.in);
		
		//MenuViewer menuViewer = new MenuViewer();
		
		System.out.print("저장할 고객 수 > ");
		//int personNum = menuViewer.sc.nextInt(); //					생성된 객체이름으로 접근(static이 없는 경우)
		int personNum = MenuViewer.sc.nextInt();   //"엔터"				클래스이름으로 접근(static이 있는 경우)
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
				String temp = MenuViewer.sc.nextLine();  //엔터
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
			} /* [방법-1]
				catch(NumberFormatException | PersonSizeException e) { //예외 잡아서
				 //e.printStackTrace(); 
				if(e instanceof NumberFormatException) {
					System.out.println("잘못된 값을 입력하셨습니다. 1~4 사이의 정수를 입력해주세요~^^");
				}else if(e instanceof PersonSizeException) {
					System.out.println(e.getMessage()); // '예외 메세지' 출력
				}
				
				//continue;    //유무 관계 없이 finally는 무조건 실행 (예외 발생 시 continue)
				
			}*/
			
			//[방법-2]
			catch (NumberFormatException e) { //가장 마지막 자식예외부터 
				System.out.println("잘못된 값을 입력하셨습니다. 1~4 사이의 정수를 입력해주세요~^^");
				continue;    //유무 관계 없이 finally는 무조건 실행 (예외 발생 시 continue)
			}
			
			catch (PersonSizeException e) {
				System.out.println(e.getMessage()); // '예외 메세지' 출력
				continue;  //유무 관계 없이 finally는 무조건 실행
			}
			
			catch(Exception e) { //NumberFormatException, PersonSizeException 이외의 예외 잡아서
				//e.printStackTrace();
				System.out.println(e); //'예외 클래스 종류' + '예외 메세지' 출력
			}
			
			finally { //try영역에 진입하면 예외발생유무에 관계없이 반드시 실행
				System.out.println("고객님~ 복 많이 받으세요~~^^ \n");
			} //try~catch~finally의 끝
			
			System.out.println("♥♥♥");
			//continue;실행되면 이 부분("♥♥♥") 건너띄고 다시 반복문의 처음으로
			//continue;실행안되면 이 부분("♥♥♥") 실행 후 다시 반복문의 처음으로
			
		}//while의 끝		
		
	}//main() 끝

}//class 끝
