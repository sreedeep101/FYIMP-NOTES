class Animal{
	public void sound() {
		System.out.println("Sound of an animal");
	}
}

class Cat extends Animal{
	public void sound(){
		System.out.println("Sound of Cat : meow meow ");
	}
}

class Dog extends Animal{
	public void sound() {
		System.out.println("Sound of Dog : boww bow ");
	}
}

class OverrideDemo {
	public static void main(String args[]){
		Animal animal = new Animal();
		Cat cat = new Cat();
		Dog dog = new Dog();

		animal.sound();
		dog.sound();
		cat.sound();

	}
}
