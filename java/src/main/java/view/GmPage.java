package view;

import core.*;

import javax.swing.*;
import java.awt.*;

public class GmPage {

    public GmPage(JFrame frame) {
        showGmPage(frame);
    }

    private void showGmPage(JFrame frame) {
        // Pulizia della finestra
        frame.getContentPane().removeAll();

        // Creazione della GmPage
        JPanel gmPanel = new JPanel();
        gmPanel.setLayout(new GridBagLayout());
        JLabel welcomeLabel = new JLabel("Benvenuto nella Gm Page!");
        JButton teamButton = new JButton("Team");
        JButton staffButton = new JButton("Staff");
        JButton rosterButton = new JButton("Roster");

        gmPanel.add(welcomeLabel);
        gmPanel.add(teamButton);
        gmPanel.add(staffButton);
        gmPanel.add(rosterButton);

        frame.add(gmPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }
}
