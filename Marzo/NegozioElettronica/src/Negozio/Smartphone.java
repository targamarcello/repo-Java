package Negozio;

public class Smartphone extends ProdottoElettronico{
    private String modello;
    private int memoria;

    public Smartphone(double prezzo, String marca, String codice, String modello, int memoria) {
        super(prezzo, marca, codice);
        this.modello = modello;
        if(memoria <=0){
            throw new IllegalArgumentException("Le memoria deve essere positiva...");
        }
        this.memoria = memoria;
    }

    public String getModello() {
        return modello;
    }

    public int getMemoria() {
        return memoria;
    }

    @Override
    public String toString(){
        return super.toString() + String.format(" - Modello: %s - Memoria: %d",modello,memoria);
    }

}
