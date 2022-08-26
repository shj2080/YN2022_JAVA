package mathtest;

import java.util.Scanner;

public class MathTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

		System.out.println("(1) 제곱");
		System.out.println("(2) 루트");
		System.out.println("(3) 로그");
		
		System.out.print("원하는 메뉴(1~3)를 선택하세요.>"); //2
		int menu = sc.nextInt();
		
		while(true) {
			System.out.print("계산할 값을 입력하세요.(계산종료:0)>"); //3
			int num = sc.nextInt();
			
			if(num == 0) {
				System.out.println("--- 계산종료 ---");
				break;
			}
			
			switch(menu) {
				case 1 :
					System.out.println(num+"의 제곱 결과=" + num * num);
					break;
				case 2 :
					System.out.println(num+"의 루트 결과=" + Math.sqrt(num));
					break;
				case 3 :
					System.out.println(num+"의 로그 결과=" + Math.log(num));
					break;
				default :
					System.out.println("메뉴에 없습니다.");
			}
		}
		
		sc.close();
	}

}
