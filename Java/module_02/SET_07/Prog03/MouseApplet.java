import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseApplet extends Applet implements MouseListener {
	
	String message = "Move the mouse inside the applet";
	int x = 0;
	int y = 0;

	public void init(){
		addMouseListener(this);
	}

	public void start(){
		message = "Move the mouse inside the applet";
	}

	public void paint(Graphics g){
		g.drawString(message, 50, 80);

		if(x != 0 || y != 0){
			g.drawString("Mouse Clicked at: X = " + x + ", Y = " + y, 50,120);
		}
	}

	public void mouseClicked(MouseEvent e){

		x = e.getX();
		y = e.getY();

		repaint();
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}
