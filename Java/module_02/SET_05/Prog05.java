class TicketBooking {
	private int availableTickets = 5;

	synchronized void bookTicket(String CustomerName, int numberOfTickets) {
		System.out.println(CustomerName + " is trying to book " + numberOfTickets + " tickets...");

		if (availableTickets >= numberOfTickets){

			try {
				Thread.sleep(3000);
			}
			catch (InterruptedException e) {
				System.out.println("Booking interrupted");
			}

			availableTickets -= numberOfTickets;

			System.out.println(CustomerName + " successfully booked " + numberOfTickets + " tickets");
			System.out.println("Remaining Tickets : " + availableTickets);
			System.out.println("----------------------------------------");
		}
		else {
			System.out.println(CustomerName + " could not book " + numberOfTickets + " tickets. Not enough tickets.");

			System.out.println("Remaining Tickets : " + availableTickets);
			System.out.println("----------------------------------------");
		}
	}
}

class Customer implements Runnable {
	private TicketBooking booking ;
	private String customerName;
	private int numberOfTickets;

	Customer(TicketBooking booking, String customerName , int numberOfTickets){
		this.booking = booking ;
		this.customerName = customerName;
		this.numberOfTickets = numberOfTickets;
	}

	@Override
	public void run(){
		booking.bookTicket(customerName, numberOfTickets);
	}
}

class TicketBookingDemo {

	public static void main(String args []) throws InterruptedException {

		TicketBooking booking = new TicketBooking();

		Customer c1 = new Customer(booking , "customer 1", 2);
		Customer c2 = new Customer(booking , "customer 2", 2);
		Customer c3 = new Customer(booking , "customer 3", 2);

		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		Thread t3 = new Thread(c3);

		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();
	}

}

	




