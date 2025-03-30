package Scuole;

public class ScuolaElementare extends Scuola{
    private static final double CONTRIBUTO_STUDENTE = 125;
    private static final double CONTRIBUTO_SEDE = 9000;

    public ScuolaElementare(String codice, String denominazione, String indirizzo, String citta, int numeroStudenti, int numeroClassi, int numeroSediAggiunte, int numeroLaboratori) {
        super(codice, denominazione, indirizzo, citta, numeroStudenti, numeroClassi, numeroSediAggiunte, numeroLaboratori);
    }

    @Override
    double calcoloContributo() {
        return (CONTRIBUTO_STUDENTE*numeroStudenti)+ (CONTRIBUTO_SEDE*numeroSediAggiunte);
    }

    @Override
    public String toString(){
        return super.toString() + String.format(" - Contributo: %.2f",calcoloContributo());
    }

}
