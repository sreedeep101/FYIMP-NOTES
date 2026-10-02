class ThreadLifeCycle extends Thread {
	@Override
	public void run() {
		try {
			System.out.println("Thread is Running");

			System.out.println("Thread is going to sleep...");
			Thread.sleep(3000);

			System.out.println("Thread woke up and is Running again");
		}
		catch (InterruptedException e){
			System.out.println("Thread interrupted");
		}
	}

	public static void main(String args[])throws InterruptedException {

		ThreadLifeCycle t = new ThreadLifeCycle();

		System.out.println("After creation: " + t.getState());

		t.start();

		System.out.println("After start() : " + t.getState());

		Thread.sleep(500);

		System.out.println("while thread is running/sleeping : "+ t.getState());
		t.join();
		
		System.out.println("After completion : " + t.getState());
	}
}
