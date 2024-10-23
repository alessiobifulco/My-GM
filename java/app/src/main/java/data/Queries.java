package data;

public final class Queries {
    
    // Firme di Contratti
    public static final String INSERT_FIRMA = 
        """
        INSERT INTO firma (data_firma, id_giocatore, id_contratto)
        VALUES (?, ?, ?);
        """;

    public static final String SELECT_FIRME_PER_GIOCATORE = 
        """
        SELECT * FROM firma
        WHERE id_giocatore = ?;
        """;

    public static final String UPDATE_FIRMA = 
        """
        UPDATE firma
        SET data_firma = ?
        WHERE id_giocatore = ? AND id_contratto = ?;
        """;

    // Scambi di Giocatori
    public static final String INSERT_SCAMBIO = 
        """
        INSERT INTO scambio (id_giocatore_a, id_giocatore_b, id_squadra_a, id_squadra_b, data_scambio, dettagli, stato)
        VALUES (?, ?, ?, ?, ?, ?, ?);
        """;

    public static final String SELECT_SCAMBI_TRA_SQUADRE = 
        """
        SELECT * FROM scambio
        WHERE id_squadra_a = ? AND id_squadra_b = ?;
        """;

    public static final String UPDATE_STATO_SCAMBIO = 
        """
        UPDATE scambio
        SET stato = ?
        WHERE id_scambio = ?;
        """;

    // Svincoli di Giocatori
    public static final String DELETE_GIOCATORE = 
        """
        DELETE FROM giocatore
        WHERE id_giocatore = ?;
        """;

    public static final String INSERT_SVINCOLO = 
        """
        INSERT INTO svincolo (id_giocatore, data_svincolo)
        VALUES (?, ?);
        """;

    // Allenamenti
    public static final String INSERT_ALLENAMENTO = 
        """
        INSERT INTO allenamento (nome, data, tipo, id_squadra)
        VALUES (?, ?, ?, ?);
        """;

    public static final String SELECT_ALLENAMENTI_PER_SQUADRA = 
        """
        SELECT * FROM allenamento
        WHERE id_squadra = ?;
        """;

    public static final String UPDATE_TIPO_ALLENAMENTO = 
        """
        UPDATE allenamento
        SET tipo = ?
        WHERE id_allenamento = ?;
        """;

    // Monitoraggio dei Free Agent
    public static final String SELECT_FREE_AGENT = 
        """
        SELECT * FROM giocatore
        WHERE freeagent = TRUE;
        """;

    public static final String ASSOCIA_FREE_AGENT_A_SQUADRA = 
        """
        UPDATE giocatore
        SET id_squadra = ?, freeagent = FALSE
        WHERE id_giocatore = ?;
        """;
}
