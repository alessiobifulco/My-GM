package model;

import data.DAOException;
import data.Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBModel implements Model {
    private final Connection connection;

    public DBModel(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void updateOdM() {
        
    }

    // Implementazione dei metodi per le Firme
    @Override
    public void insertFirma(String dataFirma, int idGiocatore, int idContratto) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.INSERT_FIRMA)) {
            statement.setString(1, dataFirma);
            statement.setInt(2, idGiocatore);
            statement.setInt(3, idContratto);
            statement.executeUpdate();
        }
    }

    @Override
    public ResultSet getFirmePerGiocatore(int idGiocatore) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.SELECT_FIRME_PER_GIOCATORE);
        statement.setInt(1, idGiocatore);
        return statement.executeQuery();
    }

    @Override
    public void updateDataFirma(String dataFirma, int idGiocatore, int idContratto) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_DATA_FIRMA)) {
            statement.setString(1, dataFirma);
            statement.setInt(2, idGiocatore);
            statement.setInt(3, idContratto);
            statement.executeUpdate();
        }
    }

    // Implementazione dei metodi per gli Scambi
    @Override
    public void insertScambio(int idGiocatoreA, int idGiocatoreB, int idSquadraA, int idSquadraB) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.INSERT_SCAMBIO)) {
            statement.setInt(1, idGiocatoreA);
            statement.setInt(2, idGiocatoreB);
            statement.setInt(3, idSquadraA);
            statement.setInt(4, idSquadraB);
            statement.executeUpdate();
        }
    }

    @Override
    public ResultSet getScambi(int idSquadraA, int idSquadraB) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.SELECT_SCAMBI);
        statement.setInt(1, idSquadraA);
        statement.setInt(2, idSquadraB);
        return statement.executeQuery();
    }

    // Implementazione dei metodi per i Giocatori
    @Override
    public void insertGiocatore(String nome, String cognome, int eta, String posizione, int esperienza, int valutazione, int idContratto) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.INSERT_GIOCATORE)) {
            statement.setString(1, nome);
            statement.setString(2, cognome);
            statement.setInt(3, eta);
            statement.setString(4, posizione);
            statement.setInt(5, esperienza);
            statement.setInt(6, valutazione);
            statement.setInt(7, idContratto);
            statement.executeUpdate();
        }
    }

    @Override
    public ResultSet getGiocatori(int idSquadra) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM giocatore WHERE id_squadra = ?");
        statement.setInt(1, idSquadra);
        return statement.executeQuery();
    }

    @Override
    public void updateGiocatore(int idGiocatore, String nome, String cognome, int eta, String posizione, int esperienza, int valutazione) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE giocatore SET nome = ?, cognome = ?, eta = ?, posizione = ?, esperienza = ?, valutazione = ? WHERE id_giocatore = ?")) {
            statement.setString(1, nome);
            statement.setString(2, cognome);
            statement.setInt(3, eta);
            statement.setString(4, posizione);
            statement.setInt(5, esperienza);
            statement.setInt(6, valutazione);
            statement.setInt(7, idGiocatore);
            statement.executeUpdate();
        }
    }

    // Implementazione dei metodi per gli Allenamenti
    @Override
    public void insertAllenamento(String nome, String data, String tipo, int idSquadra) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.INSERT_ALLENAMENTO)) {
            statement.setString(1, nome);
            statement.setString(2, data);
            statement.setString(3, tipo);
            statement.setInt(4, idSquadra);
            statement.executeUpdate();
        }
    }

    @Override
    public ResultSet getAllenamenti(int idSquadra) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.SELECT_ALLENAMENTI);
        statement.setInt(1, idSquadra);
        return statement.executeQuery();
    }

    // Implementazione dei metodi per gli Esercizi
    @Override
    public void insertEsercizio(String nome, String descrizione, int difficolta) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.INSERT_ESERCIZIO)) {
            statement.setString(1, nome);
            statement.setString(2, descrizione);
            statement.setInt(3, difficolta);
            statement.executeUpdate();
        }
    }

    @Override
    public ResultSet getEsercizi() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.SELECT_ESERCIZI);
        return statement.executeQuery();
    }
}
