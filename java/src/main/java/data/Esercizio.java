package data;

public class Esercizio {
    private int id_esercizio;
    private String nome;
    private String descrizione;
    private String difficolta;

    // Costruttore
    public Esercizio(int id_esercizio, String nome, String descrizione, String difficolta) {
        this.id_esercizio = id_esercizio;
        this.nome = nome;
        this.descrizione = descrizione;
        this.difficolta = difficolta;
    }

    // Metodi getter e setter
    public int getIdEsercizio() { return id_esercizio; }
    public void setIdEsercizio(int id_esercizio) { this.id_esercizio = id_esercizio; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescrizione() { return descrizione; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }
    public String getDifficolta() { return difficolta; }
    public void setDifficolta(String difficolta) { this.difficolta = difficolta; }
}
