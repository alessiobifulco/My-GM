package data;

public class Firma {
    private String data_firma; // Data della firma
    private int id_giocatore;  // Riferimento al giocatore
    private int id_contratto;  // Riferimento al contratto

    // Costruttore
    public Firma(String data_firma, int id_giocatore, int id_contratto) {
        this.data_firma = data_firma;
        this.id_giocatore = id_giocatore;
        this.id_contratto = id_contratto;
    }

    // Metodi getter e setter
    public String getDataFirma() { return data_firma; }
    public void setDataFirma(String data_firma) { this.data_firma = data_firma; }
    public int getIdGiocatore() { return id_giocatore; }
    public void setIdGiocatore(int id_giocatore) { this.id_giocatore = id_giocatore; }
    public int getIdContratto() { return id_contratto; }
    public void setIdContratto(int id_contratto) { this.id_contratto = id_contratto; }
}
