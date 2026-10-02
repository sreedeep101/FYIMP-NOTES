class ThreadOne implements Runnable {

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

class ThreadTwo implements Runnable { 

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


class multipleThreadDemo{
	public static void main(String args[]){
		ThreadOne threadOne = new ThreadOne();
		ThreadTwo threadTwo = new ThreadTwo();
		
		Thread t1 = new Thread(threadOne);
		Thread t2 = new Thread(threadTwo);

		t1.start();
		t2.start();
	}
}
