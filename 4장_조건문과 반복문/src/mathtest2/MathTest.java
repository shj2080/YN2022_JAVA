package mathtest2;

import java.util.Scanner;

public class MathTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String temp;
		
first:	while (true) {
			System.out.println("(1) 제곱");
			System.out.println("(2) 루트");
			System.out.println("(3) 로그");

			System.out.print("원하는 메뉴(1~3)를 선택하세요.(전체종료:stop)>"); // 3
			temp = sc.next().trim();
			
			if( temp.equalsIgnoreCase("stop")) {
				break;
			} else if( !(temp.equals("1") || temp.equals("2") || temp.equals("3")) ) {
				System.out.println("다시 입력해주세요~");
				continue;
			}
			
			int menu = Integer.parseInt(temp);
			
			while (true) {
				System.out.print("계산할 값을 입력하세요.(계산종료:0, 전체종료:stop)>"); // 3
				temp = sc.next().trim();
				
				if(temp.equalsIgnoreCase("stop")) break first; 	//가장 바깥 while문 빠져나감
				
				int num = Integer.parseInt(temp);
				
				if (num == 0) {
					System.out.println("------------ 계산종료 ------------");
					break;
				}

				switch (menu) { // 계산식 분기점
				case 1:
					System.out.println(num + "의 제곱 결과=" + num * num);
					break;
				case 2:
					System.out.println(num + "의 루트 결과=" + Math.sqrt(num));
					break;
				case 3:
					System.out.println(num + "의 로그 결과=" + Math.log(num));
					break;
				default:
					System.out.println("메뉴에 없습니다.");
				}
			} 	//안쪽 while문
		} //바깥 while문
		
		System.out.println("------------ 프로그램 종료 ------------------------");
	}

}
