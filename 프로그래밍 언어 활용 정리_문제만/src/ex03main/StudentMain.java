package ex03main;



public class StudentMain {

	public static void main(String[] args) {
		Student student = new Student("이순신", 95, 87, 100);
		
		System.out.println("이름 : " + student.studentName);//멤버변수 직접접근
		
		System.out.println("총점 : " + student.getTotalScore());//멤버변수 간접접근
		System.out.println("평균 : " + student.getAVG());
	}

}
/* 아래의 결과가 나오도록 하기(접근제한자?)
 [출력결과]
 이름 : 이순신
 총점 : 282
 평균 : 94.0 
 */

