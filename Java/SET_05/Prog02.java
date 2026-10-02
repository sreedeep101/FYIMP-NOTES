class ThreadOne extends Thread {
	@Override 
	public void run(){
		for(int i = 1; i<=5 ; i++){
			System.out.println("Number : " + i);

			try {
				Thread.sleep(100);
			}
			catch (InterruptedException e){
				System.out.println("number thread interrupted!");
			}
		}
	}
}

class ThreadTwo extends Thread { 
	@Override 
	public void run(){
		for (char ch = 'A' ; ch <= 'E';ch++){
			System.out.println("Character : " + ch);

			try {
				Thread.sleep(100);
			}
			catch (Exception e){
				System.out.println("charcter thread interrupted!");
			}
		}
	}
}

class ThreadThree extends Thread {
	@Override 
	public void run(){
		for (int i = 1; i <= 5 ; i++){
			System.out.println("Message: Hello from Threads");

			try {
				Thread.sleep(100);
			}
			catch (Exception e){
				System.out.println("Message thread interupted!");
			}
		}
	}
}

class multipleThreadDemo{
	public static void main(String args[]){
		ThreadOne t1 = new ThreadOne();
		ThreadTwo t2 = new ThreadTwo();
		ThreadThree t3 = new ThreadThree();

		t1.start();
		t2.start();
		t3.start();
	}
}
