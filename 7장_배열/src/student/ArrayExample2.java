package student;

import java.util.Scanner;

public class ArrayExample2 {

	public static void main(String[] args) {
		/*
		 * 6-27 [과제-2] 키보드로부터 학생수를 입력받아 sco2가 참조하는 배열객체 생성한 후 -> 학생들의 점수를 하나씩 입력받아 배열객체에
		 * 저장(=>반복문 for문 이용) -> 합과 평균 구하기
		 */
		int i;

		Scanner sc = new Scanner(System.in);
		System.out.println("-- 학생들의 점수합계와 평균 구하기 --");
		System.out.print("학생 수 입력 > ");
		int cnt_Student = sc.nextInt();

		/*
		 * 배열크기는 0보다 큰 수를 입력받아야 함 1.학생수가 0이면 0.0 / 0 = 모든 수 / 0 => 0으로 나눌 수 없다. Not a
		 * Number(NaN) 2.학생수가 음수이면 java.lang.NegativeArraySizeException 예외객체 생성 -> 프로그램
		 * 강제로 멈춤
		 */
		if (cnt_Student <= 0) {
			System.out.println("학생 수는 0이하가 될 수 없습니다.");
		} else {
			int[] sco2 = new int[cnt_Student]; // [90,80,100]

			/*
			 * int[] sco2 = new int[3]; //[0,0,0]
			 * 
			 * System.out.print("1번째 학생의 점수 입력(0~100)"); sco2[0] = sc.nextInt();
			 * 
			 * System.out.print("2번째 학생의 점수 입력(0~100)"); sco2[1] = sc.nextInt();
			 * 
			 * System.out.print("3번째 학생의 점수 입력(0~100)"); sco2[2] = sc.nextInt();
			 */

			int sum = 0;
			//[방법-1] 임시변수 사용
			/*
			int sco_tmp;
			
			
			for (i = 0; i < sco2.length; i++) {
				System.out.print((i + 1) + "번째 학생의 점수 입력(0~100)");
				
				sco_tmp = sc.nextInt();		//입력한 점수를 임시변수 저장
				
				//if( !(0 <= sco_tmp && sco_tmp <= 100)) {
				if( 0 > sco_tmp || sco_tmp > 100) {
					System.out.println("점수를 0~100사이로 입력해주세요~");
					i--;	//★ 잘못 입력된 학생점수를 다시 입력받기 위해 i값을 줄임
					continue; //i++로 감
				}
								
				sco2[i] = sco_tmp; // 90 -> 80 -> 100
				
				sum += sco2[i]; // 0+90+80+100
			}
			*/
			
			//[방법-2] 임시변수 사용안함
			for (i = 0; i < sco2.length; i++) {
				System.out.print((i + 1) + "번째 학생의 점수 입력(0~100)");
				
				sco2[i] = sc.nextInt();		//입력한 점수를 바로 배열에 저장
				
				if( 0 > sco2[i] || sco2[i] > 100) {
					System.out.println("점수를 0~100사이로 입력해주세요~");
					i--;	//★ 잘못 입력된 학생점수를 다시 입력받기 위해 i값을 줄임
					continue; //i++로 감
				}
				
				sum += sco2[i]; // 0+90+80+100
			}
			
			// sco2.length == cnt_Student = 학생수
			double avg = (double) sum / cnt_Student; // 0.0 / 0 = 모든 수 / 0 => 0으로 나눌 수 없다. Not a Number(NaN)

			System.out.println("점수합계=" + sum + ", 점수평균=" + avg);
		}

		sc.close();
	}

}
