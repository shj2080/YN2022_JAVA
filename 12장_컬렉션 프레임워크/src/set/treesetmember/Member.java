/**
 * String이나 Integer 등 제공받은 클래스들은 Comparable<T> 인터페이스를 이미 구현하여
 * 재정의된 compareTo() 메서드로 오름차순 정렬되어 추가됨
 * 
 * 우리가 만든 사용자 정의 클래스는
 */
package set.treesetmember;

//사용자 정의 클래스
public class Member implements Comparable<Member> { //부모:Object
	//1. private 멤버변수
	private int memberID;		//회원아이디
	private String memberName;	//회원 이름
	
	//2. 생성자
	public Member(int memberID, String memberName) {
		super();
		this.memberID = memberID;
		this.memberName = memberName;
	}
	
	/*-----------------------------------------------------*/
	
	/*-----------------------------------------------------*/
	
	//3. public get~ set~메서드를 통해 private 멤버변수에 접근하는 메서드
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

	@Override //기준 : memberID로 오름차순 정렬
	public int compareTo(Member o) {
		//오름차순 정렬-1 : 권장하지 않음(★오버플로우나 언더플로우 발생할 수 있음)
		//return (this.memberID - o.memberID); //새로 추가되는 값 - 기존의 비교하는 값 = 반환값이 '양수' : 오름차순
		//새로 추가되는 값 - 기존의 비교하는 값 = 반환값이 0이면 add()안됨(중복되어)
		
		//오름차순 정렬-2
		if(this.memberID > o.memberID) //새로 추가되는 값 - 기존의 비교하는 값 > 0 => 대표값 1리턴
			return 1;
		else if(this.memberID == o.memberID)  //새로 추가되는 값 - 기존의 비교하는 값 == 0 => 대표값 0리턴
			return 0;
		else							//새로 추가되는 값 - 기존의 비교하는 값 < 0 => 대표값 -1리턴
			return -1;
		
	}
	
	
}
