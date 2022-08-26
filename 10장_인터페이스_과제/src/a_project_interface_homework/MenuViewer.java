package a_project_interface_homework;

import java.util.Scanner;
//멤버변수와 메서드가 static이면 생성자를 private으로 하여 객체생성불가하도록 만드는 것이 좋다.
public class MenuViewer {
	//멤버변수
	public static Scanner sc = new Scanner(System.in);
	
	private MenuViewer() {} //전부 static이므로 객체 생성할 필요 없음.
	
	//메서드
	public static void showMenu() {
		System.out.println("선택하세요...");
		System.out.println("1. 고객 데이터 [입력]");
		System.out.println("2. 주민등록번호로 이름과 전화번호 또는 주소 [검색]");
		System.out.println("3. 프로그램 [종료]");
		
		System.out.print("선택(1~3 사이 정수 입력) > ");
	}
}
