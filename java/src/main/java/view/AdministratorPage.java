package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministratorPage {

    public AdministratorPage(JFrame frame) {
        initializeComponents(frame);
    }

    private void initializeComponents(JFrame frame) {
        // Pulizia della finestra
        frame.getContentPane().removeAll();

        // Creazione della AdministratorPage
        JPanel adminPanel = new JPanel();
        adminPanel.setLayout(new GridBagLayout());
        JButton addGMButton = new JButton("Add GM");
        JButton addPlayerButton = new JButton("Add Player");
        JButton addTeamButton = new JButton("Add Team");
        JButton addStaffButton = new JButton("Add Staff");

        // ActionListener per i pulsanti
        addGMButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logica per aggiungere un GM
                JOptionPane.showMessageDialog(frame, "Aggiungi GM", "Add GM", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        addPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logica per aggiungere un Player
                JOptionPane.showMessageDialog(frame, "Aggiungi Giocatore", "Add Player", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        addTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logica per aggiungere una Team
                JOptionPane.showMessageDialog(frame, "Aggiungi Team", "Add Team", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        addStaffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logica per aggiungere un Staff
                JOptionPane.showMessageDialog(frame, "Aggiungi Staff", "Add Staff", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        adminPanel.add(addGMButton);
        adminPanel.add(addPlayerButton);
        adminPanel.add(addTeamButton);
        adminPanel.add(addStaffButton);

        frame.add(adminPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }
}
