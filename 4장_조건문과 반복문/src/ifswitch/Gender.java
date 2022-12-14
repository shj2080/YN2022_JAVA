package ifswitch;

import java.util.Scanner;

public class Gender {

	public static void main(String[] args) {
		//[문제]주민등록번호를 입력받아 "당신은 '2000년 이전/이후'에 태어난 남성/여성입니다."
		Scanner sc = new Scanner(System.in); //한번만 생성하여 사용
		
		while(true) {
			System.out.print("주민등록번호 입력(예:010627-3******) 단 stop 입력 시 멈춤> ");
			String idNum = sc.nextLine(); //"Stop"
			if(idNum.equalsIgnoreCase("stop")) break; //가장 가까운 반복문을 빠져 나감
			
			//입력받은 주민등록번호 중 index 7에 해당하는 문자 1개 추출
			char gender = idNum.charAt(7);
			
			switch(gender) {
			case '1':
			case '3': switch(gender) {
						case '1':
							System.out.print("2000년 이전에 출생한 ");
							break;	//안쪽 switch문 빠져나감
						case '3':
							System.out.print("2000년 이후에 출생한 ");
							//break;	생략가능
						} // 1-안 switch문 끝
				System.out.println("남성입니다.");
				break;
			case '2':
			case '4': switch(gender) {
						case '2':
							System.out.print("2000년 이전에 출생한 ");
							break;	//안쪽 switch문 빠져나감
						case '4':
							System.out.print("2000년 이후에 출생한 ");
							//break;	생략가능
						} // 2-안 switch문 끝
				System.out.println("여성입니다.");
				break;
			default:
				System.out.println("잘못된 주민등록번호입니다.");
				//break;		//생략가능
			}//밖 switch문 끝
		} //while문 끝
		
		System.out.println("------주민등록번호 판별 끝------");
	}

}
