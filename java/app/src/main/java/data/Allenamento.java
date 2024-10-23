package data;

public class Allenamento {
    private int id_allenamento;
    private String nome;
    private String data;
    private String tipo;
    private int id_squadra; // Riferimento alla squadra

    // Costruttore
    public Allenamento(int id_allenamento, String nome, String data, String tipo, int id_squadra) {
        this.id_allenamento = id_allenamento;
        this.nome = nome;
        this.data = data;
        this.tipo = tipo;
        this.id_squadra = id_squadra;
    }

    // Metodi getter e setter
    public int getIdAllenamento() { return id_allenamento; }
    public void setIdAllenamento(int id_allenamento) { this.id_allenamento = id_allenamento; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public int getIdSquadra() { return id_squadra; }
    public void setIdSquadra(int id_squadra) { this.id_squadra = id_squadra; }
}
