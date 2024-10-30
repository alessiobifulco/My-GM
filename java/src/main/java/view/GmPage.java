package view;

import core.Controller;

import javax.swing.*;
import java.awt.*;

public class GmPage {

    private final JFrame frame;
    private final Controller controller;
    private JPanel mainPanel; // Pannello principale per la GM Page

    public GmPage(JFrame frame, Controller controller) {
        this.frame = frame;
        this.controller = controller;
        showGmPage();
    }

    private void showGmPage() {
        // Pulizia della finestra
        frame.getContentPane().removeAll();
        
        // Creazione della GmPage
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        
        // Sezione superiore con i bottoni
        JPanel buttonPanel = new JPanel();
        JButton teamButton = new JButton("Team");
        JButton staffButton = new JButton("Staff");
        JButton rosterButton = new JButton("Roster");
        JButton historyButton = new JButton("View History");

        buttonPanel.add(teamButton);
        buttonPanel.add(staffButton);
        buttonPanel.add(rosterButton);
        buttonPanel.add(historyButton);

        // Aggiungi azioni ai bottoni
        teamButton.addActionListener(e -> showTeamPage());
        staffButton.addActionListener(e -> showStaffPage());
        rosterButton.addActionListener(e -> showRosterPage());
        historyButton.addActionListener(e -> showHistoryPage());

        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    private void showTeamPage() {
        TeamPage teamPage = new TeamPage(mainPanel, controller);
        teamPage.display(); // Mostra il pannello della squadra
    }

    private void showStaffPage() {
        StaffPage staffPage = new StaffPage(mainPanel, controller);
        staffPage.display(); // Mostra il pannello dello staff
    }

    private void showRosterPage() {
        RosterPage rosterPage = new RosterPage(mainPanel, controller);
        rosterPage.display(); // Mostra il pannello del roster
    }

    private void showHistoryPage() {
        HistoryPage historyPage = new HistoryPage(mainPanel, controller);
        historyPage.display(); // Mostra il pannello della storia
    }
}
