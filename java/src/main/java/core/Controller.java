package core;

import java.sql.SQLException;
import java.util.List;

import data.Sign;
import data.Trade;

public class Controller {

    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void homePage() {
        view.showHomePage();
    }

    public void showLoginPage() {
        view.showLoginPage();
    }

    public boolean authenticateGm(String email, String password) {
        boolean isAuthenticated = false;

        try {
            isAuthenticated = model.verifyGmCredentials(email, password);

            if (isAuthenticated) {
                view.showGmPage(); // Se autenticato, mostra la pagina GM
            } else {
                view.showErrorMessage("Email o password non corretti."); // Messaggio di errore
            }
        } catch (SQLException e) {
            view.showErrorMessage("Si è verificato un errore durante la verifica delle credenziali: " + e.getMessage());
            e.printStackTrace(); // Stampa lo stack trace per il debug
        }

        return isAuthenticated;
    }

    public String getTradeHistory() {
        try {
            List<Trade> trades = model.getAllTrades(); // Ottieni tutte le transazioni di scambio
            StringBuilder result = new StringBuilder();
            for (Trade trade : trades) {
                result.append("Trade ID: ").append(trade.getIdTrade())
                        .append(" | Date: ").append(trade.getTradeDate())
                        .append(" | Details: ").append(trade.getDetails())
                        .append(" | Status: ").append(trade.getStatus())
                        .append("\n");
            }
            return result.toString();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error retrieving trade history.";
        }
    }

    public String getSignHistory() {
        try {
            List<Sign> signs = model.getAllSigns(); // Ottieni tutte le firme
            StringBuilder result = new StringBuilder();
            for (Sign sign : signs) {
                result.append("Signing Date: ").append(sign.getSignDate())
                        .append(" | Player ID: ").append(sign.getPlayerId())
                        .append(" | Contract ID: ").append(sign.getContractId())
                        .append("\n");
            }
            return result.toString();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error retrieving sign history.";
        }
    }

    public String getPlayerHistory(String playerId) {
        try {
            List<Sign> playerSigns = model.getSigningsForPlayer(Integer.parseInt(playerId)); // Ottieni le firme per il
                                                                                             // giocatore
            List<Trade> playerTrades = model.getTradesBetweenTeams(Integer.parseInt(playerId),
                    Integer.parseInt(playerId)); // Scambi per il giocatore
            StringBuilder result = new StringBuilder();

            result.append("Player ID: ").append(playerId).append("\n");

            if (playerSigns.isEmpty() && playerTrades.isEmpty()) {
                result.append("No history found for player.");
            }

            for (Sign sign : playerSigns) {
                result.append("Signing Date: ").append(sign.getSignDate())
                        .append(" | Contract ID: ").append(sign.getContractId())
                        .append("\n");
            }

            for (Trade trade : playerTrades) {
                result.append("Trade Date: ").append(trade.getTradeDate())
                        .append(" | Details: ").append(trade.getDetails())
                        .append(" | Status: ").append(trade.getStatus())
                        .append("\n");
            }

            return result.toString();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error retrieving player history.";
        }
    }
}
