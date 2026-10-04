import java.awt.*;
import java.awt.event.*;

class ColorSelection extends Frame implements ActionListener {

	Panel colorPanel;

	Button redButton, greenButton, blueButton, yellowButton;

	public ColorSelection(){

		setTitle("Color Selection Applicaiton");
		setSize(500,300);
		setLayout(new BorderLayout());

		colorPanel = new Panel();
		colorPanel.setBackground(Color.WHITE);

		redButton = new Button("Red");
		greenButton = new Button("Green");
		blueButton = new Button("Blue");
		yellowButton = new Button("Yellow");

		Panel buttonPanel = new Panel();
		buttonPanel.setLayout(new FlowLayout());
		
		buttonPanel.add(redButton);
		buttonPanel.add(greenButton);
		buttonPanel.add(blueButton);
		buttonPanel.add(yellowButton);

		add(buttonPanel , BorderLayout.NORTH);
		add(colorPanel , BorderLayout.CENTER);

		redButton.addActionListener(this);
		greenButton.addActionListener(this);
		blueButton.addActionListener(this);
		yellowButton.addActionListener(this);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				dispose();
			}
		});

		setVisible(true);
	}

	public void actionPerformed(ActionEvent e){

		if (e.getSource() == redButton) {
			colorPanel.setBackground(Color.RED);
		}
		else if(e.getSource() == greenButton){
			colorPanel.setBackground(Color.GREEN);
		}
		else if(e.getSource() == blueButton){
			colorPanel.setBackground(Color.BLUE);
		}
		else if(e.getSource() == yellowButton){
			colorPanel.setBackground(Color.YELLOW);
		}
	}

	public static void main(String args[]){
		new ColorSelection();
	}
}

