package script.assertcode;

public class Main {

	public static void main(String[] args) {
		Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(t.getName()+": "+e.getMessage());
				
			}
		});
		int i=2;
		assert true:i;
		System.out.println("aaaaa");
		System.out.println((char)0x546a);
	}

}
