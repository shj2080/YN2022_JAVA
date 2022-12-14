/* 
 *   3. LinkedList : (1) 앞에서부터 검색할 때 비효율적
 *   				 (2) 추가나 삭제가 빈번히 일어나는 곳에서는 효율적 -> 속도가 빠르다.
 *   
 *   ※	LinkedList는 다른 List계통보다 다양한 메서드를 제공한다. 
 */
package list;

import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("A");
		list.add("B");
		list.add("C");
		
		System.out.println(list); //[A, B, C]
		
		list.add(1, "D");
		System.out.println(list); //[A, D, B, C]
		
		/*---------------------------------------------------*/
		
		list.addFirst("E");
		System.out.println(list); //[E, A, D, B, C]

		list.addLast("F");
		System.out.println(list); //[E, A, D, B, C, F]
		
		System.out.println("첫번째 값(삭제)=" + list.removeFirst());
		System.out.println(list); //[A, D, B, C, F]
		
		System.out.println("마지막 값(삭제)=" + list.removeLast());
		System.out.println(list); //[A, D, B, C]
		
	}

}
