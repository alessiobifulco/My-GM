package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginPage {

    private final JPanel panel;
    private final JTextField emailField;
    private final JPasswordField passwordField;
    private final JButton loginButton;

    public LoginPage() {
        panel = new JPanel(new GridLayout(3, 2, 10, 10));

        emailField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");

        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(new JLabel());  // Placeholder per layout
        panel.add(loginButton);
    }

    public JPanel getPanel() {
        return panel;
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public void setLoginAction(ActionListener action) {
        loginButton.addActionListener(action);
    }
}
