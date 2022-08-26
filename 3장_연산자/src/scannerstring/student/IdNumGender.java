package scannerstring.student;

import java.util.Scanner;

public class IdNumGender {

	public static void main(String[] args) {
		// [과제-2]
		// [문제]주민등록번호를 입력받아 "당신은 yyyy년 mm일 dd일 '2000년 이전/이후'에 태어난 남성/여성입니다."

		Scanner sc = new Scanner(System.in);
		System.out.print("주민등록번호 입력(예 : 010622-1234567) > ");
		
		//String idNum = sc.nextLine().trim();		//엔터까지 읽어들인 후 엔터를 버리고 나머지 문자들로 String객체 생성
		String idNum = sc.next();
		String[] idNumSplit = idNum.split("-");

		String idNum_first = idNumSplit[0]; // 주민등록번호 앞자리
		String idNum_last = idNumSplit[1]; // 주민등록번호 뒷자리

		String birthMonth = idNum_first.substring(2, 3 + 1); // 태어난 월
		String birthDay = idNum_first.substring(4, 5 + 1); // 태어난 일자

		int gender = Integer.parseInt(idNum_last.substring(0, 0 + 1)); // 1, 2 :19YY년 남,녀 - 3, 4 : 20YY년 남,녀
		int birthYear = 0; // 생년(초기화)
		String gender_word = null;
		String yearBef_Aft = null;

		switch (gender) { // 주민등록번호 뒷자리 첫 숫자로 판별
		case 1:
			birthYear = Integer.parseInt("19".concat(idNum_first.substring(0, 1 + 1)));
			gender_word = new String("남성");
			yearBef_Aft = new String("이전");
			break;
		case 2:
			birthYear = Integer.parseInt("19".concat(idNum_first.substring(0, 1 + 1)));
			gender_word = new String("여성");
			yearBef_Aft = new String("이전");
			break;
		case 3:
			birthYear = Integer.parseInt("20".concat(idNum_first.substring(0, 1 + 1)));
			gender_word = new String("남성");
			yearBef_Aft = new String("이후");
			break;
		case 4:
			birthYear = Integer.parseInt("20".concat(idNum_first.substring(0, 1 + 1)));
			gender_word = new String("여성");
			yearBef_Aft = new String("이후");
			break;
		default:
			System.out.println("성별 알 수 없음.");
		}

		if (idNum.length() == 14 && 1900 <= birthYear && birthYear <= 2099) { // 입력된 주민등록번호 길이가 '-' 포함 14자리, 생년이 1900년
																				// 이상 2099년 이하인 경우
			System.out.println("당신은 " + birthYear + "년 " + birthMonth + "월 " + birthDay + "일 " + "2000년 " + yearBef_Aft
					+ "에 태어난 " + gender_word + "입니다.");
		} else
			System.out.println("주민등록번호가 올바르지 않습니다.");
		
		sc.close();
	}

}
