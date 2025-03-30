package Scuole;

public class ScuolaMedia extends Scuola{

    private static final double CONTRIBUTO_STUDENTE = 150;
    private static final double CONTRIBUTO_LABORATORIO = 1100;
    private static final double CONTRIBUTO_SEDE = 9000;

    public ScuolaMedia(String codice, String denominazione, String indirizzo, String citta, int numeroStudenti, int numeroClassi, int numeroSediAggiunte, int numeroLaboratori) {
        super(codice, denominazione, indirizzo, citta, numeroStudenti, numeroClassi, numeroSediAggiunte, numeroLaboratori);
    }

    @Override
    double calcoloContributo() {
        return (CONTRIBUTO_STUDENTE*numeroStudenti) + (CONTRIBUTO_LABORATORIO*numeroLaboratori)+(CONTRIBUTO_SEDE*numeroSediAggiunte);
    }
    @Override
    public String toString(){
        return super.toString() + String.format(" - Contributo: %.2f",calcoloContributo());
    }
}
