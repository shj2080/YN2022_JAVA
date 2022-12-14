/**
 * 일반적으로 클래스의 자료형을 모르는 상태에서 Class 클래스를 활용하여 그 클래스의 정보를 가져오고
 * 이 정보를 활용하여 객체를 생성하거나 메서드를 호출하는 방식을 'Reflection'이라고 한다.
 * 
 * Class 클래스는 reflection을 위해 아래 메서드를 제공
 * java.lang.reflect 패키지에 소속되어 있음
 * 각각 생성자 배열, 필드 배열, 메서드 배열로 리턴
 * 1. getDeclaredConstructors(), getDeclaredFields(), getDeclaredMethods()
 * 	  클래스에 선언된 멤버만 가져옴 (※Declared 선언된)
 * 
 * 2. getConstructors(), getFields(), getMethods()
 * 	  클래스에 "선언된" 멤버 + 상속된 멤버까지 얻어옴(★★생성자는 상속이 안되어 부모의 생성자는 얻어올 수 없다.)
 * 	  단, public 멤버만 얻어옴
 */
package classex.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionMain {

	public static void main(String[] args) {
		Class<?> car = null;
		
		try {
			car = Class.forName("classex.reflection.Car");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.print("[패키지명.클래스이름]");
		System.out.println(car.getName());
		
		System.out.print("[클래스이름만]");
		System.out.println(car.getSimpleName());
		
		System.out.println(); //구분용 빈 줄
		
		System.out.println("--------------- Car의 생성자-1 -------------------");
		Constructor<?>[] cons = car.getConstructors(); //Car 생성자만 가져오기(★부모 생성자는 상속안됨)
		for(Constructor<?> con:cons) {
			System.out.println(con);
		}

		System.out.println("--------------- Car의 생성자-2 -------------------");
		cons = car.getDeclaredConstructors(); //Car 생성자만 가져오기
		for(Constructor<?> con:cons) {
			System.out.println(con);
		}
		
		System.out.println(); //구분용 빈 줄
		
		System.out.println("--------------- Car의 필드(=멤버변수)-1 -------------------");
		Field[] fs = car.getFields(); //상속 포함하여 "public" Car 필드 가져오기
		for(Field f:fs) {
			System.out.println(f);
		}
		
		System.out.println("--------------- Car의 필드(=멤버변수)-2 -------------------");
		fs = car.getDeclaredFields(); //Car에 선언된 필드만 가져오기
		for(Field f:fs) {
			System.out.println(f);
		}
		
		System.out.println(); //구분용 빈 줄
		
		System.out.println("--------------- Car의 메서드-1 -------------------");
		Method[] ms = car.getMethods(); //상속 포함하여 "public" Car 메서드 가져오기
		for(Method m:ms) {
			System.out.println(m);
		}

		System.out.println("--------------- Car의 메서드-2 -------------------");
		ms = car.getDeclaredMethods(); //Car 선언된 메서드만 가져오기
		for(Method m:ms) {
			System.out.println(m);
		}

	}

}
