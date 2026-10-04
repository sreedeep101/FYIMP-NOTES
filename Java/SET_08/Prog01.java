import java.awt.*;
import java.awt.event.*;

class StudentRegistration extends Frame implements ActionListener {

	Label nameLabel , regLabel , courseLabel , semesterLabel, genderLabel;
	TextField nameField, regField;
	Choice courseChoice, semesterChoice;
	CheckboxGroup genderGroup;
	Button submitButton, clearButton;
	TextArea resultArea;
	
	public StudentRegistration() {
		
		setTitle("Student Registration Form");
		setSize(500, 500);
		setLayout(new BorderLayout());
		
		Panel formPanel = new Panel();
		formPanel.setLayout(new GridLayout(5,2,10,10));
		
		nameLabel = new Label("Name :");
		nameField = new TextField();
		
		regLabel = new Label("Register Number :");
		regField = new TextField();
		
		courseLabel = new Label("Course :");
		courseChoice = new Choice();
		courseChoice.add("Bsc Computer Science");
		courseChoice.add("BCA");
		courseChoice.add("Bsc Mathematics");
		courseChoice.add("Bcom");
		
		
		semesterLabel = new Label("Semester :");
		semesterChoice = new Choice();
		semesterChoice.add("1");
		semesterChoice.add("2");
		semesterChoice.add("3");
		semesterChoice.add("4");
		semesterChoice.add("5");
		semesterChoice.add("6");
		
		genderLabel = new Label("Gender :");
		genderGroup = new checkboxGroup();
		male = new checkbox("Male",genderGroup, true);
		female = new checkbox("Female", genderGroup, false);
		
		Panel genderPanel = new Panel();
		genderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		genderPanel.add(male);
		genderPanel.add(female);
		
		formPanel.add(nameLabel);
		formPanel.add(nameField);
		
		formPanel.add(regLabel);
		formPanel.add(regField);
		
		formPanel.add(courseLabel);
		formPanel.add(courseChoice);
		
		formPanel.add(semesterLabel);
		formPanel.add(semesterChoice);
		
		formPanel.add(genderLabel);
		formPanel.add(genderPanel);
		
		Panel buttonPanel = new Panel();
		buttonPanel.setLayout(new FlowLayout());
		
		submitButton = new Button("Submit");
		clearButton = new Button("clear");
		
		buttonPanel.add(submitButton);
		buttonPanel.add(clearButton);
		
		resultArea = new TextArea();
		resultArea.setEditable(false);
		
		add(formPanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.CENTER);
		add(resultArea, BorderLayout.SOUTH);
		
		submitButton.addActionListener(this);
		clearButton.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(windowEvent e) {
				dispose();
			}
		});
		
		setVisible(true);
	
	}
	
	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource() == submitButton) {
			String name = nameField.getText();
           		String regNo = regField.getText();
            		String course = courseChoice.getSelectedItem();
            		String semester = semesterChoice.getSelectedItem();
            		String gender = 			genderGroup.getSelectedCheckbox().getLabel();
            		
            		resultArea.setText(
                		"STUDENT DETAILS\n" +
                		"-----------------------------\n" +
                		"Name          : " + name + "\n" +
                		"Register No   : " + regNo + "\n" +
                		"Course        : " + course + "\n" +
                		"Semester      : " + semester + "\n" +
                		"Gender        : " + gender
            		);
        	}

		else if (e.getSource() == clearButton) {

            		nameField.setText("");
            		regField.setText("");

            		courseChoice.select(0);
            		semesterChoice.select(0);

            		male.setState(true);

            		resultArea.setText("");
        	}
    	}	
    	
    	public static void main(String[] args) {
    		new StudentRegistration();
    	}
}
