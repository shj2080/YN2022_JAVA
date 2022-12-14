/**
 * ArraysList : 배열처럼 선언과 동시에 초기화 불가능하다. (기본값인 null로 채워짐)
 * 				그러나 '추가나 삭제를 위한 메서드'를 통해 쉽게 해결 가능함
 * 
 * Arrays	  : 배열을 조작하기 위한 클래스
 * 				배열처럼 '선언과 동시에 초기화' 가능하다.
 * 				그러나 추가나 삭제를 위한 메서드가 없음 
 * 
 * 그래서 '배열처럼 선언과 동시에 초기화' 되면서
 * ArrayList처럼 추가나 삭제를 위한 메서드를 사용'할 수 있도록
 * 아래 소스에서 방법을 알려주겠다..
 * 
 * 즉, ArrayList도 선언과 동시에 초기화하는 방법을 알아보겠다.
 */
package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysAsList {

	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("서동규", "손주환", "여환영");
		
		list1 = new ArrayList<String>(list1);
		
		System.out.println("-- 향상된 for문 사용 --");
		for(String str:list1) {
			System.out.println(str);
		}
		
		System.out.println("===========================");
		
		List<Integer> list2 = Arrays.asList(1, 2, 3); //기본타입(int) -> 자동 Boxing되어 Integer타입으로 변환
		List<Integer> list3 = Arrays.asList(new Integer(1), new Integer(2), new Integer(3)); //기본타입(int) -> 자동 Boxing되어 Integer타입으로 변환		
		
		list3 = new ArrayList<Integer>(list3); //초기화 + 추가나 삭제 메서드 사용가능
		
		System.out.println("-- 향상된 for문 사용 --");
		for(Integer value:list3) { //value : 주소
			System.out.print(value + " "); //value.toString()호출 -> 리턴 결과 출력
		}

		System.out.println(); //커서 아래로
		
		for(int value:list3) { //value : 값 (Integer객체 -> 자동UnBoxing되어 int(기본타입:값))
			System.out.print(value + " "); //값이 출력
		}
		System.out.println(); //커서 아래로
		
		
		
	}

}
