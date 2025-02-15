public class Giocatore {
    private String nome;
    private int vittorie;
    private Dado dice;
    public Giocatore(String nome){
        this.nome = nome;
        this.vittorie = 0;
        this.dice = new Dado();
    }

    public String getNome() {
        return nome;
    }

    public int getVittorie() {
        return vittorie;
    }
    public void incrementaVittorie(){
        this.vittorie++;
    }
    public int lanciaDado(){
        dice.Lancia();
        return dice.getValFaccia();
    }

}
