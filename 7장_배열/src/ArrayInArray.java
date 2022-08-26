import java.util.Arrays;

public class ArrayInArray {

	public static void main(String[] args) {
		/****************** 2차원 배열 선언하는 방법-1 ************************/
		System.out.println("*** 2차원 배열 선언하는 방법-1 ***");
		int[][] m = new int[2][3];		//[2행][3열]
		
		System.out.println(Arrays.toString(m[0])); //m[0](=주소)가 참조하는 배열객체의 값을 출력
		System.out.println(Arrays.toString(m[1]));	//기본값으로 채워진 배열객체 출력 [0, 0 ,0]
		System.out.println();  //구분위한 빈줄
		
		int i;
		for(i = 0; i < m.length; i++) {
			System.out.println(Arrays.toString(m[i]));
		}
		System.out.println();  //구분위한 빈줄
		
		System.out.println("** 향상된 for문 : index사용안함(index로 접근해야만 하는 상황에서는 사용못함) **");
		for(int[] arr : m) {
			System.out.println(Arrays.toString(arr));
		}
		System.out.println();  //구분위한 빈줄
		
		System.out.println("** for문 사용안하고 출력 **");
		System.out.print("[");
		System.out.print(m[0][0] + ", ");//기본값 0
		System.out.print(m[0][1] + ", ");
		System.out.print(m[0][2]);
		System.out.println("]"); //커서를 아래로
		
		System.out.print("[");
		System.out.print(m[1][0] + ", ");
		System.out.print(m[1][1] + ", ");
		System.out.print(m[1][2]);
		System.out.println("]"); //커서를 아래로
		
		System.out.println("** 배열의 값 변경 후 출력");
		m[0][0] = 95;	m[0][1] = 100;	m[0][2] = 87;
		m[1][0] = 83;	m[1][1] = 92;	m[1][2] = 78;
		
		for(int[] arr : m) {
			System.out.println(Arrays.toString(arr));
		}
		System.out.println();  //구분위한 빈줄
		
		/**
		 * 7-1 [과제-1]
		 * 중첩된 for문을 이용하여 아래 내용 출력
		 * [95, 100, 87]				[00][01][02]
		 * [83, 92, 78]					[10][11][12]
		 */
		System.out.println("--[과제-1] : m이 참조하는 배열--");
		
		int j;
		for(i = 0; i < m.length; i++) {					//행
			System.out.print("[");
			for(j = 0; j < m[i].length; j++) {				//열
				if (j == 0) {
					System.out.print(m[i][j]);
				} else {
					System.out.print(", " + m[i][j]);
				}
			}
			System.out.println("]");  //괄호 닫은 후 커서를 아래로 내림
		}
		System.out.println();  //구분위한 빈줄
		
		/****************** 2차원 배열 선언하는 방법-2 ************************/
		System.out.println("*** 2차원 배열 선언하는 방법-2 ***");
		int[][] e = new int[2][];
		System.out.println(Arrays.toString(e));	//[null, null]
		
		e[0] = new int[2];//1반 2명 : [0, 0] 기본값
		e[1] = new int[3];//2반 3명 : [0, 0, 0] 기본값
		
		try { //예외가 발생할 가능성이 있는 부분
			e[0][0] = 85;	e[0][1] = 99;
			e[0][2] = 77;	//1. 여기서 예외가 발생하면 -> JVM이 예외객체를 던져서
			e[1][0] = 88;	e[1][1] = 100;	e[1][2] = 95;	//★★★ 이 부분이 실행되지 않고
		}catch(Exception e1) {	//2. 예외가 발생하면(=예외객체가 생성되면) 잡아서
			e1.printStackTrace(); //3. 처리
		}finally {
			System.out.println("4.[방법-1]예외 발생 여부에 관계없이 try{}영역에 진입하면 무조건 실행");
			e[1][0] = 88;	e[1][1] = 100;	e[1][2] = 95;
		}
		
		//[방법-2]★★ 실행되도록 try{}안에서 빼냄
		e[1][0] = 88;	e[1][1] = 100;	e[1][2] = 95; 
		
		System.out.println(Arrays.toString(e[0]));//[85, 99]
		System.out.println(Arrays.toString(e[1]));//[0, 0, 0]
		
		System.out.println("--[과제-1] : e이 참조하는 배열--");
		//조건연산자 사용하여 출력
		for(i = 0; i < e.length; i++) {	
			
			System.out.print("[");
			
			for(j = 0; j < e[i].length; j++) {
				System.out.print((j == 0)? e[i][j] : ", " + e[i][j] );
			}
			System.out.println("]");
		}
		
		
		//기존 결과물
		/*
		for(i = 0; i < e.length; i++) {					//행
			System.out.print("[");
			for(j = 0; j < e[i].length; j++) {				//열
				if(j == 0) {
					System.out.print(e[i][j]);
				} else {
					System.out.print(", " +e[i][j]);
				}
			}
			System.out.println("]");  	//괄호 닫은 후 커서를 아래로 내림
		}
		System.out.println();  //구분위한 빈줄
		*/
		/****************** 2차원 배열 선언하는 방법-3 ************************/
		System.out.println("*** 2차원 배열 선언하는 방법-3 ***");
		int[][] s = new int[2][];
		
		s[0] = new int[] {87, 93};  //기본값이 아닌 '초기값 배열' 객체 생성
		s[1] = new int[] {97, 88, 100};  //
		
		System.out.println("--s가 참조하는 배열(조건연산자)");
		//조건연산자 사용하여 출력
		for(i = 0; i < s.length; i++) {	
			
			System.out.print("[");
			
			for(j = 0; j < s[i].length; j++) {
				//(조건문)?참:거짓;
				//System.out.print((j == 0)? s[i][j] : ", " + s[i][j] );
				
				//System.out.print((j == s[i].length-1)? s[i][j] : s[i][j] + ", ");
				
				System.out.print((j != s[i].length-1)? s[i][j] + ", " : s[i][j]);
				
			}
			System.out.println("]");
		}
		System.out.println();  //구분위한 빈줄
		
		
		System.out.println("--[과제-1] : s가 참조하는 배열 (향상된 for문)--");//??
		
		String result = "";
		
		for(int[] s_addr : s) {						//행 (s_addr : 배열의 주소값을 갖고 있음)
			System.out.print("[");
			for(int s_value : s_addr) {				//열
				result += s_value + ", ";
			}
			System.out.print(result.substring(0, result.length()-2));		//마지막 결과에서 , 제거
			result = "";	// 다음 배열값을 담기 전에 초기화
						
			System.out.println("]"); 		// 괄호를 닫으면서 커서를 아래로 내림
		}
		System.out.println();		//구분위한 빈 줄
		
		/****************** 2차원 배열 선언하는 방법-4 ************************/
		System.out.println("*** 2차원 배열 선언하는 방법-4 ***");
		int[][] java = {
						{95, 97},			//1반 2명. java[0].length == 2
						{98, 100, 99, 75},	//2반 4명. java[1].length == 4
						{100, 88, 92}		//3반 3명. java[2].length == 3
						};
		
		/**
		 * 7-2 [과제-2] 각 반의 java 성적의 합과 평균 구하기
		 * 			   java 성적의 총 합과 총 평균 구하기
		 */
		System.out.println("--[과제-2] : 각 반 java 성적의 합과 평균 구한 뒤 모든 반의 성적 총합과 총평균 출력");
		
		int javaClass_SumScore = 0;
		double javaClass_AvgScore = 0;
				
		int cntStudent = 0;		//전체 학생 수 
		int totalSumScore = 0;		//모든 반의 성적 총 합
		double totalAvgScore = 0;	//모든 반의 성적 총 평균
		
		for(i = 0; i < java.length; i++) {	
			
			//javaClass_SumScore = 0;		//다음 성적 총합값을 받기 전에 초기화
			//javaClass_AvgScore = 0;		//다음 성적 평균값을 받기 전에 초기화
			
			for(j = 0; j < java[i].length; j++) {		//반 별 학생 수 만큼 반복
				javaClass_SumScore += java[i][j];
			}
			
			javaClass_AvgScore += ((double)javaClass_SumScore / java[i].length);	// 반 평균(java[i].length = 반 학생 수)
			
			System.out.println((i + 1) + "반의 성적 총합 = " + javaClass_SumScore + "\t평균 = " + javaClass_AvgScore);
			
			totalSumScore += javaClass_SumScore;
			cntStudent += java[i].length;				//반 별 학생 수(각 배열의 길이)을 모두 더해 전체 학생수를 구함.
			
			javaClass_SumScore = 0;		//다음 성적 총합값을 받기 전에 초기화
			javaClass_AvgScore = 0;		//다음 성적 평균값을 받기 전에 초기화
		}
		totalAvgScore += ((double)totalSumScore / cntStudent);
		
		System.out.println("모든 반 성적 총합=" + totalSumScore + "\t모든 반 총 평균=" + totalAvgScore);
		
	}

}
