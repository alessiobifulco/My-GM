package data;

public class Squadra {
    private int id_squadra;
    private String nome;
    private String citta;
    private int numero_giocatori;
    private int id_gm;
    private int id_staff;

    // Costruttore
    public Squadra(int id_squadra, String nome, String citta, int numero_giocatori, int id_gm, int id_staff) {
        this.id_squadra = id_squadra;
        this.nome = nome;
        this.citta = citta;
        this.numero_giocatori = numero_giocatori;
        this.id_gm = id_gm;
        this.id_staff = id_staff;
    }

    // Metodi getter e setter
    public int getIdSquadra() { return id_squadra; }
    public void setIdSquadra(int id_squadra) { this.id_squadra = id_squadra; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCitta() { return citta; }
    public void setCitta(String citta) { this.citta = citta; }
    public int getNumeroGiocatori() { return numero_giocatori; }
    public void setNumeroGiocatori(int numero_giocatori) { this.numero_giocatori = numero_giocatori; }
    public int getIdGm() { return id_gm; }
    public void setIdGm(int id_gm) { this.id_gm = id_gm; }
    public int getIdStaff() { return id_staff; }
    public void setIdStaff(int id_staff) { this.id_staff = id_staff; }
}
