package BackEnd;

public class PartitaAvanzata extends Partita{
    private int winStreakG1 = 0;
    private int winStreakG2 = 0;

    public PartitaAvanzata(Giocatore g1, Giocatore g2, int nRound) {
        super(g1, g2, nRound);
    }

    @Override
    public void giocaRound(){
        if(isFinePartita())return;
        int lancio1 = g1.lanciaDado();
        int lancio2 = g2.lanciaDado();
        if(lancio1 > lancio2){
            g1.incrementaVittorie();
            winStreakG1++;
            winStreakG2 = 0;
            if(winStreakG1==3){
                g1.incrementaVittorie();
                winStreakG1=0;
            }
        }else if(lancio2 > lancio1){
            g2.incrementaVittorie();
            winStreakG2++;
            winStreakG1 = 0;
            if(winStreakG2==3){
                g2.incrementaVittorie();
                winStreakG2=0;
            }
        }else{
            winStreakG1=0;
            winStreakG2=0;
        }
        roundAttuale++;
    }
}
