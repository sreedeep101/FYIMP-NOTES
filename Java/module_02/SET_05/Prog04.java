class BankAccount {

	int balance = 1000;

	synchronized void withdraw(int amount) {
		if (balance >= amount) {
			System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);

			try{
				Thread.sleep(100);
			}
			catch(Exception e){
				System.out.println("Thread interrupted");
			}

			balance = balance - amount;

			System.out.println(Thread.currentThread().getName() + " compleated withdrawal. Balance : " + balance );
		}
		else {
			System.out.println(Thread.currentThread().getName() + " cannot withdraw " + amount + ". Inusufficient balance.");
		}
	}
}

class WithdrawTask implements Runnable {

	BankAccount account;
	
	WithdrawTask(BankAccount account) {
		this.account = account;
	}

	@Override
	public void run() {
		account.withdraw(700);
	}
}

class BankDemo {
	public static void main(String args[]) throws InterruptedException{
		BankAccount account = new BankAccount();

		WithdrawTask ThreadOne = new WithdrawTask(account);
		WithdrawTask ThreadTwo = new WithdrawTask(account);

		Thread t1 = new Thread(ThreadOne);
		Thread t2 = new Thread(ThreadTwo);

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println("final balance : " + account.balance);
	}
}


