package map.treemapmember;

import java.util.TreeMap;

public class TreeMapMember {
	//멤버변수 : Entry<Integer, Member>를 관리하는 TreeMap 타입을 포함관계
	//[포함관계 순서-1]
	private TreeMap<Integer, Member> treeMap;
	
	//[포함관계 순서-2] 매개변수가 없는 생성자
	public TreeMapMember() { //(Key기준)오름차순 정렬된 TreeMap
		//Integer는 Comparable 인터페이스를 이미 구현하여 재정의된 compareTo()메서드로 오름차순 정렬되어 있음
		treeMap = new TreeMap<Integer, Member>(); //변수 선언 시 <>안에 타입을 정의한 경우 객체 생성시에 타입입력 생략가능
	}
	
	//[포함관계 순서-3] 외부에 노출된 메서드
	//회원 추가------------------------------------------------
	public void addMember(Member m) {
		treeMap.put(m.getMemberID(), m);	//실질적인 기능 TreeMap<Integer, Member>안에 있으므로
		/* 1. TreeMap<Integer, Member>() 생성자로 객체 생성
		 * 	  put() 호출되면 compareTo()메서드가 자동호출되어 크기를 비교해가면서 '오름차순' 정렬시켜 저장
		 * 	  (반환값이 0이면 동일객체로 인식하여 추가X, 즉 중복된 객체는 추가X)
		 */
	}
	
	//회원 삭제------------------------------------------------
	//1.'회원 아이디(=키)'로 삭제
	public boolean removeMember(int memberID) {	//memberID : 매개값
		if(treeMap.containsKey(memberID)) {	//회원정보 TreeMap 안에 찾는 키가 있는가?
			//방법-1:순서 주의(삭제 후 출력하면 null이 출력)
			//System.out.println(treeMap.get(memberID) + "가 삭제되었습니다.");
			//treeMap.remove(memberID);
			
			//방법-2:권장		※ remove(K key) : key로 삭제
			System.out.println(treeMap.remove(memberID) + "가 삭제되었습니다.");
			return true;	//삭제 성공
			
		}else {
			System.out.println(memberID + "가 존재하지 않습니다.");
			return false; //삭제 실패
		}

	}
	
	//2.'회원(=값)'으로 삭제
	public boolean removeMember(Member member) {	//member : 매개값
		/*
		 * ※ remove(V value) : value(값)으로 삭제하는 메서드 없는 이유?
		 * 값은 중복되므로 여러 키가 삭제될 가능성이 있음
		 */
		
		//방법-1
		/*
		if(treeMap.containsValue(member)) {
								//member.getMemberID()로 키를 얻어와 삭제
			System.out.println(treeMap.remove(member.getMemberID()) + "가 삭제되었습니다.");
			return true;
		}
		*/
		
		//방법-2
		if(treeMap.remove(member.getMemberID(), member)) {
			System.out.println(member + "가 삭제되었습니다.");
			return true;
		}
		else {
			System.out.println(member + "가 존재하지 않습니다.");
			return false;
		}
		
	} //removeMember() 메서드 끝
	
	//회원 정보 출력------------------------------------------------
	//1. TreeMap<Integer, Member>() 생성자로 객체 생성 => Key를 기준으로 오름차순 정렬
	public void showAllMember() {
		System.out.println("[오름차순 정렬]");
		System.out.println(treeMap);
		
		System.out.println(); //구분 빈 줄
	}
	
	
}
