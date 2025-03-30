package Scuole;

public class Liceo extends ScuolaSuperiore{
    private static final double CONTRIBUTO_STUDENTE = 150;
    private static final double CONTRIBUTO_LABORATORIO = 1100;

    public Liceo(String codice, String denominazione, String indirizzo, String citta, int numeroStudenti, int numeroClassi, int numeroSediAggiunte, int numeroLaboratori) {
        super(codice, denominazione, indirizzo, citta, numeroStudenti, numeroClassi, numeroSediAggiunte, numeroLaboratori);
    }

    @Override
    public double calcoloContributo(){
        return (CONTRIBUTO_STUDENTE*numeroStudenti) + (CONTRIBUTO_LABORATORIO*numeroLaboratori);
    }
    @Override
    public String toString(){
        return super.toString() + String.format(" - Contributo: %.2f",calcoloContributo());
    }
}