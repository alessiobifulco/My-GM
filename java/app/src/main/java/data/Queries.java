package data;

public final class Queries {

    // Query per Firme di Contratti
    public static final String INSERT_FIRMA =
        "INSERT INTO firma (data_firma, id_giocatore, id_contratto) VALUES (?, ?, ?)";
    
    public static final String SELECT_FIRME_PER_GIOCATORE =
        "SELECT * FROM firma WHERE id_giocatore = ?";

    public static final String UPDATE_DATA_FIRMA =
        "UPDATE firma SET data_firma = ? WHERE id_giocatore = ? AND id_contratto = ?";

    // Query per Scambi di Giocatori
    public static final String INSERT_SCAMBIO =
        "INSERT INTO scambio (id_giocatore_a, id_giocatore_b, id_squadra_a, id_squadra_b) VALUES (?, ?, ?, ?)";
    
    public static final String SELECT_SCAMBI =
        "SELECT * FROM scambio WHERE id_squadra_a = ? AND id_squadra_b = ?";

    public static final String UPDATE_STATO_SCAMBIO =
        "UPDATE scambio SET stato = ? WHERE id_scambio = ?";

    // Query per Giocatori
    public static final String INSERT_GIOCATORE =
        "INSERT INTO giocatore (nome, cognome, eta, posizione, esperienza, valutazione, id_contratto) VALUES (?, ?, ?, ?, ?, ?, ?)";
    
    public static final String SELECT_GIOCATORI =
        "SELECT * FROM giocatore WHERE id_squadra = ?";

    public static final String UPDATE_GIOCATORE =
        "UPDATE giocatore SET nome = ?, cognome = ?, eta = ?, posizione = ?, esperienza = ?, valutazione = ? WHERE id_giocatore = ?";

    // Query per Allenamenti
    public static final String INSERT_ALLENAMENTO =
        "INSERT INTO allenamento (nome, data, tipo, id_squadra) VALUES (?, ?, ?, ?)";
    
    public static final String SELECT_ALLENAMENTI =
        "SELECT * FROM allenamento WHERE id_squadra = ?";

    public static final String UPDATE_TIPO_ALLENAMENTO =
        "UPDATE allenamento SET tipo = ? WHERE id_allenamento = ?";

    // Query per Esercizi
    public static final String INSERT_ESERCIZIO =
        "INSERT INTO esercizio (nome, descrizione, difficolta) VALUES (?, ?, ?)";
    
    public static final String SELECT_ESERCIZI =
        "SELECT * FROM esercizio";

    // Query per Svincoli di Giocatori
    public static final String DELETE_GIOCATORE =
        "DELETE FROM giocatore WHERE id_giocatore = ?";
    
    public static final String INSERT_SVINCOLO =
        "INSERT INTO svincolo (id_giocatore, data_svincolo) VALUES (?, ?)";

    // Altre query (aggiungere secondo necessità)
    public static final String UPDATE_ODM =
        "UPDATE odm SET ..."; // Definisci qui la tua logica di aggiornamento

    public static final String SELECT_FREE_AGENTS =
        "SELECT * FROM giocatore WHERE freeagent = TRUE";
    
    public static final String ASSOCIA_FREE_AGENT =
        "UPDATE giocatore SET id_squadra = ?, freeagent = FALSE WHERE id_giocatore = ?";
}
