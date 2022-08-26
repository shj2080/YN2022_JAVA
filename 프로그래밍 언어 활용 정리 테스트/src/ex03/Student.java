package ex03;
//접근제한자는 결과가 나오도록 알아서 넣기
public class Student {
	//1. 멤버변수(=field) - 문제에서 변수타입과 변수명 주어짐
	public String studentName;	//학생이름
	int korean;		//국어점수
	int english;	//영어점수
	int math;		//수학점수
	
	//2. 생성자
	// 기능 : 매개변수의 값으로 멤버변수를 초기화한다.
	// 반환타입 : 없음
	// 매개변수 : 있음
	public Student(String studentName, int korean, int english, int math) {
		super();
		this.studentName = studentName;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	
	//3. 메서드
	//기능 : 국어, 영어, 수학의 점수를 모두 더해서 그 결과를 반환한다.
	//반환타입 : int
	//매개변수 : 없음
	public int getTotalScore() {
		return (korean + english + math);
	}
	
	//기능 : 총점(국어점수+영어점수+수학점수)을 과목수로 나눈 평균을 구하여 그 결과를 반환한다.
	//반환타입 : double
	//매개변수 : 없음
	public double getAVG() {
		return (double)getTotalScore() / 3;
	}
	
}
