package data;

public class Sottoscrizione {
    private int id_sottoscrizione;
    private int id_contratto; // Riferimento al contratto
    private String data_sottoscrizione; // Data di sottoscrizione

    // Costruttore
    public Sottoscrizione(int id_sottoscrizione, int id_contratto, String data_sottoscrizione) {
        this.id_sottoscrizione = id_sottoscrizione;
        this.id_contratto = id_contratto;
        this.data_sottoscrizione = data_sottoscrizione;
    }

    // Metodi getter e setter
    public int getIdSottoscrizione() { return id_sottoscrizione; }
    public void setIdSottoscrizione(int id_sottoscrizione) { this.id_sottoscrizione = id_sottoscrizione; }
    public int getIdContratto() { return id_contratto; }
    public void setIdContratto(int id_contratto) { this.id_contratto = id_contratto; }
    public String getDataSottoscrizione() { return data_sottoscrizione; }
    public void setDataSottoscrizione(String data_sottoscrizione) { this.data_sottoscrizione = data_sottoscrizione; }
}
