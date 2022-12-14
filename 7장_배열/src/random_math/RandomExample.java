package random_math;

import java.util.Arrays;
import java.util.Random;

public class RandomExample {

	public static void main(String[] args) {
		//선택번호
		int[] sn = new int[6]; //[0,0,0,0,0,0] 선택번호 6개 모두 0으로 채워짐
		
		/****************************************************************
		 * Random 클래스
		 * r.nextInt();		int 타입 전 범위에서 난수 발생
		 * 
		 * 0   <=	r.nextInt(int n); < n	(int형 난수 발생)
		 * 
		 * 0   <=	r.nextInt(100); < 100   (0~99 난수 발생)
		 * 0   <=	r.nextInt(101)+0; < 101   (0~100 난수 발생)
		 * 
		 * 0   <=	r.nextInt(45); < 45   (0~44 난수 발생)
		 * 0+1 <=	r.nextInt(45)+1; < 45+1   (1~45 난수 발생)
		 * 
		 * 		r.nextInt(6)+1;		      (1~6 난수 발생)
		 * 		r.nextInt(99-10+1)+10;				  (10~99 난수 발생)
		 * 
		 * ★★ "시작~끝" 난수 발생
		 *    r.nextInt(끝-시작+1)+시작;
		 * 
		 ****************************************************************/
		//선택번호를 랜덤하게 얻기 위한 Random 객체 생성
		//Random r = new Random(seed); //Random 객체 생성 방법-1 : seed가 같으면 같은 난수 발생
		
		Random r = new Random(); //Random 객체 생성 방법-2
		
		System.out.print("선택번호 > ");
		
		int i;
		for(i = 0; i < sn.length; i++) {
			sn[i] = r.nextInt(45)+1;	//1부터 시작해서 45개(정수1~45 중 랜덤으로 발생시켜 배열에 저장)
		}
		System.out.println(Arrays.toString(sn));
		
		//당첨번호
		int[] wn = new int[6]; //[0,0,0,0,0,0] 선택번호 6개 모두 0으로 채워짐
		long seed = System.currentTimeMillis(); //현재 시간으로 seed 값이 주어지면 계속 변경되어 난수도 바뀜
		Random r2 = new Random(seed); //long타입의 seed값 주면 랜덤으로 같은 값들이 생성
		
		System.out.print("당첨 번호 > ");
		
		for(i = 0; i < wn.length; i++) {
			wn[i] = r2.nextInt(45)+1;	//1부터 시작해서 45개(정수1~45 중 랜덤으로 발생시켜 배열에 저장)
		}
		System.out.println(Arrays.toString(wn));
		
		//당첨 여부
		System.out.print("당첨 여부 > ");
		if(Arrays.equals(sn, wn)) System.out.println("1등에 당첨되었습니다.");
		else System.out.println("당첨되지 않았습니다.");
		
		/**
		 * 이진 '탐색' : 반드시 정렬 -> 정렬된 데이터를 대상으로 탐색하는 알고리즘
		 * 이를 이용하여 배열의 특정 숫자가 포함되었는지 여부와
		 * 만일 포함되어 있지 않다면 그 숫자의 적절한 위치까지 찾아주는 것이 가능하다.
		 */
		System.out.println("----- 이진 탐색 --------------");
		//1. 먼저, 정렬
		Arrays.sort(wn); //오름차순 정렬
		System.out.println(Arrays.toString(wn));
		
		//2. binarySearch(배열, 찾을값) : 정렬된 배열에서 16을 찾아서 index번호를 리턴해줌
		int idx = Arrays.binarySearch(wn, 16);
		System.out.println("16은(는) " + (idx+1) + "번째로 작은 값이다.");
		
		/**
		 * binarySearch(배열, 찾을값) : 정렬된 배열에서 값을 찾아서 index번호를 리턴해줌
		 * 							찾을 값이 없으면 찾을값보다 큰 최초의 값 위치를 리턴?
		 * 
		 * binarySearch(배열, 2) : 찾을값(4)가 없으므로 4보다 큰 최초의 값(5)의 위치는 2
		 * 						 그 위치*(-1)-1 리턴
		 * 							2*(-1)-1=-3
		 * 
		 * { 1		 3		 5	}에서 찾는다면
		 * { 1  (2)  3  (4)  5	}
		 *   0  (-2) 1  (-3) 2	<- index번호
		 */
		
		int[] arr = {5, 1, 3};
		System.out.println(Arrays.toString(arr) + "에서");
		//1. 먼저 정렬
		Arrays.sort(arr);//[1,3,5]
		
		//2. binarySearch(배열, 찾을값)
		idx = Arrays.binarySearch(arr, 3);
		if(idx >= 0) {
			System.out.println("3은(는) " + (idx+1) + "번째로 작은 값이다.");
		}else System.out.println("찾을 값이 없습니다.");
				
		//찾을 값이 없는 (예-1)
		idx = Arrays.binarySearch(arr, 2);
		
		if(idx >= 0) {
			System.out.println("2은(는) " + (idx+1) + "번째로 작은 값이다.");
		} else System.out.println("찾을 값 2가 없습니다. 2의 위치 = " + idx);//-2
		
		//찾을 값이 없는 (예-2)
		idx = Arrays.binarySearch(arr, 4);
		
		if(idx >= 0) {
			System.out.println("4은(는) " + (idx+1) + "번째로 작은 값이다.");
		} else System.out.println("찾을 값 4가 없습니다. 4의 위치 = " + idx);//-3
		
		System.out.println("-----------------------------------------");
		for(i = 0; i < 10; i++) {
			System.out.println(i+"의 위치값="+Arrays.binarySearch(arr, i));
		}
		
	}

}
