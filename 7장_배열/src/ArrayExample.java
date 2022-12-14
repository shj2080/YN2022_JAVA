import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample {

	public static void main(String[] args) {
		System.out.println("** 배열을 사용하지 않았을 때 **");

		// Stack 메모리(main)에 존재하는 변수(지역변수)
		int s1 = 83;
		int s2 = 88;
		int s3 = 95;
		int s4 = 87;
		// ----Stack-----

		// 더한 합=? (반복문, 배열 사용안했을 때)
		int sum = s1 + s2 + s3 + s4;
		System.out.println("합=" + sum);

		/*
		 * sum = 0; //반복문 이용 => 합을 구할 수 없다. (이유?값 사이에 일정한 규칙이 없어서 반복문 사용불가) for(int i =
		 * 1; i <= 4; i++) { sum += si;//X 오류 }
		 */

		/** 배열 선언, 생성(Heap메모리)과 동시에 값 목록 대입 **/
		System.out.println("** 배열을 사용했을 때 : 같은 타입의 데이터만 저장가능, 크기 고정 **");

		// 1. int 타입 배열----------------------------------------------
		int[] scores = { 83, 88, 95, 87 };
		// index 0 1 2 3 배열의 길이(읽기전용 멤버변수) length == 4(마지막 index+1)

		scores[0] = 93; // 변경

		System.out.print(scores[0] + " ");
		System.out.print(scores[1] + " ");
		System.out.print(scores[2] + " ");
		System.out.print(scores[3] + " ");

		System.out.println(); // 커서를 아래로 내림

		int i;

		for (i = 0; i < scores.length; i++) { // for(i = 0; i < 4; i++) {
			System.out.print(scores[i] + " ");
		}
		System.out.println(); // 커서를 아래로 내림

		sum = 0;
		sum += scores[0] + scores[1] + scores[2] + scores[3]; // 각 index에 들어있는 정수값을 모두 더함

		sum = 0;
		for (i = 0; i < scores.length; i++) {
			sum += scores[i]; // 0 + 93 + 88 + 95 + 87
		}
		System.out.println("합=" + sum);
		double avg = (double) sum / scores.length; // 평균값 : 합 / 배열크기
		System.out.println("평균=" + avg);

		// I@6504e3b2(객체의 주소로 만든 16진수 Hash코드) 의미? 부모인 Object의 toString() 재정의하지 않고 그대로 사용
		System.out.println("int 배열=" + scores); // int 타입 배열객체의 주소만 I@6504e3b2
		System.out.println("int 배열=" + scores.toString()); // I@6504e3b2

		System.out.println("Arrays 클래스 이용=" + Arrays.toString(scores)); // [93, 88, 95, 87]

		// 2. char 타입 배열----------------------------------------------
		char[] ch = { 'a', 'b', 'c' }; // {97, 98, 99}

		// 탭 크기(\t)만큼 띄워서 옆으로 출력!
		for (i = 0; i < ch.length; i++) {
			System.out.print(ch[i] + "\t");
		}
		System.out.println(); // 커서를 아래로 내림

		System.out.println("char 배열=" + ch); // char 타입 배열객체의 주소만 C@6504e3b2
		System.out.println("char 배열=" + ch.toString()); // C@6504e3b2

		System.out.println("Arrays 클래스 이용=" + Arrays.toString(ch)); // [a, b, c]

		System.out.println((int) 'A'); // 65
		System.out.println((int) 'A' + 32); // 65+32=97
		System.out.println('A' + 32); // 65+32=97
		System.out.println((int) 'a'); // 65+32=97

		System.out.println((char) ('A' + 32)); // 65+32=97 => 'a'

		// ★소문자 - 32 = 대문자 , 대문자 + 32 = 소문자
		// 소문자 {'a', 'b', 'c'} -> 대문자 {'A', 'B', 'C'} 로 변경
		for (i = 0; i < ch.length; i++) {
			// [방법-1] : 연산한 결과는 정수인데 char타입의 배열에 저장하려면 char 타입으로 형변환
			// ch[i] = (char)(ch[i] - 32); //97 - 32 = 65(결과가 정수) => char 타입으로 형변환

			// [방법-2] : 복합대입연산자 사용하면 자동으로 형변환되어 저장됨(편리함)
			ch[i] -= 32; // 대문자 변환
		}

		for (i = 0; i < ch.length; i++) {
			System.out.print(ch[i] + "\t");
		}
		System.out.println(); // 커서를 아래로 내림

		// => 위 2개의 for문을 하나의 for문으로 해결
		// 대문자 {'A', 'B', 'C'} -> 소문자 {'a', 'b', 'c'} 로 변경
		for (i = 0; i < ch.length; i++) {
			ch[i] += 32; // 소문자 변환
			System.out.print(ch[i] + "\t");
		}
		System.out.println(); // 커서를 아래로 내림

		/** [과제-1] **/
		// 6-27 [과제-1] Arrays.toString() 메서드를 사용하지 않고, [A, B, C] 출력 (for문 사용)
		// A, B, C, 출력에서 마지막 ,제외하여 [A, B, C] 출력

		char[] ch2 = { 'A', 'B', 'C' };
		
		String result = "";
		System.out.println("--- [과제-1] 방법-1 ---");
		//System.out.print("[");  //ln 없음
		
		for (i = 0; i < ch2.length; i++) {
			result = result + ch2[i] + ", ";		// "" + "A" => "A"+...=>"A, B, C, "
		}
		
		System.out.println("[" + result.substring(0, result.length()-2) + "]");
		//System.out.println("]");
		
		
		result = "";
		System.out.println("--- [과제-1] 방법-2 ---");
		
		for (i = 0; i < ch2.length; i++) {
			if(i == 0) {
				System.out.print("[" + ch2[i] + ", ");		//옆으로 출력 위해 ln 없애야 함
			}else if(i != ch2.length-1) {//else : i > 0 마지막 index가 아니면
				System.out.print(ch2[i] + ", ");
			}else {	//마지막 index이면
				System.out.println(ch2[i] + "]"); // 커서를 아래로
			}
		}
		System.out.println(); //구분 위한 빈줄
		
		result = "";
		System.out.println("--- [과제-1] 방법-3 ---");
		
		for (i = 0; i < ch2.length; i++) {
			//if~else //[방법-1]
			//if(i != ch2.length-1) result = result + ch2[i] + ", ";
			//else result = result + ch2[i];
			
			//조건연산자 (조건문)?참:거짓
			//result = result + ((i != ch2.length-1)? ch2[i] + ", " : ch2[i]);  //[방법-2]
			//result += ((i != ch2.length-1)? ch2[i] + ", " : ch2[i]);  //[방법-2]
			result += ((i == 0)? ch2[i] : ", " + ch2[i]);  //[방법-3]
		}
		System.out.println("[" + result + "]");
		
				
		//		[과제-1 완성본]
		  System.out.println("◈과제-Arrays.toString 없이 [A, B, C] 출력");
		  //ch2 = {'A', 'B', 'C'};
		  
		  System.out.print("[");
		  for(i = 0;i < ch2.length; i++) {
			  if(i == ch2.length-1) {
				  System.out.print(ch2[i]); //ch2의 마지막 index값인 경우(length-1)  //, 제외하여 출력
			  }else {
				  System.out.print(ch2[i] + ", "); //, 포함하여 출력
			  }
		  }
		  System.out.print("]");
		  System.out.println(); //커서를 아래로 내림
		//-----------------------------------------------------------------------
		 
		/**
		 * java.util.Arrays 클래스 : 배열을 조작하기 위해 만들어진 클래스
		 */
		System.out.println("Arrays.toString()이용=" + Arrays.toString(ch)); // [a, b, c]

		/**
		 * // * java.lang.ArrayIndexOutOfBoundsException 예외발생 = 예외객체 생성 => 프로그램이 강제로 멈춤
		 * : 예외객체를 처리(try~catch)하지 않고 프로그래머가 알아서 논리적으로 처리 : 잘못된 코드 삭제
		 * 
		 * try{ 예외발생가능성 있는 부분 } catch(Exception e) //예외발생했을 때만 잡아서 예외처리;
		 */

		try {
			System.out.println(ch[3]);
		} catch (Exception e) {
			// e.printStackTrace(); //자바가상머신(=JVM)이 처리
			System.out.println("index범위를 넘었어요~ 해당 배열값은 존재하지 않습니다.");
		}

		/************ 배열 선언 후 배열목록 생성 방법-1 *********************************/
		int[] sco1 = null; // 배열선언만 (null:참조하는 배열객체 없음)

		/*
		 * 객체는 기본값이 존재함 (※ 지역변수는 반드시 초기화를 해줘야 함) 기본타입 : int(0) double(0.0) / char('\0'
		 * null문자) boolean(false) 클래스타입 : String, Integer, Double ... => 기본값은 모두 null
		 */

		sco1 = new int[3]; // 3의 의미: length가 3, int타입 배열객체[0, 0, 0]
		System.out.println("Arrays.toString()이용=" + Arrays.toString(sco1));

		boolean[] scoBoolean = null;
		scoBoolean = new boolean[4];
		System.out.println("Arrays.toString()이용=" + Arrays.toString(scoBoolean));

		// [문제] sco1가 참조하는 값들을 10 증가한 값으로 변경
		// sco1[0] += 10;
		// sco1[1] += 10;
		// sco1[2] += 10;

		for (i = 0; i < sco1.length; i++) {
			sco1[i] += 10;
		}
		System.out.println("Arrays.toString()이용=" + Arrays.toString(sco1));

		// [문제] sco1가 참조하는 값들을 다시 0으로 변경 후 [0, 10, 20]로 변경
		for (i = 0; i < sco1.length; i++) { // 먼저 0으로 변경 후
			sco1[i] = 0;
		}

		// sco[1] = sco[0] + 10 = 0 + 10;
		// sco[2] = sco[1] + 10 = 10 + 10;
		// sco[3] = sco[2] + 10 //오류 발생! sco[3]에서 3은 index범위 넘어섬
		// [방법-1]
		for (i = 0; i < sco1.length; i++) { // [0, 10, 20]로 변경
			// i가 0이면 sco1[0-1] = sco1[-1]위치에서 ArrayIndexOutOfBoundsException 발생
			if (i != 0)
				sco1[i] = sco1[i - 1] + 10;
		}
		System.out.println("Arrays.toString()이용=" + Arrays.toString(sco1));
		// [방법-2]
		for (i = 1; i < sco1.length; i++) { // [0, 10, 20]로 변경
			sco1[i] = sco1[i - 1] + 10;
		}
		System.out.println("Arrays.toString()이용=" + Arrays.toString(sco1));

		/*
		 * sco1이 참조하는 값을 향상된 for문으로 출력
		 * 
		 * 향상된 for문 정리 : index를 이용하지 않으므로 단지 배열의 값만 참조할 수 있고 index로 접근하여 배열값을 변경할 수 없다.
		 */
		for (i = 0; i < sco1.length; i++) {
			System.out.print(sco1[i] + " ");
		}
		System.out.println(); // 커서를 아래로

		for (int value : sco1) { // value : 0 -> 10 -> 20
			System.out.print(value + " ");
		}
		System.out.println(); // 커서를 아래로

		System.out.println("[과제-2]");
		/** [과제-2] **/
		/*
		 * 6-27 [과제-2] 키보드로부터 학생수를 입력받아 sco2가 참조하는 배열객체 생성한 후 -> 학생들의 점수를 하나씩 입력받아 배열객체에
		 * 저장(=>반복문 for문 이용) -> 합과 평균 구하기
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
		//다른 방법은 ArrayTesting, ArrayExample2 확인
		
		// -----------------------------------------------------------------------
		/************ 배열 선언 후 배열목록 생성 방법-2 *********************************/
		// [방법-1]
		int[] sco3 = new int[3]; // [0, 0, 0] 기본값
		sco3[0] = 3;
		sco3[1] = 4;
		sco3[2] = 5;

		// [방법-2]
		int[] sco4 = new int[] { 3, 4, 5 }; // 처음부터 초기값을 부여함

		// [방법-3]
		int[] sco5 = { 3, 4, 5 }; // 처음부터 초기값을 부여함 (new int[] 생략가능)

		// [방법-4]
		int[] sco6 = null; // 배열 선언만
		sco6 = new int[] { 3, 4, 5 }; // new int[] 생략불가
		
		/***************** [과제-1]을 '향상된 for문'으로 처리 ***************************
		 * '향상된 for문' : index로 접근하지 않기 때문에 배열의 값을 변경할 수 없다.
		 * 				  단지, 배열값을 참조만 할 수 있다.
		 */
		// 6-27 [과제-1] Arrays.toString() 메서드를 사용하지 않고, [A, B, C] 출력 (향상된 for문 사용)
		// A, B, C, 출력에서 마지막 ,제외하여 [A, B, C] 출력
		
		ch2 = new char[]{ 'A', 'B', 'C' };
		
		result = "";
		System.out.println("--- [과제-1] 방법-1 : 향상된 for문 사용 가능 ---");
		//System.out.print("[");  //ln 없음
		
		for (char value : ch2) { //'A'
			result = result + value + ", ";		// "" + "A"+", " => "A, "+...=>"A, B, C, "
		}
		
		System.out.println("[" + result.substring(0, result.length()-2) + "]");
		//System.out.println("]");
		
		
		result = "";
		System.out.println("--- [과제-1] 방법-2 : 향상된 for문 사용 불가 ---");
		/*
		for (i = 0; i < ch2.length; i++) {
			if(i == 0) {
				System.out.print("[" + ch2[i] + ", ");		//옆으로 출력 위해 ln 없애야 함
			}else if(i != ch2.length-1) {//else : i > 0 마지막 index가 아니면
				System.out.print(ch2[i] + ", ");
			}else {	//마지막 index이면
				System.out.println(ch2[i] + "]"); // 커서를 아래로
			}
		}
		*/
		System.out.println(); //구분 위한 빈줄
		
		result = "";
		System.out.println("--- [과제-1] 방법-3 : 향상된 for문 사용 불가 ---");
		/*
		for (i = 0; i < ch2.length; i++) {
			//if~else //[방법-1]
			//if(i != ch2.length-1) result = result + ch2[i] + ", ";
			//else result = result + ch2[i];
			
			//조건연산자 (조건문)?참:거짓
			//result = result + ((i != ch2.length-1)? ch2[i] + ", " : ch2[i]);  //[방법-2]
			//result += ((i != ch2.length-1)? ch2[i] + ", " : ch2[i]);  //[방법-2]
			result += ((i == 0)? ch2[i] : ", " + ch2[i]);  //[방법-3]
		}
		System.out.println("[" + result + "]");
		*/
		
		
		sc.close();
	}

}
