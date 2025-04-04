package BackEnd;

import java.util.Random;

public class Dado implements Comparable<Dado>{
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

    @Override
    public int compareTo(Dado dado2){
        return Integer.compare(this.valFaccia,dado2.getValFaccia());
    }
}
