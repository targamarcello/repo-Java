package BackEnd;

import BackEnd.Dado;

public class Giocatore implements Comparable<Giocatore>{
    private String nome;
    private int vittorie;
    private Dado dice;
    public Giocatore(String nome){
        this.nome = nome;
        this.vittorie = 0;
        this.dice = new Dado();
    }

    public String getNome() throws Exception {
        if(this.nome == null){
            throw new RuntimeException("GIOCATORE NON CREATO!!!");
        }
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

    @Override
    public int compareTo(Giocatore playerExtra){
        return Integer.compare(this.vittorie, playerExtra.getVittorie());
    }


}
