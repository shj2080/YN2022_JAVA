/**
 * [Map 인터페이스] Map은 중복을 허용하지 않는 Key와 중복이 가능한 Value가 각각 쌍을 이루어 저장되는 자료구조이다. 
 * 1. 키와 값으로 구성된 Map.Entry 객체를 생성
 * 2. 키와 값은 모두 객체
 * 3. 키 : 중복X , 값 : 중복O
 * 4. 만약 기존에 저장된 키와 동일한 키로 값을 저장하면 기존의 값은 없어지고 새로운 값으로 대체된다.
 * 
 * HashMap : 싱클쓰레드(※ HashTable : 멀티쓰레드)
 * TreeMap
 */

package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		// <키,값>Map 컬렉션 생성
		HashMap<Integer, String> map = new HashMap<Integer, String>();

		// 객체 추가
		map.put(new Integer(6), "홍길동");
		map.put(3, "이순신"); // 자동 Boxing되어 Integer객체로 바뀌어서 들어감
		map.put(7, "김구");

		System.out.println("저장된 총 Entry 객체수 : " + map.size());// 3
		// 4. 만약 기존에 저장된 키와 동일한 키로 값을 저장하면 기존의 값은 없어지고 새로운 값으로 대체된다.
		map.put(6, "유관순");
		System.out.println("저장된 총 Entry 객체수 : " + map.size());
		System.out.println("6의 이름 : " + map.get(6)); // 유관순(int ->자동 Boxing되어 'Integer객체'-> Object객체
		System.out.println();// 구분위한 빈줄

		System.out.println("[map 주소만 값이 출력] : " + map);// {3=이순신, 6=유간순, 7=김구}

		System.out.println("** 저장된 전체 객체를 대상으로 키와 값을 얻고 싶을 때 (4가지 방법) **");
		/*---------------------------keySet() -> 향상된 for, 반복자 Iterator-------------------------------*/
		// keySet()메서드로 '모든 키만' 얻어 Set객체로 담아
		Set<Integer> kset = map.keySet();// 3 6 7

		System.out.println("[방법-1] : keySet() -> 향상된 for문");
		for (Integer key : kset) {// 3
			System.out.println(key + "번의 이름은 " + map.get(key));
		}

		System.out.println();// 구분위한 빈줄

		System.out.println("[방법-2] : keySet() -> 반복자 Iterator 이용");
		Iterator<Integer> itr = kset.iterator();
		while (itr.hasNext()) {// Set안에 키가 있으면
			Integer key = itr.next();// 하나씩 키를 가져와

			// System.out.println(key+"번의 이름은 "+map.get(key));

			String value = map.get(key);
			System.out.println(key + "번의 이름은 " + value);

		}
        System.out.println();// 구분위한 빈줄
        
		/*---------------------------entrySet() -> 향상된 for, 반복자 Iterator-------------------------------*/
		// entrySet()메서드로 '모든 키와 값인 Map.Entry' 얻어 Set객체로 담아
		Set<Entry<Integer, String>> eSet = map.entrySet();

		System.out.println("[방법-3] : entrySet() -> 향상된 for문");
		for (Entry<Integer, String> entry : eSet) {
			System.out.println(entry.getKey() + "번의 이름은 " + entry.getValue());
		}
		System.out.println("");// 구분위한 빈줄

		System.out.println("[방법-4] : entryset() -> 반복자 Iterator 이용");
		Iterator<Entry<Integer, String>> eitr = eSet.iterator(); // <키,값>Entry 반복자를 통해
		while(eitr.hasNext()) {
		Entry<Integer, String> entry= eitr.next();//Map.Entry하나씩 얻어와 
		System.out.println(entry.getKey() + "번의 이름은 " + entry.getValue()); // 키와 값 출력
		}
		System.out.println();//구분위한 빈줄

		System.out.println("****** 저장된 전체 객체를 대상으로 삭제하는 방법 ******");
		System.out.println("3번 객체 삭제 후 값을 리턴 : " + map.remove(3));
		
		map.clear();//객체 전체 삭제
		System.out.println("저장된 총 Entry 객체수 : " + map.size()); //0
		
		if(map.isEmpty()) System.out.println("모두 삭제되어 비어있음");
		else System.out.println("비어있지 않음");
		
	}

}
