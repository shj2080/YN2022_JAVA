package set;

import java.util.HashSet;
import java.util.Objects;
//사용자 정의 클래스
class Student { //부모 : Object
	int studentId; //아이디
	String studentName; //이름
	
	Student(int studentId, String studentName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
	}

	
	@Override
	public int hashCode() {
		/* hash(Object... values) 이므로
		 * - studentId : int -> 자동Integer -> 자동Object
		 * - studentName : String -> 자동Object
		 */ 
		
		//return studentId % 3;  //[방법-1] 검색속도가 빨라짐
		//return studentId % 3 + studentName.hashCode(); //[방법-2] 
		
		//Objects.hash() : 최근에 추가된 방법 (Objects클래스의 hash메서드를 활용한 해쉬코드 생성)
		//return Objects.hash(studentId);//[방법-1]
		return Objects.hash(studentId, studentName); //[방법-2] ID와 이름값에 대한 hashCode를 가지고 전체적인 hashCode 만듦
	}


	/** s.equals(s1)는 Object의 equals()를 호출함
	 * Object의 equals() : 두 객체의 '주소를 비교'하여 같으면 true, 다르면 false
	 * 
	 * 따라서, '값을 비교'하도록 재정의해야 함
	 * 이 때, 비교하는 기준을 '아이디만 같아도' 같은 객체로 인식하려면 -[방법-1]
	 * 이 때, 비교하는 기준을 '아이디와 이름이 모두 같을 때' 같은 객체로 인식하려면 -[방법-2]
	 */
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) { //obj가 참조하는 객체가 Student객체 또는 Student자식객체이면 true
			Student std = (Student)obj;
			//[방법-1] : '아이디만 같아도' 같은 객체로 인식
			//if(studentId == std.studentId) return true; //리턴되는 순간 이 메서드 종료
			
			//[방법-2] : '아이디와 이름이 모두 같을 때' 같은 객체로 인식
			if(this.studentId == std.studentId 
			&& this.studentName.equals(std.studentName)) //String의 equals()는 이미 '값을 비교'하도록 재정의
				return true; 
			
		}
		
		return false; //같은 것을 찾지 못함
	}//equals 메서드 끝
	
	
	/*//마오->소스->hashCode() 및 equals() 생성
	@Override
	public int hashCode() {
		return Objects.hash(studentId, studentName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return studentId == other.studentId && Objects.equals(studentName, other.studentName);
	}
	 */
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + "]";
	}
	
	
	
}//Student 클래스 끝

public class Equals_HashCode_ToString_Test {

	public static void main(String[] args) {
		Student s = new Student(1, "강민재");
		Student s1 = s;						//s에서 생성된 객체 주소를 가리킴
		Student s2 = new Student(1, "강민재"); //s와 주소가 다름(새로 생성된 객체)
		
		//클래스 타입은 주소 비교는 중요하지 않다.
		if(s == s1) { //주소 비교
			System.out.println("주소가 같다.");
		}else System.out.println("주소가 다르다.");
		
		if(s1 == s2) { //주소 비교
			System.out.println("주소가 같다.");
		}else System.out.println("주소가 다르다.");
		
		//재정의 되지 않은 equals 메서드는 주소를 비교(Object의 equals 사용됨)
		//클래스 타입은 주소가 참조하는 값을 비교하는 것이 중요하다.
		if(s.equals(s1)) System.out.println("값이 같다. 즉, 같은 객체");
		else System.out.println("값이 다르다. 즉, 다른 객체");
				
		if(s1.equals(s2)) System.out.println("값이 같다. 즉, 같은 객체");
		else System.out.println("값이 다르다. 즉, 다른 객체");
		
		/*
		 * hashCode() 재정의 전 : Object의 hashCode() 호출하여 서로 다른 코드값이 나옴(이유?주소로 만들어서...)
		 * hashCode() 재정의 후 : Student의 hashCode() 호출하여 서로 같은 코드값이 나옴(이유?값으로 만들어서...)
		 */
		System.out.println("------------------------------------------");
		System.out.println("s가 참조하는 객체의 실제주소값 : " + System.identityHashCode(s));
		System.out.println("s2가 참조하는 객체의 실제주소값 : " + System.identityHashCode(s2));
		
		System.out.println("s가 참조하는 객체의 hashCode값 : " + s.hashCode());
		System.out.println("s2가 참조하는 객체의 hashCode값 : " + s2.hashCode());
		System.out.println("------------------------------------------");
		
		/**
		 * [★★Hash~시작하는 클래스에서 객체를 추가할 때 '같은 객체인지 여부를 판단하는 방법']
		 * (예)HashSet, HashMap(key값:중복 허용하지 않음)
		 * 
		 * 객체를 add(), put(key, value) (추가=저장)하기 전에
		 * 1. 반드시 hashCode() 메서드 호출
		 * 	  -> 리턴된 hashCode값(정수) 비교 : 같으면 -> 2. 한번 더 같은지 확인하기 위해서 equals()메서드 호출
		 * 										   -> true이면 같은 객체로 인식하여 -> 추가하지 않고
		 * 										   -> false이면 다른 객체로 인식하여 -> 추가
		 *    -> 리턴된 hashCode값(정수) 비교 : 다르면 -> 2. 서로 다른 객체로 인식하여 추가함
		 *    
		 *   ※ hashCode값(정수) : 객체의 주소로 만듦
		 *   
		 *   [Object]
		 *   - Object의 hashCode() : 객체의 '주소값'으로 hashCode 만듦
		 *   - 제공받은 Object의 자식 클래스들(예:String, Integer 등)의 hashCode() : 재정의(객체의 '실제값'으로 해쉬코드 만듦)
		 *   
		 *   - Object의 equals() : 객체의 '주소값' 비교
		 *   - 제공받은 Object의 자식 클래스들(예:String, Integer 등)의 equals() : 재정의(객체의 '실제값'을 비교)
		 *   
		 *   그러나, 우리가 만든 '사용자 정의 클래스'는 Object의 hashCode()와 equals()를 상황에 맞게 반드시 재정의해서 사용해야 함
		 *   (예 : Set인터페이스를 구현한 클래스(HashSet)를 사용하려면 재정의해야 함)
		 */
		HashSet<Student> hset = new HashSet<Student>();
		hset.add(new Student(1, "강민재"));
		hset.add(new Student(1, "강민재"));
		
		System.out.println("저장된 객체 수-1 : " + hset.size()); //2 -> 1로 변경하기 위해(객체의 실제값끼리 비교하기 위해) "hashCode()와 equals() 재정의함"
		
		System.out.println("-----------[▼hset2▼]----------------");
		HashSet<String> hset2 = new HashSet<String>();
		hset2.add(new String("강민재"));
		hset2.add(new String("강민재"));
		
		System.out.println("저장된 객체 수-2 : " + hset2.size());
		
		System.out.println("----------[hashCode 테스트]---------------------");
		String str1 = new String("abc");
		String str2 = new String("abc");
		
		System.out.println("str1이 참조하는 객체의 실제주소값 : " + System.identityHashCode(str1));
		System.out.println("str2이 참조하는 객체의 실제주소값 : " + System.identityHashCode(str2));
		System.out.println("str1이 참조하는 객체의 hashCode값 : " + str1.hashCode());
		System.out.println("str2이 참조하는 객체의 hashCode값 : " + str2.hashCode());
		
		Integer i1 = new Integer(123); //지원이 중단될 예정인 방법 - The constructor Integer(int) has been deprecated and marked for removal
		Integer i2 = 123; //123(int) -> 자동박싱(Integer)
		
		System.out.println("i1이 참조하는 객체의 실제주소값 : " + System.identityHashCode(i1));
		System.out.println("i2이 참조하는 객체의 실제주소값 : " + System.identityHashCode(i2));
		System.out.println("i1이 참조하는 객체의 hashCode값 : " + i1.hashCode());
		System.out.println("i2이 참조하는 객체의 hashCode값 : " + i2.hashCode());
		
		System.out.println("----------[toString 테스트]---------------------");
		/**
		 * Object의 toString() 호출 -> 리턴 : getClass().getName() + '@' + Integer.toHexString(hashCode())
		   toString()재정의 전 : object.Student@29d89e5 (29d89e5같은 이유? hashCode()재정의되어 같은 16진수 주소값이 리턴됨)
		   toString()재정의 후 : Student [studentId=1, studentName=강민재]
		 */
		System.out.println(s);  	//object.Student@29d89e5
		System.out.println(s1);		//object.Student@29d89e5
		System.out.println(s2);		//object.Student@29d89e5
	}

}
