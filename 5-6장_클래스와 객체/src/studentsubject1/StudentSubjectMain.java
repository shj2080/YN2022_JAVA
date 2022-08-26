package studentsubject1;

public class StudentSubjectMain {
	//기본생성자
	public static void main(String[] args) {
		System.out.println("*** Student 각각 생성하여 처리 ***");
		Student s1 = new Student(100, "홍길동");
		s1.addSubject("자바", 96);
		s1.addSubject("오라클", 90);
		
		Student s2 = new Student(101, "제우스");
		s2.addSubject("HTML", 99);
		s2.addSubject("자바", 91);
		s2.addSubject("자바스크립트", 98);
		
		s1.showStudentInfo();
		System.out.println(); //구분용 빈줄
		s2.showStudentInfo();
		
	}

}
