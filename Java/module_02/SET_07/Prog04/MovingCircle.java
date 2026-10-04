import java.applet.Applet;
import java.awt.Graphics;

public class MovingCircle extends Applet implements Runnable {
	int x = 0;
	int y = 100;
	int diameter = 50;

	Thread animationThread;
	boolean running = false;


	public void init(){
		x = 0;
		y = 100;

		animationThread = new Thread(this);
		System.out.println("init() excecuted");
	}

	public void start(){
		running = true;

		if(!animationThread.isAlive()) {
			animationThread = new Thread(this);
			animationThread.start();
		}

		System.out.println("start() excecuted");
	}
	public void paint(Graphics g){
		g.drawOval(x,y,diameter,diameter);
	}

	public void run(){
		while (running){
			x = x + 5;
			if(x > getWidth()) {
				x = -diameter;
			}
			repaint();

			try {
				Thread.sleep(50);
			}
			catch (InterruptedException e) {
				System.out.println("Animation Interrupted");
			}
		}
	}

	public void stop(){
		running = false;

		System.out.println("stop() excecuted");
	}
}
