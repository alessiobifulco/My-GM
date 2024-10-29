package model;

import data.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DBModel implements Model {

    private final Connection connection;

    DBModel(Connection connection) {
        Objects.requireNonNull(connection, "Model created with null connection");
        this.connection = connection;
    }

    // Firme di contratti
    public void firmaGiocatore(String dataFirma, int idGiocatore, int idContratto) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.INSERT_FIRMA)) {
            statement.setString(1, dataFirma);
            statement.setInt(2, idGiocatore);
            statement.setInt(3, idContratto);
            statement.executeUpdate();
        }
    }

    public List<Firma> getFirmePerGiocatore(int idGiocatore) throws SQLException {
        List<Firma> firme = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.SELECT_FIRME_PER_GIOCATORE)) {
            statement.setInt(1, idGiocatore);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    firme.add(new Firma(resultSet.getInt("id_firma"), resultSet.getString("data_firma"), idGiocatore,
                            resultSet.getInt("id_contratto")));
                }
            }
        }
        return firme;
    }

    public void aggiornaDataFirma(String dataFirma, int idGiocatore, int idContratto) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_DATA_FIRMA)) {
            statement.setString(1, dataFirma);
            statement.setInt(2, idGiocatore);
            statement.setInt(3, idContratto);
            statement.executeUpdate();
        }
    }

    // Scambi di giocatori
    public void scambiaGiocatori(int idGiocatoreA, int idGiocatoreB, int idSquadraA, int idSquadraB, String dataScambio,
            String dettagli, String stato) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.INSERT_SCAMBIO)) {
            statement.setInt(1, idGiocatoreA);
            statement.setInt(2, idGiocatoreB);
            statement.setInt(3, idSquadraA);
            statement.setInt(4, idSquadraB);
            statement.setString(5, dataScambio);
            statement.setString(6, dettagli);
            statement.setString(7, stato);
            statement.executeUpdate();
        }
    }

    public List<Scambio> getScambiTraSquadre(int idSquadraA, int idSquadraB) throws SQLException {
        List<Scambio> scambi = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.SELECT_SCAMBI_BETWEEN_SQUADRE)) {
            statement.setInt(1, idSquadraA);
            statement.setInt(2, idSquadraB);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    scambi.add(new Scambio(resultSet.getInt("id_scambio"), resultSet.getInt("id_giocatore_a"),
                            resultSet.getInt("id_giocatore_b"), resultSet.getString("data_scambio"),
                            resultSet.getString("dettagli"), resultSet.getString("stato")));
                }
            }
        }
        return scambi;
    }

    public void aggiornaStatoScambio(String stato, int idScambio) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_STATO_SCAMBIO)) {
            statement.setString(1, stato);
            statement.setInt(2, idScambio);
            statement.executeUpdate();
        }
    }

    // Allenamenti
    public void inserisciAllenamento(String nome, String data, String tipo, int idSquadra) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.INSERT_ALLENAMENTO)) {
            statement.setString(1, nome);
            statement.setString(2, data);
            statement.setString(3, tipo);
            statement.setInt(4, idSquadra);
            statement.executeUpdate();
        }
    }

    public List<Allenamento> getAllenamentiPerSquadra(int idSquadra) throws SQLException {
        List<Allenamento> allenamenti = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.SELECT_ALLENAMENTI_PER_SQUADRA)) {
            statement.setInt(1, idSquadra);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    allenamenti.add(new Allenamento(resultSet.getInt("id_allenamento"), resultSet.getString("nome"),
                            resultSet.getString("data"), resultSet.getString("tipo"), idSquadra));
                }
            }
        }
        return allenamenti;
    }

    public void aggiornaTipoAllenamento(String tipo, int idAllenamento) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_TIPO_ALLENAMENTO)) {
            statement.setString(1, tipo);
            statement.setInt(2, idAllenamento);
            statement.executeUpdate();
        }
    }

    // Monitoraggio dei Free Agent
    public List<Giocatore> getFreeAgent() throws SQLException {
        List<Giocatore> freeAgents = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.SELECT_FREE_AGENT);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                freeAgents.add(new Giocatore(resultSet.getInt("id_giocatore"), resultSet.getString("nome"),
                        resultSet.getString("ruolo"), resultSet.getDouble("valutazione"), true));
            }
        }
        return freeAgents;
    }

    public void associaFreeAgent(int idGiocatore, int idSquadra) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_FREE_AGENT)) {
            statement.setInt(1, idSquadra);
            statement.setInt(2, idGiocatore);
            statement.executeUpdate();
        }
    }

    // Query per ottenere free agent in base al ruolo
    public List<Giocatore> getFreeAgentPerRuolo(String ruolo) throws SQLException {
        List<Giocatore> freeAgents = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.SELECT_FREE_AGENT_PER_RUOLO)) {
            statement.setString(1, ruolo);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    freeAgents.add(new Giocatore(resultSet.getInt("id_giocatore"), resultSet.getString("nome"),
                            ruolo, resultSet.getDouble("valutazione"), true));
                }
            }
        }
        return freeAgents;
    }

    public List<Giocatore> getGiocatoriPerSquadra(int idSquadra) throws SQLException {
        List<Giocatore> giocatori = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.SELECT_GIOCATORI_PER_SQUADRA)) {
            statement.setInt(1, idSquadra);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    giocatori.add(new Giocatore(resultSet.getInt("id_giocatore"), resultSet.getString("nome"),
                            resultSet.getString("ruolo"), resultSet.getDouble("valutazione"), false));
                }
            }
        }
        return giocatori;
    }

    // Squadra (solo selezione)
    public Squadra getSquadra(int idSquadra) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.SELECT_SQUADRA)) {
            statement.setInt(1, idSquadra);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Squadra(
                            idSquadra,
                            resultSet.getString("nome"),
                            resultSet.getString("citta"),
                            resultSet.getInt("numero_giocatori"),
                            resultSet.getInt("id_gm"),
                            resultSet.getInt("id_staff"));
                }
            }
        }
        return null;
    }

    // Esercizio
    public void inserisciEsercizio(String nome, String descrizione) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.INSERT_ESERCIZIO)) {
            statement.setString(1, nome);
            statement.setString(2, descrizione);
            statement.executeUpdate();
        }
    }

    public List<Esercizio> getAllEsercizi() throws SQLException {
        List<Esercizio> esercizi = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(Queries.SELECT_ALL_ESERCIZI);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                esercizi.add(new Esercizio(resultSet.getInt("id_esercizio"), resultSet.getString("nome"),
                        resultSet.getString("descrizione")));
            }
        }
        return esercizi;
    }

    public void aggiornaEsercizio(int idEsercizio, String nome, String descrizione) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_ESERCIZIO)) {
            statement.setString(1, nome);
            statement.setString(2, descrizione);
            statement.setInt(3, idEsercizio);
            statement.executeUpdate();
        }
    }

    public void eliminaEsercizio(int idEsercizio) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.DELETE_ESERCIZIO)) {
            statement.setInt(1, idEsercizio);
            statement.executeUpdate();
        }
    }

    @Override
    public boolean verifyGmCredentials(String email, String password) throws SQLException {
        String query = "SELECT COUNT(*) AS count FROM gm WHERE email = ? AND password = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("count") > 0; // Ritorna true se esiste almeno un record con email e
                                                          // password forniti
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Errore durante la verifica delle credenziali del GM", e);
        }

        return false;
    }
}
