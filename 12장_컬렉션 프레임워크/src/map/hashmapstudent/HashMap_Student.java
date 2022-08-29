/* 	
 	HashMap
	해시함수를 이용한 Map임
	삽입 / 삭제 / 조회 연산의 O(1)을 보장하는 아주 빠른 자료구조
	삽입 데이터의 순서를 보장하지 않음
	정렬이 불가함
	
	LinkedHashMap
	삽입 / 삭제가 맵보다 느림
	삽입 순서를 보장함
	정렬은 불가함
	
	TreeMap
	삽입 / 삭제가 굉장히 느림,
	삽입순서를 보장함
	Map이지만 유일하게 정렬이 가능함. 
*/

package map.hashmapstudent;

import java.util.HashMap;

public class HashMap_Student {

	public static void main(String[] args) {
		//학생의 점수를 관리하는 HashMap객체 : <Student 키:중복X, Integer 값:중복O>
    	HashMap<Student, Integer> map=new HashMap<Student, Integer>();
    	
    	Student key = new Student(1, "홍길동");
    	map.put(key, 85);//int 85 -> 자동Boxing되어 'Integer객체'
    	
    	map.put(new Student(1, "홍길동"), 95);
    	
    	System.out.println("저장된 총 Entry 객체수 : " + map.size()); //2개 => 1개가 되도록 소스를 수정해야함 [중복]
    	
    	System.out.println("[map 주소만 Entry값이 출력] : " + map);//Entry값이 아니라 "클래스이름을@16진수 해쉬코드"
    	/*1.
    	 * {map.hashmapstudent.Student@1c4af82c=85, map.hashmapstudent.Student@5e91993f=85}
        => Entry값이 아니라 "클래스이름을16진수해쉬코드" 출력된 이유? Student클래스 안에 toString() 재정의 하지않아서
    	
    	 2. Student클래스 안에 toString() 재정의
    	 {학생 [아이디=1, 이름=홍길동]=95, 학생 [아이디=1, 이름=홍길동]=85} 출력됨
    	 =>문제는 "동일한 Student"가 중복되어 저장됨
    	 => HashMap<Student, Integer> : Student키가 중복됨
    	 
    	 3.
    	 => Student키가 중복되지 않도록 하기 위해서
         => hashCode(), equals() 로 같은 객체로 인식할 수 있도록 재정의해야함 -> 메서드를 주소가 아니라 값을 비교하도록 재정의필요    	
    	*/
    	
    	
    	
	}

}
