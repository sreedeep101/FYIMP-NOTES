import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class StudentMarkList extends JFrame implements ActionListener {

    JTextField nameField;
    JTextField regField;
    JTextField mark1;
    JTextField mark2;
    JTextField mark3;

    JLabel result;

    JButton calculate;
    JButton clear;
    JButton exit;

    StudentMarkList() {

        setTitle("Student Mark List");
        setSize(400, 400);
        setLayout(new FlowLayout());

        add(new JLabel("Name:"));
        nameField = new JTextField(20);
        add(nameField);

        add(new JLabel("Register No:"));
        regField = new JTextField(20);
        add(regField);

        add(new JLabel("Mark 1:"));
        mark1 = new JTextField(10);
        add(mark1);

        add(new JLabel("Mark 2:"));
        mark2 = new JTextField(10);
        add(mark2);

        add(new JLabel("Mark 3:"));
        mark3 = new JTextField(10);
        add(mark3);

        calculate = new JButton("Calculate");
        clear = new JButton("Clear");
        exit = new JButton("Exit");

        add(calculate);
        add(clear);
        add(exit);

        result = new JLabel("Result");
        add(result);

        calculate.addActionListener(this);
        clear.addActionListener(this);
        exit.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == calculate) {

            try {
                double m1 = Double.parseDouble(mark1.getText());
                double m2 = Double.parseDouble(mark2.getText());
                double m3 = Double.parseDouble(mark3.getText());

                if (m1 < 0 || m1 > 100 ||
                    m2 < 0 || m2 > 100 ||
                    m3 < 0 || m3 > 100) {

                    JOptionPane.showMessageDialog(
                        this,
                        "Marks must be between 0 and 100"
                    );

                    return;
                }

                double total = m1 + m2 + m3;
                double average = total / 3;

                String grade;

                if (average >= 90)
                    grade = "A";
                else if (average >= 75)
                    grade = "B";
                else if (average >= 60)
                    grade = "C";
                else if (average >= 50)
                    grade = "D";
                else
                    grade = "F";

                result.setText(
                    "Total: " + total
                    + "  Average: " + average
                    + "  Grade: " + grade
                );
            }
            catch (Exception ex) {

                JOptionPane.showMessageDialog(
                    this,
                    "Enter valid marks"
                );
            }
        }

        if (e.getSource() == clear) {

            nameField.setText("");
            regField.setText("");

            mark1.setText("");
            mark2.setText("");
            mark3.setText("");

            result.setText("Result");
        }

        if (e.getSource() == exit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new StudentMarkList();
    }
}
