package core;

import data.*;
import model.DBModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Model {

    // Factory Method per creare un'istanza di DBModel con una connessione al
    // database
    public static Model fromConnection(Connection connection) {
        return new DBModel(connection);
    }

    // Firme di contratti
    void firmaGiocatore(String dataFirma, int idGiocatore, int idContratto) throws SQLException;

    List<Firma> getFirmePerGiocatore(int idGiocatore) throws SQLException;

    void aggiornaDataFirma(String dataFirma, int idGiocatore, int idContratto) throws SQLException;

    // Scambi di giocatori
    void scambiaGiocatori(int idGiocatoreA, int idGiocatoreB, int idSquadraA, int idSquadraB,
            String dataScambio, String dettagli, String stato) throws SQLException;

    List<Scambio> getScambiTraSquadre(int idSquadraA, int idSquadraB) throws SQLException;

    void aggiornaStatoScambio(String stato, int idScambio) throws SQLException;

    // Allenamenti
    void inserisciAllenamento(String nome, String data, String tipo, int idSquadra) throws SQLException;

    List<Allenamento> getAllenamentiPerSquadra(int idSquadra) throws SQLException;

    void aggiornaTipoAllenamento(String tipo, int idAllenamento) throws SQLException;

    // Monitoraggio dei Free Agent
    List<Giocatore> getFreeAgent() throws SQLException;

    void associaFreeAgent(int idGiocatore, int idSquadra) throws SQLException;

    List<Giocatore> getFreeAgentPerRuolo(String ruolo) throws SQLException;

    List<Giocatore> getGiocatoriPerSquadra(int idSquadra) throws SQLException;

    // Squadra (solo selezione)
    Squadra getSquadra(int idSquadra) throws SQLException;

    // Esercizio
    void inserisciEsercizio(String nome, String descrizione) throws SQLException;

    List<Esercizio> getAllEsercizi() throws SQLException;

    void aggiornaEsercizio(int idEsercizio, String nome, String descrizione) throws SQLException;

    void eliminaEsercizio(int idEsercizio) throws SQLException;

    // Firma per la verifica credenziali GM
    boolean verifyGmCredentials(String email, String password) throws SQLException;
}
