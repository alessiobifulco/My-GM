package data;

public class Scambio {
    private int id_scambio;
    private int id_giocatore_a; // Riferimento al giocatore A
    private int id_giocatore_b; // Riferimento al giocatore B
    private int id_squadra_a; // Riferimento alla squadra A
    private int id_squadra_b; // Riferimento alla squadra B

    // Costruttore
    public Scambio(int id_scambio, int id_giocatore_a, int id_giocatore_b, int id_squadra_a, int id_squadra_b) {
        this.id_scambio = id_scambio;
        this.id_giocatore_a = id_giocatore_a;
        this.id_giocatore_b = id_giocatore_b;
        this.id_squadra_a = id_squadra_a;
        this.id_squadra_b = id_squadra_b;
    }

    // Metodi getter e setter
    public int getIdScambio() { return id_scambio; }
    public void setIdScambio(int id_scambio) { this.id_scambio = id_scambio; }
    public int getIdGiocatoreA() { return id_giocatore_a; }
    public void setIdGiocatoreA(int id_giocatore_a) { this.id_giocatore_a = id_giocatore_a; }
    public int getIdGiocatoreB() { return id_giocatore_b; }
    public void setIdGiocatoreB(int id_giocatore_b) { this.id_giocatore_b = id_giocatore_b; }
    public int getIdSquadraA() { return id_squadra_a; }
    public void setIdSquadraA(int id_squadra_a) { this.id_squadra_a = id_squadra_a; }
    public int getIdSquadraB() { return id_squadra_b; }
    public void setIdSquadraB(int id_squadra_b) { this.id_squadra_b = id_squadra_b; }
}
