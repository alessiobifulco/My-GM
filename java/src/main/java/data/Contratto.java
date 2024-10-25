package data;

public class Contratto {
    private int id_contratto;
    private int durata;         // Durata in mesi o anni
    private double stipendio;   // Stipendio del giocatore
    private String clausola;     // Clausola del contratto
    private String stato;       // Stato del contratto
    private String dataContratto; // Data di inizio del contratto

    // Costruttore
    public Contratto(int id_contratto, int durata, double stipendio, String clausola, String stato, String dataContratto) {
        this.id_contratto = id_contratto;
        this.durata = durata;
        this.stipendio = stipendio;
        this.clausola = clausola;
        this.stato = stato;
        this.dataContratto = dataContratto;
    }

    // Metodi getter e setter
    public int getIdContratto() { return id_contratto; }
    public void setIdContratto(int id_contratto) { this.id_contratto = id_contratto; }
    public int getDurata() { return durata; }
    public void setDurata(int durata) { this.durata = durata; }
    public double getStipendio() { return stipendio; }
    public void setStipendio(double stipendio) { this.stipendio = stipendio; }
    public String getClausola() { return clausola; }
    public void setClausola(String clausola) { this.clausola = clausola; }
    public String getStato() { return stato; }
    public void setStato(String stato) { this.stato = stato; }
    public String getDataContratto() { return dataContratto; }
    public void setDataContratto(String dataContratto) { this.dataContratto = dataContratto; }
}
