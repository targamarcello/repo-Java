package BackEnd;

public class PartitaBase extends Partita{
    public PartitaBase(Giocatore g1, Giocatore g2, int nRound) {
        super(g1, g2, nRound);
    }

    @Override
    public void giocaRound(){
        if(isFinePartita()) return;
        int lancio1 = g1.lanciaDado();
        int lancio2 = g2.lanciaDado();
        if(lancio1 > lancio2){
            g1.incrementaVittorie();
        }else if(lancio2 > lancio1){
            g2.incrementaVittorie();
        }
        roundAttuale++;
    }
}
