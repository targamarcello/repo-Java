package Scuole;

public class ScuolaElementare extends Scuola{
    public ScuolaElementare(String codice, String denominazione, String indirizzo, String citta, int numeroStudenti, int numeroClassi, int numeroSediAggiunte, int numeroLaboratori) {
        super(codice, denominazione, indirizzo, citta, numeroStudenti, numeroClassi, numeroSediAggiunte, numeroLaboratori);
    }

    @Override
    double calcoloContributo() {
        return (125*numeroStudenti)+ (9000*numeroSediAggiunte);
    }

    @Override
    public String toString(){
        return super.toString() + String.format(" - Contributo: %.2f",calcoloContributo());
    }

}
