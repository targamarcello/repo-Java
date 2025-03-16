package BackEnd;

public abstract class Partita {
    protected Giocatore g1;
    protected Giocatore g2;
    protected int nRound;
    protected int roundAttuale;

    public Partita(Giocatore g1, Giocatore g2, int nRound) {
        this.g1 = g1;
        this.g2 = g2;
        this.nRound = nRound;
        this.roundAttuale = 0;
    }

    public boolean isFinePartita() {
        return roundAttuale >= nRound;
    }

    public int getnRound() {
        return nRound;
    }

    public abstract void giocaRound();

    public String getWinner() {
        try {
            if (!isFinePartita()) {
                return "La partita è in corso...";
            }
            if (g1.compareTo(g2) > 0) {
                return "Il vincitore della partita è: " + g1.getNome();
            } else if (g2.compareTo(g1) > 0) {
                return "Il vincitore della partita è: " + g2.getNome();
            } else {
                return "La partita è finita in parità";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
