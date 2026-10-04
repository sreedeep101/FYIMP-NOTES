import java.applet.Applet;
import java.awt.Graphics;

public class AppletLifeCycle extends Applet {

	public void init(){
		System.out.println("init() method is excecuted");
	}

	public void start(){
		System.out.println("start() mehthod is executed");
	}

	public void paint(Graphics g) {
		System.out.println("paint() method is excecuted");

		g.drawString("Applet Life Cycle", 150,100);
		g.drawString("init(), start(), paint(), stop(), destroy()", 80, 130);

	}

	public void stop(){
		System.out.println("stop() method is executed");
	}

	public void destroy(){
		System.out.println("destroy() method is executed");
	}


}
