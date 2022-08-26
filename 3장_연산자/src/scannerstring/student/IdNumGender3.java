package scannerstring.student;

import java.util.Scanner;

public class IdNumGender3 {

	public static void main(String[] args) {

		//[문제]주민등록번호를 입력받아 "당신은 yyyy년 mm일 dd일 '2000년 이전/이후'에 태어난 남성/여성입니다."
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			//index 6의 의미 : 1 3(남성), 2 4(여성)  / 1 2 (2000년이전), 3 4 (2000년이후)
			System.out.print("주민등록번호 입력, (-는 생략,7자리 미만은 종료)"); //0106273
			String socialN = sc.next().trim();
			// 입력 길이 확인
			if (socialN.length() < 7) {
				System.out.println("탈출!");
				break;	//조건이 참일 때 "가장 가까운 반복문"을 빠져 나감
			}
			
			// 입력 번호 분할
			char socialN_G = socialN.charAt(6); // 성별확인
			if (socialN_G != '1' && socialN_G != '2' && socialN_G != '3' && socialN_G != '4') {
				System.out.println("7번째 번호를 확인해주세요");
				continue;	//★아래 실행문을 실행하지 않고 반복문의 제일 처음으로 감(=>건너뛰기)
			}
			
			String socialN_Y = socialN.substring(0, 1+1);// year확인 "01"
			String socialN_M = socialN.substring(2, 3+1);// month 확인 "06"
			
			int socialN_M_Int = Integer.parseInt(socialN_M);
			
			if (socialN_M_Int < 1 || socialN_M_Int > 12) {
				System.out.println("번호를 확인해주세요");
				System.out.println(socialN_M_Int + "월은 없습니다");
				continue;
			}
			
			String socialN_D = socialN.substring(4, 5+1);// day 확인 "27"
			
			if (Integer.parseInt(socialN_D) < 1 || Integer.parseInt(socialN_D) > 31) {
				System.out.println("번호를 확인해주세요");
				System.out.println(Integer.parseInt(socialN_D) + "일은 없습니다");
				continue;
			}
			// 분류 및 결과
			switch (socialN_G) {
			case '1':
				System.out.println("19" + socialN_Y + "년 " + socialN_M + "월 " + socialN_D + "일에 출생한 남성 이십니다.");
				break;
			case '2':
				System.out.println("19" + socialN_Y + "년 " + socialN_M + "월 " + socialN_D + "일에 출생한 여성 이십니다.");
				break;
			case '3':
				System.out.println("20" + socialN_Y + "년 " + socialN_M + "월 " + socialN_D + "일에 출생한 남성 이십니다.");
				break;
			case '4':
				System.out.println("20" + socialN_Y + "년 " + socialN_M + "월 " + socialN_D + "일에 출생한 여성 이십니다.");
				break;
			//default: //생략가능:이유?위에서 if문 이용하여 '1' '2' '3' '4' 이외의 문자 걸러줌
				//System.out.println("번호를 재확인 해주세요.");
				//break;
			}
		}
	}

}
