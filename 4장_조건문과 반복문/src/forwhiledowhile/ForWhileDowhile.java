package forwhiledowhile;

public class ForWhileDowhile {

	public static void main(String[] args) {
		/** 반복문 사용 안하면 **/
		System.out.print(1+ " ");
		System.out.print(2+ " ");
		System.out.print(3+ " ");
		System.out.print(4+ " ");
		System.out.print(5+ " ");
		
		System.out.println(); //구분용 빈줄
		
		/** 반복문 3가지 **/
		System.out.println("*** for문 : \"배열\"이나 \"컬렉션프레임워크\"에서 많이 사용함 ***");
		int i; //카운터 변수+반복문의 실행문
		//1~5까지 옆으로 출력 for문
		for(i = 1; i <= 5; i++) {	//for문에서만 조건문 생략 가능(생략하면 true)
			System.out.print(i + " ");
		}
		System.out.println(); //커서 아래로
		System.out.println(); //구분용 빈줄

		System.out.println("*** while문 : for문과 같은 결과 ***");
		
		i = 1; 	// 초기화 1번만
		while(i <= 5) {		//조건문 생략 불가능
			System.out.print(i + " ");
			i++;
		}
		System.out.println(); //커서 아래로
		System.out.println(); //구분용 빈줄
		
		System.out.println("*** do~while문 : 참/거짓에 관계없이 무조건 한번은 실행 ***");
		
		i = 1; 	// 초기화 1번만
		do {	
			System.out.print(i + " ");
			i++;
		} while(i <= 5);	//조건문 생략 불가능
		System.out.println(); //커서 아래로
		System.out.println(); //구분용 빈줄
		
		System.out.println("--- 1~10까지 더한 합 ----------------------");
		//for, while, do~while 문으로 풀어보기
		
		int result = 0; //★0으로 초기화
		for(i = 1; i <= 10; i++) {
			result += i;
		}
		System.out.println("[for문] 1~10까지 더한 합=" + result);
		
		i = 1;
		result = 0;	//★0으로 초기화
		while(i <= 10) {
			result += i;
			i++;
		}
		System.out.println("[while문] 1~10까지 더한 합=" + result);
		
		i = 1;
		result = 0;	//★0으로 초기화
		do {
			result += i;
			i++;
		} while(i <= 10);
		System.out.println("[do~while문] 1~10까지 더한 합=" + result);
		
		
		
	}

}
