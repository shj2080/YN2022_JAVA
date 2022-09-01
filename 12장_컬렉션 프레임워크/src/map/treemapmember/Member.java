package map.treemapmember;

public class Member {
	//1. private 멤버변수
	private int memberID;		//회원아이디=>key로
	private String memberName;	//회원 이름

	//2. 생성자
	public Member(int memberID, String memberName) {
		super();
		this.memberID = memberID;
		this.memberName = memberName;
	}

	//3. public get~ set~메서드를 통해 private 멤버변수에 접근
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
		return "회원 [아이디=" + memberID + ", 이름=" + memberName + "]";
	}
	
}
