package thread_test;

import java.util.List;
import java.util.Vector;

public class Data implements Runnable{
	public int num;
	public static List<String> str; //공유되는 List
	
	public Data() {
		super();
		str = new Vector<String>();
	}

	public Data(int id) {
		super();
		this.num = id;
		str = new Vector<String>();
	}

	@Override
	public void run() {		//Thread가 작업하는 메서드 - Vector에 추가
		System.out.println(Thread.currentThread().getName() +  " 시작");
		for(int i = 0 ; i <= 30; i++) {
			str.add("[" + i + "]번째 문자열");
		}
		System.out.println(Thread.currentThread().getName() +  " 끝남");
	}
	
	
}
