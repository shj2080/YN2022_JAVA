package classtest;

public class StringMain {

	public static void main(String[] args) {
		String s1 = "a";
		String s2 = "a";
		String s3 = new String("a");
		
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		System.out.println(System.identityHashCode(s3));
	}

}
