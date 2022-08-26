package ex03main;

import java.util.Scanner;
import ex03.Student;

public class StudentMain2 {

	public static void main(String[] args) {
		//조건추가 : 키보드로부터 '학생이름, 국어점수, 영어점수, 수학점수'를 각각 입력받은 값으로 Student객체 생성
		Scanner sc = new Scanner(System.in);
		
		System.out.print("학생 이름 입력 > ");
		String studentName = sc.next();
		
		System.out.print("국어 점수 입력 > ");
		int korean = sc.nextInt();
		
		System.out.print("영어 점수 입력 > ");
		int english = sc.nextInt();
		
		System.out.print("수학 점수 입력 > ");
		int math = sc.nextInt();
		
		Student student = new Student(studentName, korean, english, math);
		
		System.out.println("이름 : " + student.studentName); 		//멤버변수 직접접근
		
		System.out.println("총점 : " + student.getTotalScore());	//멤버변수 간접접근
		System.out.println("평균 : " + student.getAVG());
		
		//sc.close();
	}

}

/* 아래의 결과가 나오도록 하기(접근제한자 고려)

[출력결과]
학생 이름 입력 > 홍길동
국어 점수 입력 > 98
영어 점수 입력 > 97
수학 점수 입력 > 95

이름 : 홍길동
총점 : 290
평균 : 96.666666...7
*/