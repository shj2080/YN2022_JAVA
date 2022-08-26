package studentsubject1;

public class Subject {// 과목
	//1. 멤버변수(=field) : 속성- 정보보안 : private
	private String subjectName;// 과목명
	private int subjectScore; // 과목성적

	//2.생성자
	public Subject(String subjectName, int subjectScore) {
		super();
		
		this.subjectName = subjectName;
		this.subjectScore = subjectScore;
	}

    //3. 메서드
	// 외부에서 접근가능한 메서드를 통해 private 멤버변수에 간접접근
	public String getSubjectName() {
		return subjectName;
	}

	public int getSubjectScore() {
		return subjectScore;
	}
}
