package map;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapExample {

	public static void main(String[] args) {
		//Tree: 검색, 정렬 + Map:<키,값>Entry
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
		treeMap.put(new Integer(89), "이순신");
		treeMap.put(95, "홍길동");
		treeMap.put(78, "김유신");
		treeMap.put(98, "유관순");
		treeMap.put(80, "김구");
		treeMap.put(83, "강감찬");
		
		System.out.println("저장된 총 Entry 객체 수 : " + treeMap.size());
		
		treeMap.put(78, "유재석"); //같은 키 : "김유신"->"유재석"
		System.out.println("저장된 총 Entry 객체 수 : " + treeMap.size());
		
		System.out.println("[map 주소만(key로 오름차순 정렬)]" + treeMap);
		//{78=유재석, 80=김구, 83=강감찬, 89=이순신, 95=홍길동, 98=유관순}
		
		System.out.println("*****************************************************");
		System.out.println("-------------- [검색과 관련된 메서드들] --------------");
		Integer firstKey = treeMap.firstKey();
		
		System.out.println("가장 낮은 객체 리턴(=가장 낮은 점수) [방법-1]: " + firstKey + "," + treeMap.get(firstKey));//78,"유재석"
		//System.out.println("가장 낮은 객체 리턴(=가장 낮은 점수) [방법-1]: " + treeMap.firstKey() + "," + treeMap.get(treeMap.firstKey()));
		
		Entry<Integer, String> firstEntry = treeMap.firstEntry();
		System.out.println("가장 낮은 객체 리턴(=가장 낮은 점수) [방법-2]: " + firstEntry.getKey() + "," + firstEntry.getValue());
		//System.out.println("가장 낮은 객체 리턴(=가장 낮은 점수) [방법-2]: " + treeMap.firstEntry().getKey() + "," + treeMap.firstEntry().getValue());
		
		//98,"유관순"
		Integer lastKey = treeMap.lastKey();
		
		System.out.println("가장 높은 객체리턴(=가장 높은 점수) [방법-1]: " + lastKey + "," + treeMap.get(lastKey));
		
		Entry<Integer, String> lastEntry = treeMap.lastEntry();
		System.out.println("가장 높은 객체리턴(=가장 높은 점수) [방법-2]: " + lastEntry.getKey() + "," + lastEntry.getValue());
		
		System.out.println(); //구분용 빈 줄
		
		Entry<Integer, String> lowerEntry = treeMap.lowerEntry(95);
		System.out.println("주어진 key객체 95보다 바로 아래 Entry객체 리턴(=95점 바로 아래 점수와 이름):" + lowerEntry.getKey() + "," + lowerEntry.getValue());

		Entry<Integer, String> higherEntry = treeMap.higherEntry(95);
		System.out.println("주어진 key객체 95보다 바로 위 Entry객체 리턴(=95점 바로 위 점수와 이름):" + higherEntry.getKey() + "," + higherEntry.getValue());
		
		Entry<Integer, String> floorEntry = treeMap.floorEntry(96);
		System.out.println("주어진 key객체인 96과 같은 key객체가 있으면 해당Entry객체 리턴. 만약 없으면 주어진 key객체인 96보다 바로 아래 Entry개체 리턴:" + floorEntry.getKey() + "," + floorEntry.getValue());
		
		Entry<Integer, String> ceilingEntry = treeMap.ceilingEntry(94);
		System.out.println("주어진 key객체인 94와 같은 key객체가 있으면 해당Entry객체 리턴. 만약 없으면 주어진 key객체인 94보다 바로 위 Entry개체 리턴:" + ceilingEntry.getKey() + "," + ceilingEntry.getValue());
		
		System.out.println(); //구분용 빈 줄
		
		System.out.println("-------------- [범위 검색과 관련된 메서드들] --------------");
		/*
		 * SortedMap<K, V> subMap(K fromKey, V toKey)
		 * 						시작(포함)~끝(포함X) 이전까지의 부분집합 반환
		 * 
		 * NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)
		 * 							시작 (포함여부 선택 가능) ~ 끝 (포함여부 선택 가능) 까지의 부분집합 반환
		 * 								※ 포함: true, 포함x: false
		 */
		SortedMap<Integer, String> treeMapSub1 = treeMap.subMap(78, 95);
		System.out.println("78 <= 찾는 점수 < 95");
		Set<Entry<Integer, String>> set1 = treeMapSub1.entrySet(); //정렬된 'Set' 타입 리턴
		System.out.println("방법-1 :" + set1);	//주소만으로 값을 출력
		
		System.out.print("방법-2 :["); //1.향상된 for문 or
		Iterator<Entry<Integer, String>> set1Itr = set1.iterator();	//2.반복자 이용
		Entry<Integer, String> entry;
		while(set1Itr.hasNext()) {
			entry = set1Itr.next();
			System.out.print(entry.getKey() + "=" + entry.getValue() + " "); //<78,유재석>
		}
		System.out.println("]"); //"]" 출력 후 커서를 아래로
		
		System.out.println(); //구분용 빈 줄
		
		System.out.println("---------------------------------------------------------");
		NavigableMap<Integer, String> treeMapSub2 = treeMap.subMap(78, true, 95, true);
		System.out.println("78 <= 찾는 점수 <= 95");
		
		Set<Entry<Integer, String>> set2 = treeMapSub2.entrySet(); //정렬된 'Set' 타입 리턴
		System.out.println("방법-1 :" + set2);	//주소만으로 값을 출력
		
		System.out.print("방법-2 :["); //1.향상된 for문 or
		Iterator<Entry<Integer, String>> set2Itr = set2.iterator();	//2.반복자 이용
		//Entry<Integer, String> entry;
		while(set2Itr.hasNext()) { 
			entry = set2Itr.next(); //<78,유재석>
			System.out.print(entry.getKey() + "=" + entry.getValue() + " "); 
		}
		System.out.println("]"); //"]" 출력 후 커서를 아래로
		
		System.out.println(); //구분용 빈 줄
		
		System.out.println("---------------------------------------------------------");
		System.out.println("***** 내림차순 *****************************************");
		System.out.println("[방법-1] Key가 내림차순으로 정렬된 NavigableSet을 리턴 -> 내림차순");
		NavigableSet<Integer> dKey = treeMap.descendingKeySet(); //내림차순 Key
		// NavigableSet도 Set : 향상된 for 또는 Iterator 이용
		Iterator<Integer> itr = dKey.iterator();	//내림차순 반복자
		
		//String output = "";
		
		while(itr.hasNext()) {
			Integer key = itr.next(); //98
			String value = treeMap.get(key);
			
			//output += key + "=" + value + ", ";
			System.out.print(key + "=" + value + " ");
		}
		//output = output.substring(0, output.length() - 2);
		//System.out.println(output);
		
		System.out.println("\n"); //커서 내리고 구분용 빈 줄
		
		System.out.println("[방법-2] Entry가 내림차순으로 정렬된 NavigableMap을 리턴 -> 내림차순");
		NavigableMap<Integer, String> dMap = treeMap.descendingMap();
		Set<Entry<Integer, String>> eSet = dMap.entrySet();
		// Set : 향상된 for 또는 Iterator 이용
		for(Entry<Integer, String> entry2:eSet) {
			System.out.print(entry2.getKey() + "=" + entry2.getValue() + " ");
		}
		System.out.println(); //커서를 아래로
		
		System.out.println("-------------------------------------------------------------");
		
		
	} //main() 메서드 끝

}
