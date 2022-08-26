package studentsubject1;

import java.util.ArrayList;

public class Student {//설계도
	//1. 멤버변수(=field) : 속성
	public int studentID; 		//학생ID
	public String studentName; //학생이름
	
	//★★ 수강하는 과목들을 처리해주는 멤버변수(클래스 간의 포함관계)
	ArrayList<Subject> subjects; //Student 생성자에서 초기화
	
	//2. 생성자
	public Student(int studentID, String studentName) {
		super();
		
		this.studentID = studentID;
		this.studentName = studentName;
		
		subjects = new ArrayList<Subject>();
	}
	
	//3. 메서드(=소문자로시작~()) : 기능
	//학생이 수강하는 과목과 그 해당 점수를 추가하는 메서드
	public void addSubject(String subjectName, int subjectScore) {
		subjects.add(new Subject(subjectName, subjectScore));
	}
	
	
	/* 학생이 수강하는 과목들의 성적, 총점과 평균 출력하는 메서드
	 * ------------------
	 *  < 1번 학생 홍길동 > 
	 * 자바 과목 성적 : 95점
	 * 오라클 과목 성적 : 98점
	 * -------------------	
	 * 총점 : 193점
	 * 평균 : 96.5점
	 * -------------------
	 */
	public void showStudentInfo(){
		double totalScore = 0;
		
		System.out.println("------------------");
		System.out.println("< " + studentID + "번 학생 " + studentName + " >");
		
		for(Subject s:subjects) {
			System.out.println(s.getSubjectName() + " 과목 성적 : " + s.getSubjectScore() + "점");
			totalScore += s.getSubjectScore();
		}
		
		System.out.println("------------------");
		System.out.println("총점 : " + totalScore);
		System.out.printf("평균 : %.1f점\n", totalScore / subjects.size());
		System.out.println("------------------");
	}

	
}











