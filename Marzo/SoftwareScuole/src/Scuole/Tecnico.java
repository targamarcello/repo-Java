package Scuole;

public class Tecnico extends ScuolaSuperiore{
    private static final double CONTRIBUTO_CLASSE = 3500;
    private static final double CONTRIBUTO_LABORATORIO = 6000;

    public Tecnico(String codice, String denominazione, String indirizzo, String citta, int numeroStudenti, int numeroClassi, int numeroSediAggiunte, int numeroLaboratori) {
        super(codice, denominazione, indirizzo, citta, numeroStudenti, numeroClassi, numeroSediAggiunte, numeroLaboratori);
    }

    @Override
    public double calcoloContributo(){
        return (CONTRIBUTO_CLASSE*numeroClassi) + (CONTRIBUTO_LABORATORIO*numeroLaboratori);
    }
    @Override
    public String toString(){
        return super.toString() + String.format(" - Contributo: %.2f",calcoloContributo());
    }
}