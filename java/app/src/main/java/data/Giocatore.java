package data;

public class Giocatore {
    private int id_giocatore;
    private String nome;
    private String cognome;
    private int eta;
    private String posizione;
    private int esperienza;
    private double valutazione;

    // Costruttore
    public Giocatore(int id_giocatore, String nome, String cognome, int eta, String posizione, int esperienza, double valutazione) {
        this.id_giocatore = id_giocatore;
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.posizione = posizione;
        this.esperienza = esperienza;
        this.valutazione = valutazione;
    }

    // Metodi getter e setter
    public int getIdGiocatore() { return id_giocatore; }
    public void setIdGiocatore(int id_giocatore) { this.id_giocatore = id_giocatore; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCognome() { return cognome; }
    public void setCognome(String cognome) { this.cognome = cognome; }
    public int getEta() { return eta; }
    public void setEta(int eta) { this.eta = eta; }
    public String getPosizione() { return posizione; }
    public void setPosizione(String posizione) { this.posizione = posizione; }
    public int getEsperienza() { return esperienza; }
    public void setEsperienza(int esperienza) { this.esperienza = esperienza; }
    public double getValutazione() { return valutazione; }
    public void setValutazione(double valutazione) { this.valutazione = valutazione; }
}
