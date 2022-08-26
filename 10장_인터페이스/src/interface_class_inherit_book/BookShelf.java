package interface_class_inherit_book;
/**
 * BookShelf(=책장) 클래스는 책을 넣은 순서대로 꺼낼 수 있는 클래스
 */
public class BookShelf extends Shelf implements Queue {

	@Override
	public void endQueue(String title) {
		shelf.add(title);
	}

	@Override
	public String firstQueue() {
		return shelf.remove(0);
	}

	@Override
	public int getSize() {
		//return shelf.size();
		return getCount();
	}
	
}
