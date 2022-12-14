package set.treesetmember;

public class TreeSetMemberMain {

	public static void main(String[] args) {
		System.out.println("-------------- [처음부터 오름차순 정렬] ----------------");
		TreeSetMember tsm = new TreeSetMember();
		
		Member m1 = new Member(3, "이승기");
		/* 오류? ClassCastException: class set.treesetmember.Member cannot be cast to class java.lang.Comparable
		 * Member 클래스가 Comparable인터페이스를 구현하지 않고 저장하는 순간 ClassCastException예외 발생
		 */
		tsm.addMember(m1);
		
		Member m2 = new Member(1, "이진광");
		tsm.addMember(m2);

		Member m3 = new Member(2, "장혜원");
		tsm.addMember(m3);
		
		tsm.showAllMember();
		
		System.out.println("-- ▼중복된 ID로 추가 시▼ --"); 
		
		Member m3_2 = new Member(2, "전영훈"); //같은 아이디의 회원을 추가
		tsm.addMember(m3_2); //아이디가 중복되어 추가안됨
		
		tsm.showAllMember(); 
		
		System.out.println("-- ▼중복되지 않은 ID로 추가 시▼ --");
		
		Member m4 = new Member(4, "전영훈"); //다른 아이디의 회원을 추가
		tsm.addMember(m4); //아이디가 중복되지 않아 추가됨
		
		tsm.showAllMember(); 
		
		System.out.println("------------------ [삭제] ----------------------");
		if(tsm.removeMember(3)) System.out.println("아이디 3인 회원 삭제");
		else System.out.println("아이디 3인 회원 없어서 삭제못함");
		
		if(tsm.removeMember(new Member(2, "장혜원"))) System.out.println("\"아이디 2, 장혜원\" 회원 삭제");
		else System.out.println("\"아이디 2, 장혜원\" 회원 없어서 삭제못함");
		
		System.out.println("----------------- [회원정보 출력] -----------------");
		System.out.println("** 오름차순 **");
		tsm.showAllMember();

		System.out.println("** 내림차순 **");
		tsm.showAllDescendingMember();
		
	}

}
