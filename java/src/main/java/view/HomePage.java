package view;

import javax.swing.*;

import core.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage {

    public HomePage(JFrame frame, Controller controller) {
        initializeComponents(frame, controller);
    }

    private void initializeComponents(JFrame frame, Controller controller) {
        // Pulizia della finestra
        frame.getContentPane().removeAll();

        // Creazione della HomePage
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new GridBagLayout());
        JButton loginButton = new JButton("Login");
        JButton adminButton = new JButton("Administrator");

        // ActionListener per il bottone Login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginPage(frame, controller); // Passa alla LoginPage
            }
        });

        // ActionListener per il bottone Administrator
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdministratorPage(frame); // Passa alla AdministratorPage
            }
        });

        homePanel.add(loginButton);
        homePanel.add(adminButton);
        frame.add(homePanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }
}
