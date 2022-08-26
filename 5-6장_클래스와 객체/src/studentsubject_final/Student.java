package studentsubject_final;

import java.util.ArrayList;

public class Student { //설계도
	//1. 멤버변수(=filed) : 속성
	public int studentID;
	public String studentName;

	//★★ 수강하는 과목들을 처리해주는 멤버변수(클래스 간의 포함관계) - 한 학생이 여러 과목을 수강할 수 있으므로
	private ArrayList<Subject> subjectList; //순서-1
	
	//2. 생성자
	public Student(int studentID, String studentName) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		
		subjectList = new ArrayList<Subject>(); //순서-2
	}
	
	//3. 메서드(=소문자로 시작~()) : 기능
	//학생이 수강하는 과목과 그 해당 점수를 추가하는 메서드
	public void addSubject(String subjectName, int subjectScore) {
		//Subject subject = new Subject(subjectName, subjectScore);
		//subjectList.add(subject);
		
		subjectList.add(new Subject(subjectName, subjectScore));
	}
	
	/* 학생이 수강하는 과목들의 성적 출력, 총점과 평균 출력하는 메서드
	 * --------------------
	 * < 1번 학생 홍길동 >
	 * 자바 과목 성적 : 95점
	 * 오라클 과목 성적 : 98점
	 * --------------------
	 * 총점: 193점
	 * 평균: 96.5점
	 * --------------------
	 */
	public void showStudentInfo() {
		System.out.println("--------------------");
		System.out.println("< " + this.studentID + "번 학생 " + this.studentName +" >"); //같은 클래스 내에서 this. 생략가능(매개변수명과 멤버변수명 동일할 경우 생략불가)
		
		double totalScore = 0; //0 -> 0.0
		for(Subject s:subjectList) {
			System.out.println(s.getSubjectName() + " 과목 성적 : " + s.getSubjectScore() + "점");
			
			totalScore += s.getSubjectScore(); //0+95+98
		}
		
		System.out.println("--------------------");
		System.out.println("총점 : " + totalScore + "점");
		//System.out.println("평균 : " + totalScore / subjectList.size() + "점");
		System.out.printf("평균 : %.1f점 \n", totalScore / subjectList.size()); //%.1f : 반올림하여 소수 첫째자리까지 출력
		System.out.println("--------------------");

		/* [개인풀이] - for문 사용
		int totalScore = 0;
		
		System.out.println("--------------------");
		System.out.println("< " + studentID + "번 학생 " + studentName +" >");
		
		for(int i = 0; i < subjectList.size(); i++) {
			System.out.println(subjectList.get(i).getSubjectName() + " 과목 성적 : " + subjectList.get(i).getSubjectScore() + "점");
			
			totalScore += subjectList.get(i).getSubjectScore(); //총점 계산
		}
		
		System.out.println("--------------------");
		System.out.println("총점: " + totalScore + "점");
		System.out.println("평균: " + (double)totalScore / subjectList.size() + "점"); //double로 변환
		System.out.println("--------------------");
		*/
	}

	@Override
	public String toString() {
		return studentID + "번 학생 " + studentName + "\n" + subjectList + totalScore_Avg();
	}
	
	private String totalScore_Avg() {
		double totalScore = 0; //0 -> 0.0
		for(Subject s:subjectList) {			
			totalScore += s.getSubjectScore(); //0+95+98
		}
		
		return "\n총점 : " + totalScore + "점\n" + "평균 : " + totalScore / subjectList.size() + "점\n";
	}
	
}
