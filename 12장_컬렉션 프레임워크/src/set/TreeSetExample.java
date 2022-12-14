/**
 * [HastSet과 TreeSet]
 * ※ 공통점 : Set계통이므로 모두 중복을 허용하지 않고 순서가 없는 컬렉션이다.
 * 
 * (1) 구현방식 -HashSet : '해싱'을 이용하여 구현
 * 			  -TreeSet : '이진탐색트리'를 이용하여 구현
 * 
 * (2) 속도비교 - HashSet > TreeSet
 * 			 - 해싱이 이진탐색트리보다 빠르다.
 * 			 - 해싱값을 이용하여 검색하기 때문에 검색하는 범위가 엄청 줄어들게 되어 검색 속도가 매우 빠르다.
 * 			(HashSet은 Set계통에서 가장 빠른 데이터 접근 속도를 가지고 있다.)
 * 
 * (3) 정렬기능 - HashSet < TreeSet
 * 			 - 이진탐색트리를 이용했기 때문에 데이터 정렬이 가능(Comparable 인터페이스 이용)
 * 
 * ------------------------------------------------------------------------------------
 */
package set;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		
		/*
		 * Integer는 Comparable<T>인터페이스를 구현한 클래스이므로
		 * add()할 때마다 '재정의된 compareTo()'자동호출되어
		 * -> 크기 비교하면서 오름차순 정렬시켜 저장
		 */
		treeSet.add(new Integer(87));
		treeSet.add(95); //자동 Boxing
		treeSet.add(78); //자동 Boxing
		treeSet.add(98); //자동 Boxing
		treeSet.add(80); //자동 Boxing
		treeSet.add(83); //자동 Boxing		
		
		treeSet.add(78); //Set계통은 중복 허용하지 않음 -> 추가 안 됨
		
		System.out.println("저장된 총 객체 수 : " + treeSet.size());		//6
		/**
		 * treeSet.toString()호출
		 * ->저장된 각 Integer객체의 toString()호출	[주소1.toString(), 주소2.toString()]
		 */
		System.out.println("주소만(오름차순 정렬) : " + treeSet); //[78, 80, 83, 87, 95, 98]
		
		System.out.println("주소만(내림차순 정렬) : " + treeSet.descendingSet());	//[98, 95, 87, 83, 80, 78]
		
		System.out.println(); //구분위한 빈 줄
		
		/********************************************************************/
		System.out.println("-------------- [검색과 관련된 메서드들] --------------");
		System.out.println("가장 낮은 객체 리턴(=가장 낮은 점수) : " + treeSet.first());
		System.out.println("가장 높은 객체 리턴(=가장 높은 점수) : " + treeSet.last());
		
		System.out.println("주어진 객체 95보다 바로 아래 작은 객체 리턴 : " + treeSet.lower(95)); //87
		System.out.println("주어진 객체 95보다 바로 위  큰 객체 리턴 : " + treeSet.higher(95)); //98
		
		System.out.println("주어진 객체 96과 같은 객체가 있으면 리턴. 만약 없으면 주어진 객체 96보다 바로 아래 작은 객체 리턴 : " + treeSet.floor(96)); //95
		System.out.println("주어진 객체 94와 같은 객체가 있으면 리턴. 만약 없으면 주어진 객체 94보다 바로 위  큰 객체 리턴 : " + treeSet.ceiling(94)); //95
		
		System.out.println("-------------- [범위 검색과 관련된 메서드들] --------------");
		SortedSet<Integer> treeSetSub1 = treeSet.subSet(78, 95);
		System.out.print("78 <= 찾는 점수 < 95 : ");
		for(Integer i:treeSetSub1) {
			System.out.print(i + " "); //78 80 83 87 
		}
		System.out.println(); //커서 아래로
		
		//subSet() true,false 의미 : 찾으려는 값을 포함 여부 결정함
		NavigableSet<Integer> treeSetSub2 = treeSet.subSet(78, true, 95, true);
		System.out.print("78 <= 찾는 점수 <= 95 : ");
		for(Integer i:treeSetSub2) {
			System.out.print(i + " "); //78 80 83 87 95
		}
		System.out.println(); //커서 아래로
		
		System.out.println("---------------------------------------------------");
		
		System.out.println("** [오름차순 Iterator 리턴] **");
		Iterator<Integer> itr = treeSet.iterator(); //오름차순 반복자
		while(itr.hasNext()) {
			System.out.print(itr.next() + " "); //Integer(78)의 toString() 호출 결과 출력
		}
		System.out.println(); //커서 아래로
		
		System.out.println("** [내림차순 Iterator 리턴] **");
		Iterator<Integer> ditr = treeSet.descendingIterator(); //내림차순 반복자
		while(ditr.hasNext()) {
			System.out.print(ditr.next() + " "); //Integer(98)의 toString() 호출 결과 출력
		}
		System.out.println(); //커서 아래로
		
		/***************************************************************************/
		
		System.out.println("** [내림차순 정렬된 NavigableSet을 리턴] **");
		NavigableSet<Integer> dSet = treeSet.descendingSet();
		System.out.println("-- 1. 향상된 for문 이용 --");
		for(Integer score:dSet) {
			System.out.print(score + " ");
		}
		System.out.println(); //커서 내림
		
		System.out.println("-- 2. Iterator(=반복자) 이용 --");
		Iterator<Integer> dSetItr = dSet.iterator();
		while(dSetItr.hasNext()) {
			System.out.print(dSetItr.next()+" ");
		}
		System.out.println();//커서를 아래로
		
		System.out.println("** [내림차순 정렬된 NavigableSet을 descendingSet()으로 한번 더 호출하면 오름차순 정렬됨] **");
		NavigableSet<Integer> aSet = dSet.descendingSet();//내림차순 정렬 한번 더 하면 => 오름차순 정렬됨
		
		System.out.println("-- 1. 향상된 for문 이용 --");
		for(Integer score:aSet) {
			System.out.print(score+" ");
		}
		System.out.println();//커서를 아래로
		
		System.out.println("-- 2. Iterator(=반복자) 이용 --");
		Iterator<Integer> aSetItr = aSet.iterator();
		while(aSetItr.hasNext()) {
			System.out.print(aSetItr.next()+" ");
		}
		System.out.println();//커서를 아래로
		
		//System.out.print("제일 낮은 객체부터 꺼내오고 제거한 순서 : ");
		System.out.print("제일 높은 객체부터 꺼내오고 제거한 순서 : ");
		while(!treeSet.isEmpty()) {
			//System.out.print(treeSet.pollFirst() + " "); //제일 낮은 객체부터 꺼내오고 treeSet 컬렉션에서 제거함
			System.out.print(treeSet.pollLast() + " "); //제일 높은 객체부터 꺼내오고 treeSet 컬렉션에서 제거함
		}
		System.out.println(); //커서 아래로
		
		if(treeSet.isEmpty()) System.out.println("모두 삭제되어 비어있음");
		else System.out.println("비어있지 않음");
		
		/***************************************************************************/
		
		System.out.println("----------------------- [범위 검색] ---------------------------");
		
		TreeSet<String> treeSet2 = new TreeSet<String>();
		
		/*
		 * String은 Comparable<T>인터페이스를 구현한 클래스이므로
		 * add()할 때마다 '재정의된 compareTo()'자동호출되어
		 * -> 크기 비교하면서 오름차순 정렬시켜 저장
		 */
		treeSet2.add("banana");
		treeSet2.add("cherry");
		treeSet2.add("apple");
		treeSet2.add("black");
		treeSet2.add("school");
		treeSet2.add("door");
		treeSet2.add("element");
		
		treeSet2.add("e");
		
		//정렬되어 출력됨
		System.out.println(treeSet2); //[apple, banana, black, cherry, door, element, school]
		
		System.out.print("b~e 사이의 단어 검색 : ");
		// 시작객체 "b" <= 찾는 객체 <= 끝객체"e"(★★주의 단, element 제외-이유?e보다 element가 코드값이 크기 때문에)
		// "element" 포함하려면 아래 주석처리된 subSet 사용
		//NavigableSet<String> set = treeSet2.subSet("b", true, "em", true);
		NavigableSet<String> set = treeSet2.subSet("b", true, "e", true);
		System.out.println(set); //[banana, black, cherry, door, e]
		
		System.out.println();  	//구분위한 빈줄
		
		System.out.println("-------------------------------------------------");
		
		System.out.print("지정된 객체보다 작은 값의 객체들을 반환 [방법-1] : ");
		SortedSet<String> set2 = treeSet2.headSet("banana");
		System.out.println(set2); // [apple]

		System.out.print("지정된 객체보다 작은 값의 객체들을 반환 [방법-2] : ");
		NavigableSet<String> set2_2 = treeSet2.headSet("banana", false); //NavigableSet 리턴
		System.out.println(set2_2); // [apple]
		
		System.out.print("지정된 객체를 포함하여 보다 작은 값의 객체들을 반환 : ");
		NavigableSet<String> set2_3 = treeSet2.headSet("banana", true);
		System.out.println(set2_3); // [apple, banana]
		
		System.out.println(); //구분 빈 줄
		
		System.out.print("지정된 객체보다 큰 값의 객체들을 반환 [방법-1] : ");
		SortedSet<String> set3 = treeSet2.tailSet("ba");
		System.out.println(set3); 	// [banana, black, cherry, door, e, element, school]

		System.out.print("지정된 객체보다 큰 값의 객체들을 반환 [방법-2] : ");
		NavigableSet<String> set3_2 = treeSet2.tailSet("ba", false);
		System.out.println(set3_2); // [banana, black, cherry, door, e, element, school]
		
		System.out.print("지정된 객체를 포함하여 보다 큰 값의 객체들을 반환 : ");
		NavigableSet<String> set3_3 = treeSet2.tailSet("ba", true);
		System.out.println(set3_3); // [banana, black, cherry, door, e, element, school]

		System.out.println(); //구분 빈 줄
		
		System.out.print("지정된 객체보다 큰 값의 객체들을 반환 [방법-1] : ");
		SortedSet<String> set4 = treeSet2.tailSet("bz");
		System.out.println(set4); 	// [cherry, door, e, element, school]
		
		System.out.print("지정된 객체보다 큰 값의 객체들을 반환 [방법-2] : ");
		NavigableSet<String> set4_2 = treeSet2.tailSet("bz", false);
		System.out.println(set3_2); // [banana, black, cherry, door, e, element, school]
		
		System.out.print("지정된 객체를 포함하여 보다 큰 값의 객체들을 반환 : ");
		NavigableSet<String> set4_3 = treeSet2.tailSet("bz", true);
		System.out.println(set4_3); // [cherry, door, e, element, school]
		
		System.out.println(); //구분 빈 줄
		
		treeSet2.removeAll(treeSet2); //boolean 리턴
		System.out.println("총 객체 수 : " + treeSet2.size()); //0
	}

}
