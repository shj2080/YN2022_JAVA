/**
 * String이나 Integer 등 제공받은 클래스들은 Comparable<T> 인터페이스를 이미 구현하여
 * 재정의된 compareTo() 메서드로 오름차순 정렬되어 추가됨
 * 
 * 그런데' 내림차순 메서드를 추가하고 싶은 경우'에는 어떻게 해야 할까요?
 * String이나 Integer 클래스의 경우는 final으로 선언되어 있어서 상속받아 
 * compareTo() 메서드를 내림차순 정렬되도록 재정의할 수 없다.
 * 
 * 
 * 우리가 만든 사용자 정의 클래스는 Comparable<T> 인터페이스와 Comparator<T> 인터페이스를 함께 구현하여
 * compareTo()메서드로 '오름차순 정렬'되도록 재정의하고 compare()메서드로 '내림차순 정렬'되도록 재정의하면 된다.
 * 
 * ※ Comparator<T> 사용 시 유의점 : TreeSet() 생성자에 Comparator를 구현한 객체를 매개값으로 전달해야 함
 */

package set.treesetmember2;

import java.util.Comparator;

//사용자 정의 클래스
public class Member implements Comparable<Member>{ // 부모:Object
	// 1. private 멤버변수
	private int memberID;// 회원아이디
	private String memberName;// 회원 이름

	public Member(int memberID, String memberName) {
		super();
		this.memberID = memberID;
		this.memberName = memberName;
	}


	// 3. public get~ set~ 메서드를 통해 private 멤버변수에 접근
	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "Member [memberID=" + memberID + ", memberName=" + memberName + "]";
	}

	@Override // 기준 : memberID로 오름차순 정렬
	public int compareTo(Member o) {
		// 오름차순 정렬-1 : 권장하지 않음(오버플로우나 언더플로우 발생 가능성이 있어서)
		// return this.memberID - o.memberID; //새로 추가되는 값 - 기존의 비교하는 값 = 반환없이 '양수' :
		// 오름차순
		// 새로 추가되는 값 - 기존의 비교하는 값 = 반환값이 0이면 add()안됨(중복되어)

		// 오름차순 정렬-2
		if (this.memberID > o.memberID)
			return 1; // 새로 추가되는 값 - 기존의 비교하는 값 > 0 => 대표값 1리턴
		else if (this.memberID == o.memberID)
			return 0; // 새로 추가되는 값 - 기존의 비교하는 값 == 0 => 대표값 0리턴
		else
			return -1; // 새로 추가되는 값 - 기존의 비교하는 값 < 0 => 대표값 -1리턴

	}

	/*--------------------------------------------------------------------------------*/

	

}
