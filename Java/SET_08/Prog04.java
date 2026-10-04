import java.awt.*;
import java.awt.event.*;

class MouseKeyboardDemo extends Frame {

	Label PositionLabel, messageLabel;

	public MouseKeyboardDemo (){
		setTitle("Mouse and Keyboard Event Demo");
		setSize(1000, 600);
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

		PositionLabel  = new Label("Mouse Position: x = 0, y = 0                  ");
		messageLabel = new Label("Click or move the mouse . Press a key.");

		add(PositionLabel);
		add(messageLabel);

		addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {
				PositionLabel.setText("Mouse Position: X = " + e.getX() + ", Y = " + e.getY());

			}
		});

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				messageLabel.setText("Mouse clicked at x  = " +e.getX() + ", Y = "+e.getY());
			}
		});


		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				messageLabel.setText("Key Pressed: " + e.getKeyChar() );
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		setVisible(true);
		requestFocus();

	}
	
	public static void main(String args[]){
		new MouseKeyboardDemo();
	}
}


