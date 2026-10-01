abstract class Vehicle{
	abstract void start();

	void display(){
		System.out.println("This is a vehicle");
	}
}

class Car extends Vehicle{
	void start(){
		System.out.println("Car starts with a key!");
	}
}

class Bike extends Vehicle{
	void start(){
		System.out.println("bike starts with a self start button ! ");
	}
}

class AbstractDemo{
	public static void main(String args[]){
		Bike bike = new Bike();
		bike.start();
		bike.display();

		Car car = new Car();
		car.start();
		car.display();
	}
}
