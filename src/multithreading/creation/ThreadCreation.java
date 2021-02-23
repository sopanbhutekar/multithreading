package multithreading.creation;

public class ThreadCreation {

	public static void main(String[] args) {
		
		//1. BY implementing Runnable Interface
		Thread thread= new Thread(()-> {
			try {
				Thread.sleep(100);
				System.out.println("MyThread: "+Thread.currentThread().getName());
				//throw new RuntimeException();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		});
		thread.setName("MyRunnable");
		thread.start();
		
		thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("uncaughtException occured: ");
				e.printStackTrace();				
			}
		});
		
		//2. By Extending Thread Class
		Thread thread2= new MyThread();
		thread2.setName("MyThread");
		thread2.start();
	}

}

class MyThread extends Thread{
	@Override
	public void run() {
		try {
			Thread.sleep(500);
			System.out.println("Thread: "+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

 
