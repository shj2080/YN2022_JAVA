/*
 * ArrayList와 LinkedList의 속도차를 확인
 * - index 0에 추가나 삭제가 빈번히 일어나는 상황
 * 
 * 결과 : LinkedList가 빠른 성능을 낸다.
 */
package list;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayList_LinkedList_Example {

	public static void main(String[] args) {
		//둘다 사용방법은 같지만 내부 구조는 완전 다르다.
		ArrayList<String> list1 = new ArrayList<String>();
		LinkedList<String> list2 = new LinkedList<String>();
		
		long startTime; //시간 측정위해 시작시간과
		long endTime;	//끝시간 변수
		System.out.println("--------- ArrayList ---------");
		startTime = System.nanoTime(); //시작시간 = 나노타임 저장
		
		int i;
		for(i = 0; i < 10000; i++) { //index 0 ~ 9999 까지
			//(0, "0") -> (0, "1")(1, "0") -> (0, "2")(1, "1")(2, "0") ... 10000번 반복
			list1.add(0, String.valueOf(i)); //리스트의 index 0에 10000번 문자열이 추가되면서 저장됨
		}
		
		endTime = System.nanoTime(); //for문 수행 후, 끝 시간 = 나노타임 저장
		System.out.println("ArrayList 걸린 시간 : " + (endTime-startTime) + "ns");

		System.out.println("--------- LinkedList ---------");
		startTime = System.nanoTime(); //시작시간 = 나노타임 저장
		
		for(i = 0; i < 10000; i++) {
			//(0, "0") -> (0, "1")(1, "0") -> (0, "2")(1, "1")(2, "0") ... 10000번 반복
			list2.add(0, String.valueOf(i)); //리스트의 index 0에 10000번 문자열이 추가되면서 저장됨
		}
		
		endTime = System.nanoTime(); //for문 수행 후, 끝 시간 = 나노타임 저장
		System.out.println("LinkedList 걸린 시간 : " + (endTime-startTime) + "ns");
		
		//결과는 cpu의 상황에 따라 다르게 나올 수 있다.
	}

}
