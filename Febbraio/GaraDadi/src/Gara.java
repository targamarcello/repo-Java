import java.util.Scanner;

public class Gara  {

    private int nRound;
    private int reset;
    private Giocatore g1;
    private Giocatore g2;

    public Gara(int n,String n1,String n2, int facce){
        g1 = new Giocatore(n1,facce);
        g2 = new Giocatore(n2,facce);
        nRound = n;
        reset = nRound;
    }
    public boolean FineGara(){
        //proprietà utilizzata per determinare il fine della gara
        if(nRound == 0){
            return true;
        }
        else{
            return false;
        }
    }



    public String Winner(){
        /*ritorna il nome del vincitore, lo stato di parità o lo stato
        della partita se in corso*/
        g1.dice.Lancia();
        g2.dice.Lancia();
        if(g1.dice.getValfaccia() > g2.dice.getValfaccia()){
            //incremento delle vittorie di g1
            nRound--;
            return String.format("Il vincitore del round è: %s",g1.getNome());
        }else if(g1.dice.getValfaccia()<g2.dice.getValfaccia()){
            //incremento vincite di g2
            nRound--;
            return String.format("Il vincitore del round è: %s",g2.getNome());
        }else{
            nRound--;
            return String.format("Pareggio tra %s e %s",g1.getNome(), g2.getNome());
        }
    }
    public void Round(){
        //esegue un round della partita


    }
    public String GameWin(){
        /*se la partita è finita determina il vincitore o la
         condizione di parità*/
        if(g1.getVittorie() > g2.getVittorie()){
            return String.format("Il vincitore della gara è %s",g1.getNome());
        }else if(g1.getVittorie()<g2.getVittorie()){
            return String.format("Il vincitore della gara è %s",g2.getNome());
        }else{
            return String.format("La gara è finita in parità");
        }
    }
    public void ResetGame(){
        //resetta la partita
        nRound = reset;
        g1.setVittorie(0);
        g2.setVittorie(0);
    }
}