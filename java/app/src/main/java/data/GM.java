package data;

public class GM {
    private int id_gm;          // Identificatore del GM
    private String nome;        // Nome del GM
    private String cognome;     // Cognome del GM
    private String email;       // Email del GM (deve essere unica)
    private String password;     // Password del GM
    private int id_squadra;     // Identificatore della squadra (deve essere unica)

    // Costruttore
    public GM(int id_gm, String nome, String cognome, String email, String password, int id_squadra) {
        this.id_gm = id_gm;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.id_squadra = id_squadra;
    }

    // Metodi getter e setter
    public int getIdGm() {
        return id_gm;
    }

    public void setIdGm(int id_gm) {
        this.id_gm = id_gm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdSquadra() {
        return id_squadra;
    }

    public void setIdSquadra(int id_squadra) {
        this.id_squadra = id_squadra;
    }
}
