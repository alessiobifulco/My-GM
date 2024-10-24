package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public interface Model {

    public static Model fromConnection(Connection connection) {
        return new DBModel(connection);
    }

    void updateOdM();

    // Metodi per gestire le Firme
    void insertFirma(String dataFirma, int idGiocatore, int idContratto) throws SQLException;

    ResultSet getFirmePerGiocatore(int idGiocatore) throws SQLException;

    void updateDataFirma(String dataFirma, int idGiocatore, int idContratto) throws SQLException;

    // Metodi per gestire gli Scambi
    void insertScambio(int idGiocatoreA, int idGiocatoreB, int idSquadraA, int idSquadraB) throws SQLException;

    ResultSet getScambi(int idSquadraA, int idSquadraB) throws SQLException;

    // Metodi per gestire i Giocatori
    void insertGiocatore(String nome, String cognome, int eta, String posizione, int esperienza, int valutazione, int idContratto) throws SQLException;

    ResultSet getGiocatori(int idSquadra) throws SQLException;

    void updateGiocatore(int idGiocatore, String nome, String cognome, int eta, String posizione, int esperienza, int valutazione) throws SQLException;

    // Metodi per gestire gli Allenamenti
    void insertAllenamento(String nome, String data, String tipo, int idSquadra) throws SQLException;

    ResultSet getAllenamenti(int idSquadra) throws SQLException;

    // Metodi per gestire gli Esercizi
    void insertEsercizio(String nome, String descrizione, int difficolta) throws SQLException;

    ResultSet getEsercizi() throws SQLException;
}
