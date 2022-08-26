package studentsubject_final;

import java.util.ArrayList;

public class StudentSubjectMain {

	public static void main(String[] args) {
		System.out.println("*** Student 각각 생성하여 처리 ***");
		Student s1 = new Student(1001, "홍길동");
		s1.addSubject("JAVA", 95);
		s1.addSubject("ORACLE", 98);

		Student s2 = new Student(1002, "이순신");
		s2.addSubject("JAVA", 90);
		s2.addSubject("JSP", 88);
		s2.addSubject("HTML", 99);
		
		s1.showStudentInfo();
		System.out.println(); //구분위한 빈줄
		s2.showStudentInfo();
		
		System.out.println("*** ArrayList로 Student 처리 ***"); 
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(s1);
		studentList.add(s2);		
		
		System.out.println("1.재정의 된 toString() 호출결과");
		for(Student student:studentList) {
			//student.toString()메서드 호출한 결과가 출력
			System.out.println(student); 
		}
		System.out.println(); //구분위한 빈줄
		
		System.out.println("2.showStudentInfo() 호출결과");
		for(Student student:studentList) {
			student.showStudentInfo();
		}
	}

}
