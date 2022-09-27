package thread_test;

public class Data implements Runnable{
	public int num;
	
	public Data() {
		super();
	}

	public Data(int id) {
		super();
		this.num = id;
	}

	@Override
	public void run() {		//Thread가 작업하는 메서드
		System.out.println(Thread.currentThread().getName() +  " 시작");
		for(int i = 0 ; i <= 30; i++) {
			System.out.println(Thread.currentThread().getName() + " 작업중=" + num++);
		}
		System.out.println(Thread.currentThread().getName() +  " 끝남");
	}
	
	
}
