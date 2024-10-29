package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HomePage {

    private final JPanel panel;
    private final JButton loginButton;
    private final JButton adminButton;

    public HomePage() {
        panel = new JPanel(new BorderLayout());
        loginButton = new JButton("Login");
        adminButton = new JButton("Administrator");

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        buttonPanel.add(loginButton);
        buttonPanel.add(adminButton);

        panel.add(new JLabel(new ImageIcon("path_to_background_image.jpg")), BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
    }

    public JPanel getPanel() {
        return panel;
    }

    // Metodi per impostare le azioni dei pulsanti
    public void setLoginButtonAction(ActionListener action) {
        loginButton.addActionListener(action);
    }

    public void setAdminButtonAction(ActionListener action) {
        adminButton.addActionListener(action);
    }
}
