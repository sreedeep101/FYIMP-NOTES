import java.awt.*;
import java.awt.event.*;

class StudentPerformance extends Frame implements ActionListener {

    TextField name, regno, mark1, mark2, mark3;
    Button calculate, clear;
    Label result;

    StudentPerformance() {

        setLayout(new FlowLayout());

        add(new Label("Name:"));
        name = new TextField(20);
        add(name);

        add(new Label("Register No:"));
        regno = new TextField(20);
        add(regno);

        add(new Label("Mark 1:"));
        mark1 = new TextField(10);
        add(mark1);

        add(new Label("Mark 2:"));
        mark2 = new TextField(10);
        add(mark2);

        add(new Label("Mark 3:"));
        mark3 = new TextField(10);
        add(mark3);

        calculate = new Button("Calculate");
        clear = new Button("Clear");

        add(calculate);
        add(clear);

        result = new Label();
        add(result);

        calculate.addActionListener(this);
        clear.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setSize(400, 400);
        setTitle("Student Performance");
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == calculate) {

            try {
                int m1 = Integer.parseInt(mark1.getText());
                int m2 = Integer.parseInt(mark2.getText());
                int m3 = Integer.parseInt(mark3.getText());

                int total = m1 + m2 + m3;
                double average = total / 3.0;

                result.setText(
                    "Total: " + total
                    + " Average: " + average
                );
            }

            catch (Exception ex) {
                result.setText("Invalid marks");
            }
        }

        if (e.getSource() == clear) {

            name.setText("");
            regno.setText("");
            mark1.setText("");
            mark2.setText("");
            mark3.setText("");
            result.setText("");
        }
    }

    public static void main(String[] args) {
        new StudentPerformance();
    }
}
