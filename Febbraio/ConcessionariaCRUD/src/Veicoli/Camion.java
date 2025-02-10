package Veicoli;

public class Camion extends Veicolo{
    private float capacitaCartico;
    private int numeroAssi;

    public Camion(String marca, String modello, int prezzo, float capacitaCartico, int numeroAssi) {
        super(marca, modello, prezzo);
        this.capacitaCartico = capacitaCartico;
        this.numeroAssi = numeroAssi;
    }

    public float getCapacitaCartico() {
        return capacitaCartico;
    }

    public int getNumeroAssi() {
        return numeroAssi;
    }
    @Override
    public String toString(){
        return super.toString() + "- Capacità: "+capacitaCartico+ "- Numero Assi: "+numeroAssi;
    }
    public double calcoloPesoTot(){
        double pesoAsse = 10;
        return capacitaCartico + (numeroAssi*pesoAsse);
    }
}
