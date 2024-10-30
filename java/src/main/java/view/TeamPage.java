package view;

import core.Controller;

import javax.swing.*;
import java.awt.*;

public class TeamPage {

    private final JPanel mainPanel;
    private final Controller controller;

    public TeamPage(JPanel mainPanel, Controller controller) {
        this.mainPanel = mainPanel;
        this.controller = controller;
    }

    public void display() {
        mainPanel.removeAll(); // Rimuove i contenuti attuali

        JPanel teamPanel = new JPanel();
        teamPanel.setLayout(new BorderLayout());

        // Aggiungi i componenti specifici per il team
        teamPanel.add(new JLabel("Team Management"), BorderLayout.NORTH);
        JButton tradeButton = new JButton("Trade Player");
        JButton signButton = new JButton("Sign Player");
        JButton fireButton = new JButton("Fire Player");

        tradeButton.addActionListener(e -> showTradePlayerPanel());
        signButton.addActionListener(e -> showSignPlayerPanel());
        fireButton.addActionListener(e -> showFirePlayerPanel());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(tradeButton);
        buttonPanel.add(signButton);
        buttonPanel.add(fireButton);
        
        teamPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Aggiungi il pannello teamPanel a mainPanel
        mainPanel.add(teamPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void showTradePlayerPanel() {
        // Implementa il pannello per il trading dei giocatori
        JPanel tradePanel = new JPanel();
        tradePanel.add(new JLabel("Trade Player Panel"));
        mainPanel.add(tradePanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void showSignPlayerPanel() {
        // Implementa il pannello per firmare un giocatore
        JPanel signPanel = new JPanel();
        signPanel.add(new JLabel("Sign Player Panel"));
        mainPanel.add(signPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void showFirePlayerPanel() {
        // Implementa il pannello per licenziare un giocatore
        JPanel firePanel = new JPanel();
        firePanel.add(new JLabel("Fire Player Panel"));
        mainPanel.add(firePanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}
