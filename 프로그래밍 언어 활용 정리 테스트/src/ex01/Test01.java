package ex01;

public class Test01 {

	public static void main(String[] args) {
		/*
		 * for문과 if문을 이용하여 1~20 사이의 수 중 4의 배수를 제외하고 출력하시오.
		 * (단, 출력 시 1줄에 5개씩 Tab크기만큼 간격을 두고 출력하기)
		 */
		int cnt = 0; //1줄의 출력 횟수
		
		for(int i = 1; i <= 20; i++) {		//1~20까지 반복
			
			if(i % 4 != 0) {	//4의 배수가 아닌 경우 (4로 나눈 나머지값이 0이 아닌경우)
				if (cnt == 5) {		//5번 출력된 경우  (1줄에 출력할 숫자 개수)
					System.out.println();	//커서를 아래로 내림
					cnt = 0; //출력 횟수 초기화
				}
				
				System.out.print(i + "\t");	//값 출력
				cnt++; // 출력 횟수 증가
			}
		}
		
	}

}
