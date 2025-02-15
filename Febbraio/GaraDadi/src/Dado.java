import java.util.Random;

public class Dado {
    private int nFacce;
    private int valFaccia;
    private Random valLancio;
    public Dado(){
        this.nFacce = 6;
        this.valLancio = new Random();
    }
    public void Lancia(){
        this.valFaccia = valLancio.nextInt(nFacce)+1;
    }
    public int getValFaccia(){
        return valFaccia;
    }

}
