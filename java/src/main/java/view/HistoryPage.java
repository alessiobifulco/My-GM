package view;

import core.Controller;

import javax.swing.*;
import java.awt.*;

public class HistoryPage {

    private final JPanel mainPanel;
    private final Controller controller;

    public HistoryPage(JPanel mainPanel, Controller controller) {
        this.mainPanel = mainPanel;
        this.controller = controller;
    }

    public void display() {
        mainPanel.removeAll(); // Rimuove i contenuti attuali

        JPanel historyPanel = new JPanel();
        historyPanel.setLayout(new BorderLayout());

        // Aggiungi i componenti specifici per la cronologia
        historyPanel.add(new JLabel("History Management"), BorderLayout.NORTH);
        // Aggiungi ulteriori componenti qui

        // Aggiungi il pannello historyPanel a mainPanel
        mainPanel.add(historyPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}
