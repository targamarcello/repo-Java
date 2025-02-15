public class Gara {
    private Giocatore g1;
    private Giocatore g2;
    private int nRound;
    private int roundAttuale;

    public Gara(Giocatore g1, Giocatore g2, int nRound) {
        this.g1 = g1;
        this.g2 = g2;
        this.nRound = nRound;
        this.roundAttuale = 0;
    }
    public boolean isFineGara(){
        return roundAttuale >= nRound;
    }
    public String getWinner(){
        if(!isFineGara()){
            return "La partita è in corso...";
        }
        if(g1.getVittorie()>g2.getVittorie()){
            return "Il vincitore del round è: "+g1.getNome();
        }else if(g2.getVittorie()>g1.getVittorie()){
            return "Il vincitore del round è: "+g2.getNome();
        }else{
            return "La gara è finita in parità";
        }
    }
    public void round(){
        if(isFineGara()){
            System.out.println("La gara è terminata");
            return;
        }
        int lancio1 = g1.lanciaDado();
        int lancio2  = g2.lanciaDado();
        System.out.println(g1.getNome() + " ha lanciato: "+lancio1);
        System.out.println(g2.getNome() + " ha lanciato: "+lancio2);
        if(lancio1>lancio2){
            g1.incrementaVittorie();
            System.out.println(g1.getNome() + " ha vinto il round!");
        }else if(lancio2>lancio1){
            g2.incrementaVittorie();
            System.out.println(g2.getNome() + " ha vinto il round!");
        }else{
            g1.incrementaVittorie();
            g2.incrementaVittorie();
            System.out.println("Round finito in parità");
        }
        roundAttuale++;
        if(isFineGara()) {
            System.out.println(getWinner());
        }
    }
    public void resetGame(){
        roundAttuale = 0;
    }
}
