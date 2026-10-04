import java.awt.*;
import java.awt.event.*;

class Calculator extends Frame implements ActionListener {

	TextField num1Field, num2Field, resultField;
	Button addButton , subButton, mulButton , divButton;

	public Calculator(){

		setTitle("Simple Calculator");
		setSize(400, 300);
		setLayout(new GridLayout(5,2,10,10));

		add(new Label("First Number:"));
		num1Field = new TextField();
		add(num1Field);

		add(new Label("Second Number:"));
		num2Field = new TextField();
		add(num2Field);

		addButton = new Button("+");
		subButton = new Button("-");
		mulButton = new Button("*");
		divButton = new Button("/");

		add(addButton);
		add(subButton);
		add(mulButton);
		add(divButton);

		add(new Label("Result:"));
		resultField = new TextField();
		resultField.setEditable(false);
		add(resultField);

		addButton.addActionListener(this);
		subButton.addActionListener(this);
		mulButton.addActionListener(this);
		divButton.addActionListener(this);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				dispose();
			}
		});

		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			double num1 = Double.parseDouble(num1Field.getText());
			double num2 = Double.parseDouble(num2Field.getText());
			double result = 0;

			if (e.getSource() == addButton){
				result = num1 + num2;

			}
			else if(e.getSource() == subButton){
				result = num1 - num2;
			}
			else if(e.getSource() == mulButton){
				result = num1 * num2;
			}
			else if(e.getSource() == divButton){
				if(num2 == 0){
					resultField.setText("Cannot divide by zero");
					return;
				}
				result = num1/num2;
			}

			resultField.setText(String.valueOf(result));

		}
		catch (NumberFormatException ex) {
			resultField.setText("Invalid input");
		}
	
	}

	public static void main(String[] args){
		new Calculator();
	}
}


