public class Giocatore {
    private String nome;
    private int faccia;
    private int vittorie;
    public Dado dice;
    public Giocatore(String nome, int facce){
        this.nome = nome;
        dice = new Dado(facce);
    }

    public int getVittorie() {
        return vittorie;
    }

    public void setVittorie(int vittorie) {
        this.vittorie = vittorie;
    }

    public String getNome() {
        return nome;
    }

    public int getFaccia() {
        return faccia;
    }
}
