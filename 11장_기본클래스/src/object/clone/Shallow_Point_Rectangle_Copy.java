package object.clone;

class Point implements Cloneable{ //1. 객체를 복제할 수 있는 클래스라고 반드시 명시 - Cloneable 인터페이스 구현(implements Cloneable) 
	private int x;
	private int y;
	
	Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	void showPosition() {
		System.out.printf("[%d, %d]", x, y);
	}

	//매개값으로 기존값을 변경
	void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override //2. Object로부터 상속받은 clone() 재정의하여 Point객체를 복제할 수 있도록 재정의함
	protected Object clone() throws CloneNotSupportedException {
		return super.clone(); //얕은 복제 (기본타입은 값만 복제, 배열이나 클래스 변수(String제외)는 주소값을 복제)
	} 
	
}//Point 클래스 끝

//1. 객체를 복제할 수 있는 클래스라고 반드시 명시(명시안하면 clone() 호출할 때 예외발생=>프로그램 강제 멈춤)
class Rectangle implements Cloneable { 
	//[Point 포함관계 순서-1]
	private Point upperLeft, lowerRight;
	
	Rectangle(int x1, int y1, int x2, int y2) {
		super(); //컴파일러가 매개변수 없는 생성자 자동으로 넣음
		upperLeft = new Point(x1, y1);		//[Point 포함관계 순서-2]
		lowerRight = new Point(x2, y2);
	}
	
	void showPosition() {
		System.out.println("사각형의 위치정보....");
		System.out.print("좌 상단 : "); 
		upperLeft.showPosition(); 		//[x1, y1]
		
		System.out.print(", 우 하단 : ");
		lowerRight.showPosition();		//[x2, y2]
		
		System.out.println("\n"); //커서 내리고 빈 줄 \n\n
	}
	
	//매개값으로 기존값을 변경
	void setPosition(int x1, int y1, int x2, int y2) { //3,3  4,4
		upperLeft.setPosition(x1, y1);
		lowerRight.setPosition(x2, y2);
	}

	//★★오버라이딩(=재정의)할 때 부모 메서드의 반환타입을 '자손 클래스의 타입으로 변경'을 허용한다.
	@Override
	protected Rectangle clone() throws CloneNotSupportedException {
		return (Rectangle) super.clone(); 
	}
	
}//Rectangle 클래스 끝

public class Shallow_Point_Rectangle_Copy {

	public static void main(String[] args) {
		System.out.println("---- Point 복제 테스트 ----");
		Point orgPoint = new Point(1, 1);
		System.out.print("원본 Point : ");
		orgPoint.showPosition();
		System.out.println(); //빈 줄
		
		Point pointCpy;
		try {
			if(orgPoint instanceof Point) {
				pointCpy = (Point)orgPoint.clone(); //강제 형변환(DownCasting)
				
				System.out.print("복제 Point : ");
				pointCpy.showPosition();
				System.out.println(); //빈 줄
				
				System.out.println("-- [원본 Point 정보 변경] --");
				orgPoint.setPosition(3, 3);
				
				System.out.print("원본 Point : ");
				orgPoint.showPosition();
				System.out.println(); //빈 줄
				
				System.out.print("복제 Point : ");
				pointCpy.showPosition();
				System.out.println(); //빈 줄
			}
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		System.out.println("-----------------------------------------------");
		System.out.println("---- Point 복제 테스트 ----");
		Rectangle orgRectangle = new Rectangle(1, 1, 9, 9);
		System.out.print("원본 Rectangle : ");
		orgRectangle.showPosition();
		
		Rectangle cpyRectangle;
		try {
			/* 
			if(orgRecangle instanceof Rectangle) {
				cpyRectangle = (Rectangle)orgRectangle.clone();
			}
			 */
			cpyRectangle = orgRectangle.clone();
			System.out.print("복제 Rectangle : ");
			cpyRectangle.showPosition();
			
			System.out.println("-- [복제 Rectangle 정보 변경] --");
			cpyRectangle.setPosition(2, 2, 7, 7);
			
			System.out.print("원본 Rectangle : ");
			orgRectangle.showPosition();
			
			System.out.print("복제 Rectangle : ");
			cpyRectangle.showPosition();
			
		} catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
		}
		
	}

}
