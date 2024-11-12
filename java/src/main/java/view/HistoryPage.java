package view;

import core.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HistoryPage {

    private final JPanel mainPanel;
    private final Controller controller;

    public HistoryPage(JPanel mainPanel, Controller controller) {
        this.mainPanel = mainPanel;
        this.controller = controller;
    }

    public void display() {
        mainPanel.removeAll(); // Pulisce il contenuto attuale

        // Pannello principale della pagina History
        JPanel historyPanel = new JPanel(new BorderLayout());
        historyPanel.add(new JLabel("History Management"), BorderLayout.NORTH);

        // Pannello di selezione per tipo di storico
        JPanel selectionPanel = new JPanel();
        JComboBox<String> historyOptions = new JComboBox<>(new String[]{
            "Trade History", "Signing History", "Player History"
        });
        JButton goButton = new JButton("Go");

        // Area di visualizzazione dei risultati
        JTextArea resultArea = new JTextArea(15, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        selectionPanel.add(historyOptions);
        selectionPanel.add(goButton);
        historyPanel.add(selectionPanel, BorderLayout.CENTER);
        historyPanel.add(scrollPane, BorderLayout.SOUTH);

        // Evento pulsante "Go" per mostrare i risultati in base alla selezione
        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) historyOptions.getSelectedItem();
                String resultText = "";

                switch (selectedOption) {
                    case "Trade History":
                        resultText = controller.getTradeHistory();
                        break;
                    case "Signing History":
                        resultText = controller.getSignHistory();
                        break;
                    case "Player History":
                        String playerId = JOptionPane.showInputDialog("Enter Player ID:");
                        if (playerId != null && !playerId.isEmpty()) {
                            resultText = controller.getPlayerHistory(playerId);
                        }
                        break;
                }

                resultArea.setText(resultText);
            }
        });

        mainPanel.add(historyPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
}
