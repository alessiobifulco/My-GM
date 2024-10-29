package data;

public class Queries {
    // Query per Firma
    public static final String INSERT_FIRMA = "INSERT INTO firma (data_firma, id_giocatore, id_contratto) VALUES (?, ?, ?)";
    public static final String SELECT_FIRME_PER_GIOCATORE = "SELECT * FROM firma WHERE id_giocatore = ?";
    public static final String UPDATE_DATA_FIRMA = "UPDATE firma SET data_firma = ? WHERE id_giocatore = ? AND id_contratto = ?";

    // Query per Scambio
    public static final String INSERT_SCAMBIO = "INSERT INTO scambio (id_giocatore_a, id_giocatore_b, id_squadra_a, id_squadra_b, data_scambio, dettagli, stato) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String SELECT_SCAMBI_BETWEEN_SQUADRE = "SELECT * FROM scambio WHERE id_squadra_a = ? AND id_squadra_b = ?";
    public static final String UPDATE_STATO_SCAMBIO = "UPDATE scambio SET stato = ? WHERE id_scambio = ?";

    // Query per Allenamento
    public static final String INSERT_ALLENAMENTO = "INSERT INTO allenamento (nome, data, tipo, id_squadra) VALUES (?, ?, ?, ?)";
    public static final String SELECT_ALLENAMENTI_PER_SQUADRA = "SELECT * FROM allenamento WHERE id_squadra = ?";
    public static final String UPDATE_TIPO_ALLENAMENTO = "UPDATE allenamento SET tipo = ? WHERE id_allenamento = ?";

    // Query per Giocatore
    public static final String SELECT_FREE_AGENT = "SELECT * FROM giocatore WHERE freeagent = true";
    public static final String UPDATE_FREE_AGENT = "UPDATE giocatore SET id_squadra = ?, freeagent = false WHERE id_giocatore = ?";
    public static final String SELECT_FREE_AGENT_PER_RUOLO = "SELECT * FROM giocatore WHERE freeagent = true AND ruolo = ?";
    public static final String SELECT_GIOCATORI_PER_SQUADRA = "SELECT * FROM giocatore WHERE id_squadra = ?";

    // Query per aggiungere e rimuovere giocatori
    public static final String INSERT_GIOCATORE = "INSERT INTO giocatore (nome, ruolo, valutazione, freeagent, categoria) VALUES (?, ?, ?, ?, ?)";
    public static final String DELETE_GIOCATORE = "DELETE FROM giocatore WHERE id_giocatore = ?";
    public static final String SELECT_GIOCATORE_BY_ID = "SELECT * FROM giocatore WHERE id_giocatore = ?";
    public static final String UPDATE_VALUTAZIONE_GIOCATORE = "UPDATE giocatore SET valutazione = ? WHERE id_giocatore = ?";

    // Query per Squadra
    public static final String SELECT_SQUADRA = "SELECT nome, citta, numero_giocatori, id_gm, id_staff FROM squadra WHERE id_squadra = ?";

    // Query per aggiungere e rimuovere squadre
    public static final String INSERT_SQUADRA = "INSERT INTO squadra (nome, citta, numero_giocatori, id_gm, id_staff) VALUES (?, ?, ?, ?, ?)";
    public static final String DELETE_SQUADRA = "DELETE FROM squadra WHERE id_squadra = ?";

    // Query per GM
    public static final String INSERT_GM = "INSERT INTO gm (nome, email, password) VALUES (?, ?, ?)";
    public static final String DELETE_GM = "DELETE FROM gm WHERE id_gm = ?";

    // Query per Staff
    public static final String INSERT_STAFF = "INSERT INTO staff (nome, ruolo) VALUES (?, ?)";
    public static final String DELETE_STAFF = "DELETE FROM staff WHERE id_staff = ?";

    // Query per Esercizio
    public static final String INSERT_ESERCIZIO = "INSERT INTO esercizio (nome, descrizione) VALUES (?, ?)";
    public static final String SELECT_ALL_ESERCIZI = "SELECT * FROM esercizio";
    public static final String UPDATE_ESERCIZIO = "UPDATE esercizio SET nome = ?, descrizione = ? WHERE id_esercizio = ?";
    public static final String DELETE_ESERCIZIO = "DELETE FROM esercizio WHERE id_esercizio = ?";
}
