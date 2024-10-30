package view;

import core.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage {

    private final JFrame frame;
    public Controller controller;

    public LoginPage(JFrame mainFrame, Controller controller) {
        this.frame = mainFrame;
        this.controller = controller;
        initializeComponents();
    }

    private void initializeComponents() {
        // Creazione della Login Page
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);
        JButton submitButton = new JButton("Submit");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                if (controller.authenticateGm(email, password)) {
                    new GmPage(frame, controller); // Passa alla GmPage se il login ha successo
                } else {
                    JOptionPane.showMessageDialog(frame, "Credenziali non valide", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        loginPanel.add(emailLabel);
        loginPanel.add(emailField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(submitButton);

        frame.getContentPane().removeAll();
        frame.add(loginPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }
}
