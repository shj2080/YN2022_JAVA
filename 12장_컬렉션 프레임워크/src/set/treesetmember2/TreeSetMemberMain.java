package set.treesetmember2;

import java.util.TreeSet;

public class TreeSetMemberMain {

	public static void main(String[] args) {
		System.out.println("-------------[처음부터 아이디로 오름차순 정렬]-------------");
		// 매개변수가 없는 생성자 호출 -> 오름차순 정렬된 TreeSet 객체 생성
		TreeSet<Member> tsm = new TreeSet<Member>(); // 같은 패키지내 자동import
        
		//compareTo()메서드 자동호출 -> 자동 오름차순 정렬시켜 추가함
		tsm.add(new Member(2, "손주환"));
		tsm.add(new Member(3, "황보창민"));
		tsm.add(new Member(1, "이대현"));

		System.out.println(tsm);// 1, 2, 3 자동 오름차순 정렬되어 출력
		// System.out.println(tsm.toString());

		System.out.println("-------------[처음부터 아이디로 내림차순 정렬]-------------");
		TreeSet<Member> tsm2 = new TreeSet<Member>(new DescendingMember());
        
		//compare()메서드 자동호출 -> 자동 내림차순 정렬시켜 추가함
		tsm2.add(new Member(2, "손주환"));
		tsm2.add(new Member(3, "황보창민"));
		tsm2.add(new Member(1, "이대현"));
		
		System.out.println(tsm2);// 1, 2, 3 자동 내림차순 정렬되어 출력
		// System.out.println(tsm2.toString());
	}

}
