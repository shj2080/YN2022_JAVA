package forwhiledowhile;

public class ContinueTest {

	public static void main(String[] args) {
		/**
		 * 1과 10 사이의 정수를 출력하되 그 중 '3의 배수(조건)'인 것 제외
		 * (예) 1 2 4 5 7 8 10 (3 6 9 제외)
		 */
		int i;
		for(i = 1; i <= 10; i++) {
			if(i % 3 == 0) continue; //아래 실행문 실행하지 않고 반복문의 제일 처음인 i++로..
			System.out.print(i+ " ");
		}
		System.out.println(); // 커서 아래로
		
		System.out.println();  //구분용 빈줄
		/**
		 * [과제] 1~50 사이의 정수를 출력하되 그 중 7의 배수인것은 제외
		 * 단, 1줄에 5개씩 출력
		 * for, while, do~while  한 번씩 사용하기
		 */
		System.out.println("------[방법-1]----------------------");
		System.out.println("1. for문");
		int count = 0;
		for (i= 1; i <= 50; i++) {
			if(i % 7 == 0) { //7의 배수이면
				continue;  //반복문의 제일 위인 i++로...
			}
			else {
				System.out.print(i + "\t"); //1		2
				count++; // 한 개 출력
				if(count % 5 ==0) //5의 배수로 출력
					System.out.println(); //커서를 아래로
			}
		}
		System.out.println("\n"); //커서를 아래로 -> 구분위한 빈줄
		
		System.out.println("2. while문");
		
		i = 1;
		count=0;
		while(i <= 50) {
					
			if(i % 7 == 0) {
				
			} else {
				System.out.print(i + "\t");
				count++;
				if (count % 5 == 0) System.out.println();
			}
			i++; //참,거짓에 관계없이 무조건 실행
		}
		
		System.out.println("\n"); //커서를 아래로 -> 구분위한 빈줄
		
		System.out.println("3. do~while문");
		i = 1;
		count=0;
		do {
					
			if(i % 7 == 0) {
				
			} else {
				System.out.print(i + "\t");
				count++;
				if (count % 5 == 0) System.out.println();
			}
			i++; //참,거짓에 관계없이 무조건 실행
		} while(i <= 50);
		
		System.out.println("\n"); //커서를 아래로 -> 구분위한 빈줄
		System.out.println("------[방법-2]----------------------");
		System.out.println("1. for문");
		count = 0;//출력된 횟수
		
		for(i = 1 ; i<=50 ; i++) {
			if(i%7==0) continue;
			
			System.out.print(i+"\t");
			count++;
			if(count%5==0) System.out.println(); // 커서 아래로
		}
		System.out.println("\n"); //커서를 아래로 -> 구분위한 빈줄
		
		System.out.println("2. while문");
		
		i=0; // ★주의 : 초기화
		count=0;//출력된 횟수
		
		while(i<=49) { //1 2 3 ...49(참) 50
			i++;//먼저 1증가 후 50
			if(i%7==0) continue; //7의 배수이면 반복문의 조건(i<=49)으로 감
			
			System.out.print(i+"\t");
			count++;
			if(count % 5 ==0) System.out.println(); //커서 아래로
			
			//i++; //이 위치에 있으면 무한루프에 빠짐
		}
		System.out.println("\n"); //커서를 아래로 -> 구분위한 빈줄
		
		System.out.println("3. do~while문");
		i=0; // 주의 : 초기화
		count=0;//출력된 횟수
		do { //1 2 3 ...49(참) 50
			i++;//먼저 1증가 후
			if(i%7==0) continue; //7의 배수이면 반복문의 조건(i<=49)으로 감
			
			System.out.print(i+"\t");
			count++;
			if(count % 5 ==0) System.out.println(); //커서 아래로
		} while(i<=49);
		
		System.out.println("\n"); //커서를 아래로 -> 구분위한 빈줄
		System.out.println("------[방법-3]----------------------");
		System.out.println("1. for문");
		count = 1;//출력된 횟수
		
		for(i = 1 ; i<=50 ; i++) { //i의 초기값이 0과 1 모두 결과OK
			if(i%7==0) {	//i를 7로 나눈 나머지가 0인 경우(7의 배수)
				continue;
			}
			else if(count % 5 ==0) {   //count를 5로 나눈 나머지가 0인 경우(count가 5인 경우)
				System.out.print(i+"\n"); //출력 후 커서 아래로
				count = 1; //다시 1로 초기화
			} else {
				System.out.print(i+"\t"); //출력 후 옆으로
				count++; //1증가
			}
		}
		System.out.println("\n"); //커서를 아래로 -> 구분위한 빈줄
		
		System.out.println("2. while문");
		
		i=0; // ★주의 : 초기화
		count=1;//출력된 횟수
		
		while(i<=49) { // 1 2 3 ...49(참)	50
			i++;//먼저 1증가 후 
			
			if(i%7==0) {	//i를 7로 나눈 나머지가 0인 경우(7의 배수)
				continue;
			}
			else if(count % 5 ==0) {   //count를 5로 나눈 나머지가 0인 경우(count가 5인 경우)
				System.out.print(i+"\n"); //출력 후 커서 아래로
				count = 1; //다시 1로 초기화
			} else {
				System.out.print(i+"\t");
				count++;
			}
		}
		System.out.println("\n"); //커서를 아래로 -> 구분위한 빈줄
		
		System.out.println("3. do~while문");
		i=0; // 주의 : 초기화
		count=1;//출력된 횟수
		do {
			i++;//먼저 1증가 후 
			
			if(i%7==0) {
				continue;
			}
			else if(count % 5 ==0) {
				System.out.print(i+"\n"); //출력 후 커서 아래로
				count = 1;
			} else {
				System.out.print(i+"\t");
				count++;
			}
		} while(i<=49);
		
		
		
		
		/* 작업한 과제내용 -충돌 방지 주석처리
		//count로 5개씩 끊어 출력
		int count = 1;		
		for(i = 1; i <= 50; i++) {
			
			if(i % 7 == 0) { //7의 배수이면
				continue;  //반복문의 제일 위인 i++로...
			}
			
			if(count > 5) {					// count가 5를 초과한 경우(6)
				System.out.println();
				count = 1;	//count 1로 초기화
			}
			
			System.out.print(i + "\t");
			count++;
		}
		System.out.println(); //커서 내리기
		
		
		i = 1; count=1;
		
		while(i <= 50) {
			
			if(i % 7 == 0) {
				//i++;		//countinue 전에 i값을 증가시킴 (7의 배수일 때 무한루프 방지)
				//continue;
			}
			
			if(count > 5) {					// count가 5를 초과한 경우(6)
				System.out.println();
				count = 1;	//count 1로 초기화
			}
			
			System.out.print(i + "\t");
			
			count++;
			i++;
		}
		System.out.println(); //커서 내리기
		
		i = 1; count= 1;
		do {
			
			if(i % 7 == 0) {
				//i++;		//countinue 전에 i값을 증가시킴 (7의 배수일 때 무한루프 방지)
				//continue;
			}
			
			if(count > 5) {					// count가 5를 초과한 경우(6)
				System.out.println();
				count = 1;	//count 1로 초기화
			}
			
			System.out.print(i + "\t");
			
			count++;
			i++;
			
		} while(i <= 50);
		*/
	}

}
