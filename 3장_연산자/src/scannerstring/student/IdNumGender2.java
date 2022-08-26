package scannerstring.student;

import java.util.Scanner;

public class IdNumGender2 {

	public static void main(String[] args) {
		//[문제]주민등록번호를 입력받아 "당신은 yyyy년 mm일 dd일 '2000년 이전/이후'에 태어난 남성/여성입니다."
		System.out.println("---------------------------------");

		Scanner sc = new Scanner(System.in);
		System.out.println("[숙제-2] 주민등록번호 판별");
		System.out.println();

		for (int k = 1; k <= 5; k++) {// 확인용으로 5회 반복
			System.out.println("주민등록번호 입력(예: 011111-3234567) > ");// 숫자아님
			String idNum = sc.next();//구분자 앞까지 입력받아 String 객체 생성
			idNum = idNum.trim(); //앞뒤 공백 제거 한 String 객체 생성
			
			//index 7의 의미 : 1 3(남성), 2 4(여성)  / 1 2 (2000년이전), 3 4 (2000년이후)
			String idNum1 = idNum.substring(7, 7+1); //"3"
			//int iN = Integer.parseInt(idNum1); //"3"-> 3
			
			// 뒷자리 첫번째 자리를 정수로 변환
			String yy = idNum.substring(0, 1+1); // 년도는 00~99 이므로 문자로 바로 대입해도 문제 없음
			
			String mm = idNum.substring(2, 3+1);
			int mm1 = Integer.parseInt(mm);
			
			// 12월까지 13이상의 정수 오기입 표시를 위해 정수 변환. if문에서 비교하기위해
			String dd = idNum.substring(4, 5+1);
			int dd1 = Integer.parseInt(dd);
			
			// 월과 마찬가지로 31일 초과한 날짜 오기입 파악을 위해 정수변환

			if (mm1 > 12 || dd1 > 31) { //월, 일
				System.out.println("월과 일을 잘못 입력하셨습니다.");
				
			} else if (mm1 != 2 && (dd1 > 31)) { //2월 이외
				System.out.println("일을 잘못 입력하셨습니다.");
			}
			  else if (mm1 == 2 && (dd1 > 29)) {		//2월일 때
				System.out.println("잘못 입력하셨습니다. 2월달은 28일 또는 29일 입니다.");
				
			} else if (idNum1.equals("1")) { //else if (iN == 1) { 	//비교연산자
				System.out.println("\"당신은 " + "19" + yy + "년 " + mm + "월 " + dd + "일 '2000년 이전'에 태어난 남성입니다.");
				
			} else if (idNum1.equals("2")) { //else if (iN == 2) {
				System.out.println("\"당신은 " + "19" + yy + "년 " + mm + "월 " + dd + "일 '2000년 이전'에 태어난 여성입니다.");
				
			} else if (idNum1.equals("3")) { //else if (iN == 3) {
				System.out.println();
				System.out.println("\"당신은 " + "20" + yy + "년 " + mm + "월 " + dd + "일 '2000년 이후'에 태어난 남성입니다.");
				
			} else if (idNum1.equals("4")) { //else if (iN == 4) {
				System.out.println("\"당신은 " + "20" + yy + "년 " + mm + "월 " + dd + "일 '2000년 이후'에 태어난 여성입니다.");
				
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
			
			System.out.println();		//무조건 실행
		} // for문의 끝
	}

}
