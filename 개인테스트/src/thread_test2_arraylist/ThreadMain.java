//Thread 기본구조 테스트용 패키지
package thread_test2_arraylist;

public class ThreadMain {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Data(10)); //Thread 객체 생성
		t1.setName("ArrayList_Add_Thread");
		t1.start(); //Thread 시작
		
		Thread t2 = new Thread(new Runnable() { //다른 Thread가 ArrayList 읽기 (Runnable 익명객체)

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() +  " 시작");
				for(String strValue:Data.str) {
					System.out.println(strValue);
				}
				System.out.println(Thread.currentThread().getName() + " 끝남");
			}
			
		});
		t2.setName("ArrayList_Read_Thread");
		t2.start();
		
		System.out.println("Thread 모두 생성됨.");
		
		for(int i = 0; i <= 10; i++) {
			System.out.println("Main 다른 작업중:" + i);
		}
		
		System.out.println("Main 끝남");
		
	}

}
