package model;

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
        // Implementazione della logica di aggiornamento specifica
    }

    public void insertFirma(String dataFirma, int idGiocatore, int idContratto) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.INSERT_FIRMA)) {
            statement.setString(1, dataFirma);
            statement.setInt(2, idGiocatore);
            statement.setInt(3, idContratto);
            statement.executeUpdate();
        }
    }

    public ResultSet getFirmePerGiocatore(int idGiocatore) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.SELECT_FIRME_PER_GIOCATORE);
        statement.setInt(1, idGiocatore);
        return statement.executeQuery();
    }

    public void updateDataFirma(String dataFirma, int idGiocatore, int idContratto) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.UPDATE_DATA_FIRMA)) {
            statement.setString(1, dataFirma);
            statement.setInt(2, idGiocatore);
            statement.setInt(3, idContratto);
            statement.executeUpdate();
        }
    }

    public void insertScambio(int idGiocatoreA, int idGiocatoreB, int idSquadraA, int idSquadraB, String data, String dettagli, String stato) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(Queries.INSERT_SCAMBIO)) {
            statement.setInt(1, idGiocatoreA);
            statement.setInt(2, idGiocatoreB);
            statement.setInt(3, idSquadraA);
            statement.setInt(4, idSquadraB);
            statement.setString(5, data);
            statement.setString(6, dettagli);
            statement.setString(7, stato);
            statement.executeUpdate();
        }
    }

    public ResultSet getScambi(int idSquadraA, int idSquadraB) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(Queries.SELECT_SCAMBI);
        statement.setInt(1, idSquadraA);
        statement.setInt(2, idSquadraB);
        return statement.executeQuery();
    }
}
