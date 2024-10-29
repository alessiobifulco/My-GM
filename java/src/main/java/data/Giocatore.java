package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Giocatore {
    private int id;
    private String nome;
    private String ruolo;
    private double valutazione;
    private boolean isFreeAgent;
    private Categoria categoria; // Aggiungi il campo per la categoria

    // Costruttore
    public Giocatore(int id, String nome, String ruolo, double valutazione, boolean isFreeAgent, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.ruolo = ruolo;
        this.valutazione = valutazione;
        this.isFreeAgent = isFreeAgent;
        this.categoria = categoria; // Inizializza la categoria
    }

    // Getter e Setter
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getRuolo() { return ruolo; }
    public double getValutazione() { return valutazione; }
    public boolean isFreeAgent() { return isFreeAgent; }
    public Categoria getCategoria() { return categoria; } // Getter per la categoria

    public void setNome(String nome) { this.nome = nome; }
    public void setRuolo(String ruolo) { this.ruolo = ruolo; }
    public void setValutazione(double valutazione) { this.valutazione = valutazione; }
    public void setFreeAgent(boolean freeAgent) { isFreeAgent = freeAgent; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; } // Setter per la categoria

    // Metodi DAO per Giocatore

    // Ottieni giocatore per ID
    public static Giocatore getGiocatore(Connection connection, int idGiocatore) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.SELECT_GIOCATORE_BY_ID)) {
            statement.setInt(1, idGiocatore);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Estrai la categoria dal risultato
                    Categoria categoria = Categoria.valueOf(resultSet.getString("categoria").toUpperCase());
                    return new Giocatore(
                        idGiocatore,
                        resultSet.getString("nome"),
                        resultSet.getString("ruolo"),
                        resultSet.getDouble("valutazione"),
                        resultSet.getBoolean("freeagent"),
                        categoria // Passa la categoria al costruttore
                    );
                }
            }
        }
        return null;
    }

    // Ottieni tutti i giocatori di una squadra
    public static List<Giocatore> getGiocatoriPerSquadra(Connection connection, int idSquadra) throws SQLException {
        List<Giocatore> giocatori = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.SELECT_GIOCATORI_PER_SQUADRA)) {
            statement.setInt(1, idSquadra);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    // Estrai la categoria dal risultato
                    Categoria categoria = Categoria.valueOf(resultSet.getString("categoria").toUpperCase());
                    giocatori.add(new Giocatore(
                        resultSet.getInt("id_giocatore"),
                        resultSet.getString("nome"),
                        resultSet.getString("ruolo"),
                        resultSet.getDouble("valutazione"),
                        resultSet.getBoolean("freeagent"),
                        categoria // Passa la categoria al costruttore
                    ));
                }
            }
        }
        return giocatori;
    }

    // Aggiorna valutazione del giocatore
    public static void aggiornaValutazioneGiocatore(Connection connection, int idGiocatore, double nuovaValutazione) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_VALUTAZIONE_GIOCATORE)) {
            statement.setDouble(1, nuovaValutazione);
            statement.setInt(2, idGiocatore);
            statement.executeUpdate();
        }
    }

    // Ottieni tutti i Free Agent
    public static List<Giocatore> getFreeAgent(Connection connection) throws SQLException {
        List<Giocatore> freeAgents = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.SELECT_FREE_AGENT);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                // Estrai la categoria dal risultato (se necessario, altrimenti imposta un valore di default)
                Categoria categoria = Categoria.valueOf(resultSet.getString("categoria").toUpperCase());
                freeAgents.add(new Giocatore(
                    resultSet.getInt("id_giocatore"),
                    resultSet.getString("nome"),
                    resultSet.getString("ruolo"),
                    resultSet.getDouble("valutazione"),
                    true,
                    categoria // Passa la categoria al costruttore
                ));
            }
        }
        return freeAgents;
    }
}
