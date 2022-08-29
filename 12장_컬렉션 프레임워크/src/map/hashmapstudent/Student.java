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
	
	//기준 : 학번과 이름이 같으면 같은 Student객체로 취급
	@Override
	public String toString() {
		return "학생 [아이디=" + studentID + ", 이름="+studentName+"]";
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(studentID, studentName);
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

	
	@Override
	public boolean equals(Object obj) {		
		Student s = (Student)obj;
		if(s.studentID == this.studentID && s.studentName.equals(this.studentName)) return true;
		
	    return false;
	}
	
	
	
  

	
	
	
}
