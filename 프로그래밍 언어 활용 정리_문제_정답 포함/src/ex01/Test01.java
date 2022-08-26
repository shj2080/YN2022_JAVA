package ex01;

public class Test01 {

	public static void main(String[] args) {
		/*
		 * for문과 if문을 이용하여 1~20 사이의 수 중 4의 배수를 제외하고 출력하시오.
		 * (단, 출력 시 1줄에 5개씩 Tab크기만큼 간격을 두고 출력하기)
		 */
		int count = 0; // 한 줄에 출력된 횟수
		for(int i = 1; i <= 20; i++) {
			if(i % 4 == 0) 	//4의 배수인 경우 위로 올라감(continue)
				continue;
			//4의 배수가 아닌 경우 아래 명령문 실행
			count++;
			if(count % 5 ==0)
				System.out.println(i); 			//count가 5의 배수이면 출력 후 커서를 아래로
			else
				System.out.print(i + "\t"); 	//5의 배수가 아니면 출력 후 커서를 옆으로
		}
		
	}

}
