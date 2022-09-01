package map.treemapmember;

public class TreeMapMemberMain {

	public static void main(String[] args) {
		System.out.println("-------------- [처음부터 오름차순 정렬] ----------------");
		TreeMapMember tmm = new TreeMapMember();
		
		Member m1 = new Member(3, "이승기");
		/* 오류 발생하지 않음! ClassCastException 예외발생 안함
		 * Integer 클래스가 Comparable인터페이스를 구현했기 때문에...
		 */
		tmm.addMember(m1);
		
		Member m2 = new Member(1, "이진광");
		tmm.addMember(m2);

		Member m3 = new Member(2, "장혜원");
		tmm.addMember(m3);
		
		tmm.showAllMember();
		
		System.out.println("-- ▼중복된 ID로 추가 시▼ --"); 
		
		Member m3_2 = new Member(2, "전영훈"); //같은 아이디의 회원을 추가할 경우(TreeMap) 
		tmm.addMember(m3_2); //중복된 키가 있다면 그 키의 값이 새로운 값으로 변경됨(예)"장혜원" -> "전영훈"
		
		tmm.showAllMember(); 
		
		System.out.println("-- ▼중복되지 않은 ID로 추가 시▼ --");
		
		Member m4 = new Member(4, "황보창민"); //다른 아이디의 회원을 추가
		tmm.addMember(m4); //아이디가 중복되지 않아 추가됨
		
		tmm.showAllMember(); 
		
		System.out.println("------------------ [삭제] ----------------------");
		//아이디 2로 Entry<2,Member>객체 삭제
		if(tmm.removeMember(2))
			System.out.println("아이디 2번 회원 삭제");
		else
			System.out.println("아이디 2번 회원이 없어서 삭제못함");
		
		//Member로 Entry<4,Member>객체 삭제
		if(tmm.removeMember(m4))
			System.out.println("아이디 4번 회원 삭제");
		else
			System.out.println("아이디 4번 회원이 없어서 삭제못함");
		
		tmm.showAllMember();
		tmm.showAllDescendingMember();
		
	}//main() 메서드 끝

}
