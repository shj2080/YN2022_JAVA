package study_check;

public class arrayhomework001 {

	public static void main(String[] args) {

		// 2022.07.01 과제1 다른학생 풀이 참고자료
		// 학생01
		System.out.println("*** 2차원 배열 선언하는 방법-1 ***");
		int[][] m = new int[2][3]; // [2행][3열]

		m[0][0] = 95;
		m[0][1] = 100;
		m[0][2] = 87;
		m[1][0] = 83;
		m[1][1] = 92;
		m[1][2] = 78;

		int i, j;
		for (i = 0; i < m.length; i++) { // m.length : 행 (각 일차원 배열에 대한 주소값을 담고 있음)
			System.out.print("[");
			for (j = 0; j < m[i].length; j++) { // m[i].length : 열
				/*
				 * if (j == 0) { System.out.print(m[i][j]); } else if (j != m[i].length - 1) {
				 * System.out.print(", " + m[i][j]); } else { System.out.print(", " + m[i][j]);
				 * }
				 */

				if (j == 0) {
					System.out.print(m[i][j]);
				} else {
					System.out.print(", " + m[i][j]);
				}

			}

			System.out.println("]");

		}
		
		/*
		 * 7-2 과제 2 각반의 java 성적의  합과 평균 구하기
		
		int hap;
		double avg;
		for(i = 0; i < java.length; i++){
			hap = 0;
			for(j = 0; j < java[i].length; j++) {
				hap += java[i][j];
			}
			avg = ((double)hap/java[i].length);
			//System.out.println((i+1) + " 반의 총 합 : " + hap + ", 평균 : " + avg);
			System.out.printf("%d 반의 총 합 : %d\t 평균 : %.2f\n",(i+1),hap,avg);
		}
		*/
		
		/**
		 * 7-1 [과제-1] 중첩된 for문을 이용하여 아래 내용 출력 [95, 100, 87] [00][01][02]
		 * 
		 * [83, 92, 78] [10][11][12]
		 */
		System.out.println("--[과제-1] : m이 참조하는 배열--");
		for (i = 0; i < m.length; i++) {
			System.out.print("[" + m[i][0]);
			for (j = 1; j < m[i].length; j++) {
				System.out.print(", " + m[i][j]);

			}
			System.out.println("]");
		}
		
		/** 7-1 [과제-2] 각 반의 java 성적의 합과 평균 구하기
		 * 			   java 성적의 총 합과 총 평균 구하기
		 */
		
		System.out.println("--[과제-2] : 각 반 java 성적의 합과 평균 구한 뒤 모든 반의 성적 총합과 총평균 출력");
		
		int[][] java = {
				{95, 97},			//1반 2명. java[0].length == 2
				{98, 100, 99, 75},	//2반 4명. java[1].length == 4
				{100, 88, 92}		//3반 3명. java[2].length == 3
				};
		
		//[단계-1]. 각 반의 java 성적의 합과 평균 구하기
		int sum;  //이곳에서 0으로 초기화하지 않아도 됨
		for(i = 0; i < java.length; i++) {
			
			sum = 0; 	//★★0으로 초기화 위치
			for(j = 0; j < java[i].length; j++) {
				sum += java[i][j];
			}
			
			System.out.println((i + 1) + "반의 합=" + sum + ", 평균=" + (double)sum/java[i].length);
			
		}
		//[단계-2]. java 성적의 총 합과 총 평균 구하기
		int totalSum = 0; //★★반드시 이곳에서 0으로 초기화
		int totalStudentNum = 0; //★★반드시 이곳에서 0으로 초기화
		
		for(i = 0; i < java.length; i++) {
			
			//totalStudentNum += java[i].length; //3번만 실행
			
			for(j = 0; j < java[i].length; j++) {
				totalSum += java[i][j];
				//totalStudentNum++; //방법-1 : 9번 실행
			}
			
			totalStudentNum += java[i].length; //3번만 실행
		}
		
		System.out.println("java 성적 총 합=" + totalSum + ", 총 평균=" + (double)totalSum/totalStudentNum);
		
		//[단계-1] + [단계-2] => [단계-3] 단계1과 2를 하나로 합치기
		System.out.println("\n ------------ 단계1과 2를 하나로 합치기 --------------");
		totalSum = 0;	//★★반드시 이곳에서 0으로 초기화
		totalStudentNum = 0; //★★반드시 이곳에서 0으로 초기화
		
		for(i = 0; i < java.length; i++) {
			
			sum = 0; 	//★★0으로 초기화 위치
			
			for(j = 0; j < java[i].length; j++) {
				sum += java[i][j];
				totalSum += java[i][j];
				//totalStudentNum++; //방법-1 : 9번 실행
			}
			//System.out.println((i + 1) + "반의 합=" + sum + ", 평균=" + (double)sum/java[i].length);
			
			//format	정수(%d:1진수, %o:8진수, %x:16진수), 실수(%f)
			System.out.printf("%d반의 합=%d, 평균=%.2f \n", (i + 1), sum, (double)sum/java[i].length);
			
			totalStudentNum += java[i].length; //3번만 실행
		}
		
		//System.out.println("총 합=" + totalSum + ", 총 평균=" + (double)totalSum/totalStudentNum);
		System.out.printf("총 합=%d, 총 평균=%.2f", totalSum, (double)totalSum/totalStudentNum);
		
		
		System.out.println("\n ------------ 7-4[과제-2] 단계1과 2를 하나로 합치기(=>향상된 for로 처리) --------------");
		totalSum = 0;		 //★★반드시 이곳에서 0으로 초기화
		totalStudentNum = 0; //★★반드시 이곳에서 0으로 초기화
		
		int studentNum;			//반 내 학생 수
		int studyClass = 1;		// 반
		
		for(int[] java_addr : java) {		//java_addr 각 배열 객체의 주소값을 갖고 있음.
			
			sum = 0;			// 값 받기 전 초기화
			studentNum = 0;		// 값 받기 전 초기화
			
			for(int javaScore : java_addr) {
				sum += javaScore;
				totalSum += javaScore;
				totalStudentNum++;
				
				studentNum++;
			}
			System.out.println((studyClass++) + "반의 합=" + sum + ", 평균=" + (double)sum/studentNum); //studyClass 반 성적 출력 후 증가
			
		}
		System.out.println("총 합=" + totalSum + ", 총 평균=" + (double)totalSum / totalStudentNum);
		
		
		
		/** 선생님 풀이 **/
		System.out.println("\n ------------ 7-4[과제-2] 단계1과 2를 하나로 합치기(=>향상된 for로 처리) --------------");
		totalSum = 0;		 //★★반드시 이곳에서 0으로 초기화
		totalStudentNum = 0; //★★반드시 이곳에서 0으로 초기화
		
		int classNum = 0;
		
		for(int[] arr : java) {		
			
			sum = 0;			// 값 받기 전 초기화
			studentNum = 0;		// 값 받기 전 초기화
			
			for(int value : arr) {
				sum += value;
				totalSum += value;
				//totalStudentNum++;

			}
			System.out.println(++classNum + "반의 합=" + sum + ", 평균=" + (double)sum/arr.length); 
			
			totalStudentNum += arr.length; //3번만 실행
		}
		System.out.println("총 합=" + totalSum + ", 총 평균=" + (double)totalSum / totalStudentNum);
	}

}
