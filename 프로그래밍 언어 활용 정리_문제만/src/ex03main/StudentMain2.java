package ex03main;



public class StudentMain2 {

	public static void main(String[] args) {
	//조건추가 : 키보드로부터 '학생이름, 국어점수, 영어점수, 수학점수'를 각각 입력받은 값으로 Student객체 생성
		
		
		
		
		Student student = new Student(, , , );
		
        System.out.println("이름 : " + student.studentName);//멤버변수 직접접근
		
		System.out.println("총점 : " + student.getTotalScore());//멤버변수 간접접근
		System.out.println("평균 : " + student.getAVG());
	}

}

/* 아래의 결과가 나오도록 하기(접근제한자?)

[출력결과]
학생 이름 입력 > 홍길동
국어 점수 입력 > 98
영어 점수 입력 > 97
수학 점수 입력 > 95

이름 : 홍길동
총점 : 290
평균 : 96.666666...7
*/
