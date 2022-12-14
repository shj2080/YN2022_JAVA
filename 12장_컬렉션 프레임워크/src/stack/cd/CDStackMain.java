package stack.cd;

import java.util.Stack;

public class CDStackMain {

	public static void main(String[] args) {
		Stack<CD> cdBox = new Stack<CD>();
		
		cdBox.push(new CD("BTS"));
		cdBox.push(new CD("블랙핑크"));
		cdBox.push(new CD("신화"));
		
		CD cd = cdBox.peek(); //스택의 맨 위 객체를 가져오고 "객체를 스택에서 제거하지는 않는다."
		System.out.println(cd); //CD [cdTitle=신화]

		cd = cdBox.peek(); //스택의 맨 위 객체를 가져오고 "객체를 스택에서 제거하지는 않는다."
		System.out.println(cd); //CD [cdTitle=신화]
		
		System.out.println(); //구분 위한 빈 줄
		
		int number = 0; //int number = 1;
		while(!cdBox.isEmpty()) { //스택이 비어있지 않은 동안 반복문 실행
			cd = cdBox.pop(); //스택의 맨 위 객체를 가져오고 "객체를 스택에서 제거한다."
			System.out.println(++number + "CD 제목 : " + cd.getCdTitle()); 	//number = 0
			//System.out.println(number++ + "CD 제목 : " + cd.getCdTitle());	//number = 1
		}
		System.out.println("Stack에 남은 CD 객체 수 : " + cdBox.size());
		
		cdBox.clear(); //전체 값 제거(초기화)
		System.out.println("Stack에 남은 CD 객체 수 : " + cdBox.size());
		
		/*
		 * 빈 상태에서 index로 접근하면 ArrayIndexOutOfBoundsException 예외 발생 -> 프로그램 강제 종료
		 */
		
		//예외처리 방법-1
		/*
		try {
			cd = cdBox.get(0);
			System.out.println(cd);
		} catch (Exception e) {
			//e.printStackTrace(); 
			System.out.println(e);	//예외클래스종류 + 예외메세지
		}
		*/
		
		/*
		 예외처리 방법-2 : try~catch로 처리하는 것보다 이 방법을 권장
		 (이유?try~catch로 처리하는 것은 불필요하게 멀티쓰레드로 처리하므로 효율▼)
		 */
		if(!cdBox.isEmpty()) { //cdBox가 비어있지 않으면
			cd = cdBox.get(0);		//index 0에 접근 가능함
			System.out.println(cd);
		}
		System.out.println("-- 종료 --");
	}

}
