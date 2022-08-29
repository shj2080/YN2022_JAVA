package set.treesetmember2;

import java.util.Comparator;

public class DescendingMember implements Comparator<Member>{//Comparator<Member> 비교대상:Member
	//기본생성자 DescendingMember(){}

	@Override // 기준 : memberID로 내림차순 정렬
	public int compare(Member o1, Member o2) {//o1:새로 추가되는 값, o2:기존의 비교하는 값
		// 내림차순 정렬-1 : 권장하지 않음(오버플로우나 언더플로우 발생 가능성이 있어서)
	    //return (o1.memberID - o2.memberID)*(-1); //새로 추가되는 값 - 기존의 비교하는 값 = 반환없이 '음수' :
		// 오름차순
		// 새로 추가되는 값 - 기존의 비교하는 값 = 반환값이 0이면 add()안됨(중복되어)

		// 내림차순 정렬-2
		//if (o1.memberID < o2.memberID)
		//	return 1; // 새로 추가되는 값 - 기존의 비교하는 값 < 0 => 대표값 1리턴
		//else if (o1.memberID == o2.memberID)
		//	return 0; // 새로 추가되는 값 - 기존의 비교하는 값 == 0 => 대표값 0리턴
		//else
		//	return -1; // 새로 추가되는 값 - 기존의 비교하는 값 < 0 => 대표값 -1리턴
		
		//내림차순 정렬-3
		return o1.compareTo(o2)*(-1); //제일 심플함
	}
}
