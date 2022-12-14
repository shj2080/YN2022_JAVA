/**
 * [Set 인터페이스] index 사용안하므로 순서X, 중복X => 중복되지 않고 저장순서가 중요하지 않을 때 사용
 * 1. HashSet 클래스 : 저장 순서에 상관없는 출력 결과
 * 					Set은 index 사용안하므로 "저장순서가 중요하지 않다."
 * 
 * 그러나
 * 2. LinkedHashSet 클래스 : 저장 순서 유지하는 예외적인 Set 클래스
 * 
 * 3. TreeSet 클래스 : 이진트리를 기반으로 검색 기능을 강화
 * 
 * [★★Hash~시작하는 클래스에서 객체를 추가할 때 '같은 객체인지 여부를 판단하는 방법']
 * (예)HashSet, HashMap(key값:중복 허용하지 않음)
 * 
 * 객체를 add(), put(key, value) (추가=저장)하기 전에
 * 1. 반드시 hashCode() 메서드 호출
 * 	  -> 리턴된 hashCode값(정수) 비교 : 같으면 -> 2. 한번 더 같은지 확인하기 위해서 equals()메서드 호출
 * 										   -> true이면 같은 객체로 인식하여 -> 추가하지 않고
 * 										   -> false이면 다른 객체로 인식하여 -> 추가
 *    -> 리턴된 hashCode값(정수) 비교 : 다르면 -> 2. 서로 다른 객체로 인식하여 추가함
 *    
 *   ※ hashCode값(정수) : 객체의 주소로 만듦
 *   
 *   [Object]
 *   - Object의 hashCode() : 객체의 '주소값'으로 hashCode 만듦
 *   - 제공받은 Object의 자식 클래스들(예:String, Integer 등)의 hashCode() : 재정의(객체의 '실제값'으로 해쉬코드 만듦)
 *   
 *   - Object의 equals() : 객체의 '주소값' 비교
 *   - 제공받은 Object의 자식 클래스들(예:String, Integer 등)의 equals() : 재정의(객체의 '실제값'을 비교)
 *   
 *   그러나, 우리가 만든 '사용자 정의 클래스'는 Object의 hashCode()와 equals()를 상황에 맞게 반드시 재정의해서 사용해야 함
 *   (예 : Set인터페이스를 구현한 클래스(HashSet)를 사용하려면 재정의해야 함)
 */
package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		//부모 Set 인터페이스
		Set<String> set = new HashSet<String>();
		
		set.add("여러분");
		set.add("힘내세요~");
		//Set은 중복 허용X : add()추가하기 전 중복여부 판단하는 String클래스의 메서드 중 2개 호출 -> 중복이면 추가X, 중복아니면 추가
		set.add("힘내세요~");
		
		System.out.println("총 객체수 : " + set.size()); //총 객세수 : 2
		
		System.out.println("주소만 : " + set); //[주소1.toString(), 주소2.toString()]
		
		/** Set에 저장된 객체 얻는 방법-1 : '향상된 for문 사용' - index 사용하지 않기 때문에 **/
		for(String str:set) {
			System.out.print(str + " ");
		}
		System.out.println(); //커서를 아래로...
		
		/** Set에 저장된 객체 얻는 방법-2 : 'Iterator(=반복자:지팡이 역할) 사용' - index 사용하지 않기 때문에 **/
		Iterator<String> itr = set.iterator(); //Iterator(=반복자)생성하는 메서드 : Set에서 많이 사용
		
		while(itr.hasNext()) {
			System.out.print(itr.next() + " "); 
		}
		System.out.println(); //커서를 아래로...
		
		System.out.println("-- 삭제 --");
		if(set.remove("모두"))
			System.out.println("\"모두\" 찾아서 있으면 삭제 후 true");
		else System.out.println("\"모두\" 찾아서 없으면 false");
		
		System.out.println("-- 전체 삭제 --");
		if(set.removeAll(set))
			System.out.println("전체 삭제");
		else System.out.println("전체 삭제안됨");
		
		set.clear(); //clear()로 모두삭제하면 반환타입이 void이므로 삭제되었는지 확인하려면
		//[방법-1] size()
		System.out.println("저장된 총 객체 수 : " + set.size());
		
		//[방법-2] isEmpty()
		if(set.isEmpty()) { 		//isEmpty() :  비어있는지 확인
			System.out.println("저장된 객체가 없음. 비어있음");
		}else System.out.println("저장된 객체가 있음.");
		
	}

}
