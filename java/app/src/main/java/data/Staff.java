package data;

public class Staff {
    private int id_staff;
    private String nome;
    private String ruolo;
    private String email;

    // Costruttore
    public Staff(int id_staff, String nome, String ruolo, String email) {
        this.id_staff = id_staff;
        this.nome = nome;
        this.ruolo = ruolo;
        this.email = email;
    }

    // Metodi getter e setter
    public int getIdStaff() { return id_staff; }
    public void setIdStaff(int id_staff) { this.id_staff = id_staff; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getRuolo() { return ruolo; }
    public void setRuolo(String ruolo) { this.ruolo = ruolo; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
