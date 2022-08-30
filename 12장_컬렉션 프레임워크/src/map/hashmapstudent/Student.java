package map.hashmapstudent;

import java.util.Objects;

//사용자 정의 클래스 : Key 역할
public class Student { //Key
	int studentID; // 학번
	String studentName; // 이름

	public Student(int studentID, String studentName) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
	}
	
	@Override
	public String toString() {
		return "학생 [아이디=" + studentID + ", 이름="+studentName+"]";
	}

	//재정의 된 hashCode() - 기준 : 학번과 이름이 같으면 같은 Student객체로 취급
	@Override
	public int hashCode() {
		return Objects.hash(studentID, studentName);	//학번과 이름으로 hashcode 만듬.
	}
    /*
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return studentID == other.studentID && Objects.equals(studentName, other.studentName);
	}
    */

	//재정의 된 equals(Object obj) - 멤버변수 학번과 이름을 서로 비교
	@Override
	public boolean equals(Object obj) {		
		Student s = (Student)obj;	//매개변수로 받은 객체를 'Student'타입으로 강제형변환 후 'Student s' 에 대입
		if(s.studentID == this.studentID && s.studentName.equals(this.studentName))
			return true;	//모두 일치하면 true (학번과 이름 모두 같음)
		
	    return false;	//하나라도 일치하지 않는 게 있다면 false
	}
	
}
