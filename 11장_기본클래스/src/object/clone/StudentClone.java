/** <Object의 clone()메서드>
 * 1. 얕은 복제 : 멤버변수(=필드)만 복제
 * (1). 기본타입(int, double, char, boolean...) : '값'을 복사
 * (2). 클래스타입(String, Integer..객체의 주소)	 : '객체의 주소' 복사
 * 		배열(int[], double[],...)				  : '객체의 주소' 복사
 * 		=>즉, 객체를 통째로 복사하지만 객체가 참조하는 또 다른 객체까지 복사하지 못한다.
 * 		  그래서 아래의 문제점이 발생함
 * 
 * 2. 얕은 복제의 문제점
 * 복제 객체에서 참조변수가 참조하는 객체의 값 또는 주소를 변경하면
 * 원본 객체도 참조변수가 참조하는 객체의 값 또는 주소도 함께 변경
 * (★★단, String은 제외됨 - String은 공유되는 유일한 클래스로 원본객체의 값을 변경할 수 없다.)
 * 
 */
package object.clone;

import java.util.Arrays;

class Computer {
	String brand;

	Computer(String brand) {
		super();
		this.brand = brand;
	}

}//Computer 끝

/**
 * Cloneable 구현하지 않고 clone()메서드 호출하면
 * CloneNotSupportedException 예외객체 발생하여 복제 실패
 * <※Cloneable 인터페이스를 구현해야 하는 이유?>
 *  clone()메서드를 사용하면 객체의 정보(멤버변수 값)가 같은 객체가 하나 더 생성되는 것이므로
 *  객체지향프로그램의 '정보은닉', 객체 보호의 관점에서 위배될 수 있으므로
 *  객체의 clone()메서드 사용을 허용한다는 의미로 Cloneable 인터페이스를 명시해 줌
 */

//Cloneable 구현함으로써 "객체를 복제할 수 있는 클래스"라고 알림
class Student implements Cloneable { //부모 : Object
	/*
	 * 깊은 복제 대상 : 배열, 클래스타입(★단, String제외)
	 */
	int studentId; 		//아이디-기본타입 : 깊은복제 대상에서 제외
	String studentName; //이름-String : 깊은복제 대상에서 제외(이유? 원본 객체의 값 변경 불가. 변경하면 새 객체가 생성됨)

	//private int[] scores;		//점수들-배열 : 깊은복제 대상
	int[] scores;		//점수들-배열		   : 깊은복제 대상
	Computer com;		//컴퓨터-클래스타입 	   : 깊은복제 대상
	
	Student(int studentId, String studentName, int[] scores, Computer com) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.scores = scores;
		this.com = com;
	}
	
	/*
	@Override //재정의 : 얕은복제
	protected Object clone() throws CloneNotSupportedException {
		return super.clone(); //Object.clone()호출 : 얕은복제
	}
	*/

	/**
	 * [메서드 재정의] : 부모로부터 상속받은 메서드를 그대로 사용하지 않고 자식클래스에서 재정의
	 * 1. '리턴타입과 메서드이름(매개변수)'가 부모와 같아야 한다.
	 * 	  (단, 리턴타입은 자식클래스 타입으로 변경가능하다. => 뒤에서 예제와 함께 설명 : 11장_StudentClone.java)
	 * 
	 * 2. ★★ 재정의할 때 '접근제한자는 부모와 같거나 더 넓은 범위로' 한다.
	 * (그래야 부모의 메서드를 재정의된 자식의 메서드로 덮어씌워
	 * 컴파일러가 재정의된 자식 메서드만 호출할 수 있도록 한다.)
	 * ※ public > protected > 아무것도 없는 것(=default) > private
	 * 
	 * 3. 예외는 부모 클래스 메서드의 예외보다 더 많이 선언할 수 없다.
	 */
	@Override //재정의 : 깊은복제
	//protected Object clone() throws CloneNotSupportedException {
	protected Student clone() throws CloneNotSupportedException {
		//1. 먼저 얕은복제로 객체를 통째로 복사한다.
		Student cpyStudent = (Student) super.clone(); //Object의 clone() 호출하여 얕은복제 (리턴값 Student로 강제형변환)
		
		//2. '깊은복제의 대상'이 되는 객체들을 복제한다.
		cpyStudent.scores = Arrays.copyOf(this.scores, this.scores.length);//배열복제
		cpyStudent.com = new Computer(this.com.brand);					//Computer 객체 복제
		
		//3. 깊은 복제된 cpy를 리턴한다. (Student 리턴)
		return cpyStudent; 
	}
	
	Student copyStudent() {
		Student cpyStudent = null;
		
		try {
			//cpyStudent = (Student) clone(); //재정의 안할 경우 Object의 clone() 호출하여 얕은복제
			cpyStudent = clone(); 		//Student의 재정의한 clone() 호출하여 깊은복제
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return cpyStudent;
	}
	
	
	void showStudentInfo() {
		System.out.println("아이디 : " + studentId);
		System.out.println("이름 : " + studentName);
		System.out.println("점수 : " + Arrays.toString(scores)); //[,,]
		System.out.println("컴퓨터 브랜드 : " + com.brand);
	}
	
	
}//Student의 끝

public class StudentClone {

	public static void main(String[] args) {
		
		
		Student orgStudent = new Student(3, "이순신", new int[] {99, 93}, new Computer("LG"));
		System.out.println("[원본 학생]");
		orgStudent.showStudentInfo();
		
		System.out.println(); //구분위한 빈줄
		
		Student cpyStudent = orgStudent.copyStudent();
		System.out.println("[복제 학생]");
		cpyStudent.showStudentInfo();
		
		System.out.println("-- 복제 학생 값 변경 --");
		cpyStudent.studentId = 2;
		cpyStudent.studentName = "홍길동";
		cpyStudent.scores[0] = 0;
		cpyStudent.com.brand = "삼성";
		
		System.out.println("[복제 학생 값 변경 후 원본 학생]");
		orgStudent.showStudentInfo();
		
		System.out.println(); //구분용 빈 줄
		
		System.out.println("[복제 학생 값 변경 후 복제 학생]");
		cpyStudent.showStudentInfo();
		
		/************************************
		 	
			[원본 학생]
			아이디 : 3
			이름 : 이순신
			점수 : [99, 93]
			컴퓨터 브랜드 : LG
			
			[복제 학생]
			아이디 : 3
			이름 : 이순신
			점수 : [99, 93]
			컴퓨터 브랜드 : LG
			
			==얕은 복제 테스트======================
			-- 복제 학생 값 변경 --
			[복제 학생 값 변경 후 원본 학생]
			아이디 : 3
			이름 : 이순신
			점수 : [0, 93] 	=> 원본 수정(문제발생:이유?얕은 복제) 해결법:깊은 복제
			컴퓨터 브랜드 : 삼성 => 원본 수정(문제발생:이유?얕은 복제)
			
			[복제 학생 값 변경 후 복제 학생]
			아이디 : 2
			이름 : 홍길동
			점수 : [0, 93]
			컴퓨터 브랜드 : 삼성
			
			
			==깊은 복제 테스트======================
			-- 복제 학생 값 변경 --
			[복제 학생 값 변경 후 원본 학생]
			아이디 : 3
			이름 : 이순신
			점수 : [99, 93]	=> 원본 그대로
			컴퓨터 브랜드 : LG	=> 원본 그대로
			
			[복제 학생 값 변경 후 복제 학생]
			아이디 : 2
			이름 : 홍길동
			점수 : [0, 93]
			컴퓨터 브랜드 : 삼성
		 ************************************/
	}

}
