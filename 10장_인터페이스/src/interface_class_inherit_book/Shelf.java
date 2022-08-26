package interface_class_inherit_book;

import java.util.ArrayList;

/**
 * BookShelf(=책장) 클래스는 책을 넣은 순서대로 꺼낼 수 있는 클래스
 */
public class Shelf { //선반
	//[포함관계 순서-1]
	//private ArrayList<String> shelf; //private:정보보안=>캡슐화, 상속불가
	//protected? 자식클래스에서 접근할 수 있도록
	protected ArrayList<String> shelf; 
	
	//[포함관계 순서-2]
	public Shelf() {
		shelf = new ArrayList<String>();
	}

	//[포함관계 순서-3] : 외부에 노출된 메서드
	public ArrayList<String> getShelf() {
		return shelf;
	}
	
	public int getCount() {
		return shelf.size(); //ArrayList에 저장된 String객체 수
	}
}
