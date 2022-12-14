/**
 * 컬렉션 프레임워크 : 배열의 문제점을 해결하고 널리 알려진 자료구조를 바탕으로
 * 				 '객체들을 효율적으로 추가, 삭제, 검색'할 수 있도록
 * 				 java.util 패키지에 컬렉션과 관련된 인터페이스와 클래스들을 포함시켜 놓고
 * 				 이들을 총칭해서 '프레임워크'라고 부름
 * 				 (반드시 객체만 관리)
 * 
 * 						'Collection' 인터페이스
 * 									|
 * 			|------------------------------------------------|
 * 		List 인터페이스										Set 인터페이스								Map 인터페이스
 * 			|												 |										|
 * 	 배열과 유사하여 index로 관리								index로 관리X						 	키와 값의 쌍(=엔트리)으로 저장
 *   -> 순서를 유지하면서 저장								  -> 순서없이 저장							 키와 값 : 객체
 *   	중복 저장 가능										중복 저장 불가능(집합)					 키 : 중복X, 값:중복O
 *   		|												 |										|
 *   	   클래스												클래스								   클래스
 *   	 ArrayList										  HashSet								HashMap : 싱글쓰레드 (※HashTable : 멀티쓰레드)
 * 		 Vector											  TreeSet								TreeMap
 * 		 LinkedList																				
 * 
 * 	Stack extends Vector implements List<E> (예제:stack.cd 패키지 참조)
 *  -------------------------------------------------------------------------------------------------
 *   List 인터페이스를 구현한 클래스
 *    <공통점> 1. 배열과 유사하여 index로 관리 -> 순서를 유지하면서 저장
 *    			=> for문 사용가능
 *    		 2. 중복 저장 가능
 *    
 *   1. ArrayList  : (1) 앞에서부터 차례대로 추가나 검색할 때 효율적
 *   				 (2) 추가나 삭제가 빈번히 일어나는 곳에서는 비효율적 -> 속도가 느리다.
 *   				 '싱글 쓰레드'에 사용
 *   2. Vector     : (1)(2)ArrayList와 특징이 같다. (단, 멀티쓰레드에 사용)
 *   
 *   3. LinkedList : (1) 앞에서부터 검색할 때 비효율적
 *   				 (2) 추가나 삭제가 빈번히 일어나는 곳에서는 효율적 -> 속도가 빠르다.
 *  -------------------------------------------------------------------------------------------------
 * [Queue 인터페이스]
 * Queue : '선착순'
 * 			줄을 선 대기열처럼 먼저 추가된 데이터부터 꺼내서 사용하는 방식 (FIFO : First In First Out)
 * 
 * LinkedList : List<E>, Queue<E> 인터페이스 구현함 (예제:queue.mail 패키지 참조)
 */
package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ArrayListExample {

	public static void main(String[] args) {
		/* 
		 * 부모 인터페이스 = 자식객체가 부모타입(List)으로 자동형변환되어 대입 - upcasting
		 * 컴파일러 입장 : 모든 자식객체들을 부모타입인 List로 인식하여
		 * 			   List에 선언된 메서드들만 호출할 수 있다.
		 * 
		 * 그런데 자식 클래스들을 클래스의 특징에 맞게 추상메서드를 재정의하였으므로
		 * 재정의된 메서드가 호출됨
		 */
		List<String> list = new ArrayList<String>();
		//ArrayList<String> list = new ArrayList<String>();
		//LinkedList<String> list = new LinkedList<String>();
		//Vector<String> list = new Vector<String>();
		
		for(String str:list) {
			System.out.println(str);
		}
		
		System.out.println("************** [추가 후 값을 얻기] **************");	
		list.add("여러분~");	//index 0
		list.add("힘내세요~");	//index 1 -> 2
		list.add("^^");		//index 2 -> 3
		
		list.add(1, "모두");	//index 1 => Set계통에는 이 메서드가 없음(index로 관리안하므로...)
		list.add("여러분~");	//index 4 =>중복 허용
		
		System.out.println("저장된 총 객체 수 : " + list.size());
		
		if(list.contains("모두")) { //주어진 객체가 저장되어 있으면 true, 없으면 false
			System.out.println("\"모두\"가 존재한다.");
		}else System.out.println("\"모두\"가 존재하지 않는다.");
		
		System.out.println(); //구분용 빈 줄

		System.out.print("List객체의 주소만으로도 값이 출력됨");
		/* list.toString()호출 -> 각 객체(ArrayList)에서 재정의된 toString()호출 
		   -> String의 재정의된 toString()호출 */
		System.out.println(list); //[여러분~, 모두, 힘내세요~, ^^, 여러분~]
		
		System.out.println(); //구분용 빈 줄
		
		//get(index) : 해당 index의 값 얻기 => Set계통에는 이 메서드가 없음(index로 관리안하므로...)
		System.out.println("index 2의 값 : " + list.get(2));
		
		System.out.println("-- for문으로 모든 객체값 출력 --");
		int i;
		for(i = 0; i < list.size() ; i++) { //=> Set계통에는 이 for문 사용X(index로 관리안하므로...)
			System.out.println("index " + i + "의 값 : " + list.get(i));
		}
		
		System.out.println(); //구분용 빈 줄
		
		/*
		 * 향상된 for문 : index로 값을 접근하지 않으므로 값을 참조할 때만 사용함
		 * 			   값을 변경할 때는 사용불가(이유?값을 변경하려면 index가 필요함)
		 */
		System.out.println("-- 향상된 for문으로 모든 객체값 출력 --");
		for(String str:list) {	//=> Set계통에는 향상된 for문 사용
			System.out.println(str);
		}
		
		System.out.println(); //구분용 빈 줄
		
		System.out.println("-- Iterator로 모든 객체값 출력 --");
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println(); // 커서 내림..
		
		System.out.println("****************** [삭제] ******************");
		System.out.println("-- 삭제-1(index 이용) --");  //=> Set계통에는 이 메서드가 없음(index로 관리안하므로...)
		System.out.println("index 1에서 삭제한 문자열 : " + list.remove(1));
		
		System.out.println(); //구분용 빈 줄
		
		System.out.println("-- 삭제-2(Object 이용) --");
		if(list.remove("정말~")) {
			System.out.println("찾아서 있으면 삭제 후 true -> 삭제됨.");
		}else System.out.println("찾아서 없으면 false -> 삭제안됨.");
		
		//remove(Object 타입이므로 모든객체 다 수용, 그러나 String이외 객체는 노란줄로 경고 띄움)
		if(list.remove(new Integer(1))) {
			System.out.println("찾아서 있으면 삭제 후 true -> 삭제됨.");
		}else System.out.println("찾아서 없으면 false -> 삭제안됨.");
		
		System.out.println(); //구분용 빈 줄
		
		System.out.println("-- 모두 삭제 --");
		if(list.removeAll(list)) {
			System.out.println("모두 삭제");
		}else System.out.println("모두 삭제 안됨");
		
		System.out.println(); //구분용 빈 줄
		
		list.clear(); //clear()로 모두삭제하면 반환타입이 void이므로 삭제되었는지 확인하려면
		System.out.println("저장된 총 객체 수 : " + list.size()); //[방법-1]
		
		if(list.isEmpty()) { 		//isEmpty() : List(ArrayList, Vector, LinkedList)가 비어있는지 확인
			System.out.println("저장된 객체가 없음. 비어있음");
		}else System.out.println("저장된 객체가 있음.");
		
	}

}
