package set.treesetmember;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetMember {
	//멤버변수 : Member를 관리하는 TreeSet 타입을 포함관계
	//[포함관계 순서-1]
	private TreeSet<Member> treeSet;
	
	//[포함관계 순서-2] 매개변수가 없는 생성자
	public TreeSetMember() { //오름차순 정렬된 TreeSet
		treeSet = new TreeSet<Member>(); 		//compareTo() 메서드가 내부적으로 호출됨 (정의된 방식으로 Tree를 정렬)
	}
	
	/*---------------------------------------------------------*/	
	//※ Comparator<T> 사용 시 유의점 : TreeSet() 생성자에 'Comparator를 구현한 객체★'를 매개값으로 전달해야 함
	public TreeSetMember(Member member) {	//Member객체를 member에 담아 매개값으로 , 내림차순 정렬된 TreeSet
		treeSet = new TreeSet<Member>(member);	//compare() 메서드가 내부적으로 호출됨  (정의된 방식으로 Tree를 정렬)
	}	
	/*---------------------------------------------------------*/
	
	//[포함관계 순서-3] 외부에 노출된 메서드
	//회원 추가------------------------------------------------
	public void addMember(Member m) { //회원 추가
		treeSet.add(m); //실질적인 메서드는 TreeSet<Member>객체 안에 있으므로
		/* 1. TreeSet<Member>() 생성자로 객체 생성
		 * 	  add() 호출되면 compareTo()메서드가 자동호출되어 크기를 비교해가면서 '오름차순' 정렬시켜 저장
		 * 
		 * 2. TreeSet(Member member) 생성자로 객체 생성
		 *    ※ 매개변수 Member 클래스는 반드시 Comparator인터페이스를 구현해야 함
		 *    add() 호출되면 compare()메서드가 자동호출되어 크기를 비교해가면서 '내림차순'정렬시켜 저장
		 *     (반환값이 0이면 동일객체로 인식하여 추가X, 즉 중복된 객체는 추가X)
		 */
	}
	
	
	//회원 삭제------------------------------------------------
	//'회원 아이디'로 삭제
	public boolean removeMember(int memberID) { //memberID : 매개값
		Iterator<Member> itr = treeSet.iterator(); //오름차순 반복자 생성
		
		while(itr.hasNext()) {
			Member member = itr.next(); //추가된 회원(Member)을 가져와
			if(member.getMemberID() == memberID) { //추가된 회원 아이디와 매개값을 비교 후 같으면
				treeSet.remove(member); //제거 후 (실질적인 메서드)
				return true; //true 리턴(삭제 성공) -> 메서드 종료
			}
			//else return false; //있으면 안 됨 (이유? return 만나면 무조건 해당 메서드는 종료되므로) - 반복문 바로 끝남
		}
		
		System.out.println(memberID + "가 존재하지 않습니다.");
		return false; //삭제 실패
	}
	
	//'회원'으로 삭제
	public boolean removeMember(Member member) { // member : 매개값
		Iterator<Member> itr = treeSet.iterator(); //오름차순 반복자 생성
		
		while(itr.hasNext()) {
			Member member2 = itr.next(); //추가된 회원(Member)을 가져와
			if(member2.getMemberID() == member.getMemberID()) { //추가된 회원 아이디와 매개값으로 받은 객체의 회원아이디를 비교 후 같으면
				treeSet.remove(member2); //제거 후 (실질적인 메서드)
				return true; //true 리턴(삭제 성공) -> 메서드 종료
			}
			//else return false; //있으면 안 됨 (이유? return 만나면 무조건 해당 메서드는 종료되므로) - 반복문 바로 끝남
		}
		
		System.out.println(member + "가 존재하지 않습니다.");
		//System.out.println(member.toString() + "가 존재하지 않습니다.");
		return false; //삭제 실패
	}
	
	//회원 정보 출력------------------------------------------------
	//[1. 오름차순 정렬]
	public void showAllMember() {
		for(Member member:treeSet) {
			System.out.println(member);
			//System.out.println(member.toString());
		}
		System.out.println(); //구분 빈 줄
	}
	//---
	//1. TreeSet<member>() 생성자로 객체 생성 => 내림차순 정렬
	//2. TreeSet<member>(Member member) 생성자로 객체 생성 => 오름차순 정렬
	//----
	//[2. 내림차순 정렬]
	public void showAllDescendingMember() {
		//내림차순 방법-1
		/*
		Iterator<Member> dItr = treeSet.descendingIterator(); 
		while(dItr.hasNext()) {
			System.out.println(dItr.next()); 	//treeSet에 저장된 객체를 리턴
			//System.out.println(dItr.next().toString()); 	
		}
		System.out.println(); //구분 빈 줄
		*/
		
		//내림차순 방법-2
		NavigableSet<Member> dMemberSet = treeSet.descendingSet(); //내림차순으로 정렬된 Set
		/*
		for(Member member:dMemberSet) {
			System.out.println(member);
		}
		*/
		
		
		Iterator<Member> itr = dMemberSet.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
			//System.out.println(itr.next().toString());
		}
		
		/*
		Iterator<Member> itr = dMemberSet.descendingIterator(); //오름차순 반복자 (내림차순 정렬된 Set을 다시 내림차순 반복자로 참조하려고 하므로)
		while(itr.hasNext()) {
			System.out.println(itr.next());
			//System.out.println(itr.next().toString());
		}
		*/
		
		System.out.println(); //구분 빈 줄
		
	}
}
