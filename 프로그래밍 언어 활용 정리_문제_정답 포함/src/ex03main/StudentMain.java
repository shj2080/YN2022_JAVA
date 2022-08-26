package ex03main;

import ex03.Student; //다른 패키지의 클래스 참조 시 반드시 import 해야 함!

public class StudentMain {

	public static void main(String[] args) {
		Student student = new Student("이순신", 95, 87, 100);
		
		System.out.println("이름 : " + student.studentName);
		System.out.println("총점 : " + student.getTotalScore());
		System.out.println("평균 : " + student.getAVG());
		
	}

}

/* 아래의 결과가 나오도록 하기(접근제한자 고려)
 [출력결과]
 이름 : 이순신
 총점 : 282
 평균 : 94.0
 */