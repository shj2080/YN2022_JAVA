//실행용 : main()있는 클래스
/*
 * [접근제한자] public > protected > 아무것도 없는 것(=default) > private
 * 1. public : 어디서든지 접근 가능
 * 2. protected : 같은 패키지에서만 접근 가능(단, 자식은 어디서든 접근 가능=다른 패키지의 자식이라도 접근가능)
 * 3. 아무것도 없는 것(=default) : 같은 패키지에서만 접근 가능(=다른 패키지에서는 접근 불가)
 * 4. private : 같은 클래스안에서만 접근가능(=다른 클래스에서는 접근 불가)
 *  - private 멤버변수는 접근가능한 메서드를 통해서 간접접근할 수 있다.
 *  - private 멤버는 상속불가
 *  
 *  ※ class 앞에 public 있으면 "어디서든지" import 할 수 있다.
 *  			       없으면 "같은 패키지에서만" import 할 수 있다.
 */
package math;

import java.lang.*; //컴파일러가 컴파일하기 전에 자동 삽입
import math.*;//같은 패키지(=math)안의 클래스들은 자동 import(컴파일러가 컴파일하기 전에 자동 삽입)

import static java.lang.Math.*;

import java.util.Scanner;

public class MathMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("[원의 넓이] 반지름 입력 > ");
		double r = sc.nextDouble();
		System.out.println("반지름" + r + "의 원넓이="+Math.circleArea(r)); //클래스명.static 멤버

		System.out.print("[원의 둘레] 반지름 입력 > ");
		r = sc.nextDouble();
		System.out.println("반지름" + r + "의 원둘레="+Math.circleLength(r));
		
		//Math m = new Math(); //private생성자 접근불가
		
		System.out.println("---- 가변인수 이용하지 않은 메서드 ----");
		System.out.print("더할 첫 번째 정수 입력> ");
		int num1 = sc.nextInt();
		System.out.print("더할 두 번째 정수 입력> ");
		int num2 = sc.nextInt();
		
		//입력받은 매개값을 가지고 add() 호출
		System.out.println(num1 + " + " + num2 + " = " + Math.add(num1, num2));
		
		System.out.println("---- 가변인수 이용한 더하기 메서드 ----");
		System.out.println("10="+Math.add(10));
		System.out.println("10+20="+Math.add(10,20));
		System.out.println("10+20+30="+Math.add(10,20,30));
		System.out.println("10+20+30+40="+Math.add(10,20,30,40));
		System.out.println("10+20+30+40+50="+Math.add(10,20,30,40,50));

		System.out.println("---- 가변인수 이용한 곱하기 메서드 ----");
		System.out.println("10="+Math.mul(10));
		System.out.println("10*20="+Math.mul(10,20));
		System.out.println("10*20*30="+Math.mul(10,20,30));
		System.out.println("10*20*30*40="+Math.mul(10,20,30,40));
		System.out.println("10*20*30*40*50="+Math.mul(10,20,30,40,50));
		
		System.out.println("----[ import된 같은 이름의 클래스가 여러개 일 때 ]------------");
		System.out.println("** java.lang.Math의 메서드 호출 **");
		//같은 패키지의 Math를 우선하므로 다른 패키지의 Math는 "패키지이름으로 접근"
		System.out.println("|-3|=" + java.lang.Math.abs(-3)); //|-3|=3
		//java.lang.Math안의 모든 멤버(=필드와 메서드)는 static이다. (※그래서 생성자는 private)
		
		//import static java.lang.Math.*; 하면
		System.out.println("2와 8 중 큰수="+ max(2, 8)); //java.lang.Math. 생략가능
		
	}

}
