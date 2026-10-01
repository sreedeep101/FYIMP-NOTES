class Shape{
	public void draw(){
		System.out.println("This is a Shape object");
	}
}

class Circle extends Shape {
	@Override
	public void draw(){
		System.out.println("This is a Circle");
	}
}

class Rectangle extends Shape {
	@Override
	public void draw(){
		System.out.println("This is Rectangle");
	}
}

class DynamicMethodDispatchDemo {
	public static void main(String args[]){
		Shape s;
		s = new Circle();
		s.draw();
		s = new Rectangle();
		s.draw();
	}
}
