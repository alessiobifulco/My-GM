package view;

import core.Controller;

import javax.swing.*;
import java.awt.*;

public class StaffPage {

    private final JPanel mainPanel;
    private final Controller controller;

    public StaffPage(JPanel mainPanel, Controller controller) {
        this.mainPanel = mainPanel;
        this.controller = controller;
    }

    public void display() {
        mainPanel.removeAll(); // Rimuove i contenuti attuali

        JPanel staffPanel = new JPanel();
        staffPanel.setLayout(new BorderLayout());

        // Aggiungi i componenti specifici per lo staff
        staffPanel.add(new JLabel("Staff Management"), BorderLayout.NORTH);
        JButton coachButton = new JButton("Coach");
        JButton recruiterButton = new JButton("Recruiter");

        coachButton.addActionListener(e -> showCoachPanel());
        recruiterButton.addActionListener(e -> showRecruiterPanel());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(coachButton);
        buttonPanel.add(recruiterButton);
        
        staffPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Aggiungi il pannello staffPanel a mainPanel
        mainPanel.add(staffPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void showCoachPanel() {
        // Implementa il pannello per gestire i coach
        JPanel coachPanel = new JPanel();
        coachPanel.add(new JLabel("Coach Management Panel"));
        mainPanel.add(coachPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void showRecruiterPanel() {
        // Implementa il pannello per gestire i recruiter
        JPanel recruiterPanel = new JPanel();
        recruiterPanel.add(new JLabel("Recruiter Management Panel"));
        mainPanel.add(recruiterPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}
