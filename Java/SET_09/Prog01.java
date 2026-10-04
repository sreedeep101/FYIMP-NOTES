import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class StudentRegistration extends JFrame implements ActionListener {

    JTextField nameField;
    JTextField regField;

    JRadioButton male;
    JRadioButton female;

    JCheckBox sports;
    JCheckBox music;

    JComboBox<String> course;

    JButton submit;
    JButton clear;

    StudentRegistration() {

        setTitle("Student Registration");
        setSize(400, 400);
        setLayout(new FlowLayout());

        add(new JLabel("Name:"));
        nameField = new JTextField(20);
        add(nameField);

        add(new JLabel("Register No:"));
        regField = new JTextField(20);
        add(regField);

        add(new JLabel("Gender:"));

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        ButtonGroup gender = new ButtonGroup();
        gender.add(male);
        gender.add(female);

        add(male);
        add(female);

        add(new JLabel("Hobbies:"));

        sports = new JCheckBox("Sports");
        music = new JCheckBox("Music");

        add(sports);
        add(music);

        add(new JLabel("Course:"));

        String courses[] = {
            "Computer Science",
            "Electronics",
            "Mechanical"
        };

        course = new JComboBox<>(courses);
        add(course);

        submit = new JButton("Submit");
        clear = new JButton("Clear");

        add(submit);
        add(clear);

        submit.addActionListener(this);
        clear.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submit) {

            String gender = "";

            if (male.isSelected())
                gender = "Male";
            else if (female.isSelected())
                gender = "Female";

            String hobbies = "";

            if (sports.isSelected())
                hobbies = hobbies + "Sports ";

            if (music.isSelected())
                hobbies = hobbies + "Music";

            JOptionPane.showMessageDialog(
                this,
                "Name: " + nameField.getText()
                + "\nRegister No: " + regField.getText()
                + "\nGender: " + gender
                + "\nHobbies: " + hobbies
                + "\nCourse: " + course.getSelectedItem()
            );
        }

        if (e.getSource() == clear) {

            nameField.setText("");
            regField.setText("");

            male.setSelected(false);
            female.setSelected(false);

            sports.setSelected(false);
            music.setSelected(false);

            course.setSelectedIndex(0);
        }
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}
