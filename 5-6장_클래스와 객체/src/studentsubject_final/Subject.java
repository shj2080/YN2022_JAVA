package studentsubject_final;

public class Subject {// 과목
	// 정보보안 : private
	private String subjectName; // 과목명
	private int subjectScore; // 과목성적

	public Subject(String subjectName, int subjectScore) {
		this.subjectName = subjectName;
		this.subjectScore = subjectScore;
	}

	// 외부에서 접근가능한 메서드를 통해 private 멤버변수에 간접접근
	public String getSubjectName() {
		return subjectName;
	}

	//Ctrl + Shift + / 로 블럭 주석설정 가능 (해제 시 뒤에 /키 대신 \키)
	/*
	 * public void setSubjectName(String subjectName) { this.subjectName =
	 * subjectName; }
	 */

	public int getSubjectScore() {
		return subjectScore;
	}

	/*
	 * public void setSubjectScore(int subjectScore) { this.subjectScore =
	 * subjectScore; }
	 */

	@Override
	public String toString() {
		return subjectName + "과목 : " + subjectScore + "점";
	}
}
