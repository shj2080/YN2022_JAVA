//Person.java -> Person.class(컴파일된 class 파일)
package classex;

public class Person {
	private String name;
	private int age;
	
	public Person() { //기본값으로 채우는 생성자
		super();
	}

	public Person(String name) { //'이름 필드'에 매개값으로 채우는 생성자
		super();
		this.name = name;
	}

	public Person(String name, int age) { //'이름과 나이 필드'에 매개값으로 채우는 생성자
		super();
		this.name = name;
		this.age = age;
	}

	//private 필드에 간접접근
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
