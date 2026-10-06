import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SwingLoginForm extends JFrame implements ActionListener {

    JTextField username;
    JPasswordField password;

    JButton login;
    JButton reset;
    JButton exit;

    SwingLoginForm() {

        setTitle("Login Form");
        setSize(350, 250);
        setLayout(new FlowLayout());

        add(new JLabel("Username:"));

        username = new JTextField(20);
        add(username);

        add(new JLabel("Password:"));

        password = new JPasswordField(20);
        add(password);

        login = new JButton("Login");
        reset = new JButton("Reset");
        exit = new JButton("Exit");

        add(login);
        add(reset);
        add(exit);

        login.addActionListener(this);
        reset.addActionListener(this);
        exit.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login) {

            String user = username.getText();
            String pass = new String(password.getPassword());

            if (user.equals("admin") && pass.equals("1234")) {

                JOptionPane.showMessageDialog(
                    this,
                    "Login Successful"
                );
            }
            else {

                JOptionPane.showMessageDialog(
                    this,
                    "Invalid Username or Password"
                );
            }
        }

        if (e.getSource() == reset) {

            username.setText("");
            password.setText("");
        }

        if (e.getSource() == exit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new SwingLoginForm();
    }
}
