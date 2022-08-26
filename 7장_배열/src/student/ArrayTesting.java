package student;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayTesting {

	public static void main(String[] args) {
		int i;
		/** [과제-2] **/
		/*
		 * 6-27 [과제-2] 키보드로부터 학생수를 입력받아 sco2가 참조하는 배열객체 생성한 후 -> 학생들의 점수를 하나씩 입력받아 배열객체에
		 * 저장(=>반복문 for문 이용)
		 * -> 합과 평균 구하기
		 */
		int[] sco2 = null;

		int cnt_Student = 0; // 학생 수
		double totalScore = 0; // 점수 합계(전체점수)
		double avgScore = 0; // 평균 점수

		int score_tmp = 0; // 학생점수(if 체크용 임시변수)

		Scanner sc = new Scanner(System.in);

		System.out.print("학생 수 입력 > ");
		cnt_Student = sc.nextInt();

		if (cnt_Student <= 0) { // 입력된 학생수가 0보다 작거나 같은 경우(종료)
			System.out.println("학생 수는 0이하가 될 수 없습니다.");
		} else {

			sco2 = new int[cnt_Student]; // 학생 수 만큼 배열객체 생성

			for (i = 0; i < sco2.length; i++) {
				System.out.print((i + 1) + "번째 학생의 점수 입력(0~100) > ");
				score_tmp = sc.nextInt();
				if (score_tmp < 0 || 100 < score_tmp) { // 입력된 점수가 0보다 작거나 100보다 큰 경우
					System.out.println("점수를 0~100 사이로 입력해주세요.");
					i--; // 잘못 입력된 학생점수를 다시 입력받기 위해 i값을 줄임
					continue;
				}

				sco2[i] = score_tmp;
				totalScore += sco2[i]; // 입력받은 학생 점수를 더함
			}

			avgScore += (totalScore / cnt_Student); // 평균 구하기

			System.out.println("점수합계=" + totalScore + "\t" + "평균점수=" + avgScore);
		}
		/****************************************************/
		//다른 학생 과제 수행 참고용도
		//과제케이스-1
		// 과제 키보드로 부터 학생수를 입력받아서 sco2가 참조하는 배열객체를 생성한다음
		// -->학생들의 점수를 하나씩 입력 받아서 배열객체를 채움
		// --> 전체 점수와 평균 구하기
		//Scanner sc = new Scanner(System.in);
		System.out.println("학생수 입력");
		int student = sc.nextInt();
		double sum = 0;
		double average = 0.0;
		int[] studentpoint = new int[student]; //[90,80,89]

		for (i = 0; i < student; i++) {
			System.out.println("점수입력");
			double a = sc.nextInt(); //89
			studentpoint[i] += a;
			sum += studentpoint[i];  //0+90+80+89
		}
		average = sum / student;
		System.out.println("학생총점=" + sum);
		System.out.printf("학생평균=%.1f", average);
		//-------------------------------------------------
		//과제케이스-2
		System.out.println("[과제-2]");
		int sum1=0; //총점을 저장하기 위한 변수
		average=0;//평균을 저장하기 위한 변수	
		
		//Scanner sc = new Scanner(System.in);	
		System.out.print("학생 수 입력 > ");
		//int size = sc.nextInt();
		sco2=new int[sc.nextInt()];

		for(i=0; i<sco2.length; i++) {
			System.out.print("성적을 입력하십시오.:");
			sco2[i]=sc.nextInt();
			sum1 += sco2[i];
			average = sum1/(double) sco2.length;		
			}						
			System.out.println("총점: "+sum1);
			System.out.println("평균: "+average);
			//-------------------------------------------------
		//과제케이스-3
			/*
			 * 과제2 
			 * 키보드로 부터 학생수를 입력받아 sco2가 참조하는 배열객체 생성한 후
			 * -> 학생들의 점수를 하나씩 입력 받아 배열 객체에 저장
			 * 합과 평균 구하기
			 */
			
			
			//Scanner sc = new Scanner(System.in);
			Random random = new Random();
			//학생별 점수를 자동으로 넣기 위해서 랜덤 클래스를 이용

			System.out.print("총 학생 수는 몇명인가요?");
			int many = sc.nextInt();
			sco2 = new int[many];

			sum = 0;
			double avg = 0;

			for(i = 0; i < sco2.length; i++) {
//				System.out.println((i+1)  + " 번째 학생의 점수는?");
//				sco2[i] = sc.nextInt();
				sco2[i] = random.nextInt(100);
				//정수 0~100 사이에서 배정
				sum += sco2[i];
				System.out.print((i+1)+"번째 학생의 점수 = " + sco2[i] + "\t");
				if((i+1)%5 ==0) {
					System.out.println();
				}
			}

			System.out.println();
			System.out.println("총 점수 합 = " +sum);
			avg = sum/many;
			
			System.out.print("총 학생 수 = " + many);
			System.out.printf("\t평균 = %.2f",avg);
			sc.close();
			
	}

}
