package view;

import core.Controller;

import javax.swing.*;
import java.awt.*;

public class RosterPage {

    private final JPanel mainPanel;
    private final Controller controller;

    public RosterPage(JPanel mainPanel, Controller controller) {
        this.mainPanel = mainPanel;
        this.controller = controller;
    }

    public void display() {
        mainPanel.removeAll(); // Rimuove i contenuti attuali

        JPanel rosterPanel = new JPanel();
        rosterPanel.setLayout(new BorderLayout());

        // Aggiungi i componenti specifici per il roster
        rosterPanel.add(new JLabel("Roster Management"), BorderLayout.NORTH);
        // Aggiungi ulteriori componenti qui

        // Aggiungi il pannello rosterPanel a mainPanel
        mainPanel.add(rosterPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}
