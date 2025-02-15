import java.util.Random;

public class Dado {
    private int nFacce;
    private int valfaccia;
    private static Random valLancio;
    public Dado(int nFacce){
        this.nFacce = nFacce;
        valLancio = new Random();
    }

    public int getnFacce() {
        return nFacce;
    }

    public int getValfaccia() {
        return valfaccia;
    }

    public void Lancia(){
        valfaccia = valLancio.nextInt(1,nFacce+1);
    }

}
