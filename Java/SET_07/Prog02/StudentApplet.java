import java.applet.Applet;
import java.awt.Graphics;

public class StudentApplet extends Applet {

	String name;
	String registerNo;
	String course;
	String Semester;

	public void init(){

		name = getParameter("name");
		registerNo = getParameter("regNo");
		course = getParameter("course");
		Semester = getParameter("semester");
	}

	public void paint(Graphics g){
		g.drawString("STUDENT DETAILS", 150 ,50);

		g.drawString("Name          : " + name, 100,90);
		g.drawString("Register No   : " + registerNo, 100, 110);
		g.drawString("Course        : " + course, 100, 130);
		g.drawString("Semester      : " + Semester , 100, 150);
	}

}

